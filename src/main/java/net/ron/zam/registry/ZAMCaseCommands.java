package net.ron.zam.registry;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.SharedSuggestionProvider;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.arguments.IdentifierArgument;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.permissions.Permissions;
import net.minecraft.world.item.ItemStack;
import net.ron.zam.common.advancement.CaseAdvancementTrigger;
import net.ron.zam.common.data.ZAMSavedData;
import net.ron.zam.common.gui.cases.CaseMenu;
import net.ron.zam.util.casesystem.CaseCompletion;
import net.ron.zam.util.casesystem.CaseEntry;
import net.ron.zam.util.casesystem.CaseRewards;

import java.util.Collection;
import java.util.List;

public final class ZAMCaseCommands {
    private static final DynamicCommandExceptionType UNKNOWN_CASE = new DynamicCommandExceptionType(id -> Component.translatable("commands.zam.case.unknown", id));
    private static final DynamicCommandExceptionType UNKNOWN_ITEM = new DynamicCommandExceptionType(id -> Component.translatable("commands.zam.case.unknown_item", id));

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        var caseCommands = Commands.literal("case")
                .requires(source -> source.permissions().hasPermission(Permissions.COMMANDS_GAMEMASTER))
                .then(action("grant", true))
                .then(action("revoke", false))
                .then(completeShortcut());
        dispatcher.register(Commands.literal("zam").then(caseCommands));
    }

    private static LiteralArgumentBuilder<CommandSourceStack> completeShortcut() {
        var players = Commands.argument("players", EntityArgument.players())
                .executes(context -> change(context.getSource(), EntityArgument.getPlayers(context, "players"),
                        List.of(caseFrom(context)), null, true));
        var selectedCase = Commands.argument("case", IdentifierArgument.id())
                .suggests((context, builder) -> SharedSuggestionProvider.suggestResource(CaseRewards.ids(), builder))
                .executes(context -> change(context.getSource(), List.of(context.getSource().getPlayerOrException()),
                        List.of(caseFrom(context)), null, true))
                .then(players);
        return Commands.literal("complete").then(selectedCase);
    }

    private static LiteralArgumentBuilder<CommandSourceStack> action(String name, boolean grant) {
        var item = Commands.argument("item", IdentifierArgument.id())
                .suggests((context, builder) -> SharedSuggestionProvider.suggestResource(rewardIds(caseFrom(context)), builder))
                .executes(context -> change(context.getSource(), EntityArgument.getPlayers(context, "players"),
                        List.of(caseFrom(context)), IdentifierArgument.getId(context, "item"), grant));
        var selectedCase = Commands.argument("case", IdentifierArgument.id())
                .suggests((context, builder) -> SharedSuggestionProvider.suggestResource(CaseRewards.ids(), builder))
                .executes(context -> change(context.getSource(), EntityArgument.getPlayers(context, "players"),
                        List.of(caseFrom(context)), null, grant))
                .then(item);
        var everything = Commands.literal("everything").executes(context -> change(context.getSource(),
                EntityArgument.getPlayers(context, "players"), allCases(), null, grant));
        var players = Commands.argument("players", EntityArgument.players())
                .then(everything)
                .then(Commands.literal("only").then(selectedCase));
        return Commands.literal(name).then(players);
    }

    private static CaseEntry caseFrom(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        Identifier id = IdentifierArgument.getId(context, "case");
        return CaseRewards.getById(id).orElseThrow(() -> UNKNOWN_CASE.create(id));
    }

    private static List<CaseEntry> allCases() {
        return CaseRewards.ids().stream().map(id -> CaseRewards.getById(id).orElseThrow()).toList();
    }

    private static List<Identifier> rewardIds(CaseEntry entry) {
        return entry.possibleRewards().stream().flatMap(reward -> reward.viewRewardPool().stream())
                .map(CaseCompletion::collectionItem).map(BuiltInRegistries.ITEM::getKey).distinct().toList();
    }

    private static int change(CommandSourceStack source, Collection<ServerPlayer> players, List<CaseEntry> cases, Identifier itemId, boolean grant) throws CommandSyntaxException {
        if (itemId != null && (cases.size() != 1 || !rewardIds(cases.getFirst()).contains(itemId))) {
            throw UNKNOWN_ITEM.create(itemId);
        }
        for (ServerPlayer player : players) {
            for (CaseEntry entry : cases) {
                updateProgress(player, entry, itemId, grant);
            }
            if (player.containerMenu instanceof CaseMenu menu) menu.refreshCollection();
        }
        sendResult(source, players, cases, itemId, grant);
        return players.size();
    }

    private static void updateProgress(ServerPlayer player, CaseEntry entry, Identifier itemId, boolean grant) {
        if (grant && itemId == null) {
            CaseCompletion.finish(player, entry);
        } else {
            for (var reward : entry.possibleRewards()) {
                for (ItemStack stack : reward.viewRewardPool()) {
                    var item = CaseCompletion.collectionItem(stack);
                    if (itemId == null || BuiltInRegistries.ITEM.getKey(item).equals(itemId)) {
                        ZAMSavedData.setCollected(player.level().getServer(), player, item);
                    }
                }
            }
            if (!grant) ZAMSavedData.revokeCase(player.level().getServer(), player, entry.id());
        }
        boolean unlocked = CaseCompletion.isUnlocked(player, entry);
        if (grant && unlocked) ZAMCriteriaTriggers.CASE.triggerCompletion(player, entry.id());
        if (!grant) revokeAdvancements(player, entry, itemId, unlocked);
    }

    private static void sendResult(CommandSourceStack source, Collection<ServerPlayer> players, List<CaseEntry> cases, Identifier itemId, boolean grant) {
        Component target = players.size() == 1 ? players.iterator().next().getDisplayName()
                : Component.translatable("commands.zam.case.players", players.size());
        Component scope = cases.size() == 1
                ? new ItemStack(BuiltInRegistries.ITEM.getValue(cases.getFirst().id())).getHoverName()
                : Component.translatable("commands.zam.case.all");
        if (itemId == null) {
            source.sendSuccess(() -> Component.translatable(grant ? "commands.zam.case.completed" : "commands.zam.case.revoked",
                    scope, target), true);
        } else {
            Component item = new ItemStack(BuiltInRegistries.ITEM.getValue(itemId)).getHoverName();
            source.sendSuccess(() -> Component.translatable(grant ? "commands.zam.case.item_granted" : "commands.zam.case.item_revoked",
                    item, scope, target), true);
        }
    }

    private static void revokeAdvancements(ServerPlayer player, CaseEntry entry, Identifier itemId, boolean unlocked) {
        for (var advancement : player.level().getServer().getAdvancements().getAllAdvancements()) {
            for (var criterion : advancement.value().criteria().entrySet()) {
                if (!(criterion.getValue().triggerInstance() instanceof CaseAdvancementTrigger.TriggerInstance trigger) || trigger.id().isEmpty() || !trigger.id().get().equals(entry.id())) continue;
                boolean revoke = itemId == null || !unlocked && trigger.completed().orElse(false) || trigger.item().isPresent() && trigger.item().get().test(new ItemStack(BuiltInRegistries.ITEM.getValue(itemId)));
                if (revoke) player.getAdvancements().revoke(advancement, criterion.getKey());
            }
        }
    }
}

package net.ron.zam.common.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;
import net.ron.zam.util.casesystem.CaseRewards;
import net.ron.zam.util.casesystem.gui.CaseMenuProvider;

import java.util.function.Consumer;

public class CaseItem extends Item {
    public CaseItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        if (player instanceof ServerPlayer serverPlayer) {
            var caseId = BuiltInRegistries.ITEM.getKey(this);
            var entry = CaseRewards.getById(caseId).orElse(null);
            if (entry == null) return InteractionResult.FAIL;

            serverPlayer.openMenu(new CaseMenuProvider(entry, Component.translatable(getDescriptionId())));
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay display, Consumer<Component> consumer, TooltipFlag flag) {
        super.appendHoverText(stack, context, display, consumer, flag);
        consumer.accept(Component.translatable(getDescriptionId() + ".collection")
                .withStyle(ChatFormatting.DARK_PURPLE, ChatFormatting.ITALIC));
        appendDropRates(consumer);
    }

    protected void appendDropRates(Consumer<Component> consumer) {
        consumer.accept(Component.literal("Drop Rates:").withStyle(ChatFormatting.YELLOW));
        consumer.accept(Component.literal(" - Common: 75%").withStyle(ChatFormatting.GRAY));
        consumer.accept(Component.literal(" - Uncommon: 12%").withStyle(ChatFormatting.GREEN));
        consumer.accept(Component.literal(" - Rare: 8%").withStyle(ChatFormatting.BLUE));
        consumer.accept(Component.literal(" - Epic: 4%").withStyle(ChatFormatting.LIGHT_PURPLE));
        consumer.accept(Component.literal(" - Legendary: 1%").withStyle(ChatFormatting.GOLD));
    }
}
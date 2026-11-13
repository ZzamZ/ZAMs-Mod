package net.ron.zam.common.packet;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Prediction;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.JukeboxPlayable;
import net.ron.zam.ZAMMod;
import net.ron.zam.common.component.CosmeticPatternComponent;
import net.ron.zam.common.data.ZAMSavedData;
import net.ron.zam.common.gui.cases.CaseMenu;
import net.ron.zam.registry.ZAMComponents;
import net.ron.zam.registry.ZAMCriteriaTriggers;
import net.ron.zam.util.casesystem.CaseCompletion;
import net.ron.zam.util.casesystem.CaseEntry;
import net.ron.zam.util.casesystem.rarity.Rarity;

public record ClaimRewardPacket(int choiceIndex) implements CustomPacketPayload {
    public static final Type<ClaimRewardPacket> TYPE = new Type<>(ZAMMod.id("claim_reward"));
    public static final StreamCodec<RegistryFriendlyByteBuf, ClaimRewardPacket> STREAM_CODEC =
            StreamCodec.composite(ByteBufCodecs.VAR_INT, ClaimRewardPacket::choiceIndex, ClaimRewardPacket::new);

    @Override
    public Type<ClaimRewardPacket> type() {
        return TYPE;
    }

    public static void handle(ClaimRewardPacket packet, ServerPlayNetworking.Context context) {
        ServerPlayer player = context.player();
        if (!(player.containerMenu instanceof CaseMenu menu)) return;

        var authorized = menu.claimAuthorizedReward(packet.choiceIndex());
        if (authorized == null || authorized.stack().isEmpty()) return;

        ItemStack reward = authorized.stack();
        CaseEntry entry = authorized.caseEntry();
        Rarity rarity = authorized.rarity();
        var server = player.level().getServer();

        giveReward(player, reward);

        ZAMSavedData data = ZAMSavedData.get(server);
        data.collectReward(player, reward);
        data.claimSlot(player, entry, authorized.slotIndex());
        boolean completed = CaseCompletion.isUnlocked(player, entry);

        Component caseTitle = new ItemStack(BuiltInRegistries.ITEM.getValue(entry.id())).getHoverName();
        server.getPlayerList().broadcastSystemMessage(createAnnouncement(player, reward, rarity, caseTitle), false);
        ZAMCriteriaTriggers.CASE.trigger(player, reward, entry.id(), rarity, completed);
        player.closeContainer();
    }

    private static void giveReward(ServerPlayer player, ItemStack reward) {
        ItemStack remaining = reward.copy();
        player.getInventory().add(remaining);

        if (!remaining.isEmpty()) {
            ItemEntity dropped = player.drop(remaining, false, Prediction.SERVER_ONLY);
            if (dropped != null) {
                dropped.setNoPickUpDelay();
                dropped.setTarget(player.getUUID());
            }
        }

        player.inventoryMenu.broadcastChanges();
    }

    private static Component createAnnouncement(ServerPlayer player, ItemStack reward, Rarity rarity, Component caseTitle) {
        int rewardColor = rarity.getColor() & 0xFFFFFF;
        return Component.empty()
                .append(player.getDisplayName().copy().withColor(0x55FF55))
                .append(Component.literal(" opened a [").withColor(0xADD8E6))
                .append(caseTitle.copy().withColor(0x90EE90))
                .append(Component.literal("] and received [").withColor(0xADD8E6))
                .append(rewardName(reward).copy().withColor(rewardColor))
                .append(Component.literal("]").withColor(rewardColor));
    }

    private static Component rewardName(ItemStack stack) {
        CosmeticPatternComponent pattern = stack.get(ZAMComponents.COSMETIC_PATTERN);
        if (pattern != null) return Component.literal(pattern.displayName());

        JukeboxPlayable playable = stack.get(DataComponents.JUKEBOX_PLAYABLE);
        return playable == null ? stack.getHoverName() : playable.song().value().description();
    }
}
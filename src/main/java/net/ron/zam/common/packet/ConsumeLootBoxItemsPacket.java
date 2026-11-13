package net.ron.zam.common.packet;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.ron.zam.ZAMMod;
import net.ron.zam.common.gui.cases.CaseMenu;
import net.ron.zam.registry.ZAMStats;

public record ConsumeLootBoxItemsPacket() implements CustomPacketPayload {
    public static final Type<ConsumeLootBoxItemsPacket> TYPE = new Type<>(ZAMMod.id("consume_lootbox_items"));
    public static final StreamCodec<RegistryFriendlyByteBuf, ConsumeLootBoxItemsPacket> STREAM_CODEC = StreamCodec.unit(new ConsumeLootBoxItemsPacket());

    @Override
    public Type<ConsumeLootBoxItemsPacket> type() {
        return TYPE;
    }

    public static void handle(ConsumeLootBoxItemsPacket packet, ServerPlayNetworking.Context context) {
        ServerPlayer player = context.player();
        if (!(player.containerMenu instanceof CaseMenu menu)) return;

        int rewardIndex = menu.openCase(player, player.getRandom());
        if (rewardIndex >= 0) {
            player.awardStat(ZAMStats.CASES_OPENED, 1);
            player.inventoryMenu.broadcastChanges();
        }

        ServerPlayNetworking.send(player, new CaseRollResultPacket(rewardIndex));
    }
}

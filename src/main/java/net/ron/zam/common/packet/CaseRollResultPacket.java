package net.ron.zam.common.packet;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.ron.zam.ZAMMod;

public record CaseRollResultPacket(int rewardIndex) implements CustomPacketPayload {
    public static final Type<CaseRollResultPacket> TYPE = new Type<>(ZAMMod.id("case_roll_result"));
    public static final StreamCodec<RegistryFriendlyByteBuf, CaseRollResultPacket> STREAM_CODEC =
            StreamCodec.composite(ByteBufCodecs.VAR_INT, CaseRollResultPacket::rewardIndex, CaseRollResultPacket::new);

    @Override
    public Type<CaseRollResultPacket> type() {
        return TYPE;
    }
}

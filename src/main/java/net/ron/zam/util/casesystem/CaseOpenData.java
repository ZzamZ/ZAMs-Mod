package net.ron.zam.util.casesystem;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.Identifier;

public record CaseOpenData(Identifier caseId) {
    public static final StreamCodec<RegistryFriendlyByteBuf, CaseOpenData> STREAM_CODEC =
            StreamCodec.composite(Identifier.STREAM_CODEC, CaseOpenData::caseId, CaseOpenData::new);
}

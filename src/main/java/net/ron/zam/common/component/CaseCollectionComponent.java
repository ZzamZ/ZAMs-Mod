package net.ron.zam.common.component;

import com.mojang.serialization.Codec;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

import java.util.List;

public record CaseCollectionComponent(List<Boolean> collected) {
    public static final Codec<CaseCollectionComponent> CODEC = Codec.BOOL.listOf().xmap(CaseCollectionComponent::new, CaseCollectionComponent::collected);
    public static final StreamCodec<ByteBuf, CaseCollectionComponent> STREAM_CODEC = ByteBufCodecs.BOOL.apply(ByteBufCodecs.list()).map(CaseCollectionComponent::new,
            CaseCollectionComponent::collected);

    public CaseCollectionComponent {
        collected = List.copyOf(collected);
    }
}

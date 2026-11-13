package net.ron.zam.registry;

import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.ron.zam.ZAMMod;
import net.ron.zam.common.component.*;

import java.util.function.UnaryOperator;

public class ZAMComponents {
    public static final DataComponentType<AppliedCosmeticComponent> APPLIED_COSMETIC = register(
            "cosmetic_skin", builder -> builder.persistent(AppliedCosmeticComponent.CODEC)
                    .networkSynchronized(AppliedCosmeticComponent.STREAM_CODEC).cacheEncoding());

    public static final DataComponentType<CosmeticPatternComponent> COSMETIC_PATTERN = register(
            "cosmetic_pattern", builder -> builder.persistent(CosmeticPatternComponent.CODEC)
                    .networkSynchronized(CosmeticPatternComponent.STREAM_CODEC).cacheEncoding());

    public static final DataComponentType<CaseCollectionComponent> CASE_COLLECTION = register(
            "case_collection", builder -> builder.persistent(CaseCollectionComponent.CODEC).networkSynchronized(
                    CaseCollectionComponent.STREAM_CODEC).cacheEncoding());

    public static final DataComponentType<PausedComponent> PAUSED = register("paused",
            builder -> builder.persistent(PausedComponent.CODEC).networkSynchronized(
                    PausedComponent.STREAM_CODEC).cacheEncoding());

    public static final DataComponentType<PlayingRecordComponent> PLAYING_RECORD = register(
            "playing_record", builder -> builder.persistent(PlayingRecordComponent.CODEC).networkSynchronized(
                    PlayingRecordComponent.STREAM_CODEC).cacheEncoding());

    public static final DataComponentType<LoopingComponent> LOOPING = register("looping",
            builder -> builder.persistent(LoopingComponent.CODEC).networkSynchronized(
                    LoopingComponent.STREAM_CODEC).cacheEncoding());

    private static <T> DataComponentType<T> register(String name, UnaryOperator<DataComponentType.Builder<T>> configure) {
        return Registry.register(BuiltInRegistries.DATA_COMPONENT_TYPE, ZAMMod.id(name),
                configure.apply(DataComponentType.<T>builder()).build());
    }

    public static void registerDataComponents() {
        ZAMMod.LOGGER.info("Registering data components for {}", ZAMMod.MOD_ID);
    }
}
package net.ron.zam.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.trim.TrimPattern;
import net.ron.zam.ZAMMod;

public class ZAMTrimPatterns {
    public static final ResourceKey<TrimPattern> CREST = ResourceKey.create(Registries.TRIM_PATTERN, ZAMMod.id("crest"));
    public static final ResourceKey<TrimPattern> DWELLER = ResourceKey.create(Registries.TRIM_PATTERN, ZAMMod.id("dweller"));
    public static final ResourceKey<TrimPattern> FROSTY = ResourceKey.create(Registries.TRIM_PATTERN, ZAMMod.id("frosty"));

    public static void bootstrap(BootstrapContext<TrimPattern> context) {
        context.register(CREST, new TrimPattern(CREST.identifier(), Component.translatable("trim_pattern.zam.crest"), false));
        context.register(DWELLER, new TrimPattern(DWELLER.identifier(), Component.translatable("trim_pattern.zam.dweller"), false));
        context.register(FROSTY, new TrimPattern(FROSTY.identifier(), Component.translatable("trim_pattern.zam.frosty"), false));
    }
}

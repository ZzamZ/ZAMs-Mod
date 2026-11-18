package net.ron.zam.registry;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.stats.StatFormatter;
import net.minecraft.stats.Stats;
import net.ron.zam.ZAMMod;

public final class ZAMStats {
    public static final Identifier CASES_OPENED = ZAMMod.id("cases_opened");

    public static void registerStats() {
        Registry.register(BuiltInRegistries.CUSTOM_STAT, CASES_OPENED, CASES_OPENED);
        Stats.CUSTOM.get(CASES_OPENED, StatFormatter.DEFAULT);
        ZAMMod.LOGGER.info("Registering Stats for {}", ZAMMod.MOD_ID);
    }
}
package net.ron.zam.registry;

import net.minecraft.advancements.triggers.CriterionTrigger;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.ron.zam.ZAMMod;
import net.ron.zam.common.advancement.CaseAdvancementTrigger;

public final class ZAMCriteriaTriggers {
    public static final CaseAdvancementTrigger CASE = register("case", new CaseAdvancementTrigger());

    private ZAMCriteriaTriggers() {}

    public static <T extends CriterionTrigger<?>> T register(String name, T trigger) {
        return Registry.register(BuiltInRegistries.TRIGGER_TYPES, ZAMMod.id(name), trigger);
    }

    public static void registerCriteriaTriggers() {
        ZAMMod.LOGGER.info("Registering Criteria Triggers for {}", ZAMMod.MOD_ID);
    }
}
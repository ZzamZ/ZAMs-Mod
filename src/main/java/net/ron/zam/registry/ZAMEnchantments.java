package net.ron.zam.registry;

import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.item.enchantment.Enchantment;
import net.ron.zam.ZAMMod;

public class ZAMEnchantments {
    public static final ResourceKey<Enchantment> REELING = ResourceKey.create(Registries.ENCHANTMENT, ZAMMod.id("reeling"));
    public static final ResourceKey<Enchantment> DOUBLE_CATCH = ResourceKey.create(Registries.ENCHANTMENT, ZAMMod.id("double_catch"));

    public static void bootstrap(BootstrapContext<Enchantment> context) {
        var items = context.lookup(Registries.ITEM);
        var enchantments = context.lookup(Registries.ENCHANTMENT);
        var fishingRods = items.getOrThrow(ItemTags.FISHING_ENCHANTABLE);

        context.register(REELING, Enchantment.enchantment(Enchantment.definition(fishingRods, 2, 1, Enchantment.constantCost(15), Enchantment.constantCost(50), 4,
                EquipmentSlotGroup.HAND)).exclusiveWith(HolderSet.direct(enchantments.getOrThrow(DOUBLE_CATCH))).build(REELING.identifier()));

        context.register(DOUBLE_CATCH, Enchantment.enchantment(Enchantment.definition(fishingRods, 2, 3, Enchantment.dynamicCost(15, 10), Enchantment.dynamicCost(50, 10), 4,
                        EquipmentSlotGroup.HAND)).exclusiveWith(HolderSet.direct(enchantments.getOrThrow(REELING))).build(DOUBLE_CATCH.identifier()));
    }
}

package net.ron.zam.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.world.item.enchantment.Enchantment;
import net.ron.zam.registry.ZAMEnchantments;

import java.util.concurrent.CompletableFuture;

public class ZAMEnchantmentTagProvider extends FabricTagsProvider<Enchantment> {
    public ZAMEnchantmentTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, Registries.ENCHANTMENT, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        builder(EnchantmentTags.TREASURE)
                .add(ZAMEnchantments.REELING)
                .add(ZAMEnchantments.DOUBLE_CATCH);
    }
}
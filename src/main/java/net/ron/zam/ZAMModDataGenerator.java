package net.ron.zam;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.ron.zam.datagen.*;
import net.ron.zam.registry.ZAMEnchantments;
import net.ron.zam.registry.ZAMJukeboxSongs;
import net.ron.zam.registry.ZAMTrimPatterns;
import net.ron.zam.registry.ZAMWolfVariants;

public class ZAMModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ZAMRegistryDataProvider::new);
		pack.addProvider(ZAMModelProvider::new);
		pack.addProvider(ZAMEnchantmentTagProvider::new);
		pack.addProvider(ZAMRecipeProvider::new);
		pack.addProvider(ZAMItemTagProvider::new);
		pack.addProvider(ZAMBlockTagProvider::new);
	}

	@Override
	public void buildRegistry(RegistrySetBuilder registryBuilder) {
		registryBuilder.add(Registries.ENCHANTMENT, ZAMEnchantments::bootstrap);
		registryBuilder.add(Registries.JUKEBOX_SONG, ZAMJukeboxSongs::bootstrap);
		registryBuilder.add(Registries.TRIM_PATTERN, ZAMTrimPatterns::bootstrap);
		registryBuilder.add(Registries.WOLF_VARIANT, ZAMWolfVariants::bootstrap);
	}
}

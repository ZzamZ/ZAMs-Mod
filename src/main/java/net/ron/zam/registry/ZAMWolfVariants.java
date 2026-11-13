package net.ron.zam.registry;

import net.minecraft.core.ClientAsset;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.animal.wolf.WolfVariant;
import net.minecraft.world.entity.variant.BiomeCheck;
import net.minecraft.world.entity.variant.SpawnPrioritySelectors;
import net.minecraft.world.level.biome.Biomes;
import net.ron.zam.ZAMMod;

public class ZAMWolfVariants {
    public static final ResourceKey<WolfVariant> HONEY = ResourceKey.create(Registries.WOLF_VARIANT, ZAMMod.id("honey"));

    public static void bootstrap(BootstrapContext<WolfVariant> context) {
        var biomes = context.lookup(Registries.BIOME);
        var spawnConditions = SpawnPrioritySelectors.single(new BiomeCheck(HolderSet.direct(biomes.getOrThrow(Biomes.DAPPLED_FOREST))), 1);

        context.register(HONEY, new WolfVariant(
                textures("wolf_honey", "wolf_honey_tame", "wolf_honey_angry"),
                textures("wolf_shaya_baby", "wolf_shaya_tame_baby", "wolf_shaya_angry_baby"), spawnConditions));
    }

    private static WolfVariant.AssetInfo textures(String wild, String tame, String angry) {
        return new WolfVariant.AssetInfo(texture(wild), texture(tame), texture(angry));
    }

    private static ClientAsset.ResourceTexture texture(String name) {
        return new ClientAsset.ResourceTexture(ZAMMod.id("entity/wolf/" + name));
    }
}

package net.ron.zam.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.advancements.Advancement;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SmithingTrimRecipeBuilder;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.block.Blocks;
import net.ron.zam.ZAMMod;
import net.ron.zam.registry.ZAMBlocks;
import net.ron.zam.registry.ZAMItems;
import net.ron.zam.registry.ZAMTags;
import net.ron.zam.registry.ZAMTrimPatterns;

import java.util.concurrent.CompletableFuture;

public class ZAMRecipeProvider extends FabricRecipeProvider {
    public ZAMRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, BootstrapContext<Recipe<?>> recipes, BootstrapContext<Advancement> recipeOutput) {
        return new RecipeProvider(recipes, recipeOutput) {
            @Override
            public void buildRecipes() {

                trimSmithing(ZAMItems.CREST_ARMOR_TRIM_SMITHING_TEMPLATE, ZAMTrimPatterns.CREST, ResourceKey.create(Registries.RECIPE, ZAMMod.id("crest_smithing_trim")));
                trimSmithing(ZAMItems.DWELLER_ARMOR_TRIM_SMITHING_TEMPLATE, ZAMTrimPatterns.DWELLER, ResourceKey.create(Registries.RECIPE, ZAMMod.id("dweller_smithing_trim")));
                trimSmithing(ZAMItems.FROSTY_ARMOR_TRIM_SMITHING_TEMPLATE, ZAMTrimPatterns.FROSTY, ResourceKey.create(Registries.RECIPE, ZAMMod.id("frosty_smithing_trim")));

                shapeless(RecipeCategory.MISC, ZAMItems.CASE_KEY)
                        .requires(Items.DIAMOND)
                        .requires(Items.GOLD_NUGGET)
                        .unlockedBy("has_case", has(ZAMTags.CASES)).save(output);

                shaped(RecipeCategory.MISC, ZAMBlocks.OAK_RECORD_RACK)
                        .group("zam:record_rack")
                        .pattern("SSS")
                        .pattern("WWW")
                        .define('S', Items.STICK)
                        .define('W', Blocks.OAK_PLANKS)
                        .unlockedBy("has_record_for_oak_record_rack", has(ConventionalItemTags.MUSIC_DISCS)).save(output);

                shaped(RecipeCategory.MISC, ZAMBlocks.SPRUCE_RECORD_RACK)
                        .group("zam:record_rack")
                        .pattern("SSS")
                        .pattern("WWW")
                        .define('S', Items.STICK)
                        .define('W', Blocks.SPRUCE_PLANKS)
                        .unlockedBy("has_record_for_spruce_record_rack", has(ConventionalItemTags.MUSIC_DISCS)).save(output);

                shaped(RecipeCategory.MISC, ZAMBlocks.BIRCH_RECORD_RACK)
                        .group("zam:record_rack")
                        .pattern("SSS")
                        .pattern("WWW")
                        .define('S', Items.STICK)
                        .define('W', Blocks.BIRCH_PLANKS)
                        .unlockedBy("has_record_for_birch_record_rack", has(ConventionalItemTags.MUSIC_DISCS)).save(output);

                shaped(RecipeCategory.MISC, ZAMBlocks.JUNGLE_RECORD_RACK)
                        .group("zam:record_rack")
                        .pattern("SSS")
                        .pattern("WWW")
                        .define('S', Items.STICK)
                        .define('W', Blocks.JUNGLE_PLANKS)
                        .unlockedBy("has_record_for_jungle_record_rack", has(ConventionalItemTags.MUSIC_DISCS)).save(output);

                shaped(RecipeCategory.MISC, ZAMBlocks.ACACIA_RECORD_RACK)
                        .group("zam:record_rack")
                        .pattern("SSS")
                        .pattern("WWW")
                        .define('S', Items.STICK)
                        .define('W', Blocks.ACACIA_PLANKS)
                        .unlockedBy("has_record_for_acacia_record_rack", has(ConventionalItemTags.MUSIC_DISCS)).save(output);

                shaped(RecipeCategory.MISC, ZAMBlocks.DARK_OAK_RECORD_RACK)
                        .group("zam:record_rack")
                        .pattern("SSS")
                        .pattern("WWW")
                        .define('S', Items.STICK)
                        .define('W', Blocks.DARK_OAK_PLANKS)
                        .unlockedBy("has_record_for_dark_oak_record_rack", has(ConventionalItemTags.MUSIC_DISCS)).save(output);

                shaped(RecipeCategory.MISC, ZAMBlocks.MANGROVE_RECORD_RACK)
                        .group("zam:record_rack")
                        .pattern("SSS")
                        .pattern("WWW")
                        .define('S', Items.STICK)
                        .define('W', Blocks.MANGROVE_PLANKS)
                        .unlockedBy("has_record_for_mangrove_record_rack", has(ConventionalItemTags.MUSIC_DISCS)).save(output);

                shaped(RecipeCategory.MISC, ZAMBlocks.CHERRY_RECORD_RACK)
                        .group("zam:record_rack")
                        .pattern("SSS")
                        .pattern("WWW")
                        .define('S', Items.STICK)
                        .define('W', Blocks.CHERRY_PLANKS)
                        .unlockedBy("has_record_for_cherry_record_rack", has(ConventionalItemTags.MUSIC_DISCS)).save(output);

                shaped(RecipeCategory.MISC, ZAMBlocks.PALE_OAK_RECORD_RACK)
                        .group("zam:record_rack")
                        .pattern("SSS")
                        .pattern("WWW")
                        .define('S', Items.STICK)
                        .define('W', Blocks.PALE_OAK_PLANKS)
                        .unlockedBy("has_record_for_pale_oak_record_rack", has(ConventionalItemTags.MUSIC_DISCS)).save(output);

                shaped(RecipeCategory.MISC, ZAMBlocks.BAMBOO_RECORD_RACK)
                        .group("zam:record_rack")
                        .pattern("SSS")
                        .pattern("WWW")
                        .define('S', Items.STICK)
                        .define('W', Blocks.BAMBOO_PLANKS)
                        .unlockedBy("has_record_for_bamboo_record_rack", has(ConventionalItemTags.MUSIC_DISCS)).save(output);

                shaped(RecipeCategory.MISC, ZAMBlocks.CRIMSON_RECORD_RACK)
                        .group("zam:record_rack")
                        .pattern("SSS")
                        .pattern("WWW")
                        .define('S', Items.STICK)
                        .define('W', Blocks.CRIMSON_PLANKS)
                        .unlockedBy("has_record_for_crimson_record_rack", has(ConventionalItemTags.MUSIC_DISCS)).save(output);

                shaped(RecipeCategory.MISC, ZAMBlocks.WARPED_RECORD_RACK)
                        .group("zam:record_rack")
                        .pattern("SSS")
                        .pattern("WWW")
                        .define('S', Items.STICK)
                        .define('W', Blocks.WARPED_PLANKS)
                        .unlockedBy("has_record_for_warped_record_rack", has(ConventionalItemTags.MUSIC_DISCS)).save(output);

                shaped(RecipeCategory.MISC, ZAMBlocks.POPLAR_RECORD_RACK)
                        .group("zam:record_rack")
                        .pattern("SSS")
                        .pattern("WWW")
                        .define('S', Items.STICK)
                        .define('W', Blocks.POPLAR_PLANKS)
                        .unlockedBy("has_record_for_poplar_record_rack", has(ConventionalItemTags.MUSIC_DISCS)).save(output);

                shaped(RecipeCategory.MISC, ZAMItems.RECORD_SLEEVE)
                        .pattern("PPP")
                        .pattern("PEP")
                        .pattern("PPP")
                        .define('P', Items.PAPER)
                        .define('E', Items.EMERALD)
                        .unlockedBy("has_record_for_record_sleeve", has(ConventionalItemTags.MUSIC_DISCS)).save(output);

                shaped(RecipeCategory.MISC, ZAMItems.MUSIC_BOX)
                        .pattern("  G")
                        .pattern("RDE")
                        .pattern("PPP")
                        .define('P', ItemTags.PLANKS)
                        .define('R', Items.REPEATER)
                        .define('D', Items.DIAMOND)
                        .define('E', Items.ECHO_SHARD)
                        .define('G', Items.GOLD_INGOT)
                        .unlockedBy("has_record_for_music_box", has(ConventionalItemTags.MUSIC_DISCS)).save(output);

                shaped(RecipeCategory.MISC, ZAMItems.CREST_ARMOR_TRIM_SMITHING_TEMPLATE, 2)
                        .pattern("DCD")
                        .pattern("DPD")
                        .pattern("DDD")
                        .define('D', Items.DIAMOND)
                        .define('C', ZAMItems.CREST_ARMOR_TRIM_SMITHING_TEMPLATE)
                        .define('P', ZAMItems.SEA_JELLY)
                        .unlockedBy("has_crest_template", has(ZAMItems.CREST_ARMOR_TRIM_SMITHING_TEMPLATE)).save(output);

                shaped(RecipeCategory.MISC, ZAMItems.DWELLER_ARMOR_TRIM_SMITHING_TEMPLATE, 2)
                        .pattern("DdD")
                        .pattern("DSD")
                        .pattern("DDD")
                        .define('D', Items.DIAMOND)
                        .define('d', ZAMItems.DWELLER_ARMOR_TRIM_SMITHING_TEMPLATE)
                        .define('S', Items.STONE)
                        .unlockedBy("has_dweller_template", has(ZAMItems.DWELLER_ARMOR_TRIM_SMITHING_TEMPLATE)).save(output);

                shaped(RecipeCategory.MISC, ZAMItems.FROSTY_ARMOR_TRIM_SMITHING_TEMPLATE, 2)
                        .pattern("DFD")
                        .pattern("DSD")
                        .pattern("DDD")
                        .define('D', Items.DIAMOND)
                        .define('F', ZAMItems.FROSTY_ARMOR_TRIM_SMITHING_TEMPLATE)
                        .define('S', Items.SNOW_BLOCK)
                        .unlockedBy("has_frosty_template", has(ZAMItems.FROSTY_ARMOR_TRIM_SMITHING_TEMPLATE)).save(output);

                shaped(RecipeCategory.MISC, ZAMItems.CASTLE_CRASHERS_CASE)
                        .pattern("SS ")
                        .pattern("SS ")
                        .define('S', ZAMTags.CASTLE_CRASHERS_MUSIC_DISCS)
                        .unlockedBy("has_record_for_castle_crashers_case", has(ZAMTags.CASTLE_CRASHERS_MUSIC_DISCS)).save(output);

                shaped(RecipeCategory.MISC, ZAMItems.MINECRAFT_CASE)
                        .pattern("SS ")
                        .pattern("SS ")
                        .define('S', ZAMTags.MINECRAFT_MUSIC_DISCS)
                        .unlockedBy("has_record_for_minecraft_case", has(ZAMTags.MINECRAFT_MUSIC_DISCS)).save(output);

                shaped(RecipeCategory.MISC, ZAMItems.SPONGEBOB_CASE)
                        .pattern("SS ")
                        .pattern("SS ")
                        .define('S', ZAMTags.SPONGEBOB_MUSIC_DISCS)
                        .unlockedBy("has_record_for_spongebob_case", has(ZAMTags.SPONGEBOB_MUSIC_DISCS)).save(output);

                shaped(RecipeCategory.MISC, ZAMItems.STARDEW_VALLEY_CASE)
                        .pattern("SS ")
                        .pattern("SS ")
                        .define('S', ZAMTags.STARDEW_VALLEY_MUSIC_DISCS)
                        .unlockedBy("has_record_for_stardew_valley_case", has(ZAMTags.STARDEW_VALLEY_MUSIC_DISCS)).save(output);

                shaped(RecipeCategory.MISC, ZAMItems.UNDERTALE_CASE)
                        .pattern("SS ")
                        .pattern("SS ")
                        .define('S', ZAMTags.UNDERTALE_MUSIC_DISCS)
                        .unlockedBy("has_record_for_undertale_case", has(ZAMTags.UNDERTALE_MUSIC_DISCS)).save(output);
            }
        };
    }

    @Override
    public String getName() {
        return "ZAM Recipes";
    }
}

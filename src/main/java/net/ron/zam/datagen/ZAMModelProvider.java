package net.ron.zam.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TexturedModel;
import net.ron.zam.ZAMMod;
import net.ron.zam.registry.ZAMBlocks;
import net.ron.zam.registry.ZAMCosmetics;
import net.ron.zam.registry.ZAMItems;

public class ZAMModelProvider  extends FabricModelProvider {
    public ZAMModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        blockModelGenerators.createTrivialCube(ZAMBlocks.SEA_JELLY_BLOCK);
        blockModelGenerators.createChest(ZAMBlocks.MARINERS_FORTUNE, ZAMBlocks.MARINERS_FORTUNE, ZAMMod.id("mariners_fortune"), false);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        itemModelGenerators.generateFlatItem(ZAMItems.MUSIC_DISC_DOG, ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateFlatItem(ZAMItems.CREST_ARMOR_TRIM_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.DWELLER_ARMOR_TRIM_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.FROSTY_ARMOR_TRIM_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.SEA_JELLY, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.CASE_KEY, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.GOLD_ICON, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.RED_ICON, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.MUSIC_BOX, ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateFlatItem(ZAMItems.SWORD_COSMETIC_PATTERN, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.PICKAXE_COSMETIC_PATTERN, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.AXE_COSMETIC_PATTERN, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.SHOVEL_COSMETIC_PATTERN, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.HOE_COSMETIC_PATTERN, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.SPEAR_COSMETIC_PATTERN, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.KNIFE_COSMETIC_PATTERN, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.FISHING_ROD_COSMETIC_PATTERN, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.BOW_COSMETIC_PATTERN, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.MACE_COSMETIC_PATTERN, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.SHEARS_COSMETIC_PATTERN, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.HELMET_COSMETIC_PATTERN, ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateFlatItem(ZAMItems.CASTLE_CRASHERS_CASE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.CASTLE_CRASHERS_FOUR_BRAVE_CHAMPS, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.CASTLE_CRASHERS_FLUTEY, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.CASTLE_CRASHERS_SPANISH_WALTZ, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.CASTLE_CRASHERS_RACE_AROUND_THE_WORLD, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.CASTLE_CRASHERS_JUMPER, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.CASTLE_CRASHERS_SPACE_PIRATES, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.CASTLE_CRASHERS_THE_SHOW, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.CASTLE_CRASHERS_SIMPLE_SIGHT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.CASTLE_CRASHERS_FINAL_CONFRONTATION, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.CASTLE_CRASHERS_ARCHETYPE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.CASTLE_CRASHERS_DARK_SKIES, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.CASTLE_CRASHERS_RAGE_CHAMPIONS, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.CASTLE_CRASHERS_BATTLEBLOCK, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.CASTLE_CRASHERS_PLEASE_DONT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.CASTLE_CRASHERS_THE_ABDUCTION, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.CASTLE_CRASHERS_WINTER_BLISS, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.CASTLE_CRASHERS_BARRACKS_SONG, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.CASTLE_CRASHERS_FLOODED_CASTLE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.CASTLE_CRASHERS_CHAOZ_JAPAN, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMCosmetics.CASTLE_CRASHERS_UNICORN_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ZAMCosmetics.CASTLE_CRASHERS_DEMON_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ZAMCosmetics.CASTLE_CRASHERS_CHICKEN_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);

        itemModelGenerators.generateFlatItem(ZAMCosmetics.HELLS_RETRIEVER, ModelTemplates.FLAT_HANDHELD_ITEM);

        itemModelGenerators.generateFlatItem(ZAMItems.MINECRAFT_CASE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.MINECRAFT_SUBWOOFER_LULLABY, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.MINECRAFT_HAGGSTROM, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.MINECRAFT_MINECRAFT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.MINECRAFT_MICE_ON_VENUS, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.MINECRAFT_SWEDEN, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.MINECRAFT_ARIA_MATH, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.MINECRAFT_HALLAND, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.MINECRAFT_DALARNA, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.createFlatItemModel(ZAMCosmetics.MINECRAFT_ECHO_OF_THE_VALLEY_BOW, ModelTemplates.BOW);
        itemModelGenerators.generateBow(ZAMCosmetics.MINECRAFT_ECHO_OF_THE_VALLEY_BOW);
        itemModelGenerators.generateFlatItem(ZAMCosmetics.MINECRAFT_ANCHOR_MACE, ModelTemplates.FLAT_HANDHELD_MACE_ITEM);
        itemModelGenerators.generateFlatItem(ZAMCosmetics.MINECRAFT_PIRATE_CUTLASS_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);

        itemModelGenerators.generateFlatItem(ZAMItems.SPONGEBOB_CASE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.SPONGEBOB_KRUSTY_KRAB, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.SPONGEBOB_THE_LINEMAN, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.SPONGEBOB_PUKA_A, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.SPONGEBOB_AWARD_WINNERS_A, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.SPONGEBOB_ANDY_ANNORAK, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.SPONGEBOB_SWEET_VICTORY, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.SPONGEBOB_JELLYFISH_JAM, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.SPONGEBOB_THE_RAKE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.SPONGEBOB_HAWAIIAN_TRAIN, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.SPONGEBOB_GARYS_SONG, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.SPONGEBOB_CHILL_OUT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.SPONGEBOB_MAUI_BEACH, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.SPONGEBOB_ME_FOR_YOU, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.SPONGEBOB_SURF_BUGGY, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.SPONGEBOB_DRUNKEN_SAILOR, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.SPONGEBOB_CHA_CHA_NOVA, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.SPONGEBOB_KELPY_G, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.SPONGEBOB_CHRISTMAS, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.SPONGEBOB_THEME_SONG, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMCosmetics.SPONGEBOB_JELLYFISHING_NET, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ZAMCosmetics.SPONGEBOB_GOLDEN_SPATULA, ModelTemplates.FLAT_HANDHELD_ITEM);

        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_CASE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_OVERTURE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_SPRING, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_SPRING_2, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_SPRING_3, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_PELICAN_TOWN, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_DISTANT_BANJO, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_SUMMER, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_SUMMER_2, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_SUMMER_3, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_ADVENTURE_GUILD, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_STARDROP_SALOON, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_LUAU_FESTIVAL, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_MOONLIGHT_JELLYFISH, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_FALL, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_FALL_2, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_FALL_3, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_LIBRARY, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_FAIR, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_SPIRITS_EVE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_WINTER, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_WINTER_2, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_WINTER_3, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_WINTER_FESTIVAL, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_COUNTRY_SHOP, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_CALICO_DESERT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_CRYSTAL_BELLS, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_FLICKER, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_DEEP_WOODS, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_NIGHT_MARKET, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_SUBMARINE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_MOVIE_THEATER, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_GINGER_ISLAND, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_LEOS_SONG, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_PROFESSOR_SNAILS_RADIO, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_SUMMIT_CELEBRATION, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMCosmetics.STARDEW_VALLEY_DRAGONTOOTH_CUTLASS, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ZAMCosmetics.STARDEW_VALLEY_NEPTUNES_GLAIVE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ZAMCosmetics.STARDEW_VALLEY_IRIDIUM_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFishingRod(ZAMCosmetics.STARDEW_VALLEY_IRIDIUM_FISHING_ROD);

        itemModelGenerators.generateFlatItem(ZAMItems.UNDERTALE_CASE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.UNDERTALE_UNDERTALE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.UNDERTALE_FALLEN_DOWN, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.UNDERTALE_RUINS, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.UNDERTALE_HOME, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.UNDERTALE_HEARTACHE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.UNDERTALE_SANS, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.UNDERTALE_SNOWY, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.UNDERTALE_DOGSONG, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.UNDERTALE_SHOP, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.UNDERTALE_BONETROUSLE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.UNDERTALE_DUMMY, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.UNDERTALE_SPEAR_OF_JUSTICE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.UNDERTALE_ANOTHER_MEDIUM, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.UNDERTALE_SPIDER_DANCE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.UNDERTALE_ITS_RAINING_SOMEWHERE_ELSE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.UNDERTALE_DEATH_BY_GLAMOUR, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.UNDERTALE_ASGORE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.UNDERTALE_FINALE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.UNDERTALE_HOPES_AND_DREAMS, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.UNDERTALE_MEGALOVANIA, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMCosmetics.UNDERTALE_REAL_KNIFE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ZAMCosmetics.UNDERTALE_NICE_CREAM_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateSpear(ZAMCosmetics.UNDERTALE_UNDYNES_SPEAR);
        itemModelGenerators.createFlatItemModel(ZAMCosmetics.UNDERTALE_GASTER_BLASTER, ModelTemplates.BOW);
        itemModelGenerators.generateBow(ZAMCosmetics.UNDERTALE_GASTER_BLASTER);
    }
}

package net.ron.zam.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
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
        itemModelGenerators.generateFlatItem(ZAMItems.CASTLE_CRASHERS_FOUR_BRAVE_CHAMPS, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.CASTLE_CRASHERS_FLUTEY, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.CASTLE_CRASHERS_SPANISH_WALTZ, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.CASTLE_CRASHERS_RACE_AROUND_THE_WORLD, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.CASTLE_CRASHERS_JUMPER, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.CASTLE_CRASHERS_SPACE_PIRATES, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.CASTLE_CRASHERS_THE_SHOW, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.CASTLE_CRASHERS_SIMPLE_SIGHT, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.CASTLE_CRASHERS_FINAL_CONFRONTATION, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.CASTLE_CRASHERS_ARCHETYPE, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.CASTLE_CRASHERS_DARK_SKIES, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.CASTLE_CRASHERS_RAGE_CHAMPIONS, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.CASTLE_CRASHERS_BATTLEBLOCK, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.CASTLE_CRASHERS_PLEASE_DONT, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.CASTLE_CRASHERS_THE_ABDUCTION, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.CASTLE_CRASHERS_WINTER_BLISS, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.CASTLE_CRASHERS_BARRACKS_SONG, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.CASTLE_CRASHERS_FLOODED_CASTLE, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.CASTLE_CRASHERS_CHAOZ_JAPAN, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMCosmetics.CASTLE_CRASHERS_UNICORN_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ZAMCosmetics.CASTLE_CRASHERS_DEMON_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ZAMCosmetics.CASTLE_CRASHERS_CHICKEN_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);

        itemModelGenerators.generateFlatItem(ZAMItems.COD_ZOMBIES_CASE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.COD_ZOMBIES_JUGGERNOG, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.COD_ZOMBIES_SPEED_COLA, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.COD_ZOMBIES_DOUBLE_TAP, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.COD_ZOMBIES_QUICK_REVIVE, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.COD_ZOMBIES_PHD, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.COD_ZOMBIES_STAMINUP, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.COD_ZOMBIES_DEADSHOT, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.COD_ZOMBIES_MULE_KICK, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.COD_ZOMBIES_TOMBSTONE, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.COD_ZOMBIES_WHOS_WHO, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.COD_ZOMBIES_VULTURE_AID, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.COD_ZOMBIES_WIDOWS_WINE, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.COD_ZOMBIES_ELEMENTAL_POP, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.COD_ZOMBIES_DEATH_PERCEPTION, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.COD_ZOMBIES_MELEE_MACCHIATO, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.COD_ZOMBIES_WISP_TEA, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.COD_ZOMBIES_SOE_JUGGERNOG, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.COD_ZOMBIES_SOE_SPEED_COLA, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.COD_ZOMBIES_SOE_DOUBLE_TAP, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.COD_ZOMBIES_SOE_QUICK_REVIVE, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.COD_ZOMBIES_SOE_MULE_KICK, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.COD_ZOMBIES_PACK_A_PUNCH, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.COD_ZOMBIES_FIRE_SALE, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.COD_ZOMBIES_DAMNED, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.COD_ZOMBIES_RUSTY_CAGE, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.COD_ZOMBIES_SNAKESKIN_BOOTS, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.COD_ZOMBIES_115, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.COD_ZOMBIES_SHEPHERD_OF_FIRE, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMCosmetics.COD_ZOMBIES_HELLS_RETRIEVER, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ZAMCosmetics.COD_ZOMBIES_GOLDEN_SPORK, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ZAMCosmetics.COD_ZOMBIES_APOTHICAN_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.createFlatItemModel(ZAMCosmetics.COD_ZOMBIES_WOLF_BOW, ModelTemplates.BOW);
        itemModelGenerators.generateBow(ZAMCosmetics.COD_ZOMBIES_WOLF_BOW);
        itemModelGenerators.generateSpear(ZAMCosmetics.COD_ZOMBIES_ICE_STAFF);

        itemModelGenerators.generateFlatItem(ZAMItems.COUNTER_STRIKE_CASE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.COUNTER_STRIKE_GO_THEME, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.COUNTER_STRIKE_2_THEME, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.COUNTER_STRIKE_EZ4ENCE, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.COUNTER_STRIKE_FLASHBANG_DANCE, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.COUNTER_STRIKE_DASHSTAR, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.COUNTER_STRIKE_ULTIMATE, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.COUNTER_STRIKE_GOLD_STEPS, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.COUNTER_STRIKE_CRAB_RAVE, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.COUNTER_STRIKE_DIE_FOR_YOU, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.COUNTER_STRIKE_CARAMEL_DANCING, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMCosmetics.COUNTER_STRIKE_DOPPLER_KNIFE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ZAMCosmetics.COUNTER_STRIKE_NIGHTWISH, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ZAMCosmetics.COUNTER_STRIKE_GLITCHPOP_DAGGER, ModelTemplates.FLAT_HANDHELD_ITEM);

        itemModelGenerators.generateFlatItem(ZAMItems.DRAGON_BALL_CASE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.DRAGON_BALL_BROLY_VS_GOGETA, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.DRAGON_BALL_CHA_LA, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.DRAGON_BALL_DAN_DAN, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.DRAGON_BALL_GATEBREAKER, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.DRAGON_BALL_GT_RECAP, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.DRAGON_BALL_ULTRA_INSTINCT, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.DRAGON_BALL_ULTIMATE_BATTLE, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.DRAGON_BALL_THE_DRINK, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMCosmetics.DRAGON_BALL_SICKLE_OF_SORROW, ModelTemplates.FLAT_HANDHELD_ITEM);

        itemModelGenerators.generateFlatItem(ZAMItems.HOLIDAY_CASE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.HOLIDAY_LAST_CHRISTMAS, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.HOLIDAY_WHITE_CHRISTMAS, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.HOLIDAY_JINGLE_BELL_ROCK, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.HOLIDAY_ROCKIN_AROUND_THE_CHRISTMAS_TREE, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.HOLIDAY_MARIAH_CAREY, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.HOLIDAY_FELIZ_NAVIDAD, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.HOLIDAY_THE_CHRISTMAS_SONG, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.HOLIDAY_WONDERFUL_TIME_OF_THE_YEAR, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.HOLIDAY_HEAVY_METAL_CHRISTMAS, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMCosmetics.HOLIDAY_CANDY_CANE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ZAMCosmetics.HOLIDAY_HOCKEY_STICK, ModelTemplates.FLAT_HANDHELD_ITEM);

        itemModelGenerators.generateFlatItem(ZAMItems.HXH_CASE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.HXH_ALL_I_NEED_IS_MONEY, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.HXH_BOYS_BE_COURAGEOUS, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.HXH_DEPARTURE, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.HXH_FROM_WHALE_ISLAND, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.HXH_HISOKA_THEME, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.HXH_HUNTING_FOR_YOUR_DREAM, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.HXH_HYORI_ITTAI, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.HXH_WORLD_OF_ADVENTURES, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMCosmetics.HXH_CRAZY_SLOTS_SCYTHE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFishingRod(ZAMCosmetics.HXH_GONS_FISHING_ROD);

        itemModelGenerators.generateFlatItem(ZAMItems.MINECRAFT_CASE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.MINECRAFT_SUBWOOFER_LULLABY, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.MINECRAFT_HAGGSTROM, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.MINECRAFT_MINECRAFT, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.MINECRAFT_MICE_ON_VENUS, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.MINECRAFT_SWEDEN, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.MINECRAFT_ARIA_MATH, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.MINECRAFT_HALLAND, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.MINECRAFT_DALARNA, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.createFlatItemModel(ZAMCosmetics.MINECRAFT_ECHO_OF_THE_VALLEY, ModelTemplates.BOW);
        itemModelGenerators.generateBow(ZAMCosmetics.MINECRAFT_ECHO_OF_THE_VALLEY);
        itemModelGenerators.generateFlatItem(ZAMCosmetics.MINECRAFT_ANCHOR, ModelTemplates.FLAT_HANDHELD_MACE_ITEM);
        itemModelGenerators.generateFlatItem(ZAMCosmetics.MINECRAFT_PIRATE_CUTLASS, ModelTemplates.FLAT_HANDHELD_ITEM);

        itemModelGenerators.generateFlatItem(ZAMItems.SPONGEBOB_CASE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.SPONGEBOB_KRUSTY_KRAB, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.SPONGEBOB_THE_LINEMAN, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.SPONGEBOB_PUKA_A, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.SPONGEBOB_AWARD_WINNERS_A, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.SPONGEBOB_ANDY_ANNORAK, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.SPONGEBOB_SWEET_VICTORY, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.SPONGEBOB_JELLYFISH_JAM, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.SPONGEBOB_THE_RAKE, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.SPONGEBOB_HAWAIIAN_TRAIN, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.SPONGEBOB_GARYS_SONG, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.SPONGEBOB_CHILL_OUT, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.SPONGEBOB_MAUI_BEACH, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.SPONGEBOB_ME_FOR_YOU, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.SPONGEBOB_SURF_BUGGY, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.SPONGEBOB_DRUNKEN_SAILOR, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.SPONGEBOB_CHA_CHA_NOVA, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.SPONGEBOB_KELPY_G, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.SPONGEBOB_CHRISTMAS, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.SPONGEBOB_THEME_SONG, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMCosmetics.SPONGEBOB_JELLYFISHING_NET, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ZAMCosmetics.SPONGEBOB_GOLDEN_SPATULA, ModelTemplates.FLAT_HANDHELD_ITEM);

        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_CASE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_OVERTURE, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_SPRING, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_SPRING_2, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_SPRING_3, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_PELICAN_TOWN, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_DISTANT_BANJO, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_SUMMER, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_SUMMER_2, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_SUMMER_3, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_ADVENTURE_GUILD, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_STARDROP_SALOON, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_LUAU_FESTIVAL, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_MOONLIGHT_JELLYFISH, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_FALL, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_FALL_2, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_FALL_3, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_LIBRARY, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_FAIR, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_SPIRITS_EVE, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_WINTER, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_WINTER_2, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_WINTER_3, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_WINTER_FESTIVAL, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_COUNTRY_SHOP, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_CALICO_DESERT, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_CRYSTAL_BELLS, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_FLICKER, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_DEEP_WOODS, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_NIGHT_MARKET, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_SUBMARINE, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_MOVIE_THEATER, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_GINGER_ISLAND, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_LEOS_SONG, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_PROFESSOR_SNAILS_RADIO, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.STARDEW_VALLEY_SUMMIT_CELEBRATION, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMCosmetics.STARDEW_VALLEY_DRAGONTOOTH_CUTLASS, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ZAMCosmetics.STARDEW_VALLEY_NEPTUNES_GLAIVE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ZAMCosmetics.STARDEW_VALLEY_IRIDIUM_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFishingRod(ZAMCosmetics.STARDEW_VALLEY_IRIDIUM_FISHING_ROD);

        itemModelGenerators.generateFlatItem(ZAMItems.UNDERTALE_CASE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ZAMItems.UNDERTALE_UNDERTALE, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.UNDERTALE_FALLEN_DOWN, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.UNDERTALE_RUINS, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.UNDERTALE_HOME, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.UNDERTALE_HEARTACHE, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.UNDERTALE_SANS, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.UNDERTALE_SNOWY, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.UNDERTALE_DOGSONG, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.UNDERTALE_SHOP, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.UNDERTALE_BONETROUSLE, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.UNDERTALE_DUMMY, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.UNDERTALE_SPEAR_OF_JUSTICE, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.UNDERTALE_ANOTHER_MEDIUM, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.UNDERTALE_SPIDER_DANCE, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.UNDERTALE_ITS_RAINING_SOMEWHERE_ELSE, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.UNDERTALE_DEATH_BY_GLAMOUR, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.UNDERTALE_ASGORE, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.UNDERTALE_FINALE, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.UNDERTALE_HOPES_AND_DREAMS, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMItems.UNDERTALE_MEGALOVANIA, ModelTemplates.MUSIC_DISC);
        itemModelGenerators.generateFlatItem(ZAMCosmetics.UNDERTALE_REAL_KNIFE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ZAMCosmetics.UNDERTALE_NICE_CREAM_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateSpear(ZAMCosmetics.UNDERTALE_UNDYNES_SPEAR);
        itemModelGenerators.createFlatItemModel(ZAMCosmetics.UNDERTALE_GASTER_BLASTER, ModelTemplates.BOW);
        itemModelGenerators.generateBow(ZAMCosmetics.UNDERTALE_GASTER_BLASTER);
    }
}

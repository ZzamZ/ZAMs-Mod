package net.ron.zam.registry;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.JukeboxSong;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SmithingTemplateItem;
import net.ron.zam.ZAMMod;
import net.ron.zam.common.item.*;
import net.ron.zam.util.cosmetic.CosmeticTarget;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ZAMItems {
    private static final List<Item> COLLECTION_DISCS = new ArrayList<>();
    private static final List<Item> COLLECTION_CASES = new ArrayList<>();

    public static final Item GOLD_ICON = registerItem("gold_icon", properties -> new Item(properties.rarity(Rarity.EPIC)));
    public static final Item RED_ICON = registerItem("red_icon", properties -> new Item(properties.rarity(Rarity.RARE)));

    public static final Item CASE_KEY = registerItem("case_key", properties -> new Item(properties.rarity(Rarity.UNCOMMON)));
    public static final Item MUSIC_BOX = registerItem("music_box", MusicBoxItem::new);
    public static final Item RECORD_SLEEVE = registerItem("record_sleeve", RecordSleeveItem::new);

    public static final Item MUSIC_DISC_DOG = registerItem("music_disc_dog", properties -> new Item(properties.stacksTo(1).jukeboxPlayable(ZAMJukeboxSongs.DOG).rarity(Rarity.RARE)));

    public static final Item CREST_ARMOR_TRIM_SMITHING_TEMPLATE = registerItem("crest_armor_trim_smithing_template", properties -> SmithingTemplateItem.createArmorTrimTemplate(properties.rarity(Rarity.RARE)));
    public static final Item DWELLER_ARMOR_TRIM_SMITHING_TEMPLATE = registerItem("dweller_armor_trim_smithing_template", properties -> SmithingTemplateItem.createArmorTrimTemplate(properties.rarity(Rarity.RARE)));
    public static final Item FROSTY_ARMOR_TRIM_SMITHING_TEMPLATE = registerItem("frosty_armor_trim_smithing_template", properties -> SmithingTemplateItem.createArmorTrimTemplate(properties.rarity(Rarity.UNCOMMON)));

    public static final Item SEA_JELLY = registerItem("sea_jelly", SeaJellyItem::new);

    public static final Item SWORD_COSMETIC_PATTERN = registerItem("sword_cosmetic_pattern", properties -> new CosmeticPatternItem(CosmeticTarget.SWORD, properties.rarity(Rarity.RARE)));
    public static final Item PICKAXE_COSMETIC_PATTERN = registerItem("pickaxe_cosmetic_pattern", properties -> new CosmeticPatternItem(CosmeticTarget.PICKAXE, properties.rarity(Rarity.RARE)));
    public static final Item SHOVEL_COSMETIC_PATTERN = registerItem("shovel_cosmetic_pattern", properties -> new CosmeticPatternItem(CosmeticTarget.SHOVEL, properties.rarity(Rarity.RARE)));
    public static final Item AXE_COSMETIC_PATTERN = registerItem("axe_cosmetic_pattern", properties -> new CosmeticPatternItem(CosmeticTarget.AXE, properties.rarity(Rarity.RARE)));
    public static final Item HOE_COSMETIC_PATTERN = registerItem("hoe_cosmetic_pattern", properties -> new CosmeticPatternItem(CosmeticTarget.HOE, properties.rarity(Rarity.RARE)));
    public static final Item KNIFE_COSMETIC_PATTERN = registerItem("knife_cosmetic_pattern", properties -> new CosmeticPatternItem(CosmeticTarget.KNIFE, properties.rarity(Rarity.RARE)));
    public static final Item SPEAR_COSMETIC_PATTERN = registerItem("spear_cosmetic_pattern", properties -> new CosmeticPatternItem(CosmeticTarget.SPEAR, properties.rarity(Rarity.RARE)));
    public static final Item MACE_COSMETIC_PATTERN = registerItem("mace_cosmetic_pattern", properties -> new CosmeticPatternItem(CosmeticTarget.MACE, properties.rarity(Rarity.RARE)));
    public static final Item FISHING_ROD_COSMETIC_PATTERN = registerItem("fishing_rod_cosmetic_pattern", properties -> new CosmeticPatternItem(CosmeticTarget.FISHING_ROD, properties.rarity(Rarity.RARE)));
    public static final Item HELMET_COSMETIC_PATTERN = registerItem("helmet_cosmetic_pattern", properties -> new CosmeticPatternItem(CosmeticTarget.HELMET, properties.rarity(Rarity.RARE)));
    public static final Item SHEARS_COSMETIC_PATTERN = registerItem("shears_cosmetic_pattern", properties -> new CosmeticPatternItem(CosmeticTarget.SHEARS, properties.rarity(Rarity.RARE)));
    public static final Item BOW_COSMETIC_PATTERN = registerItem("bow_cosmetic_pattern", properties -> new CosmeticPatternItem(CosmeticTarget.BOW, properties.rarity(Rarity.RARE)));

    //Castle Crashers (18)
    public static final Item CASTLE_CRASHERS_CASE = collectionCase("castle_crashers_case");
    public static final Item CASTLE_CRASHERS_FOUR_BRAVE_CHAMPS = collectionDisc("castle_crashers_four_brave_champs", "Castle Crashers", ZAMJukeboxSongs.CASTLE_CRASHERS_FOUR_BRAVE_CHAMPS, Rarity.UNCOMMON);
    public static final Item CASTLE_CRASHERS_FLUTEY = collectionDisc("castle_crashers_flutey", "Castle Crashers", ZAMJukeboxSongs.CASTLE_CRASHERS_FLUTEY, Rarity.UNCOMMON);
    public static final Item CASTLE_CRASHERS_SPANISH_WALTZ = collectionDisc("castle_crashers_spanish_waltz", "Castle Crashers", ZAMJukeboxSongs.CASTLE_CRASHERS_SPANISH_WALTZ, Rarity.UNCOMMON);
    public static final Item CASTLE_CRASHERS_RACE_AROUND_THE_WORLD = collectionDisc("castle_crashers_race_around_the_world", "Castle Crashers", ZAMJukeboxSongs.CASTLE_CRASHERS_RACE_AROUND_THE_WORLD, Rarity.UNCOMMON);
    public static final Item CASTLE_CRASHERS_JUMPER = collectionDisc("castle_crashers_jumper", "Castle Crashers", ZAMJukeboxSongs.CASTLE_CRASHERS_JUMPER, Rarity.EPIC);
    public static final Item CASTLE_CRASHERS_SPACE_PIRATES = collectionDisc("castle_crashers_space_pirates", "Castle Crashers", ZAMJukeboxSongs.CASTLE_CRASHERS_SPACE_PIRATES, Rarity.EPIC);
    public static final Item CASTLE_CRASHERS_THE_SHOW = collectionDisc("castle_crashers_the_show", "Castle Crashers", ZAMJukeboxSongs.CASTLE_CRASHERS_THE_SHOW, Rarity.RARE);
    public static final Item CASTLE_CRASHERS_SIMPLE_SIGHT = collectionDisc("castle_crashers_simple_sight", "Castle Crashers", ZAMJukeboxSongs.CASTLE_CRASHERS_SIMPLE_SIGHT, Rarity.RARE);
    public static final Item CASTLE_CRASHERS_FINAL_CONFRONTATION = collectionDisc("castle_crashers_final_confrontation", "Castle Crashers", ZAMJukeboxSongs.CASTLE_CRASHERS_FINAL_CONFRONTATION, Rarity.RARE);
    public static final Item CASTLE_CRASHERS_ARCHETYPE = collectionDisc("castle_crashers_archetype", "Castle Crashers", ZAMJukeboxSongs.CASTLE_CRASHERS_ARCHETYPE, Rarity.RARE);
    public static final Item CASTLE_CRASHERS_DARK_SKIES = collectionDisc("castle_crashers_dark_skies", "Castle Crashers", ZAMJukeboxSongs.CASTLE_CRASHERS_DARK_SKIES, Rarity.EPIC);
    public static final Item CASTLE_CRASHERS_RAGE_CHAMPIONS = collectionDisc("castle_crashers_rage_champions", "Castle Crashers", ZAMJukeboxSongs.CASTLE_CRASHERS_RAGE_CHAMPIONS, Rarity.EPIC);
    public static final Item CASTLE_CRASHERS_BATTLEBLOCK = collectionDisc("castle_crashers_battleblock", "Castle Crashers", ZAMJukeboxSongs.CASTLE_CRASHERS_BATTLEBLOCK, Rarity.EPIC);
    public static final Item CASTLE_CRASHERS_PLEASE_DONT = collectionDisc("castle_crashers_please_dont", "Castle Crashers", ZAMJukeboxSongs.CASTLE_CRASHERS_PLEASE_DONT, Rarity.UNCOMMON);
    public static final Item CASTLE_CRASHERS_THE_ABDUCTION = collectionDisc("castle_crashers_the_abduction", "Castle Crashers", ZAMJukeboxSongs.CASTLE_CRASHERS_THE_ABDUCTION, Rarity.EPIC);
    public static final Item CASTLE_CRASHERS_WINTER_BLISS = collectionDisc("castle_crashers_winter_bliss", "Castle Crashers", ZAMJukeboxSongs.CASTLE_CRASHERS_WINTER_BLISS, Rarity.UNCOMMON);
    public static final Item CASTLE_CRASHERS_BARRACKS_SONG = collectionDisc("castle_crashers_barracks_song", "Castle Crashers", ZAMJukeboxSongs.CASTLE_CRASHERS_BARRACKS_SONG, Rarity.UNCOMMON);
    public static final Item CASTLE_CRASHERS_FLOODED_CASTLE = collectionDisc("castle_crashers_flooded_castle", "Castle Crashers", ZAMJukeboxSongs.CASTLE_CRASHERS_FLOODED_CASTLE, Rarity.UNCOMMON);
    public static final Item CASTLE_CRASHERS_CHAOZ_JAPAN = collectionDisc("castle_crashers_chaoz_japan", "Castle Crashers", ZAMJukeboxSongs.CASTLE_CRASHERS_CHAOZ_JAPAN, Rarity.RARE);
    
    // Minecraft (9)
    public static final Item MINECRAFT_CASE = collectionCase("minecraft_case");
    public static final Item MINECRAFT_SUBWOOFER_LULLABY = collectionDisc("minecraft_subwoofer_lullaby", "Minecraft", ZAMJukeboxSongs.MINECRAFT_SUBWOOFER_LULLABY, Rarity.RARE);
    public static final Item MINECRAFT_HAGGSTROM = collectionDisc("minecraft_haggstrom", "Minecraft", ZAMJukeboxSongs.MINECRAFT_HAGGSTROM, Rarity.UNCOMMON);
    public static final Item MINECRAFT_MINECRAFT = collectionDisc("minecraft_minecraft", "Minecraft", ZAMJukeboxSongs.MINECRAFT_MINECRAFT, Rarity.UNCOMMON);
    public static final Item MINECRAFT_SWEDEN = collectionDisc("minecraft_sweden", "Minecraft", ZAMJukeboxSongs.MINECRAFT_SWEDEN, Rarity.EPIC);
    public static final Item MINECRAFT_MICE_ON_VENUS = collectionDisc("minecraft_mice_on_venus", "Minecraft", ZAMJukeboxSongs.MINECRAFT_MICE_ON_VENUS, Rarity.RARE);
    public static final Item MINECRAFT_ARIA_MATH = collectionDisc("minecraft_aria_math", "Minecraft", ZAMJukeboxSongs.MINECRAFT_ARIA_MATH, Rarity.EPIC);
    public static final Item MINECRAFT_HALLAND = collectionDisc("minecraft_halland", "Minecraft", ZAMJukeboxSongs.MINECRAFT_HALLAND, Rarity.UNCOMMON);
    public static final Item MINECRAFT_DALARNA = collectionDisc("minecraft_dalarna", "Minecraft", ZAMJukeboxSongs.MINECRAFT_DALARNA, Rarity.UNCOMMON);

    //Spongebob (18)
    public static final Item SPONGEBOB_CASE = collectionCase("spongebob_case");
    public static final Item SPONGEBOB_KRUSTY_KRAB = collectionDisc("spongebob_krusty_krab", "SpongeBob SquarePants", ZAMJukeboxSongs.SPONGEBOB_KRUSTY_KRAB, Rarity.UNCOMMON);
    public static final Item SPONGEBOB_THE_LINEMAN = collectionDisc("spongebob_the_lineman", "SpongeBob SquarePants", ZAMJukeboxSongs.SPONGEBOB_THE_LINEMAN, Rarity.UNCOMMON);
    public static final Item SPONGEBOB_PUKA_A = collectionDisc("spongebob_puka_a", "SpongeBob SquarePants", ZAMJukeboxSongs.SPONGEBOB_PUKA_A, Rarity.UNCOMMON);
    public static final Item SPONGEBOB_AWARD_WINNERS_A = collectionDisc("spongebob_award_winners_a", "SpongeBob SquarePants", ZAMJukeboxSongs.SPONGEBOB_AWARD_WINNERS_A, Rarity.EPIC);
    public static final Item SPONGEBOB_ANDY_ANNORAK = collectionDisc("spongebob_andy_annorak", "SpongeBob SquarePants", ZAMJukeboxSongs.SPONGEBOB_ANDY_ANNORAK, Rarity.RARE);
    public static final Item SPONGEBOB_SWEET_VICTORY = collectionDisc("spongebob_sweet_victory", "SpongeBob SquarePants", ZAMJukeboxSongs.SPONGEBOB_SWEET_VICTORY, Rarity.EPIC);
    public static final Item SPONGEBOB_JELLYFISH_JAM = collectionDisc("spongebob_jellyfish_jam", "SpongeBob SquarePants", ZAMJukeboxSongs.SPONGEBOB_JELLYFISH_JAM, Rarity.EPIC);
    public static final Item SPONGEBOB_THE_RAKE = collectionDisc("spongebob_the_rake", "SpongeBob SquarePants", ZAMJukeboxSongs.SPONGEBOB_THE_RAKE, Rarity.RARE);
    public static final Item SPONGEBOB_HAWAIIAN_TRAIN = collectionDisc("spongebob_hawaiian_train", "SpongeBob SquarePants", ZAMJukeboxSongs.SPONGEBOB_HAWAIIAN_TRAIN, Rarity.UNCOMMON);
    public static final Item SPONGEBOB_GARYS_SONG = collectionDisc("spongebob_garys_song", "SpongeBob SquarePants", ZAMJukeboxSongs.SPONGEBOB_GARYS_SONG, Rarity.EPIC);
    public static final Item SPONGEBOB_CHILL_OUT = collectionDisc("spongebob_chill_out", "SpongeBob SquarePants", ZAMJukeboxSongs.SPONGEBOB_CHILL_OUT, Rarity.UNCOMMON);
    public static final Item SPONGEBOB_MAUI_BEACH = collectionDisc("spongebob_maui_beach", "SpongeBob SquarePants", ZAMJukeboxSongs.SPONGEBOB_MAUI_BEACH, Rarity.UNCOMMON);
    public static final Item SPONGEBOB_ME_FOR_YOU = collectionDisc("spongebob_me_for_you", "SpongeBob SquarePants", ZAMJukeboxSongs.SPONGEBOB_ME_FOR_YOU, Rarity.RARE);
    public static final Item SPONGEBOB_SURF_BUGGY = collectionDisc("spongebob_surf_buggy", "SpongeBob SquarePants", ZAMJukeboxSongs.SPONGEBOB_SURF_BUGGY, Rarity.UNCOMMON);
    public static final Item SPONGEBOB_DRUNKEN_SAILOR = collectionDisc("spongebob_drunken_sailor", "SpongeBob SquarePants", ZAMJukeboxSongs.SPONGEBOB_DRUNKEN_SAILOR, Rarity.RARE);
    public static final Item SPONGEBOB_CHA_CHA_NOVA = collectionDisc("spongebob_cha_cha_nova", "SpongeBob SquarePants", ZAMJukeboxSongs.SPONGEBOB_CHA_CHA_NOVA, Rarity.EPIC);
    public static final Item SPONGEBOB_KELPY_G = collectionDisc("spongebob_kelpy_g", "SpongeBob SquarePants", ZAMJukeboxSongs.SPONGEBOB_KELPY_G, Rarity.EPIC);
    public static final Item SPONGEBOB_CHRISTMAS = collectionDisc("spongebob_christmas", "SpongeBob SquarePants", ZAMJukeboxSongs.SPONGEBOB_CHRISTMAS, Rarity.RARE);
    public static final Item SPONGEBOB_THEME_SONG = collectionDisc("spongebob_theme_song", "SpongeBob SquarePants", ZAMJukeboxSongs.SPONGEBOB_THEME_SONG, Rarity.UNCOMMON);

    //Stardew Valley (27)
    public static final Item STARDEW_VALLEY_CASE = collectionCase("stardew_valley_case");
    public static final Item STARDEW_VALLEY_OVERTURE = collectionDisc("stardew_valley_overture", "Stardew Valley", ZAMJukeboxSongs.STARDEW_VALLEY_OVERTURE, Rarity.UNCOMMON);
    public static final Item STARDEW_VALLEY_SPRING = collectionDisc("stardew_valley_spring", "Stardew Valley", ZAMJukeboxSongs.STARDEW_VALLEY_SPRING, Rarity.EPIC);
    public static final Item STARDEW_VALLEY_SPRING_2 = collectionDisc("stardew_valley_spring_2", "Stardew Valley", ZAMJukeboxSongs.STARDEW_VALLEY_SPRING_2, Rarity.EPIC);
    public static final Item STARDEW_VALLEY_SPRING_3 = collectionDisc("stardew_valley_spring_3", "Stardew Valley", ZAMJukeboxSongs.STARDEW_VALLEY_SPRING_3, Rarity.EPIC);
    public static final Item STARDEW_VALLEY_PELICAN_TOWN = collectionDisc("stardew_valley_pelican_town", "Stardew Valley", ZAMJukeboxSongs.STARDEW_VALLEY_PELICAN_TOWN, Rarity.UNCOMMON);
    public static final Item STARDEW_VALLEY_DISTANT_BANJO = collectionDisc("stardew_valley_distant_banjo", "Stardew Valley", ZAMJukeboxSongs.STARDEW_VALLEY_DISTANT_BANJO, Rarity.RARE);
    public static final Item STARDEW_VALLEY_SUMMER = collectionDisc("stardew_valley_summer", "Stardew Valley", ZAMJukeboxSongs.STARDEW_VALLEY_SUMMER, Rarity.EPIC);
    public static final Item STARDEW_VALLEY_SUMMER_2 = collectionDisc("stardew_valley_summer_2", "Stardew Valley", ZAMJukeboxSongs.STARDEW_VALLEY_SUMMER_2, Rarity.EPIC);
    public static final Item STARDEW_VALLEY_SUMMER_3 = collectionDisc("stardew_valley_summer_3", "Stardew Valley", ZAMJukeboxSongs.STARDEW_VALLEY_SUMMER_3, Rarity.EPIC);
    public static final Item STARDEW_VALLEY_ADVENTURE_GUILD = collectionDisc("stardew_valley_adventure_guild", "Stardew Valley", ZAMJukeboxSongs.STARDEW_VALLEY_ADVENTURE_GUILD, Rarity.UNCOMMON);
    public static final Item STARDEW_VALLEY_STARDROP_SALOON = collectionDisc("stardew_valley_stardrop_saloon", "Stardew Valley", ZAMJukeboxSongs.STARDEW_VALLEY_STARDROP_SALOON, Rarity.RARE);
    public static final Item STARDEW_VALLEY_LUAU_FESTIVAL = collectionDisc("stardew_valley_luau_festival", "Stardew Valley", ZAMJukeboxSongs.STARDEW_VALLEY_LUAU_FESTIVAL, Rarity.RARE);
    public static final Item STARDEW_VALLEY_MOONLIGHT_JELLYFISH = collectionDisc("stardew_valley_moonlight_jellyfish", "Stardew Valley", ZAMJukeboxSongs.STARDEW_VALLEY_MOONLIGHT_JELLYFISH, Rarity.RARE);
    public static final Item STARDEW_VALLEY_FALL = collectionDisc("stardew_valley_fall", "Stardew Valley", ZAMJukeboxSongs.STARDEW_VALLEY_FALL, Rarity.EPIC);
    public static final Item STARDEW_VALLEY_FALL_2 = collectionDisc("stardew_valley_fall_2", "Stardew Valley", ZAMJukeboxSongs.STARDEW_VALLEY_FALL_2, Rarity.EPIC);
    public static final Item STARDEW_VALLEY_FALL_3 = collectionDisc("stardew_valley_fall_3", "Stardew Valley", ZAMJukeboxSongs.STARDEW_VALLEY_FALL_3, Rarity.EPIC);
    public static final Item STARDEW_VALLEY_LIBRARY = collectionDisc("stardew_valley_library", "Stardew Valley", ZAMJukeboxSongs.STARDEW_VALLEY_LIBRARY, Rarity.UNCOMMON);
    public static final Item STARDEW_VALLEY_FAIR = collectionDisc("stardew_valley_fair", "Stardew Valley", ZAMJukeboxSongs.STARDEW_VALLEY_FAIR, Rarity.UNCOMMON);
    public static final Item STARDEW_VALLEY_SPIRITS_EVE = collectionDisc("stardew_valley_spirits_eve", "Stardew Valley", ZAMJukeboxSongs.STARDEW_VALLEY_SPIRITS_EVE, Rarity.RARE);
    public static final Item STARDEW_VALLEY_WINTER = collectionDisc("stardew_valley_winter", "Stardew Valley", ZAMJukeboxSongs.STARDEW_VALLEY_WINTER, Rarity.EPIC);
    public static final Item STARDEW_VALLEY_WINTER_2 = collectionDisc("stardew_valley_winter_2", "Stardew Valley", ZAMJukeboxSongs.STARDEW_VALLEY_WINTER_2, Rarity.EPIC);
    public static final Item STARDEW_VALLEY_WINTER_3 = collectionDisc("stardew_valley_winter_3", "Stardew Valley", ZAMJukeboxSongs.STARDEW_VALLEY_WINTER_3, Rarity.EPIC);
    public static final Item STARDEW_VALLEY_WINTER_FESTIVAL = collectionDisc("stardew_valley_winter_festival", "Stardew Valley", ZAMJukeboxSongs.STARDEW_VALLEY_WINTER_FESTIVAL, Rarity.RARE);
    public static final Item STARDEW_VALLEY_COUNTRY_SHOP = collectionDisc("stardew_valley_country_shop", "Stardew Valley", ZAMJukeboxSongs.STARDEW_VALLEY_COUNTRY_SHOP, Rarity.UNCOMMON);
    public static final Item STARDEW_VALLEY_CALICO_DESERT = collectionDisc("stardew_valley_calico_desert", "Stardew Valley", ZAMJukeboxSongs.STARDEW_VALLEY_CALICO_DESERT, Rarity.UNCOMMON);
    public static final Item STARDEW_VALLEY_CRYSTAL_BELLS = collectionDisc("stardew_valley_crystal_bells", "Stardew Valley", ZAMJukeboxSongs.STARDEW_VALLEY_CRYSTAL_BELLS, Rarity.UNCOMMON);
    public static final Item STARDEW_VALLEY_FLICKER = collectionDisc("stardew_valley_flicker", "Stardew Valley", ZAMJukeboxSongs.STARDEW_VALLEY_FLICKER, Rarity.UNCOMMON);
    public static final Item STARDEW_VALLEY_DEEP_WOODS = collectionDisc("stardew_valley_deep_woods", "Stardew Valley", ZAMJukeboxSongs.STARDEW_VALLEY_DEEP_WOODS, Rarity.RARE);
    public static final Item STARDEW_VALLEY_NIGHT_MARKET = collectionDisc("stardew_valley_night_market", "Stardew Valley", ZAMJukeboxSongs.STARDEW_VALLEY_NIGHT_MARKET, Rarity.UNCOMMON);
    public static final Item STARDEW_VALLEY_SUBMARINE = collectionDisc("stardew_valley_submarine", "Stardew Valley", ZAMJukeboxSongs.STARDEW_VALLEY_SUBMARINE, Rarity.UNCOMMON);
    public static final Item STARDEW_VALLEY_MOVIE_THEATER = collectionDisc("stardew_valley_movie_theater", "Stardew Valley", ZAMJukeboxSongs.STARDEW_VALLEY_MOVIE_THEATER, Rarity.RARE);
    public static final Item STARDEW_VALLEY_GINGER_ISLAND = collectionDisc("stardew_valley_ginger_island", "Stardew Valley", ZAMJukeboxSongs.STARDEW_VALLEY_GINGER_ISLAND, Rarity.EPIC);
    public static final Item STARDEW_VALLEY_LEOS_SONG = collectionDisc("stardew_valley_leos_song", "Stardew Valley", ZAMJukeboxSongs.STARDEW_VALLEY_LEOS_SONG, Rarity.EPIC);
    public static final Item STARDEW_VALLEY_PROFESSOR_SNAILS_RADIO = collectionDisc("stardew_valley_professor_snails_radio", "Stardew Valley", ZAMJukeboxSongs.STARDEW_VALLEY_PROFESSOR_SNAILS_RADIO, Rarity.RARE);
    public static final Item STARDEW_VALLEY_SUMMIT_CELEBRATION = collectionDisc("stardew_valley_summit_celebration", "Stardew Valley", ZAMJukeboxSongs.STARDEW_VALLEY_SUMMIT_CELEBRATION, Rarity.EPIC);

    //Undertale (18)
    public static final Item UNDERTALE_CASE = collectionCase("undertale_case");
    public static final Item UNDERTALE_UNDERTALE = collectionDisc("undertale_undertale", "Undertale", ZAMJukeboxSongs.UNDERTALE_UNDERTALE, Rarity.RARE);
    public static final Item UNDERTALE_FALLEN_DOWN = collectionDisc("undertale_fallen_down", "Undertale", ZAMJukeboxSongs.UNDERTALE_FALLEN_DOWN, Rarity.UNCOMMON);
    public static final Item UNDERTALE_RUINS = collectionDisc("undertale_ruins", "Undertale", ZAMJukeboxSongs.UNDERTALE_RUINS, Rarity.UNCOMMON);
    public static final Item UNDERTALE_HOME = collectionDisc("undertale_home", "Undertale", ZAMJukeboxSongs.UNDERTALE_HOME, Rarity.UNCOMMON);
    public static final Item UNDERTALE_HEARTACHE = collectionDisc("undertale_heartache", "Undertale", ZAMJukeboxSongs.UNDERTALE_HEARTACHE, Rarity.EPIC);
    public static final Item UNDERTALE_SANS = collectionDisc("undertale_sans", "Undertale", ZAMJukeboxSongs.UNDERTALE_SANS, Rarity.RARE);
    public static final Item UNDERTALE_SNOWY = collectionDisc("undertale_snowy", "Undertale", ZAMJukeboxSongs.UNDERTALE_SNOWY, Rarity.UNCOMMON);
    public static final Item UNDERTALE_DOGSONG = collectionDisc("undertale_dogsong", "Undertale", ZAMJukeboxSongs.UNDERTALE_DOGSONG, Rarity.UNCOMMON);
    public static final Item UNDERTALE_SHOP = collectionDisc("undertale_shop", "Undertale", ZAMJukeboxSongs.UNDERTALE_SHOP, Rarity.UNCOMMON);
    public static final Item UNDERTALE_BONETROUSLE = collectionDisc("undertale_bonetrousle", "Undertale", ZAMJukeboxSongs.UNDERTALE_BONETROUSLE, Rarity.EPIC);
    public static final Item UNDERTALE_DUMMY = collectionDisc("undertale_dummy", "Undertale", ZAMJukeboxSongs.UNDERTALE_DUMMY, Rarity.RARE);
    public static final Item UNDERTALE_SPEAR_OF_JUSTICE = collectionDisc("undertale_spear_of_justice", "Undertale", ZAMJukeboxSongs.UNDERTALE_SPEAR_OF_JUSTICE, Rarity.EPIC);
    public static final Item UNDERTALE_ANOTHER_MEDIUM = collectionDisc("undertale_another_medium", "Undertale", ZAMJukeboxSongs.UNDERTALE_ANOTHER_MEDIUM, Rarity.UNCOMMON);
    public static final Item UNDERTALE_SPIDER_DANCE = collectionDisc("undertale_spider_dance", "Undertale", ZAMJukeboxSongs.UNDERTALE_SPIDER_DANCE, Rarity.RARE);
    public static final Item UNDERTALE_ITS_RAINING_SOMEWHERE_ELSE = collectionDisc("undertale_its_raining_somewhere_else", "Undertale", ZAMJukeboxSongs.UNDERTALE_ITS_RAINING_SOMEWHERE_ELSE, Rarity.RARE);
    public static final Item UNDERTALE_DEATH_BY_GLAMOUR = collectionDisc("undertale_death_by_glamour", "Undertale", ZAMJukeboxSongs.UNDERTALE_DEATH_BY_GLAMOUR, Rarity.EPIC);
    public static final Item UNDERTALE_ASGORE = collectionDisc("undertale_asgore", "Undertale", ZAMJukeboxSongs.UNDERTALE_ASGORE, Rarity.EPIC);
    public static final Item UNDERTALE_FINALE = collectionDisc("undertale_finale", "Undertale", ZAMJukeboxSongs.UNDERTALE_FINALE, Rarity.EPIC);
    public static final Item UNDERTALE_HOPES_AND_DREAMS = collectionDisc("undertale_hopes_and_dreams", "Undertale", ZAMJukeboxSongs.UNDERTALE_HOPES_AND_DREAMS, Rarity.EPIC);
    public static final Item UNDERTALE_MEGALOVANIA = collectionDisc("undertale_megalovania", "Undertale", ZAMJukeboxSongs.UNDERTALE_MEGALOVANIA, Rarity.EPIC);

    public static ResourceKey<Item> getRK(Item item) {
        return BuiltInRegistries.ITEM.getResourceKey(item).get();
    }

    public static Item registerItem(String name, Function<Item.Properties, Item> factory) {
        Identifier id = ZAMMod.id(name);
        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, id);
        Item item = factory.apply(new Item.Properties().setId(key));

        return Registry.register(BuiltInRegistries.ITEM, id, item);
    }

    private static Item collectionDisc(String name, String setName, ResourceKey<JukeboxSong> song, Rarity rarity) {
        Item disc = registerItem(name, properties -> new CaseRewardItem(setName, properties.stacksTo(1).jukeboxPlayable(song).rarity(rarity)));
        COLLECTION_DISCS.add(disc);
        return disc;
    }

    public static List<Item> collectionDiscs() {
        return List.copyOf(COLLECTION_DISCS);
    }

    private static Item collectionCase(String name) {
        Item caseItem = registerItem(name, properties -> new CaseItem(properties.rarity(Rarity.UNCOMMON)));
        COLLECTION_CASES.add(caseItem);
        return caseItem;
    }

    public static List<Item> collectionCases() {
        return List.copyOf(COLLECTION_CASES);
    }

    public static void registerItems() {
        ZAMMod.LOGGER.info("Registering Items for {}", ZAMMod.MOD_ID);
    }
}

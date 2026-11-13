package net.ron.zam.registry;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Util;
import net.minecraft.world.item.JukeboxSong;
import net.ron.zam.ZAMMod;

public class ZAMJukeboxSongs {

    public static final ResourceKey<JukeboxSong> DOG = create("minecraft_dog");

    //Castle Crashers
    public static final ResourceKey<JukeboxSong> CASTLE_CRASHERS_FOUR_BRAVE_CHAMPS = create("castle_crashers_four_brave_champs");
    public static final ResourceKey<JukeboxSong> CASTLE_CRASHERS_FLUTEY = create("castle_crashers_flutey");
    public static final ResourceKey<JukeboxSong> CASTLE_CRASHERS_SPANISH_WALTZ = create("castle_crashers_spanish_waltz");
    public static final ResourceKey<JukeboxSong> CASTLE_CRASHERS_RACE_AROUND_THE_WORLD = create("castle_crashers_race_around_the_world");
    public static final ResourceKey<JukeboxSong> CASTLE_CRASHERS_JUMPER = create("castle_crashers_jumper");
    public static final ResourceKey<JukeboxSong> CASTLE_CRASHERS_SPACE_PIRATES = create("castle_crashers_space_pirates");
    public static final ResourceKey<JukeboxSong> CASTLE_CRASHERS_THE_SHOW = create("castle_crashers_the_show");
    public static final ResourceKey<JukeboxSong> CASTLE_CRASHERS_DARK_SKIES = create("castle_crashers_dark_skies");
    public static final ResourceKey<JukeboxSong> CASTLE_CRASHERS_RAGE_CHAMPIONS = create("castle_crashers_rage_champions");
    public static final ResourceKey<JukeboxSong> CASTLE_CRASHERS_PLEASE_DONT = create("castle_crashers_please_dont");
    public static final ResourceKey<JukeboxSong> CASTLE_CRASHERS_THE_ABDUCTION = create("castle_crashers_the_abduction");
    public static final ResourceKey<JukeboxSong> CASTLE_CRASHERS_WINTER_BLISS = create("castle_crashers_winter_bliss");
    public static final ResourceKey<JukeboxSong> CASTLE_CRASHERS_SIMPLE_SIGHT = create("castle_crashers_simple_sight");
    public static final ResourceKey<JukeboxSong> CASTLE_CRASHERS_FINAL_CONFRONTATION = create("castle_crashers_final_confrontation");
    public static final ResourceKey<JukeboxSong> CASTLE_CRASHERS_ARCHETYPE = create("castle_crashers_archetype");
    public static final ResourceKey<JukeboxSong> CASTLE_CRASHERS_BATTLEBLOCK = create("castle_crashers_battleblock");
    public static final ResourceKey<JukeboxSong> CASTLE_CRASHERS_BARRACKS_SONG = create("castle_crashers_barracks_song");
    public static final ResourceKey<JukeboxSong> CASTLE_CRASHERS_CHAOZ_JAPAN = create("castle_crashers_chaoz_japan");
    public static final ResourceKey<JukeboxSong> CASTLE_CRASHERS_FLOODED_CASTLE = create("castle_crashers_flooded_castle");

    //Minecraft
    public static final ResourceKey<JukeboxSong> MINECRAFT_SUBWOOFER_LULLABY = create("minecraft_subwoofer_lullaby");
    public static final ResourceKey<JukeboxSong> MINECRAFT_HAGGSTROM = create("minecraft_haggstrom");
    public static final ResourceKey<JukeboxSong> MINECRAFT_MINECRAFT = create("minecraft_minecraft");
    public static final ResourceKey<JukeboxSong> MINECRAFT_MICE_ON_VENUS = create("minecraft_mice_on_venus");
    public static final ResourceKey<JukeboxSong> MINECRAFT_SWEDEN = create("minecraft_sweden");
    public static final ResourceKey<JukeboxSong> MINECRAFT_ARIA_MATH = create("minecraft_aria_math");
    public static final ResourceKey<JukeboxSong> MINECRAFT_HALLAND = create("minecraft_halland");
    public static final ResourceKey<JukeboxSong> MINECRAFT_DALARNA = create("minecraft_dalarna");

    //Spongebob
    public static final ResourceKey<JukeboxSong> SPONGEBOB_KRUSTY_KRAB = create("spongebob_krusty_krab");
    public static final ResourceKey<JukeboxSong> SPONGEBOB_THE_LINEMAN = create("spongebob_the_lineman");
    public static final ResourceKey<JukeboxSong> SPONGEBOB_PUKA_A = create("spongebob_puka_a");
    public static final ResourceKey<JukeboxSong> SPONGEBOB_AWARD_WINNERS_A = create("spongebob_award_winners_a");
    public static final ResourceKey<JukeboxSong> SPONGEBOB_ANDY_ANNORAK = create("spongebob_andy_annorak");
    public static final ResourceKey<JukeboxSong> SPONGEBOB_SWEET_VICTORY = create("spongebob_sweet_victory");
    public static final ResourceKey<JukeboxSong> SPONGEBOB_JELLYFISH_JAM = create("spongebob_jellyfish_jam");
    public static final ResourceKey<JukeboxSong> SPONGEBOB_THE_RAKE = create("spongebob_the_rake");
    public static final ResourceKey<JukeboxSong> SPONGEBOB_HAWAIIAN_TRAIN = create("spongebob_hawaiian_train");
    public static final ResourceKey<JukeboxSong> SPONGEBOB_GARYS_SONG = create("spongebob_garys_song");
    public static final ResourceKey<JukeboxSong> SPONGEBOB_CHILL_OUT = create("spongebob_chill_out");
    public static final ResourceKey<JukeboxSong> SPONGEBOB_MAUI_BEACH = create("spongebob_maui_beach");
    public static final ResourceKey<JukeboxSong> SPONGEBOB_ME_FOR_YOU = create("spongebob_me_for_you");
    public static final ResourceKey<JukeboxSong> SPONGEBOB_SURF_BUGGY = create("spongebob_surf_buggy");
    public static final ResourceKey<JukeboxSong> SPONGEBOB_DRUNKEN_SAILOR = create("spongebob_drunken_sailor");
    public static final ResourceKey<JukeboxSong> SPONGEBOB_CHA_CHA_NOVA = create("spongebob_cha_cha_nova");
    public static final ResourceKey<JukeboxSong> SPONGEBOB_KELPY_G = create("spongebob_kelpy_g");
    public static final ResourceKey<JukeboxSong> SPONGEBOB_THEME_SONG = create("spongebob_theme_song");
    public static final ResourceKey<JukeboxSong> SPONGEBOB_CHRISTMAS = create("spongebob_christmas");

    //Stardew Valley
    public static final ResourceKey<JukeboxSong> STARDEW_VALLEY_OVERTURE = create("stardew_valley_overture");
    public static final ResourceKey<JukeboxSong> STARDEW_VALLEY_SPRING = create("stardew_valley_spring");
    public static final ResourceKey<JukeboxSong> STARDEW_VALLEY_SPRING_2 = create("stardew_valley_spring_2");
    public static final ResourceKey<JukeboxSong> STARDEW_VALLEY_SPRING_3 = create("stardew_valley_spring_3");
    public static final ResourceKey<JukeboxSong> STARDEW_VALLEY_PELICAN_TOWN = create("stardew_valley_pelican_town");
    public static final ResourceKey<JukeboxSong> STARDEW_VALLEY_DISTANT_BANJO = create("stardew_valley_distant_banjo");
    public static final ResourceKey<JukeboxSong> STARDEW_VALLEY_SUMMER = create("stardew_valley_summer");
    public static final ResourceKey<JukeboxSong> STARDEW_VALLEY_SUMMER_2 = create("stardew_valley_summer_2");
    public static final ResourceKey<JukeboxSong> STARDEW_VALLEY_SUMMER_3 = create("stardew_valley_summer_3");
    public static final ResourceKey<JukeboxSong> STARDEW_VALLEY_ADVENTURE_GUILD = create("stardew_valley_adventure_guild");
    public static final ResourceKey<JukeboxSong> STARDEW_VALLEY_STARDROP_SALOON = create("stardew_valley_stardrop_saloon");
    public static final ResourceKey<JukeboxSong> STARDEW_VALLEY_LUAU_FESTIVAL = create("stardew_valley_luau_festival");
    public static final ResourceKey<JukeboxSong> STARDEW_VALLEY_MOONLIGHT_JELLYFISH = create("stardew_valley_moonlight_jellyfish");
    public static final ResourceKey<JukeboxSong> STARDEW_VALLEY_FALL = create("stardew_valley_fall");
    public static final ResourceKey<JukeboxSong> STARDEW_VALLEY_FALL_2 = create("stardew_valley_fall_2");
    public static final ResourceKey<JukeboxSong> STARDEW_VALLEY_FALL_3 = create("stardew_valley_fall_3");
    public static final ResourceKey<JukeboxSong> STARDEW_VALLEY_LIBRARY = create("stardew_valley_library");
    public static final ResourceKey<JukeboxSong> STARDEW_VALLEY_FAIR = create("stardew_valley_fair");
    public static final ResourceKey<JukeboxSong> STARDEW_VALLEY_SPIRITS_EVE = create("stardew_valley_spirits_eve");
    public static final ResourceKey<JukeboxSong> STARDEW_VALLEY_WINTER = create("stardew_valley_winter");
    public static final ResourceKey<JukeboxSong> STARDEW_VALLEY_WINTER_2 = create("stardew_valley_winter_2");
    public static final ResourceKey<JukeboxSong> STARDEW_VALLEY_WINTER_3 = create("stardew_valley_winter_3");
    public static final ResourceKey<JukeboxSong> STARDEW_VALLEY_WINTER_FESTIVAL = create("stardew_valley_winter_festival");
    public static final ResourceKey<JukeboxSong> STARDEW_VALLEY_COUNTRY_SHOP = create("stardew_valley_country_shop");
    public static final ResourceKey<JukeboxSong> STARDEW_VALLEY_CALICO_DESERT = create("stardew_valley_calico_desert");
    public static final ResourceKey<JukeboxSong> STARDEW_VALLEY_CRYSTAL_BELLS = create("stardew_valley_crystal_bells");
    public static final ResourceKey<JukeboxSong> STARDEW_VALLEY_FLICKER = create("stardew_valley_flicker");
    public static final ResourceKey<JukeboxSong> STARDEW_VALLEY_DEEP_WOODS = create("stardew_valley_deep_woods");
    public static final ResourceKey<JukeboxSong> STARDEW_VALLEY_NIGHT_MARKET = create("stardew_valley_night_market");
    public static final ResourceKey<JukeboxSong> STARDEW_VALLEY_SUBMARINE = create("stardew_valley_submarine");
    public static final ResourceKey<JukeboxSong> STARDEW_VALLEY_MOVIE_THEATER = create("stardew_valley_movie_theater");
    public static final ResourceKey<JukeboxSong> STARDEW_VALLEY_GINGER_ISLAND = create("stardew_valley_ginger_island");
    public static final ResourceKey<JukeboxSong> STARDEW_VALLEY_LEOS_SONG = create("stardew_valley_leos_song");
    public static final ResourceKey<JukeboxSong> STARDEW_VALLEY_SUMMIT_CELEBRATION = create("stardew_valley_summit_celebration");
    public static final ResourceKey<JukeboxSong> STARDEW_VALLEY_PROFESSOR_SNAILS_RADIO = create("stardew_valley_professor_snails_radio");

    //Undertale
    public static final ResourceKey<JukeboxSong> UNDERTALE_UNDERTALE = create("undertale_undertale");
    public static final ResourceKey<JukeboxSong> UNDERTALE_FALLEN_DOWN = create("undertale_fallen_down");
    public static final ResourceKey<JukeboxSong> UNDERTALE_RUINS = create("undertale_ruins");
    public static final ResourceKey<JukeboxSong> UNDERTALE_HOME = create("undertale_home");
    public static final ResourceKey<JukeboxSong> UNDERTALE_HEARTACHE = create("undertale_heartache");
    public static final ResourceKey<JukeboxSong> UNDERTALE_SANS = create("undertale_sans");
    public static final ResourceKey<JukeboxSong> UNDERTALE_SNOWY = create("undertale_snowy");
    public static final ResourceKey<JukeboxSong> UNDERTALE_DOGSONG = create("undertale_dogsong");
    public static final ResourceKey<JukeboxSong> UNDERTALE_SHOP = create("undertale_shop");
    public static final ResourceKey<JukeboxSong> UNDERTALE_BONETROUSLE = create("undertale_bonetrousle");
    public static final ResourceKey<JukeboxSong> UNDERTALE_DUMMY = create("undertale_dummy");
    public static final ResourceKey<JukeboxSong> UNDERTALE_SPEAR_OF_JUSTICE = create("undertale_spear_of_justice");
    public static final ResourceKey<JukeboxSong> UNDERTALE_ANOTHER_MEDIUM = create("undertale_another_medium");
    public static final ResourceKey<JukeboxSong> UNDERTALE_SPIDER_DANCE = create("undertale_spider_dance");
    public static final ResourceKey<JukeboxSong> UNDERTALE_ITS_RAINING_SOMEWHERE_ELSE = create("undertale_its_raining_somewhere_else");
    public static final ResourceKey<JukeboxSong> UNDERTALE_DEATH_BY_GLAMOUR = create("undertale_death_by_glamour");
    public static final ResourceKey<JukeboxSong> UNDERTALE_ASGORE = create("undertale_asgore");
    public static final ResourceKey<JukeboxSong> UNDERTALE_FINALE = create("undertale_finale");
    public static final ResourceKey<JukeboxSong> UNDERTALE_HOPES_AND_DREAMS = create("undertale_hopes_and_dreams");
    public static final ResourceKey<JukeboxSong> UNDERTALE_MEGALOVANIA = create("undertale_megalovania");

    public static void bootstrap(BootstrapContext<JukeboxSong> context) {
        register(context, DOG, ZAMSounds.MUSIC_DISC_DOG, 145, 6);

        //Castle Crashers
        register(context, CASTLE_CRASHERS_FOUR_BRAVE_CHAMPS, ZAMSounds.CASTLE_CRASHERS_FOUR_BRAVE_CHAMPS, 170, 1);
        register(context, CASTLE_CRASHERS_FLUTEY, ZAMSounds.CASTLE_CRASHERS_FLUTEY, 76, 1);
        register(context, CASTLE_CRASHERS_SPANISH_WALTZ, ZAMSounds.CASTLE_CRASHERS_SPANISH_WALTZ, 91, 1);
        register(context, CASTLE_CRASHERS_RACE_AROUND_THE_WORLD, ZAMSounds.CASTLE_CRASHERS_RACE_AROUND_THE_WORLD, 66, 1);
        register(context, CASTLE_CRASHERS_JUMPER, ZAMSounds.CASTLE_CRASHERS_JUMPER, 100, 1);
        register(context, CASTLE_CRASHERS_SPACE_PIRATES, ZAMSounds.CASTLE_CRASHERS_SPACE_PIRATES, 167, 1);
        register(context, CASTLE_CRASHERS_THE_SHOW, ZAMSounds.CASTLE_CRASHERS_THE_SHOW, 171, 1);
        register(context, CASTLE_CRASHERS_DARK_SKIES, ZAMSounds.CASTLE_CRASHERS_DARK_SKIES, 208, 1);
        register(context, CASTLE_CRASHERS_RAGE_CHAMPIONS, ZAMSounds.CASTLE_CRASHERS_RAGE_CHAMPIONS, 151, 1);
        register(context, CASTLE_CRASHERS_PLEASE_DONT, ZAMSounds.CASTLE_CRASHERS_PLEASE_DONT, 210, 1);
        register(context, CASTLE_CRASHERS_WINTER_BLISS, ZAMSounds.CASTLE_CRASHERS_WINTER_BLISS, 185, 1);
        register(context, CASTLE_CRASHERS_SIMPLE_SIGHT, ZAMSounds.CASTLE_CRASHERS_SIMPLE_SIGHT, 211, 1);
        register(context, CASTLE_CRASHERS_FINAL_CONFRONTATION, ZAMSounds.CASTLE_CRASHERS_FINAL_CONFRONTATION, 134, 1);
        register(context, CASTLE_CRASHERS_ARCHETYPE, ZAMSounds.CASTLE_CRASHERS_ARCHETYPE, 242, 1);
        register(context, CASTLE_CRASHERS_BATTLEBLOCK, ZAMSounds.CASTLE_CRASHERS_BATTLEBLOCK, 240, 1);
        register(context, CASTLE_CRASHERS_THE_ABDUCTION, ZAMSounds.CASTLE_CRASHERS_THE_ABDUCTION, 170, 1);
        register(context, CASTLE_CRASHERS_BARRACKS_SONG, ZAMSounds.CASTLE_CRASHERS_BARRACKS_SONG, 139, 1);
        register(context, CASTLE_CRASHERS_CHAOZ_JAPAN, ZAMSounds.CASTLE_CRASHERS_CHAOZ_JAPAN, 91, 1);
        register(context, CASTLE_CRASHERS_FLOODED_CASTLE, ZAMSounds.CASTLE_CRASHERS_FLOODED_CASTLE, 117, 1);
        
        //Minecraft
        register(context, MINECRAFT_SUBWOOFER_LULLABY, ZAMSounds.MINECRAFT_SUBWOOFER_LULLABY, 209, 5);
        register(context, MINECRAFT_HAGGSTROM, ZAMSounds.MINECRAFT_HAGGSTROM, 191, 2);
        register(context, MINECRAFT_MINECRAFT, ZAMSounds.MINECRAFT_MINECRAFT, 260, 1);
        register(context, MINECRAFT_MICE_ON_VENUS, ZAMSounds.MINECRAFT_MICE_ON_VENUS, 145, 6);
        register(context, MINECRAFT_SWEDEN, ZAMSounds.MINECRAFT_SWEDEN, 229, 7);
        register(context, MINECRAFT_ARIA_MATH, ZAMSounds.MINECRAFT_ARIA_MATH, 310, 8);
        register(context, MINECRAFT_HALLAND, ZAMSounds.MINECRAFT_HALLAND, 296, 3);
        register(context, MINECRAFT_DALARNA, ZAMSounds.MINECRAFT_DALARNA, 212, 4);

        //Spongebob
        register(context, SPONGEBOB_KRUSTY_KRAB, ZAMSounds.SPONGEBOB_KRUSTY_KRAB, 147, 6);
        register(context, SPONGEBOB_THE_LINEMAN, ZAMSounds.SPONGEBOB_THE_LINEMAN, 156, 6);
        register(context, SPONGEBOB_PUKA_A, ZAMSounds.SPONGEBOB_PUKA_A, 71, 6);
        register(context, SPONGEBOB_AWARD_WINNERS_A, ZAMSounds.SPONGEBOB_AWARD_WINNERS_A, 48, 6);
        register(context, SPONGEBOB_ANDY_ANNORAK, ZAMSounds.SPONGEBOB_ANDY_ANNORAK, 154, 6);
        register(context, SPONGEBOB_SWEET_VICTORY, ZAMSounds.SPONGEBOB_SWEET_VICTORY, 126, 6);
        register(context, SPONGEBOB_JELLYFISH_JAM, ZAMSounds.SPONGEBOB_JELLYFISH_JAM, 67, 6);
        register(context, SPONGEBOB_THE_RAKE, ZAMSounds.SPONGEBOB_THE_RAKE, 150, 6);
        register(context, SPONGEBOB_HAWAIIAN_TRAIN, ZAMSounds.SPONGEBOB_HAWAIIAN_TRAIN, 75, 6);
        register(context, SPONGEBOB_GARYS_SONG, ZAMSounds.SPONGEBOB_GARYS_SONG, 144, 6);
        register(context, SPONGEBOB_CHILL_OUT, ZAMSounds.SPONGEBOB_CHILL_OUT, 194, 6);
        register(context, SPONGEBOB_MAUI_BEACH, ZAMSounds.SPONGEBOB_MAUI_BEACH, 143, 6);
        register(context, SPONGEBOB_ME_FOR_YOU, ZAMSounds.SPONGEBOB_ME_FOR_YOU, 170, 6);
        register(context, SPONGEBOB_SURF_BUGGY, ZAMSounds.SPONGEBOB_SURF_BUGGY, 159, 6);
        register(context, SPONGEBOB_DRUNKEN_SAILOR, ZAMSounds.SPONGEBOB_DRUNKEN_SAILOR, 162, 6);
        register(context, SPONGEBOB_CHA_CHA_NOVA, ZAMSounds.SPONGEBOB_CHA_CHA_NOVA, 170, 6);
        register(context, SPONGEBOB_KELPY_G, ZAMSounds.SPONGEBOB_KELPY_G, 61, 6);
        register(context, SPONGEBOB_CHRISTMAS, ZAMSounds.SPONGEBOB_CHRISTMAS, 116, 6);
        register(context, SPONGEBOB_THEME_SONG, ZAMSounds.SPONGEBOB_THEME_SONG, 44, 6);

        //Stardew Valley
        register(context, STARDEW_VALLEY_OVERTURE, ZAMSounds.STARDEW_VALLEY_OVERTURE, 144, 1);
        register(context, STARDEW_VALLEY_SPRING, ZAMSounds.STARDEW_VALLEY_SPRING, 242, 2);
        register(context, STARDEW_VALLEY_SPRING_2, ZAMSounds.STARDEW_VALLEY_SPRING_2, 238, 2);
        register(context, STARDEW_VALLEY_SPRING_3, ZAMSounds.STARDEW_VALLEY_SPRING_3, 262, 2);
        register(context, STARDEW_VALLEY_PELICAN_TOWN, ZAMSounds.STARDEW_VALLEY_PELICAN_TOWN, 170, 2);
        register(context, STARDEW_VALLEY_DISTANT_BANJO, ZAMSounds.STARDEW_VALLEY_DISTANT_BANJO, 114, 1);
        register(context, STARDEW_VALLEY_SUMMER, ZAMSounds.STARDEW_VALLEY_SUMMER, 214, 2);
        register(context, STARDEW_VALLEY_SUMMER_2, ZAMSounds.STARDEW_VALLEY_SUMMER_2, 210, 2);
        register(context, STARDEW_VALLEY_SUMMER_3, ZAMSounds.STARDEW_VALLEY_SUMMER_3, 204, 2);
        register(context, STARDEW_VALLEY_ADVENTURE_GUILD, ZAMSounds.STARDEW_VALLEY_ADVENTURE_GUILD, 51, 2);
        register(context, STARDEW_VALLEY_STARDROP_SALOON, ZAMSounds.STARDEW_VALLEY_STARDROP_SALOON, 84, 2);
        register(context, STARDEW_VALLEY_LUAU_FESTIVAL, ZAMSounds.STARDEW_VALLEY_LUAU_FESTIVAL, 91, 2);
        register(context, STARDEW_VALLEY_MOONLIGHT_JELLYFISH, ZAMSounds.STARDEW_VALLEY_MOONLIGHT_JELLYFISH, 140, 1);
        register(context, STARDEW_VALLEY_FALL, ZAMSounds.STARDEW_VALLEY_FALL, 215, 2);
        register(context, STARDEW_VALLEY_FALL_2, ZAMSounds.STARDEW_VALLEY_FALL_2, 159, 2);
        register(context, STARDEW_VALLEY_FALL_3, ZAMSounds.STARDEW_VALLEY_FALL_3, 172, 2);
        register(context, STARDEW_VALLEY_LIBRARY, ZAMSounds.STARDEW_VALLEY_LIBRARY, 108, 1);
        register(context, STARDEW_VALLEY_FAIR, ZAMSounds.STARDEW_VALLEY_FAIR, 111, 1);
        register(context, STARDEW_VALLEY_SPIRITS_EVE, ZAMSounds.STARDEW_VALLEY_SPIRITS_EVE, 123, 2);
        register(context, STARDEW_VALLEY_WINTER, ZAMSounds.STARDEW_VALLEY_WINTER, 197, 2);
        register(context, STARDEW_VALLEY_WINTER_2, ZAMSounds.STARDEW_VALLEY_WINTER_2, 197, 2);
        register(context, STARDEW_VALLEY_WINTER_3, ZAMSounds.STARDEW_VALLEY_WINTER_3, 187, 2);
        register(context, STARDEW_VALLEY_WINTER_FESTIVAL, ZAMSounds.STARDEW_VALLEY_WINTER_FESTIVAL, 160, 2);
        register(context, STARDEW_VALLEY_COUNTRY_SHOP, ZAMSounds.STARDEW_VALLEY_COUNTRY_SHOP, 140, 1);
        register(context, STARDEW_VALLEY_CALICO_DESERT, ZAMSounds.STARDEW_VALLEY_CALICO_DESERT, 127, 2);
        register(context, STARDEW_VALLEY_CRYSTAL_BELLS, ZAMSounds.STARDEW_VALLEY_CRYSTAL_BELLS, 171, 1);
        register(context, STARDEW_VALLEY_FLICKER, ZAMSounds.STARDEW_VALLEY_FLICKER, 83, 1);
        register(context, STARDEW_VALLEY_DEEP_WOODS, ZAMSounds.STARDEW_VALLEY_DEEP_WOODS, 127, 2);
        register(context, STARDEW_VALLEY_NIGHT_MARKET, ZAMSounds.STARDEW_VALLEY_NIGHT_MARKET, 131, 2);
        register(context, STARDEW_VALLEY_SUBMARINE, ZAMSounds.STARDEW_VALLEY_SUBMARINE, 123, 1);
        register(context, STARDEW_VALLEY_MOVIE_THEATER, ZAMSounds.STARDEW_VALLEY_MOVIE_THEATER, 105, 2);
        register(context, STARDEW_VALLEY_GINGER_ISLAND, ZAMSounds.STARDEW_VALLEY_GINGER_ISLAND, 158, 2);
        register(context, STARDEW_VALLEY_LEOS_SONG, ZAMSounds.STARDEW_VALLEY_LEOS_SONG, 97, 1);
        register(context, STARDEW_VALLEY_SUMMIT_CELEBRATION, ZAMSounds.STARDEW_VALLEY_SUMMIT_CELEBRATION, 180, 1);
        register(context, STARDEW_VALLEY_PROFESSOR_SNAILS_RADIO, ZAMSounds.STARDEW_VALLEY_PROFESSOR_SNAILS_RADIO, 89, 1);

        //Undertale
        register(context, UNDERTALE_UNDERTALE, ZAMSounds.UNDERTALE_UNDERTALE, 380, 1);
        register(context, UNDERTALE_FALLEN_DOWN, ZAMSounds.UNDERTALE_FALLEN_DOWN, 57, 1);
        register(context, UNDERTALE_RUINS, ZAMSounds.UNDERTALE_RUINS, 91, 1);
        register(context, UNDERTALE_HOME, ZAMSounds.UNDERTALE_HOME, 123, 1);
        register(context, UNDERTALE_HEARTACHE, ZAMSounds.UNDERTALE_HEARTACHE, 108, 1);
        register(context, UNDERTALE_SANS, ZAMSounds.UNDERTALE_SANS, 50, 1);
        register(context, UNDERTALE_SNOWY, ZAMSounds.UNDERTALE_SNOWY, 101, 1);
        register(context, UNDERTALE_DOGSONG, ZAMSounds.UNDERTALE_DOGSONG, 37, 1);
        register(context, UNDERTALE_SHOP, ZAMSounds.UNDERTALE_SHOP, 50, 1);
        register(context, UNDERTALE_BONETROUSLE, ZAMSounds.UNDERTALE_BONETROUSLE, 57, 1);
        register(context, UNDERTALE_DUMMY, ZAMSounds.UNDERTALE_DUMMY, 146, 1);
        register(context, UNDERTALE_SPEAR_OF_JUSTICE, ZAMSounds.UNDERTALE_SPEAR_OF_JUSTICE, 115, 1);
        register(context, UNDERTALE_ANOTHER_MEDIUM, ZAMSounds.UNDERTALE_ANOTHER_MEDIUM, 141, 1);
        register(context, UNDERTALE_SPIDER_DANCE, ZAMSounds.UNDERTALE_SPIDER_DANCE, 106, 1);
        register(context, UNDERTALE_ITS_RAINING_SOMEWHERE_ELSE, ZAMSounds.UNDERTALE_ITS_RAINING_SOMEWHERE_ELSE, 166, 1);
        register(context, UNDERTALE_DEATH_BY_GLAMOUR, ZAMSounds.UNDERTALE_DEATH_BY_GLAMOUR, 13, 1);
        register(context, UNDERTALE_ASGORE, ZAMSounds.UNDERTALE_ASGORE, 155, 1);
        register(context, UNDERTALE_FINALE, ZAMSounds.UNDERTALE_FINALE, 112, 1);
        register(context, UNDERTALE_HOPES_AND_DREAMS, ZAMSounds.UNDERTALE_HOPES_AND_DREAMS, 180, 1);
        register(context, UNDERTALE_MEGALOVANIA, ZAMSounds.UNDERTALE_MEGALOVANIA, 156, 1);
    }

    private static void register(BootstrapContext<JukeboxSong> context, ResourceKey<JukeboxSong> key, SoundEvent soundEvent, int lengthInSeconds, int comparatorOutput) {
        context.register(key, new JukeboxSong(Holder.direct(soundEvent),
                Component.translatable(Util.makeDescriptionId("jukebox_song", key.identifier())),
                (float) lengthInSeconds, comparatorOutput));
    }

    private static ResourceKey<JukeboxSong> create(String name) {
        return ResourceKey.create(Registries.JUKEBOX_SONG, ZAMMod.id(name));
    }
}

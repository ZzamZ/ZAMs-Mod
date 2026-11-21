package net.ron.zam.registry;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.ron.zam.ZAMMod;
import net.ron.zam.util.casesystem.CaseRewards;
import net.ron.zam.util.casesystem.rarity.Rarity;
import net.ron.zam.util.casesystem.rarity.RarityItem;
import net.ron.zam.util.cosmetic.CosmeticPatterns;

import java.util.List;

public final class ZAMCaseRewards {
    public static final Identifier CASTLE_CRASHERS_CASE = ZAMMod.id("castle_crashers_case");
    public static final Identifier COD_ZOMBIES_CASE = ZAMMod.id("cod_zombies_case");
    public static final Identifier MINECRAFT_CASE = ZAMMod.id("minecraft_case");
    public static final Identifier SPONGEBOB_CASE = ZAMMod.id("spongebob_case");
    public static final Identifier STARDEW_VALLEY_CASE = ZAMMod.id("stardew_valley_case");
    public static final Identifier UNDERTALE_CASE = ZAMMod.id("undertale_case");

    public static void registerCaseRewards() {
        CaseRewards.registerDeferred(CASTLE_CRASHERS_CASE, () -> List.of(
                        new RarityItem(new ItemStack(ZAMItems.CASTLE_CRASHERS_FOUR_BRAVE_CHAMPS), Rarity.COMMON),
                        new RarityItem(new ItemStack(ZAMItems.CASTLE_CRASHERS_BARRACKS_SONG), Rarity.COMMON),
                        new RarityItem(new ItemStack(ZAMItems.CASTLE_CRASHERS_FLUTEY), Rarity.COMMON),
                        new RarityItem(new ItemStack(ZAMItems.CASTLE_CRASHERS_SPANISH_WALTZ), Rarity.COMMON),
                        new RarityItem(new ItemStack(ZAMItems.CASTLE_CRASHERS_RACE_AROUND_THE_WORLD), Rarity.COMMON),
                        new RarityItem(new ItemStack(ZAMItems.CASTLE_CRASHERS_PLEASE_DONT), Rarity.COMMON),
                        new RarityItem(new ItemStack(ZAMItems.CASTLE_CRASHERS_FLOODED_CASTLE), Rarity.COMMON),
                        new RarityItem(new ItemStack(ZAMItems.CASTLE_CRASHERS_WINTER_BLISS), Rarity.COMMON),

                        new RarityItem(new ItemStack(ZAMItems.CASTLE_CRASHERS_THE_SHOW), Rarity.UNCOMMON),
                        new RarityItem(new ItemStack(ZAMItems.CASTLE_CRASHERS_CHAOZ_JAPAN), Rarity.UNCOMMON),
                        new RarityItem(new ItemStack(ZAMItems.CASTLE_CRASHERS_SIMPLE_SIGHT), Rarity.UNCOMMON),
                        new RarityItem(new ItemStack(ZAMItems.CASTLE_CRASHERS_FINAL_CONFRONTATION), Rarity.UNCOMMON),
                        new RarityItem(new ItemStack(ZAMItems.CASTLE_CRASHERS_ARCHETYPE), Rarity.UNCOMMON),

                        RarityItem.choice(List.of(
                                new ItemStack(ZAMItems.CASTLE_CRASHERS_JUMPER),
                                new ItemStack(ZAMItems.CASTLE_CRASHERS_SPACE_PIRATES)), Rarity.RARE),

                        RarityItem.choice(List.of(
                                new ItemStack(ZAMItems.CASTLE_CRASHERS_DARK_SKIES),
                                new ItemStack(ZAMItems.CASTLE_CRASHERS_RAGE_CHAMPIONS)), Rarity.RARE),

                        RarityItem.choice(List.of(
                                new ItemStack(ZAMItems.CASTLE_CRASHERS_THE_ABDUCTION),
                                new ItemStack(ZAMItems.CASTLE_CRASHERS_BATTLEBLOCK)), Rarity.RARE),

                        RarityItem.mystery(new ItemStack(ZAMItems.RED_ICON), List.of(
                                pattern(ZAMCosmetics.CASTLE_CRASHERS_RED_KNIGHT_HELMET),
                                pattern(ZAMCosmetics.CASTLE_CRASHERS_BLUE_KNIGHT_HELMET),
                                pattern(ZAMCosmetics.CASTLE_CRASHERS_GREEN_KNIGHT_HELMET),
                                pattern(ZAMCosmetics.CASTLE_CRASHERS_ORANGE_KNIGHT_HELMET),
                                pattern(ZAMCosmetics.CASTLE_CRASHERS_PURPLE_KNIGHT_HELMET)), Rarity.EPIC),

                        RarityItem.mystery(new ItemStack(ZAMItems.GOLD_ICON), List.of(
                                pattern(ZAMCosmetics.CASTLE_CRASHERS_CHICKEN_SWORD),
                                pattern(ZAMCosmetics.CASTLE_CRASHERS_DEMON_SWORD),
                                pattern(ZAMCosmetics.CASTLE_CRASHERS_UNICORN_SWORD)), Rarity.LEGENDARY)),

                () -> new ItemStack(ZAMBlocks.CASTLE_CRASHERS_COMPLETION_BANNER));

        CaseRewards.registerDeferred(COD_ZOMBIES_CASE, () -> List.of(
                        new RarityItem(new ItemStack(ZAMItems.COD_ZOMBIES_PHD), Rarity.COMMON),
                        new RarityItem(new ItemStack(ZAMItems.COD_ZOMBIES_DEADSHOT), Rarity.COMMON),
                        new RarityItem(new ItemStack(ZAMItems.COD_ZOMBIES_VULTURE_AID), Rarity.COMMON),
                        new RarityItem(new ItemStack(ZAMItems.COD_ZOMBIES_ELEMENTAL_POP), Rarity.COMMON),
                        new RarityItem(new ItemStack(ZAMItems.COD_ZOMBIES_DEATH_PERCEPTION), Rarity.COMMON),
                        new RarityItem(new ItemStack(ZAMItems.COD_ZOMBIES_MELEE_MACCHIATO), Rarity.COMMON),
                        new RarityItem(new ItemStack(ZAMItems.COD_ZOMBIES_WISP_TEA), Rarity.COMMON),

                        new RarityItem(new ItemStack(ZAMItems.COD_ZOMBIES_STAMINUP), Rarity.UNCOMMON),
                        new RarityItem(new ItemStack(ZAMItems.COD_ZOMBIES_MULE_KICK), Rarity.UNCOMMON),
                        new RarityItem(new ItemStack(ZAMItems.COD_ZOMBIES_TOMBSTONE), Rarity.UNCOMMON),
                        new RarityItem(new ItemStack(ZAMItems.COD_ZOMBIES_WHOS_WHO), Rarity.UNCOMMON),
                        new RarityItem(new ItemStack(ZAMItems.COD_ZOMBIES_WIDOWS_WINE), Rarity.UNCOMMON),

                        RarityItem.choice(List.of(
                                new ItemStack(ZAMItems.COD_ZOMBIES_JUGGERNOG),
                                new ItemStack(ZAMItems.COD_ZOMBIES_SOE_JUGGERNOG),
                                new ItemStack(ZAMItems.COD_ZOMBIES_SNAKESKIN_BOOTS),
                                new ItemStack(ZAMItems.COD_ZOMBIES_115)), Rarity.RARE),

                        RarityItem.choice(List.of(
                                new ItemStack(ZAMItems.COD_ZOMBIES_SPEED_COLA),
                                new ItemStack(ZAMItems.COD_ZOMBIES_SOE_SPEED_COLA),
                                new ItemStack(ZAMItems.COD_ZOMBIES_FIRE_SALE),
                                new ItemStack(ZAMItems.COD_ZOMBIES_PACK_A_PUNCH)), Rarity.RARE),

                        RarityItem.choice(List.of(
                                new ItemStack(ZAMItems.COD_ZOMBIES_DOUBLE_TAP),
                                new ItemStack(ZAMItems.COD_ZOMBIES_SOE_DOUBLE_TAP),
                                new ItemStack(ZAMItems.COD_ZOMBIES_DAMNED),
                                new ItemStack(ZAMItems.COD_ZOMBIES_SHEPHERD_OF_FIRE)), Rarity.RARE),

                        RarityItem.choice(List.of(
                                new ItemStack(ZAMItems.COD_ZOMBIES_QUICK_REVIVE),
                                new ItemStack(ZAMItems.COD_ZOMBIES_SOE_QUICK_REVIVE),
                                new ItemStack(ZAMItems.COD_ZOMBIES_SOE_MULE_KICK),
                                new ItemStack(ZAMItems.COD_ZOMBIES_WHERE_ARE_WE_GOING)), Rarity.RARE),

                        RarityItem.mystery(new ItemStack(ZAMItems.RED_ICON), List.of(
                                pattern(ZAMCosmetics.COD_ZOMBIES_MARGWA_MASK),
                                pattern(ZAMCosmetics.COD_ZOMBIES_APOTHICAN_MASK),
                                pattern(ZAMCosmetics.COD_ZOMBIES_FLAMING_SKULL)), Rarity.EPIC),

                        RarityItem.mystery(new ItemStack(ZAMItems.GOLD_ICON), List.of(
                                pattern(ZAMCosmetics.COD_ZOMBIES_APOTHICAN_SWORD),
                                pattern(ZAMCosmetics.COD_ZOMBIES_HELLS_RETRIEVER),
                                pattern(ZAMCosmetics.COD_ZOMBIES_GOLDEN_SPORK),
                                pattern(ZAMCosmetics.COD_ZOMBIES_ICE_STAFF),
                                pattern(ZAMCosmetics.COD_ZOMBIES_WOLF_BOW)), Rarity.LEGENDARY)),

                () -> new ItemStack(ZAMBlocks.COD_ZOMBIES_COMPLETION_BANNER));

        CaseRewards.registerDeferred(MINECRAFT_CASE, () -> List.of(
                new RarityItem(new ItemStack(ZAMItems.MINECRAFT_SUBWOOFER_LULLABY), Rarity.COMMON),
                new RarityItem(new ItemStack(ZAMItems.MINECRAFT_HAGGSTROM), Rarity.COMMON),
                new RarityItem(new ItemStack(ZAMItems.MINECRAFT_MINECRAFT), Rarity.COMMON),
                new RarityItem(new ItemStack(ZAMItems.MINECRAFT_ARIA_MATH), Rarity.COMMON),

                new RarityItem(new ItemStack(ZAMItems.MINECRAFT_SWEDEN), Rarity.UNCOMMON),
                new RarityItem(new ItemStack(ZAMItems.MINECRAFT_MICE_ON_VENUS), Rarity.UNCOMMON),

                RarityItem.choice(List.of(
                        new ItemStack(ZAMItems.MINECRAFT_HALLAND),
                        new ItemStack(ZAMItems.MINECRAFT_DALARNA)), Rarity.RARE),

                        RarityItem.mystery(new ItemStack(ZAMItems.RED_ICON), List.of(
                                pattern(ZAMCosmetics.MINECRAFT_WOLF_HELMET),
                                pattern(ZAMCosmetics.MINECRAFT_BEE_HELMET)), Rarity.EPIC),

                        RarityItem.mystery(new ItemStack(ZAMItems.GOLD_ICON), List.of(
                                pattern(ZAMCosmetics.MINECRAFT_PIRATE_CUTLASS),
                                pattern(ZAMCosmetics.MINECRAFT_ANCHOR),
                                pattern(ZAMCosmetics.MINECRAFT_ECHO_OF_THE_VALLEY)), Rarity.LEGENDARY)),

                () -> new ItemStack(ZAMBlocks.MINECRAFT_COMPLETION_BANNER));

        CaseRewards.registerDeferred(SPONGEBOB_CASE, () -> List.of(
                        new RarityItem(new ItemStack(ZAMItems.SPONGEBOB_THEME_SONG), Rarity.COMMON),
                        new RarityItem(new ItemStack(ZAMItems.SPONGEBOB_KRUSTY_KRAB), Rarity.COMMON),
                        new RarityItem(new ItemStack(ZAMItems.SPONGEBOB_PUKA_A), Rarity.COMMON),
                        new RarityItem(new ItemStack(ZAMItems.SPONGEBOB_HAWAIIAN_TRAIN), Rarity.COMMON),
                        new RarityItem(new ItemStack(ZAMItems.SPONGEBOB_CHILL_OUT), Rarity.COMMON),
                        new RarityItem(new ItemStack(ZAMItems.SPONGEBOB_MAUI_BEACH), Rarity.COMMON),
                        new RarityItem(new ItemStack(ZAMItems.SPONGEBOB_SURF_BUGGY), Rarity.COMMON),
                        new RarityItem(new ItemStack(ZAMItems.SPONGEBOB_THE_LINEMAN), Rarity.COMMON),

                        new RarityItem(new ItemStack(ZAMItems.SPONGEBOB_THE_RAKE), Rarity.UNCOMMON),
                        new RarityItem(new ItemStack(ZAMItems.SPONGEBOB_ANDY_ANNORAK), Rarity.UNCOMMON),
                        new RarityItem(new ItemStack(ZAMItems.SPONGEBOB_ME_FOR_YOU), Rarity.UNCOMMON),
                        new RarityItem(new ItemStack(ZAMItems.SPONGEBOB_DRUNKEN_SAILOR), Rarity.UNCOMMON),
                        new RarityItem(new ItemStack(ZAMItems.SPONGEBOB_CHRISTMAS), Rarity.UNCOMMON),

                        RarityItem.choice(List.of(
                                new ItemStack(ZAMItems.SPONGEBOB_GARYS_SONG),
                                new ItemStack(ZAMItems.SPONGEBOB_SWEET_VICTORY)), Rarity.RARE),
                        RarityItem.choice(List.of(
                                new ItemStack(ZAMItems.SPONGEBOB_AWARD_WINNERS_A),
                                new ItemStack(ZAMItems.SPONGEBOB_CHA_CHA_NOVA)), Rarity.RARE),
                        RarityItem.choice(List.of(
                                new ItemStack(ZAMItems.SPONGEBOB_JELLYFISH_JAM),
                                new ItemStack(ZAMItems.SPONGEBOB_KELPY_G)), Rarity.RARE),

                        RarityItem.mystery(new ItemStack(ZAMItems.RED_ICON), List.of(
                                pattern(ZAMCosmetics.SPONGEBOB_KRUSTY_KRAB_HAT)), Rarity.EPIC),

                        RarityItem.mystery(new ItemStack(ZAMItems.GOLD_ICON), List.of(
                                pattern(ZAMCosmetics.SPONGEBOB_GOLDEN_SPATULA),
                                pattern(ZAMCosmetics.SPONGEBOB_JELLYFISHING_NET),
                                pattern(ZAMCosmetics.SPONGEBOB_MARLIN_LANCE)), Rarity.LEGENDARY)),

                () -> new ItemStack(ZAMBlocks.SPONGEBOB_COMPLETION_BANNER));

        CaseRewards.registerDeferred(STARDEW_VALLEY_CASE, () -> List.of(
                        new RarityItem(new ItemStack(ZAMItems.STARDEW_VALLEY_OVERTURE), Rarity.COMMON),
                        new RarityItem(new ItemStack(ZAMItems.STARDEW_VALLEY_PELICAN_TOWN), Rarity.COMMON),
                        new RarityItem(new ItemStack(ZAMItems.STARDEW_VALLEY_ADVENTURE_GUILD), Rarity.COMMON),
                        new RarityItem(new ItemStack(ZAMItems.STARDEW_VALLEY_LIBRARY), Rarity.COMMON),
                        new RarityItem(new ItemStack(ZAMItems.STARDEW_VALLEY_FAIR), Rarity.COMMON),
                        new RarityItem(new ItemStack(ZAMItems.STARDEW_VALLEY_COUNTRY_SHOP), Rarity.COMMON),
                        new RarityItem(new ItemStack(ZAMItems.STARDEW_VALLEY_CALICO_DESERT), Rarity.COMMON),
                        new RarityItem(new ItemStack(ZAMItems.STARDEW_VALLEY_CRYSTAL_BELLS), Rarity.COMMON),
                        new RarityItem(new ItemStack(ZAMItems.STARDEW_VALLEY_FLICKER), Rarity.COMMON),
                        new RarityItem(new ItemStack(ZAMItems.STARDEW_VALLEY_NIGHT_MARKET), Rarity.COMMON),
                        new RarityItem(new ItemStack(ZAMItems.STARDEW_VALLEY_SUBMARINE), Rarity.COMMON),

                        new RarityItem(new ItemStack(ZAMItems.STARDEW_VALLEY_PROFESSOR_SNAILS_RADIO), Rarity.UNCOMMON),
                        new RarityItem(new ItemStack(ZAMItems.STARDEW_VALLEY_DISTANT_BANJO), Rarity.UNCOMMON),
                        new RarityItem(new ItemStack(ZAMItems.STARDEW_VALLEY_STARDROP_SALOON), Rarity.UNCOMMON),
                        new RarityItem(new ItemStack(ZAMItems.STARDEW_VALLEY_LUAU_FESTIVAL), Rarity.UNCOMMON),
                        new RarityItem(new ItemStack(ZAMItems.STARDEW_VALLEY_MOONLIGHT_JELLYFISH), Rarity.UNCOMMON),
                        new RarityItem(new ItemStack(ZAMItems.STARDEW_VALLEY_SPIRITS_EVE), Rarity.UNCOMMON),
                        new RarityItem(new ItemStack(ZAMItems.STARDEW_VALLEY_WINTER_FESTIVAL), Rarity.UNCOMMON),
                        new RarityItem(new ItemStack(ZAMItems.STARDEW_VALLEY_DEEP_WOODS), Rarity.UNCOMMON),
                        new RarityItem(new ItemStack(ZAMItems.STARDEW_VALLEY_MOVIE_THEATER), Rarity.UNCOMMON),

                        RarityItem.choice(List.of(
                                new ItemStack(ZAMItems.STARDEW_VALLEY_SPRING),
                                new ItemStack(ZAMItems.STARDEW_VALLEY_SPRING_2),
                                new ItemStack(ZAMItems.STARDEW_VALLEY_SPRING_3)), Rarity.RARE),
                        RarityItem.choice(List.of(
                                new ItemStack(ZAMItems.STARDEW_VALLEY_SUMMER),
                                new ItemStack(ZAMItems.STARDEW_VALLEY_SUMMER_2),
                                new ItemStack(ZAMItems.STARDEW_VALLEY_SUMMER_3)), Rarity.RARE),
                        RarityItem.choice(List.of(
                                new ItemStack(ZAMItems.STARDEW_VALLEY_FALL),
                                new ItemStack(ZAMItems.STARDEW_VALLEY_FALL_2),
                                new ItemStack(ZAMItems.STARDEW_VALLEY_FALL_3)), Rarity.RARE),
                        RarityItem.choice(List.of(
                                new ItemStack(ZAMItems.STARDEW_VALLEY_WINTER),
                                new ItemStack(ZAMItems.STARDEW_VALLEY_WINTER_2),
                                new ItemStack(ZAMItems.STARDEW_VALLEY_WINTER_3)), Rarity.RARE),
                        RarityItem.choice(List.of(
                                new ItemStack(ZAMItems.STARDEW_VALLEY_GINGER_ISLAND),
                                new ItemStack(ZAMItems.STARDEW_VALLEY_LEOS_SONG),
                                new ItemStack(ZAMItems.STARDEW_VALLEY_SUMMIT_CELEBRATION)), Rarity.RARE),

                        RarityItem.mystery(new ItemStack(ZAMItems.RED_ICON), List.of(
                                pattern(ZAMCosmetics.STARDEW_VALLEY_INFINITY_CROWN),
                                pattern(ZAMCosmetics.STARDEW_VALLEY_STRAW_HAT)), Rarity.EPIC),

                        RarityItem.mystery(new ItemStack(ZAMItems.GOLD_ICON), List.of(
                                pattern(ZAMCosmetics.STARDEW_VALLEY_DRAGONTOOTH_CUTLASS),
                                pattern(ZAMCosmetics.STARDEW_VALLEY_IRIDIUM_HOE),
                                pattern(ZAMCosmetics.STARDEW_VALLEY_IRIDIUM_FISHING_ROD)), Rarity.LEGENDARY)),

                () -> new ItemStack(ZAMBlocks.STARDEW_VALLEY_COMPLETION_BANNER));

        CaseRewards.registerDeferred(UNDERTALE_CASE, () -> List.of(
                        new RarityItem(new ItemStack(ZAMItems.UNDERTALE_FALLEN_DOWN), Rarity.COMMON),
                        new RarityItem(new ItemStack(ZAMItems.UNDERTALE_RUINS), Rarity.COMMON),
                        new RarityItem(new ItemStack(ZAMItems.UNDERTALE_HOME), Rarity.COMMON),
                        new RarityItem(new ItemStack(ZAMItems.UNDERTALE_SNOWY), Rarity.COMMON),
                        new RarityItem(new ItemStack(ZAMItems.UNDERTALE_DOGSONG), Rarity.COMMON),
                        new RarityItem(new ItemStack(ZAMItems.UNDERTALE_SHOP), Rarity.COMMON),
                        new RarityItem(new ItemStack(ZAMItems.UNDERTALE_ANOTHER_MEDIUM), Rarity.COMMON),

                        new RarityItem(new ItemStack(ZAMItems.UNDERTALE_UNDERTALE), Rarity.UNCOMMON),
                        new RarityItem(new ItemStack(ZAMItems.UNDERTALE_SANS), Rarity.UNCOMMON),
                        new RarityItem(new ItemStack(ZAMItems.UNDERTALE_DUMMY), Rarity.UNCOMMON),
                        new RarityItem(new ItemStack(ZAMItems.UNDERTALE_SPIDER_DANCE), Rarity.UNCOMMON),
                        new RarityItem(new ItemStack(ZAMItems.UNDERTALE_ITS_RAINING_SOMEWHERE_ELSE), Rarity.UNCOMMON),

                        RarityItem.choice(List.of(
                                new ItemStack(ZAMItems.UNDERTALE_HEARTACHE),
                                new ItemStack(ZAMItems.UNDERTALE_ASGORE)), Rarity.RARE),
                        RarityItem.choice(List.of(
                                new ItemStack(ZAMItems.UNDERTALE_BONETROUSLE),
                                new ItemStack(ZAMItems.UNDERTALE_MEGALOVANIA)), Rarity.RARE),
                        RarityItem.choice(List.of(
                                new ItemStack(ZAMItems.UNDERTALE_SPEAR_OF_JUSTICE),
                                new ItemStack(ZAMItems.UNDERTALE_DEATH_BY_GLAMOUR)), Rarity.RARE),
                        RarityItem.choice(List.of(
                                new ItemStack(ZAMItems.UNDERTALE_FINALE),
                                new ItemStack(ZAMItems.UNDERTALE_HOPES_AND_DREAMS)), Rarity.RARE),

                        RarityItem.mystery(new ItemStack(ZAMItems.RED_ICON), List.of(
                                pattern(ZAMCosmetics.UNDERTALE_LAMP_SHADE)), Rarity.EPIC),

                        RarityItem.mystery(new ItemStack(ZAMItems.GOLD_ICON), List.of(
                                pattern(ZAMCosmetics.UNDERTALE_REAL_KNIFE),
                                pattern(ZAMCosmetics.UNDERTALE_NICE_CREAM_SHOVEL),
                                pattern(ZAMCosmetics.UNDERTALE_UNDYNES_SPEAR),
                                pattern(ZAMCosmetics.UNDERTALE_GASTER_BLASTER)), Rarity.LEGENDARY)),

                () -> new ItemStack(ZAMBlocks.UNDERTALE_COMPLETION_BANNER));

    }

    private static ItemStack pattern(Item cosmetic) {
        return CosmeticPatterns.stack(BuiltInRegistries.ITEM.getKey(cosmetic));
    }
}
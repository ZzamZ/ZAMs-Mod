package net.ron.zam.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.references.ItemIds;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.ron.zam.ZAMMod;
import net.ron.zam.registry.ZAMItems;
import net.ron.zam.registry.ZAMTags;

import java.util.concurrent.CompletableFuture;

public class ZAMItemTagProvider extends FabricTagsProvider.ItemTagsProvider {
    public ZAMItemTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    private static final ResourceKey<Item> SEA_JELLY_ITEM_KEY = ResourceKey.create(Registries.ITEM, ZAMMod.id("sea_jelly_block"));

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        tag(ZAMTags.COSMETIC_SWORDS).addOptionalTag(ItemTags.SWORDS);
        tag(ZAMTags.COSMETIC_PICKAXES).addOptionalTag(ItemTags.PICKAXES);
        tag(ZAMTags.COSMETIC_AXES).addOptionalTag(ItemTags.AXES);
        tag(ZAMTags.COSMETIC_SHOVELS).addOptionalTag(ItemTags.SHOVELS);
        tag(ZAMTags.COSMETIC_HOES).addOptionalTag(ItemTags.HOES);
        tag(ZAMTags.COSMETIC_SPEARS).addOptionalTag(ItemTags.SPEARS);
        tag(ZAMTags.COSMETIC_BOWS).addOptionalTag(ItemTags.BOW_ENCHANTABLE);
        tag(ZAMTags.COSMETIC_MACES).addOptionalTag(ItemTags.MACE_ENCHANTABLE);
        tag(ZAMTags.COSMETIC_FISHING_RODS).addOptionalTag(ItemTags.FISHING_ENCHANTABLE);
        tag(ZAMTags.COSMETIC_SHEARS).add(ItemIds.SHEARS);
        tag(ZAMTags.COSMETIC_HELMETS).addOptionalTag(ItemTags.HEAD_ARMOR);

        tag(ZAMTags.COSMETIC_KNIVES).addOptionalTag(
                TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("c", "tools/knife"))).addOptionalTag(
                TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("farmersdelight", "tools/knives")));

        tag(ZAMTags.CASTLE_CRASHERS_MUSIC_DISCS)
                .add(ZAMItems.getRK(ZAMItems.CASTLE_CRASHERS_FOUR_BRAVE_CHAMPS))
                .add(ZAMItems.getRK(ZAMItems.CASTLE_CRASHERS_FLUTEY))
                .add(ZAMItems.getRK(ZAMItems.CASTLE_CRASHERS_SPANISH_WALTZ))
                .add(ZAMItems.getRK(ZAMItems.CASTLE_CRASHERS_RACE_AROUND_THE_WORLD))
                .add(ZAMItems.getRK(ZAMItems.CASTLE_CRASHERS_JUMPER))
                .add(ZAMItems.getRK(ZAMItems.CASTLE_CRASHERS_SPACE_PIRATES))
                .add(ZAMItems.getRK(ZAMItems.CASTLE_CRASHERS_THE_SHOW))
                .add(ZAMItems.getRK(ZAMItems.CASTLE_CRASHERS_SIMPLE_SIGHT))
                .add(ZAMItems.getRK(ZAMItems.CASTLE_CRASHERS_FINAL_CONFRONTATION))
                .add(ZAMItems.getRK(ZAMItems.CASTLE_CRASHERS_ARCHETYPE))
                .add(ZAMItems.getRK(ZAMItems.CASTLE_CRASHERS_DARK_SKIES))
                .add(ZAMItems.getRK(ZAMItems.CASTLE_CRASHERS_RAGE_CHAMPIONS))
                .add(ZAMItems.getRK(ZAMItems.CASTLE_CRASHERS_BATTLEBLOCK))
                .add(ZAMItems.getRK(ZAMItems.CASTLE_CRASHERS_PLEASE_DONT))
                .add(ZAMItems.getRK(ZAMItems.CASTLE_CRASHERS_THE_ABDUCTION))
                .add(ZAMItems.getRK(ZAMItems.CASTLE_CRASHERS_WINTER_BLISS))
                .add(ZAMItems.getRK(ZAMItems.CASTLE_CRASHERS_BARRACKS_SONG))
                .add(ZAMItems.getRK(ZAMItems.CASTLE_CRASHERS_FLOODED_CASTLE))
                .add(ZAMItems.getRK(ZAMItems.CASTLE_CRASHERS_CHAOZ_JAPAN));

        tag(ZAMTags.COD_ZOMBIES_MUSIC_DISCS)
                .add(ZAMItems.getRK(ZAMItems.COD_ZOMBIES_JUGGERNOG))
                .add(ZAMItems.getRK(ZAMItems.COD_ZOMBIES_SPEED_COLA))
                .add(ZAMItems.getRK(ZAMItems.COD_ZOMBIES_DOUBLE_TAP))
                .add(ZAMItems.getRK(ZAMItems.COD_ZOMBIES_QUICK_REVIVE))
                .add(ZAMItems.getRK(ZAMItems.COD_ZOMBIES_PHD))
                .add(ZAMItems.getRK(ZAMItems.COD_ZOMBIES_STAMINUP))
                .add(ZAMItems.getRK(ZAMItems.COD_ZOMBIES_DEADSHOT))
                .add(ZAMItems.getRK(ZAMItems.COD_ZOMBIES_MULE_KICK))
                .add(ZAMItems.getRK(ZAMItems.COD_ZOMBIES_TOMBSTONE))
                .add(ZAMItems.getRK(ZAMItems.COD_ZOMBIES_WHOS_WHO))
                .add(ZAMItems.getRK(ZAMItems.COD_ZOMBIES_VULTURE_AID))
                .add(ZAMItems.getRK(ZAMItems.COD_ZOMBIES_WIDOWS_WINE))
                .add(ZAMItems.getRK(ZAMItems.COD_ZOMBIES_ELEMENTAL_POP))
                .add(ZAMItems.getRK(ZAMItems.COD_ZOMBIES_DEATH_PERCEPTION))
                .add(ZAMItems.getRK(ZAMItems.COD_ZOMBIES_MELEE_MACCHIATO))
                .add(ZAMItems.getRK(ZAMItems.COD_ZOMBIES_WISP_TEA))
                .add(ZAMItems.getRK(ZAMItems.COD_ZOMBIES_SOE_JUGGERNOG))
                .add(ZAMItems.getRK(ZAMItems.COD_ZOMBIES_SOE_SPEED_COLA))
                .add(ZAMItems.getRK(ZAMItems.COD_ZOMBIES_SOE_DOUBLE_TAP))
                .add(ZAMItems.getRK(ZAMItems.COD_ZOMBIES_SOE_QUICK_REVIVE))
                .add(ZAMItems.getRK(ZAMItems.COD_ZOMBIES_SOE_MULE_KICK))
                .add(ZAMItems.getRK(ZAMItems.COD_ZOMBIES_PACK_A_PUNCH))
                .add(ZAMItems.getRK(ZAMItems.COD_ZOMBIES_FIRE_SALE))
                .add(ZAMItems.getRK(ZAMItems.COD_ZOMBIES_DAMNED))
                .add(ZAMItems.getRK(ZAMItems.COD_ZOMBIES_RUSTY_CAGE))
                .add(ZAMItems.getRK(ZAMItems.COD_ZOMBIES_SNAKESKIN_BOOTS))
                .add(ZAMItems.getRK(ZAMItems.COD_ZOMBIES_115))
                .add(ZAMItems.getRK(ZAMItems.COD_ZOMBIES_SHEPHERD_OF_FIRE));

        tag(ZAMTags.COUNTER_STRIKE_MUSIC_DISCS)
                .add(ZAMItems.getRK(ZAMItems.COUNTER_STRIKE_DASHSTAR))
                .add(ZAMItems.getRK(ZAMItems.COUNTER_STRIKE_CARAMEL_DANCING))
                .add(ZAMItems.getRK(ZAMItems.COUNTER_STRIKE_EZ4ENCE))
                .add(ZAMItems.getRK(ZAMItems.COUNTER_STRIKE_FLASHBANG_DANCE))
                .add(ZAMItems.getRK(ZAMItems.COUNTER_STRIKE_ULTIMATE))
                .add(ZAMItems.getRK(ZAMItems.COUNTER_STRIKE_CRAB_RAVE))
                .add(ZAMItems.getRK(ZAMItems.COUNTER_STRIKE_GOLD_STEPS))
                .add(ZAMItems.getRK(ZAMItems.COUNTER_STRIKE_DIE_FOR_YOU))
                .add(ZAMItems.getRK(ZAMItems.COUNTER_STRIKE_GO_THEME))
                .add(ZAMItems.getRK(ZAMItems.COUNTER_STRIKE_2_THEME));

        tag(ZAMTags.DRAGON_BALL_MUSIC_DISCS)
                .add(ZAMItems.getRK(ZAMItems.DRAGON_BALL_GT_RECAP))
                .add(ZAMItems.getRK(ZAMItems.DRAGON_BALL_THE_DRINK))
                .add(ZAMItems.getRK(ZAMItems.DRAGON_BALL_ULTIMATE_BATTLE))
                .add(ZAMItems.getRK(ZAMItems.DRAGON_BALL_ULTRA_INSTINCT))
                .add(ZAMItems.getRK(ZAMItems.DRAGON_BALL_GATEBREAKER))
                .add(ZAMItems.getRK(ZAMItems.DRAGON_BALL_DAN_DAN))
                .add(ZAMItems.getRK(ZAMItems.DRAGON_BALL_CHA_LA))
                .add(ZAMItems.getRK(ZAMItems.DRAGON_BALL_BROLY_VS_GOGETA));

        tag(ZAMTags.HXH_MUSIC_DISCS)
                .add(ZAMItems.getRK(ZAMItems.HXH_HUNTING_FOR_YOUR_DREAM))
                .add(ZAMItems.getRK(ZAMItems.HXH_ALL_I_NEED_IS_MONEY))
                .add(ZAMItems.getRK(ZAMItems.HXH_HYORI_ITTAI))
                .add(ZAMItems.getRK(ZAMItems.HXH_HISOKA_THEME))
                .add(ZAMItems.getRK(ZAMItems.HXH_FROM_WHALE_ISLAND))
                .add(ZAMItems.getRK(ZAMItems.HXH_BOYS_BE_COURAGEOUS))
                .add(ZAMItems.getRK(ZAMItems.HXH_WORLD_OF_ADVENTURES))
                .add(ZAMItems.getRK(ZAMItems.HXH_DEPARTURE));

        tag(ZAMTags.HOLIDAY_MUSIC_DISCS)
                .add(ZAMItems.getRK(ZAMItems.HOLIDAY_WONDERFUL_TIME_OF_THE_YEAR))
                .add(ZAMItems.getRK(ZAMItems.HOLIDAY_THE_CHRISTMAS_SONG))
                .add(ZAMItems.getRK(ZAMItems.HOLIDAY_FELIZ_NAVIDAD))
                .add(ZAMItems.getRK(ZAMItems.HOLIDAY_MARIAH_CAREY))
                .add(ZAMItems.getRK(ZAMItems.HOLIDAY_ROCKIN_AROUND_THE_CHRISTMAS_TREE))
                .add(ZAMItems.getRK(ZAMItems.HOLIDAY_JINGLE_BELL_ROCK))
                .add(ZAMItems.getRK(ZAMItems.HOLIDAY_WHITE_CHRISTMAS))
                .add(ZAMItems.getRK(ZAMItems.HOLIDAY_HEAVY_METAL_CHRISTMAS))
                .add(ZAMItems.getRK(ZAMItems.HOLIDAY_LAST_CHRISTMAS));

        tag(ZAMTags.MINECRAFT_MUSIC_DISCS)
                .add(ZAMItems.getRK(ZAMItems.MINECRAFT_MINECRAFT))
                .add(ZAMItems.getRK(ZAMItems.MINECRAFT_SWEDEN))
                .add(ZAMItems.getRK(ZAMItems.MINECRAFT_ARIA_MATH))
                .add(ZAMItems.getRK(ZAMItems.MINECRAFT_HALLAND))
                .add(ZAMItems.getRK(ZAMItems.MINECRAFT_DALARNA))
                .add(ZAMItems.getRK(ZAMItems.MINECRAFT_SUBWOOFER_LULLABY))
                .add(ZAMItems.getRK(ZAMItems.MINECRAFT_MICE_ON_VENUS))
                .add(ZAMItems.getRK(ZAMItems.MINECRAFT_HAGGSTROM));

        tag(ZAMTags.SPONGEBOB_MUSIC_DISCS)
               .add(ZAMItems.getRK(ZAMItems.SPONGEBOB_KRUSTY_KRAB))
               .add(ZAMItems.getRK(ZAMItems.SPONGEBOB_THE_LINEMAN))
               .add(ZAMItems.getRK(ZAMItems.SPONGEBOB_PUKA_A))
               .add(ZAMItems.getRK(ZAMItems.SPONGEBOB_AWARD_WINNERS_A))
               .add(ZAMItems.getRK(ZAMItems.SPONGEBOB_ANDY_ANNORAK))
               .add(ZAMItems.getRK(ZAMItems.SPONGEBOB_SWEET_VICTORY))
               .add(ZAMItems.getRK(ZAMItems.SPONGEBOB_JELLYFISH_JAM))
               .add(ZAMItems.getRK(ZAMItems.SPONGEBOB_THE_RAKE))
               .add(ZAMItems.getRK(ZAMItems.SPONGEBOB_HAWAIIAN_TRAIN))
               .add(ZAMItems.getRK(ZAMItems.SPONGEBOB_GARYS_SONG))
               .add(ZAMItems.getRK(ZAMItems.SPONGEBOB_CHILL_OUT))
               .add(ZAMItems.getRK(ZAMItems.SPONGEBOB_MAUI_BEACH))
               .add(ZAMItems.getRK(ZAMItems.SPONGEBOB_ME_FOR_YOU))
               .add(ZAMItems.getRK(ZAMItems.SPONGEBOB_SURF_BUGGY))
               .add(ZAMItems.getRK(ZAMItems.SPONGEBOB_DRUNKEN_SAILOR))
               .add(ZAMItems.getRK(ZAMItems.SPONGEBOB_CHA_CHA_NOVA))
               .add(ZAMItems.getRK(ZAMItems.SPONGEBOB_KELPY_G))
               .add(ZAMItems.getRK(ZAMItems.SPONGEBOB_CHRISTMAS))
               .add(ZAMItems.getRK(ZAMItems.SPONGEBOB_THEME_SONG));

        tag(ZAMTags.STARDEW_VALLEY_MUSIC_DISCS)
               .add(ZAMItems.getRK(ZAMItems.STARDEW_VALLEY_OVERTURE))
               .add(ZAMItems.getRK(ZAMItems.STARDEW_VALLEY_SPRING))
               .add(ZAMItems.getRK(ZAMItems.STARDEW_VALLEY_SPRING_2))
               .add(ZAMItems.getRK(ZAMItems.STARDEW_VALLEY_SPRING_3))
               .add(ZAMItems.getRK(ZAMItems.STARDEW_VALLEY_PELICAN_TOWN))
               .add(ZAMItems.getRK(ZAMItems.STARDEW_VALLEY_DISTANT_BANJO))
               .add(ZAMItems.getRK(ZAMItems.STARDEW_VALLEY_SUMMER))
               .add(ZAMItems.getRK(ZAMItems.STARDEW_VALLEY_SUMMER_2))
               .add(ZAMItems.getRK(ZAMItems.STARDEW_VALLEY_SUMMER_3))
               .add(ZAMItems.getRK(ZAMItems.STARDEW_VALLEY_ADVENTURE_GUILD))
               .add(ZAMItems.getRK(ZAMItems.STARDEW_VALLEY_STARDROP_SALOON))
               .add(ZAMItems.getRK(ZAMItems.STARDEW_VALLEY_LUAU_FESTIVAL))
               .add(ZAMItems.getRK(ZAMItems.STARDEW_VALLEY_MOONLIGHT_JELLYFISH))
               .add(ZAMItems.getRK(ZAMItems.STARDEW_VALLEY_FALL))
               .add(ZAMItems.getRK(ZAMItems.STARDEW_VALLEY_FALL_2))
               .add(ZAMItems.getRK(ZAMItems.STARDEW_VALLEY_FALL_3))
               .add(ZAMItems.getRK(ZAMItems.STARDEW_VALLEY_LIBRARY))
               .add(ZAMItems.getRK(ZAMItems.STARDEW_VALLEY_FAIR))
               .add(ZAMItems.getRK(ZAMItems.STARDEW_VALLEY_SPIRITS_EVE))
               .add(ZAMItems.getRK(ZAMItems.STARDEW_VALLEY_WINTER))
               .add(ZAMItems.getRK(ZAMItems.STARDEW_VALLEY_WINTER_2))
               .add(ZAMItems.getRK(ZAMItems.STARDEW_VALLEY_WINTER_3))
               .add(ZAMItems.getRK(ZAMItems.STARDEW_VALLEY_WINTER_FESTIVAL))
               .add(ZAMItems.getRK(ZAMItems.STARDEW_VALLEY_COUNTRY_SHOP))
               .add(ZAMItems.getRK(ZAMItems.STARDEW_VALLEY_CALICO_DESERT))
               .add(ZAMItems.getRK(ZAMItems.STARDEW_VALLEY_CRYSTAL_BELLS))
               .add(ZAMItems.getRK(ZAMItems.STARDEW_VALLEY_FLICKER))
               .add(ZAMItems.getRK(ZAMItems.STARDEW_VALLEY_DEEP_WOODS))
               .add(ZAMItems.getRK(ZAMItems.STARDEW_VALLEY_NIGHT_MARKET))
               .add(ZAMItems.getRK(ZAMItems.STARDEW_VALLEY_SUBMARINE))
               .add(ZAMItems.getRK(ZAMItems.STARDEW_VALLEY_MOVIE_THEATER))
               .add(ZAMItems.getRK(ZAMItems.STARDEW_VALLEY_GINGER_ISLAND))
               .add(ZAMItems.getRK(ZAMItems.STARDEW_VALLEY_LEOS_SONG))
               .add(ZAMItems.getRK(ZAMItems.STARDEW_VALLEY_PROFESSOR_SNAILS_RADIO))
               .add(ZAMItems.getRK(ZAMItems.STARDEW_VALLEY_SUMMIT_CELEBRATION));

        tag(ZAMTags.UNDERTALE_MUSIC_DISCS)
                .add(ZAMItems.getRK(ZAMItems.UNDERTALE_UNDERTALE))
                .add(ZAMItems.getRK(ZAMItems.UNDERTALE_FALLEN_DOWN))
                .add(ZAMItems.getRK(ZAMItems.UNDERTALE_RUINS))
                .add(ZAMItems.getRK(ZAMItems.UNDERTALE_HOME))
                .add(ZAMItems.getRK(ZAMItems.UNDERTALE_HEARTACHE))
                .add(ZAMItems.getRK(ZAMItems.UNDERTALE_SANS))
                .add(ZAMItems.getRK(ZAMItems.UNDERTALE_SNOWY))
                .add(ZAMItems.getRK(ZAMItems.UNDERTALE_DOGSONG))
                .add(ZAMItems.getRK(ZAMItems.UNDERTALE_SHOP))
                .add(ZAMItems.getRK(ZAMItems.UNDERTALE_BONETROUSLE))
                .add(ZAMItems.getRK(ZAMItems.UNDERTALE_DUMMY))
                .add(ZAMItems.getRK(ZAMItems.UNDERTALE_SPEAR_OF_JUSTICE))
                .add(ZAMItems.getRK(ZAMItems.UNDERTALE_ANOTHER_MEDIUM))
                .add(ZAMItems.getRK(ZAMItems.UNDERTALE_SPIDER_DANCE))
                .add(ZAMItems.getRK(ZAMItems.UNDERTALE_ITS_RAINING_SOMEWHERE_ELSE))
                .add(ZAMItems.getRK(ZAMItems.UNDERTALE_DEATH_BY_GLAMOUR))
                .add(ZAMItems.getRK(ZAMItems.UNDERTALE_ASGORE))
                .add(ZAMItems.getRK(ZAMItems.UNDERTALE_FINALE))
                .add(ZAMItems.getRK(ZAMItems.UNDERTALE_HOPES_AND_DREAMS))
                .add(ZAMItems.getRK(ZAMItems.UNDERTALE_MEGALOVANIA));

        tag(ZAMTags.CASES)
                .add(ZAMItems.getRK(ZAMItems.CASTLE_CRASHERS_CASE))
                .add(ZAMItems.getRK(ZAMItems.COD_ZOMBIES_CASE))
                .add(ZAMItems.getRK(ZAMItems.COUNTER_STRIKE_CASE))
                .add(ZAMItems.getRK(ZAMItems.DRAGON_BALL_CASE))
                .add(ZAMItems.getRK(ZAMItems.HOLIDAY_CASE))
                .add(ZAMItems.getRK(ZAMItems.HXH_CASE))
                .add(ZAMItems.getRK(ZAMItems.MINECRAFT_CASE))
                .add(ZAMItems.getRK(ZAMItems.SPONGEBOB_CASE))
                .add(ZAMItems.getRK(ZAMItems.STARDEW_VALLEY_CASE))
                .add(ZAMItems.getRK(ZAMItems.UNDERTALE_CASE));

        tag(ItemTags.SULFUR_CUBE_SWALLOWABLE)
                .add(SEA_JELLY_ITEM_KEY);

        tag(ItemTags.SULFUR_CUBE_ARCHETYPE_FAST_FLAT)
                .add(SEA_JELLY_ITEM_KEY);

        tag(ConventionalItemTags.MUSIC_DISCS)
                .addTag(ZAMTags.CASTLE_CRASHERS_MUSIC_DISCS)
                .addTag(ZAMTags.COD_ZOMBIES_MUSIC_DISCS)
                .addTag(ZAMTags.COUNTER_STRIKE_MUSIC_DISCS)
                .addTag(ZAMTags.DRAGON_BALL_MUSIC_DISCS)
                .addTag(ZAMTags.HOLIDAY_MUSIC_DISCS)
                .addTag(ZAMTags.HXH_MUSIC_DISCS)
                .addTag(ZAMTags.MINECRAFT_MUSIC_DISCS)
                .addTag(ZAMTags.SPONGEBOB_MUSIC_DISCS)
                .addTag(ZAMTags.STARDEW_VALLEY_MUSIC_DISCS)
                .addTag(ZAMTags.UNDERTALE_MUSIC_DISCS);
    }
}

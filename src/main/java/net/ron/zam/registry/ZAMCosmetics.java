package net.ron.zam.registry;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.ron.zam.common.component.CosmeticPatternComponent;
import net.ron.zam.util.cosmetic.CosmeticPatterns;
import net.ron.zam.util.cosmetic.CosmeticSounds;
import net.ron.zam.util.cosmetic.CosmeticTarget;

import java.util.List;
import java.util.Optional;

public final class ZAMCosmetics {
    public static final Item CASTLE_CRASHERS_UNICORN_SWORD = ZAMItems.registerItem("castle_crashers_unicorn_sword", properties -> new Item(properties.rarity(Rarity.EPIC)));
    public static final Item CASTLE_CRASHERS_DEMON_SWORD = ZAMItems.registerItem("castle_crashers_demon_sword", properties -> new Item(properties.rarity(Rarity.EPIC)));
    public static final Item CASTLE_CRASHERS_CHICKEN_SWORD = ZAMItems.registerItem("castle_crashers_chicken_sword", properties -> new Item(properties.rarity(Rarity.EPIC)));
    public static final Item CASTLE_CRASHERS_RED_KNIGHT_HELMET = ZAMItems.registerItem("castle_crashers_red_knight_helmet", properties -> new Item(properties.rarity(Rarity.EPIC)));
    public static final Item CASTLE_CRASHERS_ORANGE_KNIGHT_HELMET = ZAMItems.registerItem("castle_crashers_orange_knight_helmet", properties -> new Item(properties.rarity(Rarity.EPIC)));
    public static final Item CASTLE_CRASHERS_GREEN_KNIGHT_HELMET = ZAMItems.registerItem("castle_crashers_green_knight_helmet", properties -> new Item(properties.rarity(Rarity.EPIC)));
    public static final Item CASTLE_CRASHERS_BLUE_KNIGHT_HELMET = ZAMItems.registerItem("castle_crashers_blue_knight_helmet", properties -> new Item(properties.rarity(Rarity.EPIC)));
    public static final Item CASTLE_CRASHERS_PURPLE_KNIGHT_HELMET = ZAMItems.registerItem("castle_crashers_purple_knight_helmet", properties -> new Item(properties.rarity(Rarity.EPIC)));

    public static final Item COD_ZOMBIES_HELLS_RETRIEVER = ZAMItems.registerItem("cod_zombies_hells_retriever", properties -> new Item(properties.rarity(Rarity.EPIC)));
    public static final Item COD_ZOMBIES_ICE_STAFF = ZAMItems.registerItem("cod_zombies_ice_staff", properties -> new Item(properties.rarity(Rarity.EPIC)));
    public static final Item COD_ZOMBIES_WOLF_BOW = ZAMItems.registerItem("cod_zombies_wolf_bow", properties -> new Item(properties.rarity(Rarity.EPIC)));
    public static final Item COD_ZOMBIES_APOTHICAN_SWORD = ZAMItems.registerItem("cod_zombies_apothican_sword", properties -> new Item(properties.rarity(Rarity.EPIC)));
    public static final Item COD_ZOMBIES_GOLDEN_SPORK = ZAMItems.registerItem("cod_zombies_golden_spork", properties -> new Item(properties.rarity(Rarity.EPIC)));
    public static final Item COD_ZOMBIES_MARGWA_MASK = ZAMItems.registerItem("cod_zombies_margwa_mask", properties -> new Item(properties.rarity(Rarity.EPIC)));
    public static final Item COD_ZOMBIES_APOTHICAN_MASK = ZAMItems.registerItem("cod_zombies_apothican_mask", properties -> new Item(properties.rarity(Rarity.EPIC)));
    public static final Item COD_ZOMBIES_FLAMING_SKULL = ZAMItems.registerItem("cod_zombies_flaming_skull", properties -> new Item(properties.rarity(Rarity.EPIC)));

    public static final Item COUNTER_STRIKE_NIGHTWISH = ZAMItems.registerItem("counter_strike_nightwish", properties -> new Item(properties.rarity(Rarity.EPIC)));
    public static final Item COUNTER_STRIKE_DOPPLER_KNIFE = ZAMItems.registerItem("counter_strike_doppler_knife", properties -> new Item(properties.rarity(Rarity.EPIC)));
    public static final Item COUNTER_STRIKE_GLITCHPOP_DAGGER = ZAMItems.registerItem("counter_strike_glitchpop_dagger", properties -> new Item(properties.rarity(Rarity.EPIC)));
    public static final Item COUNTER_STRIKE_TACTICAL_HEADGEAR = ZAMItems.registerItem("counter_strike_tactical_headgear", properties -> new Item(properties.rarity(Rarity.EPIC)));
    public static final Item COUNTER_STRIKE_DUM_NOTE = ZAMItems.registerItem("counter_strike_dum_note", properties -> new Item(properties.rarity(Rarity.EPIC)));

    public static final Item DRAGON_BALL_POWER_POLL = ZAMItems.registerItem("dragon_ball_power_poll", properties -> new Item(properties.rarity(Rarity.EPIC)));
    public static final Item DRAGON_BALL_SICKLE_OF_SORROW = ZAMItems.registerItem("dragon_ball_sickle_of_sorrow", properties -> new Item(properties.rarity(Rarity.EPIC)));
    public static final Item DRAGON_BALL_SUPER_SAIYAN_HAIR = ZAMItems.registerItem("dragon_ball_super_saiyan_hair", properties -> new Item(properties.rarity(Rarity.EPIC)));

    public static final Item ENTERTAINMENT_LIGHTSABER = ZAMItems.registerItem("entertainment_lightsaber", properties -> new Item(properties.rarity(Rarity.EPIC)));
    public static final Item ENTERTAINMENT_STORMBREAKER = ZAMItems.registerItem("entertainment_stormbreaker", properties -> new Item(properties.rarity(Rarity.EPIC)));
    public static final Item ENTERTAINMENT_INVERTED_SPEAR_OF_HEAVEN = ZAMItems.registerItem("entertainment_inverted_spear_of_heaven", properties -> new Item(properties.rarity(Rarity.EPIC)));
    public static final Item ENTERTAINMENT_GRUNKLE_STAN_HAT = ZAMItems.registerItem("entertainment_grunkle_stan_hat", properties -> new Item(properties.rarity(Rarity.EPIC)));
    public static final Item ENTERTAINMENT_DIPPER_HAT = ZAMItems.registerItem("entertainment_dipper_hat", properties -> new Item(properties.rarity(Rarity.EPIC)));
    public static final Item ENTERTAINMENT_DARTH_VADER_MASK = ZAMItems.registerItem("entertainment_darth_vader_mask", properties -> new Item(properties.rarity(Rarity.EPIC)));
    public static final Item ENTERTAINMENT_AHOY_HAT = ZAMItems.registerItem("entertainment_ahoy_hat", properties -> new Item(properties.rarity(Rarity.EPIC)));
    public static final Item ENTERTAINMENT_ADAPTION_WHEEL = ZAMItems.registerItem("entertainment_adaption_wheel", properties -> new Item(properties.rarity(Rarity.EPIC)));

    public static final Item HALO_ENERGY_SWORD = ZAMItems.registerItem("halo_energy_sword", properties -> new Item(properties.rarity(Rarity.EPIC)));
    public static final Item HALO_GRAVITY_HAMMER = ZAMItems.registerItem("halo_gravity_hammer", properties -> new Item(properties.rarity(Rarity.EPIC)));
    public static final Item HALO_NEEDLER = ZAMItems.registerItem("halo_needler", properties -> new Item(properties.rarity(Rarity.EPIC)));
    public static final Item HALO_MASTER_CHIEF_HELMET = ZAMItems.registerItem("halo_master_chief_helmet", properties -> new Item(properties.rarity(Rarity.EPIC)));

    public static final Item HOLIDAY_CANDY_CANE = ZAMItems.registerItem("holiday_candy_cane", properties -> new Item(properties.rarity(Rarity.EPIC)));
    public static final Item HOLIDAY_CHRISTMAS_TREE = ZAMItems.registerItem("holiday_christmas_tree", properties -> new Item(properties.rarity(Rarity.EPIC)));
    public static final Item HOLIDAY_HOCKEY_STICK = ZAMItems.registerItem("holiday_hockey_stick", properties -> new Item(properties.rarity(Rarity.EPIC)));
    public static final Item HOLIDAY_SANTA_HAT = ZAMItems.registerItem("holiday_santa_hat", properties -> new Item(properties.rarity(Rarity.EPIC)));

    public static final Item HXH_GONS_FISHING_ROD = ZAMItems.registerItem("hxh_gons_fishing_rod", properties -> new Item(properties.rarity(Rarity.EPIC)));
    public static final Item HXH_CRAZY_SLOTS_SCYTHE = ZAMItems.registerItem("hxh_crazy_slots_scythe", properties -> new Item(properties.rarity(Rarity.EPIC)));
    public static final Item HXH_GONS_HAIR = ZAMItems.registerItem("hxh_gons_hair", properties -> new Item(properties.rarity(Rarity.EPIC)));

    public static final Item MINECRAFT_PIRATE_CUTLASS = ZAMItems.registerItem("minecraft_pirate_cutlass", properties -> new Item(properties.rarity(Rarity.EPIC)));
    public static final Item MINECRAFT_ECHO_OF_THE_VALLEY = ZAMItems.registerItem("minecraft_echo_of_the_valley", properties -> new Item(properties.rarity(Rarity.EPIC)));
    public static final Item MINECRAFT_ANCHOR = ZAMItems.registerItem("minecraft_anchor", properties -> new Item(properties.rarity(Rarity.EPIC)));
    public static final Item MINECRAFT_BEE_HELMET = ZAMItems.registerItem("minecraft_bee_helmet", properties -> new Item(properties.rarity(Rarity.EPIC)));
    public static final Item MINECRAFT_WOLF_HELMET = ZAMItems.registerItem("minecraft_wolf_helmet", properties -> new Item(properties.rarity(Rarity.EPIC)));

    public static final Item SPONGEBOB_GOLDEN_SPATULA = ZAMItems.registerItem("spongebob_golden_spatula", properties -> new Item(properties.rarity(Rarity.EPIC)));
    public static final Item SPONGEBOB_JELLYFISHING_NET = ZAMItems.registerItem("spongebob_jellyfishing_net", properties -> new Item(properties.rarity(Rarity.EPIC)));
    public static final Item SPONGEBOB_MARLIN_LANCE = ZAMItems.registerItem("spongebob_marlin_lance", properties -> new Item(properties.rarity(Rarity.EPIC)));
    public static final Item SPONGEBOB_KRUSTY_KRAB_HAT = ZAMItems.registerItem("spongebob_krusty_krab_hat", properties -> new Item(properties.rarity(Rarity.EPIC)));

    public static final Item STARDEW_VALLEY_DRAGONTOOTH_CUTLASS = ZAMItems.registerItem("stardew_valley_dragontooth_cutlass", properties -> new Item(properties.rarity(Rarity.EPIC)));
    public static final Item STARDEW_VALLEY_IRIDIUM_HOE = ZAMItems.registerItem("stardew_valley_iridium_hoe", properties -> new Item(properties.rarity(Rarity.EPIC)));
    public static final Item STARDEW_VALLEY_IRIDIUM_FISHING_ROD = ZAMItems.registerItem("stardew_valley_iridium_fishing_rod", properties -> new Item(properties.rarity(Rarity.EPIC)));
    public static final Item STARDEW_VALLEY_NEPTUNES_GLAIVE = ZAMItems.registerItem("stardew_valley_neptunes_glaive", properties -> new Item(properties.rarity(Rarity.EPIC)));
    public static final Item STARDEW_VALLEY_INFINITY_CROWN = ZAMItems.registerItem("stardew_valley_infinity_crown", properties -> new Item(properties.rarity(Rarity.EPIC)));
    public static final Item STARDEW_VALLEY_STRAW_HAT = ZAMItems.registerItem("stardew_valley_straw_hat", properties -> new Item(properties.rarity(Rarity.EPIC)));

    public static final Item UNDERTALE_REAL_KNIFE = ZAMItems.registerItem("undertale_real_knife", properties -> new Item(properties.rarity(Rarity.EPIC)));
    public static final Item UNDERTALE_NICE_CREAM_SHOVEL = ZAMItems.registerItem("undertale_nice_cream_shovel", properties -> new Item(properties.rarity(Rarity.EPIC)));
    public static final Item UNDERTALE_UNDYNES_SPEAR = ZAMItems.registerItem("undertale_undynes_spear", properties -> new Item(properties.rarity(Rarity.EPIC)));
    public static final Item UNDERTALE_GASTER_BLASTER = ZAMItems.registerItem("undertale_gaster_blaster", properties -> new Item(properties.rarity(Rarity.EPIC)));
    public static final Item UNDERTALE_LAMP_SHADE = ZAMItems.registerItem("undertale_lamp_shade", properties -> new Item(properties.rarity(Rarity.EPIC)));

    public static void registerCosmetics() {
        register(CASTLE_CRASHERS_UNICORN_SWORD, "Unicorn Sword", "Castle Crashers", CosmeticTarget.SWORD, 0xFFB6C1, CosmeticSounds.apply(ZAMSounds.CASTLE_CRASHERS_COSMETIC_EQUIP.location()));
        register(CASTLE_CRASHERS_DEMON_SWORD, "Demon Sword", "Castle Crashers", CosmeticTarget.SWORD, 0xFF2400, CosmeticSounds.apply(ZAMSounds.CASTLE_CRASHERS_COSMETIC_EQUIP.location()));
        register(CASTLE_CRASHERS_CHICKEN_SWORD, "Chicken Sword", "Castle Crashers", CosmeticTarget.SWORD, 0xFFFFFF, CosmeticSounds.apply(ZAMSounds.CASTLE_CRASHERS_COSMETIC_EQUIP.location()));
        register(CASTLE_CRASHERS_RED_KNIGHT_HELMET, "Red Knight Helmet", "Castle Crashers", CosmeticTarget.HELMET, 0xFF5555, CosmeticSounds.apply(ZAMSounds.CASTLE_CRASHERS_COSMETIC_EQUIP.location()).withEquip(ZAMSounds.RED_KNIGHT_EQUIP.location()));
        register(CASTLE_CRASHERS_ORANGE_KNIGHT_HELMET, "Orange Knight Helmet", "Castle Crashers", CosmeticTarget.HELMET, 0xFFAA00, CosmeticSounds.apply(ZAMSounds.CASTLE_CRASHERS_COSMETIC_EQUIP.location()).withEquip(ZAMSounds.ORANGE_KNIGHT_EQUIP.location()));
        register(CASTLE_CRASHERS_GREEN_KNIGHT_HELMET, "Green Knight Helmet", "Castle Crashers", CosmeticTarget.HELMET, 0x55FF55, CosmeticSounds.apply(ZAMSounds.CASTLE_CRASHERS_COSMETIC_EQUIP.location()).withEquip(ZAMSounds.GREEN_KNIGHT_EQUIP.location()));
        register(CASTLE_CRASHERS_BLUE_KNIGHT_HELMET, "Blue Knight Helmet", "Castle Crashers", CosmeticTarget.HELMET, 0x5555FF, CosmeticSounds.apply(ZAMSounds.CASTLE_CRASHERS_COSMETIC_EQUIP.location()).withEquip(ZAMSounds.BLUE_KNIGHT_EQUIP.location()));
        register(CASTLE_CRASHERS_PURPLE_KNIGHT_HELMET, "Purple Knight Helmet", "Castle Crashers", CosmeticTarget.HELMET, 0xAA00AA, CosmeticSounds.apply(ZAMSounds.CASTLE_CRASHERS_COSMETIC_EQUIP.location()).withEquip(ZAMSounds.PURPLE_KNIGHT_EQUIP.location()));

        register(COD_ZOMBIES_HELLS_RETRIEVER, "Hell's Retriever", "Call of Duty Zombies", CosmeticTarget.AXE, 0x8A0303, CosmeticSounds.apply(ZAMSounds.COD_ZOMBIES_HELLS_RETRIEVER_COSMETIC_EQUIP.location()));
        register(COD_ZOMBIES_ICE_STAFF, "Ull’s Arrow", "Call of Duty Zombies", CosmeticTarget.SPEAR, 0xB8F3FF, CosmeticSounds.apply(ZAMSounds.COD_ZOMBIES_ICE_STAFF_COSMETIC_EQUIP.location()));
        register(COD_ZOMBIES_WOLF_BOW, "Kreeholo lu Kreemasaleet", "Call of Duty Zombies", CosmeticTarget.BOW, 0x9BE8FF, CosmeticSounds.bow(ZAMSounds.COD_ZOMBIES_WOLF_BOW_COSMETIC_EQUIP.location(), ZAMSounds.COD_ZOMBIES_WOLF_BOW_SHOOT.location()));
        register(COD_ZOMBIES_APOTHICAN_SWORD, "Maroth Zorguamat", "Call of Duty Zombies", CosmeticTarget.SWORD, 0x8A0303, CosmeticSounds.apply(ZAMSounds.COD_ZOMBIES_APOTHICAN_SWORD_COSMETIC_EQUIP.location()));
        register(COD_ZOMBIES_GOLDEN_SPORK, "Golden Spork Knife", "Call of Duty Zombies", CosmeticTarget.KNIFE, CosmeticTarget.SHOVEL, 0xD4AF37, CosmeticSounds.apply(ZAMSounds.COD_ZOMBIES_GOLDEN_SPORK_COSMETIC_EQUIP.location()));
        register(COD_ZOMBIES_MARGWA_MASK, "Margwa Mask", "Call of Duty Zombies", CosmeticTarget.HELMET, 0x526B38, CosmeticSounds.apply(ZAMSounds.COD_ZOMBIES_COSMETIC_EQUIP.location()).withEquip(ZAMSounds.COD_ZOMBIES_MARGWA_EQUIP.location()));
        register(COD_ZOMBIES_APOTHICAN_MASK, "Apothican Mask", "Call of Duty Zombies", CosmeticTarget.HELMET, 0x38264A, CosmeticSounds.apply(ZAMSounds.COD_ZOMBIES_COSMETIC_EQUIP.location()).withEquip(ZAMSounds.COD_ZOMBIES_APOTHICAN_EQUIP.location()));
        register(COD_ZOMBIES_FLAMING_SKULL, "Epic Flaming Skull", "Call of Duty Zombies", CosmeticTarget.HELMET, 0xFF3B0A, CosmeticSounds.apply(ZAMSounds.COD_ZOMBIES_COSMETIC_EQUIP.location()).withEquip(ZAMSounds.COD_ZOMBIES_SKULL_EQUIP.location()));

        register(COUNTER_STRIKE_NIGHTWISH, "Nightwish", "Counter Strike", CosmeticTarget.AXE, 0xE84B9B, CosmeticSounds.apply(ZAMSounds.COUNTER_STRIKE_NIGHTWISH_EQUIP.location()));
        register(COUNTER_STRIKE_DOPPLER_KNIFE, "M9 Bayonet Doppler Sapphire", "Counter Strike", CosmeticTarget.KNIFE, CosmeticTarget.SWORD, 0x6633CC, CosmeticSounds.apply(ZAMSounds.COUNTER_STRIKE_DOPPLER_EQUIP.location()));
        register(COUNTER_STRIKE_GLITCHPOP_DAGGER, "Glitchpop Dagger", "Counter Strike", CosmeticTarget.KNIFE, CosmeticTarget.SWORD, 0x38E6FF, CosmeticSounds.apply(ZAMSounds.COUNTER_STRIKE_GLITCHPOP_EQUIP.location()));
        register(COUNTER_STRIKE_DUM_NOTE, "Sticky Note", "Counter Strike", CosmeticTarget.HELMET, 0xB89A62, CosmeticSounds.apply(ZAMSounds.COUNTER_STRIKE_COSMETIC_EQUIP.location()).withEquip(ZAMSounds.COUNTER_STRIKE_SUS_EQUIP.location()));
        register(COUNTER_STRIKE_TACTICAL_HEADGEAR, "\"Tactical\" Headgear", "Counter Strike", CosmeticTarget.HELMET, 0xB89A62, CosmeticSounds.apply(ZAMSounds.COUNTER_STRIKE_COSMETIC_EQUIP.location()).withEquip(ZAMSounds.COUNTER_STRIKE_TACTICAL_EQUIP.location()));

        register(DRAGON_BALL_POWER_POLL, "Power Poll", "Dragon Ball", CosmeticTarget.SPEAR, 0xCC2222, CosmeticSounds.apply(ZAMSounds.DRAGON_BALL_COSMETIC_EQUIP.location()));
        register(DRAGON_BALL_SICKLE_OF_SORROW, "Sickle of Sorrow", "Dragon Ball", CosmeticTarget.HOE, 0xE040FB, CosmeticSounds.apply(ZAMSounds.DRAGON_BALL_COSMETIC_EQUIP.location()));
        register(DRAGON_BALL_SUPER_SAIYAN_HAIR, "Super Saiyan Hair", "Dragon Ball", CosmeticTarget.HELMET, 0xFFD700, CosmeticSounds.apply(ZAMSounds.DRAGON_BALL_COSMETIC_EQUIP.location()).withEquip(ZAMSounds.DRAGON_BALL_EQUIP.location()));

        register(ENTERTAINMENT_LIGHTSABER, "Lightsaber", "Entertainment", CosmeticTarget.SWORD, 0x3084E3, CosmeticSounds.apply(ZAMSounds.LIGHTSABER_EQUIP.location()));
        register(ENTERTAINMENT_STORMBREAKER, "Stormbreaker", "Entertainment", CosmeticTarget.AXE, 0x7E9EAB, CosmeticSounds.apply(ZAMSounds.STORMBREAKER_EQUIP.location()));
        register(ENTERTAINMENT_INVERTED_SPEAR_OF_HEAVEN, "Inverted Spear of Heaven", "Entertainment", CosmeticTarget.KNIFE, CosmeticTarget.SWORD, 0x817E7E, CosmeticSounds.apply(ZAMSounds.ISOH_EQUIP.location()));
        register(ENTERTAINMENT_DIPPER_HAT, "Pine Tree Hat", "Entertainment", CosmeticTarget.HELMET, 0x88A5E0, CosmeticSounds.apply(ZAMSounds.DIPPER_EQUIP.location()).withEquip(SoundEvents.ARMOR_EQUIP_LEATHER.value().location()));
        register(ENTERTAINMENT_GRUNKLE_STAN_HAT, "Grunkle Stan's Fez", "Entertainment", CosmeticTarget.HELMET, 0x7E3D51, CosmeticSounds.apply(ZAMSounds.STAN_EQUIP.location()).withEquip(SoundEvents.ARMOR_EQUIP_LEATHER.value().location()));
        register(ENTERTAINMENT_ADAPTION_WHEEL, "Adaption Wheel", "Entertainment", CosmeticTarget.HELMET, 0xA6975F, CosmeticSounds.apply(ZAMSounds.ADAPTION_COSMETIC_EQUIP.location()).withEquip(ZAMSounds.ADAPTION_EQUIP.location()));
        register(ENTERTAINMENT_DARTH_VADER_MASK, "Darth Vader Mask", "Entertainment", CosmeticTarget.HELMET, 0x292A2A, CosmeticSounds.apply(ZAMSounds.VADER_COSMETIC_EQUIP.location()).withEquip(ZAMSounds.VADER_EQUIP.location()));
        register(ENTERTAINMENT_AHOY_HAT, "Scoops Ahoy Hat", "Entertainment", CosmeticTarget.HELMET, 0xE9EDFC, CosmeticSounds.apply(ZAMSounds.AHOY_EQUIP.location()).withEquip(SoundEvents.ARMOR_EQUIP_LEATHER.value().location()));

        register(HALO_ENERGY_SWORD, "Energy Sword", "Halo", CosmeticTarget.SWORD, 0x7DEBFF, CosmeticSounds.apply(ZAMSounds.HALO_ENERGY_SWORD_EQUIP.location()));
        register(HALO_GRAVITY_HAMMER, "Gravity Hammer", "Halo", CosmeticTarget.MACE, 0x687580, CosmeticSounds.mace(ZAMSounds.HALO_COSMETIC_EQUIP.location(), ZAMSounds.HALO_MACE_HIT.location()));
        register(HALO_NEEDLER, "Needler", "Halo", CosmeticTarget.BOW, 0xE75BD9, CosmeticSounds.bow(ZAMSounds.HALO_NEEDLER_EQUIP.location(), ZAMSounds.HALO_BOW_SHOOT.location()));
        register(HALO_MASTER_CHIEF_HELMET, "Master Chief Helmet", "Halo", CosmeticTarget.HELMET, 0x78864A, CosmeticSounds.apply(ZAMSounds.HALO_COSMETIC_EQUIP.location()).withEquip(ZAMSounds.HALO_EQUIP.location()));

        register(HOLIDAY_CANDY_CANE, "Candy Cane", "Holiday", CosmeticTarget.HOE, 0xC62828, CosmeticSounds.apply(ZAMSounds.HOLIDAY_COSMETIC_EQUIP.location()));
        register(HOLIDAY_CHRISTMAS_TREE, "Christmas Tree", "Holiday", CosmeticTarget.SPEAR, 0x2E7D32, CosmeticSounds.apply(ZAMSounds.HOLIDAY_COSMETIC_EQUIP.location()));
        register(HOLIDAY_HOCKEY_STICK, "Hockey Stick", "Holiday", CosmeticTarget.HOE, 0x4B3621, CosmeticSounds.apply(ZAMSounds.HOLIDAY_COSMETIC_EQUIP.location()));
        register(HOLIDAY_SANTA_HAT, "Santa Hat", "Holiday", CosmeticTarget.HELMET, 0xC62828, CosmeticSounds.apply(ZAMSounds.HOLIDAY_COSMETIC_EQUIP.location()).withEquip(ZAMSounds.HOLIDAY_EQUIP.location()));

        register(HXH_GONS_FISHING_ROD, "Gon's Fishing Rod", "Hunter X Hunter", CosmeticTarget.FISHING_ROD, 0x4A9B45, CosmeticSounds.apply(ZAMSounds.HXH_COSMETIC_EQUIP.location()));
        register(HXH_CRAZY_SLOTS_SCYTHE, "Crazy Slots Scythe", "Hunter X Hunter", CosmeticTarget.HOE, 0xC0C0C0, CosmeticSounds.apply(ZAMSounds.HXH_COSMETIC_EQUIP.location()));
        register(HXH_GONS_HAIR, "Gon's Hair", "Hunter X Hunter", CosmeticTarget.HELMET, 0x173D24, CosmeticSounds.apply(ZAMSounds.HXH_COSMETIC_EQUIP.location()).withEquip(ZAMSounds.HXH_EQUIP.location()));

        register(MINECRAFT_PIRATE_CUTLASS, "Pirate Cutlass", "Minecraft", CosmeticTarget.SWORD, 0xA3BEC9, CosmeticSounds.apply(SoundEvents.ARMOR_EQUIP_GENERIC.value().location()));
        register(MINECRAFT_ANCHOR, "Anchor", "Minecraft", CosmeticTarget.MACE, 0x647D87, CosmeticSounds.apply(SoundEvents.ARMOR_EQUIP_GENERIC.value().location()));
        register(MINECRAFT_ECHO_OF_THE_VALLEY, "Echo of the Valley", "Minecraft", CosmeticTarget.BOW, 0x5E8746, CosmeticSounds.apply(SoundEvents.ARMOR_EQUIP_GENERIC.value().location()));
        register(MINECRAFT_BEE_HELMET, "Bee Helmet", "Minecraft", CosmeticTarget.HELMET, 0xF2C94C, CosmeticSounds.apply(SoundEvents.ARMOR_EQUIP_GENERIC.value().location()).withEquip(ZAMSounds.MINECRAFT_BEE_EQUIP.location()));
        register(MINECRAFT_WOLF_HELMET, "Wolf Helmet", "Minecraft", CosmeticTarget.HELMET, 0xB8B8B8, CosmeticSounds.apply(SoundEvents.ARMOR_EQUIP_GENERIC.value().location()).withEquip(ZAMSounds.MINECRAFT_WOLF_EQUIP.location()));

        register(SPONGEBOB_GOLDEN_SPATULA, "Golden Spatula", "SpongeBob SquarePants", CosmeticTarget.SHOVEL, 0xFFD700, CosmeticSounds.apply(ZAMSounds.SPONGEBOB_COSMETIC_EQUIP.location()));
        register(SPONGEBOB_JELLYFISHING_NET, "Jellyfishing Net", "SpongeBob SquarePants", CosmeticTarget.SHOVEL, 0x9B6A3C, CosmeticSounds.apply(ZAMSounds.SPONGEBOB_COSMETIC_EQUIP.location()));
        register(SPONGEBOB_MARLIN_LANCE, "Marlin Lance", "SpongeBob SquarePants", CosmeticTarget.SPEAR, 0x287FA3, CosmeticSounds.apply(ZAMSounds.SPONGEBOB_COSMETIC_EQUIP.location()));
        register(SPONGEBOB_KRUSTY_KRAB_HAT, "Krusty Krab Hat", "SpongeBob SquarePants", CosmeticTarget.HELMET, 0x4FA3D1, CosmeticSounds.apply(ZAMSounds.SPONGEBOB_COSMETIC_EQUIP.location()).withEquip(ZAMSounds.SPONGEBOB_EQUIP.location()));

        register(STARDEW_VALLEY_DRAGONTOOTH_CUTLASS, "Dragontooth Cutlass", "Stardew Valley", CosmeticTarget.SWORD, 0x9B5DE5, CosmeticSounds.apply(ZAMSounds.STARDEW_VALLEY_COSMETIC_EQUIP.location()));
        register(STARDEW_VALLEY_IRIDIUM_HOE, "Iridium Hoe", "Stardew Valley", CosmeticTarget.HOE, 0x9B5DE5, CosmeticSounds.apply(ZAMSounds.STARDEW_VALLEY_COSMETIC_EQUIP.location()));
        register(STARDEW_VALLEY_IRIDIUM_FISHING_ROD, "Iridium Fishing Rod", "Stardew Valley", CosmeticTarget.FISHING_ROD, 0x9B5DE5, CosmeticSounds.fishing(ZAMSounds.STARDEW_VALLEY_COSMETIC_EQUIP.location(), ZAMSounds.STARDEW_VALLEY_FISHING_CAST.location(), ZAMSounds.STARDEW_VALLEY_FISHING_BITE.location(), ZAMSounds.STARDEW_VALLEY_FISHING_PULL.location()));
        register(STARDEW_VALLEY_NEPTUNES_GLAIVE, "Neptune's Glaive", "Stardew Valley", CosmeticTarget.SWORD, 0x59C9B5, CosmeticSounds.apply(ZAMSounds.STARDEW_VALLEY_COSMETIC_EQUIP.location()));
        register(STARDEW_VALLEY_INFINITY_CROWN, "Infinity Crown", "Stardew Valley", CosmeticTarget.HELMET, 0xB11226, CosmeticSounds.apply(ZAMSounds.STARDEW_VALLEY_COSMETIC_EQUIP.location()).withEquip(ZAMSounds.STARDEW_VALLEY_EQUIP_1.location()));
        register(STARDEW_VALLEY_STRAW_HAT, "Straw Hat", "Stardew Valley", CosmeticTarget.HELMET, 0xD6A84B, CosmeticSounds.apply(ZAMSounds.STARDEW_VALLEY_COSMETIC_EQUIP.location()).withEquip(ZAMSounds.STARDEW_VALLEY_EQUIP_2.location()));

        register(UNDERTALE_REAL_KNIFE, "Real Knife", "Undertale", CosmeticTarget.KNIFE, CosmeticTarget.SWORD, 0xFF2400, CosmeticSounds.apply(ZAMSounds.UNDERTALE_COSMETIC_EQUIP.location()));
        register(UNDERTALE_NICE_CREAM_SHOVEL, "Nice Cream Shovel", "Undertale", CosmeticTarget.SHOVEL, 0x40D6C8, CosmeticSounds.apply(ZAMSounds.UNDERTALE_COSMETIC_EQUIP.location()));
        register(UNDERTALE_UNDYNES_SPEAR, "Undyne's Spear", "Undertale", CosmeticTarget.SPEAR, 0x00BFFF, CosmeticSounds.apply(ZAMSounds.UNDERTALE_COSMETIC_EQUIP.location()));
        register(UNDERTALE_GASTER_BLASTER, "Gaster Blaster", "Undertale", CosmeticTarget.BOW, 0x00A2FF, CosmeticSounds.bow(ZAMSounds.UNDERTALE_COSMETIC_EQUIP.location(), ZAMSounds.UNDERTALE_BOW_SHOOT.location()));
        register(UNDERTALE_LAMP_SHADE, "Lamp Shade", "Undertale", CosmeticTarget.HELMET, 0x8FCDD0, CosmeticSounds.apply(ZAMSounds.UNDERTALE_COSMETIC_EQUIP.location()).withEquip(ZAMSounds.UNDERTALE_EQUIP.location()));
    }

    private static void register(Item cosmetic, String name, String collection, CosmeticTarget target, int color, CosmeticSounds sounds) {
        register(cosmetic, name, collection, new CosmeticTarget[]{target}, color, sounds);
    }

    private static void register(Item cosmetic, String name, String collection, CosmeticTarget target, CosmeticTarget secondTarget, int color, CosmeticSounds sounds) {
        register(cosmetic, name, collection, new CosmeticTarget[]{target, secondTarget}, color, sounds);
    }

    private static void register(Item cosmetic, String name, String collection, CosmeticTarget[] targets, int color, CosmeticSounds sounds) {
        CosmeticTarget target = targets[0];
        List<CosmeticTarget> additionalTargets = List.of(targets).subList(1, targets.length);
        Identifier skinId = BuiltInRegistries.ITEM.getKey(cosmetic);
        CosmeticPatternComponent definition = new CosmeticPatternComponent(skinId, skinId, name, collection, target, color, sounds.apply(), sounds.equip(), sounds.cast(), sounds.bite(), sounds.reel(),
                Optional.empty(), sounds.shoot(), sounds.attack(), additionalTargets);

        CosmeticPatterns.register(skinId, cosmeticTemplate(target), definition);
    }

    public static Item cosmeticTemplate(CosmeticTarget target) {
        return switch (target) {
            case SWORD -> ZAMItems.SWORD_COSMETIC_PATTERN;
            case PICKAXE -> ZAMItems.PICKAXE_COSMETIC_PATTERN;
            case SHOVEL -> ZAMItems.SHOVEL_COSMETIC_PATTERN;
            case AXE -> ZAMItems.AXE_COSMETIC_PATTERN;
            case HOE -> ZAMItems.HOE_COSMETIC_PATTERN;
            case KNIFE -> ZAMItems.KNIFE_COSMETIC_PATTERN;
            case SPEAR -> ZAMItems.SPEAR_COSMETIC_PATTERN;
            case MACE -> ZAMItems.MACE_COSMETIC_PATTERN;
            case FISHING_ROD -> ZAMItems.FISHING_ROD_COSMETIC_PATTERN;
            case HELMET -> ZAMItems.HELMET_COSMETIC_PATTERN;
            case SHEARS -> ZAMItems.SHEARS_COSMETIC_PATTERN;
            case BOW -> ZAMItems.BOW_COSMETIC_PATTERN;
        };
    }
}
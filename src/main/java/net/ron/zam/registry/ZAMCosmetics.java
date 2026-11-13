package net.ron.zam.registry;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.ron.zam.common.component.CosmeticPatternComponent;
import net.ron.zam.util.cosmetic.CosmeticPatterns;
import net.ron.zam.util.cosmetic.CosmeticSounds;
import net.ron.zam.util.cosmetic.CosmeticTarget;

import java.util.Optional;

public final class ZAMCosmetics {
    public static final Item CASTLE_CRASHERS_UNICORN_SWORD = ZAMItems.registerItem("castle_crashers_unicorn_sword", Item::new);
    public static final Item CASTLE_CRASHERS_DEMON_SWORD = ZAMItems.registerItem("castle_crashers_demon_sword", Item::new);
    public static final Item CASTLE_CRASHERS_CHICKEN_SWORD = ZAMItems.registerItem("castle_crashers_chicken_sword", Item::new);
    public static final Item CASTLE_CRASHERS_RED_KNIGHT_HELMET = ZAMItems.registerItem("castle_crashers_red_knight_helmet", Item::new);
    public static final Item CASTLE_CRASHERS_ORANGE_KNIGHT_HELMET = ZAMItems.registerItem("castle_crashers_orange_knight_helmet", Item::new);
    public static final Item CASTLE_CRASHERS_GREEN_KNIGHT_HELMET = ZAMItems.registerItem("castle_crashers_green_knight_helmet", Item::new);
    public static final Item CASTLE_CRASHERS_BLUE_KNIGHT_HELMET = ZAMItems.registerItem("castle_crashers_blue_knight_helmet", Item::new);
    public static final Item CASTLE_CRASHERS_PURPLE_KNIGHT_HELMET = ZAMItems.registerItem("castle_crashers_purple_knight_helmet", Item::new);

    public static final Item HELLS_RETRIEVER = ZAMItems.registerItem("hells_retriever_axe", Item::new);

    public static final Item MINECRAFT_PIRATE_CUTLASS_SWORD = ZAMItems.registerItem("minecraft_pirate_cutlass_sword", Item::new);
    public static final Item MINECRAFT_ECHO_OF_THE_VALLEY_BOW = ZAMItems.registerItem("minecraft_echo_of_the_valley_bow", Item::new);
    public static final Item MINECRAFT_ANCHOR_MACE = ZAMItems.registerItem("minecraft_anchor_mace", Item::new);
    public static final Item MINECRAFT_BEE_HELMET = ZAMItems.registerItem("minecraft_bee_helmet", Item::new);
    public static final Item MINECRAFT_WOLF_HELMET = ZAMItems.registerItem("minecraft_wolf_helmet", Item::new);

    public static final Item SPONGEBOB_GOLDEN_SPATULA = ZAMItems.registerItem("spongebob_golden_spatula", Item::new);
    public static final Item SPONGEBOB_JELLYFISHING_NET = ZAMItems.registerItem("spongebob_jellyfishing_net", Item::new);
    public static final Item SPONGEBOB_MARLIN_LANCE = ZAMItems.registerItem("spongebob_marlin_lance", Item::new);
    public static final Item SPONGEBOB_KRUSTY_KRAB_HAT = ZAMItems.registerItem("spongebob_krusty_krab_hat", Item::new);

    public static final Item STARDEW_VALLEY_DRAGONTOOTH_CUTLASS = ZAMItems.registerItem("stardew_valley_dragontooth_cutlass", Item::new);
    public static final Item STARDEW_VALLEY_IRIDIUM_HOE = ZAMItems.registerItem("stardew_valley_iridium_hoe", Item::new);
    public static final Item STARDEW_VALLEY_IRIDIUM_FISHING_ROD = ZAMItems.registerItem("stardew_valley_iridium_fishing_rod", Item::new);
    public static final Item STARDEW_VALLEY_NEPTUNES_GLAIVE = ZAMItems.registerItem("stardew_valley_neptunes_glaive", Item::new);
    public static final Item STARDEW_VALLEY_INFINITY_CROWN = ZAMItems.registerItem("stardew_valley_infinity_crown", Item::new);
    public static final Item STARDEW_VALLEY_STRAW_HAT = ZAMItems.registerItem("stardew_valley_straw_hat", Item::new);

    public static final Item UNDERTALE_REAL_KNIFE = ZAMItems.registerItem("undertale_real_knife", Item::new);
    public static final Item UNDERTALE_NICE_CREAM_SHOVEL = ZAMItems.registerItem("undertale_nice_cream_shovel", Item::new);
    public static final Item UNDERTALE_UNDYNES_SPEAR = ZAMItems.registerItem("undertale_undynes_spear", Item::new);
    public static final Item UNDERTALE_GASTER_BLASTER = ZAMItems.registerItem("undertale_gaster_blaster", Item::new);
    public static final Item UNDERTALE_LAMP_SHADE = ZAMItems.registerItem("undertale_lamp_shade", Item::new);

    public static void registerCosmetics() {
        register(CASTLE_CRASHERS_UNICORN_SWORD, "Unicorn Sword", "Castle Crashers", CosmeticTarget.SWORD, 0xFFB6C1, CosmeticSounds.apply(ZAMSounds.CASTLE_CRASHERS_COSMETIC_EQUIP.location()));
        register(CASTLE_CRASHERS_DEMON_SWORD, "Demon Sword", "Castle Crashers", CosmeticTarget.SWORD, 0xFF2400, CosmeticSounds.apply(ZAMSounds.CASTLE_CRASHERS_COSMETIC_EQUIP.location()));
        register(CASTLE_CRASHERS_CHICKEN_SWORD, "Chicken Sword", "Castle Crashers", CosmeticTarget.SWORD, 0xFFFFFF, CosmeticSounds.apply(ZAMSounds.CASTLE_CRASHERS_COSMETIC_EQUIP.location()));
        register(CASTLE_CRASHERS_RED_KNIGHT_HELMET, "Red Knight Helmet", "Castle Crashers", CosmeticTarget.HELMET, 0xFF5555, CosmeticSounds.apply(ZAMSounds.CASTLE_CRASHERS_COSMETIC_EQUIP.location()).withEquip(ZAMSounds.RED_KNIGHT_EQUIP.location()));
        register(CASTLE_CRASHERS_ORANGE_KNIGHT_HELMET, "Orange Knight Helmet", "Castle Crashers", CosmeticTarget.HELMET, 0xFFAA00, CosmeticSounds.apply(ZAMSounds.CASTLE_CRASHERS_COSMETIC_EQUIP.location()).withEquip(ZAMSounds.ORANGE_KNIGHT_EQUIP.location()));
        register(CASTLE_CRASHERS_GREEN_KNIGHT_HELMET, "Green Knight Helmet", "Castle Crashers", CosmeticTarget.HELMET, 0x55FF55, CosmeticSounds.apply(ZAMSounds.CASTLE_CRASHERS_COSMETIC_EQUIP.location()).withEquip(ZAMSounds.GREEN_KNIGHT_EQUIP.location()));
        register(CASTLE_CRASHERS_BLUE_KNIGHT_HELMET, "Blue Knight Helmet", "Castle Crashers", CosmeticTarget.HELMET, 0x5555FF, CosmeticSounds.apply(ZAMSounds.CASTLE_CRASHERS_COSMETIC_EQUIP.location()).withEquip(ZAMSounds.BLUE_KNIGHT_EQUIP.location()));
        register(CASTLE_CRASHERS_PURPLE_KNIGHT_HELMET, "Purple Knight Helmet", "Castle Crashers", CosmeticTarget.HELMET, 0xAA00AA, CosmeticSounds.apply(ZAMSounds.CASTLE_CRASHERS_COSMETIC_EQUIP.location()).withEquip(ZAMSounds.PURPLE_KNIGHT_EQUIP.location()));

        register(MINECRAFT_PIRATE_CUTLASS_SWORD, "Pirate Cutlass", "Minecraft", CosmeticTarget.SWORD, 0xA3BEC9, CosmeticSounds.apply(SoundEvents.ARMOR_EQUIP_GENERIC.value().location()));
        register(MINECRAFT_ANCHOR_MACE, "Anchor", "Minecraft", CosmeticTarget.MACE, 0x647D87, CosmeticSounds.apply(SoundEvents.ARMOR_EQUIP_GENERIC.value().location()));
        register(MINECRAFT_ECHO_OF_THE_VALLEY_BOW, "Echo of the Valley", "Minecraft", CosmeticTarget.BOW, 0x5E8746, CosmeticSounds.apply(SoundEvents.ARMOR_EQUIP_GENERIC.value().location()));
        register(MINECRAFT_BEE_HELMET, "Bee Helmet", "Minecraft", CosmeticTarget.HELMET, 0xF2C94C, CosmeticSounds.apply(SoundEvents.ARMOR_EQUIP_GENERIC.value().location()).withEquip(ZAMSounds.MINECRAFT_BEE_EQUIP.location()));
        register(MINECRAFT_WOLF_HELMET, "Wolf Helmet", "Minecraft", CosmeticTarget.HELMET, 0xB8B8B8, CosmeticSounds.apply(SoundEvents.ARMOR_EQUIP_GENERIC.value().location()).withEquip(ZAMSounds.MINECRAFT_WOLF_EQUIP.location()));

        register(HELLS_RETRIEVER, "Hell's Retriever", "Call of Duty Zombies", CosmeticTarget.AXE, 0x8A0303, CosmeticSounds.apply(ZAMSounds.HELLS_RETRIEVER_COSMETIC_EQUIP.location()));

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
        register(cosmetic, name, collection, target, null, color, sounds);
    }

    private static void register(Item cosmetic, String name, String collection, CosmeticTarget target, CosmeticTarget fallback, int color, CosmeticSounds sounds) {
        Identifier skinId = BuiltInRegistries.ITEM.getKey(cosmetic);
        CosmeticPatternComponent definition = new CosmeticPatternComponent(skinId, skinId, name, collection, target, color,
                sounds.apply(), sounds.equip(), sounds.cast(), sounds.bite(), sounds.reel(), Optional.ofNullable(fallback), sounds.shoot(), sounds.attack());

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
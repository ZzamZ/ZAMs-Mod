package net.ron.zam.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.trading.VillagerTrade;
import net.minecraft.world.level.block.Block;
import net.ron.zam.ZAMMod;

public class ZAMTags {
    public static final TagKey<Item> COSMETIC_HELMETS = cosmeticTarget("helmets");
    public static final TagKey<Item> COSMETIC_SWORDS = cosmeticTarget("swords");
    public static final TagKey<Item> COSMETIC_PICKAXES = cosmeticTarget("pickaxes");
    public static final TagKey<Item> COSMETIC_AXES = cosmeticTarget("axes");
    public static final TagKey<Item> COSMETIC_SHOVELS = cosmeticTarget("shovels");
    public static final TagKey<Item> COSMETIC_HOES = cosmeticTarget("hoes");
    public static final TagKey<Item> COSMETIC_BOWS = cosmeticTarget("bows");
    public static final TagKey<Item> COSMETIC_MACES = cosmeticTarget("maces");
    public static final TagKey<Item> COSMETIC_SPEARS = cosmeticTarget("spears");
    public static final TagKey<Item> COSMETIC_FISHING_RODS = cosmeticTarget("fishing_rods");
    public static final TagKey<Item> COSMETIC_SHEARS = cosmeticTarget("shears");
    public static final TagKey<Item> COSMETIC_KNIVES = cosmeticTarget("knives");

    public static final TagKey<Item> CASES = TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(ZAMMod.MOD_ID, "cases"));
    public static final TagKey<Item> CASTLE_CRASHERS_MUSIC_DISCS = TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(ZAMMod.MOD_ID, "castle_crashers_music_discs"));
    public static final TagKey<Item> COD_ZOMBIES_MUSIC_DISCS = TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(ZAMMod.MOD_ID, "cod_zombies_music_discs"));
    public static final TagKey<Item> MINECRAFT_MUSIC_DISCS = TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(ZAMMod.MOD_ID, "minecraft_music_discs"));
    public static final TagKey<Item> SPONGEBOB_MUSIC_DISCS = TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(ZAMMod.MOD_ID, "spongebob_music_discs"));
    public static final TagKey<Item> STARDEW_VALLEY_MUSIC_DISCS = TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(ZAMMod.MOD_ID, "stardew_valley_music_discs"));
    public static final TagKey<Item> UNDERTALE_MUSIC_DISCS = TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(ZAMMod.MOD_ID, "undertale_music_discs"));

    private static TagKey<Item> cosmeticTarget(String name) {
        return TagKey.create(Registries.ITEM, ZAMMod.id("cosmetic_targets/" + name));
    }
}

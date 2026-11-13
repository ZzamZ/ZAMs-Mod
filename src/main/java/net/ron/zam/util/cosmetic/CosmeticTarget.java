package net.ron.zam.util.cosmetic;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.ron.zam.registry.ZAMTags;

import java.util.Arrays;
import java.util.Locale;
import java.util.Optional;

public enum CosmeticTarget {
    HELMET(ZAMTags.COSMETIC_HELMETS), SWORD(ZAMTags.COSMETIC_SWORDS), PICKAXE(ZAMTags.COSMETIC_PICKAXES),
    AXE(ZAMTags.COSMETIC_AXES), SHOVEL(ZAMTags.COSMETIC_SHOVELS), HOE(ZAMTags.COSMETIC_HOES),
    BOW(ZAMTags.COSMETIC_BOWS), MACE(ZAMTags.COSMETIC_MACES), SPEAR(ZAMTags.COSMETIC_SPEARS),
    FISHING_ROD(ZAMTags.COSMETIC_FISHING_RODS), SHEARS(ZAMTags.COSMETIC_SHEARS), KNIFE(ZAMTags.COSMETIC_KNIVES);

    private final TagKey<Item> tag;

    CosmeticTarget(TagKey<Item> tag) {
        this.tag = tag;
    }

    public CosmeticTarget resolve(Optional<CosmeticTarget> fallback) {
        if (this == KNIFE && !FabricLoader.getInstance().isModLoaded("farmersdelight")) {
            return fallback.orElse(this);
        }
        return this;
    }

    public TagKey<Item> tag() {
        return tag;
    }

    public String nameTranslationKey() {
        return "tooltip.zam.cosmetic.target." + serializedName();
    }

    public String serializedName() {
        return name().toLowerCase(Locale.ROOT);
    }

    public static Optional<CosmeticTarget> fromSerializedName(String name) {
        return Arrays.stream(values())
                .filter(target -> target.serializedName().equals(name))
                .findFirst();
    }

    public static CosmeticTarget require(String name) {
        return fromSerializedName(name)
                .orElseThrow(() -> new IllegalArgumentException("Unknown cosmetic target: " + name));
    }
}
package net.ron.zam.util.cosmetic;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.ron.zam.common.component.CosmeticPatternComponent;
import net.ron.zam.registry.ZAMComponents;

public final class CosmeticPreview {
    private CosmeticPreview() {
    }

    public static ItemStack displayStack(ItemStack reward) {
        CosmeticPatternComponent pattern = reward.get(ZAMComponents.COSMETIC_PATTERN);
        if (pattern == null)
            return reward.copy();

        Item cosmetic = BuiltInRegistries.ITEM.getValue(pattern.skinId());
        return new ItemStack(cosmetic);
    }
}

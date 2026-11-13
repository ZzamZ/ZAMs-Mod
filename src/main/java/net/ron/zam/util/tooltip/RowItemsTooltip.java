package net.ron.zam.util.tooltip;

import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public record RowItemsTooltip(List<ItemStack> items, List<Boolean> collectedFlags, boolean gapAfterCollectedLine) implements TooltipComponent {
}

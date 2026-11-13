package net.ron.zam.util.tooltip;

import net.minecraft.network.chat.Component;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.ItemStack;

public record CosmeticPatternTooltip(ItemStack preview, Component target, String collection, String name, int color) implements TooltipComponent {
}

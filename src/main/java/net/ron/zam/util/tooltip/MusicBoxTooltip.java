package net.ron.zam.util.tooltip;

import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.ItemStack;

public record MusicBoxTooltip(ItemStack disc, boolean paused, boolean looping) implements TooltipComponent {
}
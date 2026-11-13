package net.ron.zam.util.tooltip;

import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.component.BundleContents;

public record RecordSleeveTooltip(BundleContents contents) implements TooltipComponent {
}

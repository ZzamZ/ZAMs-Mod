package net.ron.zam.util.tooltip;

import net.minecraft.resources.Identifier;
import net.minecraft.world.inventory.tooltip.TooltipComponent;

public record CompletionBannerTooltip(Identifier texture) implements TooltipComponent {}
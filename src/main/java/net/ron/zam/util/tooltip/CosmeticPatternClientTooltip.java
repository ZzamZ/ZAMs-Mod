package net.ron.zam.util.tooltip;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.network.chat.Component;

public final class CosmeticPatternClientTooltip implements ClientTooltipComponent {
    private static final int ICON_SIZE = 16;
    private static final int GAP = 4;
    private static final int INDENT = 4;
    private static final int BLOCK_GAP = 5;
    private static final int LABEL_COLOR = 0xFFAAAAAA;
    private static final int VALUE_COLOR = 0xFF5555FF;
    private final CosmeticPatternTooltip data;

    public CosmeticPatternClientTooltip(CosmeticPatternTooltip data) {
        this.data = data;
    }

    @Override
    public int getHeight(Font font) {
        return font.lineHeight * 4 + BLOCK_GAP * 2 + ICON_SIZE + 2;
    }

    @Override
    public int getWidth(Font font) {
        Component collection = collectionName();
        int width = font.width(collection);
        width = Math.max(width, font.width(Component.translatable("tooltip.zam.cosmetic.applies_to")));
        width = Math.max(width, INDENT + font.width(data.target()));
        width = Math.max(width, font.width(Component.translatable("tooltip.zam.cosmetic.pattern")));
        return Math.max(width, INDENT + ICON_SIZE + GAP + font.width(data.name()));
    }

    @Override
    public void extractImage(Font font, int x, int y, int tooltipZ, int packedLight, GuiGraphicsExtractor g) {
        int lineY = y;
        Component collection = collectionName();
        g.text(font, collection, x, lineY, 0xFFFFFFFF, true);
        lineY += font.lineHeight + BLOCK_GAP;
        g.text(font, Component.translatable("tooltip.zam.cosmetic.applies_to"), x, lineY, LABEL_COLOR, true);
        lineY += font.lineHeight;
        g.text(font, data.target(), x + INDENT, lineY, VALUE_COLOR, true);
        lineY += font.lineHeight + BLOCK_GAP;
        g.text(font, Component.translatable("tooltip.zam.cosmetic.pattern"), x, lineY, LABEL_COLOR, true);
        lineY += font.lineHeight + 1;
        g.item(data.preview(), x + INDENT, lineY);
        g.itemDecorations(Minecraft.getInstance().font, data.preview(), x + INDENT, lineY);
        g.text(font, Component.literal(data.name()), x + INDENT + ICON_SIZE + GAP, lineY + 4, 0xFF000000 | data.color(),
                true);
    }

    private Component collectionName() {
        return Component.translatable("tooltip.zam.cosmetic.collection", data.collection()).withStyle(
                ChatFormatting.DARK_PURPLE, ChatFormatting.ITALIC);
    }
}

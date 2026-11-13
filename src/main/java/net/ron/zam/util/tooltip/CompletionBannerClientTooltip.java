package net.ron.zam.util.tooltip;

import com.mojang.blaze3d.platform.NativeImage;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.client.renderer.RenderPipelines;

import java.io.IOException;

public final class CompletionBannerClientTooltip implements ClientTooltipComponent {
    private static final int PREVIEW_SIZE = 48;
    private static final int PADDING = 2;

    private final CompletionBannerTooltip data;
    private int textureWidth = PREVIEW_SIZE;
    private int textureHeight = PREVIEW_SIZE;
    private int sourceX;
    private int sourceWidth = PREVIEW_SIZE;
    private int width = PREVIEW_SIZE;
    private int height = PREVIEW_SIZE;

    public CompletionBannerClientTooltip(CompletionBannerTooltip data) {
        this.data = data;

        try (var stream = Minecraft.getInstance().getResourceManager().getResourceOrThrow(data.texture()).open();
             NativeImage image = NativeImage.read(stream)) {
            textureWidth = image.getWidth();
            textureHeight = image.getHeight();
            float scale = (float) PREVIEW_SIZE / Math.max(textureWidth, textureHeight);

            int left = textureWidth;
            int right = -1;
            for (int y = 0; y < textureHeight; y++) {
                for (int x = 0; x < textureWidth; x++) {
                    if ((image.getPixel(x, y) >>> 24) != 0) {
                        left = Math.min(left, x);
                        right = Math.max(right, x);
                    }
                }
            }

            sourceX = right >= left ? left : 0;
            sourceWidth = right >= left ? right - left + 1 : textureWidth;
            width = Math.max(1, Math.round(sourceWidth * scale));
            height = Math.max(1, Math.round(textureHeight * scale));
        } catch (IOException ignored) {
        }
    }

    @Override
    public int getHeight(Font font) {
        return height + PADDING * 2;
    }

    @Override
    public int getWidth(Font font) {
        return width;
    }

    @Override
    public void extractImage(Font font, int x, int y, int tooltipZ, int packedLight, GuiGraphicsExtractor graphics) {
        graphics.blit(RenderPipelines.GUI_TEXTURED, data.texture(), x, y + PADDING,
                sourceX, 0, width, height, sourceWidth, textureHeight, textureWidth, textureHeight);
    }
}
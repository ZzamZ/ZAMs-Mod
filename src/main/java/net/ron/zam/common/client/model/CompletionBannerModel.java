package net.ron.zam.common.client.model;

import com.mojang.blaze3d.platform.NativeImage;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.ron.zam.common.client.CompletionBannerRenderState;

import java.util.Set;

public class CompletionBannerModel extends Model<CompletionBannerRenderState> {
    private final ModelPart flag;

    public CompletionBannerModel(ModelPart root) {
        super(root, RenderTypes::entityCutout);
        this.flag = root.getChild("banner").getChild("flag");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        var banner = mesh.getRoot().addOrReplaceChild("banner", CubeListBuilder.create(),
                PartPose.offset(0.0F, -16.0F, 7.0F));
        banner.addOrReplaceChild("flag", CubeListBuilder.create(), PartPose.ZERO);
        banner.addOrReplaceChild("stick", CubeListBuilder.create().texOffs(0, 0)
                .addBox(-10.0F, -2.0F, -0.9F, 20.0F, 2.0F, 2.0F), PartPose.ZERO);
        return LayerDefinition.create(mesh, 64, 64);
    }

    public static LayerDefinition createClothLayer(NativeImage image, int clothRows) {
        int width = image.getWidth();
        int minX = width, maxX = -1, minY = clothRows, maxY = -1;
        for (int y = 0; y < clothRows; y++) {
            for (int x = 0; x < width; x++) {
                if (opaque(image, x, y, clothRows)) {
                    minX = Math.min(minX, x);
                    maxX = Math.max(maxX, x);
                    minY = Math.min(minY, y);
                    maxY = Math.max(maxY, y);
                }
            }
        }
        MeshDefinition mesh = new MeshDefinition();
        var banner = mesh.getRoot().addOrReplaceChild("banner", CubeListBuilder.create(), PartPose.offset(0.0F, -16.0F, 7.0F));
        CubeListBuilder cloth = CubeListBuilder.create();
        if (maxX >= minX) {
            int topLeft = width, topRight = -1;
            for (int x = minX; x <= maxX; x++) {
                if (opaque(image, x, minY, clothRows)) {
                    topLeft = Math.min(topLeft, x);
                    topRight = Math.max(topRight, x);
                }
            }
            float center = (topLeft + topRight + 1) / 2.0F;
            int w = maxX - minX + 1, h = maxY - minY + 1;
            face(cloth, minX - center, 0, w, h, Direction.NORTH, minX - 1, minY - 1);
            cloth.mirror(true);
            face(cloth, minX - center, 0, w, h, Direction.SOUTH, minX - w - 2, minY - 1);
            cloth.mirror(false);
            for (int y = minY; y <= maxY; y++) {
                for (int x = minX; x <= maxX; x++) {
                    if (!opaque(image, x, y, clothRows)) continue;
                    float px = x - center, py = y - minY;
                    if (!opaque(image, x - 1, y, clothRows))
                        face(cloth, px, py, 1, 1, Direction.WEST, x, y - 1);
                    if (!opaque(image, x + 1, y, clothRows))
                        face(cloth, px, py, 1, 1, Direction.EAST, x - 2, y - 1);
                    if (!opaque(image, x, y - 1, clothRows))
                        face(cloth, px, py, 1, 1, Direction.DOWN, x - 1, y);
                    if (!opaque(image, x, y + 1, clothRows))
                        face(cloth, px, py, 1, 1, Direction.UP, x - 2, y);
                }
            }
        }
        banner.addOrReplaceChild("flag", cloth, PartPose.ZERO);
        return LayerDefinition.create(mesh, image.getWidth(), image.getHeight());
    }

    private static boolean opaque(NativeImage image, int x, int y, int rows) {
        return x >= 0 && x < image.getWidth() && y >= 0 && y < rows
                && (image.getPixel(x, y) >>> 24) >= 128;
    }

    private static void face(CubeListBuilder cloth, float x, float y, int width, int height, Direction direction, int u, int v) {
        cloth.texOffs(u, v).addBox(x, y, -0.5F, width, height, 1.0F, Set.of(direction));
    }

    @Override
    public void setupAnim(CompletionBannerRenderState state) {
        super.setupAnim(state);
        this.flag.xRot = Mth.sin(state.phase) * 0.008F;
    }
}

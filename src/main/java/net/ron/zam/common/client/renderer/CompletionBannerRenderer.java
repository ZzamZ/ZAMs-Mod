package net.ron.zam.common.client.renderer;

import com.mojang.blaze3d.platform.NativeImage;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.Vec3;
import net.ron.zam.common.block.banner.CompletionBannerBlock;
import net.ron.zam.common.block.banner.CompletionBannerBlockEntity;
import net.ron.zam.common.client.CompletionBannerRenderState;
import net.ron.zam.common.client.ZAMModelLayers;
import net.ron.zam.common.client.model.CompletionBannerModel;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CompletionBannerRenderer implements BlockEntityRenderer<CompletionBannerBlockEntity, CompletionBannerRenderState> {
    private final CompletionBannerModel model;
    private static final Identifier STICK_TEXTURE = Identifier.fromNamespaceAndPath("zam", "textures/block/completion_banner_stick.png");
    private final Map<Identifier, CompletionBannerModel> clothModels = new HashMap<>();

    public CompletionBannerRenderer(BlockEntityRendererProvider.Context ctx) {
        this.model = new CompletionBannerModel(ctx.bakeLayer(ZAMModelLayers.COMPLETION_BANNER));
    }

    @Override
    public CompletionBannerRenderState createRenderState() {
        return new CompletionBannerRenderState();
    }

    @Override
    public void extractRenderState(CompletionBannerBlockEntity be, CompletionBannerRenderState state, float partialTick, Vec3 cameraPos, ModelFeatureRenderer.CrumblingOverlay crumbling) {
        BlockEntityRenderState.extractBase(be, state, crumbling);
        state.facing = be.getBlockState().getValue(CompletionBannerBlock.FACING);
        state.block = be.getBlockState().getBlock();
        state.clothModel = this.clothModels.computeIfAbsent(textureFor(state.block), CompletionBannerRenderer::readClothModel);
        long time = be.getLevel() != null ? be.getLevel().getGameTime() : 0L;
        var pos = be.getBlockPos();
        long offset = pos.getX() * 7L + pos.getY() * 9L + pos.getZ() * 13L;
        float cycle = (Math.floorMod(time + offset, 100L) + partialTick) / 100.0F;
        state.phase = cycle * ((float) Math.PI * 2.0F);
    }

    @Override
    public void submit(CompletionBannerRenderState state, PoseStack pose, SubmitNodeCollector collector, CameraRenderState camera) {
        float yaw = switch (state.facing) {
            case NORTH -> 180.0F;
            case SOUTH -> 0.0F;
            case WEST -> 90.0F;
            case EAST -> -90.0F;
            default -> 0.0F;
        };

        pose.pushPose();
        pose.translate(0.5D, 0.5D, 0.5D);
        pose.translate(0.0F, -0.625F, 0.0F);
        pose.scale(1.0F, -1.0F, -1.0F);
        pose.rotateDegrees(Axis.YP, yaw);

        submitBannerPart(model, STICK_TEXTURE, state, pose, collector);
        if (state.clothModel != null) {
            submitBannerPart(state.clothModel, textureFor(state.block), state, pose, collector);
        }

        pose.popPose();
    }

    private static void submitBannerPart(CompletionBannerModel model, Identifier texture, CompletionBannerRenderState state, PoseStack pose, SubmitNodeCollector collector) {
        var renderType = RenderTypes.entityCutout(texture);
        collector.submitModel(model, state, pose, renderType,
                state.lightCoords, OverlayTexture.NO_OVERLAY, 0);

        if (state.breakProgress != null) {
            collector.submitCrumblingOverlay(model, state, pose, renderType,
                    state.lightCoords, OverlayTexture.NO_OVERLAY, -1, state.breakProgress);
        }
    }

    private static CompletionBannerModel readClothModel(Identifier texture) {
        try (var stream = Minecraft.getInstance().getResourceManager().getResourceOrThrow(texture).open();
             NativeImage image = NativeImage.read(stream)) {
            int clothRows = image.getHeight();
            if (image.getWidth() == 64 && image.getHeight() == 64) {
                for (int y = 40;
                     y <= 45; y++) {
                    boolean rod = true;
                    for (int row = 0; row < 4 && rod; row++) {
                        for (int x = 0; x < 44; x++) {
                            boolean expected = row >= 2 || (x >= 2 && x < 42);
                            if (((image.getPixel(x, y + row) >>> 24) == 0) == expected) {
                                rod = false;
                                break;
                            }
                        }
                    }
                    if (rod) {
                        clothRows = y;
                        break;
                    }
                }
            }
            return new CompletionBannerModel(CompletionBannerModel.createClothLayer(image, clothRows).bakeRoot());
        } catch (IOException ignored) {}
        return null;
    }
    private static Identifier textureFor(Block block) {
        Identifier blockId = BuiltInRegistries.BLOCK.getKey(block);
        return Identifier.fromNamespaceAndPath(blockId.getNamespace(),
                "textures/block/" + blockId.getPath() + ".png");
    }
}

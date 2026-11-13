package net.ron.zam.common.client;

import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;

public class CompletionBannerRenderState extends BlockEntityRenderState {
    public Direction facing = Direction.NORTH;
    public float phase;
    public net.ron.zam.common.client.model.CompletionBannerModel clothModel;
    public Block block;
}

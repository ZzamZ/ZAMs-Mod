package net.ron.zam.common.block;

import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.PathBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class SandPathBlock extends PathBlock {
    public SandPathBlock(BlockBehaviour.Properties properties) {
        super(Blocks.SAND, properties);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState path = defaultBlockState();

        if (!path.canSurvive(context.getLevel(), context.getClickedPos())) {
            return Block.pushEntitiesUp(path, Blocks.SAND.defaultBlockState(), context.getLevel(), context.getClickedPos());
        }

        return super.getStateForPlacement(context);
    }
}
package net.ron.zam.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class FairyLanternBlock extends LanternBlock {

    private static final VoxelShape STANDING_SHAPE =
            Block.box(5.0, 0.0, 5.0, 11.0, 9.0, 11.0);

    private static final VoxelShape HANGING_SHAPE =
            Block.box(5.0, 2.0, 5.0, 11.0, 10.0, 11.0);

    public FairyLanternBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        Direction direction = state.getValue(HANGING) ? Direction.UP : Direction.DOWN;
        BlockPos supportPos = pos.relative(direction);
        BlockState supportState = level.getBlockState(supportPos);

        if (super.canSurvive(state, level, pos)) {
            return true;
        }

        return supportState.is(BlockTags.LEAVES);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return state.getValue(HANGING) ? HANGING_SHAPE : STANDING_SHAPE;
    }
}
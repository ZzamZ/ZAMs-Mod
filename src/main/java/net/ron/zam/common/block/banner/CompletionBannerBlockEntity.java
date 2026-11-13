package net.ron.zam.common.block.banner;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.ron.zam.registry.ZAMBlockEntities;

public class CompletionBannerBlockEntity extends BlockEntity {
    public CompletionBannerBlockEntity(BlockPos pos, BlockState state) {
        super(ZAMBlockEntities.COMPLETION_BANNER, pos, state);
    }
}

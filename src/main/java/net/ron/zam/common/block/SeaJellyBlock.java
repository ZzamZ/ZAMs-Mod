package net.ron.zam.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.ron.zam.registry.ZAMItems;

public class SeaJellyBlock extends Block {

    public SeaJellyBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {

        if (!stack.is(Items.SHEARS)) {
            return super.useItemOn(stack, state, level, pos, player, hand, hit);
        }

        if (level instanceof ServerLevel serverLevel) {

            popResource(level, pos, new ItemStack(ZAMItems.SEA_JELLY));

            level.setBlock(pos, Blocks.WET_SPONGE.defaultBlockState(), 11);

            level.playSound(null, pos, SoundEvents.SPONGE_ABSORB, SoundSource.BLOCKS, 1.0F, 1.0F);

            stack.hurtAndBreak(1, player, hand.asEquipmentSlot());

            level.gameEvent(player, GameEvent.SHEAR, pos);

            player.awardStat(Stats.ITEM_USED.get(Items.SHEARS));
        }

        return InteractionResult.SUCCESS;
    }
}
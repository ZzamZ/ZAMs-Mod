package net.ron.zam.common.block.fortune;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;

public class MarinersFortuneChestBlockItem extends BlockItem {

    public MarinersFortuneChestBlockItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public Component getName(ItemStack stack) {
        return super.getName(stack).copy().withStyle(Rarity.RARE.color());
    }
}
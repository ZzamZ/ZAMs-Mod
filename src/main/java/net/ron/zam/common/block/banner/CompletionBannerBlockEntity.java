package net.ron.zam.common.block.banner;

import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponentGetter;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.component.ItemLore;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.ron.zam.registry.ZAMBlockEntities;

public class CompletionBannerBlockEntity extends BlockEntity {
    private CustomData customData = CustomData.EMPTY;
    private ItemLore lore = ItemLore.EMPTY;

    public CompletionBannerBlockEntity(BlockPos pos, BlockState state) {
        super(ZAMBlockEntities.COMPLETION_BANNER, pos, state);
    }

    public void setItemComponents(ItemStack stack) {
        this.customData = stack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY);
        this.lore = stack.getOrDefault(DataComponents.LORE, ItemLore.EMPTY);
        this.setChanged();
    }
    @Override
    protected void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);
        output.store("CustomData", CustomData.CODEC, this.customData);
        output.store("Lore", ItemLore.CODEC, this.lore);
    }

    @Override
    protected void loadAdditional(ValueInput input) {
        super.loadAdditional(input);
        this.customData = input.read("CustomData", CustomData.CODEC).orElse(CustomData.EMPTY);
        this.lore = input.read("Lore", ItemLore.CODEC).orElse(ItemLore.EMPTY);
    }

    @Override
    protected void applyImplicitComponents(DataComponentGetter components) {
        super.applyImplicitComponents(components);
        this.customData = components.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY);
        this.lore = components.getOrDefault(DataComponents.LORE, ItemLore.EMPTY);
    }

    @Override
    protected void collectImplicitComponents(DataComponentMap.Builder components) {
        super.collectImplicitComponents(components);
        if (!this.customData.isEmpty()) {
            components.set(DataComponents.CUSTOM_DATA, this.customData);
        }
        if (!this.lore.lines().isEmpty()) {
            components.set(DataComponents.LORE, this.lore);
        }
    }
}

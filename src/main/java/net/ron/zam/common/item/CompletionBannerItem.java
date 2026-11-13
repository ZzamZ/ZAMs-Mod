package net.ron.zam.common.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.block.Block;
import net.ron.zam.util.tooltip.CompletionBannerTooltip;

import java.util.Optional;
import java.util.function.Consumer;

public class CompletionBannerItem extends BlockItem {
    private final String collection;

    public CompletionBannerItem(Block block, String collection, Properties properties) {
        super(block, properties);
        this.collection = collection;
    }

    @Override
    public Optional<TooltipComponent> getTooltipImage(ItemStack stack) {
        Identifier id = BuiltInRegistries.BLOCK.getKey(getBlock());
        Identifier texture = Identifier.fromNamespaceAndPath(id.getNamespace(), "textures/block/" + id.getPath() + ".png");
        return Optional.of(new CompletionBannerTooltip(texture));
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay display, Consumer<Component> consumer, TooltipFlag flag) {
        super.appendHoverText(stack, context, display, consumer, flag);

        if (collection != null && !collection.isEmpty()) {
            consumer.accept(Component.literal(collection + " Collection")
                    .withStyle(ChatFormatting.DARK_PURPLE, ChatFormatting.ITALIC));
        }
    }
}
package net.ron.zam.common.component;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponentGetter;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipProvider;
import net.minecraft.world.item.equipment.Equippable;
import net.ron.zam.registry.ZAMComponents;
import net.ron.zam.registry.ZAMCosmetics;
import net.ron.zam.registry.ZAMItems;

import java.util.Optional;
import java.util.function.Consumer;

public record AppliedCosmeticComponent(Identifier skinId, Identifier originalModel, Optional<Equippable> originalEquippable, int tooltipColor, Optional<CosmeticPatternComponent> patternDefinition) implements TooltipProvider {
    public static final Codec<AppliedCosmeticComponent> CODEC = RecordCodecBuilder.create(
            instance -> instance.group(Identifier.CODEC.fieldOf("skin").forGetter(AppliedCosmeticComponent::skinId),
                    Identifier.CODEC.fieldOf("original_model").forGetter(AppliedCosmeticComponent::originalModel),
                    Equippable.CODEC.optionalFieldOf("original_equippable").forGetter(AppliedCosmeticComponent::originalEquippable),
                    Codec.INT.optionalFieldOf("tooltip_color", 0xFFD700).forGetter(AppliedCosmeticComponent::tooltipColor),
                    CosmeticPatternComponent.CODEC.optionalFieldOf("token_definition").forGetter(AppliedCosmeticComponent::patternDefinition)).apply(instance,
                    AppliedCosmeticComponent::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, AppliedCosmeticComponent> STREAM_CODEC =
            StreamCodec.composite(Identifier.STREAM_CODEC, AppliedCosmeticComponent::skinId, Identifier.STREAM_CODEC,
                    AppliedCosmeticComponent::originalModel, ByteBufCodecs.optional(Equippable.STREAM_CODEC),
                    AppliedCosmeticComponent::originalEquippable, ByteBufCodecs.VAR_INT,
                    AppliedCosmeticComponent::tooltipColor,
                    ByteBufCodecs.optional(CosmeticPatternComponent.STREAM_CODEC),
                    AppliedCosmeticComponent::patternDefinition, AppliedCosmeticComponent::new);

    @Override
    public void addToTooltip(Item.TooltipContext context, Consumer<Component> consumer, TooltipFlag flag, DataComponentGetter components) {
        Component skinName = displayName();
        consumer.accept(Component.translatable("tooltip.zam.cosmetic.applied").withStyle(ChatFormatting.GRAY));
        consumer.accept(Component.literal(" ").append(skinName).withColor(tooltipColor));
    }

    public ItemStack createReturnedItem() {
        if (patternDefinition.isPresent()) {
            CosmeticPatternComponent definition = patternDefinition.get();
            ItemStack token = new ItemStack(ZAMCosmetics.cosmeticTemplate(definition.target()));
            token.set(ZAMComponents.COSMETIC_PATTERN, definition);
            return token;
        }
        return new ItemStack(
                BuiltInRegistries.ITEM.getValue(skinId));
    }

    public Component displayName() {
        return patternDefinition.<Component>map(definition -> Component.literal(definition.patternName())).orElseGet(
                () -> Component.translatable("item." + skinId.getNamespace() + "." + skinId.getPath()));
    }
}


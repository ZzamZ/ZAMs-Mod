package net.ron.zam.common.item;

import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ClickAction;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.equipment.Equippable;
import net.ron.zam.ZAMMod;
import net.ron.zam.common.component.AppliedCosmeticComponent;
import net.ron.zam.common.component.CosmeticPatternComponent;
import net.ron.zam.registry.ZAMComponents;
import net.ron.zam.util.tooltip.CosmeticPatternTooltip;
import net.ron.zam.util.cosmetic.CosmeticPreview;
import net.ron.zam.util.cosmetic.CosmeticTarget;

import java.util.Optional;
import java.util.function.Consumer;

public class CosmeticPatternItem extends Item {
    private final String collection;
    private final CosmeticTarget target;
    private final Optional<CosmeticTarget> fallbackTarget;
    private final Identifier appliedModel;
    private final int tooltipColor;
    private final Equippable appliedEquippable;

    public CosmeticPatternItem(CosmeticTarget target, Properties properties) {
        this(null, target, null, 0xFFD700, null, properties);
    }

    public CosmeticPatternItem(String collection, CosmeticTarget target, Identifier appliedModel, int tooltipColor, Equippable appliedEquippable, Properties properties) {
        this(collection, target, Optional.empty(), appliedModel, tooltipColor, appliedEquippable, properties);
    }

    public CosmeticPatternItem(String collection, CosmeticTarget target, Optional<CosmeticTarget> fallbackTarget, Identifier appliedModel, int tooltipColor, Equippable appliedEquippable, Properties properties) {
        super(properties.stacksTo(1));
        this.fallbackTarget = fallbackTarget;
        this.collection = collection;
        this.target = target;
        this.appliedModel = appliedModel;
        this.tooltipColor = tooltipColor;
        this.appliedEquippable = appliedEquippable;
    }

    public CosmeticTarget target() {
        return target;
    }

    public Optional<CosmeticTarget> fallbackTarget() {
        return fallbackTarget;
    }

    public Identifier appliedModel() {
        return appliedModel;
    }

    @Override
    public boolean overrideStackedOnOther(ItemStack pattern, Slot slot, ClickAction action, Player player) {
        if (action != ClickAction.PRIMARY)
            return false;

        CosmeticPatternComponent definition = pattern.get(ZAMComponents.COSMETIC_PATTERN);
        CosmeticTarget effectiveTarget = definition == null ? target.resolve(fallbackTarget) : definition.effectiveTarget();
        Identifier effectiveModel = definition == null ? appliedModel : definition.model();
        int effectiveColor = definition == null ? tooltipColor : definition.tooltipColor();

        ItemStack tool = slot.getItem();
        if (effectiveModel == null || tool.isEmpty() || !tool.is(effectiveTarget.tag()) || tool.has(ZAMComponents.APPLIED_COSMETIC))
            return false;

        Identifier skinId = definition == null ? this.builtInRegistryHolder().key().identifier() : definition.skinId();
        Identifier originalModel = tool.get(DataComponents.ITEM_MODEL);
        if (originalModel == null)
            return false;
        tool.set(ZAMComponents.APPLIED_COSMETIC, new AppliedCosmeticComponent(skinId, originalModel,
                Optional.ofNullable(tool.get(DataComponents.EQUIPPABLE)), effectiveColor,
                Optional.ofNullable(definition)));
        tool.set(DataComponents.ITEM_MODEL, effectiveModel);
        Equippable equippable = appliedEquippable;
        if (definition != null) {
            Item registeredSkin = BuiltInRegistries.ITEM.getValue(definition.skinId());
            if (registeredSkin instanceof CosmeticPatternItem skin) {
                equippable = skin.appliedEquippable;
            }
        }
        if (definition != null && effectiveTarget == CosmeticTarget.HELMET) {
            if (definition.equipSound().isPresent()) {
                Equippable.Builder builder =
                        Equippable.builder(EquipmentSlot.HEAD).setSwappable(true).setDamageOnHurt(false);
                definition.equipSound().flatMap(BuiltInRegistries.SOUND_EVENT::get).ifPresent(builder::setEquipSound);
                equippable = builder.build();
            } else if (equippable == null) {
                equippable =
                        Equippable.builder(EquipmentSlot.HEAD).setSwappable(true).setDamageOnHurt(false).setEquipSound(
                                SoundEvents.ARMOR_EQUIP_GENERIC).build();
            }
        }
        if (equippable != null)
            tool.set(DataComponents.EQUIPPABLE, equippable);

        if (definition != null) {
            net.minecraft.sounds.SoundEvent applySound =
                    definition.applySound().map(BuiltInRegistries.SOUND_EVENT::getValue).orElse(
                            SoundEvents.SMITHING_TABLE_USE);
            if (definition.applySound().isEmpty()) {
                ZAMMod.LOGGER.warn("Cosmetic pattern {} has no apply sound; using smithing-table fallback",
                        definition.skinId());
            }
            player.playSound(applySound, 1.0F, 1.0F);
        }
        pattern.shrink(1);

        slot.setChanged();
        return true;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay display, Consumer<Component> consumer, TooltipFlag flag) {
        super.appendHoverText(stack, context, display, consumer, flag);
        CosmeticPatternComponent definition = stack.get(ZAMComponents.COSMETIC_PATTERN);
        CosmeticTarget effectiveTarget = definition == null ? target.resolve(fallbackTarget) : definition.effectiveTarget();
        if (definition != null)
            return;
        consumer.accept(Component.translatable("tooltip.zam.cosmetic.applies_to").withColor(0xAAAAAA));
        consumer.accept(Component.translatable(effectiveTarget.nameTranslationKey()).withColor(0x0000AA));
        if (collection != null && !collection.isBlank()) {
            consumer.accept(Component.translatable("tooltip.zam.cosmetic.collection", collection).withColor(0xAA00AA));
        }
        consumer.accept(Component.translatable("tooltip.zam.cosmetic.click_to_apply").withColor(0x555555));
    }

    @Override
    public Optional<TooltipComponent> getTooltipImage(ItemStack stack) {
        CosmeticPatternComponent definition = stack.get(ZAMComponents.COSMETIC_PATTERN);
        if (definition == null)

            return Optional.empty();

        String displayName = definition.patternName();
        ItemStack preview = CosmeticPreview.displayStack(stack);
        return Optional.of(new CosmeticPatternTooltip(preview, Component.translatable(definition.effectiveTarget().nameTranslationKey()),
                        definition.collection(), displayName, definition.tooltipColor()));
    }
}

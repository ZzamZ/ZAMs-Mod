package net.ron.zam.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.ron.zam.common.component.AppliedCosmeticComponent;
import net.ron.zam.common.item.MusicBoxItem;
import net.ron.zam.registry.ZAMComponents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {
    @ModifyExpressionValue(method = "onEquipItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;isSilent()Z"))
    private boolean zam$silenceHelmetCosmeticChange(boolean silent, EquipmentSlot slot, ItemStack oldStack, ItemStack stack) {
        if (silent || slot != EquipmentSlot.HEAD || oldStack.isEmpty() || stack.isEmpty()) {
            return silent;
        }

        AppliedCosmeticComponent oldCosmetic = oldStack.get(ZAMComponents.APPLIED_COSMETIC);
        AppliedCosmeticComponent newCosmetic = stack.get(ZAMComponents.APPLIED_COSMETIC);
        if ((oldCosmetic == null) == (newCosmetic == null)) {
            return silent;
        }

        AppliedCosmeticComponent cosmetic = oldCosmetic != null ? oldCosmetic : newCosmetic;
        ItemStack restored = (oldCosmetic != null ? oldStack : stack).copy();
        ItemStack original = oldCosmetic != null ? stack : oldStack;

        restored.set(DataComponents.ITEM_MODEL, cosmetic.originalModel());
        cosmetic.originalEquippable().ifPresentOrElse(value -> restored.set(DataComponents.EQUIPPABLE, value), () -> restored.remove(DataComponents.EQUIPPABLE));
        restored.remove(ZAMComponents.APPLIED_COSMETIC);
        return ItemStack.isSameItemSameComponents(restored, original);
    }

    @Inject(method = "tick", at = @At("HEAD"))
    private void zam$onTick(CallbackInfo ci) {
        LivingEntity entity = (LivingEntity) (Object) this;
        if (entity.level().isClientSide()) {
            MusicBoxItem.onLivingEntityUpdateClient(entity);
        } else {
            MusicBoxItem.onLivingEntityUpdateServer(entity);
        }
    }
}
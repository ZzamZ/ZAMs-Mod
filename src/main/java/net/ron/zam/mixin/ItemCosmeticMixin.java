package net.ron.zam.mixin;

import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.SlotAccess;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ClickAction;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.ron.zam.common.component.AppliedCosmeticComponent;
import net.ron.zam.registry.ZAMComponents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.function.Consumer;

@Mixin(Item.class)
public abstract class ItemCosmeticMixin {
    @Inject(method = "appendHoverText", at = @At("TAIL"))
    private void zam$appendCosmeticTooltip(ItemStack stack, Item.TooltipContext context, TooltipDisplay display, Consumer<Component> consumer, TooltipFlag flag, CallbackInfo ci) {
        AppliedCosmeticComponent cosmetic = stack.get(ZAMComponents.APPLIED_COSMETIC);
        if (cosmetic != null) {
            cosmetic.addToTooltip(context, consumer, flag, stack);
        }
    }

    @Inject(method = "overrideOtherStackedOnMe", at = @At("HEAD"), cancellable = true)
    private void zam$removeCosmetic(ItemStack equipment, ItemStack cursor, Slot slot, ClickAction action, Player player, SlotAccess cursorAccess, CallbackInfoReturnable<Boolean> cir) {
        if (action != ClickAction.SECONDARY || !cursor.isEmpty() || !slot.allowModification(player))
            return;

        AppliedCosmeticComponent cosmetic = equipment.get(ZAMComponents.APPLIED_COSMETIC);
        if (cosmetic == null)
            return;

        ItemStack returnedToken = cosmetic.createReturnedItem();
        if (!cursorAccess.set(returnedToken))
            return;

        equipment.set(DataComponents.ITEM_MODEL, cosmetic.originalModel());
        cosmetic.originalEquippable().ifPresentOrElse(value -> equipment.set(DataComponents.EQUIPPABLE, value), () -> equipment.remove(DataComponents.EQUIPPABLE));
        equipment.remove(ZAMComponents.APPLIED_COSMETIC);
        slot.setChanged();
        cir.setReturnValue(true);
    }
}

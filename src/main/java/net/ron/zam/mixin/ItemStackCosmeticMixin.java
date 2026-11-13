package net.ron.zam.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Prediction;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.ron.zam.common.component.AppliedCosmeticComponent;
import net.ron.zam.registry.ZAMComponents;
import org.spongepowered.asm.mixin.Mixin;

import java.util.function.Consumer;

@Mixin(ItemStack.class)
public abstract class ItemStackCosmeticMixin {
    @WrapMethod(method = "applyDamage")
    private void zam$returnCosmeticOnBreak(int damage, ServerPlayer player, Consumer<Item> onBreak, Operation<Void> original) {
        ItemStack stack = (ItemStack) (Object) this;
        AppliedCosmeticComponent cosmetic = stack.get(ZAMComponents.APPLIED_COSMETIC);
        int previousCount = stack.getCount();
        boolean inventoryWasFull = player != null && player.getInventory().getFreeSlot() < 0;

        original.call(damage, player, onBreak);

        if (player == null || cosmetic == null || stack.getCount() >= previousCount)
            return;

        ItemStack returnedItem = cosmetic.createReturnedItem();
        if (returnedItem.isEmpty())
            return;

        if (!inventoryWasFull) {
            player.getInventory().add(returnedItem);
        }
        if (!returnedItem.isEmpty()) {
            player.drop(returnedItem, false, Prediction.SERVER_ONLY);
        }
    }
}

package net.ron.zam.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.projectile.FishingHook;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.ron.zam.registry.ZAMEnchantments;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(FishingHook.class)
public abstract class DoubleCatchFishingHookMixin {
    @WrapOperation(method = "retrieve", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/storage/loot/LootTable;"
                            + "getRandomItems(Lnet/minecraft/world/level/storage/loot/LootParams;)"
                            + "Lit/unimi/dsi/fastutil/objects/ObjectArrayList;")
    )
    private ObjectArrayList<ItemStack> zam$doubleCatch(LootTable table, LootParams params, Operation<ObjectArrayList<ItemStack>> original, ItemStack rod) {
        ObjectArrayList<ItemStack> loot = original.call(table, params);
        FishingHook hook = (FishingHook) (Object) this;

        if (!(hook.level() instanceof ServerLevel level)) {
            return loot;
        }

        var enchantment = level.registryAccess()
                .lookupOrThrow(Registries.ENCHANTMENT)
                .getOrThrow(ZAMEnchantments.DOUBLE_CATCH);

        int enchantmentLevel = EnchantmentHelper.getItemEnchantmentLevel(enchantment, rod);

        float chance = switch (enchantmentLevel) {
            case 1 -> 0.10F;
            case 2 -> 0.15F;
            case 3 -> 0.25F;
            default -> enchantmentLevel > 3 ? 0.25F : 0.0F;
        };

        if (chance > 0.0F && hook.getRandom().nextFloat() < chance) {
            loot.addAll(table.getRandomItems(params));
        }

        return loot;
    }
}
package net.ron.zam.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.advancements.triggers.CriteriaTriggers;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.FishingHook;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.ron.zam.registry.ZAMEnchantments;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

import java.util.List;

@Mixin(FishingHook.class)
public abstract class ReelingFishingHookMixin {
    @WrapOperation(method = "retrieve", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/storage/loot/LootTable;"
                            + "getRandomItems(Lnet/minecraft/world/level/storage/loot/LootParams;)"
                            + "Lit/unimi/dsi/fastutil/objects/ObjectArrayList;"))

    private ObjectArrayList<ItemStack> zam$reeling(LootTable table, LootParams params, Operation<ObjectArrayList<ItemStack>> original, ItemStack rod) {
        ObjectArrayList<ItemStack> loot = original.call(table, params);

        FishingHook hook = (FishingHook) (Object) this;
        if (!(hook.level() instanceof ServerLevel level)) {
            return loot;
        }

        Player player = hook.getPlayerOwner();
        if (player == null) {
            return loot;
        }

        var reeling = level.registryAccess()
                .lookupOrThrow(Registries.ENCHANTMENT)
                .getOrThrow(ZAMEnchantments.REELING);

        if (EnchantmentHelper.getItemEnchantmentLevel(reeling, rod) == 0) {
            return loot;
        }

        var iterator = loot.iterator();

        while (iterator.hasNext()) {
            ItemStack stack = iterator.next();
            EntityType<?> type = zam$fishType(stack);

            if (type == null) {
                continue;
            }

            int converted = 0;

            for (int i = 0; i < stack.getCount(); i++) {
                Entity fish = zam$createFish(type, hook, player, level);

                if (fish != null) {
                    converted++;

                    if (player.getOffhandItem().is(Items.WATER_BUCKET)) {
                        player.interactOn(
                                fish,
                                InteractionHand.OFF_HAND,
                                player.position()
                        );
                    }
                }
            }

            if (converted == 0) {
                continue;
            }

            ItemStack caught = stack.copy();
            caught.setCount(converted);

            if (player instanceof ServerPlayer serverPlayer) {
                CriteriaTriggers.FISHING_ROD_HOOKED.trigger(
                        serverPlayer, rod, hook, List.of(caught)
                );
            }

            player.awardStat(Stats.FISH_CAUGHT, converted);
            stack.shrink(converted);

            if (stack.isEmpty()) {
                iterator.remove();

                level.addFreshEntity(new ExperienceOrb(level, player.getX(), player.getY() + 0.5, player.getZ(),
                        1 + level.getRandom().nextInt(6)
                ));
            }
        }

        return loot;
    }

    @Unique
    private static Entity zam$createFish(EntityType<?> type, FishingHook hook, Player player, ServerLevel level) {
        Entity fish = type.create(level, EntitySpawnReason.NATURAL);

        if (fish == null) {
            return null;
        }

        fish.snapTo(hook.getX(), hook.getY(), hook.getZ(), level.getRandom().nextFloat() * 360.0F, 0.0F);

        if (fish instanceof Mob mob) {
            mob.finalizeSpawn(
                    level,
                    level.getCurrentDifficultyAt(hook.blockPosition()),
                    EntitySpawnReason.NATURAL,
                    null
            );
        }

        double x = player.getX() - hook.getX();
        double y = player.getY() - hook.getY();
        double z = player.getZ() - hook.getZ();
        double lift = Math.sqrt(Math.sqrt(x * x + y * y + z * z)) * 0.18;

        fish.setDeltaMovement(x * 0.12, y * 0.12 + lift, z * 0.12);

        return level.tryAddFreshEntityWithPassengers(fish) ? fish : null;
    }

    @Unique
    private static EntityType<?> zam$fishType(ItemStack stack) {
        if (stack.is(Items.COD)) return EntityTypes.COD;
        if (stack.is(Items.SALMON)) return EntityTypes.SALMON;
        if (stack.is(Items.TROPICAL_FISH)) return EntityTypes.TROPICAL_FISH;
        if (stack.is(Items.PUFFERFISH)) return EntityTypes.PUFFERFISH;

        return null;
    }
}
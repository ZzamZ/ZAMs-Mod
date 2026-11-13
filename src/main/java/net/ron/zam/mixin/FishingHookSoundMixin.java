package net.ron.zam.mixin;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.FishingHook;
import net.minecraft.world.item.FishingRodItem;
import net.minecraft.world.item.ItemStack;
import net.ron.zam.util.FishingRodSounds;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(FishingHook.class)
public abstract class FishingHookSoundMixin {
    @Redirect(method = "catchingFish", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/projectile/FishingHook;playSound(Lnet/minecraft/sounds/SoundEvent;FF)V"))
    private void zam$playCosmeticBiteSound(FishingHook hook, SoundEvent sound, float volume, float pitch) {
        Player player = hook.getPlayerOwner();
        if (player != null && sound == SoundEvents.FISHING_BOBBER_SPLASH) {
            SoundEvent cosmeticSound = FishingRodSounds.bite(zam$getFishingRod(player), sound);
            hook.playSound(cosmeticSound, cosmeticSound != sound ? 1.0F : volume, cosmeticSound != sound ? 1.0F : pitch);
            return;
        }
        hook.playSound(sound, volume, pitch);
    }

    private ItemStack zam$getFishingRod(Player player) {
        ItemStack mainHand = player.getMainHandItem();
        return mainHand.getItem() instanceof FishingRodItem ? mainHand : player.getOffhandItem();
    }
}

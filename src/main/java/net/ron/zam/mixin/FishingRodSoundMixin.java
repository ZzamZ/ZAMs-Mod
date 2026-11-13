package net.ron.zam.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.FishingRodItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.ron.zam.util.FishingRodSounds;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(FishingRodItem.class)
public abstract class FishingRodSoundMixin {
    @WrapOperation(method = "use", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;playSound(Lnet/minecraft/world/entity/Entity;DDDLnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FF)V"))
    private void zam$playCosmeticSound(Level level, Entity source, double x, double y, double z, SoundEvent originalSound, SoundSource soundSource, float volume, float pitch, Operation<Void> original, Level useLevel, Player player, InteractionHand hand) {
        ItemStack rod = player.getItemInHand(hand);
        SoundEvent sound =
                originalSound == SoundEvents.FISHING_BOBBER_THROW ? FishingRodSounds.cast(rod, originalSound) :
                        FishingRodSounds.reel(rod, originalSound);
        original.call(level, source, x, y, z, sound, soundSource, sound != originalSound ? 1.0F : volume, sound != originalSound ? 1.0F : pitch);
    }
}

package net.ron.zam.mixin;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.MaceItem;
import net.ron.zam.common.component.CosmeticPatternComponent;
import net.ron.zam.registry.ZAMComponents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(Player.class)
public abstract class MaceAttackSoundMixin {
    @ModifyVariable(method = "playServerSideSound", at = @At("HEAD"), argsOnly = true, name = "sound")
    private SoundEvent zam$replaceMaceHit(SoundEvent sound) {
        if (sound != SoundEvents.PLAYER_ATTACK_STRONG && sound != SoundEvents.PLAYER_ATTACK_WEAK
                && sound != SoundEvents.PLAYER_ATTACK_CRIT) return sound;
        Player player = (Player) (Object) this;
        var stack = player.getMainHandItem();
        if (!(stack.getItem() instanceof MaceItem)) return sound;
        var cosmetic = stack.get(ZAMComponents.APPLIED_COSMETIC);
        return cosmetic == null ? sound : cosmetic.patternDefinition()
                .flatMap(CosmeticPatternComponent::attackSound).flatMap(BuiltInRegistries.SOUND_EVENT::get)
                .map(Holder.Reference::value).orElse(sound);
    }
}

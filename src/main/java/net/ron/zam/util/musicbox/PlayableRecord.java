package net.ron.zam.util.musicbox;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.JukeboxSong;
import net.minecraft.world.item.component.BundleContents;
import net.ron.zam.common.item.RecordSleeveItem;

import java.util.List;
import java.util.Optional;

public final class PlayableRecord {
    public static boolean isPlayableRecord(ItemStack stack) {
        if (stack.isEmpty())
            return false;
        if (stack.getItem() instanceof RecordSleeveItem)
            return getTrackCount(stack) > 0;
        return stack.has(DataComponents.JUKEBOX_PLAYABLE);
    }

    public static int getTrackCount(ItemStack stack) {
        if (stack.isEmpty())
            return 0;
        if (stack.getItem() instanceof RecordSleeveItem)
            return getSleeveDiscs(stack).size();
        return JukeboxSong.fromStack(stack).isPresent() ? 1 : 0;
    }

    public static ItemStack getTrack(ItemStack stack, int track) {
        if (stack.isEmpty() || track < 0)
            return ItemStack.EMPTY;
        if (stack.getItem() instanceof RecordSleeveItem) {
            List<ItemStack> discs = getSleeveDiscs(stack);
            return track < discs.size() ? discs.get(track) : ItemStack.EMPTY;
        }
        return track == 0 && JukeboxSong.fromStack(stack).isPresent() ? stack : ItemStack.EMPTY;
    }

    private static List<ItemStack> getSleeveDiscs(ItemStack sleeve) {
        BundleContents contents = sleeve.getOrDefault(DataComponents.BUNDLE_CONTENTS, BundleContents.EMPTY);
        return contents.itemCopies().filter(stack -> stack.has(DataComponents.JUKEBOX_PLAYABLE)).limit(
                RecordSleeveItem.MAX_DISCS).toList();
    }

    public static boolean canShowMessage(double x, double y, double z) {
        LocalPlayer player = Minecraft.getInstance().player;
        return player == null || player.distanceToSqr(x, y, z) <= 4096.0;
    }

    public static Optional<SoundInstance> createEntitySound(ItemStack stack, Entity entity, int track) {
        ItemStack trackStack = getTrack(stack, track);
        Optional<Holder<JukeboxSong>> maybeSong = JukeboxSong.fromStack(trackStack);
        if (maybeSong.isEmpty())
            return Optional.empty();

        JukeboxSong song = maybeSong.get().value();
        if (entity.level().getBlockState(entity.blockPosition().above()).isAir() &&
                canShowMessage(entity.getX(), entity.getY(), entity.getZ())) {
            Minecraft.getInstance().gui.hud.setNowPlaying(song.description());
        }

        return Optional.of(new EntityRecordSoundInstance(song.soundEvent().value(), entity));
    }
}

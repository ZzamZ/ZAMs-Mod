package net.ron.zam.util.musicbox;

import it.unimi.dsi.fastutil.ints.Int2IntArrayMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.ron.zam.common.item.MusicBoxItem;
import net.ron.zam.registry.ZAMComponents;

import java.util.Optional;

public final class SoundTracker {
    private static final Int2ObjectArrayMap<SoundInstance> ENTITY_SOUNDS = new Int2ObjectArrayMap<>();
    private static final Int2ObjectArrayMap<ItemStack> ENTITY_RECORDS = new Int2ObjectArrayMap<>();
    private static final Int2IntArrayMap ENTITY_TRACKS = new Int2IntArrayMap();

    public static void playMusicBox(int entityId, ItemStack record) {
        stopMusicBox(entityId);

        if (PlayableRecord.getTrackCount(record) == 0)
            return;
        playTrack(entityId, record, 0);
    }

    private static void playTrack(int entityId, ItemStack record, int track) {
        stopCurrentSound(entityId);

        Minecraft minecraft = Minecraft.getInstance();
        ClientLevel level = minecraft.level;

        if (level == null) {
            return;
        }

        Entity entity = level.getEntity(entityId);

        if (entity == null) {
            return;
        }

        Optional<SoundInstance> sound = PlayableRecord.createEntitySound(record, entity, track);
        if (sound.isEmpty()) {
            return;
        }

        SoundInstance newSound = sound.get();

        ENTITY_SOUNDS.put(entityId, newSound);
        ENTITY_RECORDS.put(entityId, record.copy());
        ENTITY_TRACKS.put(entityId, track);

        minecraft.getSoundManager().play(newSound);
    }

    public static void stopMusicBox(int entityId) {
        stopCurrentSound(entityId);
        ENTITY_RECORDS.remove(entityId);
        ENTITY_TRACKS.remove(entityId);
    }

    private static void stopCurrentSound(int entityId) {
        SoundInstance oldSound = ENTITY_SOUNDS.remove(entityId);
        if (oldSound != null) {
            Minecraft.getInstance().getSoundManager().stop(oldSound);
        }
    }

    public static SoundInstance getEntitySound(int entityId) {
        return ENTITY_SOUNDS.get(entityId);
    }

    public static int getCurrentTrack(int entityId, ItemStack record) {
        ItemStack tracked = ENTITY_RECORDS.get(entityId);
        SoundInstance sound = ENTITY_SOUNDS.get(entityId);
        if (tracked == null || !ItemStack.matches(tracked, record) || sound == null ||
                !Minecraft.getInstance().getSoundManager().isActive(sound))
            return -1;
        return ENTITY_TRACKS.getOrDefault(entityId, -1);
    }

    public static void tick() {
        Minecraft mc = Minecraft.getInstance();

        if (mc.level == null) {
            return;
        }

        for (int entityId : ENTITY_SOUNDS.keySet().toIntArray()) {

            SoundInstance sound = ENTITY_SOUNDS.get(entityId);

            if (sound == null) {
                continue;
            }

            Entity entity = mc.level.getEntity(entityId);

            if (entity == null) {
                stopMusicBox(entityId);
                continue;
            }

            ItemStack record = ENTITY_RECORDS.get(entityId);

            if (record == null || record.isEmpty()) {
                stopMusicBox(entityId);
                continue;
            }

            ItemStack musicBox = findMatchingMusicBox(entity, record);

            if (musicBox.isEmpty()) {
                stopMusicBox(entityId);
                continue;
            }

            if (musicBox.has(ZAMComponents.PAUSED)) {
                stopMusicBox(entityId);
                continue;
            }

            if (mc.getSoundManager().isActive(sound))
                continue;

            int nextTrack = ENTITY_TRACKS.getOrDefault(entityId, 0) + 1;
            if (nextTrack < PlayableRecord.getTrackCount(record)) {
                playTrack(entityId, record, nextTrack);
            } else if (musicBox.has(ZAMComponents.LOOPING)) {
                playTrack(entityId, record, 0);
            } else
                stopMusicBox(entityId);
        }
    }

    private static ItemStack findMatchingMusicBox(Entity entity, ItemStack record) {
        if (!(entity instanceof Player player))
            return ItemStack.EMPTY;

        ItemStack carried = player.inventoryMenu.getCarried();
        if (isMatchingMusicBox(carried, record))
            return carried;

        for (InteractionHand hand : InteractionHand.values()) {
            ItemStack stack = player.getItemInHand(hand);
            if (isMatchingMusicBox(stack, record))
                return stack;
        }
        for (ItemStack stack : player.getInventory().getNonEquipmentItems()) {
            if (isMatchingMusicBox(stack, record))
                return stack;
        }
        return ItemStack.EMPTY;
    }

    private static boolean isMatchingMusicBox(ItemStack stack, ItemStack record) {
        return stack.getItem() instanceof MusicBoxItem && MusicBoxItem.hasRecord(stack) &&
                ItemStack.matches(MusicBoxItem.getRecord(stack), record);
    }
}

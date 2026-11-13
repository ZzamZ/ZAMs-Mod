package net.ron.zam.util.casesystem.gui;

import net.fabricmc.fabric.api.menu.v1.ExtendedMenuProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.ron.zam.common.gui.cases.CaseMenu;
import net.ron.zam.util.casesystem.CaseEntry;
import net.ron.zam.util.casesystem.CaseOpenData;

public record CaseMenuProvider(CaseEntry entry, Component title) implements ExtendedMenuProvider<CaseOpenData> {
    @Override
    public CaseOpenData getScreenOpeningData(ServerPlayer player) {
        return new CaseOpenData(entry.id());
    }

    @Override
    public Component getDisplayName() {
        return title;
    }

    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
        return new CaseMenu(id, inventory, player, entry);
    }
}

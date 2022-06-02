package fr.silenthill99.minijeux;

import org.bukkit.OfflinePlayer;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class AdminOptionHolder implements InventoryHolder {

    private final OfflinePlayer op;

    public AdminOptionHolder(OfflinePlayer op) {
        this.op = op;
    }

    public OfflinePlayer getPlayer() {
        return this.op;
    }

    @Override
    public Inventory getInventory() {
        return null;
    }
}

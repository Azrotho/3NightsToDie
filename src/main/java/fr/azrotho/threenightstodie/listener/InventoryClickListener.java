package fr.azrotho.threenightstodie.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import fr.azrotho.threenightstodie.ThreeNightsToDiePlugin;

public class InventoryClickListener implements Listener {

    private ThreeNightsToDiePlugin plugin;

    public InventoryClickListener(ThreeNightsToDiePlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        plugin.shopClick().onInventoryClick(event);
    }
}

package fr.azrotho.threenightstodie.utils;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import org.bukkit.persistence.PersistentDataType;

import fr.azrotho.threenightstodie.ThreeNightsToDiePlugin;

public class TrackerUtility {

    private ThreeNightsToDiePlugin plugin;

    public TrackerUtility(ThreeNightsToDiePlugin plugin) {
        this.plugin = plugin;
    }

    public ItemStack getTracker(Player target) {
        ItemStack tracker = new ItemStack(Material.COMPASS, 1);
        ItemMeta meta = tracker.getItemMeta();
        meta.setDisplayName("§c§lTracker pour §e" + target.getName());
        
        NamespacedKey key = new NamespacedKey(plugin, "tracker_target");
        meta.getPersistentDataContainer().set(key, PersistentDataType.STRING, target.getName());
        
        tracker.setItemMeta(meta);
        return tracker;
    }
}

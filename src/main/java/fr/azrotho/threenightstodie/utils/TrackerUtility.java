package fr.azrotho.threenightstodie.utils;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class TrackerUtility {
    public ItemStack getTracker(Player target) {
        ItemStack tracker = new ItemStack(Material.COMPASS, 1);
        ItemMeta meta = tracker.getItemMeta();
        meta.setDisplayName("Tracker pour " + target.getName());
        meta.setLocalizedName(target.getName());
        tracker.setItemMeta(meta);
        return tracker;
    }
}

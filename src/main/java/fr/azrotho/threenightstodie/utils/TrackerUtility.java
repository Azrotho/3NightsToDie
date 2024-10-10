package fr.azrotho.threenightstodie.utils;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class TrackerUtility {
    public ItemStack getTracker(Player target) {
        return new ItemStack(Material.COMPASS);
    }
}

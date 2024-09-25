package fr.azrotho.threenightstodie.utils;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ManoirUtility {

    public Boolean isInManoir(Player player) {
        int x1 = 0;
        int y1 = 0;
        int z1 = 0;

        int x2 = 0;
        int y2 = 0;
        int z2 = 0;

        if(player.getLocation().getX() > Math.min(x1, x2) && player.getLocation().getX() < Math.max(x1, x2)) {
            if(player.getLocation().getY() > Math.min(y1, y2) && player.getLocation().getY() < Math.max(y1, y2)) {
                if(player.getLocation().getZ() > Math.min(z1, z2) && player.getLocation().getZ() < Math.max(z1, z2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void giveReward(Player player, long ticks) {
        if(ticks == 20 * 60 * 1) {
            player.getInventory().addItem(new ItemStack(Material.BREAD, 2));
        }
        if(ticks == 20 * 60 * 2) {
            player.getInventory().addItem(new ItemStack(Material.BREAD, 4));
        }
        if(ticks == 20 * 60 * 3) {
            player.getInventory().addItem(new ItemStack(Material.BREAD, 6));
        }
        if(ticks == 20 * 60 * 4) {
            player.getInventory().addItem(new ItemStack(Material.BREAD, 8));
        }
        if(ticks == 20 * 60 * 5) {
            player.getInventory().addItem(new ItemStack(Material.COOKED_MUTTON, 4));
        }
        if(ticks == 20 * 60 * 6) {
            player.getInventory().addItem(new ItemStack(Material.COOKED_MUTTON, 5));
        }
        if(ticks == 20 * 60 * 7) {
            player.getInventory().addItem(new ItemStack(Material.COOKED_MUTTON, 6));
        }
        if(ticks == 20 * 60 * 8) {
            player.getInventory().addItem(new ItemStack(Material.COOKED_BEEF, 6));
        }
        if(ticks == 20 * 60 * 9) {
            player.getInventory().addItem(new ItemStack(Material.COOKED_BEEF, 7));
        }
        if(ticks == 20 * 60 * 10) {
            player.getInventory().addItem(new ItemStack(Material.GOLDEN_CARROT, 10));
        }
    }
}

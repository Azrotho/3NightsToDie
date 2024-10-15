package fr.azrotho.threenightstodie.utils;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ManoirUtility {

    public Boolean isInManoir(Player player) {
        int x1 = -50;
        int y1 = 0;
        int z1 = -50;

        int x2 = 50;
        int y2 = 90;
        int z2 = 50;

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
        int minutes = (int) (ticks / (20 * 60));
        ItemStack reward = null;

        if(ticks % 20 * 60 != 0) {
            return;
        }

        switch (minutes) {
            case 1:
            reward = new ItemStack(Material.BREAD, 2);
            break;
            case 2:
            reward = new ItemStack(Material.BREAD, 4);
            break;
            case 3:
            reward = new ItemStack(Material.BREAD, 6);
            break;
            case 4:
            reward = new ItemStack(Material.BREAD, 8);
            break;
            case 5:
            reward = new ItemStack(Material.COOKED_MUTTON, 4);
            break;
            case 6:
            reward = new ItemStack(Material.COOKED_MUTTON, 5);
            break;
            case 7:
            reward = new ItemStack(Material.COOKED_MUTTON, 6);
            break;
            case 8:
            reward = new ItemStack(Material.COOKED_BEEF, 6);
            break;
            case 9:
            reward = new ItemStack(Material.COOKED_BEEF, 7);
            break;
            case 10:
            reward = new ItemStack(Material.GOLDEN_CARROT, 10);
            break;
        }
        if (reward != null) {
            player.getInventory().addItem(reward);
        }
    }
}

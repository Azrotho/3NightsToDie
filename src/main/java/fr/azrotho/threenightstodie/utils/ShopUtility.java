package fr.azrotho.threenightstodie.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import fr.azrotho.threenightstodie.ThreeNightsToDiePlugin;

public class ShopUtility {

    @SuppressWarnings("unused")
    private ThreeNightsToDiePlugin plugin;
    @SuppressWarnings("unused")
    private ItemStack border = new ItemStack(Material.RED_STAINED_GLASS_PANE, 1);

    public ShopUtility(ThreeNightsToDiePlugin plugin) {
        this.plugin = plugin;
    }


    public void openShopPlayer(Player player) {
        Inventory inv = Bukkit.createInventory(null, 54, "§cBoutique");
        for(int i = 0; i < 54; i++) {
            switch(i) {
                case 0,1,2,3,4,5,6,7,8,9,17,18,26,27,35,36,44,45,46,47,48,49,50,51,52,53 -> {
                    inv.setItem(i, border);
                }
            }
        }
    }
    
}

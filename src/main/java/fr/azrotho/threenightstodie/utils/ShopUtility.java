package fr.azrotho.threenightstodie.utils;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.azrotho.threenightstodie.ThreeNightsToDiePlugin;
import java.util.List;

public class ShopUtility {

    private ThreeNightsToDiePlugin plugin;
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
                case 29 -> {
                    inv.setItem(i, changeColorShopItem());
                }
                case 33 -> {
                    if(plugin.nightGame().isTargetPlayerEnabled()) {
                        inv.setItem(i, targetPlayerShopItem());
                    } else {
                        inv.setItem(i, border);
                    }
                }
            }
        }
    }

    public ItemStack changeColorShopItem() {
        ItemStack item = new ItemStack(Material.RED_DYE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§cChanger la couleure d'un joueur");
        meta.setLore(new ArrayList<>(List.of(
            "§7Changer la couleur d'un joueur parmi:",
            "§aVert §7si vous innocentez un joueur",
            "§eJaune §7Si vous ne faites moyennement confiance à un joueur",
            "§cRouge §7Si vous ne faites pas confiance du tout à un joueur",
            "   + vous octroie un tracker (marche tant qu'il est \"rouge\")",
            "§c",
            "§7(vous pouvez changer la couleur d'un joueur qu'une fois par partie.)",
            "§7(et vous pouvez changer votre couleur)"
        )));
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack targetPlayerShopItem() {
        ItemStack item = new ItemStack(Material.SKELETON_SKULL);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§cCibler un joueur");
        meta.setLore(List.of(
            "§7Cibler un joueur pour le tuer",
            "§7Vous ne pouvez cibler qu'un joueur par jour"
        ));
        item.setItemMeta(meta);
        return item;
    }
    
}

package fr.azrotho.threenightstodie.shop;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import fr.azrotho.threenightstodie.ThreeNightsToDiePlugin;
import java.util.List;

public class ShopInventories {

    private ThreeNightsToDiePlugin plugin;
    private ItemStack border = new ItemStack(Material.RED_STAINED_GLASS_PANE, 1);

    public ShopInventories(ThreeNightsToDiePlugin plugin) {
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

    public void openShopChangeColor(Player player) {
        Inventory inv = Bukkit.createInventory(null, 54, "§cChanger la couleur");
        int count = 0;
        for(int i = 0; i < 54; i++) {
            switch(i) {
                case 0,1,2,3,4,5,6,7,8,9,17,18,26,27,35,36,44,45,46,47,48,49,50,51,52,53 -> {
                    inv.setItem(i, border);
                }
                default -> {
                    inv.setItem(i, this.getPlayersHeads(false).get(count));
                    count++;
                }
            }
        }
    }

    public void openShopTargetPlayer(Player player) {
        Inventory inv = Bukkit.createInventory(null, 54, "§cCibler un joueur");
        int count = 0;
        for(int i = 0; i < 54; i++) {
            switch(i) {
                case 0,1,2,3,4,5,6,7,8,9,17,18,26,27,35,36,44,45,46,47,48,49,50,51,52,53 -> {
                    inv.setItem(i, border);
                }
                default -> {
                    inv.setItem(i, this.getPlayersHeads(true).get(count));
                    count++;
                }
            }
        }
    }

    public void openChangeColorPlayer(Player player, ItemStack itemStack) {
        Inventory inv = Bukkit.createInventory(null, 54, "§cChanger la couleur");
        for(int i = 0; i < 54; i++) {
            switch(i) {
                case 0,1,2,3,4,5,6,7,8,9,17,18,26,27,35,36,44,45,46,47,48,49,50,51,52,53 -> {
                    inv.setItem(i, border);
                }
                case 13 -> {
                    inv.setItem(i, itemStack);
                }
                case 28 -> {
                    inv.setItem(i, this.greenColorItem());
                }
                case 31 -> {
                    inv.setItem(i, this.yellowColorItem());
                }
                case 34 -> {
                    inv.setItem(i, this.redColorItem());
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
            "   + vous octroie un tracker (fonctionne tant qu'il est \"rouge\")",
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

    public List<ItemStack> getPlayersHeads(boolean withAdmins) {
        List<ItemStack> heads = new ArrayList<>();
        for(Player player : Bukkit.getOnlinePlayers()) {
            if(!withAdmins && plugin.nightPlayerManager().isAdmin(player)) {
                continue;
            }
            ItemStack item = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta meta = (SkullMeta) item.getItemMeta();
            meta.setOwningPlayer(player);
            meta.setDisplayName(player.getName());
            item.setItemMeta(meta);
            heads.add(item);
        }
        return heads;
    }

    public ItemStack greenColorItem() {
        ItemStack item = new ItemStack(Material.GREEN_DYE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aVert");
        meta.setLore(List.of(
            "§fPour innocenter un joueur"
        ));
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack yellowColorItem() {
        ItemStack item = new ItemStack(Material.YELLOW_DYE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§eJaune");
        meta.setLore(List.of(
            "§fPour ne pas faire confiance à un joueur"
        ));
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack redColorItem() {
        ItemStack item = new ItemStack(Material.RED_DYE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§cRouge");
        meta.setLore(List.of(
            "§fPour ne pas faire confiance à un joueur",
            "§fVous octroie un tracker (fonctionne tant que le joueur est \"rouge\")"
        ));
        item.setItemMeta(meta);
        return item;
    }
}

package fr.azrotho.threenightstodie.shop;

import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import fr.azrotho.threenightstodie.ThreeNightsToDiePlugin;

public class ShopClick {


    @SuppressWarnings("unused")
    private ThreeNightsToDiePlugin plugin;
    private ShopInventories shopInventories;


    public ShopClick(ThreeNightsToDiePlugin plugin) {
        this.plugin = plugin;
        this.shopInventories = new ShopInventories(plugin);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if(event.getView().getTitle().equals("§cBoutique")) {
            onClickOnMainShop(event);
            event.setCancelled(true);
            return;
        } 
        if(event.getView().getTitle().equals("§cChanger la couleur")) {
            onClickOnHeadColorShop(event);
            event.setCancelled(true);
            return;
        } 
        if(event.getView().getTitle().equals("§4Changer la couleur")) {
            onClickOnColorInColorShop(event);
            event.setCancelled(true);
            return;
        } 
        if(event.getView().getTitle().equals("§cCibler un joueur")) {
            onClickOnTargetPlayerShop(event);
            event.setCancelled(true);
            return;
        }
    }

    public void onClickOnMainShop(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if(event.getCurrentItem().isSimilar(shopInventories.changeColorShopItem())) {
            player.closeInventory();
            shopInventories.openShopChangeColor(player);
        }
        if(event.getCurrentItem().isSimilar(shopInventories.targetPlayerShopItem())) {
            player.closeInventory();
            shopInventories.openShopTargetPlayer(player);
        }
    }

    public void onClickOnHeadColorShop(InventoryClickEvent event) {
        ItemStack clickedItem = event.getCurrentItem();
        Player playerClicker = (Player) event.getWhoClicked();
        if(clickedItem == null) {
            return;
        }
        if(clickedItem.getType().equals(Material.PLAYER_HEAD)) {
            SkullMeta skullMeta = (SkullMeta) clickedItem.getItemMeta();
            OfflinePlayer ownerPlayer = skullMeta.getOwningPlayer();
            if(ownerPlayer.isOnline()) {
                Player target = ownerPlayer.getPlayer();
                shopInventories.openChangeColorPlayer(playerClicker, target);
            } else {
                playerClicker.sendMessage("Ce joueur est déconnecté.");
            }
        }
    }

    public void onClickOnColorInColorShop(InventoryClickEvent event) {
        if(event.getCurrentItem() == null) return;
        if(event.getInventory().getItem(13) == null) return;
        if(!(event.getInventory().getItem(13).getType().equals(Material.PLAYER_HEAD))) return;
        Player target = getPlayerFromSkull(event.getInventory().getItem(13));
        Player player = (Player) event.getWhoClicked();
        if(countDiamondInInv(player) < 5) {
            player.sendMessage("§cVous n'avez pas assez de diamants");
            return;
        }
        if(event.getCurrentItem().getType().equals(Material.GREEN_DYE)) {
            removeDiamondInInv(player, 5);
            player.sendMessage("§aVous avez changé la couleur de " + target.getName() + " en vert");
            plugin.teamUtility().changeTeam(target, plugin.teamUtility().greenTeam());
            plugin.nightPlayerManager().changeColor(player);
            player.closeInventory();
        }
        if(event.getCurrentItem().getType().equals(Material.YELLOW_DYE)) {
            removeDiamondInInv(player, 5);
            player.sendMessage("§aVous avez changé la couleur de " + target.getName() + " en jaune");
            plugin.teamUtility().changeTeam(target, plugin.teamUtility().yellowTeam());
            plugin.nightPlayerManager().changeColor(player);
            player.closeInventory();
        }
        if(event.getCurrentItem().getType().equals(Material.RED_DYE)) {
            removeDiamondInInv(player, 5);
            player.sendMessage("§aVous avez changé la couleur de " + target.getName() + " en rouge et vous avez reçu un tracker");
            plugin.teamUtility().changeTeam(target, plugin.teamUtility().redTeam());
            plugin.nightPlayerManager().changeColor(player);
            player.getInventory().addItem(plugin.trackerUtility().getTracker(target));
            player.closeInventory();
        }
    }

    public void onClickOnTargetPlayerShop(InventoryClickEvent event) {
        if(countDiamondInInv((Player) event.getWhoClicked()) < 30) {
            ((Player) event.getWhoClicked()).sendMessage("§cVous n'avez pas assez de diamants");
            return;
        }
    }


    public int countDiamondInInv(Player player) {
        int count = 0;
        for(ItemStack item : player.getInventory().getContents()) {
            if(item != null && item.getType().equals(Material.DIAMOND)) {
                count += item.getAmount();
            }
        }
        return count;
    }

    public void removeDiamondInInv(Player player, int amount) {
        for(ItemStack item : player.getInventory().getContents()) {
            if(item != null && item.getType().equals(Material.DIAMOND)) {
                if(item.getAmount() >= amount) {
                    item.setAmount(item.getAmount() - amount);
                    return;
                } else {
                    amount -= item.getAmount();
                    item.setAmount(0);
                }
            }
        }
    }

    public Player getPlayerFromSkull(ItemStack item) {
        SkullMeta meta = (SkullMeta) item.getItemMeta();
        return meta.getOwningPlayer().getPlayer();
    }


}

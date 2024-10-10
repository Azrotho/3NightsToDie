package fr.azrotho.threenightstodie.shop;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;

import fr.azrotho.threenightstodie.ThreeNightsToDiePlugin;

public class ShopClick {


    ThreeNightsToDiePlugin plugin;
    ShopInventories shopInventories = new ShopInventories(plugin);


    public ShopClick(ThreeNightsToDiePlugin plugin) {
        this.plugin = plugin;
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
        if(event.getView().getTitle().equals("§cCouleur")) {
            onClickOnColorInColorShop(event);
            event.setCancelled(true);
            return;
        } 
        if(event.getView().getTitle().equals("§cJoueur cible")) {
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
    }

    public void onClickOnColorInColorShop(InventoryClickEvent event) {
    }

    public void onClickOnTargetPlayerShop(InventoryClickEvent event) {
    }


}

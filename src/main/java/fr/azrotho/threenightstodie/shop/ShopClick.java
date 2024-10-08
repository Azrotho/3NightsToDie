package fr.azrotho.threenightstodie.shop;

import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ShopClick {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if(event.getView().getTitle().equals("§cBoutique")) {
            onClickOnMainShop(event);
            return;
        } 
        if(event.getView().getTitle().equals("§cChanger la couleur")) {
            onClickOnHeadColorShop(event);
            return;
        } 
        if(event.getView().getTitle().equals("§cCouleur")) {
            onClickOnColorInColorShop(event);
            return;
        } 
        if(event.getView().getTitle().equals("§cJoueur cible")) {
            onClickOnTargetPlayerShop(event);
            return;
        }
    }

    public void onClickOnMainShop(InventoryClickEvent event) {
    }

    public void onClickOnHeadColorShop(InventoryClickEvent event) {
    }

    public void onClickOnColorInColorShop(InventoryClickEvent event) {
    }

    public void onClickOnTargetPlayerShop(InventoryClickEvent event) {
    }


}

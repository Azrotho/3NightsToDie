package fr.azrotho.threenightstodie.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import fr.azrotho.threenightstodie.shop.ShopClick;

public class InventoryClickListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        ShopClick shopClick = new ShopClick();
        shopClick.onInventoryClick(event);
    }
    
}

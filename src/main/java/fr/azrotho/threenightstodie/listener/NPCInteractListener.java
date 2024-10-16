package fr.azrotho.threenightstodie.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import de.oliver.fancynpcs.api.Npc;
import de.oliver.fancynpcs.api.events.NpcInteractEvent;
import fr.azrotho.threenightstodie.ThreeNightsToDiePlugin;
import fr.azrotho.threenightstodie.shop.ShopInventories;

public class NPCInteractListener implements Listener {

    ThreeNightsToDiePlugin plugin;

    public NPCInteractListener(ThreeNightsToDiePlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void on(NpcInteractEvent event) {
        Npc npc = event.getNpc();
        if(npc.getData().getDisplayName().equals(plugin.npcUtility().name())) {
            ShopInventories shopInventories = new ShopInventories(plugin);
            shopInventories.openShopPlayer(event.getPlayer());
        }
    }
    
}

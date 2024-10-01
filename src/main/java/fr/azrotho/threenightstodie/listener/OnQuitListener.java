package fr.azrotho.threenightstodie.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.azrotho.threenightstodie.ThreeNightsToDiePlugin;

public class OnQuitListener implements Listener {
    
        private ThreeNightsToDiePlugin plugin;
    
        public OnQuitListener(ThreeNightsToDiePlugin plugin) {
            this.plugin = plugin;
        }
    
        @EventHandler
        public void on(PlayerQuitEvent event) {
            if(plugin.nightPlayerManager().isEliminated(event.getPlayer())) {
                event.setQuitMessage("");
            }
        }
    
}

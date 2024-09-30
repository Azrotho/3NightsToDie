package fr.azrotho.threenightstodie.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.azrotho.threenightstodie.ThreeNightsToDiePlugin;

public class OnJoinListener implements Listener {

    private ThreeNightsToDiePlugin plugin;

    public OnJoinListener(ThreeNightsToDiePlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void on(PlayerJoinEvent event) {
        plugin.nightPlayerManager().addPlayer(event.getPlayer().getUniqueId());
        if(plugin.nightPlayerManager().isEliminated(event.getPlayer())) {
            event.setJoinMessage("");
            event.getPlayer().kickPlayer("§cVous avez été éliminé");
        }
    }
    
}

package fr.azrotho.threenightstodie.listener;

import fr.azrotho.threenightstodie.ThreeNightsToDiePlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class OnPlayerDeathListener implements Listener {

    private final ThreeNightsToDiePlugin plugin;

    public OnPlayerDeathListener(ThreeNightsToDiePlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void on(PlayerDeathEvent event) {
        plugin.nightPlayerManager().addDeath((Player) event.getEntity());
    }
}

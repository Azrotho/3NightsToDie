package fr.azrotho.threenightstodie.listener;

import fr.azrotho.threenightstodie.utils.DayCycleUtility;
import fr.azrotho.threenightstodie.utils.NickPlayerUtility;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.azrotho.threenightstodie.ThreeNightsToDiePlugin;

public class OnJoinListener implements Listener {

    private final DayCycleUtility dayCycleUtility;
    private final NickPlayerUtility nickPlayerUtility;
    private ThreeNightsToDiePlugin plugin;

    public OnJoinListener(ThreeNightsToDiePlugin plugin) {
        this.plugin = plugin;
        this.dayCycleUtility = new DayCycleUtility();
        this.nickPlayerUtility = new NickPlayerUtility();
    }

    @EventHandler
    public void on(PlayerJoinEvent event) {
        plugin.nightPlayerManager().addPlayer(event.getPlayer().getUniqueId());
        if(plugin.nightPlayerManager().isEliminated(event.getPlayer())) {
            event.setJoinMessage("");
            event.getPlayer().kickPlayer("§cVous avez été éliminé");
        }

        if(dayCycleUtility.isDay(event.getPlayer().getWorld().getTime())) {
            nickPlayerUtility.resetPlayer(event.getPlayer());
        } else {
            nickPlayerUtility.anonimizePlayer(event.getPlayer());
        }


    }
    
}

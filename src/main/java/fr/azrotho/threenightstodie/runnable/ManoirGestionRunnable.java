package fr.azrotho.threenightstodie.runnable;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import fr.azrotho.threenightstodie.ThreeNightsToDiePlugin;
import fr.azrotho.threenightstodie.utils.ManoirUtility;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class ManoirGestionRunnable extends BukkitRunnable {
    private ThreeNightsToDiePlugin plugin;

    public ManoirGestionRunnable(ThreeNightsToDiePlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        for(Player player : Bukkit.getOnlinePlayers()) {
            ManoirUtility manoirUtility = new ManoirUtility();
            if(manoirUtility.isInManoir(player)) {
                plugin.nightPlayerManager().addTickToPlayer(player);

                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("")); // TODO: Send timer ?

                if(plugin.nightPlayerManager().player(player).tickInManoir() >= 20 * 60 * 10) {
                    plugin.nightPlayerManager().resetTickInManoir(player);
                }
            }
        }
    }
}

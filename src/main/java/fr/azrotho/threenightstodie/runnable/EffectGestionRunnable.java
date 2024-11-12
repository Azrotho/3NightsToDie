package fr.azrotho.threenightstodie.runnable;

import fr.azrotho.threenightstodie.ThreeNightsToDiePlugin;
import fr.azrotho.threenightstodie.objects.NightPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class EffectGestionRunnable extends BukkitRunnable {

    private final ThreeNightsToDiePlugin plugin;

    public EffectGestionRunnable(ThreeNightsToDiePlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        for(Player player : Bukkit.getOnlinePlayers()) {
            NightPlayer nPlayer = plugin.nightPlayerManager().player(player);
            if(nPlayer != null) {
                if(nPlayer.isTarget()) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, -1, 1, false, false, false));
                } else {
                    if(player.hasPotionEffect(PotionEffectType.GLOWING)) {
                        player.removePotionEffect(PotionEffectType.GLOWING);
                    }
                }
            }
        }
    }
}

package fr.azrotho.threenightstodie.runnable;

import fr.azrotho.threenightstodie.ThreeNightsToDiePlugin;
import fr.azrotho.threenightstodie.utils.DayCycleUtility;
import fr.azrotho.threenightstodie.utils.NickPlayerUtility;
import org.bukkit.scheduler.BukkitRunnable;

public class DayCycleGestionRunnable extends BukkitRunnable {
    private final ThreeNightsToDiePlugin plugin;
    private final DayCycleUtility dayCycleUtility;
    private final NickPlayerUtility nickPlayerUtility;

    public DayCycleGestionRunnable(ThreeNightsToDiePlugin plugin) {
        this.plugin = plugin;
        this.dayCycleUtility = new DayCycleUtility();
        this.nickPlayerUtility = new NickPlayerUtility();
    }


    @Override
    public void run() {
        long time = plugin.getServer().getWorld("world").getTime();
        if (dayCycleUtility.TICK_IS_DAY == time) {
            dayCycleUtility.announceDay();
            plugin.getServer().getOnlinePlayers().forEach(nickPlayerUtility::resetPlayer);
        }
        if (dayCycleUtility.TICK_IS_NIGHT == time) {
            dayCycleUtility.announceNight();
            plugin.getServer().getOnlinePlayers().forEach(nickPlayerUtility::anonimizePlayer);
        }
    }
}

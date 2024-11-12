package fr.azrotho.threenightstodie.utils;

import org.bukkit.Bukkit;

public class DayCycleUtility {
    public final int TICK_IS_DAY = 1000;
    public final int TICK_IS_NIGHT = 13000;


    public boolean isDay(long time) {
        return time >= TICK_IS_DAY && time < TICK_IS_NIGHT;
    }

    public boolean isNight(long time) {
        return time >= TICK_IS_NIGHT && time < TICK_IS_DAY;
    }

    public void announceDay() {
        Bukkit.broadcastMessage("§eIl fait désormais jour");
    }

    public void announceNight() {
        Bukkit.broadcastMessage("§eIl fait désormais nuit");
    }
}

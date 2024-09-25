package fr.azrotho.threenightstodie;

import org.bukkit.plugin.java.JavaPlugin;

import fr.azrotho.threenightstodie.objects.NightPlayerManager;

public class ThreeNightsToDiePlugin extends JavaPlugin {

    private NightPlayerManager nightPlayerManager = new NightPlayerManager();
    private ThreeNightsToDiePlugin instance;

    @Override
    public void onEnable() {
        instance = this;
        getLogger().info("ThreeNightsToDie plugin enabled");
    }

    @Override
    public void onDisable() {
        getLogger().info("ThreeNightsToDie plugin disabled");
    }

    public NightPlayerManager nightPlayerManager() {
        return this.nightPlayerManager;
    }

    public ThreeNightsToDiePlugin instance() {
        return this.instance;
    }
}
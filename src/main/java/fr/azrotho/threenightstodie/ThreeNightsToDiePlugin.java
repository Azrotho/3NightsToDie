package fr.azrotho.threenightstodie;

import org.bukkit.plugin.java.JavaPlugin;

public class ThreeNightsToDiePlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("ThreeNightsToDie plugin enabled");
    }

    @Override
    public void onDisable() {
        getLogger().info("ThreeNightsToDie plugin disabled");
    }
    
}

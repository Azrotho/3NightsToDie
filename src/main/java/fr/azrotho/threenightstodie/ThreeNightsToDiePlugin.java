package fr.azrotho.threenightstodie;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import fr.azrotho.threenightstodie.commands.BroadcastCommnad;
import fr.azrotho.threenightstodie.commands.DebugCommand;
import fr.azrotho.threenightstodie.commands.VoteCommand;
import fr.azrotho.threenightstodie.listener.InventoryClickListener;
import fr.azrotho.threenightstodie.listener.OnJoinListener;
import fr.azrotho.threenightstodie.listener.OnQuitListener;
import fr.azrotho.threenightstodie.objects.NightGame;
import fr.azrotho.threenightstodie.objects.NightPlayerManager;
import fr.azrotho.threenightstodie.runnable.ManoirGestionRunnable;
import fr.azrotho.threenightstodie.utils.NPCUtility;
import fr.azrotho.threenightstodie.utils.TeamUtility;
import fr.azrotho.threenightstodie.utils.TrackerUtility;

public class ThreeNightsToDiePlugin extends JavaPlugin {

    private NightPlayerManager nightPlayerManager = new NightPlayerManager();
    private ThreeNightsToDiePlugin instance;
    private NPCUtility npcUtility;
    private TeamUtility teamUtility;
    private NightGame nightGame;
    private TrackerUtility trackerUtility;

    @Override
    public void onEnable() {
        instance = this;
        npcUtility = new NPCUtility(this);
        nightGame = new NightGame();

        trackerUtility = new TrackerUtility(this);

        npcUtility.init(new Location(Bukkit.getWorld("world"), 0, 90, 0));
        getLogger().info("ThreeNightsToDie plugin enabled");

        teamUtility = new TeamUtility(this);
        teamUtility.init();

        getServer().getPluginManager().registerEvents(new OnJoinListener(this), this);
        getServer().getPluginManager().registerEvents(new OnQuitListener(this), this);
        getServer().getPluginManager().registerEvents(new InventoryClickListener(this), this);

        getCommand("vote").setExecutor(new VoteCommand());
        getCommand("debug").setExecutor(new DebugCommand(this));
        getCommand("broadcast").setExecutor(new BroadcastCommnad());

        ManoirGestionRunnable manoirGestionRunnable = new ManoirGestionRunnable(this);
        manoirGestionRunnable.runTaskTimer(this, 0, 0);
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

    public NPCUtility npcUtility() {
        return this.npcUtility;
    }

    public TeamUtility teamUtility() {
        return this.teamUtility;
    }

    public NightGame nightGame() {
        return this.nightGame;
    }

    public TrackerUtility trackerUtility() {
        return this.trackerUtility;
    }
}

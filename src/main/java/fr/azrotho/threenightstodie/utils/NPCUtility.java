package fr.azrotho.threenightstodie.utils;

import org.bukkit.Location;

import dev.sergiferry.playernpc.api.NPC;
import dev.sergiferry.playernpc.api.NPCLib;
import fr.azrotho.threenightstodie.ThreeNightsToDiePlugin;

public class NPCUtility {
    NPC.Global npcGlobal;
    ThreeNightsToDiePlugin plugin;

    public NPCUtility(ThreeNightsToDiePlugin plugin) {
        this.plugin = plugin;
    }


    public void init(Location location) {
        npcGlobal = NPCLib.getInstance().generateGlobalNPC(plugin, "3ntd-shop", location);
        npcGlobal.setSkin("Azrotho");
        npcGlobal.setText("§c§lBoutique\n§7Cliquez pour ouvrir la boutique");
        npcGlobal.forceUpdate();
    }
    
}

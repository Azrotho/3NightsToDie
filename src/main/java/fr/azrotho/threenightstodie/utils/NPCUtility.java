package fr.azrotho.threenightstodie.utils;

import java.util.UUID;

import org.bukkit.Location;

import de.oliver.fancynpcs.api.FancyNpcsPlugin;
import de.oliver.fancynpcs.api.Npc;
import de.oliver.fancynpcs.api.NpcData;
import fr.azrotho.threenightstodie.ThreeNightsToDiePlugin;

public class NPCUtility {
    ThreeNightsToDiePlugin plugin;

    private String name = "§c§lBoutique";

    public NPCUtility(ThreeNightsToDiePlugin plugin) {
        this.plugin = plugin;
    }


    public void init(Location location) {
        // if(FancyNpcsPlugin.get().getNpcManager().getNpc("shop_npc") != null) {
        //     Npc npcToRemove = FancyNpcsPlugin.get().getNpcManager().getNpc("shop_npc");
        //     npcToRemove.removeForAll();
        //     FancyNpcsPlugin.get().getNpcManager().removeNpc(npcToRemove);
        // }
        NpcData data = new NpcData("shop_npc", UUID.fromString("2c2561aa-4f8c-409b-805f-26bc23344d3a"), location);
        data.setDisplayName(name);

        Npc npc = FancyNpcsPlugin.get().getNpcAdapter().apply(data);
        FancyNpcsPlugin.get().getNpcManager().registerNpc(npc);
        npc.create();
        npc.spawnForAll();
    }

    public String name() {
        return name;
    }
    
}

package fr.azrotho.threenightstodie.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import dev.sergiferry.playernpc.api.NPC;

public class NPCInteractListener implements Listener {

    @EventHandler
    public void onNPCInteract(NPC.Events.Interact event){
        NPC npc = event.getNPC();
        if(npc.getID().equals("3ntd-shop")){
            event.getPlayer().sendMessage("wip");
        }
    }
    
}

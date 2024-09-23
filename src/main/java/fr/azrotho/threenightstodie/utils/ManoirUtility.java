package fr.azrotho.threenightstodie.utils;

import org.bukkit.entity.Player;

public class ManoirUtility {

    public Boolean isInManoir(Player player) {
        int x1 = 0;
        int y1 = 0;
        int z1 = 0;

        int x2 = 0;
        int y2 = 0;
        int z2 = 0;


        if(player.getLocation().getX() > Math.min(x1, x2) && player.getLocation().getX() < Math.max(x1, x2)) {
            if(player.getLocation().getY() > Math.min(y1, y2) && player.getLocation().getY() < Math.max(y1, y2)) {
                if(player.getLocation().getZ() > Math.min(z1, z2) && player.getLocation().getZ() < Math.max(z1, z2)) {
                    return true;
                }
            }
        }

        return false;
        
    }
    
}

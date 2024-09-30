package fr.azrotho.threenightstodie.objects;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Nullable;

import org.bukkit.entity.Player;

@SuppressWarnings("null")
public class NightPlayerManager {
    public List<NightPlayer> players = new ArrayList<>();
    
    @Nullable
    public NightPlayer player(UUID uuid) {
        for(NightPlayer nPlayer : players) {
            if(nPlayer.getUuid().equals(uuid)) {
                return nPlayer;
            }
        }
        return null;
    }
    
    @Nullable
    public NightPlayer player(Player player) {
        return player(player.getUniqueId());
    }

    public void addTickToPlayer(Player player) {
        NightPlayer nPlayer = player(player);
        nPlayer.setTickInManoir(nPlayer.tickInManoir() + 1);
    }

    public void addDeath(Player player) {
        NightPlayer nPlayer = player(player);
        nPlayer.setDeath(nPlayer.death() + 1);
    }

    public void resetDeath(Player player) {
        NightPlayer nPlayer = player(player);
        nPlayer.setDeath(0);
    }

    public void resetTickInManoir(Player player) {
        NightPlayer nightPlayer = player(player);
        nightPlayer.setTickInManoir(0);
    }

    public void addVote(Player player) {
        NightPlayer nPlayer = player(player);
        nPlayer.setVote(nPlayer.vote() + 1);
    }

    public void resetVote(Player player) {
        NightPlayer nPlayer = player(player);
        nPlayer.setVote(0);
    }

    public void setMayor(Player player) {
        NightPlayer nPlayer = player(player);
        nPlayer.setMayor(true);
    }

    public void removeMayor(Player player) {
        NightPlayer nPlayer = player(player);
        nPlayer.setMayor(false);
    }

    public void addPlayer(UUID uuid) {
        if(player(uuid) != null) {
            return;
        }
        players.add(new NightPlayer(uuid));
    }

    public void eliminate(Player player) {
        NightPlayer nPlayer = player(player);
        nPlayer.setEliminated(true);
    }

    public void unEliminate(Player player) {
        NightPlayer nPlayer = player(player);
        nPlayer.setEliminated(false);
    }

    public boolean isEliminated(Player player) {
        NightPlayer nPlayer = player(player);
        return nPlayer.isEliminated();
    }
}

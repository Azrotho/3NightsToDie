package fr.azrotho.threenightstodie.objects;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.annotation.Nullable;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;
import org.jetbrains.annotations.NotNull;

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
    public NightPlayer player(@NotNull Player player) {
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
        player.kickPlayer("§cVous avez été éliminé");
    }

    public void unEliminate(OfflinePlayer player) {
        NightPlayer nPlayer = player(player.getUniqueId());
        nPlayer.setEliminated(false);
    }

    public boolean isEliminated(Player player) {
        NightPlayer nPlayer = player(player);
        return nPlayer.isEliminated();
    }
    
    public boolean isAdmin(Player player) {
        Team adminTeam = Bukkit.getScoreboardManager().getMainScoreboard().getTeam("adminTeam");
        for(OfflinePlayer member : adminTeam.getPlayers()) {
            if(member.getUniqueId().equals(player.getUniqueId())) {
                return true;
            }
        }
        return false;
    }

    public boolean isInRedTeam(Player player) {
        Team redTeam = Bukkit.getScoreboardManager().getMainScoreboard().getTeam("redTeam");
        for(OfflinePlayer member : redTeam.getPlayers()) {
            if(member.getUniqueId().equals(player.getUniqueId())) {
                return true;
            }
        }
        return false;
    }

    public boolean hasVoted(Player player) {
        NightPlayer nPlayer = player(player);
        return nPlayer.hasVoted();
    }

    public void aVote(Player player) {
        NightPlayer nPlayer = player(player);
        nPlayer.setHasVoted(true);
    }

    public boolean hasChangeColor(Player player) {
        NightPlayer nPlayer = player(player);
        return nPlayer.hasChangedColor();
    }

    public void changeColor(Player player) {
        NightPlayer nPlayer = player(player);
        nPlayer.setHasChangedColor(true);
    }

    public boolean hasTargeted(Player player) {
        NightPlayer nPlayer = player(player);
        return nPlayer.hasTargeted();
    }

    public void target(Player player) {
        NightPlayer nPlayer = player(player);
        nPlayer.setHasTargeted(true);
    }

    public void resetForAllPlayersTargetingAndColor() {
        for(NightPlayer nPlayer : players) {
            nPlayer.setHasChangedColor(false);
            nPlayer.setHasTargeted(false);
        }
    }

    public void unTarget(Player player) {
        NightPlayer nPlayer = player(player);
        nPlayer.setHasTargeted(false);
    }

    public void resetVote() {
        for(NightPlayer nPlayer : players) {
            nPlayer.setHasVoted(false);
        }
    }

    public void untargetAllPlayers() {
        for(NightPlayer nPlayer : players) {
            nPlayer.setHasTargeted(false);
        }
    }

    public List<Player> getDeathRanking() {
        List <Player> ranking = new ArrayList<>();
        for(int i = 0; i < Bukkit.getOnlinePlayers().size(); i++) {
            Player best = null;
            for(Player player : Bukkit.getOnlinePlayers()) {
                NightPlayer nPlayer = player(player);
                if(!ranking.contains(nPlayer)) {
                    if(best == null) {
                        best = player;
                    } else {
                        if(nPlayer.death() > player(best).death()) {
                            best = player;
                        }
                    }
                }
            }
            ranking.add(best);
        }
        return ranking;
    }

    public void displayDeathRanking() {
        List <Player> ranking = getDeathRanking();
        for(int i = 0; i < ranking.size(); i++) {
            Bukkit.broadcastMessage("§c" + (i + 1) + " - " + ranking.get(i).getName() + " : " + player(ranking.get(i)).death() + " morts");
        }
    }

    public List<Player> getVoteRanking() {
        List <Player> ranking = new ArrayList<>();
        for(int i = 0; i < Bukkit.getOnlinePlayers().size(); i++) {
            Player best = null;
            for(Player player : Bukkit.getOnlinePlayers()) {
                NightPlayer nPlayer = player(player);
                if(!ranking.contains(nPlayer)) {
                    if(best == null) {
                        best = player;
                    } else {
                        if(nPlayer.vote() > player(best).vote()) {
                            best = player;
                        }
                    }
                }
            }
            ranking.add(best);
        }
        return ranking;
    }

    public void displayVoteRanking() {
        List <Player> ranking = getVoteRanking();
        for(int i = 0; i < ranking.size(); i++) {
            Bukkit.broadcastMessage("§c" + (i + 1) + " - " + ranking.get(i).getName() + " : " + player(ranking.get(i)).death() + " votes");
        }
    }
}

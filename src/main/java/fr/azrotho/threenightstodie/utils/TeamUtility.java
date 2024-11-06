package fr.azrotho.threenightstodie.utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;
import fr.azrotho.threenightstodie.ThreeNightsToDiePlugin;

public class TeamUtility {

    Team noTeam;
    Team greenTeam;
    Team yellowTeam;
    Team redTeam;
    Team adminTeam;

    ThreeNightsToDiePlugin plugin;

    public TeamUtility(ThreeNightsToDiePlugin plugin) {
        this.plugin = plugin;
    }

    public void init() {
        if(!checkIfTeamExists("noTeam")) {
            noTeam = plugin.getServer().getScoreboardManager().getMainScoreboard().registerNewTeam("noTeam");
            noTeam.setPrefix("§7");
            noTeam.setAllowFriendlyFire(true);
            noTeam.setCanSeeFriendlyInvisibles(false);
            noTeam.setColor(ChatColor.GRAY);
        } else {
            noTeam = plugin.getServer().getScoreboardManager().getMainScoreboard().getTeam("noTeam");
        }
        if(!checkIfTeamExists("greenTeam")) {
            greenTeam = plugin.getServer().getScoreboardManager().getMainScoreboard().registerNewTeam("greenTeam");
            greenTeam.setPrefix("§a");
            greenTeam.setAllowFriendlyFire(true);
            greenTeam.setCanSeeFriendlyInvisibles(false);
            greenTeam.setColor(ChatColor.GREEN);
        } else {
            greenTeam = plugin.getServer().getScoreboardManager().getMainScoreboard().getTeam("greenTeam");
        }
        if(!checkIfTeamExists("yellowTeam")) {
            yellowTeam = plugin.getServer().getScoreboardManager().getMainScoreboard().registerNewTeam("yellowTeam");
            yellowTeam.setPrefix("§e");
            yellowTeam.setAllowFriendlyFire(true);
            yellowTeam.setCanSeeFriendlyInvisibles(false);
            yellowTeam.setColor(ChatColor.YELLOW);
        } else {
            yellowTeam = plugin.getServer().getScoreboardManager().getMainScoreboard().getTeam("yellowTeam");
        }
        if(!checkIfTeamExists("redTeam")) {
            redTeam = plugin.getServer().getScoreboardManager().getMainScoreboard().registerNewTeam("redTeam");
            redTeam.setPrefix("§c");
            redTeam.setAllowFriendlyFire(true);
            redTeam.setCanSeeFriendlyInvisibles(false);
            redTeam.setColor(ChatColor.RED);
        } else {
            redTeam = plugin.getServer().getScoreboardManager().getMainScoreboard().getTeam("redTeam");
        }
        if(!checkIfTeamExists("adminTeam")) {
            adminTeam = plugin.getServer().getScoreboardManager().getMainScoreboard().registerNewTeam("adminTeam");
            adminTeam.setPrefix("§4§lORGA§c ");
            adminTeam.setAllowFriendlyFire(true);
            adminTeam.setCanSeeFriendlyInvisibles(false);
            adminTeam.setColor(ChatColor.DARK_RED);
        } else {
            adminTeam = plugin.getServer().getScoreboardManager().getMainScoreboard().getTeam("adminTeam");
        }
    }

    public boolean checkIfTeamExists(String teamName) {
        for(Team team : plugin.getServer().getScoreboardManager().getMainScoreboard().getTeams()) {
            if(team.getName().equals(teamName)) {
                return true;
            }
        }
        return false;
    }

    public Team noTeam() {
        return this.noTeam;
    }

    public Team greenTeam() {
        return this.greenTeam;
    }

    public Team yellowTeam() {
        return this.yellowTeam;
    }

    public Team redTeam() {
        return this.redTeam;
    }

    public Team adminTeam() {
        return this.adminTeam;
    }

    public void changeTeam(Player player, Team team) {
        if(player.getScoreboard().getTeams().size() > 0) {
            for(Team _team : player.getScoreboard().getTeams()) {
                _team.removeEntry(player.getName());
            }
        }
        team.addEntry(player.getName());
    }
}

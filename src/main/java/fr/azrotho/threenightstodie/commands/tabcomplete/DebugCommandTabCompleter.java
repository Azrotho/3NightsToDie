package fr.azrotho.threenightstodie.commands.tabcomplete;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

import fr.azrotho.threenightstodie.ThreeNightsToDiePlugin;

public class DebugCommandTabCompleter implements TabCompleter {
    private ThreeNightsToDiePlugin plugin;

    public DebugCommandTabCompleter(ThreeNightsToDiePlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> completions = new ArrayList<>();

        if (!sender.isOp()) {
            return completions; // Return empty list if not op
        }

        if (args.length == 1) {
            completions.add("vote");
            completions.add("shop");
            completions.add("team");
            completions.add("eliminate");
            completions.add("npc");
            completions.add("ranking");
            completions.add("help");
            completions.add("mayor");
            completions.add("targetPlayer");
            completions.add("tracker");
            completions.add("target");
        } else if (args.length == 2) {
            switch (args[0]) {
                case "vote":
                    completions.add("enable");
                    completions.add("disable");
                    completions.add("reset");
                    break;
                case "shop":
                    completions.add("open");
                    completions.add("openSelf");
                    completions.add("resetShop");
                    break;
                case "team":
                    completions.add("changeTeam");
                    break;
                case "eliminate":
                    completions.add("eliminate");
                    completions.add("revive");
                    break;
                case "ranking":
                    completions.add("deaths");
                    completions.add("votes");
                    break;
                case "mayor":
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        completions.add(player.getName());
                    }
                    break;
                case "targetPlayer":
                    completions.add("enable");
                    completions.add("disable");
                    break;
                case "tracker":
                    completions.add("getTracker");
                    break;
                case "target":
                    completions.add("target");
                    completions.add("untarget");
                    break;
            }
        } else if (args.length == 3) {
            switch (args[0]) {
                case "shop":
                    if (args[1].equals("open")) {
                        for (Player player : Bukkit.getOnlinePlayers()) {
                            completions.add(player.getName());
                        }
                    }
                    break;
                case "team":
                    if (args[1].equals("changeTeam")) {
                        for (Player player : Bukkit.getOnlinePlayers()) {
                            completions.add(player.getName());
                        }
                    }
                    break;
                case "eliminate":
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        completions.add(player.getName());
                    }
                    break;

                case "mayor":
                    completions.add("setMayor");
                    completions.add("removeMayor");
                    break;

                case "tracker":
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        completions.add(player.getName());
                    }
                    break;
                case "target":
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        completions.add(player.getName());
                    }
                    break;
            }
        } else if (args.length == 4) {
            if (args[0].equals("team") && args[1].equals("changeTeam")) {
                for (Team team : Bukkit.getScoreboardManager().getMainScoreboard().getTeams()) {
                    completions.add(team.getName());
                }
            }
        }

        return completions;
    }
}

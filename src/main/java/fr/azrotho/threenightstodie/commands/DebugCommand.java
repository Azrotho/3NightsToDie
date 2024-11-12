package fr.azrotho.threenightstodie.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

import fr.azrotho.threenightstodie.ThreeNightsToDiePlugin;
import fr.azrotho.threenightstodie.shop.ShopInventories;

public class DebugCommand implements CommandExecutor {

    private ThreeNightsToDiePlugin plugin;

    public DebugCommand(ThreeNightsToDiePlugin plugin) {
        this.plugin = plugin;
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean onCommand(CommandSender sender, Command command, String name, String[] args) {
        if(!sender.isOp()) { 
            sender.sendMessage("§cVous n'avez pas la permission d'utiliser cette commande");
            return true;
        }

        switch(args[0]) {
            case "vote" -> {
                sender.sendMessage("§aCommande vote");
                switch (args[1]) {
                    case "enable" -> {
                        plugin.nightGame().setVoteEnabled(true);
                    }
                    case "disable" -> {
                        plugin.nightGame().setVoteEnabled(false);
                    }
                    case "reset" -> {
                        plugin.nightPlayerManager().resetVote();
                    }
                }
            }
            case "shop" -> {
                sender.sendMessage("§aCommande shop");
                ShopInventories shopInventories = new ShopInventories(plugin);
                if(args[1].equals("open")) {
                    Player player = Bukkit.getPlayer(args[2]);
                    if(player == null) {
                        sender.sendMessage("§cJoueur introuvable");
                        return true;
                    }
                    shopInventories.openShopPlayer(player);
                }
                if(args[1].equals("openSelf")) {
                    Player player = (Player) sender;
                    shopInventories.openShopPlayer(player);
                }
                if(args[1].equals("resetShop")) {
                    plugin.nightPlayerManager().resetForAllPlayersTargetingAndColor();
                }
            }
            case "team" -> {
                switch (args[1]) {
                    case "changeTeam" -> {
                        Player player = Bukkit.getPlayer(args[2]);
                        if(player == null) {
                            sender.sendMessage("§cJoueur introuvable");
                            return true;
                        }

                        Team team = Bukkit.getScoreboardManager().getMainScoreboard().getTeam(args[3]);
                        if(team == null) {
                            sender.sendMessage("§cEquipe introuvable");
                            return true;
                        }
                        
                        plugin.teamUtility().changeTeam(player, team);
                    }
                }
            }
            case "eliminate" -> {
                if(args[1].equals("eliminate")) {
                    Player player = Bukkit.getPlayer(args[2]);
                    if(player == null) {
                        sender.sendMessage("§cJoueur introuvable");
                        return true;
                    }
                    plugin.nightPlayerManager().eliminate(player);
                }
                if(args[1].equals("revive")) {
                    OfflinePlayer player = Bukkit.getOfflinePlayer(args[2]);
                    if(player == null) {
                        sender.sendMessage("§cJoueur introuvable");
                        return true;
                    }
                    plugin.nightPlayerManager().unEliminate(player);
                }
            }
            case "npc" -> {
                sender.sendMessage("§aCommande npc");
                plugin.npcUtility().init(new Location(Bukkit.getWorld("world"), 0, 90, 0));
            }
            case "ranking" -> {
                sender.sendMessage("§aCommande ranking");
                switch (args[1]) {
                    case "deaths" -> {
                        plugin.nightPlayerManager().displayDeathRanking();
                    }
                    case "votes" -> {
                        plugin.nightPlayerManager().displayVoteRanking();
                    }
                }
            }
            case "help" -> {
                sender.sendMessage("§aCommande help");
            }
            case "mayor" -> {
                sender.sendMessage("§aCommande mayor");
                Player target = Bukkit.getPlayer(args[1]);
                if(target == null) {
                    sender.sendMessage("Joueur déconnecté");
                    return true;
                }
                if(args[2].equalsIgnoreCase("enable")) {
                    plugin.nightPlayerManager().setMayor(target);
                } else {
                    plugin.nightPlayerManager().removeMayor(target);
                }
            }
            case "targetPlayer" -> {
                switch (args[1]) {
                    case "enable" -> {
                        plugin.nightGame().setTargetPlayerEnabled(true);
                    } 
                    default -> {
                        plugin.nightGame().setTargetPlayerEnabled(false);
                    }
                }
            }
            case "tracker" -> {
                sender.sendMessage("Commande de tracker");
                if(args[1].equals("getTracker")) {
                    Player target = Bukkit.getPlayer(args[2]);
                    if(target == null) {
                        sender.sendMessage("Joueur déconnecté");
                        return true;
                    }
                    Player player = (Player) sender;
                    player.getInventory().addItem(plugin.trackerUtility().getTracker(target));
                }
            }
            default -> {
                sender.sendMessage("§cCommande inconnue, faites /debug help pour voir les commandes disponibles");
            }
        }
        return true;
    }
    
}

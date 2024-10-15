package fr.azrotho.threenightstodie.commands;

import org.bukkit.Bukkit;
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
            }
            case "ranking" -> {
                sender.sendMessage("§aCommande ranking");
            }
            case "help" -> {
                sender.sendMessage("§aCommande help");
            }
            case "mayor" -> {
                sender.sendMessage("§aCommande mayor");
            }
            case "targetPlayer" -> {
                sender.sendMessage("Commande targetPlayer");
            }
            default -> {
                sender.sendMessage("§cCommande inconnue, faites /debug help pour voir les commandes disponibles");
            }
        }
        return true;
    }
    
}

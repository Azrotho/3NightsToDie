package fr.azrotho.threenightstodie.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class DebugCommand implements CommandExecutor{

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
            }
            case "team" -> {
                sender.sendMessage("§aCommande team");
            }
            case "eliminate" -> {
                sender.sendMessage("§aCommande eliminate");
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
            default -> {
                sender.sendMessage("§cCommande inconnue, faites /debug help pour voir les commandes disponibles");
            }
        }

        return true;
    }
    
}

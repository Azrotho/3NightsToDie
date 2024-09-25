package fr.azrotho.threenightstodie.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BroadcastCommnad implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String name, String[] args) {
        if(!sender.isOp()) {
            sender.sendMessage("§cVous n'avez pas la permission d'utiliser cette commande");
            return true;
        }

        if(args.length == 0) {
            sender.sendMessage("§cUtilisation: /broadcast <message>");
            return true;
        }

        StringBuilder message = new StringBuilder();
        for(String arg : args) {
            message.append(arg.replace("&", "§")).append(" ");
        }

        for(Player player : sender.getServer().getOnlinePlayers()) {
            player.sendMessage(message.toString());
        }

        return true;
    }
    
}

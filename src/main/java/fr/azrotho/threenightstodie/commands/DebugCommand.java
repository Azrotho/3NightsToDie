package fr.azrotho.threenightstodie.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class DebugCommand implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String name, String[] args) {
        if(!sender.isOp()) { 
            sender.sendMessage("§cVous n'avez pas la permission d'utiliser cette commande");
            return false;
        }

        return true;
    }
    
}

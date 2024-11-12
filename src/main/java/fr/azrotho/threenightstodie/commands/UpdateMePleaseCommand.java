package fr.azrotho.threenightstodie.commands;

import fr.azrotho.threenightstodie.utils.DayCycleUtility;
import fr.azrotho.threenightstodie.utils.NickPlayerUtility;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class UpdateMePleaseCommand implements CommandExecutor {

    private final DayCycleUtility dayCycleUtility;
    private final NickPlayerUtility nickPlayerUtility;

    public UpdateMePleaseCommand() {
        this.dayCycleUtility = new DayCycleUtility();
        this.nickPlayerUtility = new NickPlayerUtility();
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(!(commandSender instanceof Player)) {
            commandSender.sendMessage("You must be a player to use this command.");
            return true;
        }
        Player player = (Player) commandSender;
        if(dayCycleUtility.isDay(player.getWorld().getTime())) {
            nickPlayerUtility.resetPlayer(player);
        } else {
            nickPlayerUtility.anonimizePlayer(player);
        }
        return true;
    }
}

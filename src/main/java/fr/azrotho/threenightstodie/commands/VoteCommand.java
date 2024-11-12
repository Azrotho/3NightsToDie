package fr.azrotho.threenightstodie.commands;

import fr.azrotho.threenightstodie.ThreeNightsToDiePlugin;
import fr.azrotho.threenightstodie.objects.NightPlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VoteCommand implements CommandExecutor {

    private final ThreeNightsToDiePlugin plugin;

    public VoteCommand(ThreeNightsToDiePlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String name, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage("Seul un joueur peut executer cette commande");
            return true;
        }

        if(!plugin.nightGame().isVoteEnabled()) {
            sender.sendMessage("Le vote n'est pas activé");
            return true;
        }

        Player player = (Player) sender;
        NightPlayer nPlayer = plugin.nightPlayerManager().player(player);

        if(nPlayer.hasVoted()) {
            player.sendMessage("Vous avez déjà voté");
            return true;
        }

        if(args.length == 0) {
            player.sendMessage("Vous devez spécifier un joueur");
            return true;
        }

        Player target = plugin.getServer().getPlayer(args[0]);

        if(target == null) {
            player.sendMessage("Le joueur spécifié n'est pas connecté ou n'existe pas");
            return true;
        }

        NightPlayer nTarget = plugin.nightPlayerManager().player(target);
        if(nPlayer.isMayor()) {
            nTarget.setVote(nTarget.vote() + 2);
            player.sendMessage("§e§lVous êtes le maire, votre vote compte double");
        } else {
            nTarget.setVote(nTarget.vote() + 1);
        }
        nPlayer.setHasVoted(true);
        player.sendMessage("Vous avez voté pour " + target.getName());
        return true;
    }
}

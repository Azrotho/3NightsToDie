package fr.azrotho.threenightstodie.runnable;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;

import fr.azrotho.threenightstodie.ThreeNightsToDiePlugin;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class TrackerGestionRunnable extends BukkitRunnable {

    private ThreeNightsToDiePlugin plugin;

    public TrackerGestionRunnable(ThreeNightsToDiePlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        for(Player player : Bukkit.getOnlinePlayers()) {
            if(player.getItemInHand() != null) {
                ItemStack item = player.getItemInHand();
                if(item.getItemMeta() != null) {
                    ItemMeta meta = item.getItemMeta();
                    if(meta.getDisplayName().contains("§c§lTracker")) {
                        NamespacedKey key = new NamespacedKey(plugin, "tracker_target");
                        String name = meta.getPersistentDataContainer().get(key, PersistentDataType.STRING);
                        Player target = Bukkit.getPlayer(name);
                        if(target != null) {
                            if(plugin.nightPlayerManager().isInRedTeam(target)) {
                                if(player.getWorld().getName().equals(target.getWorld().getName())) {
                                    player.setCompassTarget(target.getLocation());
                                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§a" + name + " est à " + (int) player.getLocation().distance(target.getLocation()) + " blocs de vous"));
                                } else {
                                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§c" + name + " n'est pas dans le même monde que vous"));
                                }
                            } else {
                                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§c" + name + " n'est plus rouge"));
                            }
                        } else {
                            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§c" + name + " n'est plus en ligne"));
                        }
                    }
                }
            }
        }
    }
    
}

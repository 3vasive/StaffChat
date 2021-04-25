package me.evasive.staffchat;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Events implements Listener {

    public Events(StaffChat plugin){
        this.plugin = plugin;
    }
    public StaffChat plugin;


    @EventHandler
    public void onChat(AsyncPlayerChatEvent e){
        if (Commands.toggle.contains(e.getPlayer().getName())){
            String message = e.getMessage();
            Player player = e.getPlayer();
            String nama = player.getName();
            e.setCancelled(true);
            //
            if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null && Bukkit.getPluginManager().getPlugin("LuckPerms") != null) {
                String name = PlaceholderAPI.setPlaceholders(player, "%player_name%");
                String prefix = PlaceholderAPI.setPlaceholders(player, "%luckperms_prefix%");
                String send = (StaffChat.getPlugin(StaffChat.class).getConfig().getString("Prefix") + ChatColor.RESET + prefix + name + StaffChat.getPlugin(StaffChat.class).getConfig().getString("Chat_Color") + " "  + message);
                GetMessage.getMessage(send);
            }else{
                String send = (StaffChat.getPlugin(StaffChat.class).getConfig().getString("Prefix") + ChatColor.RESET + nama + StaffChat.getPlugin(StaffChat.class).getConfig().getString("Chat_Color") + " " + message);
                GetMessage.getMessage(send);
            }
        }
            //
        }
    }

package me.evasive.staffchat;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class GetMessage {
    public StaffChat plugin;

    public void StaffChat(StaffChat plugin){
        this.plugin = plugin;
    }
    public static void getMessage(String message){
        for(Player player : Bukkit.getOnlinePlayers()){
            if(player.hasPermission("staffchat.chat")) {
                player.sendMessage(message);
            }
        }
    }
}

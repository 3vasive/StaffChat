package me.evasive.staffchat;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

public class Reload implements CommandExecutor {
    public StaffChat plugin;

    public void Reload(StaffChat plugin){
        this.plugin = plugin;
        plugin.getCommand("staffchat").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("staffchat.admin")){
            if(args.length == 1){
                if (args[0].equals("reload")){
                    StaffChat.getPlugin(StaffChat.class).reloadConfig();
                    sender.sendMessage(ChatColor.GREEN + "StaffChat has been reloaded");
                    return true;
                }
            }else{
                sender.sendMessage(ChatColor.YELLOW + "/staffchat reload");
            }
            return true;
        }
        return true;
    }
}

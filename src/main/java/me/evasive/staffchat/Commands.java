package me.evasive.staffchat;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Commands implements CommandExecutor {
    public StaffChat plugin;

    public void StaffChat(StaffChat plugin){
        this.plugin = plugin;
        plugin.getCommand("sc").setExecutor(this);
    }
    static List<String> toggle = new ArrayList<String>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can use this command!");
            return true;
        }
        if(sender.hasPermission("staffchat.chat")) {
            if (command.getName().equalsIgnoreCase("sc")) {
                if (args.length == 0){
                   if (toggle.contains( sender.getName())){
                       sender.sendMessage("Staff Chat Disabled");
                       toggle.remove(sender.getName());
                   }else{
                       sender.sendMessage("Staff Chat Enabled");
                       toggle.add(sender.getName());
                   }
                //    sender.sendMessage("/sc (message)");
                }else{
                    String nama = sender.getName();
                    String message = "";
                    for (int i = 0; i <= args.length - 1; i++){
                        message = message + args[i] + " ";
                    }
                    Player player = (Player) sender;
                    if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null && Bukkit.getPluginManager().getPlugin("LuckPerms") != null) {
                        String name = PlaceholderAPI.setPlaceholders(player, "%player_name%");
                        String prefix = PlaceholderAPI.setPlaceholders(player, "%luckperms_prefix%");
                        String send = ("" + ChatColor.GOLD + ChatColor.BOLD +"<" + ChatColor.AQUA + ChatColor.BOLD +"SC" + ChatColor.GOLD + ChatColor.BOLD + "> " + ChatColor.RESET + prefix + name + ChatColor.RED + " "  + message);
                        GetMessage.getMessage(send);
                        return true;
                    }
                    String send = ("" + ChatColor.GOLD + ChatColor.BOLD +"<" + ChatColor.AQUA + ChatColor.BOLD +"SC" + ChatColor.GOLD + ChatColor.BOLD + "> " + ChatColor.RESET + nama + ChatColor.RED + " " + message);
                    GetMessage.getMessage(send);
                    return true;
                }
            }
        }else{
            sender.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
        }
        return false;
    }
}

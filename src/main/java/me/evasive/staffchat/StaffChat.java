package me.evasive.staffchat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public final class StaffChat extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.saveDefaultConfig();
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") == null) {
            Bukkit.getLogger().info(ChatColor.GREEN + "[StaffChat] " + ChatColor.YELLOW + "If you wish to add prefix please install PlaceholderAPI.");
        }
        if (Bukkit.getPluginManager().getPlugin("LuckPerms") == null) {
            Bukkit.getLogger().info(ChatColor.GREEN + "[StaffChat] " + ChatColor.YELLOW + "If you wish to add prefix please install LuckPerms.");
        }
        getServer().getPluginManager().registerEvents(new Events(this), this);
        getCommand("sc").setExecutor((CommandExecutor) new Commands());
        getCommand("staffchat").setExecutor((CommandExecutor) new Reload());
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Staff chat is ready!");
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Staff chat shutting down");
        // Plugin shutdown logic
    }
}

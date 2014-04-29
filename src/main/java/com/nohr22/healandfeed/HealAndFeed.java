package com.nohr22.healandfeed;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class HealAndFeed extends JavaPlugin {

    public void onEnable(){
        Bukkit.getServer().getLogger().info("HealAndFeed v" + getDescription().getVersion() + " has been enabled!");
    }

    public void onDisable(){
        Bukkit.getServer().getLogger().info("HealAndFeed v" + getDescription().getVersion() + " has been disabled!");
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
        if (!(sender instanceof Player)){
            sender.sendMessage(ChatColor.RED + "The console can not use the heal and feed command!");
            return true;
        }
        Player p = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("heal")) {
            if (args.length == 0) {
                p.setHealth(20.0);
                p.setFoodLevel(20);
                p.sendMessage(ChatColor.GREEN + "You have been healed.");
                return true;
            }
            Player target = Bukkit.getServer().getPlayer(args[0]);
            if (target == null){
                p.sendMessage(ChatColor.RED + "Could not find player " + args[0] + ".");
                return true;
            }
            target.setHealth(20.0);
            target.setFoodLevel(20);
            target.sendMessage(ChatColor.GREEN + "You have been healed by " + p.getName() + ".");
            p.sendMessage(ChatColor.GREEN + target.getName() + " has been healed!");
        }
        if (cmd.getName().equalsIgnoreCase("feed")) {
            if (args.length == 0) {
                p.setFoodLevel(20);
                p.sendMessage(ChatColor.GREEN + "You have been fed.");
                return true;
            }
            Player target = Bukkit.getServer().getPlayer(args[0]);
            if (target == null){
                p.sendMessage(ChatColor.RED + "Could not find player " + args[0] + ".");
                return true;
            }
            target.setFoodLevel(20);
            target.sendMessage(ChatColor.GREEN + "You have been fed by " + p.getName() + ".");
            p.sendMessage(ChatColor.GREEN + target.getName() + " has been fed!");
        }
        return true;
    }
}

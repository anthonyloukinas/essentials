package net.anthonyloukinas.essentials;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import net.md_5.bungee.api.ChatColor;


public class Heal implements Listener, CommandExecutor{
	public Heal(Main plugin){
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	
		public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
			Player p = (Player) sender;
			if(command.getName().equalsIgnoreCase("heal")){
				if(args.length == 0){
					p.setHealth(20D);
					p.setFoodLevel(20);
					p.sendMessage(ChatColor.GREEN + "You have healed yourself!");
					return true;
				}
				
				if(args.length == 1){
					Player t = Bukkit.getServer().getPlayer(args[0]);
					t.setHealth(20);
					t.setFoodLevel(20);
					t.sendMessage(ChatColor.GREEN + "You were healed by " + ChatColor.GOLD + p.getName());
					t.sendMessage(ChatColor.GREEN + "You healed " + ChatColor.GOLD + t.getName());
					return true;
				}
			}
			return true;
	}


}


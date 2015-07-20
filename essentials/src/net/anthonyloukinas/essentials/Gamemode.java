package net.anthonyloukinas.essentials;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import net.md_5.bungee.api.ChatColor;

public class Gamemode implements Listener, CommandExecutor {
	public Gamemode(Main plugin){
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	

	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		readCommand((Player) sender, label);
		return false;
	}
	
	public void readCommand(Player player,String command){
		if(command.equalsIgnoreCase("creative")){
			player.setGameMode(GameMode.CREATIVE);
			player.sendMessage(ChatColor.GOLD + "Now entering " + ChatColor.RED + "creative" + ChatColor.GOLD + " mode!");
		}else if(command.equalsIgnoreCase("survival")){
			player.setGameMode(GameMode.SURVIVAL);
			player.sendMessage(ChatColor.GOLD + "Now entering " + ChatColor.RED + "survival" + ChatColor.GOLD + " mode!");
			
		}
	}
}

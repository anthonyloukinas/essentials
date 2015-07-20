package net.anthonyloukinas.essentials;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import net.md_5.bungee.api.ChatColor;

public class Teleport implements CommandExecutor, Listener{
	public Teleport(Main plugin){
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		
		if(label.equalsIgnoreCase("teleport")){
			Player p = (Player) sender;
			if(args.length == 0){
				p.sendMessage(ChatColor.GOLD + "/tp <Player> {target}");
			}else if(args.length == 1){
				Player targetPlayer = p.getServer().getPlayer(args[0]);
				Location targetPlayerLocation = targetPlayer.getLocation();
				p.teleport(targetPlayerLocation);
				p.sendMessage(ChatColor.DARK_PURPLE + "Teleported!");
			}else if(args.length == 2){
				Player targetPlayer = p.getServer().getPlayer(args[0]);
				Player targetPlayer1 = p.getServer().getPlayer(args[1]);
				Location targetPlayer1Location = targetPlayer1.getLocation();
				targetPlayer.teleport(targetPlayer1Location);
				p.sendMessage(ChatColor.DARK_AQUA + "Teleported to " + p.getName() + "!");
			}
		}
		return false;
	}

}

package net.anthonyloukinas.essentials;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import net.md_5.bungee.api.ChatColor;

public class JoinListener implements Listener{
	public JoinListener(Main plugin){
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e){
		
		Player player = e.getPlayer();
		
		e.setJoinMessage(ChatColor.GREEN + "Welcome " + ChatColor.GOLD + player.getName() + ChatColor.GREEN + " to the server!");
		
		//If new player
		if (player.hasPlayedBefore() == false) {
			player.sendMessage(ChatColor.GREEN + "Thank you for visiting our server.");
		}
	}
}

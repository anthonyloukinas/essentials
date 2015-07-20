package net.anthonyloukinas.essentials;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import net.md_5.bungee.api.ChatColor;


public class ChickenStorm implements Listener, CommandExecutor{
	public ChickenStorm(Main plugin){
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	private static final int NUM_CHICKENS = 30;
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] arguments){
		if (label.equalsIgnoreCase("chickenstorm")){
			if(sender instanceof Player){
				executeCommand(sender);
				return true;
			}
		}
		return false;
	}

	private void executeCommand(CommandSender sender) {
		Player p = (Player) sender;
		Location loc = p.getLocation();
		World world = p.getWorld();
		
		int quantity = 0;
		
		//loop from 1 to NUM_CHICKENS times
		for (int i = 1; i < Math.random() * NUM_CHICKENS + 1; i++){
			//pick a spot for the chicken above the player
			Location chickenLoc = new Location(world, loc.getX() - 15 + Math.random() *30, loc.getY() + 10 + Math.random() * 100, loc.getZ() - 15 + Math.random() * 30);
			if(chickenLoc.getBlock().getType() != Material.AIR){
				//dont put the chicken in a solid block
				continue;
			}
			Chicken chicken = world.spawn(chickenLoc, Chicken.class);
			if(Math.random() < .4){
				chicken.setBaby();
			}else{
				chicken.setAdult();
			}
			quantity++;
		}
		
		//Do something here
		p.sendMessage(ChatColor.GOLD + "You have spawned " + ChatColor.GREEN + quantity + ChatColor.GOLD + " chickens!");
	}
}

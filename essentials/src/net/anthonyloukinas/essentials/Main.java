package net.anthonyloukinas.essentials;

import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin{

	@Override
	public void onEnable()
	{
		new JoinListener(this);
		getCommand("chickenstorm").setExecutor(new ChickenStorm (this));
		getCommand("heal").setExecutor(new Heal(this));
	}
	
	@Override
	public void onDisable()
	{
		
	}
	
}

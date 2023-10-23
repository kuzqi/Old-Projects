package me.devo;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	public void onEnable() {
		getServer().getConsoleSender().sendMessage("§8[§bVenixRod§8]§a has been enabled! by [VenixCoding - Devo] discord.gg/Kak7pWH8mg");
		getServer().getPluginManager().registerEvents(new Rod(this), this);
		getCommand("rodreload").setExecutor(new ReloadCMD(this));
		getCommand("rreload").setExecutor(new ReloadCMD(this));
		saveDefaultConfig();
	}
	
	public void onDisable() {
		getServer().getConsoleSender().sendMessage("§8[§bVenixRod§8]§4 has been disabled! by [VenixCoding - Devo] discord.gg/Kak7pWH8mg");
		
	}
}

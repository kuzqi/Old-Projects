package me.o16;

import java.util.ArrayList;

import org.bukkit.plugin.java.JavaPlugin;

import com.google.common.collect.Lists;

import me.o16.Commands.RankCommand;
import me.o16.Commands.SpawnCommand;
import me.o16.Commands.WorldsCommand;
import me.o16.Listeners.JoinListener;
import me.o16.Listeners.QuitListener;
import me.o16.Listeners.RandomTeleport;

public class Main extends JavaPlugin {
    
	public ArrayList<String> vanish = Lists.newArrayList();
	
	@Override
	public void onEnable() {
		// CONFIG
		saveDefaultConfig();
		
		// LISTENERS
		getServer().getPluginManager().registerEvents(new RandomTeleport(this), this);
		getServer().getPluginManager().registerEvents(new JoinListener(this), this);
		getServer().getPluginManager().registerEvents(new QuitListener(), this);
		
		// COMMANDS
		getCommand("spawn").setExecutor(new SpawnCommand(this));
		getCommand("normalworld").setExecutor(new WorldsCommand());
		getCommand("netherworld").setExecutor(new WorldsCommand());
		getCommand("theendworld").setExecutor(new WorldsCommand());
		getCommand("setrank").setExecutor(new RankCommand());
	}
	
	
	@Override
	public void onDisable() {
	}
}

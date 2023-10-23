package Lobby;

import java.util.ArrayList;

import org.bukkit.plugin.java.JavaPlugin;

import com.google.common.collect.Lists;

import Lobby.Commands.HelpCommand;
import Lobby.Commands.SubCommands;
import Lobby.Listeners.FunGunListener;
import Lobby.Listeners.JoinListener;
import Lobby.o16.Staff.StaffListeners;
import Lobby.o16.Staff.StaffCommands.BuildCommand;
import Lobby.o16.Staff.StaffCommands.InvseeCommand;
import Lobby.o16.Staff.StaffCommands.VanishCommand;

public class Main extends JavaPlugin {

	public ArrayList<String> vanish = Lists.newArrayList();
	public ArrayList<String> build = Lists.newArrayList();
	
	@Override
	public void onEnable() {
		// CONFIG
		saveDefaultConfig();
		// LISTENERS
		getServer().getPluginManager().registerEvents(new FunGunListener(this),this);
		getServer().getPluginManager().registerEvents(new StaffListeners(this),this);
		getServer().getPluginManager().registerEvents(new JoinListener(this), this);
		// COMMANDS
		getCommand("help").setExecutor(new HelpCommand(this));
		getCommand("discord").setExecutor(new SubCommands(this));
		getCommand("website").setExecutor(new SubCommands(this));
		getCommand("online").setExecutor(new SubCommands(this));
		// STAFF COMMANDS
		getCommand("vanish").setExecutor(new VanishCommand(this));
		getCommand("invsee").setExecutor(new InvseeCommand(this));
		getCommand("build").setExecutor(new BuildCommand(this));
		getCommand("v").setExecutor(new VanishCommand(this));
		
		
	}
	
	@Override
	public void onDisable() {
		
	}
}

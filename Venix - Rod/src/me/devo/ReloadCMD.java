package me.devo;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReloadCMD implements CommandExecutor {

	private final Main main;
	public ReloadCMD(Main main) {
		this.main = main;
	}

	  public boolean onCommand(CommandSender sender, Command cmd, String command, String[] args) {
		  
		  if (command.equalsIgnoreCase("rreload") || command.equalsIgnoreCase("rodreload")) {
			  if (!(sender.hasPermission("fastrod.reload"))) {
				  sender.sendMessage("§8[§bVenixRod§8]§4 You don't have access to use this command.");
				  
			  }else {
				  main.saveDefaultConfig();
				  main.reloadConfig();
				  sender.sendMessage("§8[§bVenixRod§8]§a Successfully reloaded the config file!");
			  }
		  }
		  
		return true;
	  }
}

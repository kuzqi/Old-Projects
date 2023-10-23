package me.o16.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WorldsCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String command, String[] args) {
		
		if (command.equalsIgnoreCase("normalworld")) {
			Player p = (Player)cs;
			Location spawn1 = new Location (Bukkit.getWorld("world"), 371.922, 72, -197.088, (float)180.7, (float)-0.4);
			p.teleport(spawn1);
		}
		
		if (command.equalsIgnoreCase("netherworld")) {
			Player p = (Player)cs;
			Location spawn2 = new Location (Bukkit.getWorld("world_nether"), -0.908, 59, 54.150, (float)-88.5, (float)1.1);
			p.teleport(spawn2);
		}
		
		if (command.equalsIgnoreCase("theendworld")) {
			Player p = (Player)cs;
			Location spawn3 = new Location (Bukkit.getWorld("world_the_end"), 2.500, 62, 2.500, (float)0.0, (float)0.0);
			p.teleport(spawn3);
		}

		return true;
	}
}

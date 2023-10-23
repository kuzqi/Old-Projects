package me.o16.Commands;

import java.util.Objects;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.o16.Main;
import net.md_5.bungee.api.ChatColor;

public class SpawnCommand implements CommandExecutor {

	private final Main main;
	public SpawnCommand(Main main) {
		this.main = main;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String command, String[] args) {
		
		if (command.equalsIgnoreCase("spawn")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(main.getConfig().getString("messages.spawn-teleport"))));
				Location spawnloc = new Location (Bukkit.getWorld("lobby"), 282.533, 24, -810.532, (float)180.7, (float)-0.4);
				p.teleport(spawnloc);
				
			}	
		}

		return true;
	}

}

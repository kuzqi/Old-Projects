package Lobby.Commands;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Lobby.Main;

public class SubCommands implements CommandExecutor {

	private final Main main;
	public SubCommands(Main main) {
		this.main = main;
	}
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String command, String[] args) {
		
		if (command.equalsIgnoreCase("discord")) {
			((Player) cs).playSound(((Player) cs).getLocation(), Sound.NOTE_PIANO, 1F, 1F);
			cs.sendMessage(main.getConfig().getString("messages.discord-link").replaceAll("&", "§"));
		} 
		
		if (command.equalsIgnoreCase("website")) {
			((Player) cs).playSound(((Player) cs).getLocation(), Sound.NOTE_PIANO, 1F, 1F);
			cs.sendMessage(main.getConfig().getString("messages.website-link").replaceAll("&", "§"));
		}
		
		if (command.equalsIgnoreCase("online")) {
			((Player) cs).playSound(((Player) cs).getLocation(), Sound.NOTE_PIANO, 1F, 1F);
			cs.sendMessage("§8┃ §3✪ §8┃§r §aThere are a §f"+ main.getServer().getOnlinePlayers().size() +" §aonline players.");
		}
		
		return true;
	}

}

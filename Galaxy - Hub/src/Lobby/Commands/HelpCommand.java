package Lobby.Commands;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Lobby.Main;

public class HelpCommand implements CommandExecutor {

	private final Main main;
	public HelpCommand(Main main) {
		this.main = main;
	}
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String command, String[] args) {
		
		if (command.equalsIgnoreCase("help")) {
			if (cs instanceof Player) {
				if (args.length == 0) {
					
					((Player) cs).playSound(((Player) cs).getLocation(), Sound.NOTE_PIANO, 1F, 1F);
					cs.sendMessage("§8§m---------------§8(§r §a§lYaki§f§lCraft§r §8)§8§m---------------");
					cs.sendMessage("§8» §a/discord §8| §7To join to our discord server.");
					cs.sendMessage("§8» §a/website §8| §7To visit YakiCraft is website.");
					cs.sendMessage("§8» §a/online §8| §7To show online players in the server.");
					cs.sendMessage("§8» §a/msg §8| §7To send private messages to any player.");
					cs.sendMessage("§8§m------------------------------------------");
					
					
				}else {
					cs.sendMessage(main.getConfig().getString("messages.only-players").replaceAll("&", "§"));
				}
				
			}else {
				cs.sendMessage(main.getConfig().getString("messages.invaild-usage").replaceAll("&", "§"));
			}
		}
		
		return true;
	}

}

package PvP.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PrestigeCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String command, String[] args) {
		
		if (command.equalsIgnoreCase("ps") || command.equalsIgnoreCase("prestige")) {
			if (sender instanceof Player) {
				if (args.length == 0) {
					sender.sendMessage("§8┃ §b§lPVP §8┃§r §8§m=======================");
					sender.sendMessage("§8┃ §b§lPVP §8┃§r ");
					sender.sendMessage("§8┃ §b§lPVP §8┃§r §eBronze §8» §b500☢ §8- §b1000☢");
					sender.sendMessage("§8┃ §b§lPVP §8┃§r §7Sliver §8» §b1000☢ §8- §b1500☢");
					sender.sendMessage("§8┃ §b§lPVP §8┃§r §6Gold §8» §b1500☢ §8- §b2000☢");
					sender.sendMessage("§8┃ §b§lPVP §8┃§r §bDiamond §8» §b2000☢ §8- §b3500☢");
					sender.sendMessage("§8┃ §b§lPVP §8┃§r §3Platinum §8» §b3500☢ §8- §b4000☢");
					sender.sendMessage("§8┃ §b§lPVP §8┃§r §4Champion §8» §b4000☢ §8- §b6000☢");
					sender.sendMessage("§8┃ §b§lPVP §8┃§r §5Legendary §8» §b6000☢ §8- §b10000☢");
					sender.sendMessage("§8┃ §b§lPVP §8┃§r ");
					sender.sendMessage("§8┃ §b§lPVP §8┃§r §8§m=======================");
				}
				
			}
		}
		
		return true;
	}
	

}

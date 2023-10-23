package Systems.StaffCommands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import PvP.Main;

public class InvseeCommand implements CommandExecutor {

	private final Main main;
	public InvseeCommand(Main main) {
		this.main = main;
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
	if (label.equalsIgnoreCase("invsee")) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (!p.hasPermission("staff.invsee")) {
				p.sendMessage(main.getConfig().getString("messages.no-permission").replaceAll("&", "§"));
			
		}else {
			if (args.length == 1) {
				if (!(args[0].equals(p.getName()))) {
					if (main.getServer().getOnlinePlayers().contains(main.getServer().getPlayer(args[0]))) {
						p.openInventory((Inventory) main.getServer().getPlayer(args[0]).getInventory());
						
			}else {
				p.sendMessage(main.getConfig().getString("messages.unknown-player").replaceAll("&", "§"));
			}

			}else {
				p.sendMessage(main.getConfig().getString("messages.invaild-usage").replaceAll("&", "§"));
			}
				
			}else {
				p.sendMessage(main.getConfig().getString("messages.invaild-usage").replaceAll("&", "§"));
			}
	}
			}else {
				sender.sendMessage(main.getConfig().getString("messages.only-players").replaceAll("&", "§"));
			}
		
	}
	return true;
	}
}

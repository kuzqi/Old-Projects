package PvP.Commands.StatsCommands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import PvP.Main;

public class KillsCommand implements CommandExecutor{

	private final Main main;
	public KillsCommand(Main main) {
		this.main = main;
	}
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String command, String[] args) {
		
		if (command.equalsIgnoreCase("addkills")) {
			if (cs instanceof Player) {
				Player p = (Player) cs;
				
				if (p.hasPermission("pvp.addkills")) {
					if (args.length == 2) {
						
						Player target = p.getServer().getPlayer(args[0]); 
						if (target != null) {
							
							int amount = Integer.parseInt(args[1]);
							int oldkills = main.playerStats.get(target.getUniqueId()).getKills();
							main.playerStats.get(target.getUniqueId()).setKills(oldkills + amount);
							main.mysql.saveStats(p.getUniqueId());
							
							try {
							} catch (NumberFormatException e) {
								p.sendMessage("§4Error: §cInvalid number provided for kills.");
							}
							
						} else {
							p.sendMessage("§4Error: §cPlayer not found.");
						}
						
					} else {
						p.sendMessage("§cUsage: §7/addkills <player> <amount>");
					}
					
				} else {
					p.sendMessage(main.getConfig().getString("no-permission").replaceAll("&", "§"));
				}
				
			} else {
				cs.sendMessage("§4This command can only be executed by a player.");
			}
		}
		return true;
	}


}

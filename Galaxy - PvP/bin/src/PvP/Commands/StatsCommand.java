package PvP.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import PvP.Main;
import PvP.MySQL.PlayerStats;

public class StatsCommand implements CommandExecutor {

	private final Main main;
	public StatsCommand(Main main) {
		this.main = main;
	}
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String command, String[] args) {
		
		if (command.equalsIgnoreCase("stats")) {
			if (cs instanceof Player) {
				if (args.length == 0) {
					Player p = (Player)cs;
					PlayerStats playerstats = main.playerStats.get(p.getUniqueId());
						
					cs.sendMessage("§7Kills §8➟ §a"+String.valueOf(playerstats.getKills()));
					cs.sendMessage("§7Deaths §8➟ §a"+String.valueOf(playerstats.getDeaths()));
					cs.sendMessage("§7Coins §8➟ §a"+String.valueOf(playerstats.getCoins()));
					cs.sendMessage("§7Points §8➟ §a"+String.valueOf(playerstats.getPoints()));
					cs.sendMessage("§7Prestige §8➟ §a"+String.valueOf(playerstats.getPrestige()));
					cs.sendMessage("§r");
						
				}else {
				if (args.length == 1) {
					Player target = cs.getServer().getPlayer(args[0]); 
					if (main.getServer().getOnlinePlayers().contains(target)) {
						PlayerStats targetstats = main.playerStats.get(target.getUniqueId());
						if (target != null) {
							cs.sendMessage("§r");
							cs.sendMessage("§a"+ target.getName()+ "'s Stats");
							cs.sendMessage("§7Kills §8➟ §a"+String.valueOf(targetstats.getKills()));
							cs.sendMessage("§7Deaths §8➟ §a"+String.valueOf(targetstats.getDeaths()));
							cs.sendMessage("§7Coins §8➟ §a"+String.valueOf(targetstats.getCoins()));
							cs.sendMessage("§7Points §8➟ §a"+String.valueOf(targetstats.getPoints()));
							cs.sendMessage("§7Prestige §8➟ §a"+String.valueOf(targetstats.getPrestige()));
							cs.sendMessage("§r");
					}
					}
					
				}else {
					if (args.length == 1 && args.length == 0) {
						cs.sendMessage("§8┃ §3✪ §8┃§r §cUsage: /stats <username>");
					}
				}
			}
					
		}
	}
		
		return true;
	}
}

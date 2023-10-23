package dev.o16.stats.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev.o16.stats.DataBase.PlayerStats;
import me.redpvp.Main.Main;

public class StatsCommand implements CommandExecutor {

	  public Main main;
	  public StatsCommand(Main main) {
	    this.main = main;
	  }
	  
	public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args) {
		  if (cmd.equalsIgnoreCase("stats")) {  
				  Player target = (Player) sender;
				  PlayerStats targetstats = main.playerStats.get(target.getUniqueId());
				  
				  sender.sendMessage("");
				  sender.sendMessage("§8§l• §fName §8§l➟ §f"+target.getName());
				  sender.sendMessage("§8§l• §fKills §8§l➟ §2"+String.valueOf(targetstats.getKills()+ " ♕"));
				  sender.sendMessage("§8§l• §fDeaths §8§l➟ §4"+String.valueOf(targetstats.getDeaths()+ " ☣"));
				  sender.sendMessage("§8§l• §fStars §8§l➟ §b"+String.valueOf(targetstats.getstars()+ " ✩"));
				  sender.sendMessage("§8§l• §fStreaks §8§l➟ §6"+main.streaks.get(target.getUniqueId())+" ☢");
				  sender.sendMessage("§8§l• §fPrestige §8§l➟ "+String.valueOf(targetstats.getPrestige()));
				  sender.sendMessage("");

		  }
		  
		return true;
	  }
}

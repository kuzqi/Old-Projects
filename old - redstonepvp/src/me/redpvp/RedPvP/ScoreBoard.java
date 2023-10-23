package me.redpvp.RedPvP;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import me.redpvp.Main.Main;

public class ScoreBoard implements Listener {
	
	public static Main main;
	public ScoreBoard(Main m) {
		main = m;
	}
	  
  	public static void Scoreboard(Player p) {
	    ScoreboardManager manager = main.getServer().getScoreboardManager();
	    Scoreboard board = manager.getNewScoreboard();
	    Objective o = board.registerNewObjective("redpvp", "redpvp");
	    o.setDisplaySlot(DisplaySlot.SIDEBAR);

	    o.setDisplayName("§4§lRedStonePvP");
	    
	    o.getScore("§1").setScore(10);
	    
	    o.getScore("§4§l• You").setScore(9);
	    o.getScore(" §4§l▸ §fName §f"+p.getName()).setScore(8);
	    o.getScore(" §4§l▸ §fStars §b"+main.playerStats.get(p.getUniqueId()).getstars()+ " ✩").setScore(7);
	    
	    o.getScore("§2").setScore(6);
	    
	    o.getScore("§4§l• Other").setScore(5);
	    o.getScore(" §4§l▸ §fKills §2"+main.playerStats.get(p.getUniqueId()).getKills()+ " ♕").setScore(4);
	    o.getScore(" §4§l▸ §fDeaths §4"+main.playerStats.get(p.getUniqueId()).getDeaths()+ " ☣").setScore(3);
	    o.getScore(" §4§l▸ §fStreaks §6"+main.streaks.get(p.getUniqueId())+ " ☢").setScore(3);
	    
	    o.getScore("§3").setScore(1);
	    
	    o.getScore("§4SpiritsMC.com").setScore(0);
	    p.setScoreboard(board);
	  }
}


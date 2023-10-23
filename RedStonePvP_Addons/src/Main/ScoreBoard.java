package Main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.ScoreboardManager;

import me.clip.placeholderapi.PlaceholderAPI;

public class ScoreBoard implements Listener {

  	public static void Scoreboard(Player p) {
	    ScoreboardManager manager = Bukkit.getScoreboardManager();
	    org.bukkit.scoreboard.Scoreboard board = manager.getNewScoreboard();
	    Objective o = board.registerNewObjective("zeromb", "dumy");
	    o.setDisplaySlot(DisplaySlot.SIDEBAR);
        String Prestige = "%pvpstats_level%";  Prestige = PlaceholderAPI.setPlaceholders(p, Prestige);
        String KDR = "§7K/D: §f%pvpstats_kdr%";  KDR = PlaceholderAPI.setPlaceholders(p, KDR);
        String Kills = "§7Kills: §f%pvpstats_kills%"; Kills = PlaceholderAPI.setPlaceholders(p, Kills);
        String Deaths = "§7Deaths: §f%pvpstats_deaths%"; Deaths = PlaceholderAPI.setPlaceholders(p, Deaths);
        String Coins = "§4✪ Coins: §f%vault_eco_balance%";  Coins = PlaceholderAPI.setPlaceholders(p, Coins);
        
	    o.setDisplayName("§4§lRedStone§c§lPvP");
	    o.getScore("§0").setScore(11);
	    o.getScore("§d§lPrestige").setScore(10);
	    o.getScore(Prestige).setScore(9);
	    o.getScore("§1").setScore(8);
	    o.getScore("§b§lStats").setScore(7);
	    o.getScore(Kills).setScore(6);
	    o.getScore(Deaths).setScore(5);
	    o.getScore(KDR).setScore(4);	
	    o.getScore(Coins).setScore(3);	
	    o.getScore("§2").setScore(2);
	    o.getScore("§8§m------------§5  §6").setScore(1);
	    o.getScore("§bSpirits§3MC§b.Com").setScore(0);
	    p.setScoreboard(board);
	  }
}
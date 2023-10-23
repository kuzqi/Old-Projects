package PvP.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import PvP.Main;

public class ScoreBoardListener implements Listener {

	private final Main main = new Main();
	
	public void Scoreboard(Player p) {
	    ScoreboardManager sm = main.getServer().getScoreboardManager();
	    Scoreboard sb = sm.getNewScoreboard();
	    Objective o = sm.getNewScoreboard().registerNewObjective("zeromb", "dumy");
	    
	    o.setDisplaySlot(DisplaySlot.SIDEBAR);
	    o.setDisplayName("§a§lPVP");
	    o.getScore("§0").setScore(3);
	    o.getScore("§a§lSTATISTICS").setScore(2);
	    o.getScore("§2").setScore(1);
	    o.getScore("§7play.yaki-craft.com").setScore(0);
	    p.setScoreboard(sb);
	    
	  }
	
	
	public void onPlayerDeath(PlayerDeathEvent e) {
		if (e.getEntity() instanceof Player) {
			if (e.getEntity().getKiller() instanceof Player) {
				Scoreboard(e.getEntity());
				Scoreboard(e.getEntity().getKiller());
			}
		}
	}
	
	public void onPlayerJoin(PlayerJoinEvent e, Player p) {
		Scoreboard(p);
	}
}

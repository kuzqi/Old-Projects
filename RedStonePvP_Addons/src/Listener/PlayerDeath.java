package Listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.scheduler.BukkitRunnable;

import Main.Main;
import Main.ScoreBoard;

public class PlayerDeath implements Listener {
	Main plugin;
	
	  @EventHandler
	  public void onDeath(PlayerDeathEvent e) { 
		  try {
	    String prefix = "§4§l §r";
	    Player k = e.getEntity().getKiller();
	    Player d = e.getEntity();
		k.sendMessage(prefix+" §a§l✚ §7You §a§learned §55✪ Points §7for killing §a" +d.getName());
		d.sendMessage(prefix+" §4§l✗ §7You §c§lLost §52✪ Points §7for killing by §c" +k.getName());
		k.setHealth(k.getHealth()+5);
	    new BukkitRunnable() {
			@Override
			public void run() {
	  	   		ScoreBoard.Scoreboard(k);
	  	   		k.setFireTicks(0);
			}}.runTaskLater(Main.getInstance(), 2);
			
	    }catch (Exception uwu) {
		}
	  }
}

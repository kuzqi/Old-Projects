package dev.o16.stats.Managers;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import dev.o16.stats.DataBase.PlayerStats;
import me.redpvp.Main.Main;

public class KillsManager implements Listener {

	public Main main;
	public KillsManager(Main main) {
		this.main = main;
	}
	
	  @EventHandler
	  public void onDeath(PlayerDeathEvent e) {
		PlayerStats killerstats = main.playerStats.get(e.getEntity().getKiller().getUniqueId());
		PlayerStats dead = main.playerStats.get(e.getEntity().getUniqueId());
		
	    if (e.getEntity().getKiller() instanceof Player) {
	    	if (e.getEntity() instanceof Player) {
	    		
	    		killerstats.setKills(killerstats.getKills()+1);
	    		killerstats.setstars(killerstats.getstars()+10);
	    		dead.setDeaths(dead.getDeaths()+1);
	    		dead.setstars(dead.getstars()-5);
	    		dead.getKills();
	    }
	  }
	  }
	  
}

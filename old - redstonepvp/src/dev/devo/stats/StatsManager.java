package dev.devo.stats;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import me.redpvp.Main.Main;

public class StatsManager implements Listener {

	public Main main;
	public StatsManager(Main main) {
		this.main = main;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		if (!(main.database.hasStats(e.getPlayer().getUniqueId()))) {
			main.database.createPlayerStats(e.getPlayer().getUniqueId());
		}
			main.playerStats.put(e.getPlayer().getUniqueId(), main.database.getPlayerStats(e.getPlayer().getUniqueId()));
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		main.database.saveStats(e.getPlayer().getUniqueId());
		main.playerStats.remove(e.getPlayer().getUniqueId());
	}
	
}

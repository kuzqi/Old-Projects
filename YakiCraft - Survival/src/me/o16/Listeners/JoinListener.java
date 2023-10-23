package me.o16.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

import me.o16.Main;

public class JoinListener implements Listener {

	private final Main main;
	public JoinListener(Main main) {
		this.main = main;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		e.setJoinMessage("");
		if (!(e.getPlayer().hasPlayedBefore())) {
			
			new BukkitRunnable() { public void run() {
				Location spawnloc = new Location (Bukkit.getWorld("lobby"), 282.533, 24, -810.532, (float)180.7, (float)-0.4);
				e.getPlayer().teleport(spawnloc);
			}}.runTaskLater(main, 60);
		}
	}
}
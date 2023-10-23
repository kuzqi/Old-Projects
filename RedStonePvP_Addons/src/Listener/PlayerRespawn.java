package Listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.scheduler.BukkitRunnable;

import Main.Main;
import Main.ScoreBoard;

public class PlayerRespawn implements Listener {
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerRespawn(PlayerRespawnEvent e) {
		Player p = e.getPlayer();
		p.sendTitle("§c§lYOU DIED", "§7");
		new BukkitRunnable() {
			@Override
			public void run() {
				ScoreBoard.Scoreboard(p);
        }}.runTaskLater(Main.getInstance(), 1);
    
		new BukkitRunnable() {
			@Override
			public void run() {
				p.sendTitle("§7", "§7");
        }}.runTaskLater(Main.getInstance(), 50);
	}
}
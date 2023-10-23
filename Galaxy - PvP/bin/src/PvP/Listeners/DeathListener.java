package PvP.Listeners;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathListener implements Listener {

	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e) {

		if (e.getEntity() instanceof Player) {
			if (e.getEntity().getKiller() instanceof Player) {
				
				Player d = e.getEntity();
				Player k = e.getEntity().getKiller();

				d.sendMessage("§8┃ §3✪ §8┃§r §c§l✗ §7You §clost §64 Points §7for killing by §c"+ d.getDisplayName());
				k.sendMessage("§8┃ §3✪ §8┃§r §a§l✚ §7You §aearned §612 Points §7for killing §a"+ k.getDisplayName());

				k.setFireTicks(0);
				d.setFireTicks(0);
				d.setHealth(20F);
				k.setHealth(20F);
				
				Location spawnloc = new Location (d.getWorld(), 0.500, 65, 0.500, (float)-0.6, (float)0.9);
				d.teleport(spawnloc);
			}
		}
	}
}

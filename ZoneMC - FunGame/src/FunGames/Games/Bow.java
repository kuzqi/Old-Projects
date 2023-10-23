package FunGames.Games;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class Bow implements Listener {
	
	@EventHandler
	public void onBowHit(ProjectileHitEvent e) {
		Player p = (Player) e.getEntity().getShooter();
		Location ploc = e.getEntity().getLocation();
		
		if (e.getEntity().getType() == EntityType.ARROW) {
			e.getEntity().remove();
			ploc.setYaw(p.getLocation().getYaw());
			ploc.setPitch(p.getLocation().getPitch());
			p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.1F, 1.1F);
			p.teleport(ploc);
		}
	}
	
}

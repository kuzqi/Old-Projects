package me.devo;

import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FishHook;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;

public class Rod implements Listener {

	private final Main main;
	public Rod(Main main) {
		this.main = main;
	}
	  
	@EventHandler
	public void onProjectileLaunch(ProjectileLaunchEvent e) {
		if (e.getEntityType().equals(EntityType.FISHING_HOOK)) {
			e.getEntity().setVelocity(e.getEntity().getVelocity().multiply(main.getConfig().getInt("FastRod.speed")));
		}
	}
	
	@EventHandler
	public void onRodHit(EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof FishHook) {
			if (e.getEntity() instanceof Player) {
				if (main.getConfig().getBoolean("FastRod.sound", true)) {
					e.getEntity().getWorld().playSound(e.getEntity().getLocation(), Sound.SUCCESSFUL_HIT, 1.0F, 1.5F);
				}
			}
		}
	}
}

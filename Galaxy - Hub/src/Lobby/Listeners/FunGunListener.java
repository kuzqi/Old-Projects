package Lobby.Listeners;

import java.util.ArrayList;

import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;

import com.google.common.collect.Lists;

import Lobby.Main;

public class FunGunListener implements Listener {

	private final Main main;
	public FunGunListener(Main main) {
		this.main = main;
	}
	
	private ArrayList<String> cooldown = Lists.newArrayList();
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		if (e.getAction() == Action.RIGHT_CLICK_AIR) {
			if (e.getPlayer().getGameMode() == GameMode.ADVENTURE) {
				if (e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§aFunGun §7(Right-Click)")) {
					if (e.getPlayer().getItemInHand().getType().equals(Material.BLAZE_ROD)) {
						if (!(cooldown.contains(e.getPlayer().getDisplayName()))) {
						
						e.getPlayer().launchProjectile(Snowball.class);
		 				e.getPlayer().launchProjectile(Snowball.class);
		 				e.getPlayer().launchProjectile(Snowball.class);
		 				
		 				cooldown.add(e.getPlayer().getDisplayName());
		 				
		 				new BukkitRunnable() { public void run() {
		 					
		 					if (cooldown.contains(e.getPlayer().getName())) {
		 						cooldown.remove(e.getPlayer().getName());
		 					}
		 					
		 				}}.runTaskLater(main, 60);
		 				
					}else {
					e.getPlayer().sendMessage(main.getConfig().getString("messages.cooldown").replaceAll("&", "§"));
					}
				}
			}
			}
		}
	}
	
	
	 @EventHandler
	 public void onPlayerQuit(PlayerQuitEvent e) {
		 cooldown.remove(e.getPlayer().getDisplayName());
	 }
	 
	 
	 @EventHandler
	 public void onProjectileHit(ProjectileHitEvent e) {
		 if (e.getEntity() instanceof Snowball) {
			 Snowball s = (Snowball) e.getEntity();
			 
			 for (int x = 0; x < 6; ++x) {
				s.getWorld().playEffect(s.getLocation(), Effect.LAVA_POP, 10);
				s.getWorld().playEffect(s.getLocation(), Effect.LAVA_POP, 10);
				s.getWorld().playEffect(s.getLocation(), Effect.LAVA_POP, 10);
			 }
			 
			 s.getWorld().playSound(s.getLocation(), Sound.CAT_MEOW, 1.1F, 1.1F);
			 s.getWorld().playEffect(s.getLocation(), Effect.HEART, 10);

			}
		}
}
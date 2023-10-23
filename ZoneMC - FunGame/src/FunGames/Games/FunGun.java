package FunGames.Games;

import java.util.ArrayList;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;

import com.google.common.collect.Lists;

import FunGames.Main;
import FunGames.Utils.ActionBar;

public class FunGun implements Listener {

	private final Main main;
	public FunGun(Main main) {
		this.main = main;
	}
	
	private ArrayList<String> cooldown = Lists.newArrayList();
	
	 @EventHandler
	 public void onPlayerInteract(PlayerInteractEvent e) {
	 Player p = e.getPlayer();
	 
	 if (e.getAction() == Action.RIGHT_CLICK_AIR) {
	 	if(e.getItem().getType() == Material.BONE) {
	 		if (e.getItem().getItemMeta().getDisplayName().equals("§eFunGun")) {
	 			if (!(cooldown.contains(p.getName()))) {
	 				
	 				e.getPlayer().launchProjectile(Snowball.class);
	 				e.getPlayer().launchProjectile(Snowball.class);
	 				e.getPlayer().launchProjectile(Snowball.class);
	 			
	 				cooldown.add(p.getName());
	 			
	 				new BukkitRunnable() {
	 					public void run() {
	 						
	 						if (cooldown.contains(p.getName())) {
	 							cooldown.remove(p.getName());
	 						}
	 						
	 					}
	 				}.runTaskLater(main, 65);
	 				
	 			}else {
	 				ActionBar.send(p, "§cSIR PLEASE WAIT A FEW SECONDS");
	 			}
	 		}
	 	}
	 }
	}

	 @EventHandler
	 public void onProjectileHitEvent(ProjectileHitEvent e) {
		 if (e.getEntity() instanceof Snowball) {
			 Snowball s = (Snowball) e.getEntity();
			 
			 for (int x = 0; x < 6; ++x) {
				e.getEntity().getWorld().playEffect(e.getEntity().getLocation(), Effect.LAVA_POP, 10);
				e.getEntity().getWorld().playEffect(e.getEntity().getLocation(), Effect.LAVA_POP, 10);
				e.getEntity().getWorld().playEffect(e.getEntity().getLocation(), Effect.LAVA_POP, 10);
				e.getEntity().getWorld().playEffect(e.getEntity().getLocation(), Effect.LAVA_POP, 10);
				e.getEntity().getWorld().playEffect(e.getEntity().getLocation(), Effect.LAVA_POP, 10);
			}
			 
			 e.getEntity().getWorld().playEffect(e.getEntity().getLocation(), Effect.HEART, 10);
			 s.getWorld().playSound(s.getLocation(), Sound.CAT_MEOW,1F,1F);

			}
		}
	 
	 
}

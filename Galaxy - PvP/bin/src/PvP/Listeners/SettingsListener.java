package PvP.Listeners;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.weather.ThunderChangeEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class SettingsListener implements Listener {
	
	@EventHandler public void onItem0(PlayerPickupItemEvent e) {e.setCancelled(true);}
	
	@EventHandler public void onItem1(PlayerDropItemEvent e) {e.setCancelled(true);}
	
	@EventHandler public void onMisc1(WeatherChangeEvent e) {e.setCancelled(true);}
	
	@EventHandler public void onMisc2(FoodLevelChangeEvent e) {e.setCancelled(true);}
	
	@EventHandler public void onMisc3(ThunderChangeEvent e) {e.setCancelled(true);}
	
	
    @EventHandler(priority = EventPriority.HIGH)
    public void onFallDamage(EntityDamageEvent e) {
    	if (e.getCause() == DamageCause.FALL) {
    		e.setCancelled(true);
    	}
    }
    
    @EventHandler
    public void onProjectileHit(ProjectileHitEvent e) {
    	if (e.getEntity().getType() == EntityType.ARROW ) {
    		e.getEntity().remove();
    	}
    }
	
    
    @EventHandler(ignoreCancelled = true)
    public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
        if (e.getEntityType() == EntityType.PLAYER
        	&& e.getDamager() != null
            && e.getDamager().getType() == EntityType.ARROW
            && ((Arrow) e.getDamager()).getShooter() == e.getEntity()) {
        	e.setCancelled(true);
        }
      }
}

package Listener;

import org.bukkit.entity.ItemFrame;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class PlayerSettings implements Listener {

	  @EventHandler
	  public void onHungerMeterChange(FoodLevelChangeEvent e) {
	    e.setCancelled(true);
	  }
	  
	  @EventHandler
	  public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
	      if (e.getEntity() instanceof ItemFrame) {
	    	  e.setCancelled(true);
	      }
	  }
}

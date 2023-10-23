package FunGames.Listeners;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

public class FunGameListener implements Listener {

	 @EventHandler
	 public void onFunGamesDrop(PlayerDropItemEvent e) {
		 
		 if (
				   e.getItemDrop().getItemStack().getItemMeta().getDisplayName().equals("§eFunGun")
			    || e.getItemDrop().getItemStack().getItemMeta().getDisplayName().equals("§2Pearl Teleporter") 
			    || e.getItemDrop().getItemStack().getItemMeta().getDisplayName().equals("§cBow Teleporter") 
			    || e.getItemDrop().getItemStack().getItemMeta().getDisplayName().equals("§5FunGames")
			    || e.getItemDrop().getItemStack().getItemMeta().getDisplayName().equals("§dRod")
				|| e.getItemDrop().getItemStack().getItemMeta().getDisplayName().equals("§bSuperStar")
			
			 ) {
			 e.setCancelled(true);
			 }
	 }
	 
	
	@EventHandler
	public void FunGunClick(InventoryClickEvent e) {
		try {
			
		if (
				
			   e.getCurrentItem().getItemMeta().getDisplayName().equals("§eFunGun")
		    || e.getCurrentItem().getItemMeta().getDisplayName().equals("§2Pearl Teleporter") 
		    || e.getCurrentItem().getItemMeta().getDisplayName().equals("§cBow Teleporter") 
		    || e.getCurrentItem().getItemMeta().getDisplayName().equals("§5FunGames")
		    || e.getCurrentItem().getItemMeta().getDisplayName().equals("§dRod")
			|| e.getCurrentItem().getItemMeta().getDisplayName().equals("§bSuperStar")
			
			) {
			
			e.setCancelled(true);
		}
		
		}catch (Exception w) {
		}
	}
	
	
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e) {
		if (e.getDamager().getType().equals(EntityType.ENDER_PEARL)) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onFunGunDamage(EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Snowball) {
			e.setCancelled(true);
		}
	}
}
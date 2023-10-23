package FunGames.Games;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import FunGames.Main;
import FunGames.Utils.ItemBuilder;

public class SuperStar implements Listener {

	private final Main main;
	public SuperStar(Main main) {
		this.main = main;
	}
	
	@EventHandler
	public void onSuperStarUse(PlayerInteractEvent e) {
			if (e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equals(String.valueOf(main.getConfig().getString("Superstar.name")))) {
				if (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_AIR) {
					
				ItemStack reloading = new ItemBuilder(Material.FIREWORK_CHARGE,1,0).setDisplayname("§7Reloading...").build();
				ItemStack superstar = new ItemBuilder(Material.NETHER_STAR,1,0).setDisplayname(main.getConfig().getString("Superstar.name").replaceAll("&", "§")).build();
				
				e.getPlayer().setVelocity(e.getPlayer().getLocation().toVector().subtract(e.getPlayer().getLocation().toVector()).normalize().multiply(main.getConfig().getInt("Superstar.velocity")));
				e.getPlayer().getInventory().setItem(main.getConfig().getInt("Superstar.slot"), reloading);
				
	 	    	new BukkitRunnable() {
	 	    		@Override
	 	    			public void run() {
	 	    				if (e.getPlayer().getInventory().contains(reloading)) {
	 	    					e.getPlayer().getInventory().setItem(main.getConfig().getInt("Superstar.slot"), superstar);
	 	    				}
	 	    				}
	 	    			}.runTaskLater(main, main.getConfig().getInt("Superstar.cooldown"));
	 	    			
			}
		}
			
	}
}

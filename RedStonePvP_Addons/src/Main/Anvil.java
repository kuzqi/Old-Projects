package Main;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class Anvil implements Listener {

	@EventHandler
	public void onAnvilClick(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		Block b = e.getClickedBlock();
	    String prefix = "§4§lRedStone§c§lPvP §8» §r";
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (b.getType().equals(Material.ANVIL)) {
				e.setCancelled(true);
				
		        ItemStack item = p.getInventory().getItemInHand();
		        if (item.getType() == Material.AIR || item.getType() == null || item.getType() == Material.DIAMOND_AXE) {
		        	p.sendMessage(prefix+"§cThis item isn't allowed to repair.");
		        	
		        	}else {
		        		 if (p.getInventory().contains(new ItemStack(Material.REDSTONE, 16))) {
							 p.getInventory().remove(new ItemStack (Material.REDSTONE, 16));
							 p.playSound(p.getLocation(), Sound.ANVIL_USE, 0.9F, 0.8F);
							 p.getInventory().getItemInHand().setDurability((short)0);
		        		 }else {
		        			 p.sendMessage(prefix+"§cYou don't have enough §4REDSTONE§c.");
		        		 }
		        	}
			}
		}
	}
}
package Main;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
public class Miner implements Listener {

  @EventHandler
  public void onBreakMiner(BlockBreakEvent e) {
    if (e.getBlock().getType().equals(Material.REDSTONE_ORE) || e.getBlock().getType().equals(Material.GLOWING_REDSTONE_ORE)) {
    	Player p = e.getPlayer();
    	ItemStack Items = new ItemStack(Material.REDSTONE, 3);
    	p.getInventory().addItem(Items);
        e.getBlock().setType(Material.AIR);
	     new BukkitRunnable() {
	         @Override
	         public void run() {
	        	 e.getBlock().setType(Material.REDSTONE_ORE);
	         }}.runTaskLater(Main.getInstance(), 500);
    }
  }
}

package me.redpvp.RedPvP;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class Anvil implements Listener {

	@EventHandler
	public void onAnvilClick(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		Block b = e.getClickedBlock();
		PlayerInventory pi = p.getInventory();
		ItemStack PlayerItem = p.getInventory().getItemInHand();
		
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
		if (b.getType().equals(Material.ANVIL)) {
			e.setCancelled(true);
			
		if (PlayerItem.getType() == Material.AIR || PlayerItem.getType() == null || PlayerItem.getType() == Material.DIAMOND_AXE || PlayerItem.getType() == Material.ARROW || PlayerItem.getType() == Material.GOLDEN_APPLE) {
			p.sendMessage("§4§l(!) §cThis item isn't allowed to repair.");
		}else {
			if (pi.contains(Material.REDSTONE,16)) {
				pi.remove(new ItemStack(Material.REDSTONE,16));
				p.playSound(b.getLocation(),Sound.ANVIL_USE,0.7F,0.7F);
				PlayerItem.setDurability((short)0);
		    }else {
		    	p.sendMessage("§4§l(!) §cYou don't have enough §8[§4REDSTONE§8]");}
				}
			}
		}
	}
}
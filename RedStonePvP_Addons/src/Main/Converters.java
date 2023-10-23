package Main;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class Converters implements Listener {

    @EventHandler
    public void on1Click(PlayerInteractEvent e) {
      Player p = e.getPlayer();
      Block b = e.getClickedBlock();
      String prefix = "§4§lRedStone§c§lPvP §8» §r";
      //-----------------------------------------------------
      if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
        if (b.getType().equals(Material.EMERALD_BLOCK)) {
          if (p.getInventory().contains(Material.GOLD_INGOT, 16)) {
            p.getInventory().removeItem(new ItemStack (Material.GOLD_INGOT, 16));
            p.getInventory().addItem(new ItemStack (Material.EMERALD, 1));
          }else{
        	  p.sendMessage(prefix+"§c§lYou need 16 §6GOLD_INGOT §c§lto use this.");
           }
        } 
      } 
      //-----------------------------------------------------
        if (e.getAction() == Action.LEFT_CLICK_BLOCK) {
            if (b.getType().equals(Material.EMERALD_BLOCK)) {
              if (p.getInventory().contains(Material.EMERALD, 1)) {
            	  p.getInventory().removeItem(new ItemStack(Material.EMERALD, 1));
            	  p.getInventory().addItem(new ItemStack(Material.GOLD_INGOT, 16));
                
              }else{
            	  p.sendMessage(prefix+"§c§lYou need 1 §2EMERALD §c§lto use this.");
               }
            } 
          }
        //-----------------------------------------------------
      if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
        if (b.getType().equals(Material.REDSTONE_BLOCK)) {
          if (p.getInventory().contains(Material.GOLD_INGOT, 1)) {
            p.getInventory().removeItem(new ItemStack (Material.GOLD_INGOT, 1));
            p.getInventory().addItem(new ItemStack (Material.REDSTONE, 64));
            
          }else{
        	  p.sendMessage(prefix+"§c§lYou need 1 §6GOLD_INGOT §c§lto use this.");
           }
        } 
      } 
      //-----------------------------------------------------
      if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
        if (b.getType().equals(Material.GOLD_BLOCK)) {
          if (p.getInventory().contains(Material.REDSTONE, 64)) {
            p.getInventory().removeItem(new ItemStack(Material.REDSTONE, 64));
            p.getInventory().addItem(new ItemStack(Material.GOLD_INGOT, 1));
            
          }else{
        	  p.sendMessage(prefix+"§c§lYou need 64 §4REDSTONE §c§lto use this.");
           }
        } 
      } 
      //-----------------------------------------------------
      if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
        if (b.getType().equals(Material.LAPIS_BLOCK)) {
          if (p.getInventory().contains(Material.REDSTONE, 1)) {
            p.getInventory().removeItem(new ItemStack(Material.REDSTONE, 1));
            p.giveExpLevels(2);
            
          }else{
        	  p.sendMessage(prefix+"§c§lYou need 1 §4REDSTONE §c§lto use this.");
          }
        }
      }
      }

}

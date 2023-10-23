package me.redpvp.RedPvP;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class Converter implements Listener {

    @EventHandler
    public void on1Click(PlayerInteractEvent e) {
      Player p = e.getPlayer();
      Block b = e.getClickedBlock();
      
      // GOLD >> EMERALD
      //-----------------------------------------------------
      if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
        if (b.getType().equals(Material.EMERALD_BLOCK)) {
          if (p.getInventory().contains(Material.GOLD_INGOT, 16)) {
            p.getInventory().removeItem(new ItemStack (Material.GOLD_INGOT, 16));
            p.getInventory().addItem(new ItemStack (Material.EMERALD, 1));
          }else{
        	  p.sendMessage("§4§l(!) §cYou don't have enough §8[§6GOLD_INGOT§8]");
           }
        } 
      } 
      
      // EMERALD >> GOLD
      //-----------------------------------------------------
        if (e.getAction() == Action.LEFT_CLICK_BLOCK) {
            if (b.getType().equals(Material.EMERALD_BLOCK)) {
              if (p.getInventory().contains(Material.EMERALD, 1)) {
            	  p.getInventory().removeItem(new ItemStack(Material.EMERALD, 1));
            	  p.getInventory().addItem(new ItemStack(Material.GOLD_INGOT, 16));
                
              }else{
            	  p.sendMessage("§4§l(!) §cYou don't have enough §8[§2EMERALD§8]");
               }
            } 
          }
        
        // GOLD >> REDSTONE
        //-----------------------------------------------------
      if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
        if (b.getType().equals(Material.REDSTONE_BLOCK)) {
          if (p.getInventory().contains(Material.GOLD_INGOT, 1)) {
            p.getInventory().removeItem(new ItemStack (Material.GOLD_INGOT, 1));
            p.getInventory().addItem(new ItemStack (Material.REDSTONE, 64));
            
          }else{
        	  p.sendMessage("§4§l(!) §cYou don't have enough §8[§6GOLD_INGOT§8]");
           }
        } 
      } 
      
      // REDSTONE >> GOLD
      //-----------------------------------------------------
      if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
        if (b.getType().equals(Material.GOLD_BLOCK)) {
          if (p.getInventory().contains(Material.REDSTONE, 64)) {
            p.getInventory().removeItem(new ItemStack(Material.REDSTONE, 64));
            p.getInventory().addItem(new ItemStack(Material.GOLD_INGOT, 1));
            
          }else{
        	  p.sendMessage("§4§l(!) §cYou don't have enough §8[§4REDSTONE§8]");
           }
        } 
      } 
      
      // REDSTONE >> XP
      //-----------------------------------------------------
      if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
        if (b.getType().equals(Material.LAPIS_BLOCK)) {
          if (p.getInventory().contains(Material.REDSTONE, 1)) {
            p.getInventory().removeItem(new ItemStack(Material.REDSTONE, 1));
            p.giveExpLevels(2);
            
          }else{
        	  p.sendMessage("§4§l(!) §cYou don't have enough §8[§4REDSTONE§8]");
          }
        }
      }
      }

}

package Shop;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import Utils.ItemBuilder;
import me.redpvp.RedPvP.ScoreBoard;

public class ShopGui implements Listener {

	@EventHandler
	public void onClickShop(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		PlayerInventory pi = e.getWhoClicked().getInventory();	
		int slot = e.getSlot();
		Inventory i = e.getInventory();
		Inventory ci = e.getClickedInventory();
		
		if (i.getName() == "§4Shop") {e.setCancelled(true);}
		if (ci.getName() == "§4Shop") {e.setCancelled(true);}

		if (slot == 0) {
			if (ci.getName() == "§4Shop") {
				if (pi.contains(Material.GOLD_INGOT,16)) {
					pi.removeItem(new ItemStack(Material.GOLD_INGOT,16));
					ItemStack Rod1 = new ItemBuilder (Material.FISHING_ROD,1,0).addEnchant(Enchantment.DURABILITY, 3).build();
					pi.addItem(Rod1);
				}else {p.sendMessage("§8▎ §r §cYou don't have enough §8[§6GOLD_INGOT§8]");}
			}
		}
		
		if (slot  == 8) {
			if (ci.getName() == "§4Shop") {
				if (pi.contains(Material.GOLD_INGOT,20)) {
					pi.removeItem(new ItemStack(Material.GOLD_INGOT,20));
					ItemStack Rod2 = new ItemBuilder (Material.FISHING_ROD,1,0).addEnchant(Enchantment.DURABILITY, 4).build();
					pi.addItem(Rod2);
				}else {p.sendMessage("§8▎ §r §cYou don't have enough §8[§6GOLD_INGOT§8]");}
			}
		}
		
		if (slot == 27) {
			if (ci.getName() == "§4Shop") {
				if (pi.contains(Material.GOLD_INGOT,8)) {
					pi.removeItem(new ItemStack(Material.GOLD_INGOT,8));
					ItemStack chestplate1 = new ItemBuilder (Material.DIAMOND_CHESTPLATE,1,0).addEnchant(Enchantment.DURABILITY,3).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,3).build();
					pi.addItem(chestplate1);
				}else {p.sendMessage("§8▎ §r §cYou don't have enough §8[§6GOLD_INGOT§8]");}
			}
		}
		
		if (slot == 28) {
			if (ci.getName() == "§4Shop") {
				if (pi.contains(Material.GOLD_INGOT,16)) {
					pi.removeItem(new ItemStack(Material.GOLD_INGOT,16));
					ItemStack chestplate2 = new ItemBuilder (Material.DIAMOND_CHESTPLATE,1,0).addEnchant(Enchantment.DURABILITY,4).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,4).build();
					pi.addItem(chestplate2);
				}else {p.sendMessage("§8▎ §r §cYou don't have enough §8[§6GOLD_INGOT§8]");}
			}
		}
		
		if (slot == 18) {
			if (ci.getName() == "§4Shop") {
				if (pi.contains(Material.GOLD_INGOT,8)) {
					pi.removeItem(new ItemStack(Material.GOLD_INGOT,8));
					ItemStack helmet1 = new ItemBuilder (Material.DIAMOND_HELMET,1,0).addEnchant(Enchantment.DURABILITY,3).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,3).build();
					pi.addItem(helmet1);
				}else {p.sendMessage("§8▎ §r §cYou don't have enough §8[§6GOLD_INGOT§8]");}
			}
		}
		
		if (slot == 19) {
			if (ci.getName() == "§4Shop") {
				if (pi.contains(Material.GOLD_INGOT,16)) {
					pi.removeItem(new ItemStack(Material.GOLD_INGOT,16));
					ItemStack helmet2 = new ItemBuilder (Material.DIAMOND_HELMET,1,0).addEnchant(Enchantment.DURABILITY,4).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,4).build();
					pi.addItem(helmet2);
				}else {p.sendMessage("§8▎ §r §cYou don't have enough §8[§6GOLD_INGOT§8]");}
			}
		}
		
		if (slot == 36) {
			if (ci.getName() == "§4Shop") {
				if (pi.contains(Material.GOLD_INGOT,8)) {
					pi.removeItem(new ItemStack(Material.GOLD_INGOT,8));
					ItemStack leggings1 = new ItemBuilder (Material.DIAMOND_LEGGINGS,1,0).addEnchant(Enchantment.DURABILITY,3).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,3).build();
			    	pi.addItem(leggings1);
				}else {p.sendMessage("§8▎ §r §cYou don't have enough §8[§6GOLD_INGOT§8]");}
			}
		}
		
		if (slot == 37) {
			if (ci.getName() == "§4Shop") {
				if (pi.contains(Material.GOLD_INGOT,16)) {
					pi.removeItem(new ItemStack(Material.GOLD_INGOT,16));
					ItemStack leggings2 = new ItemBuilder (Material.DIAMOND_LEGGINGS,1,0).addEnchant(Enchantment.DURABILITY,4).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,4).build();
			    	pi.addItem(leggings2);
				}else {p.sendMessage("§8▎ §r §cYou don't have enough §8[§6GOLD_INGOT§8]");}
			}
		}
		
		if (slot == 45) {
			if (ci.getName() == "§4Shop") {
				if (pi.contains(Material.GOLD_INGOT,8)) {
					pi.removeItem(new ItemStack(Material.GOLD_INGOT,8));
					ItemStack boot1 = new ItemBuilder (Material.DIAMOND_BOOTS,1,0).addEnchant(Enchantment.DURABILITY,3).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,3).build();
			    	pi.addItem(boot1);
				}else {p.sendMessage("§8▎ §r §cYou don't have enough §8[§6GOLD_INGOT§8]");}
			}
		}
		
		if (slot == 46) {
			if (ci.getName() == "§4Shop") {
				if (pi.contains(Material.GOLD_INGOT,16)) {
					pi.removeItem(new ItemStack(Material.GOLD_INGOT,16));
					ItemStack boot2 = new ItemBuilder (Material.DIAMOND_BOOTS,1,0).addEnchant(Enchantment.DURABILITY,4).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,4).build();
			    	pi.addItem(boot2);
				}else {p.sendMessage("§8▎ §r §cYou don't have enough §8[§6GOLD_INGOT§8]");}
			}
		}
		
		if (slot == 29) {
			if (ci.getName() == "§4Shop") {
				if (pi.contains(Material.GOLD_INGOT,4)) {
					pi.removeItem(new ItemStack(Material.GOLD_INGOT,4));
					ItemStack apple1 = new ItemBuilder (Material.GOLDEN_APPLE,2,1).setDisplayname("§dGolden Apple").build();
					pi.addItem(apple1);
				}else {p.sendMessage("§8▎ §r §cYou don't have enough §8[§6GOLD_INGOT§8]");}
			}
		}
		
		if (slot == 38) {
			if (ci.getName() == "§4Shop") {
				if (pi.contains(Material.GOLD_INGOT,8)) {
					pi.removeItem(new ItemStack(Material.GOLD_INGOT,8));
					ItemStack apple2 = new ItemBuilder (Material.GOLDEN_APPLE,4,1).setDisplayname("§dGolden Apple").build();
					pi.addItem(apple2);
				}else {p.sendMessage("§8▎ §r §cYou don't have enough §8[§6GOLD_INGOT§8]");}
			}
		}
		
		if (slot == 47) {
			if (ci.getName() == "§4Shop") {
				if (pi.contains(Material.GOLD_INGOT,12)) {
					pi.removeItem(new ItemStack(Material.GOLD_INGOT,12));
					ItemStack apple3 = new ItemBuilder (Material.GOLDEN_APPLE,6,1).setDisplayname("§dGolden Apple").build();
					pi.addItem(apple3);
				}else {p.sendMessage("§8▎ §r §cYou don't have enough §8[§6GOLD_INGOT§8]");}
			}
		}
		
		if (slot == 49) {
			if (ci.getName() == "§4Shop") {
				if (pi.contains(Material.GOLD_INGOT,4)) {
					pi.removeItem(new ItemStack(Material.GOLD_INGOT,4));
					ItemStack axe1 = new ItemBuilder (Material.DIAMOND_AXE,1,0).addEnchant(Enchantment.DAMAGE_ALL, 2).addEnchant(Enchantment.DURABILITY, 3).build();
			    	pi.addItem(axe1);
				}else {p.sendMessage("§8▎ §r §cYou don't have enough §8[§6GOLD_INGOT§8]");}
			}
		}
		
		if (slot == 50) {
			if (ci.getName() == "§4Shop") {
				if (pi.contains(Material.GOLD_INGOT,8)) {
					pi.removeItem(new ItemStack(Material.GOLD_INGOT,8));
					ItemStack axe2 = new ItemBuilder (Material.DIAMOND_AXE,1,0).addEnchant(Enchantment.DAMAGE_ALL, 3).addEnchant(Enchantment.DURABILITY, 4).build();
			    	pi.addItem(axe2);
				}else {p.sendMessage("§8▎ §r §cYou don't have enough §8[§6GOLD_INGOT§8]");}
			}
		}
		
		if (slot == 34) {
			if (ci.getName() == "§4Shop") {
				if (pi.contains(Material.GOLD_INGOT,4)) {
					pi.removeItem(new ItemStack(Material.GOLD_INGOT,4));
					ItemStack bow1 = new ItemBuilder (Material.BOW,1,0).addEnchant(Enchantment.ARROW_DAMAGE, 1).addEnchant(Enchantment.DURABILITY, 2).build();
			    	pi.addItem(bow1);
				}else {p.sendMessage("§8▎ §r §cYou don't have enough §8[§6GOLD_INGOT§8]");}
			}
		}
		
		if (slot == 43) {
			if (ci.getName() == "§4Shop") {
				if (pi.contains(Material.GOLD_INGOT,8)) {
					pi.removeItem(new ItemStack(Material.GOLD_INGOT,8));
					ItemStack bow2 = new ItemBuilder (Material.BOW,1,0).addEnchant(Enchantment.ARROW_DAMAGE, 2).addEnchant(Enchantment.DURABILITY, 3).addEnchant(Enchantment.ARROW_KNOCKBACK, 1).build();
			    	pi.addItem(bow2);
				}else {p.sendMessage("§8▎ §r §cYou don't have enough §8[§6GOLD_INGOT§8]");}
			}
		}
		
		if (slot == 52) {
			if (ci.getName() == "§4Shop") {
				if (pi.contains(Material.GOLD_INGOT,12)) {
					pi.removeItem(new ItemStack(Material.GOLD_INGOT,12));
					ItemStack bow3 = new ItemBuilder (Material.BOW,1,0).addEnchant(Enchantment.ARROW_DAMAGE, 3).addEnchant(Enchantment.DURABILITY, 4).addEnchant(Enchantment.ARROW_FIRE, 1).addEnchant(Enchantment.ARROW_KNOCKBACK, 1).build();
			    	pi.addItem(bow3);
				}else {p.sendMessage("§8▎ §r §cYou don't have enough §8[§6GOLD_INGOT§8]");}
			}
		}
		
		if (slot == 26) {
			if (ci.getName() == "§4Shop") {
				if (pi.contains(Material.GOLD_INGOT,4)) {
					pi.removeItem(new ItemStack(Material.GOLD_INGOT,4));
					ItemStack sword1 = new ItemBuilder (Material.DIAMOND_SWORD,1,0).addEnchant(Enchantment.DAMAGE_ALL, 2).addEnchant(Enchantment.DURABILITY, 2).build();
			    	pi.addItem(sword1);
				}else {p.sendMessage("§8▎ §r §cYou don't have enough §8[§6GOLD_INGOT§8]");}
			}
		}
		
		if (slot == 35) {
			if (ci.getName() == "§4Shop") {
				if (pi.contains(Material.GOLD_INGOT,4)) {
					pi.removeItem(new ItemStack(Material.GOLD_INGOT,4));
					ItemStack sword2 = new ItemBuilder (Material.DIAMOND_SWORD,1,0).addEnchant(Enchantment.DAMAGE_ALL, 3).addEnchant(Enchantment.FIRE_ASPECT, 1).addEnchant(Enchantment.DURABILITY, 3).build();
			    	pi.addItem(sword2);
				}else {p.sendMessage("§8▎ §r §cYou don't have enough §8[§6GOLD_INGOT§8]");}
			}
		}
		
		if (slot == 44) {
			if (ci.getName() == "§4Shop") {
				if (pi.contains(Material.GOLD_INGOT,4)) {
					pi.removeItem(new ItemStack(Material.GOLD_INGOT,4));
					ItemStack sword3 = new ItemBuilder (Material.DIAMOND_SWORD,1,0).addEnchant(Enchantment.DAMAGE_ALL, 4).addEnchant(Enchantment.FIRE_ASPECT, 1).addEnchant(Enchantment.DURABILITY, 4).addEnchant(Enchantment.KNOCKBACK, 1).build();
			    	pi.addItem(sword3);
				}else {p.sendMessage("§8▎ §r §cYou don't have enough §8[§6GOLD_INGOT§8]");}
			}
		}
		
		if (slot == 53) {
			if (ci.getName() == "§4Shop") {
				if (pi.contains(Material.GOLD_INGOT,4)) {
					pi.removeItem(new ItemStack(Material.GOLD_INGOT,4));
					ItemStack sword4 = new ItemBuilder (Material.DIAMOND_SWORD,1,0).addEnchant(Enchantment.DAMAGE_ALL, 5).addEnchant(Enchantment.FIRE_ASPECT, 1).addEnchant(Enchantment.DURABILITY, 5).addEnchant(Enchantment.KNOCKBACK, 2).build();
			    	pi.addItem(sword4);
				}else {p.sendMessage("§8▎ §r §cYou don't have enough §8[§6GOLD_INGOT§8]");}
			}
		}
		
		if (slot == 22) {
			if (ci.getName() == "§4Shop") {
				if (pi.contains(Material.GOLD_INGOT,2)) {
					pi.removeItem(new ItemStack(Material.GOLD_INGOT,2));
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give "+p.getName()+ " 4");
					ScoreBoard.Scoreboard(p);
			}else {p.sendMessage("§8▎ §r §cYou don't have enough §8[§6GOLD_INGOT§8]");}

		}
		}
		
		if (slot == 2) {
			if (ci.getName() == "§4Shop") {
				if (pi.contains(Material.GOLD_INGOT,6)) {
					pi.removeItem(new ItemStack(Material.GOLD_INGOT,6));
					ItemStack speed = new ItemBuilder (Material.POTION,1,8226).setDisplayname("§7Speed Potion").build();
			    	pi.addItem(speed);
				}else {p.sendMessage("§8▎ §r §cYou don't have enough §8[§6GOLD_INGOT§8]");}
			}
		}
		
		if (slot == 3) {
			if (ci.getName() == "§4Shop") {
				if (pi.contains(Material.GOLD_INGOT,4)) {
					pi.removeItem(new ItemStack(Material.GOLD_INGOT,4));
					ItemStack jumpboost = new ItemBuilder (Material.POTION,1,8203).setDisplayname("§aJump Potion").build();
			    	pi.addItem(jumpboost);
				}else {p.sendMessage("§8▎ §r §cYou don't have enough §8[§6GOLD_INGOT§8]");}
			}
		}
		
		if (slot == 4) {
			if (ci.getName() == "§4Shop") {
				if (pi.contains(Material.GOLD_INGOT,2)) {
					pi.removeItem(new ItemStack(Material.GOLD_INGOT,2));
					ItemStack apple5 = new ItemBuilder (Material.GOLDEN_APPLE,1,1).setDisplayname("§dGolden Apple").build();
					pi.addItem(apple5);
				}else {p.sendMessage("§8▎ §r §cYou don't have enough §8[§6GOLD_INGOT§8]");}
			}
		}
		
		if (slot == 5) {
			if (ci.getName() == "§4Shop") {
				if (pi.contains(Material.GOLD_INGOT,4)) {
					pi.removeItem(new ItemStack(Material.GOLD_INGOT,4));
					ItemStack fireresistance = new ItemBuilder (Material.POTION,1,8259).setDisplayname("§6Fire Resistance Potion").build();
			    	pi.addItem(fireresistance);
				}else {p.sendMessage("§8▎ §r §cYou don't have enough §8[§6GOLD_INGOT§8]");}
			}
		}
		
		if (slot == 6) {
			if (ci.getName() == "§4Shop") {
				if (pi.contains(Material.GOLD_INGOT,6)) {
					pi.removeItem(new ItemStack(Material.GOLD_INGOT,6));
					ItemStack strength = new ItemBuilder (Material.POTION,1,8233).setDisplayname("§5Strength Potion").build();
			    	pi.addItem(strength);
				}else {p.sendMessage("§8▎ §r §cYou don't have enough §8[§6GOLD_INGOT§8]");}
			}
		}
		
	}
}

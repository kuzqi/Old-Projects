package Shop;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import Utils.ItemBuilder;

public class GoldShop implements Listener {

	@EventHandler
	public void _ShopSettings(InventoryClickEvent e) {
		Inventory i = e.getInventory();
		Inventory ci = e.getClickedInventory();
		
		if (i.getName() == "§8Main Shop") e.setCancelled(true);
		if (ci.getName() == "§8Main Shop") e.setCancelled(true);
		
		if (i.getName() == "§8Armours Shop") e.setCancelled(true);
		if (ci.getName() == "§8Armours Shop") e.setCancelled(true);
		
		if (i.getName() == "§8Bows Shop") e.setCancelled(true);
		if (ci.getName() == "§8Bows Shop") e.setCancelled(true);
		
		if (i.getName() == "§8Apples Shop") e.setCancelled(true);
		if (ci.getName() == "§8Apples Shop") e.setCancelled(true);
		
		if (i.getName() == "§8Potions Shop") e.setCancelled(true);
		if (ci.getName() == "§8Potions Shop") e.setCancelled(true);
		
		if (i.getName() == "§8Swords Shop") e.setCancelled(true);
		if (ci.getName() == "§8Swords Shop") e.setCancelled(true);
	}
	
	@EventHandler
	public void _1ShopSettings(InventoryClickEvent e) {
		HumanEntity p = e.getWhoClicked();
		Inventory ci = e.getClickedInventory();
		int slot = e.getSlot();
		if (slot == 2) {
		if (ci.getName() == "§8Main Shop") {
			Inventory SWORDSguiz = Bukkit.getServer().createInventory(p, 54, "§8Swords Shop");
	    	// -  -  -  -  -  -  -  -  -
	    	ItemStack SwordsGUI = new ItemBuilder (Material.DIAMOND_SWORD,1,0).setDisplayname("§6Swords Shop").build();
	    	ItemStack ArmoursGUI = new ItemBuilder (Material.DIAMOND_CHESTPLATE,1,0).setDisplayname("§6Armours Shop").build();
	    	ItemStack BowsGUI = new ItemBuilder (Material.BOW,1,0).setDisplayname("§6Bows Shop").build();
	    	ItemStack ApplesGUI = new ItemBuilder (Material.GOLDEN_APPLE,1,1).setDisplayname("§6Apples Shop").build();
	    	ItemStack PotionsGUI = new ItemBuilder (Material.POTION,1,8233).setDisplayname("§6Potions Shop").build();
	    	SWORDSguiz.setItem(2, SwordsGUI);
	    	SWORDSguiz.setItem(3, ArmoursGUI);
	    	SWORDSguiz.setItem(4, BowsGUI);
	    	SWORDSguiz.setItem(5, ApplesGUI);
	    	SWORDSguiz.setItem(6, PotionsGUI);
	    	// -  -  -  -  -  -  -  -  -
			ItemStack sword1 = new ItemBuilder(Material.DIAMOND_SWORD,1,0).setLore("§aPrice: §e 6 GOLD").addEnchant(Enchantment.DAMAGE_ALL,2).addEnchant(Enchantment.DURABILITY,2).build();
			ItemStack sword2 = new ItemBuilder(Material.DIAMOND_SWORD,1,0).setLore("§aPrice: §e 8 GOLD").addEnchant(Enchantment.DAMAGE_ALL,3).addEnchant(Enchantment.DURABILITY,3).addEnchant(Enchantment.FIRE_ASPECT,1).build();
			ItemStack sword3 = new ItemBuilder(Material.DIAMOND_SWORD,1,0).setLore("§aPrice: §e 12 GOLD").addEnchant(Enchantment.DAMAGE_ALL,4).addEnchant(Enchantment.DURABILITY,3).addEnchant(Enchantment.FIRE_ASPECT,1).addEnchant(Enchantment.KNOCKBACK,2).build();
	    	// -  -  -  -  -  -  -  -  -
			SWORDSguiz.setItem(21, sword1);
			SWORDSguiz.setItem(22, sword2);
			SWORDSguiz.setItem(23, sword3);
			p.openInventory(SWORDSguiz);
			}
		
		}else {
			if (slot == 3) {
				if (ci.getName() == "§8Main Shop") {
					Inventory ARMOURSguiz = Bukkit.getServer().createInventory(p, 54, "§8Armours Shop");
			    	// -  -  -  -  -  -  -  -  -
			    	ItemStack SwordsGUI = new ItemBuilder (Material.DIAMOND_SWORD,1,0).setDisplayname("§6Swords Shop").build();
			    	ItemStack ArmoursGUI = new ItemBuilder (Material.DIAMOND_CHESTPLATE,1,0).setDisplayname("§6Armours Shop").build();
			    	ItemStack BowsGUI = new ItemBuilder (Material.BOW,1,0).setDisplayname("§6Bows Shop").build();
			    	ItemStack ApplesGUI = new ItemBuilder (Material.GOLDEN_APPLE,1,1).setDisplayname("§6Apples Shop").build();
			    	ItemStack PotionsGUI = new ItemBuilder (Material.POTION,1,8233).setDisplayname("§6Potions Shop").build();
			    	ARMOURSguiz.setItem(2, SwordsGUI);
			    	ARMOURSguiz.setItem(3, ArmoursGUI);
			    	ARMOURSguiz.setItem(4, BowsGUI);
			    	ARMOURSguiz.setItem(5, ApplesGUI);
			    	ARMOURSguiz.setItem(6, PotionsGUI);
			    	// -  -  -  -  -  -  -  -  -
			    	ItemStack Helmet1 = new ItemBuilder(Material.DIAMOND_HELMET,1,0).setLore("§aPrice: §e4 GOLD").addEnchant(Enchantment.DURABILITY,3).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3).build();
			    	ItemStack Helmet2 = new ItemBuilder(Material.DIAMOND_HELMET,1,0).setLore("§aPrice: §e8 GOLD").addEnchant(Enchantment.DURABILITY,4).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4).build();
			    	ItemStack Chestplate1 = new ItemBuilder(Material.DIAMOND_CHESTPLATE,1,0).setLore("§aPrice: §e4 GOLD").addEnchant(Enchantment.DURABILITY,3).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3).build();
			    	ItemStack Chestplate2 = new ItemBuilder(Material.DIAMOND_CHESTPLATE,1,0).setLore("§aPrice: §e8 GOLD").addEnchant(Enchantment.DURABILITY,4).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4).build();
			    	ItemStack Leggings1 = new ItemBuilder(Material.DIAMOND_LEGGINGS,1,0).setLore("§aPrice: §e4 GOLD").addEnchant(Enchantment.DURABILITY,3).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3).build();
			    	ItemStack Leggings2 = new ItemBuilder(Material.DIAMOND_LEGGINGS,1,0).setLore("§aPrice: §e8 GOLD").addEnchant(Enchantment.DURABILITY,4).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4).build();
			    	ItemStack Boots1 = new ItemBuilder(Material.DIAMOND_BOOTS,1,0).setLore("§aPrice: §e4 GOLD").addEnchant(Enchantment.DURABILITY,3).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3).build();
			    	ItemStack Boots2 = new ItemBuilder(Material.DIAMOND_BOOTS,1,0).setLore("§aPrice: §e8 GOLD").addEnchant(Enchantment.DURABILITY,4).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4).build();
			    	ARMOURSguiz.setItem(20, Helmet1);
			    	ARMOURSguiz.setItem(23, Helmet2);
			    	ARMOURSguiz.setItem(29, Chestplate1);
			    	ARMOURSguiz.setItem(32, Chestplate2);
			    	ARMOURSguiz.setItem(21, Leggings1);
			    	ARMOURSguiz.setItem(24, Leggings2);
			    	ARMOURSguiz.setItem(30, Boots1);
			    	ARMOURSguiz.setItem(33, Boots2);
			    	p.openInventory(ARMOURSguiz);
			}
			}else {
				if (slot == 4) {
					if (ci.getName() == "§8Main Shop") {
						Inventory BOWSguiz = Bukkit.getServer().createInventory(p, 54, "§8Bows Shop");
				    	// -  -  -  -  -  -  -  -  -
				    	ItemStack SwordsGUI = new ItemBuilder (Material.DIAMOND_SWORD,1,0).setDisplayname("§6Swords Shop").build();
				    	ItemStack ArmoursGUI = new ItemBuilder (Material.DIAMOND_CHESTPLATE,1,0).setDisplayname("§6Armours Shop").build();
				    	ItemStack BowsGUI = new ItemBuilder (Material.BOW,1,0).setDisplayname("§6Bows Shop").build();
				    	ItemStack ApplesGUI = new ItemBuilder (Material.GOLDEN_APPLE,1,1).setDisplayname("§6Apples Shop").build();
				    	ItemStack PotionsGUI = new ItemBuilder (Material.POTION,1,8233).setDisplayname("§6Potions Shop").build();
				    	BOWSguiz.setItem(2, SwordsGUI);
				    	BOWSguiz.setItem(3, ArmoursGUI);
				    	BOWSguiz.setItem(4, BowsGUI);
				    	BOWSguiz.setItem(5, ApplesGUI);
				    	BOWSguiz.setItem(6, PotionsGUI);
				    	// -  -  -  -  -  -  -  -  -
				    	ItemStack Bow1 = new ItemBuilder (Material.BOW,1,0).setLore("§aPrice: §e4 GOLD").addEnchant(Enchantment.DURABILITY,2).addEnchant(Enchantment.ARROW_KNOCKBACK,1).build();
				    	ItemStack Bow2 = new ItemBuilder (Material.BOW,1,0).setLore("§aPrice: §e6 GOLD").addEnchant(Enchantment.DURABILITY,3).addEnchant(Enchantment.ARROW_KNOCKBACK,1).addEnchant(Enchantment.ARROW_FIRE,1).build();
				    	ItemStack Bow3 = new ItemBuilder (Material.BOW,1,0).setLore("§aPrice: §e8 GOLD").addEnchant(Enchantment.DURABILITY,4).addEnchant(Enchantment.ARROW_KNOCKBACK,2).addEnchant(Enchantment.ARROW_FIRE,1).build();
				    	BOWSguiz.setItem(21, Bow1);
				    	BOWSguiz.setItem(22, Bow2);
				    	BOWSguiz.setItem(23, Bow3);
				    	p.openInventory(BOWSguiz);
					}
				}else {
					if (slot == 5) {
						if (ci.getName() == "§8Main Shop") {
							Inventory APPLESguiz = Bukkit.getServer().createInventory(p, 54, "§8Apples Shop");
					    	// -  -  -  -  -  -  -  -  -
					    	ItemStack SwordsGUI = new ItemBuilder (Material.DIAMOND_SWORD,1,0).setDisplayname("§6Swords Shop").build();
					    	ItemStack ArmoursGUI = new ItemBuilder (Material.DIAMOND_CHESTPLATE,1,0).setDisplayname("§6Armours Shop").build();
					    	ItemStack BowsGUI = new ItemBuilder (Material.BOW,1,0).setDisplayname("§6Bows Shop").build();
					    	ItemStack ApplesGUI = new ItemBuilder (Material.GOLDEN_APPLE,1,1).setDisplayname("§6Apples Shop").build();
					    	ItemStack PotionsGUI = new ItemBuilder (Material.POTION,1,8233).setDisplayname("§6Potions Shop").build();
					    	APPLESguiz.setItem(2, SwordsGUI);
					    	APPLESguiz.setItem(3, ArmoursGUI);
					    	APPLESguiz.setItem(4, BowsGUI);
					    	APPLESguiz.setItem(5, ApplesGUI);
					    	APPLESguiz.setItem(6, PotionsGUI);
					    	// -  -  -  -  -  -  -  -  -
					    	ItemStack Apple1 = new ItemBuilder (Material.GOLDEN_APPLE,2,1).setLore("§aPrice: §e4 GOLD").build();
					    	ItemStack Apple2 = new ItemBuilder (Material.GOLDEN_APPLE,4,1).setLore("§aPrice: §e8 GOLD").build();
					    	ItemStack Apple3 = new ItemBuilder (Material.GOLDEN_APPLE,6,1).setLore("§aPrice: §e12 GOLD").build();
					    	APPLESguiz.setItem(21, Apple1);
					    	APPLESguiz.setItem(22, Apple2);
					    	APPLESguiz.setItem(23, Apple3);
					    	p.openInventory(APPLESguiz);
						}
					}else {
						if (slot == 6) {
							if (ci.getName() == "§8Main Shop") {
								Inventory POTIONSguiz = Bukkit.getServer().createInventory(p, 54, "§8Potions Shop");
						    	// -  -  -  -  -  -  -  -  -
						    	ItemStack SwordsGUI = new ItemBuilder (Material.DIAMOND_SWORD,1,0).setDisplayname("§6Swords Shop").build();
						    	ItemStack ArmoursGUI = new ItemBuilder (Material.DIAMOND_CHESTPLATE,1,0).setDisplayname("§6Armours Shop").build();
						    	ItemStack BowsGUI = new ItemBuilder (Material.BOW,1,0).setDisplayname("§6Bows Shop").build();
						    	ItemStack ApplesGUI = new ItemBuilder (Material.GOLDEN_APPLE,1,1).setDisplayname("§6Apples Shop").build();
						    	ItemStack PotionsGUI = new ItemBuilder (Material.POTION,1,8233).setDisplayname("§6Potions Shop").build();
						    	POTIONSguiz.setItem(2, SwordsGUI);
						    	POTIONSguiz.setItem(3, ArmoursGUI);
						    	POTIONSguiz.setItem(4, BowsGUI);
						    	POTIONSguiz.setItem(5, ApplesGUI);
						    	POTIONSguiz.setItem(6, PotionsGUI);
						    	// -  -  -  -  -  -  -  -  -
						    	ItemStack Potion1 = new ItemBuilder (Material.POTION,1,8226).setLore("§aPrice: §e4 GOLD").build();
						    	ItemStack Potion2 = new ItemBuilder (Material.POTION,1,8227).setLore("§aPrice: §e6 GOLD").build();
						    	ItemStack Potion3 = new ItemBuilder (Material.POTION,1,8233).setLore("§aPrice: §e8 GOLD").build();
						    	POTIONSguiz.setItem(21, Potion1);
						    	POTIONSguiz.setItem(22, Potion2);
						    	POTIONSguiz.setItem(23, Potion3);
						    	p.openInventory(POTIONSguiz);
							}
						}
					}
				}
			}
		}
	}
}

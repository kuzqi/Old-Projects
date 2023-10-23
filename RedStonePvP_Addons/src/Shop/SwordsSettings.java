package Shop;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import Utils.ItemBuilder;

public class SwordsSettings implements Listener {

	@EventHandler
	public void _ShopSettings1(InventoryClickEvent e) {
		HumanEntity p = e.getWhoClicked();
		Inventory ci = e.getClickedInventory();
		PlayerInventory pi = e.getWhoClicked().getInventory();
		//   -   -   -   -   -   -   -   
		if (e.getSlot() == 21) {
		if (ci.getName() == "§8Swords Shop") 
			if (pi.contains(Material.GOLD_INGOT, 6)) {
				pi.removeItem(new ItemStack(Material.GOLD_INGOT,6));
				ItemStack Sword1z = new ItemBuilder(Material.DIAMOND_SWORD,1,0).addEnchant(Enchantment.DAMAGE_ALL,2).addEnchant(Enchantment.DURABILITY,2).build();
				pi.addItem(Sword1z);}else{ p.sendMessage("§8§l┃ §4§l✘ §c§lYou don't have enough §8[§6GOLD_INGOT§8] §c§lto buy this.");}
		//   -   -   -   -   -   -   -   
		}else {
			if (e.getSlot() == 22) {
				if (pi.contains(Material.GOLD_INGOT, 8)) {
					pi.removeItem(new ItemStack(Material.GOLD_INGOT,8));
					ItemStack Sword1z = new ItemBuilder(Material.DIAMOND_SWORD,1,0).addEnchant(Enchantment.DAMAGE_ALL,3).addEnchant(Enchantment.DURABILITY,3).addEnchant(Enchantment.FIRE_ASPECT,1).build();
					pi.addItem(Sword1z);}else{p.sendMessage("§8§l┃ §4§l✘ §c§lYou don't have enough §8[§6GOLD_INGOT§8] §c§lto buy this.");}
			//   -   -   -   -   -   -   -   
			}else {
				if (e.getSlot() == 22) {
					if (pi.contains(Material.GOLD_INGOT, 12)) {
						pi.removeItem(new ItemStack(Material.GOLD_INGOT,12));
						ItemStack Sword1z = new ItemBuilder(Material.DIAMOND_SWORD,1,0).addEnchant(Enchantment.DAMAGE_ALL,4).addEnchant(Enchantment.DURABILITY,3).addEnchant(Enchantment.FIRE_ASPECT,1).addEnchant(Enchantment.KNOCKBACK,2).build();
						pi.addItem(Sword1z);}else{p.sendMessage("§8§l┃ §4§l✘ §c§lYou don't have enough §8[§6GOLD_INGOT§8] §c§lto buy this.");}
			}
			}
		}
	}
}

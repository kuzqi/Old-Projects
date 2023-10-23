package PvP.Managers;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import PvP.Utils.ItemBuilder;

public class EventsManager {

	
	public void PlayerJoin(Player p) {

		Location spawnloc = new Location (p.getWorld(), 0.500, 65, 0.500, (float)-0.6, (float)0.9);
		p.teleport(spawnloc);
	
		if (p.getHealth() < 20) {
			p.setHealth(20F);
		}
		
		if (p.getFireTicks() >= 1) {
			p.setFireTicks(0);
		}
	
		p.getInventory().clear();
	
		ItemStack sword1 = new ItemBuilder(Material.WOOD_SWORD, 1, 0).setUnbreakable(true).addEnchant(Enchantment.DAMAGE_ALL, 1).setDisplayname("§7(Sword)").addItemFlags(ItemFlag.HIDE_UNBREAKABLE).addItemFlags(ItemFlag.HIDE_ATTRIBUTES).addItemFlags(ItemFlag.HIDE_DESTROYS).addItemFlags(ItemFlag.HIDE_ENCHANTS).build();
		ItemStack rod1 = new ItemBuilder(Material.FISHING_ROD, 1, 0).setUnbreakable(true).setDisplayname("§7(Rod)").addItemFlags(ItemFlag.HIDE_UNBREAKABLE).build();
		ItemStack bow1 = new ItemBuilder(Material.BOW, 1, 0).setUnbreakable(true).setDisplayname("§7(Bow)").addItemFlags(ItemFlag.HIDE_UNBREAKABLE).build();
		ItemStack flint1 = new ItemBuilder(Material.FLINT_AND_STEEL, 1, 0).setUnbreakable(true).setDisplayname("§6Charges §c1").addItemFlags(ItemFlag.HIDE_UNBREAKABLE).build();
		ItemStack arrow1 = new ItemBuilder(Material.ARROW, 3, 0).setDisplayname("§7(Arrow)").build();
		ItemStack helmet1 = new ItemBuilder(Material.IRON_HELMET, 1, 0).setUnbreakable(true).setDisplayname("§7(Helmet)").addItemFlags(ItemFlag.HIDE_UNBREAKABLE).build();
		ItemStack chestplate1 = new ItemBuilder(Material.CHAINMAIL_CHESTPLATE, 1, 0).setUnbreakable(true).setDisplayname("§7(Chestplate)").addItemFlags(ItemFlag.HIDE_UNBREAKABLE).build();
		ItemStack leggings1 = new ItemBuilder(Material.CHAINMAIL_LEGGINGS, 1, 0).setUnbreakable(true).setDisplayname("§7(Leggings)").addItemFlags(ItemFlag.HIDE_UNBREAKABLE).build();
		ItemStack boots1 = new ItemBuilder(Material.IRON_BOOTS, 1, 0).setUnbreakable(true).setDisplayname("§7(Boots)").addItemFlags(ItemFlag.HIDE_UNBREAKABLE).build();
		p.getInventory().setItem(0, sword1);
		p.getInventory().setItem(1, rod1);
		p.getInventory().setItem(2, bow1);
		p.getInventory().setItem(3, flint1);
		p.getInventory().setItem(5, arrow1);
		p.getInventory().setHelmet(helmet1);
		p.getInventory().setChestplate(chestplate1);
		p.getInventory().setLeggings(leggings1);
		p.getInventory().setBoots(boots1);
		
		ItemStack white_wool = new ItemBuilder(Material.WOOL, 64, 0).setDisplayname("§7(Wool)").build();
		
		p.getInventory().setItem(4, white_wool);
	}

}

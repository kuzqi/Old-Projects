package Shop;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import Main.Main;
import Utils.ItemBuilder;

public class ShopCMD implements CommandExecutor {
	  public Main plugin;
	  public ShopCMD(Main plugin) { this.plugin = plugin;}

	  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
	    Player p = (Player)sender;
	    if (label.equalsIgnoreCase("iixxxSHOPxxxii")) {
	    	// -  -  -  -  -  -  -  -  -
	    	Inventory ShopGui = Bukkit.getServer().createInventory(p, 54, "§8Main Shop");
	    	ItemStack SwordsGUI = new ItemBuilder (Material.DIAMOND_SWORD,1,0).setDisplayname("§6Swords Shop").build();
	    	ItemStack ArmoursGUI = new ItemBuilder (Material.DIAMOND_CHESTPLATE,1,0).setDisplayname("§6Armours Shop").build();
	    	ItemStack BowsGUI = new ItemBuilder (Material.BOW,1,0).setDisplayname("§6Bows Shop").build();
	    	ItemStack ApplesGUI = new ItemBuilder (Material.GOLDEN_APPLE,1,1).setDisplayname("§6Apples Shop").build();
	    	ItemStack PotionsGUI = new ItemBuilder (Material.POTION,1,8233).setDisplayname("§6Potions Shop").build();
	    	// -  -  -  -  -  -  -  -  -
	    	ItemStack PREMIUM_Chestplate = new ItemBuilder (Material.DIAMOND_CHESTPLATE,1,0).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5).addEnchant(Enchantment.DURABILITY, 5).setLore("§0", "§aPrice: §e14 GOLD").build();
	    	ItemStack PREMIUM_Chestplate1 = new ItemBuilder (Material.DIAMOND_CHESTPLATE,1,0).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 6).addEnchant(Enchantment.DURABILITY, 5).setLore("§0", "§aPrice: §e16 GOLD").build();
	    	ItemStack PREMIUM_Chestplate2 = new ItemBuilder (Material.DIAMOND_CHESTPLATE,1,0).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 7).addEnchant(Enchantment.DURABILITY, 5).setLore("§0", "§aPrice: §e18 GOLD").build();
	    	ItemStack PREMIUM_Sword = new ItemBuilder (Material.DIAMOND_SWORD,1,0).addEnchant(Enchantment.DAMAGE_ALL, 5).addEnchant(Enchantment.DURABILITY, 4).setLore("§0", "§aPrice: §e12 GOLD").build();
	    	ItemStack PREMIUM_Sword1 = new ItemBuilder (Material.DIAMOND_SWORD,1,0).addEnchant(Enchantment.DAMAGE_ALL, 6).addEnchant(Enchantment.DURABILITY, 4).setLore("§0", "§aPrice: §e14 GOLD").build();
	    	ItemStack PREMIUM_Sword2 = new ItemBuilder (Material.DIAMOND_SWORD,1,0).addEnchant(Enchantment.DAMAGE_ALL, 7).addEnchant(Enchantment.DURABILITY, 4).setLore("§0", "§aPrice: §e16 GOLD").build();
	    	
	    	ShopGui.setItem(2, SwordsGUI);
	    	ShopGui.setItem(3, ArmoursGUI);
	    	ShopGui.setItem(4, BowsGUI);
	    	ShopGui.setItem(5, ApplesGUI);
	    	ShopGui.setItem(6, PotionsGUI);
	    	// -  -  -  -  -  -  -  -  -
	    	ShopGui.setItem(21, PREMIUM_Chestplate);
	    	ShopGui.setItem(22, PREMIUM_Chestplate1);
	    	ShopGui.setItem(23, PREMIUM_Chestplate2);
	    	ShopGui.setItem(30, PREMIUM_Sword);
	    	ShopGui.setItem(31, PREMIUM_Sword1);
	    	ShopGui.setItem(32, PREMIUM_Sword2);
	    	p.openInventory(ShopGui);
	    	}
		return true;
	  }
}
	    
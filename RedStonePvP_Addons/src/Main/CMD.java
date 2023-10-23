package Main;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import Utils.ItemBuilder;

public class CMD implements CommandExecutor {
	  public Main plugin;

	  public CMD(Main plugin) {
	    this.plugin = plugin;
	  }

	  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
	    Player p = (Player)sender;
	    
	    if (label.equalsIgnoreCase("trash")) {
	    	Inventory trash = Bukkit.getServer().createInventory(p, 54, "§4Trash"); p.openInventory(trash);}
	    
	    if (label.equalsIgnoreCase("ranks")) {
	    	if (args.length == 0) {
	    	String prefix = "§4§lRedStone§c§lPvP §8» §r";
	    	p.sendMessage("§1");
	    	p.sendMessage(prefix+"§7UNRANKED §a➲§7 0 §5✪");
	    	p.sendMessage(prefix+"§eBronze I §a➲§7 100 §5✪");
	    	p.sendMessage(prefix+"§eBronze II §a➲§7 200 §5✪");
	    	p.sendMessage(prefix+"§eBronze III §a➲§7 300 §5✪");
	    	p.sendMessage(prefix+"§eBronze IV §a➲§7 400 §5✪");
	    	p.sendMessage(prefix+"§eBronze V §a➲§7 500 §5✪");
	    	p.sendMessage(prefix+"§7Silver I §a➲§7 600 §5✪");
	    	p.sendMessage(prefix+"§7Silver II §a➲§7 700 §5✪");
	    	p.sendMessage(prefix+"§7Silver III §a➲§7 800 §5✪");
	    	p.sendMessage(prefix+"§7Silver IV §a➲§7 900 §5✪");
	    	p.sendMessage(prefix+"§7Silver V §a➲§7 1000 §5✪");
	    	p.sendMessage(prefix+"§6Gold I §a➲§7 1100 §5✪");
	    	p.sendMessage(prefix+"§6Gold II §a➲§7 1200 §5✪");
	    	p.sendMessage(prefix+"§6Gold III §a➲§7 1300 §5✪");
	    	p.sendMessage(prefix+"§6Gold IV §a➲§7 1400 §5✪");
	    	p.sendMessage(prefix+"§6Gold V §a➲§7 1500 §5✪");
	    	p.sendMessage(prefix+"§bDiamond I §a➲§7 1600 §5✪");
	    	p.sendMessage(prefix+"§bDiamond II §a➲§7 1700 §5✪");
	    	p.sendMessage(prefix+"§bDiamond III §a➲§7 1800 §5✪");
	    	p.sendMessage(prefix+"§bDiamond IV §a➲§7 1900 §5✪");
	    	p.sendMessage(prefix+"§bDiamond V §a➲§7 2000 §5✪");
	    	p.sendMessage(prefix+"§3Platinum I §a➲§7 2100 §5✪");
	    	p.sendMessage(prefix+"§3Platinum II §a➲§7 2200 §5✪");
	    	p.sendMessage(prefix+"§3Platinum III §a➲§7 2300 §5✪");
	    	p.sendMessage(prefix+"§3Platinum IV §a➲§7 2400 §5✪");
	    	p.sendMessage(prefix+"§3Platinum V §a➲§7 2600 §5✪");
	    	p.sendMessage(prefix+"§4Champion I §a➲§7 2700 §5✪");
	    	p.sendMessage(prefix+"§4Champion II §a➲§7 2800 §5✪");
	    	p.sendMessage(prefix+"§4Champion III §a➲§7 2900 §5✪");
	    	p.sendMessage(prefix+"§4Champion IV §a➲§7 3000 §5✪");
	    	p.sendMessage(prefix+"§4Champion V §a➲§7 3100 §5✪");
	    	p.sendMessage(prefix+"§5Legendary I §a➲§7 3500 §5✪");
	    	p.sendMessage(prefix+"§5Legendary II §a➲§7 4000 §5✪");
	    	p.sendMessage(prefix+"§5Legendary III §a➲§7 4500 §5✪");
	    	p.sendMessage(prefix+"§3§lThe§b§lHero §a➲§7 10000 §5✪");
	    	p.sendMessage(prefix+"§8§lGreatest §a➲§7 15000 §5✪");
	    	p.sendMessage(prefix+"§2§lAlZa7f §a➲§7 20000 §5✪");
	    }else {
	          p.sendMessage("§c§lUsage: §7/ranks");
	    }
	    }

	    if (label.equalsIgnoreCase("iixxxMINERxxxii")) {
	    	ItemStack MinerPickAxe = new ItemBuilder(Material.IRON_PICKAXE,1,0).setDisplayname("§4Pickaxe").setLore("§c§lLOCKED").addEnchant(Enchantment.DIG_SPEED, 5).addEnchant(Enchantment.DURABILITY, 3).build();
	    	Inventory MinerGUI = Bukkit.getServer().createInventory(p, 27, "§4Miner"); MinerGUI.setItem(13, MinerPickAxe); p.openInventory(MinerGUI);
	    }
	    
	    if (label.equalsIgnoreCase("iixxxWARPSxxxii")) {
	    	
	  	ItemStack GoldWarp = new ItemBuilder(Material.WOOL,1,(short)1).setDisplayname("§6Gold warp").build();
	  	ItemStack DiamondWarp = new ItemBuilder(Material.WOOL,1,(short)3).setDisplayname("§bDiamond warp").build();
	  	ItemStack EmeraldWarp = new ItemBuilder(Material.WOOL,1,(short)5).setDisplayname("§aEmerald warp").build();
	  	ItemStack EpicWarp = new ItemBuilder(Material.WOOL,1,(short)13).setDisplayname("§2Epic warp").build();
	    Inventory WarpsGUI = Bukkit.getServer().createInventory(p, 9, "§4Warps");
	    WarpsGUI.setItem(2, GoldWarp);
	    WarpsGUI.setItem(3, DiamondWarp);
	    WarpsGUI.setItem(4, EmeraldWarp);
	    WarpsGUI.setItem(5, EpicWarp);
	    p.openInventory(WarpsGUI);
	    }
		return true;
		
	  }
}
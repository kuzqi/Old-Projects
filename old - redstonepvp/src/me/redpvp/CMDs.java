package me.redpvp;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import me.redpvp.Main.Main;

public class CMDs implements CommandExecutor {
	  public Main main;

	  public CMDs(Main plugin) {
	    this.main = plugin;
	  }

	  public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args) {
	    Player p = (Player)sender;
	    
	    if (cmd.equalsIgnoreCase("trash")) {
	    	Inventory trash = main.getServer().createInventory(p, 36, "§8Trash"); p.openInventory(trash);}
	    
	    if (cmd.equalsIgnoreCase("ranks")) {
	    	String prefix = "§4§l(!) §r";
	    	p.sendMessage("§1");
	    	p.sendMessage(prefix+"§7UNRANKED §a➲§7 0 §5✪");
	    	p.sendMessage(prefix+"§eBronze I §a➲§7 100 §5✪");
	    	p.sendMessage(prefix+"§eBronze II §a➲§7 200 §5✪");
	    	p.sendMessage(prefix+"§eBronze III §a➲§7 300 §5✪");
	    	p.sendMessage(prefix+"§eBronze IV §a➲§7 400 §5✪");
	    	p.sendMessage(prefix+"§7Silver I §a➲§7 600 §5✪");
	    	p.sendMessage(prefix+"§7Silver II §a➲§7 700 §5✪");
	    	p.sendMessage(prefix+"§7Silver III §a➲§7 800 §5✪");
	    	p.sendMessage(prefix+"§7Silver IV §a➲§7 900 §5✪");
	    	p.sendMessage(prefix+"§6Gold I §a➲§7 1100 §5✪");
	    	p.sendMessage(prefix+"§6Gold II §a➲§7 1200 §5✪");
	    	p.sendMessage(prefix+"§6Gold III §a➲§7 1300 §5✪");
	    	p.sendMessage(prefix+"§6Gold IV §a➲§7 1400 §5✪");
	    	p.sendMessage(prefix+"§bDiamond I §a➲§7 1600 §5✪");
	    	p.sendMessage(prefix+"§bDiamond II §a➲§7 1700 §5✪");
	    	p.sendMessage(prefix+"§bDiamond III §a➲§7 1800 §5✪");
	    	p.sendMessage(prefix+"§bDiamond IV §a➲§7 1900 §5✪");
	    	p.sendMessage(prefix+"§3Platinum I §a➲§7 2600 §5✪");
	    	p.sendMessage(prefix+"§3Platinum II §a➲§7 2700 §5✪");
	    	p.sendMessage(prefix+"§3Platinum III §a➲§7 2800 §5✪");
	    	p.sendMessage(prefix+"§3Platinum IV §a➲§7 2900 §5✪");
	    	p.sendMessage(prefix+"§4Champion I §a➲§7 3600 §5✪");
	    	p.sendMessage(prefix+"§4Champion II §a➲§7 3700 §5✪");
	    	p.sendMessage(prefix+"§4Champion III §a➲§7 3800 §5✪");
	    	p.sendMessage(prefix+"§4Champion IV §a➲§7 3900 §5✪");
	    	p.sendMessage(prefix+"§5Legendary I §a➲§7 5000 §5✪");
	    	p.sendMessage(prefix+"§5Legendary II §a➲§7 5200 §5✪");
	    	p.sendMessage(prefix+"§5Legendary III §a➲§7 5400 §5✪");
	    	p.sendMessage(prefix+"§5Legendary IV §a➲§7 5600 §5✪");
	    	p.sendMessage(prefix+"§3§lThe§b§lHero §a➲§7 10000 §5✪");
	    }
		return true;
		
	  }
}
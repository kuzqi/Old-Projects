package System.CMDs;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import me.redpvp.Main.Main;

public class StaffCMDs implements CommandExecutor {
	
	  public Main main;
	  public StaffCMDs(Main m) {
		  this.main = m;
	  }

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player p = (Player)sender;
		
	      if (label.equalsIgnoreCase("gmc")) {
	    	  if (!p.hasPermission("system.gamemode")) {
	            	p.sendMessage("§8§l[§4§l!§8§l] §cYou don't have access to execute this command.");
	            	
	    	  }else {
	    		  p.setGameMode(GameMode.CREATIVE);
		          p.sendMessage("§8§l[§f§l!§8§l]§r §bYou have change your gamemode to §3Creative"); 
	    	  }
	      }
		
	      if (label.equalsIgnoreCase("gms")) {
	    	  if (!p.hasPermission("system.gamemode")) {
	            	p.sendMessage("§8§l[§4§l!§8§l] §cYou don't have access to execute this command.");
	            	
	    	  }else {
	    		  p.setGameMode(GameMode.SURVIVAL);
		          p.sendMessage("§8§l[§f§l!§8§l]§r §bYou have change your gamemode to §3Survival"); 
	    	  }
	      }
	      

	      
	        if (label.equalsIgnoreCase("invsee")) {
	            if (!p.hasPermission("system.invsee")) {
	            	p.sendMessage("§8§l[§4§l!§8§l] §cYou don't have access to execute this command.");
	            }else {
	            	if (!(args.length == 0)) {
	            		if (!(args[0].equalsIgnoreCase(p.getName()))) {
	            			if (main.getServer().getOnlinePlayers().contains(p)) {
	            				String arg1 = args[0];
	            				Bukkit.getPlayerExact(arg1);
	            				Player targetPlayer = main.getServer().getPlayer(arg1);
	            				p.openInventory ((Inventory) targetPlayer.getInventory());
	            		}else {
	            			 p.sendMessage("§8§l[§4§l!§8§l]§r §cThis player isn't online.");
	            		}
	            }else {
			    	 p.sendMessage("§8§l[§4§l!§8§l]§r §cYou can't use this command on yourself.");
	            }
	            	
	            }else {
	            	p.sendMessage("§8§l[§4§l!§8§l]§r §cSystem Error! Invaild command usage.");
	            }
	        }
	        }
		 //     ---     ---     ---     ---     --- 
	        
		return true; 
	  }
}
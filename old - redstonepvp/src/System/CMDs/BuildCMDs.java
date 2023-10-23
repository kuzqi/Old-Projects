package System.CMDs;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.redpvp.Main.Main;

public class BuildCMDs implements CommandExecutor {
	
	  public Main main;
	  public BuildCMDs(Main m) {
	    this.main = m;
	  }
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player p = (Player)sender;
			
	    if (label.equalsIgnoreCase("build")) {
	    	if (!p.hasPermission("system.build")) {
            	p.sendMessage("§8§l[§4§l!§8§l] §cYou don't have access to execute this command.");
          	
	    	}else {
	    		if (!main.build.contains(p.getName())) {
	    			main.build.add(p.getName());
	    			p.sendMessage("§8§l[§f§l!§8§l]§r §bBuild mode has been enabled!");
	    		
	      	}else {
	    		if (main.build.contains(p.getName())) {
	    			main.build.remove(p.getName());
		      		p.sendMessage("§8§l[§f§l!§8§l]§r §3Build mode has been disabled!");
		      	}
	      	}
	    }
	    }

		return true;
	}
}

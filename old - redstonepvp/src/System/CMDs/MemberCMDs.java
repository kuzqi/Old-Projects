package System.CMDs;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class MemberCMDs implements CommandExecutor {
	
	  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
	    Player p = (Player)sender;
	    
	    if (label.equalsIgnoreCase("ping")) {
		    int ping = ((CraftPlayer) p).getHandle().ping;
	        p.sendMessage("§bYour Ping is §a" +ping+ "§bms");
	    } 
	    
	    if (label.equalsIgnoreCase("discord")) {
	        p.sendMessage("§5https://discord.gg/N79MW4xSFh");
	    } 
	    
	    if (label.equalsIgnoreCase("store")) {
	        p.sendMessage("§ahttps://store.spiritsmc.com");
	    }
	    
	    if (label.equalsIgnoreCase("website")) {
	        p.sendMessage("§chttps://www.spiritsmc.com");
	    }
	    
	    if (label.equalsIgnoreCase("help")) {
	        p.sendMessage("§7§m---§b§m-----§3§m--------§3( §bSpirits§3MC §3)§3§m--------§b§m-----§7§m---");
	        p.sendMessage("§8- §b/friend §8| §7add §bfriends§7 in server.");
	        p.sendMessage("§8- §d/webstie §8| §7Visit our  §dwebsite§7.");
	        p.sendMessage("§8- §5/discord §8| §7join our §5discord§7.");
	        p.sendMessage("§8- §e/clan §8| §7create your §eclan§7 with friends.");
	        p.sendMessage("§8- §a/store §8| §7visit our §astore§7.");
	        p.sendMessage("§8- §4/report §8| §7report a §4rule breaker§7 in server.");
	        p.sendMessage("§7§m---§b§m-----§3§m--------§3( §bSpirits§3MC §3)§3§m--------§b§m-----§7§m---");
	    }
	    
		return true;
	  }
}
package System.CMDs;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import me.redpvp.Main.Main;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;

public class VanishCMDs implements CommandExecutor {

	  public Main main;
	  public VanishCMDs(Main m) {
		  this.main = m;
	  }
	  
	@SuppressWarnings("rawtypes")
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player p = (Player)sender;
	    PacketPlayOutTitle vanish = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, (IChatBaseComponent)IChatBaseComponent.ChatSerializer.a("{\"text\":\"Are Vanished\"}"), 0, 999999999, 0);
	    PacketPlayOutTitle visible = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, (IChatBaseComponent)IChatBaseComponent.ChatSerializer.a("{\"text\":\"Have Become Visible\"}"), 20, 30, 20);
	    
	    
    if (label.equalsIgnoreCase("v")) {
    	if (!p.hasPermission("system.vanish")) {
        	p.sendMessage("§8§l[§4§l!§8§l] §cYou don't have access to execute this command.");
			
    	}else {
    		if (!(main.vanish.contains(p.getName()))) {
    			main.vanish.add(p.getName());
    			p.sendMessage("§8§l[§f§l!§8§l]§r §bVanish mode has been enabled!");
    			p.setGameMode(GameMode.ADVENTURE);
        		p.setAllowFlight(true);
        		Location worldspawn = p.getWorld().getSpawnLocation();
        		p.teleport(worldspawn);
        		(((CraftPlayer)p).getHandle()).playerConnection.sendPacket((Packet)vanish);
        		for (Player online : main.getServer().getOnlinePlayers()) {
        			online.hidePlayer(p);
                }

    		}else {
        		if (main.vanish.contains(p.getName())) {
        			main.vanish.remove(p.getName());
        			p.sendMessage("§8§l[§f§l!§8§l]§r §3Vanish mode has been disabled!");
        			p.setGameMode(GameMode.SURVIVAL);
        			p.setAllowFlight(false);
        			Location worldspawn = p.getWorld().getSpawnLocation();
        			p.teleport(worldspawn);
        			(((CraftPlayer)p).getHandle()).playerConnection.sendPacket((Packet)visible);
        			for (Player online : main.getServer().getOnlinePlayers()) {
        				online.showPlayer(p);
        			}
        		}
    		}
    	}
    }
	return true;
  }
}

package me.o16.Listeners;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import me.o16.Main;

public class RandomTeleport implements Listener {

	private final Main main;
	public RandomTeleport(Main main) {
		this.main = main;
	}
	
	@EventHandler
	public void onPlayerMove(final PlayerMoveEvent e) {
    	if (e.getPlayer().getLocation().getWorld().getName().equalsIgnoreCase("lobby")) {
    		if (e.getTo().getBlock().isLiquid()) {
	        
    			ArrayList<Location> locations = new ArrayList<>();
    			  
	        	Location loc1 = new Location (main.getServer().getWorld("world"), -394.504, 68, -223.537, (float)89.7, (float)-0.1);
	        	
	        	Location loc2 = new Location (main.getServer().getWorld("world"), -1757.492, 70, -803.520, (float)89.1, (float)0.1);
	        	
	        	Location loc3 = new Location (main.getServer().getWorld("world"), -1022.500, 65, 9048.500, (float)92.4, (float)1.3);
	        	
	        	Location loc4 = new Location (main.getServer().getWorld("world"), 1885.494, 65, -9754.514, (float)90.1, (float)-0.1);
	        	
	        	Location loc5 = new Location (main.getServer().getWorld("world"), 1866.024, 76, -9186.407, (float)90.2, (float)0.5);
	        	

	            locations.add(loc1);
	            locations.add(loc2);
	            locations.add(loc3);
	            locations.add(loc4);
	            locations.add(loc5);
	            
	            Random random = new Random();
	            int randomIndex = random.nextInt(locations.size());
	            Location randomLocation = locations.get(randomIndex);
	            
	            e.getPlayer().teleport(randomLocation);
	    	}
				
	    }
	}
}

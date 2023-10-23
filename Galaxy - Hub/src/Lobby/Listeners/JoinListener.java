package Lobby.Listeners;

import java.io.IOException;
import java.net.InetAddress;
import java.util.UUID;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import Lobby.Main;

public class JoinListener implements Listener {

	//private static final String CHEATER_IP = "82.167.72.246";
	
	//private static final String CHEATER_NAME = "Demsh8";

	private final Main main;

	public JoinListener(Main main) {
	    this.main = main;
	}

	@EventHandler
	public void onpJoin(PlayerJoinEvent e) {
	    storeData(e.getPlayer());
	}

//	private void checkCheater(Player p) {
	//    if (p.getDisplayName().equalsIgnoreCase(CHEATER_NAME)) {
	//        InetAddress address = p.getAddress().getAddress();
	  //      if (!address.getHostAddress().equals(CHEATER_IP)) {
	        //    main.getConfig().set("cheater-ip", address.toString());
	      //      p.kickPlayer("You are not allowed to join this server.");
	   //         
		//        try {
		//	        saveConfig();
		//	        
		//	    }catch (Exception e) {
		//	    	e.printStackTrace();
		//		}
	  //      }
	 //   }
	//}

	private void storeData(Player p) {
	    UUID UUID = p.getUniqueId();
	    if (!main.getConfig().isSet(UUID.toString())) {
	        InetAddress address = p.getAddress().getAddress();
	        main.getConfig().set(UUID + ".name", p.getDisplayName());
	        main.getConfig().set(UUID + ".ip", address.getHostAddress());
	        main.getConfig().set(UUID + ".port", p.getAddress().getPort());
	        
	        try {
	        saveConfig();
	        
	        }catch (Exception e) {
				e.printStackTrace();
			}
	    }
	}
	
	private void saveConfig() throws IOException {
	    main.saveConfig();
	}

}
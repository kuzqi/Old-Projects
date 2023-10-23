package dev.o16.stats.Managers;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import dev.o16.stats.DataBase.PlayerStats;
import me.redpvp.Main.Main;

public class PrestigeManager implements Listener {
	
	public Main main;
	public PrestigeManager(Main main) {
		this.main = main;
	}
	
	
	String ownercolor = "§e";
	
	@EventHandler
	public void PrestigeJoin(PlayerJoinEvent e) {
		PlayerStats stats = main.playerStats.get(e.getPlayer().getUniqueId());
		if (main.playerStats.get(e.getPlayer().getUniqueId()).getPrestige() == null || main.playerStats.get(e.getPlayer().getUniqueId()).getstars() == 0) {
			stats.setPrestige("§7UNRANKED");
		}
	}

	@EventHandler
	public void PrestigeKill(PlayerDeathEvent e) {
		if (e.getEntity().getKiller() instanceof Player) {
			if (e.getEntity() instanceof Player) {
				check(e.getEntity().getKiller());
			}
		}
	}
	
	public void check(Player player) {
		int stars = main.playerStats.get(player.getUniqueId()).getstars();
		String prestige = main.playerStats.get(player.getUniqueId()).getPrestige();

		
		//                ----=======[ UNRANKED ]=======---- 
		if (prestige.equals("§7UNRANKED") && stars >= 100 && stars < 200) {
			main.playerStats.get(player.getUniqueId()).setPrestige("§eBronze I");
		}
		
		
		//                 ----=======[ BORNZE ]=======----
		if (prestige.equals("§eBronze I") && stars >= 200 && stars < 300) {
			main.playerStats.get(player.getUniqueId()).setPrestige("§eBronze II");
		}
		
		if (prestige.equals("§eBronze II") && stars >= 300 && stars < 400) {
			main.playerStats.get(player.getUniqueId()).setPrestige("§eBronze III");
		}
		
		if (prestige.equals("§eBronze III") && stars >= 400 && stars < 500) {
			main.playerStats.get(player.getUniqueId()).setPrestige("§eBronze IV");
		}
		
		if (prestige.equals("§eBronze IV") && stars >= 500 && stars < 600) {
			main.playerStats.get(player.getUniqueId()).setPrestige("§7Silver I");
		}
		
		
		//                 ----=======[ SILVER ]=======---- 
		if (prestige.equals("§7Silver I") && stars >= 600 && stars < 700) {
			main.playerStats.get(player.getUniqueId()).setPrestige("§7Silver II");
		}
		
		if (prestige.equals("§7Silver II") && stars >= 700 && stars < 800) {
			main.playerStats.get(player.getUniqueId()).setPrestige("§7Silver III");
		}
		
		if (prestige.equals("§7Silver III") && stars >= 800 && stars < 900) {
			main.playerStats.get(player.getUniqueId()).setPrestige("§7Silver IV");
		}
		
		if (prestige.equals("§7Silver IV") && stars >= 900 && stars < 1000) {
			main.playerStats.get(player.getUniqueId()).setPrestige("§6Gold I");
		}
		
		
		//                 ----=======[ GOLD ]=======---- 
		if (prestige.equals("§6Gold I") && stars >= 1000 && stars < 1100) {
			main.playerStats.get(player.getUniqueId()).setPrestige("§7Gold II");
		}
		
		if (prestige.equals("§6Gold II") && stars >= 1100 && stars < 1200) {
			main.playerStats.get(player.getUniqueId()).setPrestige("§7Gold III");
		}
		
		if (prestige.equals("§6Gold III") && stars >= 1200 && stars < 1300) {
			main.playerStats.get(player.getUniqueId()).setPrestige("§7Gold IV");
		}
		
		if (prestige.equals("§6Gold IV") && stars >= 1300 && stars < 1400) {
			main.playerStats.get(player.getUniqueId()).setPrestige("§bDiamond I");
		}
		
		//                 ----=======[ GOLD ]=======---- 
		if (prestige.equals("§bDiamond I") && stars >= 1400 && stars < 1500) {
			main.playerStats.get(player.getUniqueId()).setPrestige("§bDiamond II");
		}
		
	}

	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		String prestige = main.playerStats.get(e.getPlayer().getUniqueId()).getPrestige();
		String name = e.getPlayer().getDisplayName();
		
		main.playerStats.get(e.getPlayer().getUniqueId()).setstars(main.playerStats.get(e.getPlayer().getUniqueId()).getstars()+50);
		check(e.getPlayer());
		e.setFormat("§8┃ " + prestige + " §8┃ " + ownercolor + name + " §8» §r" +e.getMessage());
	}
	

}

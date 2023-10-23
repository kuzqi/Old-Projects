package PvP.Managers;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import PvP.Main;
import PvP.MySQL.PlayerStats;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;

public class PrestigeManager implements Listener {
	
	private final Main main;
	public PrestigeManager(Main main) {
		this.main = main;
	}
	
	 static LuckPerms lp = LuckPermsProvider.get();
	 
	 
	@EventHandler
	public void PrestigeJoin(PlayerJoinEvent e) {
		PlayerStats stats = main.playerStats.get(e.getPlayer().getUniqueId());
		if (main.playerStats.get(e.getPlayer().getUniqueId()).getPrestige().equalsIgnoreCase("UNRANKED") || main.playerStats.get(e.getPlayer().getUniqueId()).getPoints() == 0) {
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

	private void check(Player player) {
		int points = main.playerStats.get(player.getUniqueId()).getPoints();
		String prestige = main.playerStats.get(player.getUniqueId()).getPrestige();
		
		if (prestige.equals("§7UNRANKED") && points >= 250 && points < 500) {
			main.playerStats.get(player.getUniqueId()).setPrestige("§eBronze");
		}
		
		if (prestige.equals("§eBronze") && points >= 500 && points < 1000) {
			main.playerStats.get(player.getUniqueId()).setPrestige("§7Silver");
		}
		
		if (prestige.equals("§7Silver") && points >= 1000 && points < 1500) {
			main.playerStats.get(player.getUniqueId()).setPrestige("§6Gold");
		}
		
		if (prestige.equals("§6Gold") && points >= 1500 && points < 2000) {
			main.playerStats.get(player.getUniqueId()).setPrestige("§bDiamond");
		}
		
		if (prestige.equals("§bDiamond") && points >= 2000 && points < 3500) {
			main.playerStats.get(player.getUniqueId()).setPrestige("§3Platinum");
		}
		
		if (prestige.equals("§3Platinum") && points >= 3500 && points < 4000) {
			main.playerStats.get(player.getUniqueId()).setPrestige("§4Champion");
		}
		
		if (prestige.equals("§4Champion") && points >= 4000 && points < 6000) {
			main.playerStats.get(player.getUniqueId()).setPrestige("§5Legendary");
		}

	}
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		
		Player p = e.getPlayer();
		String prestige = main.playerStats.get(e.getPlayer().getUniqueId()).getPrestige();

  		if (lp.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("Owner")) {
  		    e.setFormat("§8┃ "+ prestige +" §8┃ §4" +p.getName()+ " §8» §r"+e.getMessage());
  		}
  			
  		if (lp.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("Admin")) {
  		    e.setFormat("§8┃ "+ prestige +" §8┃ §e" +p.getName()+ " §8» §r"+e.getMessage());
  		}
  		
  		if (lp.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("SrMod")) {
  		    e.setFormat("§8┃ "+ prestige +" §8┃ §9" +p.getName()+ " §8» §r"+e.getMessage());
  		}
  		
  		if (lp.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("Mod")) {
  		    e.setFormat("§8┃ "+ prestige +" §8┃ §9" +p.getName()+ " §8» §r"+e.getMessage());
  		}
  			
  		if (lp.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("Elite")) {
  		    e.setFormat("§8┃ "+ prestige +" §8┃ §b" +p.getName()+ " §8» §r"+e.getMessage());
  		}
  			
  		if (lp.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("Special")) {
  		    e.setFormat("§8┃ "+ prestige +" §8┃ §c" +p.getName()+ " §8» §r"+e.getMessage());
  			
  		if (lp.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("VIP")) {
  		    e.setFormat("§8┃ "+ prestige +" §8┃ §6" +p.getName()+ " §8» §r"+e.getMessage());  
  		}
  			
  		if (lp.getUserManager().getUser(p.getUniqueId()).getPrimaryGroup().equalsIgnoreCase("Default")) {
  		    e.setFormat("§8┃ "+ prestige +" §8┃ §7" +p.getName()+ " §8» §r"+e.getMessage());
  		}
  	  }
	}
}

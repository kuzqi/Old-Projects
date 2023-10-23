package dev.o16.stats.Managers;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import me.redpvp.Main.Main;

public class StreaksManager implements Listener {

	public Main main; 
	public StreaksManager(Main main) {
		this.main = main;
	}
	
	@EventHandler
	public void onStreaks(PlayerDeathEvent e) {
		Player online = (Player) main.getServer().getOnlinePlayers();
		Player killer = e.getEntity().getKiller();

		if (main.streaks.get(killer.getUniqueId()) == 3) {
			main.getServer().broadcastMessage("§4§l(!) §f" +killer.getUniqueId()+ " §7has got a §4§lTRIPLE KILL");
		}
			
		if (main.streaks.get(killer.getUniqueId()) == 5) {
			main.getServer().broadcastMessage("§4§l(!) §f" +killer.getUniqueId()+ " §7has got a killstreak of §4§l5");
		}
			
		if (main.streaks.get(killer.getUniqueId()) == 10) {
			main.getServer().broadcastMessage("§4§l(!) §f" +killer.getUniqueId()+ " §7has got a killstreak of §4§l10");
			online.playSound(online.getLocation(), Sound.ENDERDRAGON_GROWL,1F,1F);
		}
			
		if (main.streaks.get(killer.getUniqueId()) == 15) {
			main.getServer().broadcastMessage("§4§l(!) §f" +killer.getUniqueId()+ " §7has got a killstreak of §4§l15");
		}
			
		if (main.streaks.get(killer.getUniqueId()) == 20) {
			main.getServer().broadcastMessage("§4§l(!) §f" +killer.getUniqueId()+ " §7has got a killstreak of §4§l20");
			online.playSound(online.getLocation(), Sound.ENDERDRAGON_GROWL,1F,1F);
		}
			
		if (main.streaks.get(killer.getUniqueId()) == 25) {
			main.getServer().broadcastMessage("§4§l(!) §f" +killer.getUniqueId()+ " §7has got a killstreak of §4§l25");
		}
			
		if (main.streaks.get(killer.getUniqueId()) == 30) {
			main.getServer().broadcastMessage("§4§l(!) §f" +killer.getUniqueId()+ " §7has got a killstreak of §4§l30");
			online.playSound(online.getLocation(), Sound.ENDERDRAGON_GROWL,1F,1F);
		}
			
		if (main.streaks.get(killer.getUniqueId()) == 35) {
			main.getServer().broadcastMessage("§4§l(!) §f" +killer.getUniqueId()+ " §7has got a killstreak of §4§l35");
		}
			
		if (main.streaks.get(killer.getUniqueId()) == 40) {
			main.getServer().broadcastMessage("§4§l(!) §f" +killer.getUniqueId()+ " §7has got a killstreak of §4§l40");
			online.playSound(online.getLocation(), Sound.ENDERDRAGON_GROWL,1F,1F);
		}
			
		if (main.streaks.get(killer.getUniqueId()) == 45) {
			main.getServer().broadcastMessage("§4§l(!) §f" +killer.getUniqueId()+ " §7has got a killstreak of §4§l45");
		}
		
		if (main.streaks.get(killer.getUniqueId()) == 50) {
			main.getServer().broadcastMessage("§4§l(!) §f" +killer.getUniqueId()+ " §7has got a killstreak of §4§l50");
			online.playSound(online.getLocation(), Sound.ENDERDRAGON_GROWL,1F,1F);
		}
			
		if (main.streaks.get(killer.getUniqueId()) == 55) {
			main.getServer().broadcastMessage("§4§l(!) §f" +killer.getUniqueId()+ " §7has got a killstreak of §4§l55");
		}
		
		if (main.streaks.get(killer.getUniqueId()) == 60) {
			main.getServer().broadcastMessage("§4§l(!) §f" +killer.getUniqueId()+ " §7has got a killstreak of §4§l60");
			online.playSound(online.getLocation(), Sound.ENDERDRAGON_GROWL,1F,1F);
		}
			
		if (main.streaks.get(killer.getUniqueId()) == 70) {
			main.getServer().broadcastMessage("§4§l(!) §f" +killer.getUniqueId()+ " §7has got a killstreak of §4§l70");
		}
			
		if (main.streaks.get(killer.getUniqueId()) == 80) {
			main.getServer().broadcastMessage("§4§l(!) §f" +killer.getUniqueId()+ " §7has got a killstreak of §4§l80");
			online.playSound(online.getLocation(), Sound.ENDERDRAGON_GROWL,1F,1F);
		}
			
		if (main.streaks.get(killer.getUniqueId()) == 90) {
			main.getServer().broadcastMessage("§4§l(!) §f" +killer.getUniqueId()+ " §7has got a killstreak of §4§l90");
		}
			
		if (main.streaks.get(killer.getUniqueId()) == 100) {
			main.getServer().broadcastMessage("§4§l(!) §f" +killer.getUniqueId()+ " §7has got a killstreak of §4§l100");
			online.playSound(online.getLocation(), Sound.ENDERDRAGON_GROWL, 0.9F, 0.8F);
		}
	}
	
	@EventHandler 
	public void StreakCheck(PlayerDeathEvent e){
		if (main.streaks.containsKey(e.getEntity().getKiller().getUniqueId())) {
			main.streaks.put(e.getEntity().getKiller().getUniqueId(), main.streaks.get(e.getEntity().getKiller().getUniqueId())+1);
		}
	}
	
	@EventHandler 
	public void onJoin(PlayerJoinEvent e){
		main.streaks.put(e.getPlayer().getUniqueId(),0);
	}
	
	@EventHandler 
	public void onRespawn(PlayerRespawnEvent e){
		main.streaks.put(e.getPlayer().getUniqueId(),0);
	}
	
	@EventHandler 
	public void onQuit(PlayerQuitEvent e){
		main.streaks.remove(e.getPlayer().getUniqueId());
	}
}

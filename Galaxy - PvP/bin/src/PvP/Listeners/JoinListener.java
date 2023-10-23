package PvP.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import PvP.Managers.EventsManager;

public class JoinListener implements Listener {

	EventsManager em = new EventsManager();
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e, Player p) {
		e.setJoinMessage("");
		em.PlayerJoin(p);
	}
}
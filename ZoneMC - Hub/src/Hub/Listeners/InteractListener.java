package Hub.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

import Hub.Main;

public class InteractListener implements Listener {

	private final Main main;
	public InteractListener(Main main) {
		this.main = main;
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		if (e.getAction() == Action.RIGHT_CLICK_AIR) {
			if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aGames §7(Right-Click)")) {
				Player p = e.getPlayer();
				
				Inventory GamesMenu = main.getServer().createInventory(p, 36, "§8");
				
			}
		}
	}
}

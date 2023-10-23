package FunGames.Games;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.inventory.ItemStack;

import FunGames.Utils.ItemBuilder;

public class Pearl implements Listener {

	@EventHandler
	public void onTeleport(PlayerTeleportEvent e) {
		if (e.getCause() == TeleportCause.ENDER_PEARL) {
			ItemStack enderpearl = new ItemBuilder(Material.ENDER_PEARL,1,0).setDisplayname("§2Pearl Teleporter").build();
			e.getPlayer().getInventory().setItem(1, enderpearl);
		}
	}
	
}

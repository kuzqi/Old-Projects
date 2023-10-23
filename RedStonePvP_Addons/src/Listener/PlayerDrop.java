package Listener;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class PlayerDrop implements Listener {

	@EventHandler
	public void onPlayerDrop(PlayerDropItemEvent e) {
	try {
	if (e.getItemDrop().getItemStack().getItemMeta().getLore().contains("§c§lLOCKED")) {
		Player p = e.getPlayer();
		e.getItemDrop().remove(); p.playSound(p.getLocation(),Sound.ITEM_BREAK,1,1);}
	}catch (Exception w){}}
}

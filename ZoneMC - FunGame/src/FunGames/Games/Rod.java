package FunGames.Games;

import java.util.Set;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

import com.google.common.collect.Sets;

public class Rod implements Listener {

	Set<Player> hookers = Sets.newHashSet();
	
	@EventHandler
    public void onPlayerFish(PlayerFishEvent e){
		if (hookers.contains(e.getPlayer())){
			e.getPlayer().setVelocity(e.getHook().getLocation().toVector().subtract(e.getPlayer().getLocation().toVector()).normalize().multiply(3));
			hookers.remove(e.getPlayer());
		}else{
			hookers.add(e.getPlayer());
		}
	}
	
}

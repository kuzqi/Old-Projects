package Player;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

import Utils.ItemBuilder;
import me.redpvp.Main.Main;
import me.redpvp.RedPvP.ScoreBoard;

public class PlayerDeath implements Listener {
	
	public Main main; 
	public PlayerDeath(Main main) {
		this.main = main;
	}
	
	  @EventHandler
	  public void onDeath(PlayerDeathEvent e) {
	    Player k = e.getEntity().getKiller();
	    Player d = e.getEntity();
		
	    if (k instanceof Player) {
	    	if (d instanceof Player) {
	    		
	    		k.sendMessage(main.getConfig().getString("messages.death").toString().replace("{killer}", k.getName().replaceAll("&", "§")));
	    		d.sendMessage(main.getConfig().getString("messages.kill").toString().replace("{killed}", d.getName().replaceAll("&", "§")));
	    		
	    		ScoreBoard.Scoreboard(k);
	    		ScoreBoard.Scoreboard(d);
	    		
	    }
	  }
	  }
	  
		@EventHandler
		public void onPlayerRespawn(PlayerRespawnEvent e) {
			Player p = e.getPlayer();
			ItemStack RespawnBow = new ItemBuilder(Material.BOW,1,0).setLore("§c§lLOCKED").build();
			ItemStack RespawnArrow = new ItemBuilder(Material.ARROW,64,0).setLore("§c§lLOCKED").build();
			ItemStack RespawnApple = new ItemBuilder(Material.GOLDEN_APPLE,64,0).setLore("§c§lLOCKED").build();
			ItemStack RespawnSword = new ItemBuilder(Material.DIAMOND_SWORD,1,0).setLore("§c§lLOCKED").build();
			ItemStack RespawnHelmet = new ItemBuilder(Material.DIAMOND_HELMET,1,0).setLore("§c§lLOCKED").build();
			ItemStack RespawnChestplate = new ItemBuilder(Material.DIAMOND_CHESTPLATE,1,0).setLore("§c§lLOCKED").build();
			ItemStack RespawnLeggings = new ItemBuilder(Material.DIAMOND_LEGGINGS,1,0).setLore("§c§lLOCKED").build();
			ItemStack RespawnBoots = new ItemBuilder(Material.DIAMOND_BOOTS,1,0).setLore("§c§lLOCKED").build();
			p.getInventory().setItem(0, RespawnSword);
			p.getInventory().setItem(1, RespawnBow);
			p.getInventory().setItem(7, RespawnApple);
			p.getInventory().setItem(8, RespawnArrow);
			p.getInventory().setHelmet(RespawnHelmet);
			p.getInventory().setChestplate(RespawnChestplate);
			p.getInventory().setLeggings(RespawnLeggings);
			p.getInventory().setBoots(RespawnBoots);

		}
}

package FunGames.Menu;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import FunGames.Utils.ItemBuilder;

public class Menu implements Listener {

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		if (e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equals(main.getConfig().getString("Fungames.name").replaceAll("&", "§"))){
			openMenu(e.getPlayer());
			}
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		if (main.getConfig().getBoolean("give-on-join", true)) {
			Player p = e.getPlayer();
			ItemStack fg = new ItemBuilder(Material.CHEST,1,0).setDisplayname(main.getConfig().getString("Fungames.name").replaceAll("&", "§")).build();
			p.getInventory().setItem(main.getConfig().getInt("Fungames.slot"), fg);
		}
	}
	
	public void openMenu(InventoryHolder player) {
		Player p = (Player)player;
		
		if (!(((Player) p).hasPermission(main.getConfig().getString("Fungames.permission")))) {
			p.sendMessage(main.getConfig().getString("noperm").replace("%prefix%", main.getConfig().getString("prefix").replaceAll("&", "§")).replaceAll("&", "§"));
			return;
			
		}else {
			Inventory FunGames = main.getServer().createInventory(p, 36, main.getConfig().getString("Fungames.menu-name"));
			drawOutline(FunGames);
			ItemStack fungun = new ItemBuilder(Material.BONE,1,0).setDisplayname(main.getConfig().getString("Fungun.name").replaceAll("&", "§")).build();
			ItemStack rod = new ItemBuilder(Material.FISHING_ROD,1,0).setDisplayname(main.getConfig().getString("Rod.name").replaceAll("&", "§")).build();
			ItemStack pearl = new ItemBuilder(Material.ENDER_PEARL,1,0).setDisplayname(main.getConfig().getString("Enderpearl.name").replaceAll("&", "§")).build();
			ItemStack bow = new ItemBuilder(Material.BOW,1,0).setDisplayname(main.getConfig().getString("Bow.name").replaceAll("&", "§")).build();
			ItemStack superstar = new ItemBuilder(Material.NETHER_STAR,1,0).setDisplayname(main.getConfig().getString("Superstar.name").replaceAll("&", "§")).build();
			ItemStack close = new ItemBuilder(Material.BARRIER,0,0).setDisplayname("§cClose").build();
		
			FunGames.setItem(13, fungun);
			FunGames.setItem(15, rod);
			FunGames.setItem(11, pearl);
			FunGames.setItem(21, bow);
			FunGames.setItem(23, superstar);
			FunGames.setItem(31, close);
			p.openInventory(FunGames);
	}
	}
	
	@SuppressWarnings("deprecation")
	public void drawOutline(Inventory inventory){
		ItemStack glass = new ItemBuilder(Material.STAINED_GLASS_PANE, 1, DyeColor.BLACK.getData()).setDisplayname(" ").build(); //.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_DESTROYS, ItemFlag.HIDE_PLACED_ON)
		for (int i = 0; i < inventory.getSize(); i++) {
            if(i<=9 || i==17||i==18||i==26 || i>=27&&i<=35){
				inventory.setItem(i, glass);
             }
        }
    }
	
	
	
	@EventHandler
	public void onClickShop(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		PlayerInventory pi = e.getWhoClicked().getInventory();	
		int slot = e.getSlot();
		FileConfiguration config = main.getConfig();
		
		if (e.getInventory().getName() == config.getString("Fungames.menu-name")) {e.setCancelled(true);}

		if (slot == 13) {
			if (e.getClickedInventory().getName() == config.getString("Fungames.menu-name")) {
				ItemStack fungun = new ItemBuilder(Material.BONE,1,0).setDisplayname(main.getConfig().getString("Fungun.name").replaceAll("&", "§")).build();
				pi.setItem(config.getInt("Fungun.slot"), fungun);
				p.closeInventory();
			}
		}
		
		if (slot == 15) {
			if (e.getClickedInventory().getName() == config.getString("Fungames.menu-name")) {
				if (p.hasPermission("fungames.rod")) {
					
					for (ItemStack items : e.getInventory().getContents()) {
						if (!(items.getItemMeta().getLore().contains("FunGame"))) {
							
							ItemStack rod = new ItemBuilder(Material.FISHING_ROD,1,0).setDisplayname(main.getConfig().getString("Rod.name").replaceAll("&", "§")).setLore("FunGame").build();
							pi.setItem(config.getInt("Rod.slot"), rod);
							p.closeInventory();
						
						}else {
							ItemStack rod = new ItemBuilder(Material.FISHING_ROD,1,0).setDisplayname(main.getConfig().getString("Rod.name").replaceAll("&", "§")).setLore("FunGame").build();
							items.setAmount(0);
							pi.setItem(config.getInt("Rod.slot"), rod);
							p.closeInventory();
							
						}
					}
				}
			}
		}
		
	}
}

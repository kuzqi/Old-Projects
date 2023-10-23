package Main;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.inventory.EnchantingInventory;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import Listener.PlayerDeath;
import Listener.PlayerDrop;
import Listener.PlayerRespawn;
import Listener.PlayerSettings;
import Shop.GoldShop;
import Shop.ShopCMD;
import Shop.ShopSettings;
import Shop.SwordsSettings;

public class Main extends JavaPlugin implements Listener {
	  public ArrayList<EnchantingInventory> inventories;
	  
		public static Main getInstance() {
			return Main.getPlugin(Main.class);
		}
		
  @Override
  public void onEnable() {
    //  ---------------------  //
	if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
		Bukkit.getPluginManager().registerEvents(this, this);
	 	}else{ getLogger().warning("Could not find PlaceholderAPI! This plugin is required."); Bukkit.getPluginManager().disablePlugin(this);}
    //  ---------------------  //
	Bukkit.getServer().getConsoleSender().sendMessage("§8┃ §4§lRedStone§c§lPvP §8» §2§lEnabled! By O16");
    this.inventories = new ArrayList<>();
    getServer().getPluginManager().registerEvents(new Enchantment(this), this);	
    //  ---------------------  //
    getCommand("ranks").setExecutor(new CMD(this));
    getCommand("trash").setExecutor(new CMD(this));
    getCommand("iixxxMINERxxxii").setExecutor(new CMD(this));
    getCommand("iixxxWARPSxxxii").setExecutor(new CMD(this));
    //  ---------------------
    getCommand("iixxxSHOPxxxii").setExecutor(new ShopCMD(this));
    //  ---------------------
    register(new PlayerDeath(),this);
    register(new PlayerDrop(),this);
    register(new PlayerRespawn(),this);
    register(new PlayerSettings(),this);
    //  ---------------------
    register(new ScoreBoard(),this);
    //  ---------------------
    register(new Converters(),this);
    register(new Anvil(),this);
    register(new Miner(),this);
    //  ---------------------
    register(new GoldShop(),this);
    register(new ShopSettings(),this);
    register(new SwordsSettings(),this);
    //  ---------------------
    
  }
  
  public void register(Listener listner, Plugin plugin) {
	  getServer().getPluginManager().registerEvents(listner, plugin);
  }
  
  public void onDisable() {
	Bukkit.getServer().getConsoleSender().sendMessage("§8┃ §4§lRedStone§c§lPvP §8» §4§lDisabled! By O16");
	for (EnchantingInventory ei : this.inventories)
	  ei.setItem(1, null); 
	  this.inventories = null;
  }
}
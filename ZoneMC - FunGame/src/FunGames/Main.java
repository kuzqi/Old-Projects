package FunGames;

import org.bukkit.plugin.java.JavaPlugin;

import FunGames.Games.Bow;
import FunGames.Games.FunGun;
import FunGames.Games.Pearl;
import FunGames.Games.Rod;
import FunGames.Games.SuperStar;
import FunGames.Listeners.FunGameListener;
import FunGames.Menu.Menu;

public class Main extends JavaPlugin {
	

	public void onEnable(){
		getServer().getConsoleSender().sendMessage("§b§lZONE§f§lMC §8» §a§lThe plugin has been enabled! [ By O16#6006 ]");
		register();
	}
	
	public void onDisable(){
		getServer().getConsoleSender().sendMessage("§b§lZONE§f§lMC §8» §4§lThe plugin has been disabled! [ By O16#6006 ]");
		
	}
	
	public void register() {
		getServer().getPluginManager().registerEvents(new FunGun(this),this);
		getServer().getPluginManager().registerEvents(new SuperStar(this),this);
		getServer().getPluginManager().registerEvents(new Rod(),this);
		getServer().getPluginManager().registerEvents(new Bow(),this);
		getServer().getPluginManager().registerEvents(new Pearl(),this);
		getServer().getPluginManager().registerEvents(new Menu(),this);
		getServer().getPluginManager().registerEvents(new FunGameListener(),this);
	}
}

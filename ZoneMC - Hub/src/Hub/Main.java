package Hub;

import org.bukkit.plugin.java.JavaPlugin;

import Hub.Listeners.JoinListener;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
        getServer().getConsoleSender().sendMessage("§aThe plugin has been enabled!");
        getServer().getPluginManager().registerEvents(new JoinListener(), this);  

	}
	
	
	@Override
	public void onDisable() {
		getServer().getConsoleSender().sendMessage("§cThe plugin has been disabled!");
	}

}

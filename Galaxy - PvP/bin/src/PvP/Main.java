package PvP;

import java.util.ArrayList;

import org.bukkit.plugin.java.JavaPlugin;

import com.google.common.collect.Lists;

import PvP.Listeners.DeathListener;
import PvP.Listeners.JoinListener;
import PvP.Listeners.ScoreBoardListener;
import PvP.Listeners.SettingsListener;
import Systems.StaffListeners;
import Systems.StaffCommands.BuildCommand;
import Systems.StaffCommands.InvseeCommand;
import Systems.StaffCommands.VanishCommand;

public class Main extends JavaPlugin {
	
    private static Main instance;
    
	//public MySQL mysql;
	
	//public Map<UUID, PlayerStats> playerStats = Maps.newHashMap();
	
	public ArrayList<String> build = Lists.newArrayList();
	
	public ArrayList<String> vanish = Lists.newArrayList();
	
	@Override
	public void onEnable() {
        //mysql = new MySQL(this);
        
       // try {
        	//mysql.initialazieDatabase();
            
        //} catch (SQLException e) {
            //e.printStackTrace();
           // System.out.println("Could not initialize database.");
        //}
        
		setInstance(this);
        this.saveDefaultConfig();
        
        // Commands
        //getCommand("stats").setExecutor(new StatsCommand(this));
        //getCommand("ps").setExecutor(new PrestigeCommand());
        //getCommand("prestige").setExecutor(new PrestigeCommand());
        //getCommand("addkills").setExecutor(new KillsCommand(this));
        //getCommand("setdeaths").setExecutor(new DeathsCommand(this));
        //getCommand("adddeaths").setExecutor(new DeathsCommand(this));
        //getCommand("resetdeaths").setExecutor(new DeathsCommand(this));
        // Staff
        getCommand("build").setExecutor(new BuildCommand(this));
        getCommand("vanish").setExecutor(new VanishCommand(this));
        getCommand("v").setExecutor(new VanishCommand(this));
        getCommand("invsee").setExecutor(new InvseeCommand(this));
        // Managers
        //getServer().getPluginManager().registerEvents(new PrestigeManager(this), this);
        //getServer().getPluginManager().registerEvents(new StatsManager(this), this);
        // Listeners
        getServer().getPluginManager().registerEvents(new DeathListener(), this);
        getServer().getPluginManager().registerEvents(new SettingsListener(), this);
        getServer().getPluginManager().registerEvents(new JoinListener(), this);
        getServer().getPluginManager().registerEvents(new StaffListeners(this), this);
        getServer().getPluginManager().registerEvents(new ScoreBoardListener(), this);
	}
	
	
	@Override
	public void onDisable() {
		
	}
	
    public static Main getInstance() {
        return instance;
    }
    
    private static void setInstance(Main instance) {
        Main.instance = instance;
    }

}

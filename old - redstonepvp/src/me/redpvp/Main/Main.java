package me.redpvp.Main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.inventory.EnchantingInventory;
import org.bukkit.plugin.java.JavaPlugin;

import com.google.common.collect.Maps;

import Player.PlayerDeath;
import Player.PlayerSettings;
import System.CMDs.BuildCMDs;
import System.CMDs.MemberCMDs;
import System.CMDs.StaffCMDs;
import System.CMDs.VanishCMDs;
import dev.devo.stats.StatsManager;
import dev.o16.stats.Commands.StatsCommand;
import dev.o16.stats.DataBase.Database;
import dev.o16.stats.DataBase.PlayerStats;
import dev.o16.stats.Managers.KillsManager;
import dev.o16.stats.Managers.PrestigeManager;
import dev.o16.stats.Managers.StreaksManager;
import me.redpvp.CMDs;
import me.redpvp.RedPvP.Anvil;
import me.redpvp.RedPvP.Converter;
import me.redpvp.RedPvP.Enchant;
import me.redpvp.RedPvP.Miner;
import me.redpvp.RedPvP.ScoreBoard;

public final class Main extends JavaPlugin {
	
	  public List<String> build = new ArrayList<>();
	  public List<String> vanish = new ArrayList<>();
	  
	public Database database;
	public ArrayList<EnchantingInventory> inventories;
	public Map<UUID, PlayerStats> playerStats = Maps.newHashMap();
	public Map<UUID, Integer> streaks = Maps.newHashMap();
	
	@Override
    public void onEnable() {
		this.saveDefaultConfig();
		
        System.out.println("Plugin started...");
        database = new Database(this);
        
        try {
            database.initialazieDatabase();
            
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Could not initialize database.");
        }

        //  Player events
        getServer().getPluginManager().registerEvents(new PlayerDeath(this), this);
        getServer().getPluginManager().registerEvents(new PlayerSettings(this), this);
        
        // RedPvP Addons
        getServer().getPluginManager().registerEvents(new Enchant(this), this);
        getServer().getPluginManager().registerEvents(new Miner(this), this);
        getServer().getPluginManager().registerEvents(new Anvil(), this);
        getServer().getPluginManager().registerEvents(new Converter(), this);
        getServer().getPluginManager().registerEvents(new ScoreBoard(this), this);
        
        // Managers 
        getServer().getPluginManager().registerEvents(new StatsManager(this), this);
        getServer().getPluginManager().registerEvents(new StreaksManager(this), this);
        getServer().getPluginManager().registerEvents(new KillsManager(this), this);
        getServer().getPluginManager().registerEvents(new PrestigeManager(this), this);
        
        // CMDs
        getCommand("ranks").setExecutor(new CMDs(this));
        getCommand("stats").setExecutor(new StatsCommand(this));
        getCommand("trash").setExecutor(new CMDs(this));
        
        //  -----======= [ SYSTEM COMMANDS ] =======-----
		getCommand("gmc").setExecutor(new StaffCMDs(this));
		getCommand("gms").setExecutor(new StaffCMDs(this));
	    getCommand("build").setExecutor(new BuildCMDs(this));
	    getCommand("invsee").setExecutor(new StaffCMDs(this));
	    getCommand("v").setExecutor(new VanishCMDs(this));
	    getCommand("discord").setExecutor(new MemberCMDs());
	    getCommand("website").setExecutor(new MemberCMDs());
	    getCommand("store").setExecutor(new MemberCMDs());
	    getCommand("help").setExecutor(new MemberCMDs());
	    getCommand("ping").setExecutor(new MemberCMDs());
	    //  -----======= [ SYSTEM COMMANDS ] =======-----
    }
	
	@Override
	public void onDisable() {
		for (EnchantingInventory ei : this.inventories)
			ei.getItem(1).setType(Material.AIR);
			this.inventories = null;
			System.out.println("Plugin has been disabled.");
  }
}
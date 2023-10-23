package dev.o16.stats.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import me.redpvp.Main.Main;

public class Database {

	public Main main;
	public Database(Main main) {
		this.main = main;
	}
	
	private Connection connection;
	
	public Connection getConnection() throws SQLException {
		
		if (connection != null) {
			return connection;
		}
		
		String user = main.getConfig().getString("mysql.username");
		String pass = main.getConfig().getString("mysql.password");
		String url = main.getConfig().getString("mysql.address");
		String database = main.getConfig().getString("mysql.database");
		
			this.connection = DriverManager.getConnection("jdbc:mysql://" +url+ "/" +database, user, pass);
			System.out.println("connected to the database.");
			
			return this.connection;
	}
	
	public void initialazieDatabase() throws SQLException {
		
		String sql = "CREATE TABLE IF NOT EXISTS player_stats(uuid varchar(36) primary key, kills int, deaths int, stars int, prestige varchar(32))";
		Statement statment = getConnection().createStatement();
		System.out.println("connected to the stats table in the database.");
		statment.execute(sql);
		statment.close();
	}
	
	public PlayerStats getPlayerStats(UUID uuid){
		
		try {
			Statement statement = getConnection().createStatement();
			String sql = "SELECT * FROM player_stats WHERE uuid =\"" +uuid+"\"";
			ResultSet results = statement.executeQuery(sql);

			if (results.next()) {
				
				int kills = results.getInt("kills");
				int deaths = results.getInt("deaths");
				int stars = results.getInt("stars");
				String prestige = results.getString("prestige");
				results.close();
				statement.close();
				return new PlayerStats(uuid, kills, deaths, stars, prestige);
			}
			results.close();
			statement.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	

    public void createPlayerStats(UUID uuid){

       
        try {
        	PreparedStatement statement = getConnection()
                    .prepareStatement("INSERT INTO player_stats(uuid, kills, deaths, stars, prestige) VALUES (?, ?, ?, ?, ?)");
            statement.setString(1, uuid.toString());
            statement.setInt(2, 0);
            statement.setInt(3, 0);
            statement.setInt(4, 0);
            statement.setString(5, null);
            statement.executeUpdate();
            statement.close();
            System.out.println("created");
		} catch (SQLException e) {
			e.printStackTrace();
		}
       

    }
    
    public boolean hasStats(UUID uuid) {
    	try {
			Statement statement = getConnection().createStatement();
			String sql = "SELECT * FROM player_stats WHERE uuid=\""+uuid.toString()+"\"";
			ResultSet results = statement.executeQuery(sql);
			if (results.next()) {
                statement.close();
                results.close();
                System.out.println("had");
                return true;
            } else {
                statement.close();
                results.close();
                System.out.println("doesn't have");
                return false;
            }
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
    }
    
    public synchronized void saveStats(UUID uuid) {
        PlayerStats profile = main.playerStats.get(uuid);
        try {
            PreparedStatement statement = getConnection()
                    .prepareStatement("UPDATE player_stats SET kills = ?, deaths = ?, stars = ?, prestige = ? WHERE uuid = ?");
            statement.setInt(1, profile.getKills());
            statement.setInt(2, profile.getDeaths());
            statement.setInt(3, profile.getstars());
            statement.setString(4, profile.getPrestige());
            statement.setString(5, uuid.toString());
            statement.executeUpdate();
            statement.close();
            main.getServer().getConsoleSender().sendMessage("§aCached"+main.getServer().getPlayer(uuid).getName()+"'s stats!");
        } catch (SQLException e) {
        	main.getServer().getConsoleSender().sendMessage("§cCouldn't cache "+main.getServer().getPlayer(uuid).getName()+"'s stats");
            e.printStackTrace();
        }
    }
    
}

package PvP.MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import PvP.Main;


public class MySQL {

	private final Main main;
	public MySQL(Main main) {
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
		
		String sql = "CREATE TABLE IF NOT EXISTS player_stats("
			+ "uuid varchar(36) primary key, kills int, deaths int, points int, coins int, prestige varchar(32))";
		
		Statement statment = getConnection().createStatement();
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
				int points = results.getInt("points");
				int coins = results.getInt("coins");
				String prestige = results.getString("prestige");
				
				results.close();
				statement.close();
				return new PlayerStats(uuid, kills, deaths, points, coins, prestige);
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
        	PreparedStatement statement = this.getConnection().prepareStatement("INSERT INTO player_stats"
        		+ "(uuid, kills, deaths, points, coins, prestige)"
        		+ " VALUES (?, ?, ?, ?, ?, ?)");
        	
            statement.setString(1, uuid.toString()); // uuid
            statement.setInt(2, 0); // kills 
            statement.setInt(3, 0); // deaths
            statement.setInt(4, 0); // points
            statement.setInt(5, 100); // coins
            statement.setString(6, "UNRANKED"); // prestige 
            
            statement.executeUpdate();
            statement.close();
            
		}catch (SQLException e) {
			e.printStackTrace();
		}
       

    }


    public boolean hasStats(UUID uuid) {
    	try {
    		
			Statement statement = this.getConnection().createStatement();
			String sql = "SELECT * FROM player_stats WHERE uuid=\""+uuid.toString()+"\"";
			ResultSet results = statement.executeQuery(sql);
			
			if (results.next()) {
                statement.close();
                results.close();
                return true;
                
            } else {
                statement.close();
                results.close();
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
            .prepareStatement("UPDATE player_stats SET "
            + "kills = ?, deaths = ?, points = ?, coins = ?"
            + ", prestige = ? WHERE uuid = ?");
            
            statement.setInt(1, profile.getKills());
            statement.setInt(2, profile.getDeaths());
            statement.setInt(3, profile.getPoints());
            statement.setInt(4, profile.getCoins());
            statement.setString(7, profile.getPrestige());
            statement.setString(8, uuid.toString());
            
            statement.executeUpdate();
            statement.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}

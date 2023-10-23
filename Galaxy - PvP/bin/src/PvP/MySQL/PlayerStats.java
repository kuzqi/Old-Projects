package PvP.MySQL;

import java.util.UUID;

public class PlayerStats {

	private UUID uuid;
	
	private int kills;
	
	private int deaths;
	
	private int points;
	
	private int coins;
	
	private String prestige;
	
	public PlayerStats(UUID uuid, int kills, int deaths, int points, int coins, String prestige) {
		this.uuid = uuid;
		this.kills = kills;
		this.deaths = deaths;
		this.points = points;
		this.coins = coins;
		this.prestige = prestige;
	}
	
    public UUID getUUID() {
        return uuid;
    }
    
    public int getDeaths() {
        return deaths;
    }
	
    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getKills() {
        return kills;
    }
	
    public void setKills(int kills) {
        this.kills = kills;
    }
	
    public int getPoints() {
        return points;
    }
	
    public void setPoints(int points) {
        this.points = points;
    }
    
    public int getCoins() {
        return coins;
    }
	
    public void setCoins(int coins) {
        this.coins = coins;
    }
    
    public String getPrestige() {
    	return this.prestige;
    }
    
    public void setPrestige(String prestige) {
    	this.prestige = prestige;
    }
}
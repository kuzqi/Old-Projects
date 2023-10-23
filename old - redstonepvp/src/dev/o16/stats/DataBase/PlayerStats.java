package dev.o16.stats.DataBase;

import java.util.UUID;

public class PlayerStats {

	private UUID uuid;
	private int kills;
	private int deaths;
	private int stars;
	private String prestige;
	
	public PlayerStats(UUID uuid, int kills, int deaths, int stars, String prestige) {
		this.uuid = uuid;
		this.kills = kills;
		this.deaths = deaths;
		this.stars = stars;
		this.prestige = prestige;
	}
	
	
    public UUID getPlayerUUID() {
        return uuid;
    }
	
    public String getPrestige() {
    	return this.prestige;
    }
    public void setPrestige(String prestige) {
    	this.prestige = prestige;
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
    
    
	
    public int getstars() {
        return stars;
    }
	
    public void setstars(int stars) {
        this.stars = stars;
    }
    
    
}
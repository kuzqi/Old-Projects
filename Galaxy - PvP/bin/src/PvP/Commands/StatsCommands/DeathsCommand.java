package PvP.Commands.StatsCommands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import PvP.Main;

public class DeathsCommand implements CommandExecutor{

	private final Main main;
	public DeathsCommand(Main main) {
		this.main = main;
	}
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String command, String[] args) {
		
		if (command.equalsIgnoreCase("adddeaths")) {
			  if (cs instanceof Player) {
			    Player player = (Player) cs;
				
			    if (player.hasPermission("pvp.adddeaths")) {
			      if (args.length == 2) {
			        Player target = player.getServer().getPlayer(args[0]); 
					
			        if (target != null) {
			          try {
			            int amount = Integer.parseInt(args[1]);
			            int oldDeaths = main.playerStats.get(target.getUniqueId()).getDeaths();
			            main.playerStats.get(target.getUniqueId()).setDeaths(oldDeaths + amount);
			            main.mysql.saveStats(target.getUniqueId());
			            
			          } catch (NumberFormatException e) {
			            player.sendMessage("§8┃ §3✪ §8┃§r §cInvalid number provided for deaths.");
			          }
			        } else {
			          player.sendMessage("§8┃ §3✪ §8┃§r §cPlayer $args[0] not found.");
			        }
			      } else {
			        player.sendMessage("§8┃ §3✪ §8┃§r §cUsage: §7/adddeaths <player> <amount>");
			      }
			    } else {
			      player.sendMessage(main.getConfig().getString("no-permission").replaceAll("&", "§"));
			    }
			  } else {
			    cs.sendMessage("§8┃ §3✪ §8┃§r §4This command can only be executed by a player.");
			  }
			}
		
		
		if (command.equalsIgnoreCase("setdeaths")) {
			if (cs instanceof Player) {
				Player p = (Player) cs;
				
				if (p.hasPermission("pvp.setdeaths")) {
					if (args.length == 1) {
						
						Player target = p.getServer().getPlayer(args[0]); 
						if (target != null) {
							
							int amount = Integer.parseInt(args[1]);
							main.playerStats.get(target.getUniqueId()).setDeaths(amount);
							main.mysql.saveStats(p.getUniqueId());
							
							try {
							} catch (NumberFormatException e) {
								p.sendMessage("§8┃ §3✪ §8┃§r §cInvalid number provided for deaths.");
							}
							
						} else {
							p.sendMessage("§8┃ §3✪ §8┃§r §cPlayer not found.");
						}
						
					} else {
						p.sendMessage("§8┃ §3✪ §8┃§r §cUsage: §7/setdeaths <player> <amount>");
					}
					
				} else {
					p.sendMessage(main.getConfig().getString("no-permission").replaceAll("&", "§"));
				}
				
			} else {
				cs.sendMessage("§8┃ §3✪ §8┃§r §4This command can only be executed by a player.");
			}
		}
		
		if (command.equalsIgnoreCase("resetdeaths")) {
			if (cs instanceof Player) {
				Player p = (Player) cs;
				
				if (p.hasPermission("pvp.resetdeaths")) {
					if (args.length == 1) {
						
						Player target = p.getServer().getPlayer(args[0]); 
						if (target != null) {
							
							main.playerStats.get(target.getUniqueId()).setDeaths(0);
							main.mysql.saveStats(p.getUniqueId());
							
						} else {
							p.sendMessage("§8┃ §3✪ §8┃§r §cPlayer not found.");
						}
						
					} else {
						p.sendMessage("§8┃ §3✪ §8┃§r §cUsage: §7/resetdeaths <player>");
					}
					
				} else {
					p.sendMessage(main.getConfig().getString("no-permission").replaceAll("&", "§"));
				}
				
			} else {
				cs.sendMessage("§8┃ §3✪ §8┃§r §4This command can only be executed by a player.");
			}
		}
		
		return true;
	}


}

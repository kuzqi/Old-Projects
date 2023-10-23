package me.o16.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.model.user.User;

public class RankCommand implements CommandExecutor {

	LuckPerms lp = Bukkit.getServicesManager().getRegistration(LuckPerms.class).getProvider();
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String command, String[] args) {
		
		if (command.equalsIgnoreCase("setrank")) {
			if (cs instanceof Player) {
				if (args.length != 0) {
					if (args.length == 2) {
						Player p = (Player) cs;
						Player target = p.getServer().getPlayer(args[0]); 
						
						if (target != null) {
							if (!(args[1].isEmpty())){
									if (args[1].equalsIgnoreCase("member") 
									 || args[1].equalsIgnoreCase("vip")
									 ||	args[1].equalsIgnoreCase("special")
									 ||	args[1].equalsIgnoreCase("elite")){
										
										if (args[1].equalsIgnoreCase("member")) {
											
										User user = lp.getUserManager().getUser(target.getUniqueId());
										user.setPrimaryGroup("member");
										lp.getUserManager().saveUser(user);
										
										}
										
										if (args[1].equalsIgnoreCase("vip")) {
											
											User user = lp.getUserManager().getUser(target.getUniqueId());
											user.setPrimaryGroup("vip");
											lp.getUserManager().saveUser(user);
											
											}
										
										if (args[1].equalsIgnoreCase("special")) {
											
											User user = lp.getUserManager().getUser(target.getUniqueId());
											user.setPrimaryGroup("special");
											lp.getUserManager().saveUser(user);
											
											}
										
										if (args[1].equalsIgnoreCase("elite")) {
											
											User user = lp.getUserManager().getUser(target.getUniqueId());
											user.setPrimaryGroup("elite");
											lp.getUserManager().saveUser(user);
											
											}
									}
								
							}
						}
					}
				}
			}
		}
		
		return true;
	}
}
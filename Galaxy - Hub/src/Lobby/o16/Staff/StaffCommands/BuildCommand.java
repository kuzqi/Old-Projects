package Lobby.o16.Staff.StaffCommands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import Lobby.Main;

public class BuildCommand implements CommandExecutor {

	private final Main main;
	public BuildCommand(Main main) {
		this.main = main;
	}
	
	 public boolean onCommand(CommandSender sender, Command cmd, String command, String[] args) {
		 String prefix = main.getConfig().getString("prefix").replaceAll("&", "§");
		 
		 if (command.equalsIgnoreCase("build")) {
			 if (!(sender instanceof ConsoleCommandSender)) {
				Player p = (Player) sender;
				if (!p.hasPermission("staff.build")) {
					 p.sendMessage(main.getConfig().getString("messages.no-permission").replaceAll("&", "§"));
					
				}else {
					if (args.length == 1) {
						if (main.getServer().getOnlinePlayers().contains(main.getServer().getPlayer(args[0]))) {
							if (!(main.build.contains(main.getServer().getPlayer(args[0]).getName()))) {
								main.build.add(main.getServer().getPlayer(args[0]).getName());
								main.getServer().getPlayer(args[0]).sendMessage("%prefix% §bYour build mode has been §aenabled".replace("%prefix%", prefix)+" §bby §a"+p.getName());
								p.sendMessage("%prefix% §b".replace("%prefix%", prefix)+main.getServer().getPlayer(args[0]).getName()+"'s build mode has been §aenabled");
								
							}else {
								if (main.build.contains(main.getServer().getPlayer(args[0]).getName())) {
									main.build.remove(main.getServer().getPlayer(args[0]).getName());
									main.getServer().getPlayer(args[0]).sendMessage("%prefix% §bYour build mode has been §cdisabled".replace("%prefix%", prefix)+" §bby §c"+p.getName());
									p.sendMessage("%prefix% §b".replace("%prefix%", prefix)+main.getServer().getPlayer(args[0]).getName()+"'s build mode has been §cdisabled");
									
								}
							}
						}else {
							p.sendMessage(main.getConfig().getString("messages.unknown-player").replaceAll("&", "§"));
						}
						
					}else {
						if (args.length == 0) {
							if (!(main.build.contains(p.getName()))) {
								main.build.add(p.getName());
								p.sendMessage("%prefix% §bYour build mode has been §aenabled".replace("%prefix%", prefix));
								
							}else {
								if (main.build.contains(p.getName())) {
									main.build.remove(p.getName());
									p.sendMessage("%prefix% §bYour build mode has been §cdisabled".replace("%prefix%", prefix));
									
								}
							}
						}else {
							p.sendMessage(main.getConfig().getString("messages.invaild-usage").replaceAll("&", "§"));
						}
					}
				}
				
			 }else {
				 if (args.length == 1) {
						if (main.getServer().getOnlinePlayers().contains(main.getServer().getPlayer(args[0]))) {
							if (!(main.build.contains(main.getServer().getPlayer(args[0]).getName()))) {
								main.build.add(main.getServer().getPlayer(args[0]).getName());
								main.getServer().getPlayer(args[0]).sendMessage("%prefix% §bYour build mode has been §aenabled".replace("%prefix%", prefix)+" §bby §a"+sender.getName());
								sender.sendMessage("%prefix% §b".replace("%prefix%", prefix)+main.getServer().getPlayer(args[0]).getName()+"'s build mode has been §aenabled");
								
							}else {
								if (main.build.contains(main.getServer().getPlayer(args[0]).getName())) {
									main.build.remove(main.getServer().getPlayer(args[0]).getName());
									main.getServer().getPlayer(args[0]).sendMessage("%prefix% §bYour build mode has been §cdisabled".replace("%prefix%", prefix)+" §bby §c"+sender.getName());
									sender.sendMessage("%prefix% §b".replace("%prefix%", prefix)+main.getServer().getPlayer(args[0]).getName()+"'s build mode has been §cdisabled");
									
								}
							}
						}else {
							sender.sendMessage(main.getConfig().getString("messages.unknown-player").replaceAll("&", "§"));
						}
						
					}else {
						sender.sendMessage(main.getConfig().getString("messages.invaild-usage").replaceAll("&", "§"));
					}
			 }
		 }
		 
		return true;
	 }
	 
	 public void enableBuild(Player p) {
		main.build.add(p.getName());
		p.sendMessage("%prefix% §aBuild mode has been enabled!".replace("%prefix%", main.getConfig().getString("prefix").replaceAll("&", "§")));
			 
	  }
		 
	 public void disableBuild(Player p) {
		main.build.remove(p.getName());
		p.sendMessage("%prefix% §cBuild mode has been disabled!".replace("%prefix%", main.getConfig().getString("prefix").replaceAll("&", "§")));
	 }
	 
}

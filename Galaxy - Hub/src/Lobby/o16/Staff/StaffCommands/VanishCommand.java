package Lobby.o16.Staff.StaffCommands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import Lobby.Main;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;

public class VanishCommand implements CommandExecutor {
	
	private final Main main;
	public VanishCommand(Main main) {
		this.main = main;
	}

	@SuppressWarnings("rawtypes")
	public boolean onCommand(CommandSender cs, Command cmd, String command, String[] args) {
		 String prefix = main.getConfig().getString("prefix").replaceAll("&", "§");
		 if (command.equalsIgnoreCase("v") || command.equalsIgnoreCase("vanish")) {
			 if (cs instanceof Player) {
				 if (!(cs.hasPermission("staff.vanish"))) {
					 cs.sendMessage(main.getConfig().getString("messages.no-permission").replaceAll("&", "§"));
					 
			}else {
				if (args.length == 1) {
					if (main.getServer().getOnlinePlayers().contains(main.getServer().getPlayer(args[0]))) {
						if (!(main.vanish.contains(main.getServer().getPlayer(args[0]).getName()))) {
							main.vanish.add(main.getServer().getPlayer(args[0]).getName());
							PacketPlayOutTitle vanish = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE,(IChatBaseComponent)IChatBaseComponent.ChatSerializer.a(""), 0, 999999999,0);
							cs.sendMessage("%prefix% §aYou have enabled vanish mode for".replace("%prefix%", prefix)+ " §b"+main.getServer().getPlayer(args[0]).getName());
							main.getServer().getPlayer(args[0]).sendMessage("%prefix% §aYour vanish has been enabled by".replace("%prefix%", prefix)+ " §b"+cs.getName());
							main.getServer().getPlayer(args[0]).setGameMode(GameMode.SPECTATOR);
							main.getServer().getPlayer(args[0]).setAllowFlight(true);
							main.getServer().getPlayer(args[0]).teleport(main.getServer().getPlayer(args[0]).getWorld().getSpawnLocation());
							(((CraftPlayer) main.getServer().getPlayer(args[0])).getHandle()).playerConnection.sendPacket((Packet) vanish);
							for (Player online : main.getServer().getOnlinePlayers()) {
								online.hidePlayer(main.getServer().getPlayer(args[0]));
							}
							
						}else {
							main.vanish.remove(main.getServer().getPlayer(args[0]).getName());
							PacketPlayOutTitle visible = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE,(IChatBaseComponent) IChatBaseComponent.ChatSerializer.a("{\"text\":\"Have Become Visible\"}"), 20, 30,20);
							cs.sendMessage("%prefix% §cYou have disabled vanish mode for".replace("%prefix%", prefix)+ " §b"+main.getServer().getPlayer(args[0]).getName());
							main.getServer().getPlayer(args[0]).sendMessage("%prefix% §cYour vanish has been disabled by".replace("%prefix%", prefix)+ " §b"+cs.getName());
							main.getServer().getPlayer(args[0]).setGameMode(GameMode.ADVENTURE);
							main.getServer().getPlayer(args[0]).setAllowFlight(false);
							main.getServer().getPlayer(args[0]).teleport(main.getServer().getPlayer(args[0]).getWorld().getSpawnLocation());
							(((CraftPlayer) main.getServer().getPlayer(args[0])).getHandle()).playerConnection.sendPacket((Packet) visible);
							for (Player online : main.getServer().getOnlinePlayers()) {
								online.showPlayer(main.getServer().getPlayer(args[0]));
							}
							
						}
						
					}else {
						cs.sendMessage(main.getConfig().getString("messages.unknown-player").replaceAll("&", "§"));
					}
					
				}else {
					if (args.length == 0) {
						Player p = (Player)cs;
						if (!(main.vanish.contains(p.getName()))) {
							main.vanish.add(p.getName());
							PacketPlayOutTitle vanish = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE,(IChatBaseComponent)IChatBaseComponent.ChatSerializer.a(""), 0, 999999999,0);
							p.sendMessage("%prefix% §aYour vanish mode has been enabled!".replace("%prefix%", prefix));
							p.setGameMode(GameMode.SPECTATOR);
							p.setAllowFlight(true);
							p.teleport(p.getWorld().getSpawnLocation());
							
							(((CraftPlayer)(p)).getHandle()).playerConnection.sendPacket((Packet) vanish);
							for (Player online : main.getServer().getOnlinePlayers()) {
								online.hidePlayer(p);
							}
							
						}else {
							if (main.vanish.contains(p.getName())) {
								main.vanish.remove(p.getName());
								PacketPlayOutTitle visible = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE,(IChatBaseComponent) IChatBaseComponent.ChatSerializer.a("{\"text\":\"Have Become Visible\"}"), 20, 30,20);
								p.sendMessage("%prefix% §CYour vanish mode has been disabled!".replace("%prefix%", prefix));
								p.setGameMode(GameMode.ADVENTURE);
								p.setAllowFlight(false);
								p.teleport(p.getWorld().getSpawnLocation());

								(((CraftPlayer)(p)).getHandle()).playerConnection.sendPacket((Packet) visible);
								for (Player online : main.getServer().getOnlinePlayers()) {
									online.showPlayer(p);
								}
							}
							}
						
					}else {
						cs.sendMessage(main.getConfig().getString("messages.invaild-usage").replaceAll("&", "§"));
					}
				}
			}
		}else {
			cs.sendMessage(main.getConfig().getString("messages.only-players").replaceAll("&", "§"));
		}
	}
		 
		return true;
	 }
}

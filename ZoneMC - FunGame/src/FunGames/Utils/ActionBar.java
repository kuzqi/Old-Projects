package FunGames.Utils;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;

public class ActionBar {

	public static void send(Player p, String msg) {
		CraftPlayer CraftPlayer = (CraftPlayer) p;
		IChatBaseComponent ChatComponent = ChatSerializer.a("{\"text\": \"" + msg.replaceAll("&", "§") + "\"}");
		PacketPlayOutChat Packet2 = new PacketPlayOutChat(ChatComponent, (byte) 2);
		CraftPlayer.getHandle().playerConnection.sendPacket(Packet2);
	}
}

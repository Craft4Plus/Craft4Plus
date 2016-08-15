package com.craft4plus.Utils.Bars;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_10_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_10_R1.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_10_R1.PacketPlayOutChat;

public class ActionBar {
	
	//TO USE ACTIONBAR ADD:
	//ActionBar actionBar = new ActionBar("Text Here");
    //actionBar.sendToPlayer(player);
	
	private PacketPlayOutChat packet;

	public void Actionbar(String text) {
		PacketPlayOutChat packet = new PacketPlayOutChat(ChatSerializer.a("{\"text\":\"" + text + "\"}"), (byte) 2);

		this.packet = packet;
	}

	public void sendToPlayer(Player p) {

		((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);

	}
	
    public void sendToAll() {
        for (Player p : Bukkit.getServer().getOnlinePlayers()) {
            ((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);;
        }
    }

}

package com.craft4plus.listeners;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

import com.craft4plus.minigames.parkour.Parkour;

public class PlayerWorldChange implements Listener {
	
	@EventHandler
	public void onPlayerWorldChange (PlayerChangedWorldEvent event) {
		
		Player player = event.getPlayer();
		World world = player.getWorld();
		
		Parkour.removeFromLists(player.getName());
		
		if (world.getName() == "BuildWorld") {
			world.setTime(6000);
		}
		
	}

}

package com.craft4plus.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import com.craft4plus.listeners.PlayerJoin;
import com.craft4plus.minigames.parkour.Parkour;

public class PlayerLeave implements Listener {
	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent event) {
		Player player = event.getPlayer();

		if (PlayerJoin.JustJoined(player)) { // Check if player is in the just joined list
			PlayerJoin.RemoveFromJustJoined(player); // Remove him
		}
		
		Parkour.removeFromLists(player.getName());

	}

}
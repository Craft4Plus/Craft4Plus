package com.craft4plus.listeners;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

	static List<String> PlayerJustJoined = new ArrayList<String>(); // List that will hold all the players that just joined
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();

		PlayerJustJoined.add(player.getName()); // Add name to list of players
												// that just joined.

		new java.util.Timer().schedule(new java.util.TimerTask() {
			@Override
			public void run() {
				if (PlayerJustJoined.contains(player.getName())) { // Check
																	// if
																	// player
																	// is
																	// still
																	// list
					PlayerJustJoined.remove(player.getName()); // Remove
																// after
																// ten
																// seconds
				}
			}
		}, 10000 // This is 10 seconds BTW :P
		);

	}

	public static boolean JustJoined(Player player){ // Boolean that we can access from any class as long as you specify player.
		if(PlayerJustJoined.contains(player.getName()) && (PlayerJustJoined != null)) { // Check if player is in list and list isn't null.
			return true;
		}
		return false;
	}
	
	public static boolean RemoveFromJustJoined(Player player){ // Boolean that we can access from any class as long as you specify player.
		if(PlayerJustJoined.contains(player.getName()) && (PlayerJustJoined != null)) { // Check if player is in list and list isn't null.
			PlayerJustJoined.remove(player); // Remove player from list.
			return true;
		}
		return false;
	}
	
}

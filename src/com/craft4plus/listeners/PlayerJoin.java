package com.craft4plus.listeners;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

	private List<String> PlayerJustJoined;

	// TO USE IN OTHER CLASSES:
	// import java.util.List;
	// import com.craft4plus.checks.PlayerJoin;
	//
	// private PlayerJoin PlayerJustJoinedList;
	//
	// public void/boolean/whatever whatever(whatever) {
	//
	// PlayerJustJoinedList = new PlayerJoin();
	// List<String> PlayerJustJoined = PlayerJustJoinedList.getList();
	//
	// -Rest Of code-
	//
	// }

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		PlayerJustJoined = new ArrayList<String>();

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

	public List<String> getList() {
		return PlayerJustJoined;
	}

}

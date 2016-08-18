package com.craft4plus.detection;

import java.util.HashSet;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Detection implements Listener {

	HashSet<String> Gamemode0 = new HashSet<String>();
	HashSet<String> Gamemode1 = new HashSet<String>();
	HashSet<String> Gamemode2 = new HashSet<String>();
	HashSet<String> Gamemode3 = new HashSet<String>();

	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		if (player.isOp()) {
			if (player.getGameMode() == GameMode.SURVIVAL) {
				Gamemode0.add(player.getName());
			} else {
				if (player.getGameMode() == GameMode.CREATIVE) {
					Gamemode1.add(player.getName());
				} else {
					if (player.getGameMode() == GameMode.ADVENTURE) {
						Gamemode2.add(player.getName());
					} else {
						if (player.getGameMode() == GameMode.SPECTATOR) {
							Gamemode3.add(player.getName());
						}
					}
				}
			}
		}
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		if (player.isOp()) {
			if (Gamemode0.contains(player.getName())) {
				Gamemode0.remove(player.getName());
				player.setGameMode(GameMode.SURVIVAL);
			} else {
				if (Gamemode1.contains(player.getName())) {
					Gamemode1.remove(player.getName());
					player.setGameMode(GameMode.CREATIVE);
				} else {
					if (Gamemode2.contains(player.getName())) {
						Gamemode2.remove(player.getName());
						player.setGameMode(GameMode.ADVENTURE);
					} else {
						if (Gamemode3.contains(player.getName())) {
							Gamemode3.remove(player.getName());
							player.setGameMode(GameMode.SPECTATOR);
						}
					}
				}
			}
		}
	}
}

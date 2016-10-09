package com.craft4plus.afksystem;

import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import com.craft4plus.main.Main;

import net.ess3.api.IUser;
import net.ess3.api.events.AfkStatusChangeEvent;

public class AFKSystem implements Listener {

	HashMap<String, Location> LocationBeforeAFK = new HashMap<String, Location>();
	HashMap<String, GameMode> GameModeBeforeAFK = new HashMap<String, GameMode>();
	
	@EventHandler (priority = EventPriority.HIGHEST)
	public boolean onAfk(AfkStatusChangeEvent event) {
		
		IUser iuser = event.getAffected(); // User from essentials
		Player player = Bukkit.getServer().getPlayer(iuser.getName()); // Player
		if (player.hasPermission("c4p.afk.elite")) { //Just a permission to prevent everyone from having this
			
			if (!iuser.isAfk()) { // Weird how this works, this is what happens if the player was not afk and just became afk
				LocationBeforeAFK.put(player.getName(), player.getLocation()); // Get the location of the player to store it for later
				GameModeBeforeAFK.put(player.getName(), player.getGameMode()); // Get the GameMode of the player to store it for later
				
				player.teleport(new Location(Bukkit.getWorld("BuildWorld"), 2000, 91, 2000)); // Teleport him to the AFK area
				return true;
				
			} else if (iuser.isAfk()) { // Player stopped being AFK
				
				if ((LocationBeforeAFK.containsKey(player.getName())) && (GameModeBeforeAFK.containsKey(player.getName()))) { // If we've got somewhere to lead this guy back to
					Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() { //Schedule a repeating task
					@Override
					public void run() {
						player.teleport(LocationBeforeAFK.get(player.getName())); // Get that location and telport him
						LocationBeforeAFK.remove(player.getName()); // Remove the location data
						player.setGameMode(GameModeBeforeAFK.get(player.getName())); // Get his previous gamemode
						GameModeBeforeAFK.remove(player.getName()); // Remove the location data
					}
				}, 1L);
				}
				return true;
			}
		} else {
			if (!iuser.isAfk()) { // Weird how this works, this is what happens if the player was not afk and just became afk
				LocationBeforeAFK.put(player.getName(), player.getLocation()); // Get the location of the player to store it for later
				GameModeBeforeAFK.put(player.getName(), player.getGameMode()); // Get the GameMode of the player to store it for later
				
				player.teleport(new Location(Bukkit.getWorld("BuildWorld"), 100000, 70, 10000)); // Teleport him to the AFK area
				return true;
				
			} else if (iuser.isAfk()) { // Player stopped being AFK
				
				if ((LocationBeforeAFK.containsKey(player.getName())) && (GameModeBeforeAFK.containsKey(player.getName()))) { // If we've got somewhere to lead this guy back to
					Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() { //Schedule a repeating task
						@Override
						public void run() {
							player.teleport(LocationBeforeAFK.get(player.getName())); // Get that location and telport him
							LocationBeforeAFK.remove(player.getName()); // Remove the location data
							player.setGameMode(GameModeBeforeAFK.get(player.getName())); // Get his previous gamemode
							GameModeBeforeAFK.remove(player.getName()); // Remove the location data
						}
					}, 1L);
				}
				return true;
			}
		}
		return false;
	}
}
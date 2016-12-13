package com.craft4plus.afksystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import com.craft4plus.main.Main;
import com.craft4plus.miscellaneous.Numbers;

import net.ess3.api.IUser;
import net.ess3.api.events.AfkStatusChangeEvent;

public class AFKSystem implements Listener {

	HashMap<String, Location> LocationBeforeAFK = new HashMap<String, Location>();
	HashMap<String, GameMode> GameModeBeforeAFK = new HashMap<String, GameMode>();
	static HashMap<Location, UUID> LocationsSimple = new HashMap<Location, UUID>();
	static HashMap<Location, UUID> LocationsElite = new HashMap<Location, UUID>();
	
	public static void addLocationsForAFK() {
		// Simple
		LocationsSimple.put(new Location(Bukkit.getWorld("Spawn"), 17.5, 82, -85.5) , null);
		LocationsSimple.put(new Location(Bukkit.getWorld("Spawn"), 94.5, 86, -52.5) , null);
		LocationsSimple.put(new Location(Bukkit.getWorld("Spawn"), 60.5, 80, -28.5) , null);
		LocationsSimple.put(new Location(Bukkit.getWorld("Spawn"), 68.5, 63, -117.5) , null);
		LocationsSimple.put(new Location(Bukkit.getWorld("Spawn"), 36.5, 82, -128.5) , null);
		LocationsSimple.put(new Location(Bukkit.getWorld("Spawn"), 89.5, 94, -114.5) , null);
		LocationsSimple.put(new Location(Bukkit.getWorld("Spawn"), 96.5, 67, -8.5) , null);
		LocationsSimple.put(new Location(Bukkit.getWorld("Spawn"), 15.5, 82, -21.5) , null);
		
		// Elite
		LocationsElite.put(new Location(Bukkit.getWorld("Spawn"), 78.5, 120.5, -39.5) , null);
		LocationsElite.put(new Location(Bukkit.getWorld("Spawn"), 75.5, 128.5, -104.5) , null);
		LocationsElite.put(new Location(Bukkit.getWorld("Spawn"), -10.5, 118.5, -19.5) , null);
		LocationsElite.put(new Location(Bukkit.getWorld("Spawn"), -10.5, 133.5, -101.5) , null);
	}
	
	@EventHandler (priority = EventPriority.HIGHEST)
	public void onAfk(AfkStatusChangeEvent event) {
		
		IUser iuser = event.getAffected(); // User from essentials
		Player player = Bukkit.getServer().getPlayer(iuser.getName()); // Player
		if (player.hasPermission("c4p.afk.elite")) { //Just a permission to prevent everyone from having this
			
			if (!iuser.isAfk()) { // Weird how this works, this is what happens if the player was not afk and just became afk
				addToAFKListElite(player);				
			} else if (iuser.isAfk()) { // Player stopped being AFK
				sendUserBack(player);
			}
		} else {
			if (!iuser.isAfk()) { // Weird how this works, this is what happens if the player was not afk and just became afk
				addToAFKListSimple(player);			
			} else if (iuser.isAfk()) { // Player stopped being AFK
				sendUserBack(player);
			}
		}
	}
	
	public Location nextAvailableAreaSimple(Player player) {
		if (!LocationsSimple.isEmpty()) {
			List<Location> AvailableLocations = new ArrayList<Location>();
			for (Location loc : LocationsSimple.keySet()) {
				if (LocationsSimple.get(loc) == null) {
					AvailableLocations.add(loc);
				}
			}
			Location chosenloc = AvailableLocations.get(Numbers.getRandom(1, AvailableLocations.size()));
			LocationsSimple.put(chosenloc, player.getUniqueId());
			return chosenloc;
		}
		return new Location(Bukkit.getWorld("BuildWorld"), 100000.5, 70, 10000.5);
	}
	
	public void addToAFKListSimple(Player player) {
		LocationBeforeAFK.put(player.getName(), player.getLocation()); // Get the location of the player to store it for later
		GameModeBeforeAFK.put(player.getName(), player.getGameMode()); // Get the GameMode of the player to store it for later
		Location location = nextAvailableAreaSimple(player);
		player.teleport(location); // Teleport him to the AFK area
	}
	
	public Location nextAvailableAreaElite(Player player) {
		if (!LocationsElite.isEmpty()) {
			List<Location> AvailableLocations = new ArrayList<Location>();
			for (Location loc : LocationsElite.keySet()) {
				if (LocationsElite.get(loc) == null) {
					AvailableLocations.add(loc);
				}
			}
			Location chosenloc = AvailableLocations.get(Numbers.getRandom(1, AvailableLocations.size()));
			LocationsElite.put(chosenloc, player.getUniqueId());
			return chosenloc;
		}
		return new Location(Bukkit.getWorld("BuildWorld"), 2000.5, 91, 2000.5);
	}
	
	public void addToAFKListElite(Player player) {
		LocationBeforeAFK.put(player.getName(), player.getLocation()); // Get the location of the player to store it for later
		GameModeBeforeAFK.put(player.getName(), player.getGameMode()); // Get the GameMode of the player to store it for later
		Location location = nextAvailableAreaElite(player);
		player.teleport(location); // Teleport him to the AFK area
	}
	
	public void sendUserBack(Player player) {
		if ((LocationBeforeAFK.containsKey(player.getName())) && (GameModeBeforeAFK.containsKey(player.getName()))) { // If we've got somewhere to lead this guy back to
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() { //Schedule a repeating task
				@Override
				public void run() {
					player.teleport(LocationBeforeAFK.get(player.getName())); // Get that location and telport him
					LocationBeforeAFK.remove(player.getName()); // Remove the location data
				}
			}, 1L);
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() { //Schedule a repeating task
			@Override
			public void run() {
				player.setGameMode(GameModeBeforeAFK.get(player.getName())); // Get his previous gamemode
				GameModeBeforeAFK.remove(player.getName()); // Remove the location data
			}
		}, 3L);
		}
		if (LocationsElite.containsValue(player.getUniqueId())) {
			for (Location loc : LocationsElite.keySet()) {
				LocationsElite.put(loc, null);
			}
		}
		if (LocationsSimple.containsValue(player.getUniqueId())) {
			for (Location loc : LocationsSimple.keySet()) {
				LocationsSimple.put(loc, null);
			}
		}
	}	
}
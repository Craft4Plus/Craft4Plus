package com.craft4plus.minigames.parkour;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class Parkour implements Listener {
	
	
	public static HashMap<String, Integer> parkourprogress = new HashMap<String, Integer>();
	public static HashMap<String, Long> parkourtime = new HashMap<String, Long>();
	public static HashMap<String, String> parkourname = new HashMap<String, String>();

	
	@EventHandler
	public void onPressurePlate(PlayerInteractEvent event) { // When a player interacts with a block

		if (event.getAction() == Action.PHYSICAL) {

			Player player = event.getPlayer();

			if (event.getClickedBlock().getType().equals(Material.GOLD_PLATE)) { // Check if it was a gold pressure plate
				if (isStartingPlate(event.getClickedBlock().getLocation()) != null) { // Check if the location of the block was a starting point for a parkour

					if ((parkourprogress.containsKey(player.getName())) && (parkourtime.containsKey(player.getName())) && (parkourname.containsKey(player.getName()))) { // If the player was already in a parkour course

						if ((System.currentTimeMillis() - (parkourtime.get(player.getName())) > 300)) { // Check if the player had already stepped on the pressure plate by checking if it has been less than 300 milliseconds

							player.sendMessage(ChatColor.GOLD + "Parkour restarted. GO!");

						}
						
						removeFromLists(player.getName());

						parkourprogress.put(player.getName(), 1); // Restart the Parkour Progresss
						parkourtime.put(player.getName(), System.currentTimeMillis()); // Restart the timer
						parkourname.put(player.getName(), isStartingPlate(event.getClickedBlock().getLocation())); // Restart the parkour course name

						event.setCancelled(true); // Cancel the pressure plate click

					} else {

						player.sendMessage(ChatColor.GOLD + "Parkour started. GO!");

						parkourprogress.put(player.getName(), 1); // Restart the Parkour Progress
						parkourtime.put(player.getName(), System.currentTimeMillis()); // Restart the timer
						parkourname.put(player.getName(), isStartingPlate(event.getClickedBlock().getLocation())); // Restart the parkour course name

						event.setCancelled(true); // Cancel the pressure plate click
					}

				} else if (isFinishingPlate(event.getClickedBlock().getLocation()) != null) { // Check if the location of the block was a finishing point for a parkour

					if ((parkourprogress.containsKey(player.getName())) && (parkourtime.containsKey(player.getName())) && (parkourname.containsKey(player.getName()))) { // If the player is already in a parkour course
					
					if (parkourprogress.get(player.getName()) == numberOfCheckpoints(isFinishingPlate(event.getClickedBlock().getLocation()))) { // Check if the player has gone through all the checkpoints

						Date date = new Date(System.currentTimeMillis() - (parkourtime.get(player.getName()))); // Get the date and time
						DateFormat formatter = new SimpleDateFormat("mm:ss:SSS"); // Format it
						String dateFormatted = formatter.format(date); // Make it a string

						player.sendMessage(ChatColor.GOLD + "Congratulations! You finished the parkour course! Time: " + dateFormatted);

						removeFromLists(player.getName()); // Remove the player object from the array lists
						
						event.setCancelled(true); // Cancel the pressure plate click

					} else { // If the player has not gone through all the checkpoints
						
						player.sendMessage(ChatColor.RED + "You didn't go through all the checkpoints!");
						
					}

					}
					
				}

			} else if (event.getClickedBlock().getType().equals(Material.IRON_PLATE)) { // Otherwise, if it's a Iron Pressure plate
				
				if ((parkourprogress.containsKey(player.getName())) && (parkourtime.containsKey(player.getName())) && (parkourname.containsKey(player.getName()))) { // If the player is already in a parkour course
				
				if (isCheckpointPlate(event.getClickedBlock().getLocation()) != 0) { // Check if the location of the block was a checkpoint for a parkour

				if (isCheckpointPlate(event.getClickedBlock().getLocation()) == parkourprogress.get(player.getName())) { // Check if the pressure plate is a checkpoint and the player has gone through the previous checkpoints

					Date date = new Date(System.currentTimeMillis() - (parkourtime.get(player.getName()))); // Get the date and time
					DateFormat formatter = new SimpleDateFormat("mm:ss:SSS"); // Format it
					String dateFormatted = formatter.format(date); // Make it a string

					player.sendMessage(ChatColor.GOLD + "Checkpoint " + parkourprogress.get(player.getName()) + "! Time so far: " + dateFormatted);
					parkourprogress.put(player.getName(), (parkourprogress.get(player.getName()) + 1)); // Add a checkpoint

					event.setCancelled(true); // Cancel the pressure plate click
				} 
					
				}
				
				}

			}
		}
	}
	
	public String isStartingPlate (Location loc) { // Check if the plate is a starting point pressure plate
		if ((loc.getBlockX() == 54) && (loc.getBlockY() == 70) && (loc.getBlockZ() == -50) && (loc.getWorld().getName().equals("Spawn"))) { // Spawn1 starting plate
			return "spawn1";
		}
		
		if ((loc.getBlockX() == -362) && (loc.getBlockY() == 77) && (loc.getBlockZ() == 349) && (loc.getWorld().getName().equals("Survival"))) { // Survival1 starting plate
			return "survival1";
		}
		
		if ((loc.getBlockX() == 9001) && (loc.getBlockY() == 80) && (loc.getBlockZ() == 9001) && (loc.getWorld().getName().equals("BuildWorld"))) { // Parkour1 starting plate
			return "parkour1";
		}
		return null;
	}
	
	public int isCheckpointPlate (Location loc) { // Check if the plate is a checkpoint pressure plate
		if ((loc.getBlockX() == 55) && (loc.getBlockY() == 80) && (loc.getBlockZ() == -46) && (loc.getWorld().getName().equals("Spawn"))) { //Spawn1 checkpoint plates
			return 1;
		}
		if ((loc.getBlockX() == 51) && (loc.getBlockY() == 84) && (loc.getBlockZ() == -47) && (loc.getWorld().getName().equals("Spawn"))) { //Spawn1 checkpoint plates
			return 2;
		}
		if ((loc.getBlockX() == 51) && (loc.getBlockY() == 93) && (loc.getBlockZ() == -47) && (loc.getWorld().getName().equals("Spawn"))) { //Spawn1 checkpoint plates
			return 3;
		}		
		
		if ((loc.getBlockX() == -362) && (loc.getBlockY() == 86) && (loc.getBlockZ() == 352) && (loc.getWorld().getName().equals("Survival"))) { //Survival1 checkpoint plates
			return 1;
		}
		if ((loc.getBlockX() == -365) && (loc.getBlockY() == 87) && (loc.getBlockZ() == 329) && (loc.getWorld().getName().equals("Survival"))) { //Survival1 checkpoint plates
			return 2;
		}
		
		if ((loc.getBlockX() == 9004) && (loc.getBlockY() == 86) && (loc.getBlockZ() == 8997) && (loc.getWorld().getName().equals("BuildWorld"))) { //Parkour1 checkpoint plates
			return 1;
		}
		if ((loc.getBlockX() == 9002) && (loc.getBlockY() == 87) && (loc.getBlockZ() == 9006) && (loc.getWorld().getName().equals("BuildWorld"))) { //Parkour1 checkpoint plates
			return 2;
		}
		if ((loc.getBlockX() == 9003) && (loc.getBlockY() == 92) && (loc.getBlockZ() == 8996) && (loc.getWorld().getName().equals("BuildWorld"))) { //Parkour1 checkpoint plates
			return 3;
		}
		if ((loc.getBlockX() == 8998) && (loc.getBlockY() == 100) && (loc.getBlockZ() == 8997) && (loc.getWorld().getName().equals("BuildWorld"))) { //Parkour1 checkpoint plates
			return 4;
		}
		if ((loc.getBlockX() == 9004) && (loc.getBlockY() == 105) && (loc.getBlockZ() == 9005) && (loc.getWorld().getName().equals("BuildWorld"))) { //Parkour1 checkpoint plates
			return 5;
		}
		
		return 0;
	}
	
	public String isFinishingPlate (Location loc) { // Check if the plate is a finishing point pressure plate and send the parkour course name
		if ((loc.getBlockX() == 52) && (loc.getBlockY() == 106) && (loc.getBlockZ() == -47) && (loc.getWorld().getName().equals("Spawn"))) { //Spawn finishing plate
			return "spawn1";
		}
		
		if ((loc.getBlockX() == -374) && (loc.getBlockY() == 88) && (loc.getBlockZ() == 340) && (loc.getWorld().getName().equals("Survival"))) { //Spawn finishing plate
			return "survival1";
		}
		
		if ((loc.getBlockX() == 9005) && (loc.getBlockY() == 110) && (loc.getBlockZ() == 9005) && (loc.getWorld().getName().equals("BuildWorld"))) { //Spawn finishing plate
			return "parkour1";
		}
		return null;
	}
	
	public int numberOfCheckpoints (String parkourname) { // Get the number of checkpoints (with the finishing point)
		
		if (parkourname == "spawn1") {
			return 4;
		}
		
		if (parkourname == "survival1") {
			return 3;
		}
		
		if (parkourname == "parkour1") {
			return 6;
		}
		return 0;
		
	}
	
	public static void removeFromLists (String playername) { // Remove a player from the array lists
		
		if (parkourprogress.containsKey(playername)) { // Check if the player is in progress
			parkourprogress.remove(playername); // Remove him
		}
		
		if (parkourtime.containsKey(playername)) { // Check if the player is in time
			parkourtime.remove(playername); // Remove him
		}
		
		if (parkourname.containsKey(playername)) { // Check if the player is in parkour name
			parkourname.remove(playername); // Remove him
		}
	}
	
	public static void resetProgress (Player player) {
		if ((parkourprogress.containsKey(player.getName())) && (parkourtime.containsKey(player.getName())) && (parkourname.containsKey(player.getName()))) {
			if (parkourname.get(player.getName()).equals("spawn1")) {
				player.teleport(new Location(Bukkit.getWorld("Spawn"), 53.5, 70, -49.5));
				return;
			}
			if (parkourname.get(player.getName()).equals("survival1")) {
				player.teleport(new Location(Bukkit.getWorld("Survival"), -361.5, 77, 348.5));
				return;
			}
			if (parkourname.get(player.getName()).equals("parkour1")) {
				player.teleport(new Location(Bukkit.getWorld("BuildWorld"), 9001.5, 80, 9000.5));
				return;
			}
		} else {
			player.sendMessage(ChatColor.RED + "You are not currently in a parkour course!");
		}
	}
	
}

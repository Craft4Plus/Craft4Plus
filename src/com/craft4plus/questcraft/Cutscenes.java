package com.craft4plus.questcraft;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import eu.crushedpixel.camerastudio.CameraStudio;

public class Cutscenes {
	
	public static void introCutscene(Player player) {
	
		List<Location> locations = new ArrayList<Location>();
		
		locations.add(new Location(Bukkit.getWorld("BuildWorld"), 3014.5, 86, 2986.5, 49.5F, 31.3F));
		locations.add(new Location(Bukkit.getWorld("BuildWorld"), 2995.5, 74, 2988.5, -40.8F, -5.0F));
		
		try {
			CameraStudio.travel(player, locations, CameraStudio.parseTimeString("1m"), "FAIL", "DONE");
		} catch (ParseException e) {
			player.sendMessage("Error with time parsing");
		}
		
	}

}

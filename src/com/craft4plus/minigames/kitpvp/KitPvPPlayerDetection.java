package com.craft4plus.minigames.kitpvp;

import org.bukkit.entity.Player;

public class KitPvPPlayerDetection {

	public static boolean InSGGame(Player player){ // Boolean that we can access from any class as long as you specify player.
		if (player.getWorld().getName().equals("Spawn")) {
			return true;
		}
		return false;
	}
	
}
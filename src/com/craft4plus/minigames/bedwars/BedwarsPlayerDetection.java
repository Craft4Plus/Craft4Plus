package com.craft4plus.minigames.bedwars;

import org.bukkit.entity.Player;

import com.craft4plus.worldguard.PlayerInRegion;

public class BedwarsPlayerDetection {
	
	public static boolean InBWGame(Player player){ // Boolean that we can access from any class as long as you specify player.
		if ((PlayerInRegion.InWorldGuardRegion(player, "BuildWorld", "goldenmountain"))
				|| (PlayerInRegion.InWorldGuardRegion(player, "BuildWorld", "goldenmountainlobby"))) {
			return true;
		}
		return false;
	}
	
}

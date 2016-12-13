package com.craft4plus.minigames.bedwars;

import org.bukkit.entity.Player;

import com.craft4plus.worldguard.PlayerInRegion;

public class BedwarsPlayerDetection {

	public static boolean InBWGame(Player player) { 
		if ((PlayerInRegion.InWorldGuardRegion(player, "BuildWorld", "goldenmountain"))
				|| (PlayerInRegion.InWorldGuardRegion(player, "BuildWorld", "goldenmountainlobby"))
				|| (PlayerInRegion.InWorldGuardRegion(player, "BuildWorld", "sandstonefortress"))) {
			return true;
		}
		return false;
	}

}

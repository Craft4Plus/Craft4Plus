package com.craft4plus.minigames.kitpvp;

import org.bukkit.entity.Player;

import com.craft4plus.worldguard.PlayerInRegion;

public class KitPvPPlayerDetection {

	public static boolean InSGGame(Player player){ // Boolean that we can access from any class as long as you specify player.
		if ((PlayerInRegion.InWorldGuardRegion(player, "Spawn", "spawn")) || (PlayerInRegion.InWorldGuardRegion(player, "Spawn", "spawnpvp"))) {
			return true;
		}
		return false;
	}
	
}

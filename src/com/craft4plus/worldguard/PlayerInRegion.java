package com.craft4plus.worldguard;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import com.sk89q.worldguard.bukkit.BukkitUtil;
import com.sk89q.worldguard.bukkit.WGBukkit;

public class PlayerInRegion {
	
		public static boolean InWorldGuardRegion(Player player, String world, String region){ // Boolean that we can access from any class as long as you specify player and worldguard region.
			for(String regions : WGBukkit.getRegionManager(Bukkit.getWorld(world)).getApplicableRegionsIDs(BukkitUtil.toVector(player.getLocation()))){ // Get all the applicable regions names in the player's location
				if(regions.contains(region)){ // If all the regions in the player's location contain the region we want
					return true;
				}
				return false;
			}
			return false;
		}	
	
}

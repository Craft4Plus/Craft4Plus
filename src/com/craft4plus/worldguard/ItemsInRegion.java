package com.craft4plus.worldguard;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.util.Vector;

import com.sk89q.worldguard.bukkit.WGBukkit;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;

public class ItemsInRegion {

	public static Vector p1;
	public static Vector p2;
	
	public static void removeItemsInRegion (String world, String r) {
		
        List<Entity> entList = Bukkit.getWorld(world).getEntities();//get all entities in the world
        
        ProtectedRegion region = WGBukkit.getRegionManager(Bukkit.getWorld(world)).getRegion(r); // Region as a variable
 
        int minX = region.getMinimumPoint().getBlockX();
        int minY = region.getMinimumPoint().getBlockY();
        int minZ = region.getMinimumPoint().getBlockZ();
       
        int maxX = region.getMaximumPoint().getBlockX();
        int maxY = region.getMaximumPoint().getBlockY();
        int maxZ = region.getMaximumPoint().getBlockZ();
        
        p1 = new Vector( minX, minY, minZ);
        p2 = new Vector( maxX, maxY, maxZ);
        
        for(Entity current : entList){//loop through the list
            if (current instanceof Item){//make sure we aren't deleting mobs/players
                if (((current).getLocation().getBlockX() >= p1.getBlockX() && (current).getLocation().getBlockX() <= p2.getBlockX() // Check if item is in region
        				&& (current).getLocation().getBlockY() >= p1.getBlockY() && (current).getLocation().getBlockY() <= p2.getBlockY()
        				&& (current).getLocation().getBlockZ() >= p1.getBlockZ() && (current).getLocation().getBlockZ() <= p2.getBlockZ())) { 
                	current.remove();//remove it
                }
            }
        }
	}
	
}

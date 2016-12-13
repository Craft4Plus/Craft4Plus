package com.craft4plus.islandclash;

import java.io.File;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkPopulateEvent;

import com.craft4plus.utils.Schematics;

public class WorldGeneration implements Listener {
	
	File schematic = new File("plugins/Craft4Plus/schematics/IslandClash/BedrockBeacon.schematic");
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onChunkGeneration(ChunkPopulateEvent event) {
		Chunk chunk = event.getChunk();
		if (!chunk.getWorld().getName().equals("IslandClash")) return;
		Block block = chunk.getBlock(0, 120, 0);
		int x = block.getX();
		int z = block.getZ();
		if (x % 480 != 0 || z % 480 != 0) return;
		// This is now the center of the island
		Location location = block.getLocation();
		spawnBedrockBeacon(location);
	}
	
	public void spawnBedrockBeacon(Location location) {
		int x = location.getBlockX();
		int y = location.getBlockY();
		int z = location.getBlockZ();
		World world = location.getWorld();
		Material barrier = Material.BARRIER;
		Schematics.paste(location, schematic);
		y = y - 1;
		while(y <= 256) {
			y = y+1;
			placeBlock(x, y, z, world, barrier);
		}
		
	}
	
	public void placeBlock(int x, int y, int z, World world, Material material) {
		Location location = (new Location(world, x, y, z));
		Block block = location.getBlock();
		block.setType(material);
	}
	
}

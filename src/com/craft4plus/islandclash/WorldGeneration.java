package com.craft4plus.islandclash;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkPopulateEvent;

public class WorldGeneration implements Listener {
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onChunkGeneration(ChunkPopulateEvent event) {
		Chunk chunk = event.getChunk();
		if (!chunk.getWorld().getName().equals("IslandClash")) return;
		Block block = chunk.getBlock(0, 100, 0);
		int x = block.getX();
		int z = block.getZ();
		if (!isEvenlyDivisable(x, 480) || !isEvenlyDivisable(z, 480)) return;
		block.setType(Material.WOOL);
	}

	public boolean isEvenlyDivisable(int a, int b) {
	    return a % b == 0;
	}
	
}

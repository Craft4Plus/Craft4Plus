package com.craft4plus.miscellaneous;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.Location;

public class SlimeChunks {

	public static boolean isSlimeChunk(Location location) {
		Chunk chunk = location.getChunk();
		int x = chunk.getX();
		int z = chunk.getZ();
		Long worldSeed = location.getWorld().getSeed();

		Random random = new Random(
				worldSeed + x * x * 4987142 + x * 5947611 + z * z * 4392871L + z * 389711 ^ 0x3AD8025F);
		if (random.nextInt(10) == 0) return true;
		return false;
	}
}

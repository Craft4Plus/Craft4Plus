package com.craft4plus.utils;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.MaxChangedBlocksException;
import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.bukkit.BukkitWorld;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldedit.data.DataException;
import com.sk89q.worldedit.schematic.MCEditSchematicFormat;

@SuppressWarnings("deprecation")
public class Schematics {
	public static boolean paste(Location location, File schematic) {
		WorldEditPlugin we = (WorldEditPlugin) Bukkit.getPluginManager().getPlugin("WorldEdit");
		EditSession session = we.getWorldEdit().getEditSessionFactory().getEditSession(new BukkitWorld(location.getWorld()),
				1000000);
			try {
				MCEditSchematicFormat.getFormat(schematic).load(schematic).paste(session, new Vector(location.getBlockX(), location.getBlockY(), location.getBlockZ()), false);
				return true;
			} catch (MaxChangedBlocksException | DataException | IOException e) {
				e.printStackTrace();
				return false;
			}
	}
}
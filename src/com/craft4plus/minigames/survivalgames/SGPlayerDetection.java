package com.craft4plus.minigames.survivalgames;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.mcsg.survivalgames.api.PlayerJoinArenaEvent;

import com.craft4plus.main.Main;
import com.craft4plus.worldguard.ItemsInRegion;
import com.craft4plus.worldguard.PlayerInRegion;

public class SGPlayerDetection implements Listener {
	
	@EventHandler
	public void onPlayerJoinSG (PlayerJoinArenaEvent event) {
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() { // New delayed task
			public void run() {
				ItemsInRegion.removeItemsInRegion("BuildWorld", "dimmedarena"); // Remove items in world BuildWorld and WorldGuard region dimmedarena (The arena's name)
			    }
			}, 100L); //This is the delay, in ticks.
	}
	
	public static boolean InSGGame(Player player){ // Boolean that we can access from any class as long as you specify player.
		if (PlayerInRegion.InWorldGuardRegion(player, "BuildWorld", "dimmedarena")) {
			return true;
		}
		if (PlayerInRegion.InWorldGuardRegion(player, "BuildWorld", "candyland")) {
			return true;
		}
		return false;
	}
}
package com.craft4plus.minigames.survivalgames;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.mcsg.survivalgames.api.PlayerJoinArenaEvent;
import org.mcsg.survivalgames.api.PlayerKilledEvent;

public class SGPlayerDetection implements Listener {
	
	static List<String> PlayerInSG = new ArrayList<String>(); // List that will hold all the players that are in SG
	
	@EventHandler
	public void onPlayerJoinArena(PlayerJoinArenaEvent event) { // When a player joins a SG arena
		PlayerInSG.add(event.getPlayer().getName()); // Add him to the list
        World world = Bukkit.getServer().getWorld(event.getPlayer().getWorld().getName());//get the world
        List<Entity> entList = world.getEntities();//get all entities in the world
 
        for(Entity current : entList){//loop through the list
            if (current instanceof Item){//make sure we aren't deleting mobs/players
            current.remove();//remove it
            }
        }
	}
	
	// Used PlayerChangedWorldEvent instead of PlayerLeaveArenaEvent as it wasn't working
	@EventHandler
	public void onPlayerWorldChange (PlayerChangedWorldEvent event) { // When a player changes worlds
		if (PlayerInSG != null) {
			if (PlayerInSG.contains(event.getPlayer().getName())) {
			PlayerInSG.remove(event.getPlayer().getName()); // Remove him from the list
			}
		}
	}

	@EventHandler
	public void onPlayerKilled(PlayerKilledEvent event) { // When a player is killed in a SG arena
		if (PlayerInSG != null) {
		PlayerInSG.remove(event.getPlayer().getName()); // Remove him from the list
		if ((!event.getGame().getAllPlayers().contains(event.getKiller())) && (PlayerInSG.contains(event.getPlayer().getKiller().getName()))) {
			PlayerInSG.remove(event.getPlayer().getKiller().getName()); // Remove the killer from the list
		}
		}
	}
	
	public static boolean InSGGame(Player player){ // Boolean that we can access from any class as long as you specify player.
		if(PlayerInSG.contains(player.getName()) && (PlayerInSG != null)) { // Check if player is in list and list isn't null.
			return true;
		}
		return false;
	}
}

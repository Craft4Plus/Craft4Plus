package com.craft4plus.minigames.kitpvp;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

import com.connorlinfoot.bountifulapi.BountifulAPI;

public class KitPvPDeath implements Listener{

	public static HashMap<UUID, String> lastdamager = new HashMap<UUID, String>();
	
	@EventHandler
	public void onPlayerDeath (PlayerDeathEvent event) {
		if (event.getEntity().getWorld().getName().equals("Spawn")) {
		if (event.getEntity().getKiller() != null) {
				Player killer = Bukkit.getServer().getPlayer(lastdamager.get(event.getEntity().getUniqueId()));
				lastdamager.remove(event.getEntity().getUniqueId());
	            
				event.setDeathMessage("");
				BountifulAPI.sendActionBar(killer, ChatColor.BLUE + "" + ChatColor.BOLD + "You killed " + ChatColor.RED + event.getEntity().getName());
				event.setDroppedExp(0);
				event.getDrops().clear();
				BountifulAPI.sendActionBar(event.getEntity(), ChatColor.BLUE + "" + ChatColor.BOLD + "You were killed by " + ChatColor.RED + killer.getName());
				killer.giveExpLevels(1);
			} else {
			if (lastdamager.isEmpty() || !lastdamager.containsKey(event.getEntity().getUniqueId())) {
			event.setDeathMessage("");
			event.setDroppedExp(0);
			event.getDrops().clear();
			BountifulAPI.sendActionBar(event.getEntity(), ChatColor.BLUE + "" + ChatColor.BOLD + "You killed yourself");
			}
			
			}
		}
	}

	    @EventHandler
	    public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
	               
	            Player damaged = (Player) e.getEntity();

	            Player damager = (Player) e.getDamager();
	            
	            if (lastdamager != null) {
	            	if (lastdamager.containsKey(damaged.getUniqueId())) {
	            		lastdamager.remove(damaged.getUniqueId());
	            	}
	            }
	               
	            lastdamager.put(damaged.getUniqueId(), damager.getName());
	}

	
}

package com.craft4plus.minigames.kitpvp;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

import com.connorlinfoot.bountifulapi.BountifulAPI;

import net.md_5.bungee.api.ChatColor;

public class KitPvPItemDrops implements Listener {
	
	@EventHandler
	public void onItemDrop (PlayerDropItemEvent event) {
		Player player = event.getPlayer();
		if (player.getWorld().getName().equals("Spawn")) {
			if (event.getItemDrop().getName().equals("item.item.bowl")) {
				event.getItemDrop().remove();
			} else {
				event.setCancelled(true);
				BountifulAPI.sendActionBar(player, ChatColor.RED + "You cannot drop this item");
			}
		}
	}

}

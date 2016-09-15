package com.craft4plus.minigames.parkour;

import java.util.HashMap;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class Parkour implements Listener {

	public HashMap<String, Integer> parkourprogress = new HashMap<String, Integer>();
	
	@EventHandler
	public void onPressurePlate(PlayerInteractEvent event) {

		Player player = event.getPlayer();

		if (event.getAction() == Action.PHYSICAL && event.getClickedBlock().getLocation().equals(Material.GOLD_PLATE)) {

			if (parkourprogress.containsKey(player.getName())) {
				
			}
			
		}
	}
}

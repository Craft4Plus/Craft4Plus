package com.craft4plus.custom;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class CustomItemsListener implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onEntityDamage(EntityDamageByEntityEvent event) { // When an
																	// entity is
																	// hit
		if ((event.getDamager() instanceof Player)) { // If the damager is a
														// player
			Player player = (Player) event.getDamager(); // Make him a player
															// variable
			if ((player.getItemInHand() != null)
					&& (CustomItems.getCustomItemDurability(player.getItemInHand()) != 123456789)
					&& !(player.getItemInHand().getDurability() <= CustomItems
							.getCustomItemDurability(player.getItemInHand()))) {
				player.getInventory().removeItem(player.getItemInHand());
				player.playSound(player.getLocation(), Sound.ENTITY_ITEM_BREAK, 1.0F, 1.0F);
			}
		}

	}

}

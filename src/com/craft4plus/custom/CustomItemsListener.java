package com.craft4plus.custom;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import com.craft4plus.miscellaneous.TreeBreaker;

public class CustomItemsListener implements Listener {
	
	@SuppressWarnings("deprecation")
	public void customItemCheck(Player player) {
		if ((player.getItemInHand() != null)
				&& (CustomItems.getCustomItemDurability(player.getItemInHand()) != 123456789)
				&& (player.getItemInHand().getDurability() >= CustomItems.getCustomItemDurability(player.getItemInHand()))) {
			player.getInventory().removeItem(player.getItemInHand()); // Check if there is an item in hand and if it should be broken due to low durability.
			player.playSound(player.getLocation(), Sound.ENTITY_ITEM_BREAK, 1.0F, 1.0F);
		}
		
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onEntityDamage(EntityDamageByEntityEvent event) { // When an entity is hit
		if ((event.getDamager() instanceof Player)) { // If the damager is a player
			Player player = (Player) event.getEntity();
			customItemCheck(player);
			if (player.getItemInHand() != null && CustomItems.isDoubleAxe(player.getItemInHand())) {
				CustomItems.reduceDurability(player.getItemInHand(), player, 2);
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onBlockBreakEvent(BlockBreakEvent event) { // When a block is broken
		Player player = event.getPlayer();
		customItemCheck(player);
		if (player.getItemInHand() != null && CustomItems.isDoubleAxe(player.getItemInHand())) {
			TreeBreaker.Chop(event.getBlock(), player, event.getBlock().getWorld());
			CustomItems.reduceDurability(player.getItemInHand(), player, 1);
		}
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) { // When a player interacts with something
			customItemCheck(event.getPlayer());
	}

}

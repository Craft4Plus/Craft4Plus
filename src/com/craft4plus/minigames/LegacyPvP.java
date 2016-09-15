package com.craft4plus.minigames;

import com.craft4plus.main.Main;
import com.craft4plus.minigames.bedwars.BedwarsPlayerDetection;
import com.craft4plus.minigames.kitpvp.KitPvPPlayerDetection;
import com.craft4plus.minigames.survivalgames.SGPlayerDetection;

import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;

public class LegacyPvP implements Listener {

	@EventHandler
	public void onEntityDamage(EntityDamageByEntityEvent event) { // When an entity is hit
		if ((event.getDamager() instanceof Player)) { // If the damager is a player
			Player player = (Player) event.getDamager(); // Make him a player variable
			AttributeInstance instance = player.getAttribute(Attribute.GENERIC_ATTACK_SPEED); // Get attack speed as variable
			if ((Main.sw.getCurrentGameTracker().isInGame(player.getUniqueId())) || (SGPlayerDetection.InSGGame(player)) || (KitPvPPlayerDetection.InSGGame(player)) || (BedwarsPlayerDetection.InBWGame(player))) { // Check if he's in SurvivalGames(SGPlayerDetection) or SkyWars
				if (!(instance.getBaseValue() == 24)) {
				instance.setBaseValue(24.0D); // 1.8-like attack speed
				}
			} else {
				if (!(instance.getBaseValue() == 4)) {
				instance.setBaseValue(4.0D); // 1.9+ attack speed
				}
			}

		}

	}

	@EventHandler (priority = EventPriority.LOWEST) 
	public void onWorldChange(PlayerChangedWorldEvent event) { // When a player changes world 
		Player player = (Player) event.getPlayer();
		AttributeInstance instance = player.getAttribute(Attribute.GENERIC_ATTACK_SPEED);
		if ((Main.sw.getCurrentGameTracker().isInGame(player.getUniqueId())) || (SGPlayerDetection.InSGGame(player)) || (KitPvPPlayerDetection.InSGGame(player)) || (BedwarsPlayerDetection.InBWGame(player))) { 
			instance.setBaseValue(24.0D); // 1.8 like attack speed
		} else {
			instance.setBaseValue(4.0D); // 1.9+ attack speed
		}

	}

}
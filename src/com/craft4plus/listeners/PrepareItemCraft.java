package com.craft4plus.listeners;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.craft4plus.main.Main;

import net.md_5.bungee.api.ChatColor;

public class PrepareItemCraft implements Listener{

	// NETHER STAR EXPLOIT FIX
	@EventHandler
	public void craftItem(PrepareItemCraftEvent e) {
		CraftingInventory inv = e.getInventory();
		ItemStack netherstar = new ItemStack(Material.NETHER_STAR, 1);
		ItemMeta meta = netherstar.getItemMeta();
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&aNavigator"));
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.translateAlternateColorCodes('&', "&aRight click to use the World Navigator"));
		meta.setLore(lore);
		netherstar.setItemMeta(meta);
		if (inv.contains(netherstar)) {
			for (HumanEntity human : e.getViewers()) {
				human.closeInventory();
				human.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Don't use the navigator to craft items!");
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
					@Override
					public void run() {
						human.getInventory().setItem(8, netherstar);
					}
				}, 1L);
			}
		}
	}
	// END OF NETHER STAR EXPLOIT FIX
	
}

package com.craft4plus.custom;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerResourcePackStatusEvent;

import com.craft4plus.main.Main;

import net.md_5.bungee.api.ChatColor;

public class ResourcePackListener implements Listener {

	@EventHandler
	public void onResourcePackEvent(PlayerResourcePackStatusEvent event) {
		if (event.getStatus() == PlayerResourcePackStatusEvent.Status.DECLINED) {
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() { //Schedule a repeating task
				@Override
				public void run() {
					event.getPlayer()
					.kickPlayer(ChatColor.RED + " You did not accept the resource pack. " + ChatColor.GREEN
							+ "Edit the server on the server list to accept resource packs! " + ChatColor.WHITE
							+ "If you need more help visit: discord.craft4plus.ml");
				}
			}, 2L);
		} else if (event.getStatus() == PlayerResourcePackStatusEvent.Status.FAILED_DOWNLOAD) {
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() { //Schedule a repeating task
				@Override
				public void run() {
					event.getPlayer().kickPlayer(ChatColor.RED + " The resource pack could not be downloaded. "
							+ ChatColor.GREEN + "Please try joining again!");
				}
			}, 2L);
		}

	}
}

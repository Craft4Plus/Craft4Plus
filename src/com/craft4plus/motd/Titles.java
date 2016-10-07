package com.craft4plus.motd;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.connorlinfoot.bountifulapi.BountifulAPI;
import com.craft4plus.main.Main;

import net.md_5.bungee.api.ChatColor;

public class Titles {

public static void titleOnPlayerJoin(Player player) {
		
	Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() { //Schedule a repeating task
			@Override
			public void run() {
				if (MailPlaceholder.mailString(player) != null) {
					BountifulAPI.sendTitle(player, 5, 60, 5,
							ChatColor.GOLD + "Welcome back, " + player.getName() + "!", "");
				}
			}
		}, 100L);

		if (MailPlaceholder.mailString(player) != null) {
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
				@Override
				public void run() {
					if (MailPlaceholder.mailString(player) != null) {
						BountifulAPI.sendTitle(player, 5, 80, 5, ChatColor.RED + MailPlaceholder.mailString(player),
								ChatColor.GREEN + "Type: " + ChatColor.BLUE + "/mail read");
					}
				}
			}, 170L);
		}

		if (MailPlaceholder.buildsString(player) != null) {
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
				@Override
				public void run() {
					if (MailPlaceholder.buildsString(player) != null) {
						BountifulAPI.sendTitle(player, 5, 80, 5, ChatColor.RED + MailPlaceholder.buildsString(player),
								ChatColor.GREEN + "Type: " + ChatColor.BLUE + "/builds list");
					}
				}
			}, 260L);
		}
	}
}
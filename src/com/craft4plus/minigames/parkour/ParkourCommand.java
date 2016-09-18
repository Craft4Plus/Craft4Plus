package com.craft4plus.minigames.parkour;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ParkourCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (label.equalsIgnoreCase("parkourreset")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED + "You must be in-game to use this command!!");
				return false;
			}

			Parkour.resetProgress(Bukkit.getPlayer(sender.getName()));
			return true;
		}

		return false;
	}
}

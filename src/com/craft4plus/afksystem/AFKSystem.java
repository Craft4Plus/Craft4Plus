package com.craft4plus.afksystem;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AFKSystem implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("afk")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED + "You must be a Player to use this command!");
				return false;
			}
			Player player = (Player) sender;
			return true;
		}
		return false;
	}
}
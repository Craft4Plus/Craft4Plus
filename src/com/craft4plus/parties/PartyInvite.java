package com.craft4plus.parties;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import net.md_5.bungee.api.ChatColor;

public class PartyInvite implements CommandExecutor {

	String PartyPrefix = ChatColor.GRAY + "[" + ChatColor.BLUE + "Party" + ChatColor.GRAY + "]" + ChatColor.RESET;

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (commandLabel.equalsIgnoreCase("party")) {
			if (sender instanceof Player) {
				if (args.length == 1) {
					for (Player serverplayer : Bukkit.getServer().getOnlinePlayers()) {
						if (args[0].equalsIgnoreCase(serverplayer.getName())) {
							sender.sendMessage(
									PartyPrefix + serverplayer.getName() + " has been invited to your party.");
							return true;
						}
					}
					sender.sendMessage(PartyPrefix + "Cannot find a player by that username.");
					return false;
				}
				return false;
			}
			return false;
		}
		return false;
	}
}
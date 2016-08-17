package com.craft4plus.parties;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import net.md_5.bungee.api.ChatColor;

public class Parties implements Listener {

	String PartyPrefix = ChatColor.GRAY + "[" + ChatColor.BLUE + "Party" + ChatColor.GRAY + "]" + ChatColor.RESET;

	public boolean onCommand(Command sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			if (cmd.getName().equalsIgnoreCase("party invite " + args[0])) {
			for (Player serverplayer : Bukkit.getServer().getOnlinePlayers()) {
				if (args[0].equalsIgnoreCase(serverplayer.getName())) {
					((CommandSender) sender)
							.sendMessage(PartyPrefix + serverplayer.getName() + " has been invited to your party.");
					return true;
				}
				((CommandSender) sender).sendMessage(PartyPrefix + "Cannot find a player by that username.");
				return false;
			}

			return false;
		}
		return false;
	}
		return false;
	}
}
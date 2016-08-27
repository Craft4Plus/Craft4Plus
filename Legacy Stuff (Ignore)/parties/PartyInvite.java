package com.craft4plus.parties;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import net.md_5.bungee.api.ChatColor;

public abstract class PartyInvite extends Parties implements CommandExecutor, Plugin {

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (commandLabel.equalsIgnoreCase("party")) {
			if (sender instanceof Player) {
				if (args.length == 1) {
					for (Player serverplayer : Bukkit.getServer().getOnlinePlayers()) {
						if (args[0].equalsIgnoreCase(serverplayer.getName())) {
							if (!args[0].equalsIgnoreCase(sender.getName())) {
								sender.sendMessage(PartyPrefix + ChatColor.RED + serverplayer.getName() + ChatColor.AQUA
										+ " has been invited to your party.");
								serverplayer.sendMessage(PartyPrefix + ChatColor.AQUA + "You have been invited to "
										+ ChatColor.RED + sender.getName() + ChatColor.AQUA + "'s Party! Do "
										+ ChatColor.GREEN + "/party accept " + ChatColor.AQUA
										+ "within 60 seconds to join the Party.");
								if ((!InParty.containsKey(sender.getName()))
										&& (!InParty.containsKey(serverplayer.getName()))
										&& (!WaitingForParty.containsKey(sender.getName()))
										&& (!WaitingForParty.containsKey(serverplayer.getName()))) {
									NumberOfParties += 1;
									InParty.put(sender.getName(), NumberOfParties);
									WaitingForParty.put(serverplayer.getName(), NumberOfParties);
									Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
										public void run() {
											WaitingForParty.remove(serverplayer.getName());
										}
									}, 1200L);
									return true;
								} else {

								}
							} else {
								sender.sendMessage(PartyPrefix + "You can't invite yourself!");
								return false;
							}
						}
					}
					sender.sendMessage(PartyPrefix + "Cannot find a player by that username.");
					return false;
				}
				sender.sendMessage(PartyPrefix + "Too many arguements.");
				return false;
			}
			sender.sendMessage(PartyPrefix + "You must be a player to run this command!");
			return false;
		}
		return false;
	}

}
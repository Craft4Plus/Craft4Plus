package com.craft4plus.custom.items;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class CustomItemsCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		if (!(sender instanceof Player)) return false;
		
		Player player = Bukkit.getPlayer(sender.getName());
		if (player.hasPermission("c4p.customitems.getitem")) {
			try {
			player.getInventory().addItem(CustomItemStack.getItem(Integer.parseInt(args[0])));
			return true;
			} catch (Exception e) {
				player.sendMessage("That is not a valid ID!");
				return false;
			}
		} else {
			player.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
			return true;
		}
	}

}

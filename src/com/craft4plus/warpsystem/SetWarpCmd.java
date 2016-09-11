package com.craft4plus.warpsystem;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class SetWarpCmd implements Listener, CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command command, 
			String label, String[] args) {
	            if (label.equalsIgnoreCase("setwp" + )) {
	            if (!(sender instanceof Player)) {
	            	sender.sendMessage(ChatColor.RED + "You must be in-game to set a warp!");
	            	return false;
	            }
	            
	            Player player = (Player) sender;
	            	
	            }

}
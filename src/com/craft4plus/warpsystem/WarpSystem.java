package com.craft4plus.warpsystem;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class WarpSystem implements Listener, CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command command, 
			String label, String[] args) {
		         if (label.equalsIgnoreCase("wp")) {
		         if (!(sender instanceof Player)) {
		         sender.sendMessage(ChatColor.RED + " You must be in-game to use this command!");
		          return false;
		         }
		         Player player = (Player) sender;
		         
                    if (player.hasPermission("c4p.cmd.warp")) {
		            player.sendMessage("You have been teleported to..."); // Small message that is sent to the player when teleported.
        }    
      }
	}
  }
}
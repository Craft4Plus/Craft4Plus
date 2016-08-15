package com.craft4plus.parties;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Parties extends JavaPlugin{
	
	public boolean onCommand(Command sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
		Player player = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("party invite " + player.getName() )) {
			
			((CommandSender) sender).sendMessage(player.getName() + " has been invited to your party");
			return true;
		}
		}
		return false;
		
	}

}

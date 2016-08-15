package com.craft4plus.parties;

import org.bukkit.command.Command;
import org.bukkit.plugin.java.JavaPlugin;

public class Parties extends JavaPlugin{
	
	public boolean onCommand(Command sender, Command cmd, String label, String[] args) {
		if(sender instanceof player) {
		Player player = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("party invite"));
		}
		return false;
		
	}

}

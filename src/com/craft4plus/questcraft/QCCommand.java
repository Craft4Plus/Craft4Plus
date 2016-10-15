package com.craft4plus.questcraft;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class QCCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		if (sender instanceof Player) {
			Player player = ((Player) sender).getPlayer();
			if (args[0].equals("cutscene1")) {
				Cutscenes.introCutscene(player);
				return true;
			}
		} else {
			sender.sendMessage("You must be a player to use this command!");
			return true;
		}
		return false;
	}
	
}

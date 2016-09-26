package com.craft4plus.bulders.builds;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class BuildsCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		if (sender.hasPermission("c4p.builders.command")) {
			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("check") || args[0].equals("list")) {
					Builds.showBuilds(Bukkit.getPlayer(sender.getName()));
					return true;
				}
			}
			if (args.length > 1) {
				if (args[0].equals("add")) {
					Builds.addBuild(Bukkit.getPlayer(sender.getName()), args);
					return true;
				}
				if (args[0].equals("tp")) {
					Builds.tpToBuild(Bukkit.getPlayer(sender.getName()), args);
					return true;
				}
				if (args[0].equals("complete")) {
					Builds.completeBuild(Bukkit.getPlayer(sender.getName()), args);
					return true;
				}
			}
		}
		return false;
	}

}

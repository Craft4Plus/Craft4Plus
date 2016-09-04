package com.craft4plus.afksystem;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;

public class AFKSystem extends main implements Listener {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("afk")) {
			    if (args.length == 2) {
				if (sender.hasPermission("c4p.command.afk")) {}
				
    


package com.craft4plus.bulders.builds;

import java.util.HashMap;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import com.craft4plus.main.Main;
import com.earth2me.essentials.User;

import net.md_5.bungee.api.ChatColor;

public class Builds {
	
	static HashMap<Integer, String> BuildsListString = new HashMap<Integer, String>();
	
	static HashMap<Integer, Location> BuildsListLocation = new HashMap<Integer, Location>();
	
	static HashMap<Integer, UUID> BuildsListSubmiter = new HashMap<Integer, UUID>();
	
	static int BuildsListNumber = new Integer(0);
	
	static String BuildsPrefix = new String(ChatColor.GRAY + "[" + ChatColor.BLUE + "Builds" + ChatColor.GRAY + "] ");
	
	public static void addBuild(Player player, String[] args) {
		BuildsListNumber = BuildsListNumber + 1;
		
		String build = StringUtils.join(args, " ");
		
		BuildsListString.put(BuildsListNumber, ChatColor.GRAY + "[" + ChatColor.YELLOW + BuildsListNumber + ChatColor.GRAY + "] " + ChatColor.RED + build.substring(4));
		BuildsListLocation.put(BuildsListNumber, player.getLocation());
		BuildsListSubmiter.put(BuildsListNumber, player.getUniqueId());		
		
		player.sendMessage(BuildsPrefix + ChatColor.YELLOW + "You have added '" + ChatColor.RED + build.substring(4) + ChatColor.YELLOW + "'as number " + ChatColor.RED + BuildsListNumber + ChatColor.YELLOW + " for your location on the Pending Builds List!");
	}
	
	public static void showBuilds(Player player) {
		player.sendMessage(ChatColor.YELLOW + "----------" + ChatColor.RED + " Pending Builds List " + ChatColor.YELLOW + "----------");
		
		for (Integer build : BuildsListString.keySet()) {
			player.sendMessage(BuildsListString.get(build) + " - Submitted by " + ChatColor.GREEN + Bukkit.getOfflinePlayer(BuildsListSubmiter.get(build)).getName());
		}
		
		player.sendMessage(ChatColor.YELLOW + "-------------------------------------");
		
	}
	
	public static void tpToBuild(Player player, String[] args) {
		int buildnumber = Integer.parseInt(args[1]);
		
		if (BuildsListLocation.containsKey(buildnumber) && BuildsListString.containsKey(buildnumber)) {
			player.teleport(BuildsListLocation.get(buildnumber));

			player.sendMessage(BuildsPrefix + ChatColor.YELLOW + "You have been teleported to Build " + BuildsListString.get(buildnumber) + ChatColor.YELLOW + ". Start building!");;

			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() { // Schedule a repeating task
				@Override
				public void run() {
					player.setGameMode(GameMode.CREATIVE);
				}
			}, 2L);			
		} else {
			player.sendMessage(ChatColor.RED + "There is no build with that number!");
		}
		
	}

	public static void completeBuild(Player player, String[] args) {
		int buildnumber = Integer.parseInt(args[1]);
		
		if (BuildsListLocation.containsKey(buildnumber) && BuildsListString.containsKey(buildnumber) && BuildsListSubmiter.containsKey(buildnumber)) {
			
			if ((Bukkit.getServer().getOnlinePlayers().contains(Bukkit.getPlayer(BuildsListSubmiter.get(buildnumber))))) {
				
				 if (Bukkit.getPlayer(BuildsListSubmiter.get(buildnumber)) != player) {
				
					Player submiter = Bukkit.getServer().getPlayer(BuildsListSubmiter.get(buildnumber));
					User EssentialsUser = Main.ess.getUser(submiter);

					player.sendMessage(ChatColor.YELLOW + "Build is now complete! Thank you for your assistance! " + submiter.getName() + " has been notified!");

					EssentialsUser.addMail(ChatColor.YELLOW + "Build no." + BuildsListString.get(buildnumber) + ChatColor.YELLOW + " has been completed by " + player.getName() + "!");
				
				 } else {				 
					 player.sendMessage(ChatColor.YELLOW + "Build is now complete! Thank you for your assistance!");
				 }
				 
			} else {
				OfflinePlayer offlinesubmiter = Bukkit.getOfflinePlayer(BuildsListSubmiter.get(buildnumber));
				
				@SuppressWarnings("deprecation")
				User EssentialsUser = Main.ess.getUser(offlinesubmiter);
				
				player.sendMessage(ChatColor.YELLOW + "Build is now complete! Thank you for your assistance! " + offlinesubmiter.getName() + " has been notified!");
				EssentialsUser.addMail(ChatColor.YELLOW + "Build no." + BuildsListString.get(buildnumber) + ChatColor.YELLOW + " has been completed by "+ player.getName() + "!");
			}
			
			BuildsListLocation.remove(buildnumber);
			BuildsListString.remove(buildnumber);
			BuildsListSubmiter.remove(buildnumber);
			
		} else {
			player.sendMessage(ChatColor.RED + "There is no build with that number!");
		}
	}
	
	public static int buildsAvailable() {
		if (!BuildsListString.isEmpty()) {
			return BuildsListString.size();
		} else {
			return 0;
		}
	}

}

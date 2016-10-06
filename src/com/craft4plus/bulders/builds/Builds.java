package com.craft4plus.bulders.builds;

import java.io.File;
import java.util.HashMap;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import com.craft4plus.main.Main;
import com.craft4plus.miscellaneous.Files;
import com.earth2me.essentials.User;

import net.md_5.bungee.api.ChatColor;

public class Builds {
	
	static HashMap<Integer, String> BuildsListString;
	
	static HashMap<Integer, Location> BuildsListLocation = new HashMap<Integer, Location>();
	
	static HashMap<Integer, String> BuildsListLocationSerialized;
	
	static HashMap<Integer, UUID> BuildsListSubmitter;
	
	static int BuildsListNumber;
	
	static String BuildsPrefix = new String(ChatColor.GRAY + "[" + ChatColor.BLUE + "Builds" + ChatColor.GRAY + "] ");
	
	public static void addBuild(Player player, String[] args) {
		BuildsListNumber = BuildsListNumber + 1;
		
		String build = StringUtils.join(args, " ");
		
		BuildsListString.put(BuildsListNumber, ChatColor.GRAY + "[" + ChatColor.YELLOW + BuildsListNumber + ChatColor.GRAY + "] " + ChatColor.RED + build.substring(4));
		BuildsListLocation.put(BuildsListNumber, player.getLocation());
		BuildsListSubmitter.put(BuildsListNumber, player.getUniqueId());		
		
		player.sendMessage(BuildsPrefix + ChatColor.YELLOW + "You have added '" + ChatColor.RED + build.substring(4) + ChatColor.YELLOW + "'as number " + ChatColor.RED + BuildsListNumber + ChatColor.YELLOW + " for your location on the Pending Builds List!");
	}
	
	public static void showBuilds(Player player) {
		if (!(BuildsListLocation.isEmpty() && BuildsListString.isEmpty())) {
		player.sendMessage(ChatColor.YELLOW + "----------" + ChatColor.RED + " Pending Builds List " + ChatColor.YELLOW + "----------");
		
		for (Integer build : BuildsListString.keySet()) {
			player.sendMessage(BuildsListString.get(build) + " - Submitted by " + ChatColor.GREEN + Bukkit.getOfflinePlayer(BuildsListSubmitter.get(build)).getName());
		}
		
		player.sendMessage(ChatColor.YELLOW + "-------------------------------------");
		} else {
			player.sendMessage(ChatColor.YELLOW + "No builds available at the moment! Please check back later.");
		}
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
		if (!NumberUtils.isNumber(args[1])) {
			player.sendMessage(ChatColor.RED + "The value you enteredis not a number!");
			return;
		}
		int buildnumber = Integer.parseInt(args[1]);
		if (BuildsListLocation.containsKey(buildnumber) && BuildsListString.containsKey(buildnumber) && BuildsListSubmitter.containsKey(buildnumber)) {
			
			if ((Bukkit.getServer().getOnlinePlayers().contains(Bukkit.getPlayer(BuildsListSubmitter.get(buildnumber))))) {
				
				 if (Bukkit.getPlayer(BuildsListSubmitter.get(buildnumber)) != player) {
				
					Player submiter = Bukkit.getServer().getPlayer(BuildsListSubmitter.get(buildnumber));
					User EssentialsUser = Main.ess.getUser(submiter);

					player.sendMessage(ChatColor.YELLOW + "Build is now complete! Thank you for your assistance! " + submiter.getName() + " has been notified!");

					EssentialsUser.addMail(ChatColor.YELLOW + "Build no." + BuildsListString.get(buildnumber) + ChatColor.YELLOW + " has been completed by " + player.getName() + "!");
				
				 } else {				 
					 player.sendMessage(ChatColor.YELLOW + "Build is now complete! Thank you for your assistance!");
				 }
				 
			} else {
				OfflinePlayer offlinesubmiter = Bukkit.getOfflinePlayer(BuildsListSubmitter.get(buildnumber));
				
				@SuppressWarnings("deprecation")
				User EssentialsUser = Main.ess.getUser(offlinesubmiter);
				
				player.sendMessage(ChatColor.YELLOW + "Build is now complete! Thank you for your assistance! " + offlinesubmiter.getName() + " has been notified!");
				EssentialsUser.addMail(ChatColor.YELLOW + "Build no." + BuildsListString.get(buildnumber) + ChatColor.YELLOW + " has been completed by "+ player.getName() + "!");
			}
			
			BuildsListLocation.remove(buildnumber);
			BuildsListString.remove(buildnumber);
			BuildsListSubmitter.remove(buildnumber);
			
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
	
	public static void save(File dir) {
		Files.save(BuildsListString, new File((dir), "BuildsListString.dat"));
		if (BuildsListLocation == null) {
			Files.save(null, new File((dir), "BuildsListLocationSerialized.dat"));
		} else {
			BuildsListLocationSerialized = new HashMap<Integer, String>();
			for (Integer i : BuildsListLocation.keySet()) {
				BuildsListLocationSerialized.put(i, Files.getSerializedLocation(BuildsListLocation.get(i)));
			}
			Files.save(BuildsListLocationSerialized, new File((dir), "BuildsListLocationSerialized.dat"));
		}
		Files.save(BuildsListSubmitter, new File((dir), "BuildsListSubmitter.dat"));
		Files.save(BuildsListNumber, new File((dir), "BuildsListNumber.dat"));
	}
	
	@SuppressWarnings("unchecked")
	public static void load(File dir) {
		
		BuildsListString = (HashMap<Integer, String>) Files.load(new File(dir, "BuildsListString.dat"));
		BuildsListLocationSerialized = (HashMap<Integer, String>) Files.load(new File(dir, "BuildsListLocationSerialized.dat"));
		BuildsListSubmitter = (HashMap<Integer, UUID>) Files.load(new File(dir, "BuildsListSubmitter.dat"));
		if (Files.load(new File(dir, "BuildsList/Number.dat")) != null) {
			BuildsListNumber = (int) Files.load(new File(dir, "BuildsList/Number.dat"));
		} else {
			BuildsListNumber = new Integer(0);
		}
		
		if (BuildsListString == null) {
			BuildsListString  = new HashMap<Integer, String>();
		}
		if (BuildsListLocationSerialized == null) {
			BuildsListLocationSerialized = new HashMap<Integer, String>();
		} else {
			for(Integer i : BuildsListLocationSerialized.keySet()) {
				BuildsListLocation.put(i, Files.getDeserializedLocation(BuildsListLocationSerialized.get(i)));
			}
		}
		if (BuildsListLocation == null) {
			BuildsListLocation = new HashMap<Integer, Location>();
		}
		if (BuildsListSubmitter == null) {
			BuildsListSubmitter = new HashMap<Integer, UUID>();
		}
	}
	
}

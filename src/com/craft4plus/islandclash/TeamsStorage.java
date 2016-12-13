package com.craft4plus.islandclash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.bukkit.entity.Player;

import com.craft4plus.miscellaneous.Numbers;

public class TeamsStorage {
	
	/*
	 * Things that need to be tracked:
	 * Players: Team, Wealth, Plot Number
	 * Teams: Total Wealth, Members 
	 */
	
	// Team Members
	static List<UUID> TeamRed = new ArrayList<UUID>();
	static List<UUID> TeamBlue = new ArrayList<UUID>();
	static List<UUID> TeamYellow = new ArrayList<UUID>();
	
	// Team Members with Wealth
	static HashMap<UUID, Double> TeamRedWealth = new HashMap<UUID, Double>();
	static HashMap<UUID, Double> TeamBlueWealth = new HashMap<UUID, Double>();
	static HashMap<UUID, Double> TeamYellowWealth = new HashMap<UUID, Double>();
	
	// Team Members with Owned Plots
	static HashMap<UUID, Integer> TeamRedPlots = new HashMap<UUID, Integer>();
	static HashMap<UUID, Integer> TeamBluePlots = new HashMap<UUID, Integer>();
	static HashMap<UUID, Integer> TeamYellowPlots = new HashMap<UUID, Integer>();
	
	public static void addToRandomTeam(Player player) {
		int redMembers = getSize(Team.RED);
		int blueMembers = getSize(Team.BLUE);
		int yellowMembers = getSize(Team.BLUE);
		
		int lowestMembers = Numbers.getLowestInt(new int[] {redMembers, blueMembers, yellowMembers});
		if (redMembers == lowestMembers) {
			addToTeam(Team.RED, player);			
		} else if (blueMembers == lowestMembers) {
			addToTeam(Team.BLUE, player);
		} else if (yellowMembers == lowestMembers) {
			addToTeam(Team.YELLOW, player);
		}
	}
	
	public static void addToTeam(Team team, Player player) {
		removeFromTeams(player);
		UUID uuid = player.getUniqueId();
		switch (team) {
		case RED:
			TeamRed.add(uuid);
			TeamRedWealth.put(uuid, 0D);
			TeamRedPlots.put(uuid, 0);
		case BLUE:
			TeamBlue.add(uuid);
			TeamBlueWealth.put(uuid, 0D);
			TeamBluePlots.put(uuid, 0);
		case YELLOW:
			TeamYellow.add(uuid);
			TeamYellowWealth.put(uuid, 0D);
			TeamYellowPlots.put(uuid, 0);
		}
	}
	
	public static Team getTeam(Player player){
		UUID uuid = player.getUniqueId();
		if (TeamRed.contains(uuid) || TeamRedWealth.containsKey(uuid) || TeamRedPlots.containsKey(uuid)) return Team.RED;
		if (TeamBlue.contains(uuid) || TeamBlueWealth.containsKey(uuid) || TeamBluePlots.containsKey(uuid)) return Team.BLUE;
		if (TeamYellow.contains(uuid) || TeamYellowWealth.containsKey(uuid) || TeamYellowPlots.containsKey(uuid)) return Team.YELLOW;
		return null;
	}
	
	public static void removeFromTeams(Player player) {
		UUID uuid = player.getUniqueId();
		if (TeamRed.contains(uuid)) TeamRed.remove(uuid);
		if (TeamBlue.contains(uuid)) TeamBlue.remove(uuid);
		if (TeamYellow.contains(uuid)) TeamYellow.remove(uuid);
		
		if (TeamRedWealth.containsKey(uuid)) TeamRedWealth.remove(uuid);
		if (TeamBlueWealth.containsKey(uuid)) TeamBlueWealth.remove(uuid);
		if (TeamYellowWealth.containsKey(uuid)) TeamYellowWealth.remove(uuid);
		
		if (TeamRedPlots.containsKey(uuid)) TeamRedPlots.remove(uuid);
		if (TeamBluePlots.containsKey(uuid)) TeamBluePlots.remove(uuid);
		if (TeamYellowPlots.containsKey(uuid)) TeamYellowPlots.remove(uuid);
	}
	
	public static int getSize(Team team) {
		switch (team) {
		case RED:
			return TeamRed.size();
		case BLUE:
			return TeamBlue.size();
		case YELLOW:
			return TeamYellow.size();
		}
		return 0;
	}
	
	public static Double getWealth(Team team) {
		Double totalWealth = 0.0D;
		switch (team) {
		case RED:
			for (Double wealth : TeamRedWealth.values()) {
				totalWealth = totalWealth + wealth;
			}
		case BLUE:
			for (Double wealth : TeamBlueWealth.values()) {
				totalWealth = totalWealth + wealth;
			}
		case YELLOW:
			for (Double wealth : TeamYellowWealth.values()) {
				totalWealth = totalWealth + wealth;
			}
		}
		return totalWealth;
	}
	
	public static Double getWealth(Player player) {
		UUID uuid = player.getUniqueId();
		switch (getTeam(player)) {
		case RED:
			return TeamRedWealth.get(uuid);
		case BLUE:
			return TeamBlueWealth.get(uuid);
		case YELLOW:
			return TeamYellowWealth.get(uuid);
		}
		return 0.0D;
	}
}

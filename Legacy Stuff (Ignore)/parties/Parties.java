package com.craft4plus.parties;

import java.util.HashMap;

import net.md_5.bungee.api.ChatColor;

public class Parties {
	
	public static String PartyPrefix = ChatColor.GRAY + "[" + ChatColor.BLUE + "Party" + ChatColor.GRAY + "]" + ChatColor.RESET + " ";
	
	public static HashMap<String, Integer> InParty = new HashMap<String, Integer>();
	public static HashMap<String, Integer> WaitingForParty = new HashMap<String, Integer>();
	
	public static int NumberOfParties = 0;
	

}

package com.craft4plus.tips;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.connorlinfoot.bountifulapi.BountifulAPI;
import com.craft4plus.listeners.PlayerJoin;

import net.md_5.bungee.api.ChatColor;

public class Tips {

	private PlayerJoin PlayerJustJoinedList;

	public void showTips() {

		PlayerJustJoinedList = new PlayerJoin();
		List<String> PlayerJustJoined = PlayerJustJoinedList.getList();

		List<String> listCrafter = new ArrayList<String>();
		
		listCrafter.add(ChatColor.BLUE + "" + ChatColor.MAGIC + "|||" + ChatColor.RESET + " " + ChatColor.RED + ChatColor.BOLD + "Sell items in the Survival Shop to get coins!" + ChatColor.RESET + "" + ChatColor.BLUE + " " + ChatColor.MAGIC + "|||");
		listCrafter.add(ChatColor.BLUE + "" + ChatColor.MAGIC + "|||" + ChatColor.RESET + " " + ChatColor.RED + ChatColor.BOLD + "You can get the Miner Rank using 10,000 in-game coins!" + ChatColor.RESET + "" + ChatColor.BLUE + " " + ChatColor.MAGIC + "|||");
		listCrafter.add(ChatColor.BLUE + "" + ChatColor.MAGIC + "|||" + ChatColor.RESET + " " + ChatColor.RED + ChatColor.BOLD + "There are huge Creative Plots available!" + ChatColor.RESET + "" + ChatColor.BLUE + " " + ChatColor.MAGIC + "|||");
		listCrafter.add(ChatColor.BLUE + "" + ChatColor.MAGIC + "|||" + ChatColor.RESET + " " + ChatColor.RED + ChatColor.BOLD + "There are plenty of Minigames available!" + ChatColor.RESET + "" + ChatColor.BLUE + " " + ChatColor.MAGIC + "|||");
		listCrafter.add(ChatColor.BLUE + "" + ChatColor.MAGIC + "|||" + ChatColor.RESET + " " + ChatColor.RED + ChatColor.BOLD + "Join Discord to chat with other players! discord.craft4plus.ml" + ChatColor.RESET + "" + ChatColor.BLUE + " " + ChatColor.MAGIC + "|||");
		listCrafter.add(ChatColor.BLUE + "" + ChatColor.MAGIC + "|||" + ChatColor.RESET + " " + ChatColor.RED + ChatColor.BOLD + "Need help with the server? Tell us on Discord!" + ChatColor.RESET + "" + ChatColor.BLUE + " " + ChatColor.MAGIC + "|||");
		listCrafter.add(ChatColor.BLUE + "" + ChatColor.MAGIC + "|||" + ChatColor.RESET + " " + ChatColor.RED + ChatColor.BOLD + "Want to chat with your mates only? Use one of the Chat Chanels!" + ChatColor.RESET + "" + ChatColor.BLUE + " " + ChatColor.MAGIC + "|||");
		listCrafter.add(ChatColor.BLUE + "" + ChatColor.MAGIC + "|||" + ChatColor.RESET + " " + ChatColor.RED + ChatColor.BOLD + "Hard to get resources in SkyBlock? Use the shop!" + ChatColor.RESET + "" + ChatColor.BLUE + " " + ChatColor.MAGIC + "|||");
		listCrafter.add(ChatColor.BLUE + "" + ChatColor.MAGIC + "|||" + ChatColor.RESET + " " + ChatColor.RED + ChatColor.BOLD + "mcMMO is available! Use it to gain amazing advantages." + ChatColor.RESET + "" + ChatColor.BLUE + " " + ChatColor.MAGIC + "|||");
		listCrafter.add(ChatColor.BLUE + "" + ChatColor.MAGIC + "|||" + ChatColor.RESET + " " + ChatColor.RED + ChatColor.BOLD + "Want a map of the server? Visit map.craft4plus.ml" + ChatColor.RESET + "" + ChatColor.BLUE + " " + ChatColor.MAGIC + "|||");
		
		String TipsCrafter = listCrafter.get(new Random().nextInt(listCrafter.size()));

		List<String> listMiner = new ArrayList<String>();
		
		listMiner.add(ChatColor.BLUE + "" + ChatColor.MAGIC + "|||" + ChatColor.RESET + " " + ChatColor.RED + ChatColor.BOLD + "Sell items in the Survival Shop to get coins!" + ChatColor.RESET + "" + ChatColor.BLUE + " " + ChatColor.MAGIC + "|||");
//		listMiner.add(ChatColor.BLUE + "" + ChatColor.MAGIC + "|||" + ChatColor.RESET + " " + ChatColor.RED + ChatColor.BOLD + "You can get the Miner Rank using 10,000 in-game coins!" + ChatColor.RESET + "" + ChatColor.BLUE + " " + ChatColor.MAGIC + "|||");
		listMiner.add(ChatColor.BLUE + "" + ChatColor.MAGIC + "|||" + ChatColor.RESET + " " + ChatColor.RED + ChatColor.BOLD + "There are huge Creative Plots available!" + ChatColor.RESET + "" + ChatColor.BLUE + " " + ChatColor.MAGIC + "|||");
		listMiner.add(ChatColor.BLUE + "" + ChatColor.MAGIC + "|||" + ChatColor.RESET + " " + ChatColor.RED + ChatColor.BOLD + "There are plenty of Minigames available!" + ChatColor.RESET + "" + ChatColor.BLUE + " " + ChatColor.MAGIC + "|||");
		listMiner.add(ChatColor.BLUE + "" + ChatColor.MAGIC + "|||" + ChatColor.RESET + " " + ChatColor.RED + ChatColor.BOLD + "Join Discord to chat with other players! discord.craft4plus.ml" + ChatColor.RESET + "" + ChatColor.BLUE + " " + ChatColor.MAGIC + "|||");
		listMiner.add(ChatColor.BLUE + "" + ChatColor.MAGIC + "|||" + ChatColor.RESET + " " + ChatColor.RED + ChatColor.BOLD + "Need help with the server? Tell us on Discord!" + ChatColor.RESET + "" + ChatColor.BLUE + " " + ChatColor.MAGIC + "|||");
		listMiner.add(ChatColor.BLUE + "" + ChatColor.MAGIC + "|||" + ChatColor.RESET + " " + ChatColor.RED + ChatColor.BOLD + "Want to chat with your mates only? Use one of the Chat Chanels!" + ChatColor.RESET + "" + ChatColor.BLUE + " " + ChatColor.MAGIC + "|||");
		listMiner.add(ChatColor.BLUE + "" + ChatColor.MAGIC + "|||" + ChatColor.RESET + " " + ChatColor.RED + ChatColor.BOLD + "Hard to get resources in SkyBlock? Use the shop!" + ChatColor.RESET + "" + ChatColor.BLUE + " " + ChatColor.MAGIC + "|||");
		listMiner.add(ChatColor.BLUE + "" + ChatColor.MAGIC + "|||" + ChatColor.RESET + " " + ChatColor.RED + ChatColor.BOLD + "mcMMO is available! Use it to gain amazing advantages." + ChatColor.RESET + "" + ChatColor.BLUE + " " + ChatColor.MAGIC + "|||");
		listMiner.add(ChatColor.BLUE + "" + ChatColor.MAGIC + "|||" + ChatColor.RESET + " " + ChatColor.RED + ChatColor.BOLD + "Want a map of the server? Visit map.craft4plus.ml" + ChatColor.RESET + "" + ChatColor.BLUE + " " + ChatColor.MAGIC + "|||");
		
		String TipsMiner = listMiner.get(new Random().nextInt(listMiner.size()));

		for (Player player : Bukkit.getServer().getOnlinePlayers()) {

			if (PlayerJustJoined != null) {

				if ((!PlayerJustJoined.contains(player.getName())) && (!player.isOp())) {

					if (player.hasPermission("c4p.rank.crafter")) {

						BountifulAPI.sendActionBar(player, TipsCrafter, 100);

					} else {
						if (player.hasPermission("c4p.rank.miner")) {
							BountifulAPI.sendActionBar(player, TipsMiner, 100);
						}

					}

				}
			}
		}
	}
}
package com.craft4plus.ranks;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.craft4plus.main.Main;

import net.md_5.bungee.api.ChatColor;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class RanksCommand extends Ranks implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("ranks")) { // Check for the /ranks command
			if (args.length == 2) { // Check if there are 2 arguments
				if (sender.hasPermission("c4p.ranks.manage")) { // Check if
																// player has
																// the
																// permission
					Player player = Bukkit.getPlayer(args[1]); // Get the player
																// from args1
					if (player != null) { // Check if player is online right now

						if ((args[0].equalsIgnoreCase("Crafter")) || (args[0].equalsIgnoreCase("Miner"))
								|| (args[0].equalsIgnoreCase("Warrior")) || (args[0].equalsIgnoreCase("Archer"))
								|| (args[0].equalsIgnoreCase("Guard")) || (args[0].equalsIgnoreCase("King"))
								|| (args[0].equalsIgnoreCase("Emperor"))) { // Check
																			// if
																			// Args0
																			// is
																			// a
																			// valid
																			// rank
							PermissionUser PexUser = PermissionsEx.getUser(Bukkit.getServer().getPlayer(args[1]));
							
							List<String> PexUserGroups = PexUser.getParentIdentifiers();

							// Remove all groups from player

							if (PexUserGroups.contains("Owner")) {
								Main.permission.playerRemoveGroup(null, player, "Owner");
							}
							if (PexUserGroups.contains("CoOwner")) {
								Main.permission.playerRemoveGroup(null, player, "CoOwner");
							}
							if (PexUserGroups.contains("Mod")) {
								Main.permission.playerRemoveGroup(null, player, "Mod");
							}
							if (PexUserGroups.contains("Dev")) {
								Main.permission.playerRemoveGroup(null, player, "Dev");
							}
							if (PexUserGroups.contains("Builder")) {
								Main.permission.playerRemoveGroup(null, player, "Builder");
							}
							if (PexUserGroups.contains("YouTuber")) {
								Main.permission.playerRemoveGroup(null, player, "YouTuber");
							}
							if (PexUserGroups.contains("Emperor")) {
								Main.permission.playerRemoveGroup(null, player, "Emperor");
							}
							if (PexUserGroups.contains("King")) {
								Main.permission.playerRemoveGroup(null, player, "King");
							}
							if (PexUserGroups.contains("Guard")) {
								Main.permission.playerRemoveGroup(null, player, "Guard");
							}
							if (PexUserGroups.contains("Archer")) {
								Main.permission.playerRemoveGroup(null, player, "Archer");
							}
							if (PexUserGroups.contains("Warrior")) {
								Main.permission.playerRemoveGroup(null, player, "Warrior");
							}
							if (PexUserGroups.contains("Miner")) {
								Main.permission.playerRemoveGroup(null, player, "Miner");
							}
							if (PexUserGroups.contains("Crafter")) {
								Main.permission.playerRemoveGroup(null, player, "Crafter");
							}

							// Add new ranks

							if (args[0].equalsIgnoreCase("Crafter")) {
								Main.permission.playerAddGroup(null, player, "Crafter");
								sender.sendMessage(RanksPrefix + "Added Crafter rank successfully!");
								if (sender.getName() != player.getName()) {
									player.sendMessage(RanksPrefix + "Added to Crafter rank successfully!");
								}
							}

							if (args[0].equalsIgnoreCase("Miner")) {
								Main.permission.playerAddGroup(null, player, "Crafter");
								Main.permission.playerAddGroup(null, player, "Miner");
								sender.sendMessage(RanksPrefix + "Added Miner rank successfully!");
								if (sender.getName() != player.getName()) {
									player.sendMessage(RanksPrefix + "Added to Miner rank successfully!");
								}
							}

							if (args[0].equalsIgnoreCase("Warrior")) {
								Main.permission.playerAddGroup(null, player, "Crafter");
								Main.permission.playerAddGroup(null, player, "Miner");
								Main.permission.playerAddGroup(null, player, "Warrior");
								sender.sendMessage(RanksPrefix + "Added Warrior rank successfully!");
								if (sender.getName() != player.getName()) {
									player.sendMessage(RanksPrefix + "Added to Warrior rank successfully!");
								}
							}

							if (args[0].equalsIgnoreCase("Archer")) {
								Main.permission.playerAddGroup(null, player, "Crafter");
								Main.permission.playerAddGroup(null, player, "Miner");
								Main.permission.playerAddGroup(null, player, "Warrior");
								Main.permission.playerAddGroup(null, player, "Archer");
								sender.sendMessage(RanksPrefix + "Added Archer rank successfully!");
								if (sender.getName() != player.getName()) {
									player.sendMessage(RanksPrefix + "Added to Archer rank successfully!");
								}
							}

							if (args[0].equalsIgnoreCase("Guard")) {
								Main.permission.playerAddGroup(null, player, "Crafter");
								Main.permission.playerAddGroup(null, player, "Miner");
								Main.permission.playerAddGroup(null, player, "Warrior");
								Main.permission.playerAddGroup(null, player, "Archer");
								Main.permission.playerAddGroup(null, player, "Guard");
								sender.sendMessage(RanksPrefix + "Added Guard rank successfully!");
								if (sender.getName() != player.getName()) {
									player.sendMessage(RanksPrefix + "Added to Guard rank successfully!");
								}
							}

							if (args[0].equalsIgnoreCase("King")) {
								Main.permission.playerAddGroup(null, player, "Crafter");
								Main.permission.playerAddGroup(null, player, "Miner");
								Main.permission.playerAddGroup(null, player, "Warrior");
								Main.permission.playerAddGroup(null, player, "Archer");
								Main.permission.playerAddGroup(null, player, "Guard");
								Main.permission.playerAddGroup(null, player, "King");
								sender.sendMessage(RanksPrefix + "Added King rank successfully!");
								if (sender.getName() != player.getName()) {
									player.sendMessage(RanksPrefix + "Added to King rank successfully!");
								}
							}

							if (args[0].equalsIgnoreCase("Emperor")) {
								Main.permission.playerAddGroup(null, player, "Crafter");
								Main.permission.playerAddGroup(null, player, "Miner");
								Main.permission.playerAddGroup(null, player, "Warrior");
								Main.permission.playerAddGroup(null, player, "Archer");
								Main.permission.playerAddGroup(null, player, "Guard");
								Main.permission.playerAddGroup(null, player, "King");
								Main.permission.playerAddGroup(null, player, "Emperor");
								sender.sendMessage(RanksPrefix + "Added Emperor rank successfully!");
								if (sender.getName() != player.getName()) {
									sender.sendMessage(RanksPrefix + "Added to Emperor rank successfully!");
								}
							}

							// Restore old ranks

							if (PexUserGroups.contains("Owner")) {
								Main.permission.playerAddGroup(null, player, "Owner");
								sender.sendMessage(RanksPrefix + "Added Owner rank successfully!");
							} else {
								if (PexUserGroups.contains("CoOwner")) {
									Main.permission.playerAddGroup(null, player, "CoOwner");
									sender.sendMessage(RanksPrefix + "Added CoOwner rank successfully!");
								} else {
									if (PexUserGroups.contains("Mod")) {
										Main.permission.playerAddGroup(null, player, "Mod");
										sender.sendMessage(RanksPrefix + "Added Mod rank successfully!");
									} else {
										if (PexUserGroups.contains("Dev")) {
											Main.permission.playerAddGroup(null, player, "Dev");
											sender.sendMessage(RanksPrefix + "Added Dev rank successfully!");
										} else {
											if (PexUserGroups.contains("Builder")) {
												Main.permission.playerAddGroup(null, player, "Builder");
												sender.sendMessage(RanksPrefix + "Added  rank successfully!");
											} else {
												if (PexUserGroups.contains("YouTuber")) {
													Main.permission.playerAddGroup(null, player, "YouTuber");
													sender.sendMessage(
															RanksPrefix + "Added YouTuber rank successfully!");
												}
											}
										}
									}
								}

							}

							return true;

						} else {

							if (sender.isOp()) {

								if ((args[0].equalsIgnoreCase("Owner")) || (args[0].equalsIgnoreCase("CoOwner"))
										|| (args[0].equalsIgnoreCase("Mod")) || (args[0].equalsIgnoreCase("Dev"))
										|| (args[0].equalsIgnoreCase("Builder"))
										|| (args[0].equalsIgnoreCase("YouTuber"))) { // Check
									// if
									// Args0
									// is
									// a
									// valid
									// rank
									PermissionUser PexUser = PermissionsEx
											.getUser(Bukkit.getServer().getPlayer(args[1]));

									List<String> PexUserGroups = PexUser.getParentIdentifiers();

									// Remove all groups from player

									if (PexUserGroups.contains("Owner")) {
										Main.permission.playerRemoveGroup(null, player, "Owner");
									}
									if (PexUserGroups.contains("CoOwner")) {
										Main.permission.playerRemoveGroup(null, player, "CoOwner");
									}
									if (PexUserGroups.contains("Mod")) {
										Main.permission.playerRemoveGroup(null, player, "Mod");
									}
									if (PexUserGroups.contains("Dev")) {
										Main.permission.playerRemoveGroup(null, player, "Dev");
									}
									if (PexUserGroups.contains("Builder")) {
										Main.permission.playerRemoveGroup(null, player, "Builder");
									}
									if (PexUserGroups.contains("YouTuber")) {
										Main.permission.playerRemoveGroup(null, player, "YouTuber");
									}
									if (PexUserGroups.contains("Emperor")) {
										Main.permission.playerRemoveGroup(null, player, "Emperor");
									}
									if (PexUserGroups.contains("King")) {
										Main.permission.playerRemoveGroup(null, player, "King");
									}
									if (PexUserGroups.contains("Guard")) {
										Main.permission.playerRemoveGroup(null, player, "Guard");
									}
									if (PexUserGroups.contains("Archer")) {
										Main.permission.playerRemoveGroup(null, player, "Archer");
									}
									if (PexUserGroups.contains("Warrior")) {
										Main.permission.playerRemoveGroup(null, player, "Warrior");
									}
									if (PexUserGroups.contains("Miner")) {
										Main.permission.playerRemoveGroup(null, player, "Miner");
									}
									if (PexUserGroups.contains("Crafter")) {
										Main.permission.playerRemoveGroup(null, player, "Crafter");
									}

									// Restore old ranks

									if (PexUserGroups.contains("Crafter")) {
										Main.permission.playerAddGroup(null, player, "Crafter");
									}
									if (PexUserGroups.contains("Miner")) {
										Main.permission.playerAddGroup(null, player, "Miner");
									}
									if (PexUserGroups.contains("Warrior")) {
										Main.permission.playerAddGroup(null, player, "Warrior");
									}
									if (PexUserGroups.contains("Archer")) {
										Main.permission.playerAddGroup(null, player, "Archer");
									}
									if (PexUserGroups.contains("Guard")) {
										Main.permission.playerAddGroup(null, player, "Guard");
									}
									if (PexUserGroups.contains("King")) {
										Main.permission.playerAddGroup(null, player, "King");
									}
									if (PexUserGroups.contains("Emperor")) {
										Main.permission.playerAddGroup(null, player, "Emperor");
									}

									// Add new ranks

									if (args[0].equalsIgnoreCase("Owner")) {
										Main.permission.playerAddGroup(null, player, "Owner");
										sender.sendMessage(RanksPrefix + "Added Owner rank successfully!");
										if (sender.getName() != player.getName()) {
											sender.sendMessage(RanksPrefix + "Added to Owner rank successfully!");
										}
									}

									if (args[0].equalsIgnoreCase("CoOwner")) {
										Main.permission.playerAddGroup(null, player, "CoOwner");
										sender.sendMessage(RanksPrefix + "Added CoOwner rank successfully!");
										if (sender.getName() != player.getName()) {
											sender.sendMessage(RanksPrefix + "Added to CoOwner rank successfully!");
										}
									}

									if (args[0].equalsIgnoreCase("Mod")) {
										Main.permission.playerAddGroup(null, player, "Mod");
										sender.sendMessage(RanksPrefix + "Added Mod rank successfully!");
										if (sender.getName() != player.getName()) {
											sender.sendMessage(RanksPrefix + "Added to Mod rank successfully!");
										}
									}

									if (args[0].equalsIgnoreCase("Dev")) {
										Main.permission.playerAddGroup(null, player, "Dev");
										sender.sendMessage(RanksPrefix + "Added Dev rank successfully!");
										if (sender.getName() != player.getName()) {
											sender.sendMessage(RanksPrefix + "Added to Dev rank successfully!");
										}
									}

									if (args[0].equalsIgnoreCase("Builder")) {
										Main.permission.playerAddGroup(null, player, "Builder");
										sender.sendMessage(RanksPrefix + "Added Builder rank successfully!");
										if (sender.getName() != player.getName()) {
											sender.sendMessage(RanksPrefix + "Added to Builder rank successfully!");
										}
									}

									if (args[0].equalsIgnoreCase("YouTuber")) {
										Main.permission.playerAddGroup(null, player, "YouTuber");
										sender.sendMessage(RanksPrefix + "Added YouTuber rank successfully!");
										if (sender.getName() != player.getName()) {
											sender.sendMessage(RanksPrefix + "Added to YouTuber rank successfully!");
										}
									}

									return true;

								} else {
									sender.sendMessage(RanksPrefix + ChatColor.RED + args[1] + "is not a valid rank!");
									return false;
								}

							} else {
								sender.sendMessage(
										RanksPrefix + ChatColor.RED + "You do not have access to this command.");
								return false;
							}
						}
					} else {

						if ((args[0].equalsIgnoreCase("Crafter")) || (args[0].equalsIgnoreCase("Miner"))
								|| (args[0].equalsIgnoreCase("Warrior")) || (args[0].equalsIgnoreCase("Archer"))
								|| (args[0].equalsIgnoreCase("Guard")) || (args[0].equalsIgnoreCase("King"))
								|| (args[0].equalsIgnoreCase("Emperor"))) { // Check
																			// if
																			// Args0
																			// is
																			// a
																			// valid
																			// rank

							@SuppressWarnings("deprecation")
							OfflinePlayer offlineplayer = Bukkit.getOfflinePlayer(args[1]);

							String[] StringPexUserGroups = Main.permission.getPlayerGroups(null, offlineplayer);

							List<String> PexUserGroups = Arrays.asList(StringPexUserGroups);

							// Remove all groups from player

							if (PexUserGroups.contains("Owner")) {
								Main.permission.playerRemoveGroup(null, offlineplayer, "Owner");
							}
							if (PexUserGroups.contains("CoOwner")) {
								Main.permission.playerRemoveGroup(null, offlineplayer, "CoOwner");
							}
							if (PexUserGroups.contains("Mod")) {
								Main.permission.playerRemoveGroup(null, offlineplayer, "Mod");
							}
							if (PexUserGroups.contains("Dev")) {
								Main.permission.playerRemoveGroup(null, offlineplayer, "Dev");
							}
							if (PexUserGroups.contains("Builder")) {
								Main.permission.playerRemoveGroup(null, offlineplayer, "Builder");
							}
							if (PexUserGroups.contains("YouTuber")) {
								Main.permission.playerRemoveGroup(null, offlineplayer, "YouTuber");
							}
							if (PexUserGroups.contains("Emperor")) {
								Main.permission.playerRemoveGroup(null, offlineplayer, "Emperor");
							}
							if (PexUserGroups.contains("King")) {
								Main.permission.playerRemoveGroup(null, offlineplayer, "King");
							}
							if (PexUserGroups.contains("Guard")) {
								Main.permission.playerRemoveGroup(null, offlineplayer, "Guard");
							}
							if (PexUserGroups.contains("Archer")) {
								Main.permission.playerRemoveGroup(null, offlineplayer, "Archer");
							}
							if (PexUserGroups.contains("Warrior")) {
								Main.permission.playerRemoveGroup(null, offlineplayer, "Warrior");
							}
							if (PexUserGroups.contains("Miner")) {
								Main.permission.playerRemoveGroup(null, offlineplayer, "Miner");
							}
							if (PexUserGroups.contains("Crafter")) {
								Main.permission.playerRemoveGroup(null, offlineplayer, "Crafter");
							}

							// Add new ranks

							if (args[0].equalsIgnoreCase("Crafter")) {
								Main.permission.playerAddGroup(null, offlineplayer, "Crafter");
								sender.sendMessage(RanksPrefix + "Added Crafter rank successfully!");
							}

							if (args[0].equalsIgnoreCase("Miner")) {
								Main.permission.playerAddGroup(null, offlineplayer, "Crafter");
								Main.permission.playerAddGroup(null, offlineplayer, "Miner");
								sender.sendMessage(RanksPrefix + "Added Miner rank successfully!");
							}

							if (args[0].equalsIgnoreCase("Warrior")) {
								Main.permission.playerAddGroup(null, offlineplayer, "Crafter");
								Main.permission.playerAddGroup(null, offlineplayer, "Miner");
								Main.permission.playerAddGroup(null, offlineplayer, "Warrior");
								sender.sendMessage(RanksPrefix + "Added Warrior rank successfully!");
							}

							if (args[0].equalsIgnoreCase("Archer")) {
								Main.permission.playerAddGroup(null, offlineplayer, "Crafter");
								Main.permission.playerAddGroup(null, offlineplayer, "Miner");
								Main.permission.playerAddGroup(null, offlineplayer, "Warrior");
								Main.permission.playerAddGroup(null, offlineplayer, "Archer");
								sender.sendMessage(RanksPrefix + "Added Archer rank successfully!");
							}

							if (args[0].equalsIgnoreCase("Guard")) {
								Main.permission.playerAddGroup(null, offlineplayer, "Crafter");
								Main.permission.playerAddGroup(null, offlineplayer, "Miner");
								Main.permission.playerAddGroup(null, offlineplayer, "Warrior");
								Main.permission.playerAddGroup(null, offlineplayer, "Archer");
								Main.permission.playerAddGroup(null, offlineplayer, "Guard");
								sender.sendMessage(RanksPrefix + "Added Guard rank successfully!");
							}

							if (args[0].equalsIgnoreCase("King")) {
								Main.permission.playerAddGroup(null, offlineplayer, "Crafter");
								Main.permission.playerAddGroup(null, offlineplayer, "Miner");
								Main.permission.playerAddGroup(null, offlineplayer, "Warrior");
								Main.permission.playerAddGroup(null, offlineplayer, "Archer");
								Main.permission.playerAddGroup(null, offlineplayer, "Guard");
								Main.permission.playerAddGroup(null, offlineplayer, "King");
								sender.sendMessage(RanksPrefix + "Added King rank successfully!");
							}

							if (args[0].equalsIgnoreCase("Emperor")) {
								Main.permission.playerAddGroup(null, offlineplayer, "Crafter");
								Main.permission.playerAddGroup(null, offlineplayer, "Miner");
								Main.permission.playerAddGroup(null, offlineplayer, "Warrior");
								Main.permission.playerAddGroup(null, offlineplayer, "Archer");
								Main.permission.playerAddGroup(null, offlineplayer, "Guard");
								Main.permission.playerAddGroup(null, offlineplayer, "King");
								Main.permission.playerAddGroup(null, offlineplayer, "Emperor");
								sender.sendMessage(RanksPrefix + "Added Emperor rank successfully!");
							}

							// Restore old ranks

							if (PexUserGroups.contains("Owner")) {
								Main.permission.playerAddGroup(null, offlineplayer, "Owner");
								sender.sendMessage(RanksPrefix + "Added Owner rank successfully!");
							} else {
								if (PexUserGroups.contains("CoOwner")) {
									Main.permission.playerAddGroup(null, offlineplayer, "CoOwner");
									sender.sendMessage(RanksPrefix + "Added CoOwner rank successfully!");
								} else {
									if (PexUserGroups.contains("Mod")) {
										Main.permission.playerAddGroup(null, offlineplayer, "Mod");
										sender.sendMessage(RanksPrefix + "Added Mod rank successfully!");
									} else {
										if (PexUserGroups.contains("Dev")) {
											Main.permission.playerAddGroup(null, offlineplayer, "Dev");
											sender.sendMessage(RanksPrefix + "Added Dev rank successfully!");
										} else {
											if (PexUserGroups.contains("Builder")) {
												Main.permission.playerAddGroup(null, offlineplayer, "Builder");
												sender.sendMessage(RanksPrefix + "Added  rank successfully!");
											} else {
												if (PexUserGroups.contains("YouTuber")) {
													Main.permission.playerAddGroup(null, offlineplayer, "YouTuber");
													sender.sendMessage(
															RanksPrefix + "Added YouTuber rank successfully!");
												}
											}
										}
									}
								}

							}

							return true;

						} else {

							if (sender.isOp()) {

								if ((args[0].equalsIgnoreCase("Owner")) || (args[0].equalsIgnoreCase("CoOwner"))
										|| (args[0].equalsIgnoreCase("Mod")) || (args[0].equalsIgnoreCase("Dev"))
										|| (args[0].equalsIgnoreCase("Builder"))
										|| (args[0].equalsIgnoreCase("YouTuber"))) { // Check
									// if
									// Args0
									// is
									// a
									// valid
									// rank

									@SuppressWarnings("deprecation")
									OfflinePlayer offlineplayer = Bukkit.getOfflinePlayer(args[1]);

									String[] StringPexUserGroups = Main.permission.getPlayerGroups(null, offlineplayer);

									List<String> PexUserGroups = Arrays.asList(StringPexUserGroups);

									// Remove all groups from player

									if (PexUserGroups.contains("Owner")) {
										Main.permission.playerRemoveGroup(null, offlineplayer, "Owner");
									}
									if (PexUserGroups.contains("CoOwner")) {
										Main.permission.playerRemoveGroup(null, offlineplayer, "CoOwner");
									}
									if (PexUserGroups.contains("Mod")) {
										Main.permission.playerRemoveGroup(null, offlineplayer, "Mod");
									}
									if (PexUserGroups.contains("Dev")) {
										Main.permission.playerRemoveGroup(null, offlineplayer, "Dev");
									}
									if (PexUserGroups.contains("Builder")) {
										Main.permission.playerRemoveGroup(null, offlineplayer, "Builder");
									}
									if (PexUserGroups.contains("YouTuber")) {
										Main.permission.playerRemoveGroup(null, offlineplayer, "YouTuber");
									}
									if (PexUserGroups.contains("Emperor")) {
										Main.permission.playerRemoveGroup(null, offlineplayer, "Emperor");
									}
									if (PexUserGroups.contains("King")) {
										Main.permission.playerRemoveGroup(null, offlineplayer, "King");
									}
									if (PexUserGroups.contains("Guard")) {
										Main.permission.playerRemoveGroup(null, offlineplayer, "Guard");
									}
									if (PexUserGroups.contains("Archer")) {
										Main.permission.playerRemoveGroup(null, offlineplayer, "Archer");
									}
									if (PexUserGroups.contains("Warrior")) {
										Main.permission.playerRemoveGroup(null, offlineplayer, "Warrior");
									}
									if (PexUserGroups.contains("Miner")) {
										Main.permission.playerRemoveGroup(null, offlineplayer, "Miner");
									}
									if (PexUserGroups.contains("Crafter")) {
										Main.permission.playerRemoveGroup(null, offlineplayer, "Crafter");
									}

									// Restore old ranks

									if (PexUserGroups.contains("Crafter")) {
										Main.permission.playerAddGroup(null, offlineplayer, "Crafter");
									}
									if (PexUserGroups.contains("Miner")) {
										Main.permission.playerAddGroup(null, offlineplayer, "Miner");
									}
									if (PexUserGroups.contains("Warrior")) {
										Main.permission.playerAddGroup(null, offlineplayer, "Warrior");
									}
									if (PexUserGroups.contains("Archer")) {
										Main.permission.playerAddGroup(null, offlineplayer, "Archer");
									}
									if (PexUserGroups.contains("Guard")) {
										Main.permission.playerAddGroup(null, offlineplayer, "Guard");
									}
									if (PexUserGroups.contains("King")) {
										Main.permission.playerAddGroup(null, offlineplayer, "King");
									}
									if (PexUserGroups.contains("Emperor")) {
										Main.permission.playerAddGroup(null, offlineplayer, "Emperor");
									}

									// Add new ranks

									if (args[0].equalsIgnoreCase("Owner")) {
										Main.permission.playerAddGroup(null, offlineplayer, "Owner");
										sender.sendMessage(RanksPrefix + "Added Owner rank successfully!");
									}

									if (args[0].equalsIgnoreCase("CoOwner")) {
										Main.permission.playerAddGroup(null, offlineplayer, "CoOwner");
										sender.sendMessage(RanksPrefix + "Added CoOwner rank successfully!");
									}

									if (args[0].equalsIgnoreCase("Mod")) {
										Main.permission.playerAddGroup(null, offlineplayer, "Mod");
										sender.sendMessage(RanksPrefix + "Added Mod rank successfully!");
									}

									if (args[0].equalsIgnoreCase("Dev")) {
										Main.permission.playerAddGroup(null, offlineplayer, "Dev");
										sender.sendMessage(RanksPrefix + "Added Dev rank successfully!");
									}

									if (args[0].equalsIgnoreCase("Builder")) {
										Main.permission.playerAddGroup(null, offlineplayer, "Builder");
										sender.sendMessage(RanksPrefix + "Added Builder rank successfully!");
									}

									if (args[0].equalsIgnoreCase("YouTuber")) {
										Main.permission.playerAddGroup(null, offlineplayer, "YouTuber");
										sender.sendMessage(RanksPrefix + "Added YouTuber rank successfully!");
									}

									return true;

								} else {
									sender.sendMessage(RanksPrefix + ChatColor.RED + args[1] + "is not a valid rank!");
									return false;
								}

							} else {
								sender.sendMessage(
										RanksPrefix + ChatColor.RED + "You do not have access to this command.");
								return false;
							}
						}

					}

				} else {
					sender.sendMessage(RanksPrefix + ChatColor.RED + "You do not have access to this command.");
					return false;
				}

			} else {
				if (args.length < 2) { // Check for 1 or 0 arguments.
					sender.sendMessage(
							RanksPrefix + ChatColor.RED + "Too few arguements! Usage: /ranks <rankname> <player>");
					return false;
				} else { // We're sure sender has more arguments at this
							// point.
					sender.sendMessage(
							RanksPrefix + ChatColor.RED + "Too many arguements! Usage: /ranks <rankname> <player>");
					return false;
				}
			}
		}

		return false;

	}

}
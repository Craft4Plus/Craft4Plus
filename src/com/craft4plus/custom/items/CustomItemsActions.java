package com.craft4plus.custom.items;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Color;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.inventivetalent.particle.ParticleEffect;

import com.connorlinfoot.bountifulapi.BountifulAPI;

import net.md_5.bungee.api.ChatColor;

public class CustomItemsActions {
	
	// === ANY CUSTOM ITEM === //
	
	public static void customItemCheck(Player player) {
		if ((!player.getInventory().getItemInMainHand().getType().equals(Material.AIR))
				&& (getCustomItemDurability(player.getInventory().getItemInMainHand()) != 123456789)
				&& (player.getInventory().getItemInMainHand().getDurability() >= getCustomItemDurability(player.getInventory().getItemInMainHand()))) {
			player.getInventory().removeItem(player.getInventory().getItemInMainHand()); 
			player.playSound(player.getLocation(), Sound.ENTITY_ITEM_BREAK, 1.0F, 1.0F);
		}

	}
	
	public static int getCustomItemDurability(ItemStack item) {
		if ((!item.getType().equals(Material.AIR)) && (item.getItemMeta() != null) && (!item.getItemMeta().spigot().isUnbreakable())) {
			Material m = item.getType();
			if ((m.equals(Material.DIAMOND_SWORD)) || (m.equals(Material.DIAMOND_AXE))
					|| (m.equals(Material.DIAMOND_PICKAXE)) || (m.equals(Material.DIAMOND_SPADE))
					|| (m.equals(Material.DIAMOND_HOE))) {
				return 1560;
			}
			if ((m.equals(Material.STONE_SWORD)) || (m.equals(Material.STONE_PICKAXE)) || (m.equals(Material.STONE_SPADE))
					|| (m.equals(Material.STONE_HOE))) {
				return 130;
			}
			if (m.equals(Material.WOOD_AXE)) {
				return 58;
			}
			if (m.equals(Material.STONE_AXE)) {
				return 128;
			}
			if (m.equals(Material.IRON_AXE)) {
				return 250;
			}
			if (m.equals(Material.GOLD_AXE)) {
				return 28;
			}
			return 123456789;
		}
		return 123456789;
	}

	public static void reduceDurability(ItemStack item, Player player, int durabilitytoremove) {
		if (player.getGameMode() != GameMode.CREATIVE) {
			if (item.getItemMeta().getLore() != null) {
				List<String> lore = item.getItemMeta().getLore();
				for (String string : lore) {
					if (string.startsWith(ChatColor.GRAY + "Durability: ")) {
						String durability = string.replaceFirst(ChatColor.GRAY + "Durability: ", "");
						String segments[] = durability.split(" / ");
						int finaldurability = Integer.parseInt(segments[0]) - durabilitytoremove;
						String newstring = string.replaceFirst("Durability: " + segments[0],
								"Durability: " + Integer.toString(finaldurability));
						lore.remove(string);
						lore.add(newstring);
						if (finaldurability <= 10) {
							BountifulAPI.sendActionBar(player,
									ChatColor.RED + "" + ChatColor.BOLD + "Item Durability Low!");
							String redstring = newstring.replaceAll(ChatColor.GRAY + "", ChatColor.RED + "");
							lore.remove(newstring);
							lore.add(redstring);
						}
					} else if (string.startsWith(ChatColor.RED + "Durability: ")) {
						String durability = string.replaceFirst(ChatColor.RED + "Durability: ", "");
						String segments[] = durability.split(" / ");
						int finaldurability = Integer.parseInt(segments[0]) - durabilitytoremove;
						if (finaldurability == 0) {
							player.getInventory().removeItem(player.getInventory().getItemInMainHand());
							player.playSound(player.getLocation(), Sound.ENTITY_ITEM_BREAK, 1.0F, 1.0F);
							return;
						} else {
							String newstring = string.replaceFirst("Durability: " + segments[0],
									"Durability: " + Integer.toString(finaldurability));
							BountifulAPI.sendActionBar(player,
									ChatColor.RED + "" + ChatColor.BOLD + "Item Durability Low!");
							String redstring = newstring.replaceAll(ChatColor.RED + "", ChatColor.RED + "");
							lore.remove(string);
							lore.remove(newstring);
							lore.add(redstring);
						}
					}
				}
				ItemMeta im = item.getItemMeta();
				im.setDisplayName(im.getDisplayName());
				im.setLore(lore);
				item.setItemMeta(im);
			}
		}
	}


	// === DOUBLE AXES === //
	
	public static boolean isDoubleAxe(ItemStack item) {
		if (!item.getType().equals(Material.AIR) && (item.getItemMeta() != null) && item.getItemMeta().spigot().isUnbreakable()) {
			Material m = item.getType();
			if ((m.equals(Material.WOOD_AXE) && item.getDurability() == 59)
					|| (m.equals(Material.STONE_AXE) && item.getDurability() == 131)
					|| (m.equals(Material.IRON_AXE) && item.getDurability() == 250)
					|| (m.equals(Material.GOLD_AXE) && item.getDurability() == 29)
					|| (m.equals(Material.GOLD_AXE) && item.getDurability() == 30)
					|| (m.equals(Material.GOLD_AXE) && item.getDurability() == 31)) {
				return true;
			}
			return false;
		}
		return false;
	}
	
	// === STONE ARMOR ===
	
	public static boolean isStoneArmor(ItemStack item) {
		if (item != null) {
			Material m = item.getType();
			if ((m.equals(Material.LEATHER_HELMET)) || (m.equals(Material.LEATHER_CHESTPLATE))
					|| (m.equals(Material.LEATHER_LEGGINGS)) || (m.equals(Material.LEATHER_BOOTS))) {
				LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
				Color color = meta.getColor();
				if ((color.getRed() == 103) && (color.getBlue() == 103) && (color.getGreen() == 103)) {
					return true;
				}
				if ((color.getRed() == 168) && (color.getBlue() == 100) && (color.getGreen() == 168)) {
					return true;
				}
				return false;
			}
			return false;
		}
		return false;
	}
	
	// === END STONE ITEMS === //
	
	public static boolean isEndStoneSword(ItemStack item) {
		if (item.getItemMeta().spigot().isUnbreakable()) {
			Material m = item.getType();
			if (m.equals(Material.STONE_SWORD) && item.getDurability() == 131) {
				return true;
			}
			return false;
		}
		return false;
	}
	
	public static boolean isEndStoneItem(ItemStack item) {
		if (item.getItemMeta().spigot().isUnbreakable()) {
			Material m = item.getType();
			if ((m.equals(Material.STONE_AXE) && item.getDurability() == 130)
					|| (m.equals(Material.STONE_AXE) && item.getDurability() == 129)
					|| (m.equals(Material.STONE_SPADE) && item.getDurability() == 131)
					|| (m.equals(Material.STONE_PICKAXE) && item.getDurability() == 131)
					|| (m.equals(Material.STONE_HOE) && item.getDurability() == 131)) {
				return true;
			}
			return false;
		}
		return false;
	}
	
	// === CUSTOM FOOD === //
	
	public static boolean isCustomFood(ItemStack item, Material material) {
		if (material == Material.DIAMOND_SWORD) {
			if ((item.getDurability() >= 1560) && (item.getDurability() <= 1560)) return true;
		}
		return false;
	}
	
	public static void addFood(Player player, ItemStack item, Material material) {
		if (material == Material.DIAMOND_SWORD) {
			if (item.getDurability() == 1560) {
				player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 2400, 0));
				player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 100, 1));
				addToFoodLevel(player, 4);
				addToSaturationLevel(player, 9.6F);
			}
		}
	}
	
	public static void addToFoodLevel(Player player, int FoodLevel) {
		if (player.getFoodLevel() > 20 - FoodLevel) {
			player.setFoodLevel(20);
		}
		player.setFoodLevel(player.getFoodLevel() + FoodLevel);
	}
	
	public static void addToSaturationLevel(Player player, float SaturationLevel) {
		if (player.getSaturation() > 20F - SaturationLevel) {
			player.setSaturation(20F);
		}
		player.setSaturation(player.getSaturation() + SaturationLevel);
	}
	
	@SuppressWarnings("deprecation")
	public static void addEatingFoodEffects(Player player, Integer ticks, Material EffectLook) {
		Location location = player.getLocation();
		Material block = new Location(player.getWorld(), location.getBlockX(),
				location.getBlockY() - 1, location.getBlockZ()).getBlock().getType();
		if (block != Material.AIR && block != Material.WATER && block != Material.LAVA && block != Material.LADDER && !player.isInsideVehicle()) {
			player.setVelocity(player.getVelocity().multiply(0.5));
		}
		player.playSound(location, Sound.ENTITY_GENERIC_EAT, 1.0F, 1.0F);
		Location eye = player.getEyeLocation();
		List<Player> list = new ArrayList<Player>();
		list.add(player);
		ParticleEffect.BLOCK_CRACK.sendData(list, eye.getX(), eye.getY(), eye.getZ(), 2, 2, 2, ticks, 200, Material.GOLD_BLOCK.getId(), (byte)0x01);
	}
	
	// === END OF CUSTOM FOOD === //
	
	// === SLIME ARMOR === //
	public static boolean isSlimeBoots(ItemStack item) {
		if (item != null) {
			Material m = item.getType();
			if (m.equals(Material.LEATHER_BOOTS)) {
				LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
				Color color = meta.getColor();
				if ((color.getRed() == 132) && (color.getBlue() == 115) && (color.getGreen() == 200)) {
					return true;
				}
				return false;
			}
			return false;
		}
		return false;
	}
	
	// === END OF SLIME ARMOR === //
	
}
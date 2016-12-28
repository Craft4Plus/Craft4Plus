package com.craft4plus.custom.items;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.SandstoneType;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.inventivetalent.particle.ParticleEffect;

import com.connorlinfoot.bountifulapi.BountifulAPI;
import com.craft4plus.main.Main;

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
			if (m.equals(Material.DIAMOND_SWORD))
				return 1543;
			if ((m.equals(Material.DIAMOND_AXE)) || (m.equals(Material.DIAMOND_SPADE))
					|| (m.equals(Material.DIAMOND_HOE)))
				return 1560;
			if (m.equals(Material.DIAMOND_PICKAXE))
				return 1558;
			if ((m.equals(Material.STONE_SWORD)) || (m.equals(Material.STONE_SPADE)) || (m.equals(Material.STONE_HOE)))
				return 130;
			if (m.equals(Material.WOOD_AXE))
				return 58;
			if (m.equals(Material.STONE_AXE))
				return 128;
			if (m.equals(Material.IRON_AXE))
				return 250;
			if (m.equals(Material.GOLD_AXE))
				return 28;
			if (m.equals(Material.WOOD_PICKAXE))
				return 58;
			if (m.equals(Material.STONE_PICKAXE))
				return 128;
			if (m.equals(Material.IRON_PICKAXE))
				return 249;
			if (m.equals(Material.GOLD_PICKAXE))
				return 31;
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
	

	// === SUPER HOES === //

	public static List<Block> getSquareRadius(Block block, int radius) {
		List<Block> blocks = new ArrayList<Block>();

		World world = block.getWorld();

		int centerX = block.getX();
		int centerY = block.getY();
		int centerZ = block.getZ();

		for (int x = centerX - radius; x < centerX + radius; x++) {
			for (int y = centerY - radius; y < centerY + radius; y++) {
				for (int z = centerZ - radius; z < centerZ + radius; z++) {
					blocks.add(world.getBlockAt(x, y, z));
				}
			}
		}

		return blocks;
	}
	
	@SuppressWarnings("deprecation")
	public static int breakSeedsInRadius(Block block, int radius) {		
       
		List<Block> blocks = getSquareRadius(block, radius);
        
        Long delay = 0L;
        int blocksbroken = 0;
        Collection<? extends Player> players = Bukkit.getOnlinePlayers();
        World world = block.getWorld();
        
        for (Block b : blocks) {
			int material = b.getTypeId();
        	if (material == 59 || material == 141 || material == 142 || material == 207) {
        		delay++;
        		blocksbroken++;
        		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
        			@Override
        			public void run() {
        				if (b.getTypeId() == material) {
        					b.breakNaturally();
        					ParticleEffect.BLOCK_CRACK.sendData(players, b.getX(), b.getY(), b.getZ(), 2, 2, 2, 1, 100, material, (byte)0x01);
        					world.playSound(b.getLocation(), Sound.BLOCK_GRASS_BREAK, 1.0F, 1.0F);
        				}
        			}
        		}, delay);
        	}
        }
        
        return blocksbroken;
	}
	
	public static boolean isSickle(ItemStack item) {
		if (item != null && item.getType() == Material.DIAMOND_SWORD) {
			int durability = item.getDurability();
			if (durability <= 1559 && durability >= 1553)
				return true;
		}
		return false;
	}
	
	public static int getSickleBreakRadius(ItemStack item) {
		if (!isSickle(item)) return 0;
		int durability = item.getDurability();
		if (durability == 1559) return 1;
		if (durability == 1558 || durability == 1557) return 2;
		if (durability == 1556) return 3;
		if (durability == 1555) return 4;
		if (durability == 1554 || durability == 1553) return 5;
		return 0;
	}
	
	public static Material getSickleMaterial(ItemStack item) {
		if (!isSickle(item)) return null;
		int durability = item.getDurability();
		if (durability == 1559) return Material.WOOD;
		if (durability == 1558) return Material.STONE;
		if (durability == 1557) return Material.ENDER_STONE;
		if (durability == 1556) return Material.IRON_INGOT;
		if (durability == 1555) return Material.GOLD_INGOT;
		if (durability == 1554) return Material.DIAMOND;
		if (durability == 1553) return Material.EMERALD;
		return null;
	}
	
	// === SLIME BUCKETS === //
	
	public static boolean isSlimeBucket(ItemStack item) {
		if (isSimpleSlimeBucket(item)) return true;
		if (isHoppingSlimeBucket(item)) return true;
		return false;
	}
	
	public static boolean isSimpleSlimeBucket(ItemStack item) {
		if (item != null && item.getType() == Material.DIAMOND_SWORD && item.getDurability() == 1552) return true;
		return false;
	}
	
	public static boolean isHoppingSlimeBucket(ItemStack item) {
		if (item != null && item.getType() == Material.DIAMOND_SWORD && item.getDurability() == 1551) return true;
		return false;
	}
	
	// === CHISELS === //
	
	public static boolean isChisel(ItemStack item) {
		if (item != null) {
			int durability = item.getDurability();
			Material type = item.getType();
			if (durability == 59 && type == Material.WOOD_PICKAXE)
				return true;
			if (durability == 130 && type == Material.STONE_PICKAXE)
				return true;
			if (durability == 129 && type == Material.STONE_PICKAXE)
				return true;
			if (durability == 250 && type == Material.IRON_PICKAXE)
				return true;
			if (durability == 31 && type == Material.GOLD_PICKAXE)
				return true;
			if (durability == 1560 && type == Material.DIAMOND_PICKAXE)
				return true;
			if (durability == 1559 && type == Material.DIAMOND_PICKAXE)
				return true;
		}
		return false;
	}
	
	public static Material getChiselMaterial(ItemStack item) {
		if (item != null) {
			int durability = item.getDurability();
			Material type = item.getType();
			if (durability == 59 && type == Material.WOOD_PICKAXE)
				return Material.WOOD;
			if (durability == 130 && type == Material.STONE_PICKAXE)
				return Material.STONE;
			if (durability == 129 && type == Material.STONE_PICKAXE)
				return Material.ENDER_STONE;
			if (durability == 250 && type == Material.IRON_PICKAXE)
				return Material.IRON_INGOT;
			if (durability == 31 && type == Material.GOLD_PICKAXE)
				return Material.GOLD_INGOT;
			if (durability == 1560 && type == Material.DIAMOND_PICKAXE)
				return Material.DIAMOND;
			if (durability == 1559 && type == Material.DIAMOND_PICKAXE)
				return Material.EMERALD;
		}
		return null;
	}
	
	@SuppressWarnings("deprecation")
	public static void convertToChiseled(Block block) {
		Material type = block.getType();
		byte data = block.getData();
		if (type == Material.SANDSTONE) {
			if (data == (byte)0) {
				block.setTypeIdAndData(Material.SANDSTONE.getId(), SandstoneType.GLYPHED.getData(), true);
			} else if (data == SandstoneType.GLYPHED.getData()) {
				block.setTypeIdAndData(Material.SANDSTONE.getId(), (byte)0, true);
			}
		} else if (type == Material.MONSTER_EGGS) {
			if (data == (byte)2) {
				block.setTypeIdAndData(Material.MONSTER_EGGS.getId(), (byte)5, true);
			} else if (data == (byte)5) {
				block.setTypeIdAndData(Material.MONSTER_EGGS.getId(), (byte)2, true);
			}
		} else if (type == Material.SMOOTH_BRICK) {
			if (data == (byte)0) {
				block.setTypeIdAndData(Material.SMOOTH_BRICK.getId(), (byte)3, true);
			} else if (data == (byte)3) {
				block.setTypeIdAndData(Material.SMOOTH_BRICK.getId(), (byte)0, true);
			}
		} else if (type == Material.QUARTZ_BLOCK) {
			if (data == (byte)0) {
				block.setTypeIdAndData(Material.QUARTZ_BLOCK.getId(), (byte)1, true);
			} else if (data == (byte)1) {
				block.setTypeIdAndData(Material.QUARTZ_BLOCK.getId(), (byte)0, true);
			}
		} else if (type == Material.RED_SANDSTONE) {
			if (data == (byte)0) {
				block.setTypeIdAndData(Material.RED_SANDSTONE.getId(), (byte)1, true);
			} else if (data == (byte)1) {
				block.setTypeIdAndData(Material.RED_SANDSTONE.getId(), (byte)0, true);
			}
		}
	}
	
}
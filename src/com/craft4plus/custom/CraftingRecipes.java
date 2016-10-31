package com.craft4plus.custom;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import com.craft4plus.main.Main;

public class CraftingRecipes {

	public static void addCustomCraftingRecipes() {

		// There is a need for a 1 tick delay - otherwise the Crafting Bench
		// will glitch out and have some item already.
		
		// ------------ EMERALD ITEMS ---------------
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
			@Override
			public void run() {
				addEmeraldSword();
			}
		}, 1L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
			@Override
			public void run() {
				addEmeraldAxe();
			}
		}, 1L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
			@Override
			public void run() {
				addEmeraldPickaxe();
			}
		}, 1L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
			@Override
			public void run() {
				addEmeraldShovel();
			}
		}, 1L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
			@Override
			public void run() {
				addEmeraldHoe();
			}
		}, 1L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
			@Override
			public void run() {
				addEmeraldHelmet();
			}
		}, 1L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
			@Override
			public void run() {
				addEmeraldChestplate();
			}
		}, 1L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
			@Override
			public void run() {
				addEmeraldLeggings();
			}
		}, 1L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
			@Override
			public void run() {
				addEmeraldBoots();
			}
		}, 1L);
		// ------------ END OF EMERALD ITEMS ---------------
		// ----------------- DOUBLE AXES ------------------- 
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
			@Override
			public void run() {
				addWoodenDoubleAxe();
			}
		}, 1L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
			@Override
			public void run() {
				addStoneDoubleAxe();
			}
		}, 1L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
			@Override
			public void run() {
				addEndStoneDoubleAxe();
			}
		}, 1L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
			@Override
			public void run() {
				addIronDoubleAxe();
			}
		}, 1L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
			@Override
			public void run() {
				addGoldDoubleAxe();
			}
		}, 1L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
			@Override
			public void run() {
				addDiamondDoubleAxe();
			}
		}, 1L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
			@Override
			public void run() {
				addEmeraldDoubleAxe();
			}
		}, 1L);
		
		// ------------- END OF DOUBLE AXES ----------------
		
		// ----------------- STONE ARMOR -------------------
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
			@Override
			public void run() {
				addStoneHelmet();
			}
		}, 1L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
			@Override
			public void run() {
				addStoneChestplate();
			}
		}, 1L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
			@Override
			public void run() {
				addStoneLeggings();
			}
		}, 1L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
			@Override
			public void run() {
				addStoneBoots();
			}
		}, 1L);
	
		// ------------- END OF STONE ARMOR ----------------
		
		// --------------- END STONE ITEMS -----------------
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
			@Override
			public void run() {
				addEndStoneSword();
			}
		}, 1L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
			@Override
			public void run() {
				addEndStoneAxe();
			}
		}, 1L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
			@Override
			public void run() {
				addEndStonePickaxe();
			}
		}, 1L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
			@Override
			public void run() {
				addEndStoneShovel();
			}
		}, 1L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
			@Override
			public void run() {
				addEndStoneHoe();
			}
		}, 1L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
			@Override
			public void run() {
				addEndStoneHelmet();
			}
		}, 1L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
			@Override
			public void run() {
				addEndStoneChestplate();
			}
		}, 1L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
			@Override
			public void run() {
				addEndStoneLeggings();
			}
		}, 1L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
			@Override
			public void run() {
				addEndStoneBoots();
			}
		}, 1L);
		
		// ------------ END OF END STONE ITEMS -------------
		
		// ----------------- CUSTOM FOOD -------------------
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
			@Override
			public void run() {
				addGoldfish();
			}
		}, 1L);
		
		// -------------- END OF CUSTOM FOOD ---------------
	}

	// ------------ EMERALD ITEMS ---------------
	public static void addEmeraldSword() {

		ItemStack item = CustomItems.EmeraldSword();

		ShapedRecipe ItemRecipe1 = new ShapedRecipe(item);

		ItemRecipe1.shape("123", "456", "789");

		ItemRecipe1.setIngredient('1', Material.EMERALD);
		ItemRecipe1.setIngredient('4', Material.EMERALD);
		ItemRecipe1.setIngredient('7', Material.STICK);

		Bukkit.getServer().addRecipe(ItemRecipe1);

		ShapedRecipe ItemRecipe2 = new ShapedRecipe(item);

		ItemRecipe2.shape("123", "456", "789");

		ItemRecipe2.setIngredient('2', Material.EMERALD);
		ItemRecipe2.setIngredient('5', Material.EMERALD);
		ItemRecipe2.setIngredient('8', Material.STICK);

		Bukkit.getServer().addRecipe(ItemRecipe2);

		ShapedRecipe ItemRecipe3 = new ShapedRecipe(item);

		ItemRecipe3.shape("123", "456", "789");

		ItemRecipe3.setIngredient('3', Material.EMERALD);
		ItemRecipe3.setIngredient('6', Material.EMERALD);
		ItemRecipe3.setIngredient('9', Material.STICK);

		Bukkit.getServer().addRecipe(ItemRecipe3);
	}

	public static void addEmeraldAxe() {

		ItemStack item = CustomItems.EmeraldAxe();

		ShapedRecipe ItemRecipe4 = new ShapedRecipe(item);

		ItemRecipe4.shape("123", "456", "789");

		ItemRecipe4.setIngredient('5', Material.STICK);
		ItemRecipe4.setIngredient('8', Material.STICK);
		ItemRecipe4.setIngredient('1', Material.EMERALD);
		ItemRecipe4.setIngredient('2', Material.EMERALD);
		ItemRecipe4.setIngredient('4', Material.EMERALD);

		Bukkit.getServer().addRecipe(ItemRecipe4);

		ShapedRecipe ItemRecipe5 = new ShapedRecipe(item);

		ItemRecipe5.shape("123", "456", "789");

		ItemRecipe5.setIngredient('5', Material.STICK);
		ItemRecipe5.setIngredient('8', Material.STICK);
		ItemRecipe5.setIngredient('3', Material.EMERALD);
		ItemRecipe5.setIngredient('2', Material.EMERALD);
		ItemRecipe5.setIngredient('6', Material.EMERALD);

		Bukkit.getServer().addRecipe(ItemRecipe5);
	}

	public static void addEmeraldPickaxe() {

		ItemStack item = CustomItems.EmeraldPickaxe();

		ShapedRecipe ItemRecipe6 = new ShapedRecipe(item);

		ItemRecipe6.shape("123", "456", "789");

		ItemRecipe6.setIngredient('5', Material.STICK);
		ItemRecipe6.setIngredient('8', Material.STICK);
		ItemRecipe6.setIngredient('1', Material.EMERALD);
		ItemRecipe6.setIngredient('2', Material.EMERALD);
		ItemRecipe6.setIngredient('3', Material.EMERALD);

		Bukkit.getServer().addRecipe(ItemRecipe6);
	}

	public static void addEmeraldShovel() {

		ItemStack item = CustomItems.EmeraldShovel();

		ShapedRecipe ItemRecipe7 = new ShapedRecipe(item);

		ItemRecipe7.shape("123", "456", "789");

		ItemRecipe7.setIngredient('5', Material.STICK);
		ItemRecipe7.setIngredient('8', Material.STICK);
		ItemRecipe7.setIngredient('2', Material.EMERALD);

		Bukkit.getServer().addRecipe(ItemRecipe7);
	}

	public static void addEmeraldHoe() {

		ItemStack item = CustomItems.EmeraldHoe();

		ShapedRecipe ItemRecipe8 = new ShapedRecipe(item);

		ItemRecipe8.shape("123", "456", "789");

		ItemRecipe8.setIngredient('5', Material.STICK);
		ItemRecipe8.setIngredient('8', Material.STICK);
		ItemRecipe8.setIngredient('2', Material.EMERALD);
		ItemRecipe8.setIngredient('3', Material.EMERALD);

		Bukkit.getServer().addRecipe(ItemRecipe8);

		ShapedRecipe ItemRecipe9 = new ShapedRecipe(item);

		ItemRecipe9.shape("123", "456", "789");

		ItemRecipe9.setIngredient('5', Material.STICK);
		ItemRecipe9.setIngredient('8', Material.STICK);
		ItemRecipe9.setIngredient('1', Material.EMERALD);
		ItemRecipe9.setIngredient('2', Material.EMERALD);

		Bukkit.getServer().addRecipe(ItemRecipe9);
	}

	public static void addEmeraldHelmet() {

		ItemStack item = CustomItems.EmeraldHelmet();

		ShapedRecipe ItemRecipe1 = new ShapedRecipe(item);

		ItemRecipe1.shape("789", "456", "123");

		ItemRecipe1.setIngredient('7', Material.EMERALD);
		ItemRecipe1.setIngredient('8', Material.EMERALD);
		ItemRecipe1.setIngredient('9', Material.EMERALD);
		ItemRecipe1.setIngredient('4', Material.EMERALD);
		ItemRecipe1.setIngredient('6', Material.EMERALD);

		Bukkit.getServer().addRecipe(ItemRecipe1);

		ShapedRecipe ItemRecipe2 = new ShapedRecipe(item);

		ItemRecipe2.shape("789", "456", "123");

		ItemRecipe2.setIngredient('4', Material.EMERALD);
		ItemRecipe2.setIngredient('5', Material.EMERALD);
		ItemRecipe2.setIngredient('6', Material.EMERALD);
		ItemRecipe2.setIngredient('1', Material.EMERALD);
		ItemRecipe2.setIngredient('3', Material.EMERALD);

		Bukkit.getServer().addRecipe(ItemRecipe2);
	}

	public static void addEmeraldChestplate() {

		ItemStack item = CustomItems.EmeraldChestplate();

		ShapedRecipe ItemRecipe1 = new ShapedRecipe(item);

		ItemRecipe1.shape("789", "456", "123");

		ItemRecipe1.setIngredient('7', Material.EMERALD);
		ItemRecipe1.setIngredient('9', Material.EMERALD);
		ItemRecipe1.setIngredient('4', Material.EMERALD);
		ItemRecipe1.setIngredient('5', Material.EMERALD);
		ItemRecipe1.setIngredient('6', Material.EMERALD);
		ItemRecipe1.setIngredient('1', Material.EMERALD);
		ItemRecipe1.setIngredient('2', Material.EMERALD);
		ItemRecipe1.setIngredient('3', Material.EMERALD);

		Bukkit.getServer().addRecipe(ItemRecipe1);

	}

	public static void addEmeraldLeggings() {

		ItemStack item = CustomItems.EmeraldLeggings();

		ShapedRecipe ItemRecipe1 = new ShapedRecipe(item);

		ItemRecipe1.shape("789", "456", "123");

		ItemRecipe1.setIngredient('7', Material.EMERALD);
		ItemRecipe1.setIngredient('8', Material.EMERALD);
		ItemRecipe1.setIngredient('9', Material.EMERALD);
		ItemRecipe1.setIngredient('4', Material.EMERALD);
		ItemRecipe1.setIngredient('6', Material.EMERALD);
		ItemRecipe1.setIngredient('1', Material.EMERALD);
		ItemRecipe1.setIngredient('3', Material.EMERALD);

		Bukkit.getServer().addRecipe(ItemRecipe1);

	}

	public static void addEmeraldBoots() {

		ItemStack item = CustomItems.EmeraldBoots();

		ShapedRecipe ItemRecipe1 = new ShapedRecipe(item);

		ItemRecipe1.shape("789", "456", "123");

		ItemRecipe1.setIngredient('7', Material.EMERALD);
		ItemRecipe1.setIngredient('9', Material.EMERALD);
		ItemRecipe1.setIngredient('4', Material.EMERALD);
		ItemRecipe1.setIngredient('6', Material.EMERALD);

		Bukkit.getServer().addRecipe(ItemRecipe1);

		ShapedRecipe ItemRecipe2 = new ShapedRecipe(item);

		ItemRecipe2.shape("789", "456", "123");

		ItemRecipe2.setIngredient('4', Material.EMERALD);
		ItemRecipe2.setIngredient('6', Material.EMERALD);
		ItemRecipe2.setIngredient('1', Material.EMERALD);
		ItemRecipe2.setIngredient('3', Material.EMERALD);

		Bukkit.getServer().addRecipe(ItemRecipe2);
	}

	// ------------ END OF EMERALD ITEMS ---------------
	
	// ----------------- DOUBLE AXES ------------------- 
	
	public static void addWoodenDoubleAxe() {

		ItemStack item = CustomItems.WoodenDoubleAxe();

		ShapedRecipe ItemRecipe1 = new ShapedRecipe(item);

		ItemRecipe1.shape("789", "456", "123");

		ItemRecipe1.setIngredient('7', Material.WOOD);
		ItemRecipe1.setIngredient('8', Material.WOOD);
		ItemRecipe1.setIngredient('9', Material.WOOD);
		ItemRecipe1.setIngredient('4', Material.WOOD);
		ItemRecipe1.setIngredient('6', Material.WOOD);
		ItemRecipe1.setIngredient('5', Material.STICK);
		ItemRecipe1.setIngredient('2', Material.STICK);

		Bukkit.getServer().addRecipe(ItemRecipe1);
	}
	
	public static void addStoneDoubleAxe() {

		ItemStack item = CustomItems.StoneDoubleAxe();

		ShapedRecipe ItemRecipe1 = new ShapedRecipe(item);

		ItemRecipe1.shape("789", "456", "123");

		ItemRecipe1.setIngredient('7', Material.COBBLESTONE);
		ItemRecipe1.setIngredient('8', Material.COBBLESTONE);
		ItemRecipe1.setIngredient('9', Material.COBBLESTONE);
		ItemRecipe1.setIngredient('4', Material.COBBLESTONE);
		ItemRecipe1.setIngredient('6', Material.COBBLESTONE);
		ItemRecipe1.setIngredient('5', Material.STICK);
		ItemRecipe1.setIngredient('2', Material.STICK);

		Bukkit.getServer().addRecipe(ItemRecipe1);
	}
	
	public static void addEndStoneDoubleAxe() {

		ItemStack item = CustomItems.EndStoneDoubleAxe();

		ShapedRecipe ItemRecipe1 = new ShapedRecipe(item);

		ItemRecipe1.shape("789", "456", "123");

		ItemRecipe1.setIngredient('7', Material.ENDER_STONE);
		ItemRecipe1.setIngredient('8', Material.ENDER_STONE);
		ItemRecipe1.setIngredient('9', Material.ENDER_STONE);
		ItemRecipe1.setIngredient('4', Material.ENDER_STONE);
		ItemRecipe1.setIngredient('6', Material.ENDER_STONE);
		ItemRecipe1.setIngredient('5', Material.STICK);
		ItemRecipe1.setIngredient('2', Material.STICK);

		Bukkit.getServer().addRecipe(ItemRecipe1);
	}
	
	public static void addIronDoubleAxe() {

		ItemStack item = CustomItems.IronDoubleAxe();

		ShapedRecipe ItemRecipe1 = new ShapedRecipe(item);

		ItemRecipe1.shape("789", "456", "123");

		ItemRecipe1.setIngredient('7', Material.IRON_INGOT);
		ItemRecipe1.setIngredient('8', Material.IRON_INGOT);
		ItemRecipe1.setIngredient('9', Material.IRON_INGOT);
		ItemRecipe1.setIngredient('4', Material.IRON_INGOT);
		ItemRecipe1.setIngredient('6', Material.IRON_INGOT);
		ItemRecipe1.setIngredient('5', Material.STICK);
		ItemRecipe1.setIngredient('2', Material.STICK);

		Bukkit.getServer().addRecipe(ItemRecipe1);
	}
	
	public static void addGoldDoubleAxe() {

		ItemStack item = CustomItems.GoldDoubleAxe();

		ShapedRecipe ItemRecipe1 = new ShapedRecipe(item);

		ItemRecipe1.shape("789", "456", "123");

		ItemRecipe1.setIngredient('7', Material.GOLD_INGOT);
		ItemRecipe1.setIngredient('8', Material.GOLD_INGOT);
		ItemRecipe1.setIngredient('9', Material.GOLD_INGOT);
		ItemRecipe1.setIngredient('4', Material.GOLD_INGOT);
		ItemRecipe1.setIngredient('6', Material.GOLD_INGOT);
		ItemRecipe1.setIngredient('5', Material.STICK);
		ItemRecipe1.setIngredient('2', Material.STICK);

		Bukkit.getServer().addRecipe(ItemRecipe1);
	}
	
	public static void addDiamondDoubleAxe() {

		ItemStack item = CustomItems.DiamondDoubleAxe();

		ShapedRecipe ItemRecipe1 = new ShapedRecipe(item);

		ItemRecipe1.shape("789", "456", "123");

		ItemRecipe1.setIngredient('7', Material.DIAMOND);
		ItemRecipe1.setIngredient('8', Material.DIAMOND);
		ItemRecipe1.setIngredient('9', Material.DIAMOND);
		ItemRecipe1.setIngredient('4', Material.DIAMOND);
		ItemRecipe1.setIngredient('6', Material.DIAMOND);
		ItemRecipe1.setIngredient('5', Material.STICK);
		ItemRecipe1.setIngredient('2', Material.STICK);

		Bukkit.getServer().addRecipe(ItemRecipe1);
	}
	
	public static void addEmeraldDoubleAxe() {

		ItemStack item = CustomItems.EmeraldDoubleAxe();

		ShapedRecipe ItemRecipe1 = new ShapedRecipe(item);

		ItemRecipe1.shape("789", "456", "123");

		ItemRecipe1.setIngredient('7', Material.EMERALD);
		ItemRecipe1.setIngredient('8', Material.EMERALD);
		ItemRecipe1.setIngredient('9', Material.EMERALD);
		ItemRecipe1.setIngredient('4', Material.EMERALD);
		ItemRecipe1.setIngredient('6', Material.EMERALD);
		ItemRecipe1.setIngredient('5', Material.STICK);
		ItemRecipe1.setIngredient('2', Material.STICK);

		Bukkit.getServer().addRecipe(ItemRecipe1);
	}
	
	// ------------- END OF DOUBLE AXES ----------------
	
	// ----------------- STONE ARMOR -------------------
	
	public static void addStoneHelmet() {

		ItemStack item = CustomItems.StoneHelmet();

		ShapedRecipe ItemRecipe1 = new ShapedRecipe(item);

		ItemRecipe1.shape("789", "456", "123");

		ItemRecipe1.setIngredient('7', Material.COBBLESTONE);
		ItemRecipe1.setIngredient('8', Material.COBBLESTONE);
		ItemRecipe1.setIngredient('9', Material.COBBLESTONE);
		ItemRecipe1.setIngredient('4', Material.COBBLESTONE);
		ItemRecipe1.setIngredient('6', Material.COBBLESTONE);

		Bukkit.getServer().addRecipe(ItemRecipe1);

		ShapedRecipe ItemRecipe2 = new ShapedRecipe(item);

		ItemRecipe2.shape("789", "456", "123");

		ItemRecipe2.setIngredient('4', Material.COBBLESTONE);
		ItemRecipe2.setIngredient('5', Material.COBBLESTONE);
		ItemRecipe2.setIngredient('6', Material.COBBLESTONE);
		ItemRecipe2.setIngredient('1', Material.COBBLESTONE);
		ItemRecipe2.setIngredient('3', Material.COBBLESTONE);

		Bukkit.getServer().addRecipe(ItemRecipe2);
	}

	public static void addStoneChestplate() {

		ItemStack item = CustomItems.StoneChestplate();

		ShapedRecipe ItemRecipe1 = new ShapedRecipe(item);

		ItemRecipe1.shape("789", "456", "123");

		ItemRecipe1.setIngredient('7', Material.COBBLESTONE);
		ItemRecipe1.setIngredient('9', Material.COBBLESTONE);
		ItemRecipe1.setIngredient('4', Material.COBBLESTONE);
		ItemRecipe1.setIngredient('5', Material.COBBLESTONE);
		ItemRecipe1.setIngredient('6', Material.COBBLESTONE);
		ItemRecipe1.setIngredient('1', Material.COBBLESTONE);
		ItemRecipe1.setIngredient('2', Material.COBBLESTONE);
		ItemRecipe1.setIngredient('3', Material.COBBLESTONE);

		Bukkit.getServer().addRecipe(ItemRecipe1);

	}

	public static void addStoneLeggings() {

		ItemStack item = CustomItems.StoneLeggings();

		ShapedRecipe ItemRecipe1 = new ShapedRecipe(item);

		ItemRecipe1.shape("789", "456", "123");

		ItemRecipe1.setIngredient('7', Material.COBBLESTONE);
		ItemRecipe1.setIngredient('8', Material.COBBLESTONE);
		ItemRecipe1.setIngredient('9', Material.COBBLESTONE);
		ItemRecipe1.setIngredient('4', Material.COBBLESTONE);
		ItemRecipe1.setIngredient('6', Material.COBBLESTONE);
		ItemRecipe1.setIngredient('1', Material.COBBLESTONE);
		ItemRecipe1.setIngredient('3', Material.COBBLESTONE);

		Bukkit.getServer().addRecipe(ItemRecipe1);

	}

	public static void addStoneBoots() {

		ItemStack item = CustomItems.StoneBoots();

		ShapedRecipe ItemRecipe1 = new ShapedRecipe(item);

		ItemRecipe1.shape("789", "456", "123");

		ItemRecipe1.setIngredient('7', Material.COBBLESTONE);
		ItemRecipe1.setIngredient('9', Material.COBBLESTONE);
		ItemRecipe1.setIngredient('4', Material.COBBLESTONE);
		ItemRecipe1.setIngredient('6', Material.COBBLESTONE);

		Bukkit.getServer().addRecipe(ItemRecipe1);

		ShapedRecipe ItemRecipe2 = new ShapedRecipe(item);

		ItemRecipe2.shape("789", "456", "123");

		ItemRecipe2.setIngredient('4', Material.COBBLESTONE);
		ItemRecipe2.setIngredient('6', Material.COBBLESTONE);
		ItemRecipe2.setIngredient('1', Material.COBBLESTONE);
		ItemRecipe2.setIngredient('3', Material.COBBLESTONE);

		Bukkit.getServer().addRecipe(ItemRecipe2);
	}
	
	// ------------- END OF STONE ARMOR ----------------
	
	// --------------- END STONE ITEMS -----------------
	
	public static void addEndStoneSword() {

		ItemStack item = CustomItems.EndStoneSword();

		ShapedRecipe ItemRecipe1 = new ShapedRecipe(item);

		ItemRecipe1.shape("123", "456", "789");

		ItemRecipe1.setIngredient('1', Material.ENDER_STONE);
		ItemRecipe1.setIngredient('4', Material.ENDER_STONE);
		ItemRecipe1.setIngredient('7', Material.STICK);

		Bukkit.getServer().addRecipe(ItemRecipe1);

		ShapedRecipe ItemRecipe2 = new ShapedRecipe(item);

		ItemRecipe2.shape("123", "456", "789");

		ItemRecipe2.setIngredient('2', Material.ENDER_STONE);
		ItemRecipe2.setIngredient('5', Material.ENDER_STONE);
		ItemRecipe2.setIngredient('8', Material.STICK);

		Bukkit.getServer().addRecipe(ItemRecipe2);

		ShapedRecipe ItemRecipe3 = new ShapedRecipe(item);

		ItemRecipe3.shape("123", "456", "789");

		ItemRecipe3.setIngredient('3', Material.ENDER_STONE);
		ItemRecipe3.setIngredient('6', Material.ENDER_STONE);
		ItemRecipe3.setIngredient('9', Material.STICK);

		Bukkit.getServer().addRecipe(ItemRecipe3);
	}

	public static void addEndStoneAxe() {

		ItemStack item = CustomItems.EndStoneAxe();

		ShapedRecipe ItemRecipe4 = new ShapedRecipe(item);

		ItemRecipe4.shape("123", "456", "789");

		ItemRecipe4.setIngredient('5', Material.STICK);
		ItemRecipe4.setIngredient('8', Material.STICK);
		ItemRecipe4.setIngredient('1', Material.ENDER_STONE);
		ItemRecipe4.setIngredient('2', Material.ENDER_STONE);
		ItemRecipe4.setIngredient('4', Material.ENDER_STONE);

		Bukkit.getServer().addRecipe(ItemRecipe4);

		ShapedRecipe ItemRecipe5 = new ShapedRecipe(item);

		ItemRecipe5.shape("123", "456", "789");

		ItemRecipe5.setIngredient('5', Material.STICK);
		ItemRecipe5.setIngredient('8', Material.STICK);
		ItemRecipe5.setIngredient('3', Material.ENDER_STONE);
		ItemRecipe5.setIngredient('2', Material.ENDER_STONE);
		ItemRecipe5.setIngredient('6', Material.ENDER_STONE);

		Bukkit.getServer().addRecipe(ItemRecipe5);
	}

	public static void addEndStonePickaxe() {

		ItemStack item = CustomItems.EndStonePickaxe();

		ShapedRecipe ItemRecipe6 = new ShapedRecipe(item);

		ItemRecipe6.shape("123", "456", "789");

		ItemRecipe6.setIngredient('5', Material.STICK);
		ItemRecipe6.setIngredient('8', Material.STICK);
		ItemRecipe6.setIngredient('1', Material.ENDER_STONE);
		ItemRecipe6.setIngredient('2', Material.ENDER_STONE);
		ItemRecipe6.setIngredient('3', Material.ENDER_STONE);

		Bukkit.getServer().addRecipe(ItemRecipe6);
	}

	public static void addEndStoneShovel() {

		ItemStack item = CustomItems.EndStoneShovel();

		ShapedRecipe ItemRecipe7 = new ShapedRecipe(item);

		ItemRecipe7.shape("123", "456", "789");

		ItemRecipe7.setIngredient('5', Material.STICK);
		ItemRecipe7.setIngredient('8', Material.STICK);
		ItemRecipe7.setIngredient('2', Material.ENDER_STONE);

		Bukkit.getServer().addRecipe(ItemRecipe7);
	}

	public static void addEndStoneHoe() {

		ItemStack item = CustomItems.EndStoneHoe();

		ShapedRecipe ItemRecipe8 = new ShapedRecipe(item);

		ItemRecipe8.shape("123", "456", "789");

		ItemRecipe8.setIngredient('5', Material.STICK);
		ItemRecipe8.setIngredient('8', Material.STICK);
		ItemRecipe8.setIngredient('2', Material.ENDER_STONE);
		ItemRecipe8.setIngredient('3', Material.ENDER_STONE);

		Bukkit.getServer().addRecipe(ItemRecipe8);

		ShapedRecipe ItemRecipe9 = new ShapedRecipe(item);

		ItemRecipe9.shape("123", "456", "789");

		ItemRecipe9.setIngredient('5', Material.STICK);
		ItemRecipe9.setIngredient('8', Material.STICK);
		ItemRecipe9.setIngredient('1', Material.ENDER_STONE);
		ItemRecipe9.setIngredient('2', Material.ENDER_STONE);

		Bukkit.getServer().addRecipe(ItemRecipe9);
	}

	public static void addEndStoneHelmet() {

		ItemStack item = CustomItems.EndStoneHelmet();

		ShapedRecipe ItemRecipe1 = new ShapedRecipe(item);

		ItemRecipe1.shape("789", "456", "123");

		ItemRecipe1.setIngredient('7', Material.ENDER_STONE);
		ItemRecipe1.setIngredient('8', Material.ENDER_STONE);
		ItemRecipe1.setIngredient('9', Material.ENDER_STONE);
		ItemRecipe1.setIngredient('4', Material.ENDER_STONE);
		ItemRecipe1.setIngredient('6', Material.ENDER_STONE);

		Bukkit.getServer().addRecipe(ItemRecipe1);

		ShapedRecipe ItemRecipe2 = new ShapedRecipe(item);

		ItemRecipe2.shape("789", "456", "123");

		ItemRecipe2.setIngredient('4', Material.ENDER_STONE);
		ItemRecipe2.setIngredient('5', Material.ENDER_STONE);
		ItemRecipe2.setIngredient('6', Material.ENDER_STONE);
		ItemRecipe2.setIngredient('1', Material.ENDER_STONE);
		ItemRecipe2.setIngredient('3', Material.ENDER_STONE);

		Bukkit.getServer().addRecipe(ItemRecipe2);
	}

	public static void addEndStoneChestplate() {

		ItemStack item = CustomItems.EndStoneChestplate();

		ShapedRecipe ItemRecipe1 = new ShapedRecipe(item);

		ItemRecipe1.shape("789", "456", "123");

		ItemRecipe1.setIngredient('7', Material.ENDER_STONE);
		ItemRecipe1.setIngredient('9', Material.ENDER_STONE);
		ItemRecipe1.setIngredient('4', Material.ENDER_STONE);
		ItemRecipe1.setIngredient('5', Material.ENDER_STONE);
		ItemRecipe1.setIngredient('6', Material.ENDER_STONE);
		ItemRecipe1.setIngredient('1', Material.ENDER_STONE);
		ItemRecipe1.setIngredient('2', Material.ENDER_STONE);
		ItemRecipe1.setIngredient('3', Material.ENDER_STONE);

		Bukkit.getServer().addRecipe(ItemRecipe1);

	}

	public static void addEndStoneLeggings() {

		ItemStack item = CustomItems.EndStoneLeggings();

		ShapedRecipe ItemRecipe1 = new ShapedRecipe(item);

		ItemRecipe1.shape("789", "456", "123");

		ItemRecipe1.setIngredient('7', Material.ENDER_STONE);
		ItemRecipe1.setIngredient('8', Material.ENDER_STONE);
		ItemRecipe1.setIngredient('9', Material.ENDER_STONE);
		ItemRecipe1.setIngredient('4', Material.ENDER_STONE);
		ItemRecipe1.setIngredient('6', Material.ENDER_STONE);
		ItemRecipe1.setIngredient('1', Material.ENDER_STONE);
		ItemRecipe1.setIngredient('3', Material.ENDER_STONE);

		Bukkit.getServer().addRecipe(ItemRecipe1);

	}

	public static void addEndStoneBoots() {

		ItemStack item = CustomItems.EndStoneBoots();

		ShapedRecipe ItemRecipe1 = new ShapedRecipe(item);

		ItemRecipe1.shape("789", "456", "123");

		ItemRecipe1.setIngredient('7', Material.ENDER_STONE);
		ItemRecipe1.setIngredient('9', Material.ENDER_STONE);
		ItemRecipe1.setIngredient('4', Material.ENDER_STONE);
		ItemRecipe1.setIngredient('6', Material.ENDER_STONE);

		Bukkit.getServer().addRecipe(ItemRecipe1);

		ShapedRecipe ItemRecipe2 = new ShapedRecipe(item);

		ItemRecipe2.shape("789", "456", "123");

		ItemRecipe2.setIngredient('4', Material.ENDER_STONE);
		ItemRecipe2.setIngredient('6', Material.ENDER_STONE);
		ItemRecipe2.setIngredient('1', Material.ENDER_STONE);
		ItemRecipe2.setIngredient('3', Material.ENDER_STONE);

		Bukkit.getServer().addRecipe(ItemRecipe2);
	}
	
	// ------------ END OF END STONE ITEMS -------------
	
	// ----------------- CUSTOM FOOD -------------------
	
	public static void addGoldfish() {

		ItemStack item = CustomItems.Goldfish();

		ShapedRecipe ItemRecipe1 = new ShapedRecipe(item);

		ItemRecipe1.shape("111", "121", "111");

		ItemRecipe1.setIngredient('1', Material.GOLD_INGOT);
		ItemRecipe1.setIngredient('2', Material.RAW_FISH);

		Bukkit.getServer().addRecipe(ItemRecipe1);

	}
	
	// -------------- END OF CUSTOM FOOD ---------------
	
}

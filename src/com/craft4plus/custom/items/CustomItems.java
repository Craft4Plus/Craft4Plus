package com.craft4plus.custom.items;

import java.util.HashMap;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;


public class CustomItems {
	
	// ============ STUFF CONTAINING CUSTOM ITEMS =========== //
	
	public static HashMap<Integer, ItemStack> CustomItems = new HashMap<Integer, ItemStack>();
	
	public static void generateCustomItems() {
		// Emerald Items
		EmeraldSword();
		EmeraldAxe();
		EmeraldPickaxe();
		EmeraldShovel();
		EmeraldHoe();
		EmeraldHelmet();
		EmeraldChestplate();
		EmeraldLeggings();
		EmeraldBoots();
		
		// Double Axes
		WoodenDoubleAxe();
		StoneDoubleAxe();
		IronDoubleAxe();
		GoldDoubleAxe();
		DiamondDoubleAxe();
		EmeraldDoubleAxe();
		
		// Stone Armor
		StoneHelmet();
		StoneChestplate();
		StoneLeggings();
		StoneBoots();
		
		// End Stone Items
		EndStoneSword();
		EndStoneAxe();
		EndStonePickaxe();
		EndStoneShovel();
		EndStoneHoe();
		EndStoneHelmet();
		EndStoneChestplate();
		EndStoneLeggings();
		EndStoneBoots();
		EndStoneDoubleAxe();
		
		// Custom Food
		Goldfish();
		
		// Slime Armor
		SlimeBoots();
		
		// Super Hoes
		SuperHoeBreakPlaceholder();
		WoodenSickle();
		StoneSickle();
		EndStoneSickle();
		IronSickle();
		GoldSickle();
		DiamondSickle();
		EmeraldSickle();
		
		//Slime Buckets
		SlimeBucket();
		HoppingSlimeBucket();
		
		//Chisels
		WoodenChisel();
		StoneChisel();
		EndStoneChisel();
		IronChisel();
		GoldChisel();
		DiamondChisel();
		EmeraldChisel();
		
	}
	
	// ======== END OF STUFF CONTAINING CUSTOM ITEMS ======= //
	
	// ------------ EMERALD ITEMS ---------------

		public static void EmeraldSword() { // ID OF 1

			ItemStack Item = ItemStackUtilities.createItem(Material.DIAMOND_SWORD, 1, 1561);

			ItemStackUtilities.setUnbreakable(Item, true, false);
			ItemStackUtilities.setName(Item, "Emerald Sword");

			CustomItems.put(1, Item);

		}

		public static void EmeraldAxe() { // ID OF 2

			ItemStack Item = ItemStackUtilities.createItem(Material.DIAMOND_AXE, 1, 1561);

			ItemStackUtilities.setUnbreakable(Item, true, false);
			ItemStackUtilities.setName(Item, "Emerald Axe");

			CustomItems.put(2, Item);

		}

		public static void EmeraldPickaxe() { // ID OF 3

			ItemStack Item = ItemStackUtilities.createItem(Material.DIAMOND_PICKAXE, 1, 1561);

			ItemStackUtilities.setUnbreakable(Item, true, false);
			ItemStackUtilities.setName(Item, "Emerald Pickaxe");

			CustomItems.put(3, Item);

		}

		public static void EmeraldShovel() { // ID OF 4

			ItemStack Item = ItemStackUtilities.createItem(Material.DIAMOND_SPADE, 1, 1561);

			ItemStackUtilities.setUnbreakable(Item, true, false);
			ItemStackUtilities.setName(Item, "Emerald Shovel");

			CustomItems.put(4, Item);

		}

		public static void EmeraldHoe() { // ID OF 5

			ItemStack Item = ItemStackUtilities.createItem(Material.DIAMOND_HOE, 1, 1561);

			ItemStackUtilities.setUnbreakable(Item, true, false);
			ItemStackUtilities.setName(Item, "Emerald Hoe");

			CustomItems.put(5, Item);

		}

		public static void EmeraldHelmet() { // ID OF 6

			ItemStack Item = ItemStackUtilities.createItem(Material.LEATHER_HELMET, 1, 0);

			ItemStackUtilities.setUnbreakable(Item, true, false);
			ItemStackUtilities.setName(Item, "Emerald Helmet");
			Item = ItemStackUtilities.setArmorLevel(Item, 3, 2, "head");
			ItemStackUtilities.setLeatherArmorColor(Item, 0, 255, 76);

			CustomItems.put(6, Item);

		}

		public static void EmeraldChestplate() { // ID OF 7

			ItemStack Item = ItemStackUtilities.createItem(Material.LEATHER_CHESTPLATE, 1, 0);

			ItemStackUtilities.setUnbreakable(Item, true, false);
			ItemStackUtilities.setName(Item, "Emerald Chestplate");
			Item = ItemStackUtilities.setArmorLevel(Item, 8, 2, "chest");
			ItemStackUtilities.setLeatherArmorColor(Item, 0, 255, 76);

			CustomItems.put(7, Item);

		}

		public static void EmeraldLeggings() { // ID OF 8

			ItemStack Item = ItemStackUtilities.createItem(Material.LEATHER_LEGGINGS, 1, 0);

			ItemStackUtilities.setUnbreakable(Item, true, false);
			ItemStackUtilities.setName(Item, "Emerald Leggings");
			Item = ItemStackUtilities.setArmorLevel(Item, 6, 2, "legs");
			ItemStackUtilities.setLeatherArmorColor(Item, 0, 255, 76);

			CustomItems.put(8, Item);

		}

		public static void EmeraldBoots() { // ID OF 9

			ItemStack Item = ItemStackUtilities.createItem(Material.LEATHER_BOOTS, 1, 0);

			ItemStackUtilities.setUnbreakable(Item, true, false);
			ItemStackUtilities.setName(Item, "Emerald Boots");
			Item = ItemStackUtilities.setArmorLevel(Item, 3, 2, "feet");
			ItemStackUtilities.setLeatherArmorColor(Item, 0, 255, 76);

			CustomItems.put(9, Item);

		}

		// ------------ END OF EMERALD ITEMS ---------------

		// ----------------- DOUBLE AXES -------------------

		public static void WoodenDoubleAxe() { // ID OF 10

			ItemStack Item = ItemStackUtilities.createItem(Material.WOOD_AXE, 1, 59);

			ItemStackUtilities.setUnbreakable(Item, true, true);
			ItemStackUtilities.setName(Item, "Wooden Double Axe");
			Item = ItemStackUtilities.setAttack(Item, 0.5, 7, false, true);
			Item = ItemStackUtilities.addDurabilityLore(Item, 59, 59);

			CustomItems.put(10, Item);

		}

		public static void StoneDoubleAxe() { // ID OF 11

			ItemStack Item = ItemStackUtilities.createItem(Material.STONE_AXE, 1, 131);

			ItemStackUtilities.setUnbreakable(Item, true, true);
			ItemStackUtilities.setName(Item, "Stone Double Axe");
			Item = ItemStackUtilities.setAttack(Item, 0.5, 9, false, true);
			Item = ItemStackUtilities.addDurabilityLore(Item, 131, 131);

			CustomItems.put(11, Item);

		}

		public static void IronDoubleAxe() { // ID OF 12

			ItemStack Item = ItemStackUtilities.createItem(Material.IRON_AXE, 1, 250);

			ItemStackUtilities.setUnbreakable(Item, true, true);
			ItemStackUtilities.setName(Item, "Iron Double Axe");
			Item = ItemStackUtilities.setAttack(Item, 0.6, 9, false, true);
			Item = ItemStackUtilities.addDurabilityLore(Item, 250, 250);

			CustomItems.put(12, Item);

		}

		public static void GoldDoubleAxe() { // ID OF 13

			ItemStack Item = ItemStackUtilities.createItem(Material.GOLD_AXE, 1, 31);

			ItemStackUtilities.setUnbreakable(Item, true, true);
			ItemStackUtilities.setName(Item, "Golden Double Axe");
			Item = ItemStackUtilities.setAttack(Item, 0.7, 7, false, true);
			Item = ItemStackUtilities.addDurabilityLore(Item, 32, 32);

			CustomItems.put(13, Item);

		}

		public static void DiamondDoubleAxe() { // ID OF 14 

			ItemStack Item = ItemStackUtilities.createItem(Material.GOLD_AXE, 1, 30);

			ItemStackUtilities.setUnbreakable(Item, true, true);
			ItemStackUtilities.setName(Item, "Diamond Double Axe");
			Item = ItemStackUtilities.setAttack(Item, 0.7, 9, false, true);
			Item = ItemStackUtilities.addDurabilityLore(Item, 1561, 1561);

			CustomItems.put(14, Item);

		}

		public static void EmeraldDoubleAxe() { // ID OF 15

			ItemStack Item = ItemStackUtilities.createItem(Material.GOLD_AXE, 1, 29);

			ItemStackUtilities.setUnbreakable(Item, true, false);
			ItemStackUtilities.setName(Item, "Emerald Double Axe");
			Item = ItemStackUtilities.setAttack(Item, 0.7, 9, false, true);

			CustomItems.put(15, Item);

		}
		
		// ------------- END OF DOUBLE AXES ----------------
		
		// ----------------- STONE ARMOR -------------------
		
		public static void StoneHelmet() { // ID OF 16

			ItemStack Item = ItemStackUtilities.createItem(Material.LEATHER_HELMET, 1, 0);

			ItemStackUtilities.setName(Item, "Stone Helmet");
			Item = ItemStackUtilities.setArmorLevel(Item, 2, 0, "head");
			ItemStackUtilities.setLeatherArmorColor(Item, 103, 103, 103);

			CustomItems.put(16, Item);

		}

		public static void StoneChestplate() { // ID OF 17

			ItemStack Item = ItemStackUtilities.createItem(Material.LEATHER_CHESTPLATE, 1, 0);

			ItemStackUtilities.setName(Item, "Stone Chestplate");
			Item = ItemStackUtilities.setArmorLevel(Item, 5, 0, "chest");
			ItemStackUtilities.setLeatherArmorColor(Item, 103, 103, 103);

			CustomItems.put(17, Item);

		}

		public static void StoneLeggings() { // ID OF 18

			ItemStack Item = ItemStackUtilities.createItem(Material.LEATHER_LEGGINGS, 1, 0);

			ItemStackUtilities.setName(Item, "Stone Leggings");
			Item = ItemStackUtilities.setArmorLevel(Item, 4, 0, "legs");
			ItemStackUtilities.setLeatherArmorColor(Item, 103, 103, 103);

			CustomItems.put(18, Item);

		}

		public static void StoneBoots() { // ID OF 19

			ItemStack Item = ItemStackUtilities.createItem(Material.LEATHER_BOOTS, 1, 0);

			ItemStackUtilities.setName(Item, "Stone Boots");
			Item = ItemStackUtilities.setArmorLevel(Item, 1, 0, "feet");
			ItemStackUtilities.setLeatherArmorColor(Item, 103, 103, 103);

			CustomItems.put(19, Item);

		}
		
		// ------------- END OF STONE ARMOR ----------------
		
		// --------------- END STONE ITEMS -----------------
		
		
		public static void EndStoneHelmet() { // ID OF 20

			ItemStack Item = ItemStackUtilities.createItem(Material.LEATHER_HELMET, 1, 0);

			ItemStackUtilities.setName(Item, "End Stone Helmet");
			Item = ItemStackUtilities.setArmorLevel(Item, 2, 0, "head");
			ItemStackUtilities.setLeatherArmorColor(Item, 168, 168, 100);

			CustomItems.put(20, Item);

		}

		public static void EndStoneChestplate() { // ID OF 21

			ItemStack Item = ItemStackUtilities.createItem(Material.LEATHER_CHESTPLATE, 1, 0);

			ItemStackUtilities.setName(Item, "End Stone Chestplate");
			Item = ItemStackUtilities.setArmorLevel(Item, 5, 0, "chest");
			ItemStackUtilities.setLeatherArmorColor(Item, 168, 168, 100);

			CustomItems.put(21, Item);

		}

		public static void EndStoneLeggings() { // ID OF 22

			ItemStack Item = ItemStackUtilities.createItem(Material.LEATHER_LEGGINGS, 1, 0);

			ItemStackUtilities.setName(Item, "End Stone Leggings");
			Item = ItemStackUtilities.setArmorLevel(Item, 4, 0, "legs");
			ItemStackUtilities.setLeatherArmorColor(Item, 168, 168, 100);

			CustomItems.put(22, Item);

		}

		public static void EndStoneBoots() {  // ID OF 23

			ItemStack Item = ItemStackUtilities.createItem(Material.LEATHER_BOOTS, 1, 0);

			ItemStackUtilities.setName(Item, "End Stone Boots");
			Item = ItemStackUtilities.setArmorLevel(Item, 1, 0, "feet");
			ItemStackUtilities.setLeatherArmorColor(Item, 168, 168, 100);

			CustomItems.put(23, Item);

		}
		
		public static void EndStoneSword() {  // ID OF 24
			
			ItemStack Item = ItemStackUtilities.createItem(Material.STONE_SWORD, 1 , 131);
			
			ItemStackUtilities.setName(Item, "End Stone Sword");
			ItemStackUtilities.setUnbreakable(Item, true, true);
			Item = ItemStackUtilities.addDurabilityLore(Item, 131, 131);
			
			CustomItems.put(24, Item);
			
		}
		
		public static void EndStoneAxe() { // ID OF 25
			
			ItemStack Item = ItemStackUtilities.createItem(Material.STONE_AXE, 1 , 130);
			
			ItemStackUtilities.setName(Item, "End Stone Axe");
			ItemStackUtilities.setUnbreakable(Item, true, true);
			Item = ItemStackUtilities.addDurabilityLore(Item, 131, 131);
			
			CustomItems.put(25, Item);
			
		}
		
		public static void EndStoneDoubleAxe() { // ID OF 26
			
			ItemStack Item = ItemStackUtilities.createItem(Material.STONE_AXE, 1 , 129);
			
			ItemStackUtilities.setName(Item, "End Stone Double Axe");
			ItemStackUtilities.setUnbreakable(Item, true, true);
			Item = ItemStackUtilities.addDurabilityLore(Item, 131, 131);
			
			CustomItems.put(26, Item);
			
		}
		
		public static void EndStonePickaxe() { // ID OF 27
			
			ItemStack Item = ItemStackUtilities.createItem(Material.STONE_PICKAXE, 1 , 131);
			
			ItemStackUtilities.setName(Item, "End Stone Pickaxe");
			ItemStackUtilities.setUnbreakable(Item, true, true);
			Item = ItemStackUtilities.addDurabilityLore(Item, 131, 131);
			
			CustomItems.put(27, Item);
			
		}
		
		public static void EndStoneShovel() { // ID OF 28
			
			ItemStack Item = ItemStackUtilities.createItem(Material.STONE_SPADE, 1 , 131);
			
			ItemStackUtilities.setName(Item, "End Stone Shovel");
			ItemStackUtilities.setUnbreakable(Item, true, true);
			Item = ItemStackUtilities.addDurabilityLore(Item, 131, 131);
			
			CustomItems.put(28, Item);
			
		}
		
		public static void EndStoneHoe() { // ID OF 29
			
			ItemStack Item = ItemStackUtilities.createItem(Material.STONE_HOE, 1 , 131);
			
			ItemStackUtilities.setName(Item, "End Stone Hoe");
			ItemStackUtilities.setUnbreakable(Item, true, true);
			Item = ItemStackUtilities.addDurabilityLore(Item, 131, 131);
			
			CustomItems.put(29, Item);
			
		}
		
		// ------------ END OF END STONE ITEMS -------------
		
		// ----------------- CUSTOM FOOD -------------------
		
		public static void Goldfish() { // ID OF 30
			ItemStack Item = ItemStackUtilities.createItem(Material.DIAMOND_SWORD, 1, 1560);
			
			ItemStackUtilities.setName(Item, "Goldfish");
			ItemStackUtilities.setUnbreakable(Item, true, true);
			Item = ItemStackUtilities.nullifyModifiers(Item);
			
			CustomItems.put(30, Item);
		}
		
		// -------------- END OF CUSTOM FOOD ---------------
		
		// === SLIME ARMOR === //
		
		public static void SlimeBoots() { // ID OF 31

			ItemStack Item = ItemStackUtilities.createItem(Material.LEATHER_BOOTS, 1, 0);

			ItemStackUtilities.setName(Item, "Slime Boots");
			ItemStackUtilities.setLeatherArmorColor(Item, 132, 200, 115);
			ItemStackUtilities.addLore(Item, "Jump Boost II");
			
			CustomItems.put(31, Item);

		}
		
		// === END OF SLIME ARMOR === //
		
		// === SUPER HOES === //
		
		public static void SuperHoeBreakPlaceholder() { // ID OF 32
			ItemStack Item = ItemStackUtilities.createItem(Material.DIAMOND_HOE, 1, 0);

			ItemStackUtilities.setName(Item, "Non obtainable item - please return to chrismin13.");
			
			CustomItems.put(32, Item);
		}
		
		public static void WoodenSickle() { // ID OF 33

			ItemStack Item = ItemStackUtilities.createItem(Material.DIAMOND_SWORD, 1, 1559);

			ItemStackUtilities.setUnbreakable(Item, true, true);
			ItemStackUtilities.setName(Item, "Wooden Sickle");
			Item = ItemStackUtilities.setAttack(Item, 1.0, 1.0, false, false);
			Item = ItemStackUtilities.addDurabilityLore(Item, 59, 59);

			CustomItems.put(33, Item);

		}

		public static void StoneSickle() { // ID OF 34

			ItemStack Item = ItemStackUtilities.createItem(Material.DIAMOND_SWORD, 1, 1558);

			ItemStackUtilities.setUnbreakable(Item, true, true);
			ItemStackUtilities.setName(Item, "Stone Sickle");
			Item = ItemStackUtilities.setAttack(Item, 2.0, 1.0, false, false);
			Item = ItemStackUtilities.addDurabilityLore(Item, 131, 131);

			CustomItems.put(34, Item);

		}
		
		public static void EndStoneSickle() { // ID OF 35

			ItemStack Item = ItemStackUtilities.createItem(Material.DIAMOND_SWORD, 1, 1557);

			ItemStackUtilities.setUnbreakable(Item, true, true);
			ItemStackUtilities.setName(Item, "Stone Sickle");
			Item = ItemStackUtilities.setAttack(Item, 2.0, 1.0, false, false);
			Item = ItemStackUtilities.addDurabilityLore(Item, 131, 131);

			CustomItems.put(35, Item);

		}

		public static void IronSickle() { // ID OF 36

			ItemStack Item = ItemStackUtilities.createItem(Material.DIAMOND_SWORD, 1, 1556);

			ItemStackUtilities.setUnbreakable(Item, true, true);
			ItemStackUtilities.setName(Item, "Iron Sickle");
			Item = ItemStackUtilities.setAttack(Item, 3.0, 1.0, false, false);
			Item = ItemStackUtilities.addDurabilityLore(Item, 250, 250);

			CustomItems.put(36, Item);

		}

		public static void GoldSickle() { // ID OF 37

			ItemStack Item = ItemStackUtilities.createItem(Material.DIAMOND_SWORD, 1, 1555);

			ItemStackUtilities.setUnbreakable(Item, true, true);
			ItemStackUtilities.setName(Item, "Golden Sickle");
			Item = ItemStackUtilities.setAttack(Item, 1.0, 1.0, false, false);
			Item = ItemStackUtilities.addDurabilityLore(Item, 32, 32);

			CustomItems.put(37, Item);

		}

		public static void DiamondSickle() { // ID OF 38 

			ItemStack Item = ItemStackUtilities.createItem(Material.DIAMOND_SWORD, 1, 1554);

			ItemStackUtilities.setUnbreakable(Item, true, true);
			ItemStackUtilities.setName(Item, "Diamond Sickle");
			Item = ItemStackUtilities.setAttack(Item, 4.0, 1.0, false, false);
			Item = ItemStackUtilities.addDurabilityLore(Item, 1561, 1561);

			CustomItems.put(38, Item);

		}

		public static void EmeraldSickle() { // ID OF 39

			ItemStack Item = ItemStackUtilities.createItem(Material.DIAMOND_SWORD, 1, 1553);

			ItemStackUtilities.setUnbreakable(Item, true, false);
			ItemStackUtilities.setName(Item, "Emerald Sickle");
			Item = ItemStackUtilities.setAttack(Item, 4.0, 1.0, false, false);

			CustomItems.put(39, Item);

		}
		
		// === SLIME BUCKETS === //
		
		public static void SlimeBucket() { // ID OF 40

			ItemStack Item = ItemStackUtilities.createItem(Material.DIAMOND_SWORD, 1, 1552);

			ItemStackUtilities.setUnbreakable(Item, true, true);
			ItemStackUtilities.setName(Item, "Slime Bucket");
			Item = ItemStackUtilities.setAttack(Item, 4.0, 1.0, false, false);

			CustomItems.put(40, Item);

		}
		
		public static void HoppingSlimeBucket() { // ID OF 41

			ItemStack Item = ItemStackUtilities.createItem(Material.DIAMOND_SWORD, 1, 1551);

			ItemStackUtilities.setUnbreakable(Item, true, true);
			ItemStackUtilities.setName(Item, "Slime Bucket");
			Item = ItemStackUtilities.setAttack(Item, 4.0, 1.0, false, false);

			CustomItems.put(41, Item);

		}
		
		// === CHISELS === //
		
		public static void WoodenChisel() { // ID OF 42

			ItemStack Item = ItemStackUtilities.createItem(Material.WOOD_PICKAXE, 1, 59);

			ItemStackUtilities.setUnbreakable(Item, true, true);
			ItemStackUtilities.setName(Item, "Wooden Chisel");
			Item = ItemStackUtilities.addDurabilityLore(Item, 59, 59);

			CustomItems.put(42, Item);

		}

		public static void StoneChisel() { // ID OF 43

			ItemStack Item = ItemStackUtilities.createItem(Material.STONE_PICKAXE, 1, 130);

			ItemStackUtilities.setUnbreakable(Item, true, true);
			ItemStackUtilities.setName(Item, "Stone Chisel");
			Item = ItemStackUtilities.addDurabilityLore(Item, 131, 131);

			CustomItems.put(43, Item);

		}
		
		public static void EndStoneChisel() { // ID OF 44

			ItemStack Item = ItemStackUtilities.createItem(Material.STONE_PICKAXE, 1, 129);

			ItemStackUtilities.setUnbreakable(Item, true, true);
			ItemStackUtilities.setName(Item, "Stone Chisel");
			Item = ItemStackUtilities.addDurabilityLore(Item, 131, 131);

			CustomItems.put(44, Item);

		}

		public static void IronChisel() { // ID OF 45

			ItemStack Item = ItemStackUtilities.createItem(Material.IRON_PICKAXE, 1, 250);

			ItemStackUtilities.setUnbreakable(Item, true, true);
			ItemStackUtilities.setName(Item, "Iron Chisel");
			Item = ItemStackUtilities.addDurabilityLore(Item, 250, 250);

			CustomItems.put(45, Item);

		}

		public static void GoldChisel() { // ID OF 46

			ItemStack Item = ItemStackUtilities.createItem(Material.GOLD_PICKAXE, 1, 32);

			ItemStackUtilities.setUnbreakable(Item, true, true);
			ItemStackUtilities.setName(Item, "Golden Chisel");
			Item = ItemStackUtilities.addDurabilityLore(Item, 32, 32);

			CustomItems.put(46, Item);

		}

		public static void DiamondChisel() { // ID OF 47

			ItemStack Item = ItemStackUtilities.createItem(Material.DIAMOND_PICKAXE, 1, 1560);

			ItemStackUtilities.setUnbreakable(Item, true, true);
			ItemStackUtilities.setName(Item, "Diamond Chisel");
			Item = ItemStackUtilities.addDurabilityLore(Item, 1561, 1561);

			CustomItems.put(47, Item);

		}

		public static void EmeraldChisel() { // ID OF 48

			ItemStack Item = ItemStackUtilities.createItem(Material.DIAMOND_PICKAXE, 1, 1559);

			ItemStackUtilities.setUnbreakable(Item, true, false);
			ItemStackUtilities.setName(Item, "Emerald Chisel");

			CustomItems.put(48, Item);

		}
		
}
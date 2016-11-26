package com.craft4plus.custom.items;

import org.bukkit.inventory.ItemStack;

public class CustomItemStack {
	// === EMERALD ITEMS === //
	public static ItemStack EMERALD_SWORD = getItem(1);
	public static ItemStack EMERALD_AXE = getItem(2);
	public static ItemStack EMERALD_PICKAXE = getItem(3);
	public static ItemStack EMERALD_SHOVEL = getItem(4);
	public static ItemStack EMERALD_HOE = getItem(5);
	public static ItemStack EMERALD_HELMET = getItem(6);
	public static ItemStack EMERALD_CHESTPLATE = getItem(7);
	public static ItemStack EMERALD_LEGGINGS = getItem(8);
	public static ItemStack EMERALD_BOOTS = getItem(9);

	// === DOUBLE AXES === //
	public static ItemStack WOODEN_DOUBLE_AXE = getItem(10);
	public static ItemStack STONE_DOUBLE_AXE = getItem(11);
	public static ItemStack IRON_DOUBLE_AXE = getItem(12);
	public static ItemStack GOLD_DOUBLE_AXE = getItem(13);
	public static ItemStack DIAMOND_DOUBLE_AXE = getItem(14);
	public static ItemStack EMERALD_DOUBLE_AXE = getItem(15);
	
	// === STONE ARMOR === //
	public static ItemStack STONE_HELMET = getItem(16);
	public static ItemStack STONE_CHESTPLATE = getItem(17);
	public static ItemStack STONE_LEGGINGS = getItem(18);
	public static ItemStack STONE_BOOTS = getItem(19);
	
	// === END STONE ITEMS === //
	public static ItemStack END_STONE_HELMET = getItem(20);
	public static ItemStack END_STONE_CHESTPLATE = getItem(21);
	public static ItemStack END_STONE_LEGGINGS = getItem(22);
	public static ItemStack END_STONE_BOOTS = getItem(23);
	public static ItemStack END_STONE_SWORD = getItem(24);
	public static ItemStack END_STONE_AXE = getItem(25);
	public static ItemStack END_STONE_DOUBLE_AXE = getItem(26);
	public static ItemStack END_STONE_PICKAXE = getItem(27);
	public static ItemStack END_STONE_SHOVEL = getItem(28);
	public static ItemStack END_STONE_HOE = getItem(29);

	// === FOOD === //
	public static ItemStack GOLDFISH = getItem(30);

	// === SLIME ARMOR === //
	public static ItemStack SLIME_BOOTS = getItem(31);
	
	// === SUPER HOES === //
	public static ItemStack SUPER_HOE_BREAK_PLACEHOLDER = getItem(32);
	public static ItemStack WOODEN_SICKLE = getItem(33);
	public static ItemStack STONE_SICKLE = getItem(34);
	public static ItemStack END_STONE_SICKLE = getItem(35);
	public static ItemStack IRON_SICKLE = getItem(36);
	public static ItemStack GOLD_SICKLE = getItem(37);
	public static ItemStack DIAMOND_SICKLE = getItem(38);
	public static ItemStack EMERALD_SICKLE = getItem(39);
	
	public static ItemStack getItem(int id) {
		return CustomItems.CustomItems.get(id);
	}

}
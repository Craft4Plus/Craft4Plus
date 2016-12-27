package com.craft4plus.custom.items;

import org.bukkit.inventory.ItemStack;

public class CustomItemStack {
	// === EMERALD ITEMS === //
	public final static ItemStack EMERALD_SWORD = getItem(1);
	public final static ItemStack EMERALD_AXE = getItem(2);
	public final static ItemStack EMERALD_PICKAXE = getItem(3);
	public final static ItemStack EMERALD_SHOVEL = getItem(4);
	public final static ItemStack EMERALD_HOE = getItem(5);
	public final static ItemStack EMERALD_HELMET = getItem(6);
	public final static ItemStack EMERALD_CHESTPLATE = getItem(7);
	public final static ItemStack EMERALD_LEGGINGS = getItem(8);
	public final static ItemStack EMERALD_BOOTS = getItem(9);

	// === DOUBLE AXES === //
	public final static ItemStack WOODEN_DOUBLE_AXE = getItem(10);
	public final static ItemStack STONE_DOUBLE_AXE = getItem(11);
	public final static ItemStack IRON_DOUBLE_AXE = getItem(12);
	public final static ItemStack GOLD_DOUBLE_AXE = getItem(13);
	public final static ItemStack DIAMOND_DOUBLE_AXE = getItem(14);
	public final static ItemStack EMERALD_DOUBLE_AXE = getItem(15);

	// === STONE ARMOR === //
	public final static ItemStack STONE_HELMET = getItem(16);
	public final static ItemStack STONE_CHESTPLATE = getItem(17);
	public final static ItemStack STONE_LEGGINGS = getItem(18);
	public final static ItemStack STONE_BOOTS = getItem(19);

	// === END STONE ITEMS === //
	public final static ItemStack END_STONE_HELMET = getItem(20);
	public final static ItemStack END_STONE_CHESTPLATE = getItem(21);
	public final static ItemStack END_STONE_LEGGINGS = getItem(22);
	public final static ItemStack END_STONE_BOOTS = getItem(23);
	public final static ItemStack END_STONE_SWORD = getItem(24);
	public final static ItemStack END_STONE_AXE = getItem(25);
	public final static ItemStack END_STONE_DOUBLE_AXE = getItem(26);
	public final static ItemStack END_STONE_PICKAXE = getItem(27);
	public final static ItemStack END_STONE_SHOVEL = getItem(28);
	public final static ItemStack END_STONE_HOE = getItem(29);

	// === FOOD === //
	public final static ItemStack GOLDFISH = getItem(30);

	// === SLIME ARMOR === //
	public final static ItemStack SLIME_BOOTS = getItem(31);

	// === SUPER HOES === //
	public final static ItemStack SUPER_HOE_BREAK_PLACEHOLDER = getItem(32);
	public final static ItemStack WOODEN_SICKLE = getItem(33);
	public final static ItemStack STONE_SICKLE = getItem(34);
	public final static ItemStack END_STONE_SICKLE = getItem(35);
	public final static ItemStack IRON_SICKLE = getItem(36);
	public final static ItemStack GOLD_SICKLE = getItem(37);
	public final static ItemStack DIAMOND_SICKLE = getItem(38);
	public final static ItemStack EMERALD_SICKLE = getItem(39);

	// === SLIME BUCKETS === //
	public final static ItemStack SLIME_BUCKET = getItem(40);
	public final static ItemStack HOPPING_SLIME_BUCKET = getItem(41);

	// === CHISELS === //
	public final static ItemStack WOODEN_CHISEL = getItem(42);
	public final static ItemStack STONE_CHISEL = getItem(43);
	public final static ItemStack END_STONE_CHISEL = getItem(44);
	public final static ItemStack IRON_CHISEL = getItem(45);
	public final static ItemStack GOLD_CHISEL = getItem(46);
	public final static ItemStack DIAMOND_CHISEL = getItem(47);
	public final static ItemStack EMERALD_CHISEL = getItem(48);

	public static ItemStack getItem(int id) {
		return CustomItems.CustomItems.get(id);
	}

}
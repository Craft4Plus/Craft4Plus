package com.craft4plus.custom.items;

import org.bukkit.inventory.ItemStack;

public class CustomItemStack {
	public static ItemStack EMERALD_SWORD() {
		return getItem(1);
	}
	public static ItemStack EMERALD_AXE() {
		return getItem(2);
	}
    public static ItemStack EMERALD_PICKAXE() {
    	return getItem(3);
    }
    public static ItemStack EMERALD_SHOVEL() {
    	return getItem(4);
    }
    public static ItemStack EMERALD_HOE() {
    	return getItem(5);
    }
    public static ItemStack EMERALD_HELMET() {
    	return getItem(6);
    }
    public static ItemStack EMERALD_CHESTPLATE() {
    	return getItem(7);
    }
    public static ItemStack EMERALD_LEGGINGS() {
    	return getItem(8);
    }
    public static ItemStack EMERALD_BOOTS() {
    	return getItem(9);
    }
    
    // DOUBLE AXES
    public static ItemStack WOODEN_DOUBLE_AXE() {
    	return getItem(10);
    }
    public static ItemStack STONE_DOUBLE_AXE() {
    	return getItem(11);
    }
    public static ItemStack IRON_DOUBLE_AXE() {
    	return getItem(12);
    }
    public static ItemStack GOLD_DOUBLE_AXE() {
    	return getItem(13);
    }
    public static ItemStack DIAMOND_DOUBLE_AXE() {
    	return getItem(14);
    }
    public static ItemStack EMERALD_DOUBLE_AXE() {
    	return getItem(15);
    }
    
    // Stone Armor
    public static ItemStack STONE_HELMET() {
    	return getItem(16);
    }
    public static ItemStack STONE_CHESTPLATE() {
    	return getItem(17);
    }
    public static ItemStack STONE_LEGGINGS() {
    	return getItem(18);
    }
    public static ItemStack STONE_BOOTS() {
    	return getItem(19);
    }
    
    // End Stone Items
    public static ItemStack END_STONE_HELMET() {
    	return getItem(20);
    }
    public static ItemStack END_STONE_CHESTPLATE() {
    	return getItem(21);
    }
    public static ItemStack END_STONE_LEGGINGS() {
    	return getItem(22);
    }
    public static ItemStack END_STONE_BOOTS() {
    	return getItem(23);
    }
    public static ItemStack END_STONE_SWORD() {
    	return getItem(24);
    }
    public static ItemStack END_STONE_AXE() {
    	return getItem(25);
    }
    public static ItemStack END_STONE_DOUBLE_AXE() {
    	return getItem(26);
    }
    public static ItemStack END_STONE_PICKAXE() {
    	return getItem(27);
    }
    public static ItemStack END_STONE_SHOVEL() {
    	return getItem(28);
    }
    public static ItemStack END_STONE_HOE() {
    	return getItem(29);
    }
    
    // Food
    public static ItemStack GOLDFISH() {
    	return getItem(30);
    }
    ;

    public static ItemStack getItem(int id) {
    	return CustomItems.CustomItems.get(id);
    }

}
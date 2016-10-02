package com.craft4plus.custom;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class CraftingRecipes {
	
	public static void addCustomCraftingRecipes() {
	
		addEmeraldSword();
		
	}
	
	public static void addEmeraldSword() {
		
		ItemStack item = CustomItems.EmeraldSword();
		
	    ShapedRecipe ItemRecipe1 = new ShapedRecipe(item);
		 
		ItemRecipe1.shape("123","456","789");
		 
		ItemRecipe1.setIngredient('1', Material.EMERALD);
		ItemRecipe1.setIngredient('4', Material.EMERALD);
		ItemRecipe1.setIngredient('7', Material.STICK);
		 
		Bukkit.getServer().addRecipe(ItemRecipe1);
		
		ShapedRecipe ItemRecipe2 = new ShapedRecipe(item);
		 
		ItemRecipe2.shape("123","456","789");
		 
		ItemRecipe2.setIngredient('2', Material.EMERALD);
		ItemRecipe2.setIngredient('5', Material.EMERALD);
		ItemRecipe2.setIngredient('8', Material.STICK);
		 
		Bukkit.getServer().addRecipe(ItemRecipe2);
		
		ShapedRecipe ItemRecipe3 = new ShapedRecipe(item);
		 
		ItemRecipe3.shape("123","456","789");
		 
		ItemRecipe3.setIngredient('3', Material.EMERALD);
		ItemRecipe3.setIngredient('6', Material.EMERALD);
		ItemRecipe3.setIngredient('9', Material.STICK);
		 
		Bukkit.getServer().addRecipe(ItemRecipe3);
	}
	
	public static void addEmeraldAxe() {
		
		ItemStack item = CustomItems.EmeraldAxe();
		
	    ShapedRecipe ItemRecipe1 = new ShapedRecipe(item);
		 
		ItemRecipe1.shape("123","456","789");
		
		ItemRecipe1.setIngredient('5', Material.STICK);
		ItemRecipe1.setIngredient('8', Material.STICK);
		ItemRecipe1.setIngredient('1', Material.EMERALD);
		ItemRecipe1.setIngredient('2', Material.EMERALD);
		ItemRecipe1.setIngredient('4', Material.EMERALD);

		Bukkit.getServer().addRecipe(ItemRecipe1);
		
		ShapedRecipe ItemRecipe2 = new ShapedRecipe(item);
		 
		ItemRecipe2.shape("123","456","789");
		 
		ItemRecipe1.setIngredient('5', Material.STICK);
		ItemRecipe1.setIngredient('8', Material.STICK);
		ItemRecipe1.setIngredient('3', Material.EMERALD);
		ItemRecipe1.setIngredient('2', Material.EMERALD);
		ItemRecipe1.setIngredient('6', Material.EMERALD);
		 
		Bukkit.getServer().addRecipe(ItemRecipe2);
	}
	
	public static void addEmeraldPickaxe() {
		
		ItemStack item = CustomItems.EmeraldPickaxe();
		
	    ShapedRecipe ItemRecipe1 = new ShapedRecipe(item);
		 
		ItemRecipe1.shape("123","456","789");
		 
		ItemRecipe1.setIngredient('5', Material.STICK);
		ItemRecipe1.setIngredient('8', Material.STICK);
		ItemRecipe1.setIngredient('1', Material.EMERALD);
		ItemRecipe1.setIngredient('2', Material.EMERALD);
		ItemRecipe1.setIngredient('3', Material.EMERALD);
		 
		Bukkit.getServer().addRecipe(ItemRecipe1);
	}
	
	public static void addEmeraldShovel() {
		
		ItemStack item = CustomItems.EmeraldShovel();
		
	    ShapedRecipe ItemRecipe1 = new ShapedRecipe(item);
		 
		ItemRecipe1.shape("123","456","789");
		 
		ItemRecipe1.setIngredient('5', Material.STICK);
		ItemRecipe1.setIngredient('8', Material.STICK);
		ItemRecipe1.setIngredient('2', Material.EMERALD);
		 
		Bukkit.getServer().addRecipe(ItemRecipe1);
	}
	
	public static void addEmeraldHoe() {
		
		ItemStack item = CustomItems.EmeraldHoe();
		
	    ShapedRecipe ItemRecipe1 = new ShapedRecipe(item);
		 
		ItemRecipe1.shape("123","456","789");
		 
		ItemRecipe1.setIngredient('5', Material.STICK);
		ItemRecipe1.setIngredient('8', Material.STICK);
		ItemRecipe1.setIngredient('2', Material.EMERALD);
		ItemRecipe1.setIngredient('3', Material.EMERALD);
		 
		Bukkit.getServer().addRecipe(ItemRecipe1);
		
		ShapedRecipe ItemRecipe2 = new ShapedRecipe(item);
		 
		ItemRecipe2.shape("123","456","789");
		 
		ItemRecipe1.setIngredient('5', Material.STICK);
		ItemRecipe1.setIngredient('8', Material.STICK);
		ItemRecipe1.setIngredient('1', Material.EMERALD);
		ItemRecipe1.setIngredient('2', Material.EMERALD);
		 
		Bukkit.getServer().addRecipe(ItemRecipe2);
	}
	
}

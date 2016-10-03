package com.craft4plus.custom;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import com.craft4plus.main.Main;

public class CraftingRecipes {
	
	public static void addCustomCraftingRecipes() {
	
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() { //Schedule a repeating task
			@Override
			public void run() {
				addEmeraldSword();
			}
		}, 1L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() { //Schedule a repeating task
		@Override
		public void run() {
			addEmeraldAxe();
		}
		}, 1L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() { //Schedule a repeating task
			@Override
			public void run() {
				addEmeraldPickaxe();
			}
		}, 1L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() { //Schedule a repeating task
			@Override
			public void run() {
				addEmeraldShovel();
			}
		}, 1L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() { //Schedule a repeating task
			@Override
			public void run() {
				addEmeraldHoe();
			}
		}, 1L);
		
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
		
	    ShapedRecipe ItemRecipe4 = new ShapedRecipe(item);
		 
		ItemRecipe4.shape("123","456","789");
		
		ItemRecipe4.setIngredient('5', Material.STICK);
		ItemRecipe4.setIngredient('8', Material.STICK);
		ItemRecipe4.setIngredient('1', Material.EMERALD);
		ItemRecipe4.setIngredient('2', Material.EMERALD);
		ItemRecipe4.setIngredient('4', Material.EMERALD);

		Bukkit.getServer().addRecipe(ItemRecipe4);
		
		ShapedRecipe ItemRecipe5 = new ShapedRecipe(item);
		 
		ItemRecipe5.shape("123","456","789");
		 
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
		 
		ItemRecipe6.shape("123","456","789");
		 
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
		 
		ItemRecipe7.shape("123","456","789");
		 
		ItemRecipe7.setIngredient('5', Material.STICK);
		ItemRecipe7.setIngredient('8', Material.STICK);
		ItemRecipe7.setIngredient('2', Material.EMERALD);
		 
		Bukkit.getServer().addRecipe(ItemRecipe7);
	}
	
	public static void addEmeraldHoe() {
		
		ItemStack item = CustomItems.EmeraldHoe();
		
	    ShapedRecipe ItemRecipe8 = new ShapedRecipe(item);
		 
		ItemRecipe8.shape("123","456","789");
		 
		ItemRecipe8.setIngredient('5', Material.STICK);
		ItemRecipe8.setIngredient('8', Material.STICK);
		ItemRecipe8.setIngredient('2', Material.EMERALD);
		ItemRecipe8.setIngredient('3', Material.EMERALD);
		 
		Bukkit.getServer().addRecipe(ItemRecipe8);
		
		ShapedRecipe ItemRecipe9 = new ShapedRecipe(item);
		 
		ItemRecipe9.shape("123","456","789");
		 
		ItemRecipe9.setIngredient('5', Material.STICK);
		ItemRecipe9.setIngredient('8', Material.STICK);
		ItemRecipe9.setIngredient('1', Material.EMERALD);
		ItemRecipe9.setIngredient('2', Material.EMERALD);
		 
		Bukkit.getServer().addRecipe(ItemRecipe9);
	}
	
}

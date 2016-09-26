package com.craft4plus.custom.items;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_10_R1.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_10_R1.NBTTagCompound;
import net.minecraft.server.v1_10_R1.NBTTagInt;
import net.minecraft.server.v1_10_R1.NBTTagList;
import net.minecraft.server.v1_10_R1.NBTTagString;

public class EmeraldItems {
	
	public static void addEmeraldSword() {

		ItemStack EmeraldSword = new ItemStack(Material.GOLD_SWORD, 1, (short)32);
		
		ItemMeta EmeraldSwordMeta = EmeraldSword.getItemMeta();
		EmeraldSwordMeta.spigot().setUnbreakable(true);
		
        net.minecraft.server.v1_10_R1.ItemStack nmsStack = CraftItemStack.asNMSCopy(EmeraldSword);
        NBTTagCompound EmeraldSwordCompound = (nmsStack.hasTag()) ? nmsStack.getTag() : new NBTTagCompound();
       
        NBTTagList EmeraldSwordModifiers = new NBTTagList();
       
        // -- attack damage
        NBTTagCompound EmeraldSwordDamage = new NBTTagCompound();
        EmeraldSwordDamage.set("AttributeName", new NBTTagString("generic.attackDamage"));
        EmeraldSwordDamage.set("Name", new NBTTagString("generic.attackDamage"));
        EmeraldSwordDamage.set("Amount", new NBTTagInt(7));
        EmeraldSwordDamage.set("Operation", new NBTTagInt(0));
        EmeraldSwordDamage.set("UUIDLeast", new NBTTagInt(894654));
        EmeraldSwordDamage.set("UUIDMost", new NBTTagInt(2872));
        EmeraldSwordDamage.set("Slot", new NBTTagString("mainhand"));

        // -- apply modifiers
        EmeraldSwordModifiers.add(EmeraldSwordDamage);
        EmeraldSwordCompound.set("AttributeModifiers", EmeraldSwordModifiers);
		
		EmeraldSwordMeta.setDisplayName(ChatColor.RESET + "Emerald Sword");
	    EmeraldSword.setItemMeta(EmeraldSwordMeta);
	    
	    ShapedRecipe EmeraldSwordRecipe1 = new ShapedRecipe(EmeraldSword);
		 
		EmeraldSwordRecipe1.shape("123","456","789");
		 
		EmeraldSwordRecipe1.setIngredient('1', Material.EMERALD);
		EmeraldSwordRecipe1.setIngredient('4', Material.EMERALD);
		EmeraldSwordRecipe1.setIngredient('7', Material.STICK);
		 
		Bukkit.getServer().addRecipe(EmeraldSwordRecipe1);
		
		ShapedRecipe EmeraldSwordRecipe2 = new ShapedRecipe(EmeraldSword);
		 
		EmeraldSwordRecipe2.shape("123","456","789");
		 
		EmeraldSwordRecipe2.setIngredient('2', Material.EMERALD);
		EmeraldSwordRecipe2.setIngredient('5', Material.EMERALD);
		EmeraldSwordRecipe2.setIngredient('8', Material.STICK);
		 
		Bukkit.getServer().addRecipe(EmeraldSwordRecipe2);
		
		ShapedRecipe EmeraldSwordRecipe3 = new ShapedRecipe(EmeraldSword);
		 
		EmeraldSwordRecipe3.shape("123","456","789");
		 
		EmeraldSwordRecipe3.setIngredient('3', Material.EMERALD);
		EmeraldSwordRecipe3.setIngredient('6', Material.EMERALD);
		EmeraldSwordRecipe3.setIngredient('9', Material.STICK);
		 
		Bukkit.getServer().addRecipe(EmeraldSwordRecipe3);
    
	}
	
}

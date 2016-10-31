package com.craft4plus.custom.items;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_10_R1.inventory.CraftItemStack;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_10_R1.NBTTagCompound;
import net.minecraft.server.v1_10_R1.NBTTagDouble;
import net.minecraft.server.v1_10_R1.NBTTagInt;
import net.minecraft.server.v1_10_R1.NBTTagList;
import net.minecraft.server.v1_10_R1.NBTTagString;

public class ItemStackUtilities {

	public static int ArmorUUID = 1;

	public static ItemStack createItem(Material material, int quantity, int durability) {

		ItemStack Item = new ItemStack(material, quantity, (short) durability);
		return Item;

	}

	public static void setUnbreakable(ItemStack Item, boolean SetUnbreakable, boolean HideUnbreakableTag) {

		ItemMeta ItemMeta = Item.getItemMeta();
		ItemMeta.spigot().setUnbreakable(SetUnbreakable);
		if (HideUnbreakableTag) {
			ItemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		}
		Item.setItemMeta(ItemMeta);

	}

	public static void setName(ItemStack Item, String ItemName) {

		ItemMeta ItemMeta = Item.getItemMeta();
		ItemMeta.setDisplayName(ChatColor.RESET + ItemName);
		Item.setItemMeta(ItemMeta);

	}

	public static ItemStack setArmorLevel(ItemStack Item, int ArmorLevel, int ArmorToughnessLevel,
			String ApplicationArea) {

		net.minecraft.server.v1_10_R1.ItemStack nmsStack = CraftItemStack.asNMSCopy(Item);
		NBTTagCompound ItemCompound = (nmsStack.hasTag()) ? nmsStack.getTag() : new NBTTagCompound();

		NBTTagList ItemModifiers = new NBTTagList();

		NBTTagCompound ItemArmor = new NBTTagCompound();
		ItemArmor.set("AttributeName", new NBTTagString("generic.armor"));
		ItemArmor.set("Name", new NBTTagString("generic.armor"));
		ItemArmor.set("Amount", new NBTTagDouble(ArmorLevel));
		ItemArmor.set("Operation", new NBTTagInt(0));
		ItemArmor.set("UUIDLeast", new NBTTagInt(ArmorUUID));
		ItemArmor.set("UUIDMost", new NBTTagInt(ArmorUUID));
		ItemArmor.set("Slot", new NBTTagString(ApplicationArea)); // Can be
																	// "mainhand",
																	// "offhand",
																	// "feet",
																	// "legs",
																	// "chest",
																	// "head"

		NBTTagCompound ItemArmorToughness = new NBTTagCompound();
		ItemArmorToughness.set("AttributeName", new NBTTagString("generic.armorToughness"));
		ItemArmorToughness.set("Name", new NBTTagString("generic.armorToughness"));
		ItemArmorToughness.set("Amount", new NBTTagDouble(ArmorToughnessLevel));
		ItemArmorToughness.set("Operation", new NBTTagInt(0));
		ItemArmorToughness.set("UUIDLeast", new NBTTagInt(ArmorUUID));
		ItemArmorToughness.set("UUIDMost", new NBTTagInt(ArmorUUID));
		ItemArmorToughness.set("Slot", new NBTTagString(ApplicationArea)); // Can
																			// be
																			// "mainhand",
																			// "offhand",
																			// "feet",
																			// "legs",
																			// "chest",
																			// "head"

		ItemModifiers.add(ItemArmor);
		ItemModifiers.add(ItemArmorToughness);
		ItemCompound.set("AttributeModifiers", ItemModifiers);

		ArmorUUID = ArmorUUID + 1;

		nmsStack.setTag(ItemCompound);
		return CraftItemStack.asBukkitCopy(nmsStack);

	}

	public static ItemStack setAttack(ItemStack Item, double AttackSpeed, double AttackDamage, boolean ShowText, boolean addFakeText) {

//		if (addFakeText) {
//			ItemMeta im = Item.getItemMeta();
//			im.setDisplayName(im.getDisplayName());
//			if (Item.getItemMeta().getLore() == null) {
//				List<String> loreList = new ArrayList<String>();
//				loreList.add("");
//				loreList.add(ChatColor.GRAY + "When in main hand: ");
//				if (AttackDamage != Math.round(AttackSpeed)) {
//					loreList.add(ChatColor.GRAY + " " + AttackSpeed + " Attack Speed");
//				} else {
//					loreList.add(ChatColor.GRAY + " " + Integer.toString((int) AttackSpeed) + " Attack Speed");
//				}
//				if (AttackDamage != Math.round(AttackDamage)) {
//					loreList.add(ChatColor.GRAY + " " + AttackDamage + " Attack Speed");
//				} else {
//					loreList.add(ChatColor.GRAY + " " + Integer.toString((int) AttackDamage) + " Attack Speed");
//				}
//				im.setLore(loreList);
//				Item.setItemMeta(im);
//			} else {
//				List<String> loreList = Item.getItemMeta().getLore();
//				loreList.add("");
//				loreList.add(ChatColor.GRAY + "When in main hand: ");
//				if (AttackDamage != Math.round(AttackSpeed)) {
//					loreList.add(ChatColor.GRAY + " " + AttackSpeed + " Attack Speed");
//				} else {
//					loreList.add(ChatColor.GRAY + " " + Integer.toString((int) AttackSpeed) + " Attack Speed");
//				}
//				if (AttackDamage != Math.round(AttackDamage)) {
//					loreList.add(ChatColor.GRAY + " " + AttackDamage + " Attack Speed");
//				} else {
//					loreList.add(ChatColor.GRAY + " " + Integer.toString((int) AttackDamage) + " Attack Speed");
//				}
//				im.setLore(loreList);
//				Item.setItemMeta(im);
//			}
//		}
		
		
		net.minecraft.server.v1_10_R1.ItemStack nmsStack = CraftItemStack.asNMSCopy(Item);
		NBTTagCompound ItemCompound = (nmsStack.hasTag()) ? nmsStack.getTag() : new NBTTagCompound();

		NBTTagList ItemModifiers = new NBTTagList();

		// -- attack damage
		NBTTagCompound ItemDamage = new NBTTagCompound();
		ItemDamage.set("AttributeName", new NBTTagString("generic.attackDamage"));
		if (ShowText) {
			ItemDamage.set("Name", new NBTTagString("generic.attackDamage"));
		} else {
			ItemDamage.set("Name", new NBTTagString("generic.attackDamage"));
		}
		ItemDamage.set("Amount", new NBTTagDouble(AttackDamage - 1.0));
		ItemDamage.set("Operation", new NBTTagInt(0));
		ItemDamage.set("UUIDLeast", new NBTTagInt(894654));
		ItemDamage.set("UUIDMost", new NBTTagInt(2872));
		ItemDamage.set("Slot", new NBTTagString("mainhand"));

		// -- attack speed
		NBTTagCompound ItemSpeed = new NBTTagCompound();
		ItemSpeed.set("AttributeName", new NBTTagString("generic.attackSpeed"));
		if (ShowText){
			ItemSpeed.set("Name", new NBTTagString("generic.attackSpeed"));
		} else {
			ItemSpeed.set("Name", new NBTTagString("generic.attackSpeed"));
		}
		ItemSpeed.set("Amount", new NBTTagDouble(AttackSpeed - 4.0));
		ItemSpeed.set("Operation", new NBTTagInt(0));
		ItemSpeed.set("UUIDLeast", new NBTTagInt(894654));
		ItemSpeed.set("UUIDMost", new NBTTagInt(2872));
		ItemSpeed.set("Slot", new NBTTagString("mainhand"));

		// -- apply modifiers
		ItemModifiers.add(ItemSpeed);
		ItemModifiers.add(ItemDamage);
		ItemCompound.set("AttributeModifiers", ItemModifiers);
		
		nmsStack.setTag(ItemCompound);
		
		return CraftItemStack.asBukkitCopy(nmsStack);

	}
	
	public static ItemStack nullifyModifiers(ItemStack Item) {

		net.minecraft.server.v1_10_R1.ItemStack nmsStack = CraftItemStack.asNMSCopy(Item);
		NBTTagCompound ItemCompound = (nmsStack.hasTag()) ? nmsStack.getTag() : new NBTTagCompound();

		NBTTagList ItemModifiers = new NBTTagList();
		NBTTagCompound ItemDamage = new NBTTagCompound();
		ItemModifiers.add(ItemDamage);
		ItemCompound.set("AttributeModifiers", ItemModifiers);
		
		nmsStack.setTag(ItemCompound);
		
		return CraftItemStack.asBukkitCopy(nmsStack);
		
	}

	public static void setLeatherArmorColor(ItemStack Item, int Red, int Green, int Blue) {

		LeatherArmorMeta meta = (LeatherArmorMeta) Item.getItemMeta();

		meta.setColor(Color.fromRGB(Red, Green, Blue));

		ItemMeta ItemMeta = Item.getItemMeta();
		Item.setItemMeta(ItemMeta);

		Item.setItemMeta(meta);

	}

	public static ItemStack addDurabilityLore(ItemStack item, int CurrentDurability, int MaximumDurability) {
		ItemMeta im = item.getItemMeta();
		im.setDisplayName(im.getDisplayName());
		if (item.getItemMeta().getLore() == null) {
			List<String> loreList = new ArrayList<String>();
			loreList.add(ChatColor.GRAY + "Durability: " + Integer.toString(CurrentDurability) + " / "
					+ Integer.toString(MaximumDurability));// This is the first
															// line of lore
			im.setLore(loreList);
			item.setItemMeta(im);
		} else {
			List<String> loreList = item.getItemMeta().getLore();
			loreList.add(ChatColor.GRAY + "Durability: " + Integer.toString(CurrentDurability) + " / "
					+ Integer.toString(MaximumDurability));// This is the first
															// line of lore
			im.setLore(loreList);
			item.setItemMeta(im);
		}
		return item;
	}

	
}
package com.craft4plus.custom;

import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_10_R1.inventory.CraftItemStack;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_10_R1.NBTTagCompound;
import net.minecraft.server.v1_10_R1.NBTTagDouble;
import net.minecraft.server.v1_10_R1.NBTTagInt;
import net.minecraft.server.v1_10_R1.NBTTagList;
import net.minecraft.server.v1_10_R1.NBTTagString;

public class CustomItems {

	public static ItemStack createItemOld(Material material, int quantity, int durability, String itemname,
			boolean unbreakable, boolean hideunbreaking, boolean hideattributes, Double attackdamage,
			Double attackspeed) {

		ItemStack Item = new ItemStack(material, quantity, (short) durability);

		if (attackdamage != null && attackspeed != null) {
			net.minecraft.server.v1_10_R1.ItemStack nmsStack = CraftItemStack.asNMSCopy(Item);
			NBTTagCompound ItemCompound = (nmsStack.hasTag()) ? nmsStack.getTag() : new NBTTagCompound();

			NBTTagList ItemModifiers = new NBTTagList();

			// -- attack damage
			NBTTagCompound ItemDamage = new NBTTagCompound();
			ItemDamage.set("AttributeName", new NBTTagString("generic.attackDamage"));
			ItemDamage.set("Name", new NBTTagString("generic.attackDamage"));
			ItemDamage.set("Amount", new NBTTagDouble(attackdamage - 1.0));
			ItemDamage.set("Operation", new NBTTagInt(0));
			ItemDamage.set("UUIDLeast", new NBTTagInt(894654));
			ItemDamage.set("UUIDMost", new NBTTagInt(2872));
			ItemDamage.set("Slot", new NBTTagString("mainhand"));

			// -- attack speed
			NBTTagCompound ItemSpeed = new NBTTagCompound();
			ItemSpeed.set("AttributeName", new NBTTagString("generic.attackSpeed"));
			ItemSpeed.set("Name", new NBTTagString("generic.attackSpeed"));
			ItemSpeed.set("Amount", new NBTTagDouble(attackspeed - 4.0));
			ItemSpeed.set("Operation", new NBTTagInt(0));
			ItemSpeed.set("UUIDLeast", new NBTTagInt(894654));
			ItemSpeed.set("UUIDMost", new NBTTagInt(2872));
			ItemSpeed.set("Slot", new NBTTagString("mainhand"));

			// -- apply modifiers
			ItemModifiers.add(ItemSpeed);
			ItemModifiers.add(ItemDamage);
			ItemCompound.set("AttributeModifiers", ItemModifiers);

			nmsStack.setTag(ItemCompound);
			Item = CraftItemStack.asBukkitCopy(nmsStack);
		}		

		ItemMeta ItemMeta = Item.getItemMeta();

		ItemMeta.spigot().setUnbreakable(unbreakable);

		if (hideunbreaking) {
			ItemMeta.removeItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		}

		if (hideattributes) {
			ItemMeta.removeItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		}

		ItemMeta.setDisplayName(ChatColor.RESET + itemname);

		Item.setItemMeta(ItemMeta);

		return Item;
	}

	public static ItemStack createItem(Material material, int quantity, int durability) {
		
		ItemStack Item = new ItemStack(material, quantity, (short) durability);
		return Item;
		
		}
	
	public static void setUnbreakable(ItemStack Item, boolean SetUnbreakable, boolean HideUnbreakableTag) {

		ItemMeta ItemMeta = Item.getItemMeta();
		ItemMeta.spigot().setUnbreakable(SetUnbreakable);
		if (HideUnbreakableTag) {
			ItemMeta.removeItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		}
		Item.setItemMeta(ItemMeta);

	}

	public static void setName(ItemStack Item, String ItemName) {

		ItemMeta ItemMeta = Item.getItemMeta();
		ItemMeta.setDisplayName(ChatColor.RESET + ItemName);
		Item.setItemMeta(ItemMeta);

	}
	
	public static ItemStack EmeraldSword() {

		ItemStack Item = createItem(Material.DIAMOND_SWORD, 1, 1561);
		
		setUnbreakable(Item, true, false);
		setName(Item, "Emerald Sword");
		
		return Item;
		
	}

	public static ItemStack EmeraldAxe() {
		
		ItemStack Item = createItem(Material.DIAMOND_AXE, 1, 1561);
		
		setUnbreakable(Item, true, false);
		setName(Item, "Emerald Axe");
		
		return Item;
		
	}

	public static ItemStack EmeraldPickaxe() {

		ItemStack Item = createItem(Material.DIAMOND_PICKAXE, 1, 1561);
		
		setUnbreakable(Item, true, false);
		setName(Item, "Emerald Pickaxe");
		
		return Item;
		
	}

	public static ItemStack EmeraldShovel() {
		
		ItemStack Item = createItem(Material.DIAMOND_SPADE, 1, 1561);

		setUnbreakable(Item, true, false);
		setName(Item, "Emerald Shovel");

		return Item;
		
	}

	public static ItemStack EmeraldHoe() {
		
		ItemStack Item = createItem(Material.DIAMOND_HOE, 1, 1561);
		
		setUnbreakable(Item, true, false);
		setName(Item, "Emerald Hoe");
		
		return Item;
		
	}

	public static int getCustomItemDurability(ItemStack item) {
		if ((item.getType().equals(Material.DIAMOND_SWORD)) || (item.getType().equals(Material.DIAMOND_AXE))
				|| (item.getType().equals(Material.DIAMOND_PICKAXE)) || (item.getType().equals(Material.DIAMOND_SPADE))
				|| (item.getType().equals(Material.DIAMOND_HOE))) {
			ItemMeta ItemMeta = item.getItemMeta();
			if (ItemMeta.spigot().isUnbreakable()) {
				return 123456789;
			}
			return 1561;
		}
		return 123456789;
	}

}

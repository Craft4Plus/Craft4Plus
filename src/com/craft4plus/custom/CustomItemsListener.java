package com.craft4plus.custom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.SpectralArrow;
import org.bukkit.entity.TippedArrow;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.Material;
import com.craft4plus.main.Main;
import com.craft4plus.miscellaneous.TreeBreaker;
import com.craft4plus.utils.armorequip.ArmorEquipEvent;

import net.md_5.bungee.api.ChatColor;

public class CustomItemsListener implements Listener {

	public void customItemCheck(Player player) {
		// Check if there is an item in hand and whether it should be broken due
		// to low durability.
		if ((!player.getInventory().getItemInMainHand().getType().equals(Material.AIR))
				&& (CustomItems.getCustomItemDurability(player.getInventory().getItemInMainHand()) != 123456789)
				&& (player.getInventory().getItemInMainHand().getDurability() >= CustomItems
						.getCustomItemDurability(player.getInventory().getItemInMainHand()))) {
			player.getInventory().removeItem(player.getInventory().getItemInMainHand());
			player.playSound(player.getLocation(), Sound.ENTITY_ITEM_BREAK, 1.0F, 1.0F);
		}

	}

	@EventHandler
	public void onEntityDamage(EntityDamageByEntityEvent event) {
		if ((event.getEntity() instanceof Player)) {
			Player player = (Player) event.getEntity();
			customItemCheck(player);
			if (!player.getInventory().getItemInMainHand().getType().equals(Material.AIR)) {
				ItemStack item = player.getInventory().getItemInMainHand();
				if (CustomItems.isDoubleAxe(item)) {
					CustomItems.reduceDurability(item, player, 2);
				}
				if (CustomItems.isEndStoneSword(item)) {
					CustomItems.reduceDurability(item, player, 1);
				}
				if (CustomItems.isEndStoneItem(item)) {
					CustomItems.reduceDurability(item, player, 2);
				}
			}

		}
	}

	@EventHandler
	public void onBlockBreakEvent(BlockBreakEvent event) {
		Player player = event.getPlayer();
		customItemCheck(player);
		if (!player.getInventory().getItemInMainHand().getType().equals(Material.AIR)) {
			if (CustomItems.isDoubleAxe(player.getInventory().getItemInMainHand())) {
				TreeBreaker.Chop(event.getBlock(), player, event.getBlock().getWorld());
				CustomItems.reduceDurability(player.getInventory().getItemInMainHand(), player, 1);
			}
		}
	}

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		customItemCheck(event.getPlayer());
	}

	@EventHandler
	public void onArmorEquip(ArmorEquipEvent event) {
		Player player = event.getPlayer();
		if ((event.getNewArmorPiece() != null) && (!event.getNewArmorPiece().getType().equals(Material.AIR))
				&& (CustomItems.isStoneArmor(event.getNewArmorPiece()))) {
			player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 9999999, 1));
		} else {
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
				public void run() {
					if (!(CustomItems.isStoneArmor(player.getInventory().getItem(39))
							|| CustomItems.isStoneArmor(player.getInventory().getItem(38))
							|| CustomItems.isStoneArmor(player.getInventory().getItem(37))
							|| CustomItems.isStoneArmor(player.getInventory().getItem(36)))) {
						if (player.hasPotionEffect(PotionEffectType.SLOW)) {
							for (PotionEffect effect : player.getActivePotionEffects()) {
								if (effect.getDuration() >= 1000 && effect.getAmplifier() == 1) {
									player.removePotionEffect(effect.getType());
								}
							}
						}
					}
				}
			}, 1L);
		}
	}

	// CUSTOM FOOD - UTILITY TO HAVE A BOW THAT CAN SHOOT WITHOUT ARROWS - MADE
	// BY Ugleh

	HashMap<Player, ItemStack> storedItem = new HashMap<Player, ItemStack>();
	List<UUID> drawing = new ArrayList<UUID>();

	@EventHandler
	public void PlayerItemHeldEvent(PlayerItemHeldEvent e) {
		Player player = e.getPlayer();
		if (!player.getGameMode().equals(GameMode.CREATIVE) && player.hasPermission("c4p.unlimitedarrows")) {
			returnItem(e.getPlayer());
		}
	}

	@EventHandler
	public void PlayerDropItemEvent(PlayerDropItemEvent e) {
		Player player = e.getPlayer();
		if (!player.getGameMode().equals(GameMode.CREATIVE) && player.hasPermission("c4p.unlimitedarrows")) {
			returnItem(e.getPlayer());
		}
	}

	@EventHandler
	public void EntityShootBowEvent(EntityShootBowEvent e) {
		if (e.getEntity() instanceof Player) {
			Player player = (Player) e.getEntity();
			if (!player.getGameMode().equals(GameMode.CREATIVE) && player.hasPermission("c4p.unlimitedarrows")) {
				returnItem((Player) e.getEntity());
			}

			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
				@Override
				public void run() {
					if (drawing.contains(player.getUniqueId())) {
						drawing.remove(player.getUniqueId());
					}
				}
			}, 1L);
		}

	}

	private void returnItem(Player player) {
		if (storedItem.containsKey(player.getPlayer())) {
			int slot = 9;
			player.getInventory().setItem(slot, storedItem.get(player));
			player.updateInventory();
			storedItem.remove(player);
		}
	}

	@EventHandler
	public void onDraw(PlayerInteractEvent e) {
		// On interact
		if (e.getItem() != null && e.getItem().getType() == Material.BOW) {
			// If item == Material.BOW
			drawing.add(e.getPlayer().getUniqueId());
		}
	}
	
	@EventHandler
	public void onInventoryOpen(InventoryOpenEvent event) {
		Player player = (Player) event.getPlayer();
		if (drawing.contains(player.getUniqueId())) {
			drawing.remove(player.getUniqueId());
		}
	}
	
	@EventHandler
	public void onItemHeldChange(PlayerItemHeldEvent event) {
		Player player = (Player) event.getPlayer();
		if (drawing.contains(player.getUniqueId())) {
			drawing.remove(player.getUniqueId());
		}
	}

	@EventHandler
	public void PlayerInteractEvent(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		ItemStack ItemInHand = e.getItem();
		if (!p.getGameMode().equals(GameMode.CREATIVE) && (p.hasPermission("c4p.unlimitedarrows") || CustomItems.isCustomFood(ItemInHand))) {
			if (!(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)))
				return;
			if (storedItem.containsKey(p))
				return;
			if ((p.getInventory().getItemInMainHand().getType().equals(org.bukkit.Material.BOW))
					|| (p.getInventory().getItemInOffHand().getType().equals(Material.BOW))) {
				int slot = 9;
				ItemStack item = p.getInventory().getItem(slot);
				storedItem.put(p, item);
				ItemStack arrow = new ItemStack(Material.ARROW, 1);
				ItemMeta meta = arrow.getItemMeta();
				meta.setDisplayName("Unlimited Arrow");
				arrow.setItemMeta(meta);
				p.getInventory().setItem(slot, arrow);
			}
		}
		if (CustomItems.isCustomFood(ItemInHand)) {
			p.sendMessage("Is custom food");
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
				@Override
				public void run() {
					if (drawing.contains(p.getUniqueId())) {
						p.sendMessage("Fooded");
					}
				}
			}, 40L);
		}
	}

	@EventHandler
	public void onArrowHit(ProjectileHitEvent event) {
		if ((event.getEntity() instanceof Arrow) && (event.getEntity().getShooter() instanceof Player)) {
			Player player = (Player) event.getEntity().getShooter();
			Arrow arrow = (Arrow) event.getEntity();
			if (player.hasPermission("c4p.unlimitedarrows")
					&& !(event.getEntity() instanceof TippedArrow || event.getEntity() instanceof SpectralArrow)) {
				arrow.remove();
			}
		}
	}

	// END OF CUSTOM FOOD

	// NETHER STAR EXPLOIT FIX
	@EventHandler
	public void craftItem(PrepareItemCraftEvent e) {
		CraftingInventory inv = e.getInventory();
		ItemStack netherstar = new ItemStack(Material.NETHER_STAR, 1);
		ItemMeta meta = netherstar.getItemMeta();
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&aNavigator"));
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.translateAlternateColorCodes('&', "&aRight click to use the World Navigator"));
		meta.setLore(lore);
		netherstar.setItemMeta(meta);
		if (inv.contains(netherstar)) {
			for (HumanEntity human : e.getViewers()) {
				human.closeInventory();
				human.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Don't use the navigator to craft items!");
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
					@Override
					public void run() {
						human.getInventory().setItem(8, netherstar);
					}
				}, 1L);
			}
		}
	}
	// END OF NETHER STAR EXPLOIT FIX

}

package com.craft4plus.custom;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.Material;

import com.craft4plus.main.Main;
import com.craft4plus.miscellaneous.TreeBreaker;
import com.craft4plus.utils.armorequip.ArmorEquipEvent;

import net.minecraft.server.v1_10_R1.MinecraftServer;

public class CustomItemsListener implements Listener {

	public void customItemCheck(Player player) {
		if ((!player.getInventory().getItemInMainHand().getType().equals(Material.AIR))
				&& (CustomItems.getCustomItemDurability(player.getInventory().getItemInMainHand()) != 123456789)
				&& (player.getInventory().getItemInMainHand().getDurability() >= CustomItems
						.getCustomItemDurability(player.getInventory().getItemInMainHand()))) {
			player.getInventory().removeItem(player.getInventory().getItemInMainHand()); // Check
																							// if
																							// there
																							// is
																							// an
																							// item
																							// in
																							// hand
																							// and
																							// if
																							// it
																							// should
																							// be
																							// broken
																							// due
																							// to
																							// low
																							// durability.
			player.playSound(player.getLocation(), Sound.ENTITY_ITEM_BREAK, 1.0F, 1.0F);
		}

	}

	@EventHandler
	public void onEntityDamage(EntityDamageByEntityEvent event) { // When an
																	// entity is
																	// hit
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
	public void onBlockBreakEvent(BlockBreakEvent event) { // When a block is
															// broken
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
	public void onPlayerInteract(PlayerInteractEvent event) { // When a player
																// interacts
																// with
																// something
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

	HashMap<UUID, ItemStack> storedItem = new HashMap<UUID, ItemStack>();
	HashMap<UUID, Integer> EatingState = new HashMap<UUID, Integer>();
	HashMap<UUID, Integer> EatingStateLastCheck = new HashMap<UUID, Integer>();

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
		}

	}

	private void returnItem(Player player) {
		if (storedItem.containsKey(player.getUniqueId())) {
			int slot = player.getInventory().getSize() - 6;
			player.getInventory().setItem(slot, storedItem.get(player.getUniqueId()));
			player.updateInventory();
			storedItem.remove(player.getUniqueId());
		}
	}

	@EventHandler
	public void PlayerInteractEvent(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		unlimitedArrow(p, e);
		customFood(p, e);
	}

	public void unlimitedArrow(Player p, PlayerInteractEvent e) {
		if (!p.getGameMode().equals(GameMode.CREATIVE) && p.hasPermission("c4p.unlimitedarrows")) {
			if (!(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)))
				return;
			if (storedItem.containsKey(p.getUniqueId()))
				return;
			if ((p.getInventory().getItemInMainHand().getType().equals(Material.BOW))
					|| (p.getInventory().getItemInOffHand().getType().equals(Material.BOW))) {
				int slot = p.getInventory().getSize() - 6;
				ItemStack item = p.getInventory().getItem(slot);
				storedItem.put(p.getUniqueId(), item);
				p.getInventory().setItem(slot, new ItemStack(Material.ARROW, 1));
			}
		}
	}

	public void customFood(Player player, PlayerInteractEvent event) {
		if ((player.getGameMode() != GameMode.CREATIVE) && (player.getGameMode() != GameMode.SPECTATOR)
				&& (event.getItem() != null) && (event.getItem().getType() != Material.AIR)
				&& (player.getFoodLevel() != 20)) {
			ItemStack item = event.getItem();
			Material material = item.getType();
			if (CustomItems.isCustomFood(item, material)) {
				//player.playSound(player.getLocation(), Sound.entitY_PLAYER, arg2, arg3);
				int CurrentTick = MinecraftServer.currentTick;
				UUID uuid = player.getUniqueId();
				if (!(EatingState.containsKey(uuid) && (EatingStateLastCheck.containsKey(uuid)))) {
					EatingState.put(uuid, CurrentTick);
					EatingStateLastCheck.put(uuid, CurrentTick);
				} else {
					if (EatingStateLastCheck.get(uuid) == CurrentTick - 4) {
						int TimePassed = EatingState.get(uuid) - CurrentTick;
						if (TimePassed == -28) {
							CustomItems.addFood(player, item, material);
							EatingState.remove(player.getUniqueId());
							EatingStateLastCheck.remove(player.getUniqueId());
							player.getInventory().remove(item);
						} else {
							EatingStateLastCheck.put(uuid, CurrentTick);
						}
					} else {
						if (EatingStateLastCheck.get(uuid) == CurrentTick)
							return;
						EatingState.put(uuid, CurrentTick);
						EatingStateLastCheck.put(uuid, CurrentTick);
					}
				}
			}
		}
	}

	// END OF CUSTOM FOOD

}

package com.craft4plus.custom.items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import static com.earth2me.essentials.I18n.tl;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Item;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Player;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import com.craft4plus.main.Main;
import com.craft4plus.miscellaneous.SlimeChunks;
import com.craft4plus.miscellaneous.TreeBreaker;
import com.craft4plus.utils.armorequip.ArmorEquipEvent;
import com.earth2me.essentials.CommandSource;
import com.earth2me.essentials.Mob;
import com.earth2me.essentials.Mob.MobException;
import com.earth2me.essentials.MobData;
import com.earth2me.essentials.SpawnMob;
import com.earth2me.essentials.User;
import com.earth2me.essentials.utils.LocationUtil;
import com.earth2me.essentials.utils.StringUtil;

import net.ess3.api.IEssentials;
import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_10_R1.MinecraftServer;

public class CustomItemsListener implements Listener {

	public static void tell(String string) {
		if (Bukkit.getPlayer("chrismin13").isOnline())
			Bukkit.getPlayer("chrismin13").sendMessage(ChatColor.AQUA + string);
	}

	@EventHandler
	public void onEntityDamage(EntityDamageByEntityEvent event) {
		if ((event.getEntity() instanceof Player)) {
			Player player = (Player) event.getEntity();
			CustomItemsActions.customItemCheck(player);
			if (!player.getInventory().getItemInMainHand().getType().equals(Material.AIR)) {
				ItemStack item = player.getInventory().getItemInMainHand();
				// DOUBLE AXES
				if (CustomItemsActions.isDoubleAxe(item)) 
					CustomItemsActions.reduceDurability(item, player, 2);
				// END STONE ITEMS
				if (CustomItemsActions.isEndStoneSword(item)) 
					CustomItemsActions.reduceDurability(item, player, 1);
				if (CustomItemsActions.isEndStoneItem(item)) 
					CustomItemsActions.reduceDurability(item, player, 2);
				// CHISELS
				if (CustomItemsActions.isChisel(item))
					CustomItemsActions.reduceDurability(item, player, 2);
			}

		}
	}

	@EventHandler
	public void onBlockBreakEvent(BlockBreakEvent event) {
		Player player = event.getPlayer();
		CustomItemsActions.customItemCheck(player);
		if (!player.getInventory().getItemInMainHand().getType().equals(Material.AIR)) {
			ItemStack item = player.getInventory().getItemInMainHand();
			Block block = event.getBlock();
			// DOUBLE AXES
			if (CustomItemsActions.isDoubleAxe(item)) {
				TreeBreaker.Chop(block, player);
				CustomItemsActions.reduceDurability(item, player, 1);
				return;
			}
			// SICKELS
			if (CustomItemsActions.isSickle(item)) {
				CustomItemsActions.reduceDurability(item, player,
						CustomItemsActions.breakSeedsInRadius(block, CustomItemsActions.getSickleBreakRadius(item)));
				player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_ATTACK_SWEEP, 1.0F, 1.0F);
				return;
			}
			// CHISELS
			if (CustomItemsActions.isChisel(item) && !event.isCancelled()) {
				event.setCancelled(true);
				CustomItemsActions.convertToChiseled(block);
				CustomItemsActions.reduceDurability(item, player, 1);
			}
		}
	}

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		CustomItemsActions.customItemCheck(event.getPlayer());
	}

	@EventHandler
	public void onArmorEquip(ArmorEquipEvent event) {
		Player player = event.getPlayer();
		if ((event.getNewArmorPiece() != null) && (!event.getNewArmorPiece().getType().equals(Material.AIR))) {
			ItemStack newArmorPiece = event.getNewArmorPiece();
			if (CustomItemsActions.isStoneArmor(newArmorPiece)) {
				player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 9999999, 1));
				return;
			}
			if (CustomItemsActions.isSlimeBoots(newArmorPiece)) {
				player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 9999999, 1));
				return;
			}
		} else {
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
				public void run() {
					if (!(CustomItemsActions.isStoneArmor(player.getInventory().getItem(39))
							|| CustomItemsActions.isStoneArmor(player.getInventory().getItem(38))
							|| CustomItemsActions.isStoneArmor(player.getInventory().getItem(37))
							|| CustomItemsActions.isStoneArmor(player.getInventory().getItem(36)))) {
						if (player.hasPotionEffect(PotionEffectType.SLOW)) {
							for (PotionEffect effect : player.getActivePotionEffects()) {
								if (effect.getType().equals(PotionEffectType.SLOW) && effect.getDuration() >= 1000
										&& effect.getAmplifier() == 1) {
									player.removePotionEffect(effect.getType());
								}
							}
						}
					}
					if (CustomItemsActions.isSlimeBoots(event.getOldArmorPiece())) {
						if (player.hasPotionEffect(PotionEffectType.JUMP)) {
							for (PotionEffect effect : player.getActivePotionEffects()) {
								if (effect.getType().equals(PotionEffectType.JUMP) && effect.getDuration() >= 1000
										&& effect.getAmplifier() == 1) {
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
		String world = p.getWorld().getName();
		if (!p.getGameMode().equals(GameMode.CREATIVE) && p.hasPermission("c4p.unlimitedarrows")
				&& ((world == "Survival") || (world == "Survival_nether") || (world == "Survival_the_end")
						|| (world == "FloatingIslands") || (world == "skyworld") || (world == "skyworld_nether"))) {
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
			if (CustomItemsActions.isCustomFood(item, material)) {
				int CurrentTick = MinecraftServer.currentTick;
				UUID uuid = player.getUniqueId();
				if (!(EatingState.containsKey(uuid) && (EatingStateLastCheck.containsKey(uuid)))) {
					EatingState.put(uuid, CurrentTick);
					EatingStateLastCheck.put(uuid, CurrentTick);
					CustomItemsActions.addEatingFoodEffects(player, 5, Material.GOLD_INGOT);
				} else {
					if (EatingStateLastCheck.get(uuid) == CurrentTick - 4) {
						int TimePassed = EatingState.get(uuid) - CurrentTick;
						if (TimePassed == -28) {
							CustomItemsActions.addFood(player, item, material);
							EatingState.remove(player.getUniqueId());
							EatingStateLastCheck.remove(player.getUniqueId());
							player.getInventory().remove(item);
							player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_BURP, 1.0F, 1.0F);
						} else {
							EatingStateLastCheck.put(uuid, CurrentTick);
							CustomItemsActions.addEatingFoodEffects(player, 5, Material.GOLD_BLOCK);
						}
					} else {
						if (EatingStateLastCheck.get(uuid) == CurrentTick)
							return;
						EatingState.put(uuid, CurrentTick);
						EatingStateLastCheck.put(uuid, CurrentTick);
						CustomItemsActions.addEatingFoodEffects(player, 5, Material.GOLD_INGOT);
					}
				}
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

	// === SUPER HOES === //

	@EventHandler
	public void onHoeBreak(BlockBreakEvent event) {
		if (event.getPlayer() == null)
			return;

		Player player = event.getPlayer();

		if (player.getGameMode() != GameMode.SURVIVAL)
			return;

		if (player.getInventory().getItemInMainHand() == null
				|| player.getInventory().getItemInMainHand().getType() == Material.AIR)
			return;

		ItemStack item = player.getInventory().getItemInMainHand();
		Material itemType = item.getType();
		Block block = event.getBlock();

		if (itemType == Material.DIAMOND_HOE) {
			CustomItemsActions.breakSeedsInRadius(block, 5);
		}
	}

	// === SLIME BUCKETS === //

	List<UUID> PlayersInSlimeChunks = new ArrayList<UUID>();

	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event) {
		Player player = event.getPlayer();
		UUID playeruuid = player.getUniqueId();
		if (SlimeChunks.isSlimeChunk(player.getLocation())) {
			if (!PlayersInSlimeChunks.contains(playeruuid)) {
				PlayersInSlimeChunks.add(playeruuid);
				Inventory inventory = player.getInventory();
				for (ItemStack item : inventory.getContents()) {
					if (CustomItemsActions.isSimpleSlimeBucket(item))
						item.setDurability((short) 1551);
				}
			}
		} else {
			if (PlayersInSlimeChunks.contains(playeruuid)) {
				PlayersInSlimeChunks.remove(playeruuid);
				Inventory inventory = player.getInventory();
				for (ItemStack item : inventory.getContents()) {
					if (CustomItemsActions.isHoppingSlimeBucket(item))
						item.setDurability((short) 1552);
				}
			}
		}
	}

	@EventHandler
	public void onItemDrop(PlayerDropItemEvent event) {
		Item item = event.getItemDrop();
		ItemStack itemstack = item.getItemStack();
		if (!CustomItemsActions.isSlimeBucket(itemstack))
			return;
		Player player = event.getPlayer();
		UUID playeruuid = player.getUniqueId();
		if (PlayersInSlimeChunks.contains(playeruuid))
			PlayersInSlimeChunks.remove(playeruuid);
		itemstack.setDurability((short) 1552);
		item.setItemStack(itemstack);
	}

	@EventHandler
	public void onItemPickup(PlayerPickupItemEvent event) {
		Item item = event.getItem();
		ItemStack itemstack = item.getItemStack();
		if (!CustomItemsActions.isSlimeBucket(itemstack))
			return;
		Player player = event.getPlayer();
		UUID playeruuid = player.getUniqueId();
		if (SlimeChunks.isSlimeChunk(player.getLocation())) {
			PlayersInSlimeChunks.add(playeruuid);
			for (ItemStack itemtochange : player.getInventory().getContents()) {
				if (CustomItemsActions.isSimpleSlimeBucket(itemtochange))
					itemtochange.setDurability((short) 1551);
			}
			itemstack.setDurability((short) 1551);
		} else {
			if (PlayersInSlimeChunks.contains(playeruuid))
				PlayersInSlimeChunks.remove(playeruuid);
			for (ItemStack itemtochange : player.getInventory().getContents()) {
				if (CustomItemsActions.isHoppingSlimeBucket(itemtochange))
					itemtochange.setDurability((short) 1552);
			}
			itemstack.setDurability((short) 1552);
		}
		item.setItemStack(itemstack);
	}

	@EventHandler
	public void onSlimeBucketMove(InventoryMoveItemEvent event) {
		ItemStack item = event.getItem();
		if (!CustomItemsActions.isSlimeBucket(item))
			return;
		item.setDurability((short) 1552);
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onBucketSlimeClick(PlayerInteractEntityEvent event) {
		Entity entity = event.getRightClicked();
		Player player = event.getPlayer();
		PlayerInventory inventory = player.getInventory();
		ItemStack item = null;
		UUID playeruuid = player.getUniqueId();
		if (entity instanceof Slime) {
			if (entity.isDead())
				return;
			Slime slime = (Slime) entity;
			if (slime.getSize() != 1)
				return;
			if (inventory.getItemInMainHand().getType().equals(Material.BUCKET)) {
				item = inventory.getItemInMainHand();
				int amount = item.getAmount() - 1;
				item.setAmount(amount);
				inventory.setItemInMainHand(item);
			} else if (inventory.getItemInOffHand().getType().equals(Material.BUCKET)) {
				item = inventory.getItemInOffHand();
				int amount = item.getAmount() - 1;
				item.setAmount(amount);
				inventory.setItemInOffHand(item);
			}
			if (SlimeChunks.isSlimeChunk(player.getLocation())) {
				PlayersInSlimeChunks.add(playeruuid);
				player.getInventory().addItem(CustomItemStack.HOPPING_SLIME_BUCKET);
			} else {
				if (PlayersInSlimeChunks.contains(playeruuid))
					PlayersInSlimeChunks.remove(playeruuid);
				player.getInventory().addItem(CustomItemStack.SLIME_BUCKET);
			}
			event.getRightClicked().remove();
		} else if (entity instanceof ItemFrame) {
			ItemFrame itemframe = (ItemFrame) entity;
			if (itemframe.getItem().getType() != Material.AIR)
				return;
			if (CustomItemsActions.isSlimeBucket(inventory.getItemInMainHand())) {
				PlayersInSlimeChunks.remove(playeruuid);
				inventory.getItemInMainHand().setDurability((short) 1552);
			} else if (CustomItemsActions.isSlimeBucket(inventory.getItemInOffHand())) {
				PlayersInSlimeChunks.remove(playeruuid);
				inventory.getItemInOffHand().setDurability((short) 1552);
			}
		}
	}

	@EventHandler
	public void onInventoryChange(InventoryClickEvent event) {
		if (event.getView().getTopInventory() == null)
			return;
		Inventory inventory = event.getInventory();
		ItemStack item = event.getCurrentItem();
		if (inventory.getHolder().toString().contains("CraftPlayer")) {
			if (CustomItemsActions.isSlimeBucket(item)) {
				if (CustomItemsActions.isSlimeBucket(item)) {
					if (SlimeChunks.isSlimeChunk(event.getWhoClicked().getLocation())) {
						item.setDurability((short) 1551);
					} else {
						item.setDurability((short) 1552);
					}
				}
			}
		} else {
			if (CustomItemsActions.isSlimeBucket(item)) {
				item.setDurability((short) 1552);
				PlayersInSlimeChunks.remove(event.getWhoClicked().getUniqueId());
			}
		}
	}

	static List<Material> interactables = Arrays.asList(Material.ACACIA_DOOR, Material.ACACIA_FENCE_GATE,
			Material.ANVIL, Material.BEACON, Material.BED, Material.BIRCH_DOOR, Material.BIRCH_FENCE_GATE,
			Material.BOAT, Material.BOAT_ACACIA, Material.BOAT_BIRCH, Material.BOAT_DARK_OAK, Material.BOAT_JUNGLE,
			Material.BOAT_SPRUCE, Material.BREWING_STAND, Material.COMMAND, Material.CHEST, Material.DARK_OAK_DOOR,
			Material.DARK_OAK_FENCE_GATE, Material.DAYLIGHT_DETECTOR, Material.DAYLIGHT_DETECTOR_INVERTED,
			Material.DISPENSER, Material.DROPPER, Material.ENCHANTMENT_TABLE, Material.ENDER_CHEST, Material.FENCE_GATE,
			Material.FURNACE, Material.HOPPER, Material.HOPPER_MINECART, Material.ITEM_FRAME, Material.JUNGLE_DOOR,
			Material.JUNGLE_FENCE_GATE, Material.LEVER, Material.MINECART, Material.NOTE_BLOCK,
			Material.POWERED_MINECART, Material.REDSTONE_COMPARATOR, Material.REDSTONE_COMPARATOR_OFF,
			Material.REDSTONE_COMPARATOR_ON, Material.SIGN, Material.SIGN_POST, Material.STORAGE_MINECART,
			Material.TRAP_DOOR, Material.TRAPPED_CHEST, Material.WALL_SIGN, Material.WOOD_BUTTON, Material.WOOD_DOOR,
			Material.WORKBENCH);

	@EventHandler
	public void onSlimeBucketBlockClick(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		PlayerInventory inventory = player.getInventory();
		ItemStack item = null;
		if (CustomItemsActions.isSlimeBucket(inventory.getItemInMainHand())) {
			item = inventory.getItemInMainHand();
		} else if (CustomItemsActions.isSlimeBucket(inventory.getItemInOffHand())) {
			item = inventory.getItemInOffHand();
		} else
			return;

		if (event.getAction() == Action.RIGHT_CLICK_BLOCK
				&& !interactables.contains(event.getClickedBlock().getType())) {
			if (event.getClickedBlock() == null)
				return;
			List<String> mobParts = SpawnMob.mobParts("slime:1");
			List<String> mobData = SpawnMob.mobData("slime:1");

			int mobCount = 1;

			try {
				spawnmob(Main.ess, Main.instance.getServer(), Main.ess.getUser(player), mobParts, mobData, mobCount);
			} catch (Exception e) {
				tell("Failed to spawn slime of user " + player.getName());
				e.printStackTrace();
			}
			item.setType(Material.BUCKET);
			item.setDurability((short) 0);
			ItemStackUtilities.setName(item, "Bucket");
		} else if (event.getClickedBlock() != null && event.getClickedBlock().equals(Material.ITEM_FRAME)) {
			item.setDurability((short) 1552);
		}
	}

	@EventHandler
	public void onTeleportWithSlimeBucket(PlayerTeleportEvent event) {
		Player player = event.getPlayer();
		UUID playeruuid = player.getUniqueId();
		if (SlimeChunks.isSlimeChunk(player.getLocation())) {
			if (!PlayersInSlimeChunks.contains(playeruuid)) {
				PlayersInSlimeChunks.add(playeruuid);
				Inventory inventory = player.getInventory();
				for (ItemStack item : inventory.getContents()) {
					if (CustomItemsActions.isSimpleSlimeBucket(item))
						item.setDurability((short) 1551);
				}
			}
		} else {
			if (PlayersInSlimeChunks.contains(playeruuid)) {
				PlayersInSlimeChunks.remove(playeruuid);
				Inventory inventory = player.getInventory();
				for (ItemStack item : inventory.getContents()) {
					if (CustomItemsActions.isHoppingSlimeBucket(item))
						item.setDurability((short) 1552);
				}
			}
		}
	}

	@EventHandler
	public void onItemCraft(CraftItemEvent event) {
		ItemStack item = event.getCurrentItem();
		if (CustomItemsActions.isSlimeBucket(item)) {
			PlayersInSlimeChunks.remove(event.getWhoClicked().getUniqueId());
		}
	}

	/*
	 * ALL CODE IS FROM THE ESSENTIALS GITHUB REPO
	 * 
	 * SMALL CHANGES HAVE BEEN MADE
	 */
	// This method spawns a mob where the user is looking, owned by user
	public static void spawnmob(final IEssentials ess, final Server server, final User user, final List<String> parts,
			final List<String> data, int mobCount) throws Exception {
		final Block block = LocationUtil.getTarget(user.getBase()).getBlock();
		if (block == null) {
			throw new Exception(tl("unableToSpawnMob"));
		}
		spawnmob(ess, server, user.getSource(), user, block.getLocation(), parts, data, mobCount);
	}

	// This method spawns a mob at target, owned by target
	public static void spawnmob(final IEssentials ess, final Server server, final CommandSource sender,
			final User target, final List<String> parts, final List<String> data, int mobCount) throws Exception {
		spawnmob(ess, server, sender, target, target.getLocation(), parts, data, mobCount);
	}

	// This method spawns a mob at loc, owned by target
	public static void spawnmob(final IEssentials ess, final Server server, final CommandSource sender,
			final User target, final Location loc, final List<String> parts, final List<String> data, int mobCount)
			throws Exception {
		final Location sloc = LocationUtil.getSafeDestination(loc);

		for (int i = 0; i < parts.size(); i++) {
			Mob mob = Mob.fromName(parts.get(i));
			checkSpawnable(ess, sender, mob);
		}

		final int serverLimit = ess.getSettings().getSpawnMobLimit();
		int effectiveLimit = serverLimit / parts.size();

		if (effectiveLimit < 1) {
			effectiveLimit = 1;
			while (parts.size() > serverLimit) {
				parts.remove(serverLimit);
			}
		}

		if (mobCount > effectiveLimit) {
			mobCount = effectiveLimit;
			sender.sendMessage(tl("mobSpawnLimit"));
		}

		try {
			for (int i = 0; i < mobCount; i++) {
				spawnMob(ess, server, sender, target, sloc, parts, data);
			}
		} catch (MobException e1) {
			throw new Exception(tl("unableToSpawnMob"), e1);
		} catch (NumberFormatException e2) {
			throw new Exception(tl("numberRequired"), e2);
		} catch (NullPointerException np) {
			throw new Exception(tl("soloMob"), np);
		}
	}

	private static void spawnMob(final IEssentials ess, final Server server, final CommandSource sender,
			final User target, final Location sloc, List<String> parts, List<String> data) throws Exception {
		Mob mob;
		Entity spawnedMob = null;
		Entity spawnedMount;

		for (int i = 0; i < parts.size(); i++) {
			if (i == 0) {
				mob = Mob.fromName(parts.get(i));
				spawnedMob = mob.spawn(sloc.getWorld(), server, sloc);
				defaultMobData(mob.getType(), spawnedMob);

				if (data.get(i) != null) {
					changeMobData(sender, mob.getType(), spawnedMob, data.get(i).toLowerCase(Locale.ENGLISH), target);
				}
			}

			int next = (i + 1);
			if (next < parts.size()) // If it's the last mob in the list, don't
										// set the mount
			{
				Mob mMob = Mob.fromName(parts.get(next));
				spawnedMount = mMob.spawn(sloc.getWorld(), server, sloc);
				defaultMobData(mMob.getType(), spawnedMount);

				if (data.get(next) != null) {
					changeMobData(sender, mMob.getType(), spawnedMount, data.get(next).toLowerCase(Locale.ENGLISH),
							target);
				}

				spawnedMob.setPassenger(spawnedMount);

				spawnedMob = spawnedMount;
			}
		}
	}

	private static void checkSpawnable(IEssentials ess, CommandSource sender, Mob mob) throws Exception {
		if (mob == null) {
			throw new Exception(tl("invalidMob"));
		}

		if (ess.getSettings().getProtectPreventSpawn(mob.getType().toString().toLowerCase(Locale.ENGLISH))) {
			throw new Exception(tl("disabledToSpawnMob"));
		}

		if (sender.isPlayer() && !ess.getUser(sender.getPlayer())
				.isAuthorized("essentials.spawnmob." + mob.name.toLowerCase(Locale.ENGLISH))) {
			throw new Exception(tl("noPermToSpawnMob"));
		}
	}

	@SuppressWarnings("deprecation")
	private static void defaultMobData(final EntityType type, final Entity spawned) {
		if (type == EntityType.SKELETON) {
			final EntityEquipment invent = ((LivingEntity) spawned).getEquipment();
			invent.setItemInHand(new ItemStack(Material.BOW, 1));
			invent.setItemInHandDropChance(0.1f);

			invent.setBoots(new ItemStack(Material.GOLD_BOOTS, 1));
			invent.setBootsDropChance(0.0f);
		}

		if (type == EntityType.PIG_ZOMBIE) {
			final PigZombie zombie = ((PigZombie) spawned);
			zombie.setVillager(false);

			final EntityEquipment invent = zombie.getEquipment();
			invent.setItemInHand(new ItemStack(Material.GOLD_SWORD, 1));
			invent.setItemInHandDropChance(0.1f);

			invent.setBoots(new ItemStack(Material.GOLD_BOOTS, 1));
			invent.setBootsDropChance(0.0f);
		}

		if (type == EntityType.ZOMBIE) {
			final Zombie zombie = ((Zombie) spawned);
			zombie.setVillager(false);

			final EntityEquipment invent = zombie.getEquipment();
			invent.setBoots(new ItemStack(Material.GOLD_BOOTS, 1));
			invent.setBootsDropChance(0.0f);
		}
	}

	private static void changeMobData(final CommandSource sender, final EntityType type, final Entity spawned,
			final String inputData, final User target) throws Exception {
		String data = inputData;

		if (data.isEmpty()) {
			sender.sendMessage(tl("mobDataList", StringUtil.joinList(MobData.getValidHelp(spawned))));
		}

		if (spawned instanceof Zombie) {
			((Zombie) spawned).setBaby(false);
		}

		if (spawned instanceof Zombie || type == EntityType.SKELETON) {
			if (inputData.contains("armor") || inputData.contains("armour")) {
				final EntityEquipment invent = ((LivingEntity) spawned).getEquipment();
				if (inputData.contains("noarmor") || inputData.contains("noarmour")) {
					invent.clear();
				} else if (inputData.contains("diamond")) {
					invent.setBoots(new ItemStack(Material.DIAMOND_BOOTS, 1));
					invent.setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS, 1));
					invent.setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE, 1));
					invent.setHelmet(new ItemStack(Material.DIAMOND_HELMET, 1));
				} else if (inputData.contains("gold")) {
					invent.setBoots(new ItemStack(Material.GOLD_BOOTS, 1));
					invent.setLeggings(new ItemStack(Material.GOLD_LEGGINGS, 1));
					invent.setChestplate(new ItemStack(Material.GOLD_CHESTPLATE, 1));
					invent.setHelmet(new ItemStack(Material.GOLD_HELMET, 1));
				} else if (inputData.contains("leather")) {
					invent.setBoots(new ItemStack(Material.LEATHER_BOOTS, 1));
					invent.setLeggings(new ItemStack(Material.LEATHER_LEGGINGS, 1));
					invent.setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE, 1));
					invent.setHelmet(new ItemStack(Material.LEATHER_HELMET, 1));
				} else {
					invent.setBoots(new ItemStack(Material.IRON_BOOTS, 1));
					invent.setLeggings(new ItemStack(Material.IRON_LEGGINGS, 1));
					invent.setChestplate(new ItemStack(Material.IRON_CHESTPLATE, 1));
					invent.setHelmet(new ItemStack(Material.IRON_HELMET, 1));
				}
				invent.setBootsDropChance(0f);
				invent.setLeggingsDropChance(0f);
				invent.setChestplateDropChance(0f);
				invent.setHelmetDropChance(0f);
			}

		}

		MobData newData = MobData.fromData(spawned, data);
		while (newData != null) {
			newData.setData(spawned, target.getBase(), data);
			data = data.replace(newData.getMatched(), "");
			newData = MobData.fromData(spawned, data);
		}
	}			
}

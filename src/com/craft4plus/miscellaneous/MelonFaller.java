package com.craft4plus.miscellaneous;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.FallingBlock;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.inventory.ItemStack;

import com.craft4plus.main.Main;

public class MelonFaller implements Listener {
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onMelonPlace (BlockPlaceEvent event) {
		
		if ((event.getBlock().getType().equals(Material.MELON_BLOCK)) && (event.getBlock().getLocation().subtract(0, 1, 0).getBlock().getType().equals(Material.AIR))) {
			Block block = event.getBlock();
			
			block.setType(Material.AIR);
			
			block.getWorld().spawnFallingBlock(block.getLocation().subtract(-0.5, 0, -0.5), Material.MELON_BLOCK, (byte) 0);
		}
		
	}

	@EventHandler
	public void onMelonTouchdown(EntityChangeBlockEvent event) {
		if (((FallingBlock) event.getEntity()).getMaterial() == Material.MELON_BLOCK) {
			event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(),
					new ItemStack(Material.MELON));
			event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(),
					new ItemStack(Material.MELON));
			event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(),
					new ItemStack(Material.MELON));
			event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(),
					new ItemStack(Material.MELON));
			event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(),
					new ItemStack(Material.MELON));
			
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() { //Schedule a repeating task
				@Override
				public void run() {
				event.getBlock().getLocation().getBlock().setType(Material.AIR);
				}
			}, 1L);
		
		}
	}

}
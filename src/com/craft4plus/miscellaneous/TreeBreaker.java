package com.craft4plus.miscellaneous;

import java.util.LinkedList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class TreeBreaker {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static boolean Chop(Block block, Player player, World world) {
		List<Block> blocks = new LinkedList();
		Block highest = getHighestLog(block);
		if (isTree(highest, player, block)) {
			getBlocksToChop(block, highest, blocks);
			popLogs(block, blocks, world, player);
			return true;
		}
		return false;
	}

	@SuppressWarnings("deprecation")
	public static void getBlocksToChop(Block block, Block highest, List<Block> blocks) {
		while (block.getY() <= highest.getY()) {
			if (!blocks.contains(block)) {
				blocks.add(block);
			}
			getBranches(block, blocks, block.getRelative(BlockFace.NORTH));
			getBranches(block, blocks, block.getRelative(BlockFace.NORTH_EAST));
			getBranches(block, blocks, block.getRelative(BlockFace.EAST));
			getBranches(block, blocks, block.getRelative(BlockFace.SOUTH_EAST));
			getBranches(block, blocks, block.getRelative(BlockFace.SOUTH));
			getBranches(block, blocks, block.getRelative(BlockFace.SOUTH_WEST));
			getBranches(block, blocks, block.getRelative(BlockFace.WEST));
			getBranches(block, blocks, block.getRelative(BlockFace.NORTH_WEST));
			if (!blocks.contains(block.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH))) {
				getBranches(block, blocks, block.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH));
			}
			if (!blocks.contains(block.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH_EAST))) {
				getBranches(block, blocks, block.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH_EAST));
			}
			if (!blocks.contains(block.getRelative(BlockFace.UP).getRelative(BlockFace.EAST))) {
				getBranches(block, blocks, block.getRelative(BlockFace.UP).getRelative(BlockFace.EAST));
			}
			if (!blocks.contains(block.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH_EAST))) {
				getBranches(block, blocks, block.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH_EAST));
			}
			if (!blocks.contains(block.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH))) {
				getBranches(block, blocks, block.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH));
			}
			if (!blocks.contains(block.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH_WEST))) {
				getBranches(block, blocks, block.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH_WEST));
			}
			if (!blocks.contains(block.getRelative(BlockFace.UP).getRelative(BlockFace.WEST))) {
				getBranches(block, blocks, block.getRelative(BlockFace.UP).getRelative(BlockFace.WEST));
			}
			if (!blocks.contains(block.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH_WEST))) {
				getBranches(block, blocks, block.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH_WEST));
			}
			if ((block.getData() == 3) || (block.getData() == 7) || (block.getData() == 11)
					|| (block.getData() == 15)) {
				if (!blocks.contains(block.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH, 2))) {
					getBranches(block, blocks, block.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH, 2));
				}
				if (!blocks.contains(block.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH_EAST, 2))) {
					getBranches(block, blocks, block.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH_EAST, 2));
				}
				if (!blocks.contains(block.getRelative(BlockFace.UP).getRelative(BlockFace.EAST, 2))) {
					getBranches(block, blocks, block.getRelative(BlockFace.UP).getRelative(BlockFace.EAST, 2));
				}
				if (!blocks.contains(block.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH_EAST, 2))) {
					getBranches(block, blocks, block.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH_EAST, 2));
				}
				if (!blocks.contains(block.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH, 2))) {
					getBranches(block, blocks, block.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH, 2));
				}
				if (!blocks.contains(block.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH_WEST, 2))) {
					getBranches(block, blocks, block.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH_WEST, 2));
				}
				if (!blocks.contains(block.getRelative(BlockFace.UP).getRelative(BlockFace.WEST, 2))) {
					getBranches(block, blocks, block.getRelative(BlockFace.UP).getRelative(BlockFace.WEST, 2));
				}
				if (!blocks.contains(block.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH_WEST, 2))) {
					getBranches(block, blocks, block.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH_WEST, 2));
				}
			}
			if (((blocks.contains(block.getRelative(BlockFace.UP)))
					|| (block.getRelative(BlockFace.UP).getType() != Material.LOG))
					&& (block.getRelative(BlockFace.UP).getType() != Material.LOG_2)) {
				break;
			}
			block = block.getRelative(BlockFace.UP);
		}
	}

	public static void getBranches(Block block, List<Block> blocks, Block other) {
		if ((!blocks.contains(other)) && ((other.getType() == Material.LOG) || (other.getType() == Material.LOG_2))) {
			getBlocksToChop(other, getHighestLog(other), blocks);
		}
	}

	public static Block getHighestLog(Block block) {
		boolean isLog = true;
		while (isLog) {
			if ((block.getRelative(BlockFace.UP).getType().equals(Material.LOG))
					|| (block.getRelative(BlockFace.UP).getType().equals(Material.LOG_2))
					|| (block.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH).getType().equals(Material.LOG))
					|| (block.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH).getType().equals(Material.LOG_2))
					|| (block.getRelative(BlockFace.UP).getRelative(BlockFace.EAST).getType().equals(Material.LOG))
					|| (block.getRelative(BlockFace.UP).getRelative(BlockFace.EAST).getType().equals(Material.LOG_2))
					|| (block.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH).getType().equals(Material.LOG))
					|| (block.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH).getType().equals(Material.LOG_2))
					|| (block.getRelative(BlockFace.UP).getRelative(BlockFace.WEST).getType().equals(Material.LOG))
					|| (block.getRelative(BlockFace.UP).getRelative(BlockFace.WEST).getType().equals(Material.LOG_2))
					|| (block.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH_EAST).getType()
							.equals(Material.LOG))
					|| (block.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH_EAST).getType()
							.equals(Material.LOG_2))
					|| (block.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH_WEST).getType()
							.equals(Material.LOG))
					|| (block.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH_WEST).getType()
							.equals(Material.LOG_2))
					|| (block.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH_EAST).getType()
							.equals(Material.LOG))
					|| (block.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH_EAST).getType()
							.equals(Material.LOG_2))
					|| (block.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH_WEST).getType()
							.equals(Material.LOG))
					|| (block.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH_WEST).getType()
							.equals(Material.LOG_2))) {
				if ((block.getRelative(BlockFace.UP).getType().equals(Material.LOG))
						|| (block.getRelative(BlockFace.UP).getType().equals(Material.LOG_2))) {
					block = block.getRelative(BlockFace.UP);
				} else if ((block.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH).getType().equals(Material.LOG))
						|| (block.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH).getType()
								.equals(Material.LOG_2))) {
					block = block.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH);
				} else if ((block.getRelative(BlockFace.UP).getRelative(BlockFace.EAST).getType().equals(Material.LOG))
						|| (block.getRelative(BlockFace.UP).getRelative(BlockFace.EAST).getType()
								.equals(Material.LOG_2))) {
					block = block.getRelative(BlockFace.UP).getRelative(BlockFace.EAST);
				} else if ((block.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH).getType().equals(Material.LOG))
						|| (block.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH).getType()
								.equals(Material.LOG_2))) {
					block = block.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH);
				} else if ((block.getRelative(BlockFace.UP).getRelative(BlockFace.WEST).getType().equals(Material.LOG))
						|| (block.getRelative(BlockFace.UP).getRelative(BlockFace.WEST).getType()
								.equals(Material.LOG_2))) {
					block = block.getRelative(BlockFace.UP).getRelative(BlockFace.WEST);
				} else if ((block.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH_EAST).getType()
						.equals(Material.LOG))
						|| (block.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH_EAST).getType()
								.equals(Material.LOG_2))) {
					block = block.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH_EAST);
				} else if ((block.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH_WEST).getType()
						.equals(Material.LOG))
						|| (block.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH_WEST).getType()
								.equals(Material.LOG_2))) {
					block = block.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH_WEST);
				} else if ((block.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH_EAST).getType()
						.equals(Material.LOG))
						|| (block.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH_EAST).getType()
								.equals(Material.LOG_2))) {
					block = block.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH_EAST);
				} else if ((block.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH_WEST).getType()
						.equals(Material.LOG))
						|| (block.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH_WEST).getType()
								.equals(Material.LOG_2))) {
					block = block.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH_WEST);
				}
			} else {
				isLog = false;
			}
		}
		return block;
	}

	@SuppressWarnings("deprecation")
	public static boolean isTree(Block block, Player player, Block first) {
		int counter = 0;
		if ((block.getRelative(BlockFace.UP).getType() == Material.LEAVES)
				|| (block.getRelative(BlockFace.UP).getType() == Material.LEAVES_2)) {
			counter++;
		}
		if ((block.getRelative(BlockFace.UP).getRelative(BlockFace.UP).getType() == Material.LEAVES)
				|| (block.getRelative(BlockFace.UP).getRelative(BlockFace.UP).getType() == Material.LEAVES_2)) {
			counter++;
		}
		if ((block.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH).getType() == Material.LEAVES)
				|| (block.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH).getType() == Material.LEAVES_2)) {
			counter++;
		}
		if ((block.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH).getType() == Material.LEAVES)
				|| (block.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH).getType() == Material.LEAVES_2)) {
			counter++;
		}
		if ((block.getRelative(BlockFace.UP).getRelative(BlockFace.EAST).getType() == Material.LEAVES)
				|| (block.getRelative(BlockFace.UP).getRelative(BlockFace.EAST).getType() == Material.LEAVES_2)) {
			counter++;
		}
		if ((block.getRelative(BlockFace.UP).getRelative(BlockFace.WEST).getType() == Material.LEAVES)
				|| (block.getRelative(BlockFace.UP).getRelative(BlockFace.WEST).getType() == Material.LEAVES_2)) {
			counter++;
		}
		if ((block.getRelative(BlockFace.DOWN).getType() == Material.LEAVES)
				|| (block.getRelative(BlockFace.DOWN).getType() == Material.LEAVES_2)) {
			counter++;
		}
		if ((block.getRelative(BlockFace.NORTH).getType() == Material.LEAVES)
				|| (block.getRelative(BlockFace.NORTH).getType() == Material.LEAVES_2)) {
			counter++;
		}
		if ((block.getRelative(BlockFace.EAST).getType() == Material.LEAVES)
				|| (block.getRelative(BlockFace.EAST).getType() == Material.LEAVES_2)) {
			counter++;
		}
		if ((block.getRelative(BlockFace.SOUTH).getType() == Material.LEAVES)
				|| (block.getRelative(BlockFace.SOUTH).getType() == Material.LEAVES_2)) {
			counter++;
		}
		if ((block.getRelative(BlockFace.WEST).getType() == Material.LEAVES)
				|| (block.getRelative(BlockFace.WEST).getType() == Material.LEAVES_2)) {
			counter++;
		}
		if (counter >= 2) {
			return true;
		}
		if (block.getData() == 1) {
			block = block.getRelative(BlockFace.UP);
			if ((block.getRelative(BlockFace.UP).getType() == Material.LEAVES)
					|| (block.getRelative(BlockFace.UP).getType() == Material.LEAVES_2)) {
				counter++;
			}
			if ((block.getRelative(BlockFace.UP).getRelative(BlockFace.UP).getType() == Material.LEAVES)
					|| (block.getRelative(BlockFace.UP).getRelative(BlockFace.UP).getType() == Material.LEAVES_2)) {
				counter++;
			}
			if ((block.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH).getType() == Material.LEAVES)
					|| (block.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH).getType() == Material.LEAVES_2)) {
				counter++;
			}
			if ((block.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH).getType() == Material.LEAVES)
					|| (block.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH).getType() == Material.LEAVES_2)) {
				counter++;
			}
			if ((block.getRelative(BlockFace.UP).getRelative(BlockFace.EAST).getType() == Material.LEAVES)
					|| (block.getRelative(BlockFace.UP).getRelative(BlockFace.EAST).getType() == Material.LEAVES_2)) {
				counter++;
			}
			if ((block.getRelative(BlockFace.UP).getRelative(BlockFace.WEST).getType() == Material.LEAVES)
					|| (block.getRelative(BlockFace.UP).getRelative(BlockFace.WEST).getType() == Material.LEAVES_2)) {
				counter++;
			}
			if ((block.getRelative(BlockFace.NORTH).getType() == Material.LEAVES)
					|| (block.getRelative(BlockFace.NORTH).getType() == Material.LEAVES_2)) {
				counter++;
			}
			if ((block.getRelative(BlockFace.EAST).getType() == Material.LEAVES)
					|| (block.getRelative(BlockFace.EAST).getType() == Material.LEAVES_2)) {
				counter++;
			}
			if ((block.getRelative(BlockFace.SOUTH).getType() == Material.LEAVES)
					|| (block.getRelative(BlockFace.SOUTH).getType() == Material.LEAVES_2)) {
				counter++;
			}
			if ((block.getRelative(BlockFace.WEST).getType() == Material.LEAVES)
					|| (block.getRelative(BlockFace.WEST).getType() == Material.LEAVES_2)) {
				counter++;
			}
			if (counter >= 2) {
				return true;
			}
		}
		return false;
	}

	@SuppressWarnings("deprecation")
	public static void popLogs(Block block, List<Block> blocks, World world, Player player) {
		ItemStack item = new ItemStack(1, 1, (short) 0, null);
		item.setAmount(1);
		for (int counter = 0; counter < blocks.size(); counter++) {
			block = (Block) blocks.get(counter);
			item.setType(block.getType());
			item.setDurability((short) block.getData());
			block.breakNaturally();
			popLeaves(block);
		}
	}

	public static void popLeaves(Block block) {
		for (int y = -3; y < 3 + 1; y++) {
			for (int x = -3; x < 3 + 1; x++) {
				for (int z = -3; z < 3 + 1; z++) {
					Block target = block.getRelative(x, y, z);
					if ((target.getType().equals(Material.LEAVES)) || (target.getType().equals(Material.LEAVES_2))) {
						target.breakNaturally();
					}
				}
			}
		}
	}

	public boolean isLoneLog(Block block) {
		if ((block.getRelative(BlockFace.UP).getType() == Material.LOG)
				|| (block.getRelative(BlockFace.UP).getType() == Material.LOG_2)) {
			return false;
		}
		if (block.getRelative(BlockFace.DOWN).getType() != Material.AIR) {
			return false;
		}
		if (hasHorizontalCompany(block)) {
			return false;
		}
		if (hasHorizontalCompany(block.getRelative(BlockFace.UP))) {
			return false;
		}
		if (hasHorizontalCompany(block.getRelative(BlockFace.DOWN))) {
			return false;
		}
		return true;
	}

	public boolean hasHorizontalCompany(Block block) {
		if ((block.getRelative(BlockFace.NORTH).getType() == Material.LOG)
				|| (block.getRelative(BlockFace.NORTH).getType() == Material.LOG_2)) {
			return true;
		}
		if ((block.getRelative(BlockFace.NORTH_EAST).getType() == Material.LOG)
				|| (block.getRelative(BlockFace.NORTH_EAST).getType() == Material.LOG_2)) {
			return true;
		}
		if ((block.getRelative(BlockFace.EAST).getType() == Material.LOG)
				|| (block.getRelative(BlockFace.EAST).getType() == Material.LOG_2)) {
			return true;
		}
		if ((block.getRelative(BlockFace.SOUTH_EAST).getType() == Material.LOG)
				|| (block.getRelative(BlockFace.SOUTH_EAST).getType() == Material.LOG_2)) {
			return true;
		}
		if ((block.getRelative(BlockFace.SOUTH).getType() == Material.LOG)
				|| (block.getRelative(BlockFace.SOUTH).getType() == Material.LOG_2)) {
			return true;
		}
		if ((block.getRelative(BlockFace.SOUTH_WEST).getType() == Material.LOG)
				|| (block.getRelative(BlockFace.SOUTH_WEST).getType() == Material.LOG_2)) {
			return true;
		}
		if ((block.getRelative(BlockFace.WEST).getType() == Material.LOG)
				|| (block.getRelative(BlockFace.WEST).getType() == Material.LOG_2)) {
			return true;
		}
		if ((block.getRelative(BlockFace.NORTH_WEST).getType() == Material.LOG)
				|| (block.getRelative(BlockFace.NORTH_WEST).getType() == Material.LOG_2)) {
			return true;
		}
		return false;
	}

}

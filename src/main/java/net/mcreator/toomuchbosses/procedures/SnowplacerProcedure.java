package net.mcreator.toomuchbosses.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.toomuchbosses.init.TooMuchBossesModBlocks;

public class SnowplacerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (Blocks.AIR == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
			world.setBlock(BlockPos.containing(x, y, z), TooMuchBossesModBlocks.WARLOCKS_SNOW.get().defaultBlockState(), 3);
		}
	}
}

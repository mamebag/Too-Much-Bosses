package net.mcreator.toomuchbosses.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.toomuchbosses.init.TooMuchBossesModBlocks;

public class IceplacerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		Entity warlock = null;
		double Zknockback = 0;
		double Yknockback = 0;
		double Xknockback = 0;
		double dis = 0;
		if ((world.getBlockState(BlockPos.containing(x + 0, y + 0, z + 0))).getBlock() == Blocks.AIR) {
			world.setBlock(BlockPos.containing(x, y, z), TooMuchBossesModBlocks.WARLOCKS_ICE.get().defaultBlockState(), 3);
		}
	}
}

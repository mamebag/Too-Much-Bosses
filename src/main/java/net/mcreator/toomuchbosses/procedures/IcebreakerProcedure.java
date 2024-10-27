package net.mcreator.toomuchbosses.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.toomuchbosses.init.TooMuchBossesModBlocks;

public class IcebreakerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		Entity warlock = null;
		double Zknockback = 0;
		double Yknockback = 0;
		double Xknockback = 0;
		double dis = 0;
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == TooMuchBossesModBlocks.WARLOCKS_ICE.get()) {
			world.destroyBlock(BlockPos.containing(x, y, z), false);
		}
	}
}

package net.mcreator.toomuchbosses.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class IcelastProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		if (!immediatesourceentity.level().isClientSide())
			immediatesourceentity.discard();
		IceplacerProcedure.execute(world, x, y, z);
		IceplacerProcedure.execute(world, x, (y + 1), z);
		IceplacerProcedure.execute(world, x, (y + -1), z);
		IceplacerProcedure.execute(world, (x + 1), (y + 0), (z + 1));
		IceplacerProcedure.execute(world, (x + -1), (y + 0), (z + -1));
		IceplacerProcedure.execute(world, (x + 1), (y + 0), (z + -1));
		IceplacerProcedure.execute(world, (x + -1), (y + 0), (z + 1));
	}
}

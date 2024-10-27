package net.mcreator.toomuchbosses.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class FreezeEnemyProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, double width, double height) {
		double xx = 0;
		double zz = 0;
		double layerNum = 0;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		boolean found = false;
		boolean thereisaliving = false;
		if (entity instanceof LivingEntity) {
			IceplacerProcedure.execute(world, (x + 0), (y + 0), (z + 0));
			IceplacerProcedure.execute(world, (x + 0), (y + -1), (z + 0));
			for (int index0 = 0; index0 < 1; index0++) {
				IceplacerProcedure.execute(world, (x + 1), (y + -1), (z + 0));
				IceplacerProcedure.execute(world, (x + 1), (y + -1), (z + 0));
				IceplacerProcedure.execute(world, (x + 0), (y + -1), (z + 1));
				IceplacerProcedure.execute(world, (x + -1), (y + -1), (z + 0));
				IceplacerProcedure.execute(world, (x + 1), (y + -1), (z + 1));
				IceplacerProcedure.execute(world, (x + -1), (y + -1), (z + -1));
				IceplacerProcedure.execute(world, (x + 1), (y + -1), (z + -1));
				IceplacerProcedure.execute(world, (x + -1), (y + -1), (z + 1));
			}
			for (int index1 = 0; index1 < 1; index1++) {
				IceplacerProcedure.execute(world, (x + 1), (y + 0), (z + 0));
				IceplacerProcedure.execute(world, (x + 0), (y + 0), (z + -1));
				IceplacerProcedure.execute(world, (x + 0), (y + 0), (z + 1));
				IceplacerProcedure.execute(world, (x + -1), (y + 0), (z + 0));
				IceplacerProcedure.execute(world, (x + 1), (y + 0), (z + 1));
				IceplacerProcedure.execute(world, (x + -1), (y + 0), (z + -1));
				IceplacerProcedure.execute(world, (x + 1), (y + 0), (z + -1));
				IceplacerProcedure.execute(world, (x + -1), (y + 0), (z + 1));
			}
			for (int index2 = 0; index2 < 1; index2++) {
				IceplacerProcedure.execute(world, (x + 1), (y + 1), (z + 0));
				IceplacerProcedure.execute(world, (x + 0), (y + 1), (z + -1));
				IceplacerProcedure.execute(world, (x + 0), (y + 1), (z + 1));
				IceplacerProcedure.execute(world, (x + -1), (y + 1), (z + 0));
				IceplacerProcedure.execute(world, (x + 1), (y + 1), (z + 1));
				IceplacerProcedure.execute(world, (x + -1), (y + 1), (z + -1));
				IceplacerProcedure.execute(world, (x + 1), (y + 1), (z + -1));
				IceplacerProcedure.execute(world, (x + -1), (y + 1), (z + 1));
			}
			for (int index3 = 0; index3 < 1; index3++) {
				IceplacerProcedure.execute(world, (x + 0), (y + 2), (z + -1));
				IceplacerProcedure.execute(world, (x + 0), (y + 2), (z + 1));
				IceplacerProcedure.execute(world, (x + 1), (y + 2), (z + 0));
				IceplacerProcedure.execute(world, (x + -1), (y + 2), (z + 0));
				IceplacerProcedure.execute(world, (x + 1), (y + 2), (z + 1));
				IceplacerProcedure.execute(world, (x + -1), (y + 2), (z + -1));
				IceplacerProcedure.execute(world, (x + 1), (y + 2), (z + -1));
				IceplacerProcedure.execute(world, (x + -1), (y + 2), (z + 1));
			}
			for (int index4 = 0; index4 < 1; index4++) {
				IceplacerProcedure.execute(world, (x + 1), (y + 3), (z + 0));
				IceplacerProcedure.execute(world, (x + 0), (y + 3), (z + -1));
				IceplacerProcedure.execute(world, (x + 0), (y + 3), (z + 1));
				IceplacerProcedure.execute(world, (x + -1), (y + 3), (z + 0));
				IceplacerProcedure.execute(world, (x + 1), (y + 3), (z + 1));
				IceplacerProcedure.execute(world, (x + -1), (y + 3), (z + -1));
				IceplacerProcedure.execute(world, (x + 1), (y + 3), (z + -1));
				IceplacerProcedure.execute(world, (x + -1), (y + 3), (z + 1));
			}
			IceplacerProcedure.execute(world, (x + 0), (y + 3), (z + 0));
		}
	}
}

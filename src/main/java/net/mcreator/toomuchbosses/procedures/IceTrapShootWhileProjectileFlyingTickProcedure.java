package net.mcreator.toomuchbosses.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class IceTrapShootWhileProjectileFlyingTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		double placeX = 0;
		double placeY = 0;
		double placeZ = 0;
		double kurikaeshi = 0;
		if (8 < immediatesourceentity.tickCount) {
			if (!immediatesourceentity.level().isClientSide())
				immediatesourceentity.discard();
		}
		immediatesourceentity.setDeltaMovement(new Vec3(0, 0, 0));
		immediatesourceentity.noPhysics = true;
		placeX = x + Math.sin(immediatesourceentity.tickCount * 45) * 5;
		placeY = world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x + Math.sin(immediatesourceentity.tickCount * 45) * 5), (int) (z + Math.cos(immediatesourceentity.tickCount * 45) * 5));
		placeZ = z + Math.cos(immediatesourceentity.tickCount * 45) * 5;
		for (int index0 = 0; index0 < 5; index0++) {
			IceplacerProcedure.execute(world, placeX, placeY, placeZ);
			placeY = placeY + 1;
		}
	}
}

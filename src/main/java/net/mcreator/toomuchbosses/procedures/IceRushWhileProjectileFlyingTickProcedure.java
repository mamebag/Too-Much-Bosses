package net.mcreator.toomuchbosses.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;

import net.mcreator.toomuchbosses.entity.IceRushEntity;

public class IceRushWhileProjectileFlyingTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
			return;
		double dis = 0;
		double rad = 0;
		double increasement = 0;
		double degvec = 0;
		double destX = 0;
		double destY = 0;
		double destZ = 0;
		double theta = 0;
		immediatesourceentity.noPhysics = true;
		immediatesourceentity.setNoGravity(true);
		if (immediatesourceentity.tickCount > 60) {
			IceplacerProcedure.execute(world, (immediatesourceentity.getX()), (immediatesourceentity.getY()), (immediatesourceentity.getZ()));
			IceplacerProcedure.execute(world, (immediatesourceentity.getX()), (immediatesourceentity.getY() + 1), (immediatesourceentity.getZ()));
			IceplacerProcedure.execute(world, (immediatesourceentity.getX()), (immediatesourceentity.getY() + -1), (immediatesourceentity.getZ()));
			IceplacerProcedure.execute(world, (immediatesourceentity.getX() + 1), (immediatesourceentity.getY() + 0), (immediatesourceentity.getZ() + 1));
			IceplacerProcedure.execute(world, (immediatesourceentity.getX() + -1), (immediatesourceentity.getY() + 0), (immediatesourceentity.getZ() + -1));
			IceplacerProcedure.execute(world, (immediatesourceentity.getX() + 1), (immediatesourceentity.getY() + 0), (immediatesourceentity.getZ() + -1));
			IceplacerProcedure.execute(world, (immediatesourceentity.getX() + -1), (immediatesourceentity.getY() + 0), (immediatesourceentity.getZ() + 1));
			if (!immediatesourceentity.level().isClientSide())
				immediatesourceentity.discard();
		}
		if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity) {
			IceplacerProcedure.execute(world, (immediatesourceentity.getX()), (immediatesourceentity.getY()), (immediatesourceentity.getZ()));
			destX = ((IceRushEntity) entity).destX;
			destY = ((IceRushEntity) entity).destY;
			destZ = ((IceRushEntity) entity).destZ;
			theta = ((IceRushEntity) entity).theta;
			theta += immediatesourceentity.tickCount / 5;
			if (immediatesourceentity.tickCount == 1) {
				destX = (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX();
				destY = (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY();
				destZ = (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ();
			}
			if (immediatesourceentity.tickCount < 60) {
				((IceRushEntity)immediatesourceentity).homing(destX + (10 - (immediatesourceentity.tickCount * 0.16)) * ((double) (Mth.sin((float) (theta)))), destY + (10 - (immediatesourceentity.tickCount * 0.16)) * ((double) (Mth.cos((float) (theta)))),
						destZ + (10 - (immediatesourceentity.tickCount * 0.16)) * ((double) (Mth.cos((float) (theta)))), 5 - (immediatesourceentity.tickCount * 0.08));
			}
		}
	}
}

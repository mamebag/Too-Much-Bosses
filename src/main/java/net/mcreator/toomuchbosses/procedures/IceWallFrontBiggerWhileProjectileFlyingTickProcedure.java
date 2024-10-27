package net.mcreator.toomuchbosses.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.toomuchbosses.entity.IceWallFrontBiggerEntity;

import java.util.List;
import java.util.Comparator;

public class IceWallFrontBiggerWhileProjectileFlyingTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
			return;
		Entity warlock = null;
		double dis = 0;
		double tickX = 0;
		double tickY = 0;
		double tickZ = 0;
		double Zknockback = 0;
		double Yknockback = 0;
		double Xknockback = 0;
		if (immediatesourceentity.tickCount > 40) {
			if (!immediatesourceentity.level().isClientSide())
				immediatesourceentity.discard();
		}
		if (immediatesourceentity.tickCount == 1) {
			immediatesourceentity.noPhysics = true;
			immediatesourceentity.setNoGravity(true);
			if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity) {
				((IceWallFrontBiggerEntity) immediatesourceentity).goalX = (((Mob) entity).getTarget().getX());
				((IceWallFrontBiggerEntity) immediatesourceentity).goalY = (((Mob) entity).getTarget().getY());
				((IceWallFrontBiggerEntity) immediatesourceentity).goalZ = (((Mob) entity).getTarget().getZ());
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == entityiterator) {
						dis = Math.sqrt(Math.pow(entityiterator.getX() - immediatesourceentity.getX(), 2) + Math.pow(entityiterator.getY() - immediatesourceentity.getY(), 2) + Math.pow(entityiterator.getZ() - immediatesourceentity.getZ(), 2));
						immediatesourceentity.setDeltaMovement(new Vec3((((entityiterator.getX() - immediatesourceentity.getX()) / dis) / 2), (((entityiterator.getY() - immediatesourceentity.getY()) / dis) / 2),
								(((entityiterator.getZ() - immediatesourceentity.getZ()) / dis) / 2)));
					}
				}
			}
		}
		if ((immediatesourceentity.tickCount) % 2 == 0) {
			tickY = -1.5;
			for (int index0 = 0; index0 < (int) Math.round(immediatesourceentity.tickCount / 8); index0++) {
				IceplacerProcedure.execute(world, (x + 0), (y + tickY), (z + 0));
				IceplacerProcedure.execute(world, (x + 0), (y + tickY), (z + 0));
				IceplacerProcedure.execute(world, (x + 1), (y + tickY), (z + 0));
				IceplacerProcedure.execute(world, (x + -1), (y + tickY), (z + 0));
				IceplacerProcedure.execute(world, (x + 1), (y + tickY), (z + 1));
				IceplacerProcedure.execute(world, (x + -1), (y + tickY), (z + -1));
				IceplacerProcedure.execute(world, (x + 1), (y + tickY), (z + -1));
				IceplacerProcedure.execute(world, (x + -1), (y + tickY), (z + 1));
				tickY = tickY + 1;
			}
			for (int index1 = 0; index1 < (int) Math.round(immediatesourceentity.tickCount / 2); index1++) {
				IceplacerProcedure.execute(world, (x + 0), (y + tickY), (z + 0));
				tickY = tickY + 1;
			}
		}
	}
}

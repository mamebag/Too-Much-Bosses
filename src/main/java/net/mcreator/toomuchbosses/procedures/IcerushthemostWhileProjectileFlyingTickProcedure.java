package net.mcreator.toomuchbosses.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import java.util.List;
import java.util.Comparator;

public class IcerushthemostWhileProjectileFlyingTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
			return;
		double dis = 0;
		immediatesourceentity.noPhysics = true;
		IceplacerProcedure.execute(world, x, y, z);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.SNOWFLAKE, x, y, z, 30, 0.2, 0.2, 0.2, 0);
		if (immediatesourceentity.tickCount % 10 == 0) {
			for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 1, 3); index0++) {
				SnowplacerProcedure.execute(world, (x + Mth.nextInt(RandomSource.create(), -1, 1)), y, (z + Mth.nextInt(RandomSource.create(), -1, 1)));
			}
		}
		if (immediatesourceentity.tickCount > 80) {
			IcelastProcedure.execute(world, x, y, z, immediatesourceentity);
			if (!immediatesourceentity.level().isClientSide())
				immediatesourceentity.discard();
		}
		immediatesourceentity.noPhysics = true;
		if (immediatesourceentity.tickCount == 1) {
			if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity) {
				immediatesourceentity.getPersistentData().putDouble("theta", (Mth.nextInt(RandomSource.create(), 0, 360)));
				immediatesourceentity.getPersistentData().putDouble("distX", ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()));
				immediatesourceentity.getPersistentData().putDouble("distY", ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY()));
				immediatesourceentity.getPersistentData().putDouble("distZ", ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ()));
			}
		}
		immediatesourceentity.getPersistentData().putDouble("theta", immediatesourceentity.tickCount * 0.3);
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == entityiterator) {
					if (immediatesourceentity.tickCount < 80) {
						dis = Math.sqrt(Math.pow(
								(immediatesourceentity.getPersistentData().getDouble("distX") + Math.cos(immediatesourceentity.getPersistentData().getDouble("theta")) * 20 - (immediatesourceentity.tickCount * 0.25)) - immediatesourceentity.getX(), 2)
								+ Math.pow((immediatesourceentity.getPersistentData().getDouble("distY") + Math.cos(immediatesourceentity.getPersistentData().getDouble("theta")) * 20 - (immediatesourceentity.tickCount * 0.25))
										- immediatesourceentity.getY(), 2)
								+ Math.pow((immediatesourceentity.getPersistentData().getDouble("distZ") + Math.sin(immediatesourceentity.getPersistentData().getDouble("theta")) * 20 - (immediatesourceentity.tickCount * 0.25))
										- immediatesourceentity.getZ(), 2));
						immediatesourceentity.setDeltaMovement(new Vec3(
								((((immediatesourceentity.getPersistentData().getDouble("distX") + Math.cos(immediatesourceentity.getPersistentData().getDouble("theta")) * 20 - (immediatesourceentity.tickCount * 0.25)) - immediatesourceentity.getX())
										/ dis) * 2),
								((((immediatesourceentity.getPersistentData().getDouble("distY") + Math.cos(immediatesourceentity.getPersistentData().getDouble("theta")) * 20 - (immediatesourceentity.tickCount * 0.25)) - immediatesourceentity.getY())
										/ dis) * 2),
								((((immediatesourceentity.getPersistentData().getDouble("distZ") + Math.sin(immediatesourceentity.getPersistentData().getDouble("theta")) * 20 - (immediatesourceentity.tickCount * 0.25)) - immediatesourceentity.getZ())
										/ dis) * 2)));
					} else {
						dis = Math.sqrt(Math
								.pow((immediatesourceentity.getPersistentData().getDouble("distX") + Math.cos(immediatesourceentity.getPersistentData().getDouble("theta")) * 10 - (immediatesourceentity.tickCount * 0.125))
										- immediatesourceentity.getX(), 2)
								+ Math.pow((immediatesourceentity.getPersistentData().getDouble("distY") + Math.cos(immediatesourceentity.getPersistentData().getDouble("theta")) * 10 - (immediatesourceentity.tickCount * 0.125))
										- immediatesourceentity.getY(), 2)
								+ Math.pow((immediatesourceentity.getPersistentData().getDouble("distZ") + Math.sin(immediatesourceentity.getPersistentData().getDouble("theta")) * 10 - (immediatesourceentity.tickCount * 0.125))
										- immediatesourceentity.getZ(), 2));
						immediatesourceentity.setDeltaMovement(new Vec3(
								((((immediatesourceentity.getPersistentData().getDouble("distX") + Math.cos(immediatesourceentity.getPersistentData().getDouble("theta")) * 10 - (immediatesourceentity.tickCount * 0.125))
										- immediatesourceentity.getX()) / dis) * 1),
								((((immediatesourceentity.getPersistentData().getDouble("distY") + Math.cos(immediatesourceentity.getPersistentData().getDouble("theta")) * 10 - (immediatesourceentity.tickCount * 0.125))
										- immediatesourceentity.getY()) / dis) * 1),
								((((immediatesourceentity.getPersistentData().getDouble("distZ") + Math.sin(immediatesourceentity.getPersistentData().getDouble("theta")) * 10 - (immediatesourceentity.tickCount * 0.125))
										- immediatesourceentity.getZ()) / dis) * 1)));
					}
				}
			}
		}
		if (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z) >= immediatesourceentity.getY()) {
			immediatesourceentity.setDeltaMovement(new Vec3((immediatesourceentity.getDeltaMovement().x()), 0.25, (immediatesourceentity.getDeltaMovement().z())));
		}
	}
}

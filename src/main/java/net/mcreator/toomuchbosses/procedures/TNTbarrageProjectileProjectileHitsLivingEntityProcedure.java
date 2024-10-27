package net.mcreator.toomuchbosses.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.toomuchbosses.entity.SpitterEntity;

public class TNTbarrageProjectileProjectileHitsLivingEntityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity, Entity sourceentity) {
		if (entity == null || immediatesourceentity == null || sourceentity == null)
			return;
		double dis = 0;
		entity.invulnerableTime = 0;
		if (world instanceof Level _level && !_level.isClientSide())
			_level.explode(null, x, y, z, 1, Level.ExplosionInteraction.NONE);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.SMOKE, x, y, z, 20, 0, 0, 0, 0.5);
		if (sourceentity instanceof SpitterEntity) {
			if (((SpitterEntity) sourceentity).hasRevived == true) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, x, y, z, 20, 0, 0, 0, 0.5);
				entity.setSecondsOnFire(2);
			}
		}
		if (!immediatesourceentity.level().isClientSide())
			immediatesourceentity.discard();
	}
}

package net.mcreator.toomuchbosses.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.toomuchbosses.entity.SpitterEntity;

public class TNTbarrageProjectileProjectileHitsBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
			return;
		if (world instanceof Level _level && !_level.isClientSide())
			_level.explode(null, x, y, z, 1, Level.ExplosionInteraction.NONE);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.SMOKE, x, y, z, 20, 0, 0, 0, 0.5);
		if (entity instanceof SpitterEntity) {
			if (((SpitterEntity) entity).hasRevived == true) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, x, y, z, 20, 0, 0, 0, 0.5);
			}
		}
		if (!immediatesourceentity.level().isClientSide())
			immediatesourceentity.discard();
	}
}

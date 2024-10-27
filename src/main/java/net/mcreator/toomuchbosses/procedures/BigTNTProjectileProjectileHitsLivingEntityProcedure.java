package net.mcreator.toomuchbosses.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.toomuchbosses.entity.SpitterEntity;

import java.util.List;
import java.util.Comparator;

public class BigTNTProjectileProjectileHitsLivingEntityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity, Entity sourceentity) {
		if (immediatesourceentity == null || sourceentity == null)
			return;
		double fireplaceX = 0;
		double fireplaceZ = 0;
		if (world instanceof Level _level && !_level.isClientSide())
			_level.explode(null, x, y, z, 2, Level.ExplosionInteraction.NONE);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.LARGE_SMOKE, x, y, z, 30, 0, 0, 0, 0.65);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, x, y, z, 30, 0, 0, 0, 0.65);
		if (sourceentity instanceof SpitterEntity) {
			if (((SpitterEntity) sourceentity).hasRevived == true) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (!(entityiterator instanceof SpitterEntity)) {
							entityiterator.setSecondsOnFire(5);
						}
					}
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, x, y, z, 30, 0, 0, 0, 0.65);
				for (int index0 = 0; index0 < 10; index0++) {
					fireplaceX = x + Mth.nextDouble(RandomSource.create(), -2, 2);
					fireplaceZ = z + Mth.nextDouble(RandomSource.create(), -2, 2);
					world.setBlock(BlockPos.containing(fireplaceX, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) fireplaceX, (int) fireplaceZ), fireplaceZ), Blocks.SOUL_FIRE.defaultBlockState(), 3);
				}
			}
		}
		if (!immediatesourceentity.level().isClientSide())
			immediatesourceentity.discard();
	}
}

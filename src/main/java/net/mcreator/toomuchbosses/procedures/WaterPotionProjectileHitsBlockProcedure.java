package net.mcreator.toomuchbosses.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.toomuchbosses.init.TooMuchBossesModEntities;

public class WaterPotionProjectileHitsBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		double times = 0;
		double offsetY = 0;
		double rad = 0;
		double rot = 0;
		world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.GLASS.defaultBlockState()));
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = TooMuchBossesModEntities.ICE_PIKES.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
			if (entityToSpawn != null) {
				entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
			}
		}
		if (!immediatesourceentity.level().isClientSide())
			immediatesourceentity.discard();
		times = 0;
		rad = 0;
		offsetY = 3;
		for (int index0 = 0; index0 < 18; index0++) {
			times = times + 1;
			rot = 0;
			offsetY = offsetY - times * 0.33;
			rad = 1.5 * Math.sin(times);
			for (int index1 = 0; index1 < 18; index1++) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.SPLASH, (x + rad * Math.cos(rot)), (y + offsetY), (z + rad * Math.cos(rot)), 2, 0, 0, 0, 0);
				rot = rot + 20;
			}
		}
	}
}

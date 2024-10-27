package net.mcreator.toomuchbosses.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.toomuchbosses.init.TooMuchBossesModEntities;

public class WaterPotionProjectileHitsLivingEntityProcedure {
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
	}
}

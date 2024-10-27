package net.mcreator.toomuchbosses.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.toomuchbosses.init.TooMuchBossesModEntities;
import net.mcreator.toomuchbosses.init.TooMuchBossesModBlocks;

public class WaterPotionWhileProjectileFlyingTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
			return;
		boolean found = false;
		double dis = 0;
		double rot = 0;
		double rad = 0;
		double offsetY = 0;
		double times = 0;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		sx = -2;
		found = false;
		for (int index0 = 0; index0 < 4; index0++) {
			sy = -2;
			for (int index1 = 0; index1 < 4; index1++) {
				sz = -2;
				for (int index2 = 0; index2 < 4; index2++) {
					if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == TooMuchBossesModBlocks.WARLOCKS_ICE.get()
							|| (world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == TooMuchBossesModBlocks.WARLOCKS_SNOW.get()) {
						world.destroyBlock(BlockPos.containing(x + sx, y + sy, z + sz), false);
					}
					sz = sz + 1;
				}
				sy = sy + 1;
			}
			sx = sx + 1;
		}
		if (immediatesourceentity.tickCount == 1) {
			entity.getPersistentData().putDouble("random", (Mth.nextInt(RandomSource.create(), 0, 0)));
		}
		if (immediatesourceentity.tickCount < 3) {
			if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity) {
				dis = Math.sqrt(Math.pow(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() + entity.getPersistentData().getDouble("random")) - immediatesourceentity.getX(), 2)
						+ Math.pow(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() + entity.getPersistentData().getDouble("random")) - immediatesourceentity.getY(), 2)
						+ Math.pow(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() + entity.getPersistentData().getDouble("random")) - immediatesourceentity.getZ(), 2));
				immediatesourceentity.setDeltaMovement(new Vec3((((((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() + entity.getPersistentData().getDouble("random")) - immediatesourceentity.getX()) / dis) / 0.25), 1,
						(((((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() + entity.getPersistentData().getDouble("random")) - immediatesourceentity.getZ()) / dis) / 0.25)));
			}
		}
		if (immediatesourceentity.tickCount == 3) {
			if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity) {
				dis = Math.sqrt(Math.pow(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() + entity.getPersistentData().getDouble("random")) - immediatesourceentity.getX(), 2)
						+ Math.pow((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() - immediatesourceentity.getY(), 2)
						+ Math.pow(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() + entity.getPersistentData().getDouble("random")) - immediatesourceentity.getZ(), 2));
				immediatesourceentity.setDeltaMovement(new Vec3((((((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() + entity.getPersistentData().getDouble("random")) - immediatesourceentity.getX()) / dis) / 2), 1,
						(((((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() + entity.getPersistentData().getDouble("random")) - immediatesourceentity.getZ()) / dis) / 2)));
			}
		}
		if (immediatesourceentity.tickCount == 4) {
			if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity) {
				dis = Math.sqrt(Math.pow(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() + entity.getPersistentData().getDouble("random")) - immediatesourceentity.getX(), 2)
						+ Math.pow((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() - immediatesourceentity.getY(), 2)
						+ Math.pow(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() + entity.getPersistentData().getDouble("random")) - immediatesourceentity.getZ(), 2));
				immediatesourceentity.setDeltaMovement(new Vec3((((((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() + entity.getPersistentData().getDouble("random")) - immediatesourceentity.getX()) / dis) / 3), 1,
						(((((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() + entity.getPersistentData().getDouble("random")) - immediatesourceentity.getZ()) / dis) / 3)));
			}
		}
		if (immediatesourceentity.tickCount < 15) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SPLASH, x, y, z, 1, 0, 0, 0, 0);
		}
		if (Mth.nextInt(RandomSource.create(), 15, 30) < immediatesourceentity.tickCount) {
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
}

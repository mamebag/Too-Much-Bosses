package net.mcreator.toomuchbosses.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.toomuchbosses.init.TooMuchBossesModEntities;
import net.mcreator.toomuchbosses.init.TooMuchBossesModBlocks;
import net.mcreator.toomuchbosses.entity.IceProjectileEntity;

public class LiftIceProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity,double width) {
		if (entity == null)
			return;
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;/*
		if (entity instanceof LivingEntity _entity)
			_entity.removeAllEffects();*/
		sx = 0 - width/2;
		found = false;
		for (int index0 = 0; index0 < ((int)width); index0++) {
			sy = 0 - width/2;
			for (int index1 = 0; index1 < ((int)width); index1++) {
				sz = 0 - width/2;
				for (int index2 = 0; index2 < ((int)width); index2++) {
					if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == TooMuchBossesModBlocks.WARLOCKS_ICE.get()) {
						world.setBlock(BlockPos.containing(x + sx, y + sy, z + sz), Blocks.AIR.defaultBlockState(), 3);
						if (world instanceof ServerLevel projectileLevel) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
									AbstractArrow entityToSpawn = new IceProjectileEntity(TooMuchBossesModEntities.ICE_PROJECTILE.get(), level);
									entityToSpawn.setOwner(shooter);
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.setKnockback(knockback);
									entityToSpawn.setSilent(true);
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, entity, 2, 1);
							_entityToSpawn.setPos((x + sx), (y + sy), (z + sz));
							_entityToSpawn.shoot(0, 0, 0, 0, 0);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
					}
					sz = sz + 1;
				}
				sy = sy + 1;
			}
			sx = sx + 1;
		}
	}
}

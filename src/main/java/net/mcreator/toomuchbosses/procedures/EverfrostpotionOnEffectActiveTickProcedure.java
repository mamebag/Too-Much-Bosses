package net.mcreator.toomuchbosses.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.toomuchbosses.init.TooMuchBossesModParticleTypes;
import net.mcreator.toomuchbosses.entity.IcePikesEntity;
import net.mcreator.toomuchbosses.entity.FrozenWarlockEntity;
import net.mcreator.toomuchbosses.TooMuchBossesMod;

import java.util.List;
import java.util.Comparator;

public class EverfrostpotionOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean found = false;
		Entity warlock = null;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double Zknockback = 0;
		double Yknockback = 0;
		double Xknockback = 0;
		double dis = 0;
		if (entity.isAlive()) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (TooMuchBossesModParticleTypes.EVERFROST.get()), x, (y - 2), z, 15, 0, 0, 0, 0.5);
		}
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof LivingEntity) {
					if (!(entityiterator instanceof IcePikesEntity)) {
						if (entityiterator.isAlive()) {
							if (!(entity == entityiterator)) {
								if (!((entityiterator instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) == entity)) {
									if (entityiterator.getTicksFrozen() < 100) {
										entityiterator.setTicksFrozen((int) (entityiterator.getTicksFrozen() + 3));
									}
									if (40 < entityiterator.getTicksFrozen()) {
										entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.FREEZE), entity), 1);
										if (((LivingEntity) entity).hurtTime != 0) {
											if (world instanceof ServerLevel _level)
												_level.sendParticles(ParticleTypes.SNOWFLAKE, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 10, (entityiterator.getBbWidth() / 2), (entityiterator.getBbHeight()),
														(entityiterator.getBbWidth() / 2), 0);
										}
									}
									if (100 < entityiterator.getTicksFrozen() && entityiterator.getTicksFrozen() < 103) {
										entityiterator.setTicksFrozen(400);
										FreezeEnemyProcedure.execute(world, entityiterator.getX(), entityiterator.getY(), entityiterator.getZ(), entity, entity.getBbWidth(), entity.getBbHeight());
									}
								}
							}
						}
					}
				}
				if (entityiterator instanceof Projectile) {
					if (Blocks.AIR == (world.getBlockState(BlockPos.containing(entityiterator.getX(), entityiterator.getY() - 0.1, entityiterator.getZ()))).getBlock()) {
						if (((Projectile) entityiterator).getOwner() != null) {
							if (!((((Projectile) entityiterator).getOwner()) instanceof FrozenWarlockEntity)) {
								Xknockback = entityiterator.getX() - entity.getX();
								Yknockback = entityiterator.getY() - entity.getY();
								Zknockback = entityiterator.getZ() - entity.getZ();
								dis = Math.abs(Xknockback) + Math.abs(Yknockback) + Math.abs(Zknockback);
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.SNOWFLAKE, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 2, 0, 0, 0, 0);
								if (dis != 0) {
									Xknockback = (Xknockback / dis) * 3;
									Yknockback = Math.min((Yknockback / dis) * 3, 2);
									Zknockback = (Zknockback / dis) * 3;
								} else {
									Xknockback = 0;
									Yknockback = 0;
									Zknockback = 0;
								}
								entityiterator.setDeltaMovement(new Vec3(Xknockback, Yknockback, Zknockback));
								entityiterator.setNoGravity(true);
								TooMuchBossesMod.queueServerWork(5, () -> {
									entityiterator.setNoGravity(false);
								});
							}
						}
					}
				}
			}
		}
	}
}

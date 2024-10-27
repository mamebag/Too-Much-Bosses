package net.mcreator.toomuchbosses.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.toomuchbosses.entity.SpitterEntity;
import net.mcreator.toomuchbosses.TooMuchBossesMod;

import java.util.List;
import java.util.Comparator;

public class TNTbarrageProjectileWhileProjectileFlyingTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
			return;
		double dis = 0;
		immediatesourceentity.setNoGravity(true);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.SMOKE, x, y, z, 2, 0, 0, 0, 0);
		if (immediatesourceentity.tickCount == 1) {
			immediatesourceentity.setDeltaMovement(new Vec3((Mth.nextDouble(RandomSource.create(), -1, 1)), (Mth.nextDouble(RandomSource.create(), 0.5, 1)), (Mth.nextDouble(RandomSource.create(), -1, 1))));
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.shulker.shoot")), SoundSource.NEUTRAL, 2, (float) 0.5);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.shulker.shoot")), SoundSource.NEUTRAL, 2, (float) 0.5, false);
				}
			}
		}
		if (immediatesourceentity.tickCount > 20) {
			if (entity instanceof SpitterEntity) {
				if (((SpitterEntity) entity).hasRevived == true) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, x, y, z, 2, 0, 0, 0, 0.2);
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == entityiterator) {
								dis = Math.sqrt(Math.pow((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() - immediatesourceentity.getX(), 2)
										+ Math.pow((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() - immediatesourceentity.getY(), 2)
										+ Math.pow((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() - immediatesourceentity.getZ(), 2));
								immediatesourceentity.setDeltaMovement(new Vec3(((((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() - immediatesourceentity.getX()) / dis) / 1),
										((((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() - immediatesourceentity.getY()) / dis) / 1),
										((((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() - immediatesourceentity.getZ()) / dis) / 1)));
							}
						}
					}
				} else {
					if (immediatesourceentity.tickCount > 40) {
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == entityiterator) {
									dis = Math.sqrt(Math.pow((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() - immediatesourceentity.getX(), 2)
											+ Math.pow((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() - immediatesourceentity.getY(), 2)
											+ Math.pow((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() - immediatesourceentity.getZ(), 2));
									immediatesourceentity.setDeltaMovement(new Vec3(((((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() - immediatesourceentity.getX()) / dis) / 1),
											((((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() - immediatesourceentity.getY()) / dis) / 1),
											((((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() - immediatesourceentity.getZ()) / dis) / 1)));
								}
							}
						}
					}
				}
			}
		}
		TooMuchBossesMod.queueServerWork(100, () -> {
			immediatesourceentity.setNoGravity(false);
		});
	}
}

package net.mcreator.toomuchbosses.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.toomuchbosses.entity.FrozenWarlockEntity;

import java.util.List;
import java.util.Comparator;

public class IceProjectileWhileProjectileFlyingTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
			return;
		double dis = 0;
		immediatesourceentity.noPhysics = true;
		if (immediatesourceentity.tickCount > 100) {
			IceplacerProcedure.execute(world, x, y, z);
			if (!immediatesourceentity.level().isClientSide())
				immediatesourceentity.discard();
		}
		if (immediatesourceentity.tickCount == 1) {
			if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity) {
				immediatesourceentity.getPersistentData().putDouble("theta", (Mth.nextInt(RandomSource.create(), 0, 360)));
				immediatesourceentity.getPersistentData().putDouble("distX", ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()));
				immediatesourceentity.getPersistentData().putDouble("distY", ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY()));
				immediatesourceentity.getPersistentData().putDouble("distZ", ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ()));
				immediatesourceentity.setDeltaMovement(new Vec3(0, (Mth.nextDouble(RandomSource.create(), 0.1, 0.5)), 0));
			}
		}
		immediatesourceentity.getPersistentData().putDouble("theta", immediatesourceentity.tickCount * 0.3);
		if (immediatesourceentity.tickCount > 40) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator instanceof FrozenWarlockEntity)) {
						if (entityiterator instanceof LivingEntity) {
							if (((LivingEntity) entityiterator).hurtTime == 0) {
								entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.FALLING_BLOCK), immediatesourceentity, entity), 8);
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.POOF, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 20, 0, 0, 0, 0.3);
							}
						}
					}
				}
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == entityiterator) {
						if ((immediatesourceentity.tickCount < 60) && (immediatesourceentity.tickCount > 30)) {
							dis = Math.sqrt(Math
									.pow((immediatesourceentity.getPersistentData().getDouble("distX") + Math.cos(immediatesourceentity.getPersistentData().getDouble("theta")) * 20 - (immediatesourceentity.tickCount * 0.25))
											- immediatesourceentity.getX(), 2)
									+ Math.pow((immediatesourceentity.getPersistentData().getDouble("distY") + Math.cos(immediatesourceentity.getPersistentData().getDouble("theta")) * 20 - (immediatesourceentity.tickCount * 0.25))
											- immediatesourceentity.getY(), 2)
									+ Math.pow((immediatesourceentity.getPersistentData().getDouble("distZ") + Math.sin(immediatesourceentity.getPersistentData().getDouble("theta")) * 20 - (immediatesourceentity.tickCount * 0.25))
											- immediatesourceentity.getZ(), 2));
							immediatesourceentity.setDeltaMovement(new Vec3(
									((((immediatesourceentity.getPersistentData().getDouble("distX") + Math.cos(immediatesourceentity.getPersistentData().getDouble("theta")) * 20 - (immediatesourceentity.tickCount * 0.25))
											- immediatesourceentity.getX()) / dis) * 2),
									((((immediatesourceentity.getPersistentData().getDouble("distY") + Math.cos(immediatesourceentity.getPersistentData().getDouble("theta")) * 20 - (immediatesourceentity.tickCount * 0.25))
											- immediatesourceentity.getY()) / dis) * 2),
									((((immediatesourceentity.getPersistentData().getDouble("distZ") + Math.sin(immediatesourceentity.getPersistentData().getDouble("theta")) * 20 - (immediatesourceentity.tickCount * 0.25))
											- immediatesourceentity.getZ()) / dis) * 2)));
						} else {
							dis = Math.sqrt(
									Math.pow(immediatesourceentity.getPersistentData().getDouble("distX") - immediatesourceentity.getX(), 2) + Math.pow(immediatesourceentity.getPersistentData().getDouble("distY") - immediatesourceentity.getY(), 2)
											+ Math.pow(immediatesourceentity.getPersistentData().getDouble("distZ") - immediatesourceentity.getZ(), 2));
							immediatesourceentity.setDeltaMovement(new Vec3((((immediatesourceentity.getPersistentData().getDouble("distX") - immediatesourceentity.getX()) / dis) * 1),
									(((immediatesourceentity.getPersistentData().getDouble("distY") - immediatesourceentity.getY()) / dis) * 1),
									(((immediatesourceentity.getPersistentData().getDouble("distZ") - immediatesourceentity.getZ()) / dis) * 1)));
						}
					}
				}
			}
		}
		if (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z) >= immediatesourceentity.getY()) {
			immediatesourceentity.setDeltaMovement(new Vec3((immediatesourceentity.getDeltaMovement().x()), 0.25, (immediatesourceentity.getDeltaMovement().z())));
		}
	}
}

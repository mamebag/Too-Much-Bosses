package net.mcreator.toomuchbosses.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import net.mcreator.toomuchbosses.entity.IceWallFrontShootEntity;

import java.util.List;
import java.util.Comparator;

public class IceWallFrontShootWhileProjectileFlyingTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
			return;
		Entity warlock = null;
		double dis = 0;
		if (immediatesourceentity.tickCount > 60) {
			if (!immediatesourceentity.level().isClientSide())
				immediatesourceentity.discard();
		}
		if (immediatesourceentity.tickCount % 15 == 0) {
			IceplacerProcedure.execute(world, (immediatesourceentity.getX()), (immediatesourceentity.getY() + 1), (immediatesourceentity.getZ()));
			IceplacerProcedure.execute(world, (immediatesourceentity.getX()), (immediatesourceentity.getY() + -1), (immediatesourceentity.getZ()));
			IceplacerProcedure.execute(world, (immediatesourceentity.getX() + 1), (immediatesourceentity.getY() + 0), (immediatesourceentity.getZ() + 1));
			IceplacerProcedure.execute(world, (immediatesourceentity.getX() + -1), (immediatesourceentity.getY() + 0), (immediatesourceentity.getZ() + -1));
			IceplacerProcedure.execute(world, (immediatesourceentity.getX() + 1), (immediatesourceentity.getY() + 0), (immediatesourceentity.getZ() + -1));
			IceplacerProcedure.execute(world, (immediatesourceentity.getX() + -1), (immediatesourceentity.getY() + 0), (immediatesourceentity.getZ() + 1));
		}
		if (immediatesourceentity.tickCount == 1) {
			immediatesourceentity.noPhysics = true;
			immediatesourceentity.setNoGravity(true);
			if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity) {
				((IceWallFrontShootEntity) immediatesourceentity).goalX = (((Mob) entity).getTarget().getX());
				((IceWallFrontShootEntity) immediatesourceentity).goalY = (((Mob) entity).getTarget().getY());
				((IceWallFrontShootEntity) immediatesourceentity).goalZ = (((Mob) entity).getTarget().getZ());
			}
			{
				Entity _ent = immediatesourceentity;
				_ent.teleportTo((entity.getX() + ((IceWallFrontShootEntity) immediatesourceentity).getHorizontalLookAngle(immediatesourceentity.getYRot() + 90).x), (entity.getY() + 1.7),
						(entity.getZ() + ((IceWallFrontShootEntity) immediatesourceentity).getHorizontalLookAngle(immediatesourceentity.getYRot() + 90).z));
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport((entity.getX() + ((IceWallFrontShootEntity) immediatesourceentity).getHorizontalLookAngle(immediatesourceentity.getYRot() + 90).x), (entity.getY() + 1.7),
							(entity.getZ() + ((IceWallFrontShootEntity) immediatesourceentity).getHorizontalLookAngle(immediatesourceentity.getYRot() + 90).z), _ent.getYRot(), _ent.getXRot());
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == entityiterator) {
						dis = Math.sqrt(Math.pow(((IceWallFrontShootEntity) immediatesourceentity).goalX - immediatesourceentity.getX(), 2) + Math.pow(((IceWallFrontShootEntity) immediatesourceentity).goalY - immediatesourceentity.getY(), 2)
								+ Math.pow(((IceWallFrontShootEntity) immediatesourceentity).goalZ - immediatesourceentity.getZ(), 2));
						immediatesourceentity.setDeltaMovement(new Vec3((((((IceWallFrontShootEntity) immediatesourceentity).goalX - immediatesourceentity.getX()) / dis) / 2.5),
								(((((IceWallFrontShootEntity) immediatesourceentity).goalY - immediatesourceentity.getY()) / dis) / 2.5), (((((IceWallFrontShootEntity) immediatesourceentity).goalZ - immediatesourceentity.getZ()) / dis) / 2.5)));
					}
				}
			}
		}
		IceplacerProcedure.execute(world, (immediatesourceentity.getX()), (immediatesourceentity.getY()), (immediatesourceentity.getZ()));
	}
}

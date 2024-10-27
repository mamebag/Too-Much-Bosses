package net.mcreator.toomuchbosses.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.toomuchbosses.init.TooMuchBossesModMobEffects;
import net.mcreator.toomuchbosses.init.TooMuchBossesModBlocks;
import net.mcreator.toomuchbosses.entity.IcePikesEntity;
import net.mcreator.toomuchbosses.entity.FrozenWarlockEntity;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

@Mod.EventBusSubscriber
public class WarlocksIceTickProcedure {
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingTickEvent event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity warlock = null;
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if (entity instanceof LivingEntity) {
			if (entity.isAlive()) {
				if (!(entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(TooMuchBossesModMobEffects.EVERFROSTPOTION.get()))) {
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (entityiterator instanceof FrozenWarlockEntity) {
								warlock = entityiterator;
							}
						}
					}
					sx = -2;
					found = false;
					for (int index0 = 0; index0 < 4; index0++) {
						sy = -2;
						for (int index1 = 0; index1 < 4; index1++) {
							sz = -2;
							for (int index2 = 0; index2 < 4; index2++) {
								if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == TooMuchBossesModBlocks.WARLOCKS_ICE.get()) {
									found = true;
								}
								sz = sz + 1;
							}
							sy = sy + 1;
						}
						sx = sx + 1;
					}
					if (found == true) {
						if (!(entity instanceof FrozenWarlockEntity)) {
							if (!(entity instanceof IcePikesEntity)) {
								if (entity.getTicksFrozen() < 100) {
									entity.setTicksFrozen((int) (entity.getTicksFrozen() + 3));
								}
								if (60 < entity.getTicksFrozen()) {
									entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.FREEZE), warlock), 1);
									if (((LivingEntity) entity).hurtTime != 0) {
										if (world instanceof ServerLevel _level)
											_level.sendParticles(ParticleTypes.SNOWFLAKE, x, y, z, 10, (entity.getBbWidth() / 2), (entity.getBbHeight()), (entity.getBbWidth() / 2), 0);
									}
								}
								if (98 < entity.getTicksFrozen() && entity.getTicksFrozen() < 101) {
									entity.setTicksFrozen(300);
									FreezeEnemyProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, entity.getBbWidth(), entity.getBbHeight());
								}
							}
						}
					}
				}
			}
		}
	}
}

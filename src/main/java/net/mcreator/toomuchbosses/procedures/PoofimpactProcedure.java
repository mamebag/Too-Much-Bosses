package net.mcreator.toomuchbosses.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.toomuchbosses.entity.IcepoofMakerEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PoofimpactProcedure {
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
		double times = 0;
		double offsetY = 0;
		double rad = 0;
		double rot = 0;
		double spawnX = 0;
		double spawnZ = 0;
		double dis = 0;
		double theta = 0;
		if (entity instanceof IcepoofMakerEntity) {
			if (entity.tickCount == 1) {
				for (int index0 = 0; index0 < 72; index0++) {
					theta = theta + 5;
					rad = 10;
					spawnX = x + Math.cos(theta) * rad;
					spawnZ = z + Math.sin(theta) * rad;
					dis = Math.sqrt(Math.pow(spawnX - x, 2) + Math.pow(y - y, 2) + Math.pow(spawnZ - z, 2));
					world.addParticle(ParticleTypes.POOF, x, y, z, (((spawnX - x) / dis) / 1), 0, (((spawnZ - z) / dis) / 1));
				}
				if (!entity.level().isClientSide())
					entity.discard();
			}
		}
	}
}

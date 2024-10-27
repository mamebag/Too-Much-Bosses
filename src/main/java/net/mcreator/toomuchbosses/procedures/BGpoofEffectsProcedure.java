package net.mcreator.toomuchbosses.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.toomuchbosses.entity.BGPoofEntityEntity;
import net.mcreator.toomuchbosses.TooMuchBossesMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class BGpoofEffectsProcedure {
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingTickEvent event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double a = 0;
		double r = 0;
		double b = 0;
		double dis = 0;
		if (entity instanceof BGPoofEntityEntity) {
			r = 0.5;
			a = Math.random() * 12;
			b = 90;
			for (int index0 = 0; index0 < 30; index0++) {
				for (int index1 = 0; index1 < 16; index1++) {
					b = b + 12;
					dis = Math.sqrt(Math.pow((entity.getX() - r * Math.cos(Math.toRadians(b)) * Math.sin(Math.toRadians(a))) - entity.getX(), 2) + Math.pow((entity.getY() - r * Math.sin(Math.toRadians(b))) - entity.getY(), 2)
							+ Math.pow((entity.getZ() + r * Math.cos(Math.toRadians(b)) * Math.cos(Math.toRadians(a))) - entity.getZ(), 2));
					world.addParticle(ParticleTypes.POOF, (entity.getX()), (entity.getY()), (entity.getZ()), ((((entity.getX() - r * Math.cos(Math.toRadians(b)) * Math.sin(Math.toRadians(a))) - entity.getX()) / dis) / 1),
							((((entity.getY() - r * Math.sin(Math.toRadians(b))) - entity.getY()) / dis) / 1), ((((entity.getZ() + r * Math.cos(Math.toRadians(b)) * Math.cos(Math.toRadians(a))) - entity.getZ()) / dis) / 1));
				}
				b = 90;
				a = a + 12;
			}
			TooMuchBossesMod.queueServerWork(1, () -> {
				if (!entity.level().isClientSide())
					entity.discard();
			});
		}
	}
}

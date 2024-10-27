package net.mcreator.toomuchbosses.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.toomuchbosses.entity.BGCrackEntityEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class BGFlamePillarProcedure {
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
		if (entity instanceof BGCrackEntityEntity) {
			if (entity.isShiftKeyDown()) {
				for (int index0 = 0; index0 < 2; index0++) {
					world.addParticle(ParticleTypes.FLAME, (entity.getX() + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), (entity.getY()), (entity.getZ() + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), 0,
							(Mth.nextDouble(RandomSource.create(), 0.25, 0.5)), 0);
				}
			}
		}
	}
}

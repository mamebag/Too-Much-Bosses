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

import net.mcreator.toomuchbosses.entity.BigTNTProjectileEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class HardlysmokeProcedure {
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
		if (entity instanceof BigTNTProjectileEntity) {
			for (int index0 = 0; index0 < 20; index0++) {
				world.addParticle(ParticleTypes.SMOKE, (x + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), (y + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), (z + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)),
						((0 - entity.getDeltaMovement().x()) / 2), ((0 - entity.getDeltaMovement().y()) / 2), ((0 - entity.getDeltaMovement().z()) / 2));
			}
		}
	}
}

package net.mcreator.toomuchbosses.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.entity.Entity;

import net.mcreator.toomuchbosses.entity.SpitterEntity;
import net.mcreator.toomuchbosses.entity.BigTNTProjectileEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class HeavySmokerProcedure {
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingTickEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof BigTNTProjectileEntity) {
			if (((BigTNTProjectileEntity) entity).getOwner() != null) {
				if (((SpitterEntity) (((BigTNTProjectileEntity) entity).getOwner())).hasRevived == true) {
					entity.setSprinting(true);
				}
			}
		}
	}
}

package net.mcreator.toomuchbosses.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingFallEvent;

import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ModdedCreeperManDontHurtProcedure {
	@SubscribeEvent
	public static void onEntityFall(LivingFallEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity());
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Skeleton) {
			if ((entity.getDisplayName().getString()).equals("The Modded Mob")) {
				entity.fallDistance = 0;
			}
		}
	}
}

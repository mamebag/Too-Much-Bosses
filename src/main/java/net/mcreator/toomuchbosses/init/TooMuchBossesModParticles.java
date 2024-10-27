
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.toomuchbosses.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.toomuchbosses.client.particle.GlowstoneChargeParticle;
import net.mcreator.toomuchbosses.client.particle.EverfrostParticle;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TooMuchBossesModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(TooMuchBossesModParticleTypes.GLOWSTONE_CHARGE.get(), GlowstoneChargeParticle::provider);
		event.registerSpriteSet(TooMuchBossesModParticleTypes.EVERFROST.get(), EverfrostParticle::provider);
	}
}


/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.toomuchbosses.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

import net.mcreator.toomuchbosses.client.renderer.WitheredScoutRenderer;
import net.mcreator.toomuchbosses.client.renderer.TheBossCloneRenderer;
import net.mcreator.toomuchbosses.client.renderer.SpitterRenderer;
import net.mcreator.toomuchbosses.client.renderer.PakuriRenderer;
import net.mcreator.toomuchbosses.client.renderer.MogiPlayerRenderer;
import net.mcreator.toomuchbosses.client.renderer.MayhemMakerRenderer;
import net.mcreator.toomuchbosses.client.renderer.IcepoofMakerRenderer;
import net.mcreator.toomuchbosses.client.renderer.IceWallFrontRenderer;
import net.mcreator.toomuchbosses.client.renderer.IceProjectileRenderer;
import net.mcreator.toomuchbosses.client.renderer.IcePikesRenderer;
import net.mcreator.toomuchbosses.client.renderer.GrowlEffectRenderer;
import net.mcreator.toomuchbosses.client.renderer.GlowstonebeamRenderer;
import net.mcreator.toomuchbosses.client.renderer.FrozenWarlockRenderer;
import net.mcreator.toomuchbosses.client.renderer.BigTNTProjectileRenderer;
import net.mcreator.toomuchbosses.client.renderer.BasaltTurretRenderer;
import net.mcreator.toomuchbosses.client.renderer.BasaltGuardianRenderer;
import net.mcreator.toomuchbosses.client.renderer.BGTrapEntityRenderer;
import net.mcreator.toomuchbosses.client.renderer.BGPoofEntityRenderer;
import net.mcreator.toomuchbosses.client.renderer.BGPillarEntityRenderer;
import net.mcreator.toomuchbosses.client.renderer.BGFlameEntityRenderer;
import net.mcreator.toomuchbosses.client.renderer.BGEarthQuakeEntityRenderer;
import net.mcreator.toomuchbosses.client.renderer.BGCrackEntityRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TooMuchBossesModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(TooMuchBossesModEntities.PAKURI.get(), PakuriRenderer::new);
		event.registerEntityRenderer(TooMuchBossesModEntities.BASALT_GUARDIAN.get(), BasaltGuardianRenderer::new);
		event.registerEntityRenderer(TooMuchBossesModEntities.GROWL_EFFECT.get(), GrowlEffectRenderer::new);
		event.registerEntityRenderer(TooMuchBossesModEntities.BG_TRAP_ENTITY.get(), BGTrapEntityRenderer::new);
		event.registerEntityRenderer(TooMuchBossesModEntities.BG_FLAME_ENTITY.get(), BGFlameEntityRenderer::new);
		event.registerEntityRenderer(TooMuchBossesModEntities.BG_PILLAR_ENTITY.get(), BGPillarEntityRenderer::new);
		event.registerEntityRenderer(TooMuchBossesModEntities.BG_POOF_ENTITY.get(), BGPoofEntityRenderer::new);
		event.registerEntityRenderer(TooMuchBossesModEntities.BG_EARTH_QUAKE_ENTITY.get(), BGEarthQuakeEntityRenderer::new);
		event.registerEntityRenderer(TooMuchBossesModEntities.SPITTER.get(), SpitterRenderer::new);
		event.registerEntityRenderer(TooMuchBossesModEntities.THE_BOSS_CLONE.get(), TheBossCloneRenderer::new);
		event.registerEntityRenderer(TooMuchBossesModEntities.BG_CRACK_ENTITY.get(), BGCrackEntityRenderer::new);
		event.registerEntityRenderer(TooMuchBossesModEntities.WITHERED_SCOUT.get(), WitheredScoutRenderer::new);
		event.registerEntityRenderer(TooMuchBossesModEntities.BASALT_TURRET.get(), BasaltTurretRenderer::new);
		event.registerEntityRenderer(TooMuchBossesModEntities.GLOWSTONEBEAM.get(), GlowstonebeamRenderer::new);
		event.registerEntityRenderer(TooMuchBossesModEntities.MOGI_PLAYER.get(), MogiPlayerRenderer::new);
		event.registerEntityRenderer(TooMuchBossesModEntities.TN_TBARRAGE_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(TooMuchBossesModEntities.BIG_TNT_PROJECTILE.get(), BigTNTProjectileRenderer::new);
		event.registerEntityRenderer(TooMuchBossesModEntities.FROZEN_WARLOCK.get(), FrozenWarlockRenderer::new);
		event.registerEntityRenderer(TooMuchBossesModEntities.ICE_WALL_FRONT.get(), IceWallFrontRenderer::new);
		event.registerEntityRenderer(TooMuchBossesModEntities.ICE_WALL_FRONT_SHOOT.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(TooMuchBossesModEntities.ICE_WALL_FRONT_BIGGER.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(TooMuchBossesModEntities.ICE_TRAP_SHOOT.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(TooMuchBossesModEntities.MAYHEM_MAKER.get(), MayhemMakerRenderer::new);
		event.registerEntityRenderer(TooMuchBossesModEntities.ICE_PIKES.get(), IcePikesRenderer::new);
		event.registerEntityRenderer(TooMuchBossesModEntities.WATER_POTION.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(TooMuchBossesModEntities.ICEPOOF_MAKER.get(), IcepoofMakerRenderer::new);
		event.registerEntityRenderer(TooMuchBossesModEntities.ICE_RUSH.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(TooMuchBossesModEntities.ICERUSHTHEMOST.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(TooMuchBossesModEntities.ICE_PROJECTILE.get(), IceProjectileRenderer::new);
	}
}

/**
 * The code of this mod element is always locked.
 *
 * You can register new events in this class too.
 *
 * If you want to make a plain independent class, create it using
 * Project Browser -> New... and make sure to make the class
 * outside net.mcreator.toomuchbosses as this package is managed by MCreator.
 *
 * If you change workspace package, modid or prefix, you will need
 * to manually adapt this file to these changes or remake it.
 *
 * This class will be added in the mod root package.
*/
package net.mcreator.toomuchbosses;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PakuriofwardenAnimation{
	//roarAnimation
	public static final AnimationDefinition WARDEN_ROAR = AnimationDefinition.Builder.withLength(4.2F).addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.24F, KeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.6F, KeyframeAnimations.degreeVec(32.5F, 0.0F, -7.5F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.84F, KeyframeAnimations.degreeVec(38.33F, 0.0F, 2.99F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(2.08F, KeyframeAnimations.degreeVec(40.97F, 0.0F, -4.3F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(2.36F, KeyframeAnimations.degreeVec(44.41F, 0.0F, 6.29F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(3.0F, KeyframeAnimations.degreeVec(47.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(4.2F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("body", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.24F, KeyframeAnimations.posVec(0.0F, -1.0F, 3.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.6F, KeyframeAnimations.posVec(0.0F, -3.0F, -6.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(3.0F, KeyframeAnimations.posVec(0.0F, -3.0F, -6.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(4.2F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.24F, KeyframeAnimations.degreeVec(-32.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.6F, KeyframeAnimations.degreeVec(-32.5F, 0.0F, -27.5F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.8F, KeyframeAnimations.degreeVec(-32.5F, 0.0F, 26.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(2.04F, KeyframeAnimations.degreeVec(-32.5F, 0.0F, -27.5F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(2.44F, KeyframeAnimations.degreeVec(-32.5F, 0.0F, 26.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(2.84F, KeyframeAnimations.degreeVec(-5.0F, 0.0F, -12.5F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(4.2F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.24F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.6F, KeyframeAnimations.posVec(0.0F, -2.0F, -6.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(2.2F, KeyframeAnimations.posVec(0.0F, -2.0F, -6.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(2.48F, KeyframeAnimations.posVec(0.0F, -2.0F, -6.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(4.2F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("right_ear", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.24F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.76F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -10.85F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(2.08F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 12.5F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(2.4F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -10.85F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(2.72F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 12.5F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(3.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -10.85F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(4.2F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("left_ear", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.24F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.76F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -15.85F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(2.08F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 12.5F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(2.4F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -15.85F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(2.72F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 12.5F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(3.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -15.85F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(4.2F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("right_arm", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.72F, KeyframeAnimations.degreeVec(-120.0F, 0.0F, -20.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.24F, KeyframeAnimations.degreeVec(-77.5F, 3.75F, 15.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.48F, KeyframeAnimations.degreeVec(67.5F, -32.5F, 20.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(2.48F, KeyframeAnimations.degreeVec(37.5F, -32.5F, 25.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(2.88F, KeyframeAnimations.degreeVec(27.6F, -17.1F, 32.5F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(4.2F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("right_arm", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.72F, KeyframeAnimations.posVec(3.0F, -2.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.48F, KeyframeAnimations.posVec(4.0F, -2.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(2.48F, KeyframeAnimations.posVec(4.0F, -2.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(4.2F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("left_arm", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.72F, KeyframeAnimations.degreeVec(-125.0F, 0.0F, 20.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.24F, KeyframeAnimations.degreeVec(-76.25F, -17.5F, -7.5F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.48F, KeyframeAnimations.degreeVec(62.5F, 42.5F, -12.5F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(2.48F, KeyframeAnimations.degreeVec(37.5F, 27.5F, -27.5F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(2.88F, KeyframeAnimations.degreeVec(25.0F, 18.4F, -30.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(4.2F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("left_arm", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.72F, KeyframeAnimations.posVec(-3.0F, -2.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.48F, KeyframeAnimations.posVec(-4.0F, -2.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(2.48F, KeyframeAnimations.posVec(-4.0F, -2.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(4.2F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM))).build();
	//roarAnimation
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		new PakuriofwardenAnimation();
	}

	@Mod.EventBusSubscriber
	private static class ForgeBusEvents {
		@SubscribeEvent
		public static void serverLoad(ServerStartingEvent event) {
		}

		@OnlyIn(Dist.CLIENT)
		@SubscribeEvent
		public static void clientLoad(FMLClientSetupEvent event) {
		}
	}
}

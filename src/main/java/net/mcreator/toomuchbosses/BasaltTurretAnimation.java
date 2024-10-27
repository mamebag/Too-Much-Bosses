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
import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BasaltTurretAnimation {
public static final AnimationDefinition SHOOT = AnimationDefinition.Builder.withLength(8.0F)
	.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
				new Keyframe(2.5F, KeyframeAnimations.degreeVec(-45.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.0F, KeyframeAnimations.degreeVec(-45.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(3.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
								new Keyframe(8.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("lid", new AnimationChannel(AnimationChannel.Targets.POSITION, 
		new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 16.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
				new Keyframe(7.0F, KeyframeAnimations.posVec(0.0F, 16.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(8.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("lid", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 180.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
				new Keyframe(7.0F, KeyframeAnimations.degreeVec(0.0F, 180.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(8.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM))).build();

public static final AnimationDefinition DEATH = AnimationDefinition.Builder.withLength(8.0F)
	.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, -65.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
				new Keyframe(1.0F, KeyframeAnimations.degreeVec(-45.0F, -65.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("lid", new AnimationChannel(AnimationChannel.Targets.POSITION, 
		new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 16.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 16.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
				new Keyframe(1.66F, KeyframeAnimations.posVec(0.0F, 2.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.8F, KeyframeAnimations.posVec(-4.0F, -2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("lid", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
				new Keyframe(1.66F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.8F, KeyframeAnimations.degreeVec(0.0F, -22.5F, -20.0F), AnimationChannel.Interpolations.CATMULLROM))).build();

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		new BasaltTurretAnimation();
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

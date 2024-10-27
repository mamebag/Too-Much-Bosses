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
public class WitheredScoutAnimation {
public static final AnimationDefinition SLASH = AnimationDefinition.Builder.withLength(1.0F)
	.addAnimation("Head", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.5F, KeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
				new Keyframe(0.66F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.79F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("RightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.5F, KeyframeAnimations.degreeVec(-193.6497F, -6.2797F, -24.2477F), AnimationChannel.Interpolations.CATMULLROM),
				new Keyframe(0.66F, KeyframeAnimations.degreeVec(-33.6497F, -6.2797F, -24.2477F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.79F, KeyframeAnimations.degreeVec(-33.6497F, -6.2797F, -24.2477F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("LeftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.5F, KeyframeAnimations.degreeVec(-62.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
				new Keyframe(0.66F, KeyframeAnimations.degreeVec(56.1093F, 16.598F, -15.9854F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.79F, KeyframeAnimations.degreeVec(56.1093F, 16.598F, -15.9854F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("zyouhanshin", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.5F, KeyframeAnimations.degreeVec(-10.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
				new Keyframe(0.66F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.79F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("sword", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
				new Keyframe(0.66F, KeyframeAnimations.degreeVec(65.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.79F, KeyframeAnimations.degreeVec(65.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM))).build();

public static final AnimationDefinition STAB = AnimationDefinition.Builder.withLength(0.91F)
	.addAnimation("Head", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.5F, KeyframeAnimations.degreeVec(20.0F, -22.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
				new Keyframe(0.62F, KeyframeAnimations.degreeVec(-2.4029F, 3.0023F, -5.9116F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75F, KeyframeAnimations.degreeVec(-2.4029F, 3.0023F, -5.9116F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.91F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("RightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.5F, KeyframeAnimations.degreeVec(21.7254F, 19.5064F, -4.5043F), AnimationChannel.Interpolations.CATMULLROM),
				new Keyframe(0.62F, KeyframeAnimations.degreeVec(-43.4542F, -14.4859F, 4.0025F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75F, KeyframeAnimations.degreeVec(-43.4542F, -14.4859F, 4.0025F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.91F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("LeftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.5F, KeyframeAnimations.degreeVec(-60.1277F, -22.0161F, -12.1512F), AnimationChannel.Interpolations.CATMULLROM),
				new Keyframe(0.62F, KeyframeAnimations.degreeVec(53.2195F, 3.71F, -32.456F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75F, KeyframeAnimations.degreeVec(53.2195F, 3.71F, -32.456F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.91F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("zyouhanshin", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.5F, KeyframeAnimations.degreeVec(-11.5084F, 29.4987F, -5.7251F), AnimationChannel.Interpolations.CATMULLROM),
				new Keyframe(0.62F, KeyframeAnimations.degreeVec(7.4626F, -4.9238F, 0.8704F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75F, KeyframeAnimations.degreeVec(7.4626F, -4.9238F, 0.8704F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.91F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("sword", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
				new Keyframe(0.62F, KeyframeAnimations.degreeVec(47.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75F, KeyframeAnimations.degreeVec(47.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.91F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM))).build();

public static final AnimationDefinition DEATH = AnimationDefinition.Builder.withLength(1.12F)
	.addAnimation("Head", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.5F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
				new Keyframe(0.62F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.87F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(11.25F, KeyframeAnimations.degreeVec(-10.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("RightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.5F, KeyframeAnimations.degreeVec(-35.0F, 0.0F, 22.5F), AnimationChannel.Interpolations.CATMULLROM),
				new Keyframe(0.83F, KeyframeAnimations.degreeVec(-35.0F, 0.0F, 22.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.87F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.95F, KeyframeAnimations.degreeVec(20.9473F, 20.4366F, 54.6517F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("LeftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.5F, KeyframeAnimations.degreeVec(-35.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
				new Keyframe(0.87F, KeyframeAnimations.degreeVec(-80.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.04F, KeyframeAnimations.degreeVec(17.8924F, 9.0866F, -26.0666F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("zyouhanshin", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.45F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
				new Keyframe(0.54F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.04F, KeyframeAnimations.degreeVec(17.8924F, 9.0866F, -26.0666F), AnimationChannel.Interpolations.CATMULLROM)))
	/*.addAnimation("zyouhanshin", new AnimationChannel(AnimationChannel.Targets.POSITION, 
		new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.45F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
				new Keyframe(0.54F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.04F, KeyframeAnimations.posVec(0.0F, 0.0F, 10.0F), AnimationChannel.Interpolations.CATMULLROM)))*/
	.addAnimation("sword", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
				new Keyframe(1.0F, KeyframeAnimations.degreeVec(46.2543F, 58.3186F, -45.2656F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("sword", new AnimationChannel(AnimationChannel.Targets.POSITION, 
		new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.875F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
				new Keyframe(1.0F, KeyframeAnimations.posVec(-3.0F, 0.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("RightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
				new Keyframe(0.83F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 17.5F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("RightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION, 
		new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, -3.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
				new Keyframe(0.83F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("LeftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
				new Keyframe(0.83F, KeyframeAnimations.degreeVec(4.3329F, -2.4976F, 4.9055F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("legs", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.45F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
				new Keyframe(1.0F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("legs", new AnimationChannel(AnimationChannel.Targets.POSITION, 
		new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.45F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
				new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, -11.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("zyouhanshin", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.45F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
				new Keyframe(1.0F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("zyouhanshin", new AnimationChannel(AnimationChannel.Targets.POSITION, 
		new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.45F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
				new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, -10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM))).build();

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		new WitheredScoutAnimation();
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

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
import net.minecraft.client.gui.screens.DeathScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BasaltGuardianAnimation {
	
	public static final AnimationDefinition ROAR = AnimationDefinition.Builder.withLength(4.2F)
	.addAnimation("zouhanshin", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.24F, KeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.6F, KeyframeAnimations.degreeVec(32.5F, 0.0F, -7.5F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.84F, KeyframeAnimations.degreeVec(38.33F, 0.0F, 2.99F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(2.08F, KeyframeAnimations.degreeVec(40.97F, 0.0F, -4.3F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(2.36F, KeyframeAnimations.degreeVec(44.41F, 0.0F, 6.29F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(3.0F, KeyframeAnimations.degreeVec(47.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(4.2F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("zouhanshin", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.24F, KeyframeAnimations.posVec(0.0F, -1.0F, 3.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.6F, KeyframeAnimations.posVec(0.0F, -3.0F, -6.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(3.0F, KeyframeAnimations.posVec(0.0F, -3.0F, -6.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(4.2F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.24F, KeyframeAnimations.degreeVec(-32.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.6F, KeyframeAnimations.degreeVec(-32.5F, 0.0F, -27.5F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.8F, KeyframeAnimations.degreeVec(-32.5F, 0.0F, 26.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(2.04F, KeyframeAnimations.degreeVec(-32.5F, 0.0F, -27.5F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(2.44F, KeyframeAnimations.degreeVec(-32.5F, 0.0F, 26.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(2.84F, KeyframeAnimations.degreeVec(-5.0F, 0.0F, -12.5F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(4.2F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.24F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.6F, KeyframeAnimations.posVec(0.0F, -2.0F, -6.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(2.2F, KeyframeAnimations.posVec(0.0F, -2.0F, -6.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(2.48F, KeyframeAnimations.posVec(0.0F, -2.0F, -6.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(4.2F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.72F, KeyframeAnimations.degreeVec(-120.0F, 0.0F, -20.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.24F, KeyframeAnimations.degreeVec(-77.5F, 3.75F, 15.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.48F, KeyframeAnimations.degreeVec(67.5F, -32.5F, 20.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(2.48F, KeyframeAnimations.degreeVec(37.5F, -32.5F, 25.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(2.88F, KeyframeAnimations.degreeVec(27.6F, -17.1F, 32.5F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(4.2F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.72F, KeyframeAnimations.posVec(3.0F, -2.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.48F, KeyframeAnimations.posVec(4.0F, -2.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(2.48F, KeyframeAnimations.posVec(4.0F, -2.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(4.2F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.72F, KeyframeAnimations.degreeVec(-125.0F, 0.0F, 20.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.24F, KeyframeAnimations.degreeVec(-76.25F, -17.5F, -7.5F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.48F, KeyframeAnimations.degreeVec(62.5F, 42.5F, -12.5F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(2.48F, KeyframeAnimations.degreeVec(37.5F, 27.5F, -27.5F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(2.88F, KeyframeAnimations.degreeVec(25.0F, 18.4F, -30.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(4.2F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.72F, KeyframeAnimations.posVec(-3.0F, -2.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(1.48F, KeyframeAnimations.posVec(-4.0F, -2.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(2.48F, KeyframeAnimations.posVec(-4.0F, -2.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(4.2F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM))).build();
	
	public static final AnimationDefinition SMASH = AnimationDefinition.Builder.withLength(3.0F)
	.addAnimation("zouhanshin", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(1.0F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.5F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.75F, KeyframeAnimations.degreeVec(-82.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.20F, KeyframeAnimations.degreeVec(-82.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.66F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(1.0F, KeyframeAnimations.degreeVec(198.8817F, -6.7177F, 18.8817F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.5F, KeyframeAnimations.degreeVec(207.8939F, -10.2876F, 25.5522F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.75F, KeyframeAnimations.degreeVec(141.9522F, -23.0509F, 8.0663F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.08F, KeyframeAnimations.degreeVec(141.9522F, -23.0509F, 8.0663F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.66F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(1.0F, KeyframeAnimations.degreeVec(198.8817F, 5.188F, -16.7363F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.5F, KeyframeAnimations.degreeVec(203.7394F, 7.2218F, -21.3312F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.75F, KeyframeAnimations.degreeVec(139.4522F, 23.708F, -6.9739F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.08F, KeyframeAnimations.degreeVec(139.4522F, 23.708F, -6.9739F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.66F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	/*.addAnimation("arm", new AnimationChannel(AnimationChannel.Targets.SCALE, 
		new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR)))
	.addAnimation("arm2", new AnimationChannel(AnimationChannel.Targets.SCALE, 
		new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR)))*/
	.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(1.0F, KeyframeAnimations.degreeVec(-30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.5F, KeyframeAnimations.degreeVec(-42.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.75F, KeyframeAnimations.degreeVec(75.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.08F, KeyframeAnimations.degreeVec(75.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.20F, KeyframeAnimations.degreeVec(75.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
								new Keyframe(2.66F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(1.0F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.5F, KeyframeAnimations.degreeVec(32.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION, 
		new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 4.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.75F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM))).build();

	public static final AnimationDefinition HAMMER = AnimationDefinition.Builder.withLength(2.25F)
	.addAnimation("zouhanshin", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.5F, KeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.0F, KeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.12F, KeyframeAnimations.degreeVec(-44.765F, 16.3882F, -15.6337F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.5F, KeyframeAnimations.degreeVec(-44.765F, 16.3882F, -15.6337F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.5F, KeyframeAnimations.degreeVec(37.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.0F, KeyframeAnimations.degreeVec(37.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.12F, KeyframeAnimations.degreeVec(-3.525F, 25.3105F, -11.3755F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.5F, KeyframeAnimations.degreeVec(-3.525F, 25.3105F, -11.3755F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("rightarmFist", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), 
			new Keyframe(1.0F, KeyframeAnimations.degreeVec(37.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
				new Keyframe(1.12F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.5F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
						new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)))
	.addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.5F, KeyframeAnimations.degreeVec(-15.9053F, 15.1235F, 15.5666F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.0F, KeyframeAnimations.degreeVec(-15.9053F, 15.1235F, 15.5666F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.12F, KeyframeAnimations.degreeVec(68.6815F, 35.7377F, 70.3525F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.5F, KeyframeAnimations.degreeVec(68.6815F, 35.7377F, 70.3525F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("rightarmFist2", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.5F, KeyframeAnimations.degreeVec(-55.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.0F, KeyframeAnimations.degreeVec(-55.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.12F, KeyframeAnimations.degreeVec(-10.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.5F, KeyframeAnimations.degreeVec(-10.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(1.0F, KeyframeAnimations.degreeVec(-32.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
				new Keyframe(1.12F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM))).build();

	public static final AnimationDefinition BASH = AnimationDefinition.Builder.withLength(1.66F)
	.addAnimation("zouhanshin", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), 
			new Keyframe(0.5F, KeyframeAnimations.degreeVec(7.5F, 7.5F, 0.0F), AnimationChannel.Interpolations.LINEAR), 
				new Keyframe(0.75F, KeyframeAnimations.degreeVec(12.697F, 14.9343F, 1.0103F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.875F, KeyframeAnimations.degreeVec(13.2644F, 22.2433F, 2.7865F), AnimationChannel.Interpolations.LINEAR),
						new Keyframe(1.04F, KeyframeAnimations.degreeVec(15.7749F, -38.6316F, -12.315F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.375F, KeyframeAnimations.degreeVec(15.7749F, -38.6316F, -12.315F), AnimationChannel.Interpolations.CATMULLROM),
								new Keyframe(1.66F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), 
			new Keyframe(0.5F, KeyframeAnimations.degreeVec(-12.3159F, -2.1539F, -9.7676F), AnimationChannel.Interpolations.LINEAR), 
				new Keyframe(0.75F, KeyframeAnimations.degreeVec(-22.3159F, -2.1539F, -9.7676F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.875F, KeyframeAnimations.degreeVec(-29.8159F, -2.1539F, -9.7676F), AnimationChannel.Interpolations.LINEAR),
						new Keyframe(1.04F, KeyframeAnimations.degreeVec(45.3707F, -16.7409F, 4.1452F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.16F, KeyframeAnimations.degreeVec(22.6841F, -2.1539F, -9.7676F), AnimationChannel.Interpolations.CATMULLROM),
								new Keyframe(1.375F, KeyframeAnimations.degreeVec(22.6841F, -2.1539F, -9.7676F), AnimationChannel.Interpolations.CATMULLROM),
									new Keyframe(1.66F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	/*.addAnimation("arm", new AnimationChannel(AnimationChannel.Targets.SCALE, 
		new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 0.6F, 1.0F), AnimationChannel.Interpolations.LINEAR)))
	.addAnimation("arm2", new AnimationChannel(AnimationChannel.Targets.SCALE, 
		new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 0.6F, 1.0F), AnimationChannel.Interpolations.LINEAR)))*/
	.addAnimation("rightarmFist", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), 
			new Keyframe(0.5F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), 
				new Keyframe(0.75F, KeyframeAnimations.degreeVec(62.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.875F, KeyframeAnimations.degreeVec(62.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
						new Keyframe(1.04F, KeyframeAnimations.degreeVec(97.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.16F, KeyframeAnimations.degreeVec(97.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
								new Keyframe(1.375F, KeyframeAnimations.degreeVec(97.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
									new Keyframe(1.66F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), 
			new Keyframe(0.62F, KeyframeAnimations.degreeVec(22.1916F, -3.8102F, 9.2525F), AnimationChannel.Interpolations.LINEAR), 
					new Keyframe(0.79F, KeyframeAnimations.degreeVec(26.8102F, -6.4611F, 13.5094F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.37F, KeyframeAnimations.degreeVec(26.8102F, -6.4611F, 13.5094F), AnimationChannel.Interpolations.LINEAR),
						new Keyframe(1.66F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)))
	.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), 
			new Keyframe(0.5F, KeyframeAnimations.degreeVec(-20.0703F, 4.6978F, -1.7139F), AnimationChannel.Interpolations.LINEAR), 
				new Keyframe(0.87F, KeyframeAnimations.degreeVec(-35.0703F, 4.6978F, -1.7139F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.375F, KeyframeAnimations.degreeVec(-35.0703F, 4.6978F, -1.7139F), AnimationChannel.Interpolations.LINEAR),
						new Keyframe(1.66F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)))
	.addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION, 
		new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), 
			new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 3.0F, 6.0F), AnimationChannel.Interpolations.LINEAR), 
				new Keyframe(0.875F, KeyframeAnimations.posVec(0.0F, 3.0F, 6.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.04F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM))).build();
	
	public static final AnimationDefinition INSERT = AnimationDefinition.Builder.withLength(3.83F)
	.addAnimation("zouhanshin", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), 
			new Keyframe(1.0F, KeyframeAnimations.degreeVec(20.0F, 7.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.16F, KeyframeAnimations.degreeVec(-72.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(2.5F, KeyframeAnimations.degreeVec(-72.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
						new Keyframe(2.66F, KeyframeAnimations.degreeVec(-62.6085F, 9.298F, -31.2822F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.87F, KeyframeAnimations.degreeVec(2.3915F, 9.298F, -31.2822F), AnimationChannel.Interpolations.CATMULLROM),
								new Keyframe(3.16F, KeyframeAnimations.degreeVec(7.8191F, 5.5837F, 8.9052F), AnimationChannel.Interpolations.CATMULLROM),
									new Keyframe(3.37F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), 
			new Keyframe(1.0F, KeyframeAnimations.degreeVec(56.5968F, -39.8557F, -67.0902F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.16F, KeyframeAnimations.degreeVec(83.5193F, 30.8516F, -33.727F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(2.5F, KeyframeAnimations.degreeVec(83.5193F, 30.8516F, -33.727F), AnimationChannel.Interpolations.LINEAR),
						new Keyframe(2.66F, KeyframeAnimations.degreeVec(121.5183F, 63.4972F, -13.7353F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.87F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -40.2646F), AnimationChannel.Interpolations.CATMULLROM),
								new Keyframe(3.16F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -30.811F), AnimationChannel.Interpolations.CATMULLROM),
										new Keyframe(3.37F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	/*.addAnimation("arm", new AnimationChannel(AnimationChannel.Targets.SCALE, 
		new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 0.6F, 1.0F), AnimationChannel.Interpolations.LINEAR)))
	.addAnimation("arm2", new AnimationChannel(AnimationChannel.Targets.SCALE, 
		new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 0.6F, 1.0F), AnimationChannel.Interpolations.LINEAR)))*/
	.addAnimation("rightarmFist", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), 
			new Keyframe(0.87F, KeyframeAnimations.degreeVec(-13.6497F, -6.2797F, 33.2523F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(2.5F, KeyframeAnimations.degreeVec(-13.6497F, -6.2797F, 33.2523F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(2.66F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), 
			new Keyframe(1.0F, KeyframeAnimations.degreeVec(56.5968F, 39.2383F, 79.6309F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.16F, KeyframeAnimations.degreeVec(80.4059F, -28.5812F, 34.9833F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(2.5F, KeyframeAnimations.degreeVec(80.4059F, -28.5812F, 34.9833F), AnimationChannel.Interpolations.LINEAR),
						new Keyframe(2.66F, KeyframeAnimations.degreeVec(52.4508F, -54.7604F, 46.6163F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.87F, KeyframeAnimations.degreeVec(40.3807F, -48.5946F, 39.7083F), AnimationChannel.Interpolations.CATMULLROM),
								new Keyframe(3.16F, KeyframeAnimations.degreeVec(51.5361F, -35.908F, 23.2803F), AnimationChannel.Interpolations.CATMULLROM),
										new Keyframe(3.37F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), 
			new Keyframe(1.0F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.16F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(2.5F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
						new Keyframe(2.91F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM))).build();
							
	public static final AnimationDefinition ENRAGE = AnimationDefinition.Builder.withLength(3.625F)
	.addAnimation("zouhanshin", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.5F, KeyframeAnimations.degreeVec(-0.76F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(0.62F, KeyframeAnimations.degreeVec(-20.97F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.83F, KeyframeAnimations.degreeVec(-20.97F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.16F, KeyframeAnimations.degreeVec(0.95F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.54F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
								new Keyframe(1.75F, KeyframeAnimations.degreeVec(-27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
									new Keyframe(2.29F, KeyframeAnimations.degreeVec(-27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
										new Keyframe(2.54F, KeyframeAnimations.degreeVec(-26.0666F, -9.0866F, -17.8924F), AnimationChannel.Interpolations.CATMULLROM),
											new Keyframe(2.79F, KeyframeAnimations.degreeVec(-86.0666F, -9.0866F, -17.8924F), AnimationChannel.Interpolations.CATMULLROM),
												new Keyframe(3.29F, KeyframeAnimations.degreeVec(-86.0666F, -9.0866F, -17.8924F), AnimationChannel.Interpolations.CATMULLROM),
													new Keyframe(3.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), 
			new Keyframe(0.625F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), 
				new Keyframe(0.95F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.20F, KeyframeAnimations.degreeVec(64.8109F, -6.7938F, 3.1846F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.54F, KeyframeAnimations.degreeVec(64.8109F, -6.7938F, 3.1846F), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.75F, KeyframeAnimations.degreeVec(7.6654F, 28.5474F, -12.7325F), AnimationChannel.Interpolations.LINEAR),
								new Keyframe(2.29F, KeyframeAnimations.degreeVec(7.6654F, 28.5474F, -12.7325F), AnimationChannel.Interpolations.CATMULLROM),
									new Keyframe(2.54F, KeyframeAnimations.degreeVec(146.9411F, -52.2702F, 25.6135F), AnimationChannel.Interpolations.CATMULLROM),
										new Keyframe(2.79F, KeyframeAnimations.degreeVec(77.0103F, -14.6355F, 67.1855F), AnimationChannel.Interpolations.CATMULLROM),
											new Keyframe(3.29F, KeyframeAnimations.degreeVec(77.0103F, -14.6355F, 67.1855F), AnimationChannel.Interpolations.CATMULLROM),
												new Keyframe(3.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("rightarmFist", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), 
			new Keyframe(0.95F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), 
				new Keyframe(1.20F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 52.5F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.54F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 52.5F), AnimationChannel.Interpolations.LINEAR),
						new Keyframe(1.75F, KeyframeAnimations.degreeVec(75.0F, 0.0F, 52.5F), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.29F, KeyframeAnimations.degreeVec(75.0F, 0.0F, 52.5F), AnimationChannel.Interpolations.CATMULLROM),
								new Keyframe(2.54F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
									new Keyframe(2.79F, KeyframeAnimations.degreeVec(28.4654F, 5.8237F, 82.3868F), AnimationChannel.Interpolations.CATMULLROM),
										new Keyframe(3.29F, KeyframeAnimations.degreeVec(28.4654F, 5.8237F, 82.3868F), AnimationChannel.Interpolations.CATMULLROM),
											new Keyframe(3.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), 
			new Keyframe(0.625F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), 
				new Keyframe(0.95F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.20F, KeyframeAnimations.degreeVec(62.1392F, 8.8604F, -4.6547F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.54F, KeyframeAnimations.degreeVec(62.1392F, 8.8604F, -4.6547F), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.75F, KeyframeAnimations.degreeVec(7.6654F, -28.5474F, 12.7325F), AnimationChannel.Interpolations.LINEAR),
								new Keyframe(2.29F, KeyframeAnimations.degreeVec(7.6654F, -28.5474F, 12.7325F), AnimationChannel.Interpolations.CATMULLROM),
									new Keyframe(2.54F, KeyframeAnimations.degreeVec(7.6654F, -28.5474F, 12.7325F), AnimationChannel.Interpolations.CATMULLROM),
										new Keyframe(2.79F, KeyframeAnimations.degreeVec(-27.7337F, -16.3918F, 45.5112F), AnimationChannel.Interpolations.CATMULLROM),
											new Keyframe(3.29F, KeyframeAnimations.degreeVec(-27.7337F, -16.3918F, 45.5112F), AnimationChannel.Interpolations.CATMULLROM),
												new Keyframe(3.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("rightarmFist2", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), 
			new Keyframe(0.95F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), 
				new Keyframe(1.20F, KeyframeAnimations.degreeVec(-31.2325F, 16.6658F, 25.3112F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.54F, KeyframeAnimations.degreeVec(-31.2325F, 16.6658F, 25.3112F), AnimationChannel.Interpolations.LINEAR),
						new Keyframe(1.75F, KeyframeAnimations.degreeVec(-75.0F, 0.0F, 52.5F), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.29F, KeyframeAnimations.degreeVec(-75.0F, 0.0F, 52.5F), AnimationChannel.Interpolations.CATMULLROM),
								new Keyframe(2.54F, KeyframeAnimations.degreeVec(-75.0F, 0.0F, 52.5F), AnimationChannel.Interpolations.CATMULLROM),
									new Keyframe(2.79F, KeyframeAnimations.degreeVec(-80.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
										new Keyframe(3.29F, KeyframeAnimations.degreeVec(-80.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
											new Keyframe(3.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(0.5F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
					new Keyframe(0.625F, KeyframeAnimations.degreeVec(-3.51F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.875F, KeyframeAnimations.degreeVec(22.15F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.54F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
								new Keyframe(1.70F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
									new Keyframe(1.91F, KeyframeAnimations.degreeVec(5.9153F, -19.291F, -5.3815F), AnimationChannel.Interpolations.CATMULLROM), 
										new Keyframe(2.12F, KeyframeAnimations.degreeVec(13.5657F, 22.9975F, -1.0437F), AnimationChannel.Interpolations.CATMULLROM),
											new Keyframe(2.33F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), 
				new Keyframe(2.29F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), 
						new Keyframe(2.54F, KeyframeAnimations.degreeVec(55.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), 
							new Keyframe(2.79F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)))
	.addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION, 
		new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 4.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
				new Keyframe(0.625F, KeyframeAnimations.posVec(0.0F, 0.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.12F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM))).build();
	
	public static final AnimationDefinition REVIVE = AnimationDefinition.Builder.withLength(4.5F)
	.addAnimation("zouhanshin", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(1.91F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(2.12F, KeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(3.0F, KeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
						new Keyframe(3.37F, KeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(3.54F, KeyframeAnimations.degreeVec(-57.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
								new Keyframe(4.0F, KeyframeAnimations.degreeVec(-55.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
									new Keyframe(4.50F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("zouhanshin", new AnimationChannel(AnimationChannel.Targets.POSITION, 
			new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
				new Keyframe(1.91F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(2.12F, KeyframeAnimations.posVec(0.0F, -10.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
						new Keyframe(3.37F, KeyframeAnimations.posVec(0.0F, -10.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3.62F, KeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
								new Keyframe(4.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)))
	.addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(1.91F, KeyframeAnimations.degreeVec(27.7312F, 24.7391F, 12.4075F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(2.21F, KeyframeAnimations.degreeVec(25.0F, 24.7391F, 0.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(3.0F, KeyframeAnimations.degreeVec(25.0F, 24.7391F, 0.0F), AnimationChannel.Interpolations.LINEAR),
						new Keyframe(3.37F, KeyframeAnimations.degreeVec(-11.7643F, -39.3284F, 11.7391F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(3.58F, KeyframeAnimations.degreeVec(56.2401F, -13.7023F, -10.967F), AnimationChannel.Interpolations.CATMULLROM),
								new Keyframe(4.0F, KeyframeAnimations.degreeVec(56.2401F, -13.7023F, -10.967F), AnimationChannel.Interpolations.CATMULLROM),
									new Keyframe(4.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("rightarmFist", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.91F, KeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.0F, KeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
						new Keyframe(3.37F, KeyframeAnimations.degreeVec(97.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(3.62F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	//.addAnimation("arm", new AnimationChannel(AnimationChannel.Targets.SCALE, new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 0.6F, 1.0F), AnimationChannel.Interpolations.LINEAR)))
	.addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(1.91F, KeyframeAnimations.degreeVec(25.0F, -24.7391F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(2.21F, KeyframeAnimations.degreeVec(25.0F, -24.7391F, 0.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(3.0F, KeyframeAnimations.degreeVec(25.0F, -24.7391F, 0.0F), AnimationChannel.Interpolations.LINEAR),
						new Keyframe(3.41F, KeyframeAnimations.degreeVec(25.0F, -24.7391F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(3.7F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("rightarmFist2", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.91F, KeyframeAnimations.degreeVec(-45.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.0F, KeyframeAnimations.degreeVec(-45.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
						new Keyframe(3.37F, KeyframeAnimations.degreeVec(-45.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3.7F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	//.addAnimation("arm2", new AnimationChannel(AnimationChannel.Targets.SCALE, new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 0.6F, 1.0F), AnimationChannel.Interpolations.LINEAR)))
	.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(0.25F, KeyframeAnimations.degreeVec(20.1587F, 7.0453F, 2.5782F), AnimationChannel.Interpolations.CATMULLROM), 
					new Keyframe(0.45F, KeyframeAnimations.degreeVec(37.7959F, -28.0243F, -11.1702F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.75F, KeyframeAnimations.degreeVec(38.4899F, 11.3535F, 16.2723F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.5F, KeyframeAnimations.degreeVec(37.6447F, -2.4651F, 5.4756F), AnimationChannel.Interpolations.CATMULLROM),
								new Keyframe(1.91F, KeyframeAnimations.degreeVec(37.6447F, -2.4651F, 5.4756F), AnimationChannel.Interpolations.CATMULLROM),
									new Keyframe(2.12F, KeyframeAnimations.degreeVec(-44.8553F, -2.4651F, 5.4756F), AnimationChannel.Interpolations.LINEAR), 
										new Keyframe(3.0F, KeyframeAnimations.degreeVec(-44.8553F, -2.4651F, 5.4756F), AnimationChannel.Interpolations.LINEAR),
											new Keyframe(3.70F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), 
				new Keyframe(1.91F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), 
					new Keyframe(2.12F, KeyframeAnimations.degreeVec(53.682F, -15.1503F, 7.83F), AnimationChannel.Interpolations.LINEAR),
						new Keyframe(3.41F, KeyframeAnimations.degreeVec(53.682F, -15.1503F, 7.83F), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3.70F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)))
	.addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION, 
			new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
				new Keyframe(1.91F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(2.12F, KeyframeAnimations.posVec(0.0F, -10.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
						new Keyframe(3.37F, KeyframeAnimations.posVec(0.0F, -10.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3.62F, KeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
								new Keyframe(4.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)))
	.addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), 
			new Keyframe(1.91F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), 
				new Keyframe(2.12F, KeyframeAnimations.degreeVec(44.5615F, 7.053F, -7.1071F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(3.0F, KeyframeAnimations.degreeVec(44.5615F, 7.053F, -7.1071F), AnimationChannel.Interpolations.LINEAR),
						new Keyframe(3.37F, KeyframeAnimations.degreeVec(35.2644F, -30.0F, 35.2644F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(3.66F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION, 
			new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
				new Keyframe(1.91F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(2.12F, KeyframeAnimations.posVec(0.0F, -10.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
						new Keyframe(3.37F, KeyframeAnimations.posVec(0.0F, -10.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3.62F, KeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
								new Keyframe(4.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)))
	.addAnimation("root", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
				new Keyframe(1.91F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(2.12F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
						new Keyframe(3.62F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(4.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)))
	.addAnimation("root", new AnimationChannel(AnimationChannel.Targets.POSITION, 
			new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
				new Keyframe(1.91F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(2.12F, KeyframeAnimations.posVec(0.0F, -10.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
						new Keyframe(3.37F, KeyframeAnimations.posVec(0.0F, -10.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3.62F, KeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
								new Keyframe(4.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR))).build();

	public static final AnimationDefinition STOMP = AnimationDefinition.Builder.withLength(1.5F)
	.addAnimation("zouhanshin", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(1.0F, KeyframeAnimations.degreeVec(-0.76F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.12F, KeyframeAnimations.degreeVec(-20.97F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.33F, KeyframeAnimations.degreeVec(-20.97F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(1.0F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.3F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("rightarmFist", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(1.0F, KeyframeAnimations.degreeVec(35.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.3F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(1.0F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.3F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("rightarmFist2", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(1.0F, KeyframeAnimations.degreeVec(-35.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.3F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(1.0F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.12F, KeyframeAnimations.degreeVec(-3.51F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.37F, KeyframeAnimations.degreeVec(22.15F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(1.0F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.12F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION, 
		new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 4.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.12F, KeyframeAnimations.posVec(0.0F, 0.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM))).build();

	public static final AnimationDefinition BEAM = AnimationDefinition.Builder.withLength(4.0F)
	.addAnimation("zouhanshin", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.5F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(0.625F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.25F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						//new Keyframe(1.5F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.5F, KeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
								new Keyframe(2.5F, KeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
									new Keyframe(2.75F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
										new Keyframe(3.25F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
											new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.3F, KeyframeAnimations.degreeVec(39.52F, 0.0F, -50.88F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(0.625F, KeyframeAnimations.degreeVec(76.7396F, -22.2161F, -57.2271F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.25F, KeyframeAnimations.degreeVec(76.7396F, -22.2161F, -57.2271F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.5F, KeyframeAnimations.degreeVec(4.187F, -25.8785F, -32.8798F), AnimationChannel.Interpolations.CATMULLROM),
							//new Keyframe(1.5F, KeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
								new Keyframe(2.5F, KeyframeAnimations.degreeVec(4.187F, -25.8785F, -32.8798F), AnimationChannel.Interpolations.CATMULLROM),
									new Keyframe(2.75F, KeyframeAnimations.degreeVec(-23.6813F, -19.0436F, -12.5068F), AnimationChannel.Interpolations.CATMULLROM),
										new Keyframe(3.25F, KeyframeAnimations.degreeVec(-23.6813F, -19.0436F, -12.5068F), AnimationChannel.Interpolations.CATMULLROM),
											new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("rightarmFist", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.3F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(0.625F, KeyframeAnimations.degreeVec(37.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.5F, KeyframeAnimations.degreeVec(37.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.75F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(3.25F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
								new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.3F, KeyframeAnimations.degreeVec(39.52F, 0.0F, 50.88F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(0.625F, KeyframeAnimations.degreeVec(74.2396F, 22.2161F, 57.2271F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.25F, KeyframeAnimations.degreeVec(74.2396F, 22.2161F, 57.2271F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.5F, KeyframeAnimations.degreeVec(4.187F, 25.8785F, 32.8798F), AnimationChannel.Interpolations.CATMULLROM),
							//new Keyframe(1.5F, KeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
								new Keyframe(2.5F, KeyframeAnimations.degreeVec(4.187F, 25.8785F, 32.8798F), AnimationChannel.Interpolations.CATMULLROM),
									new Keyframe(2.75F, KeyframeAnimations.degreeVec(-33.6684F, 13.2971F, 9.8674F), AnimationChannel.Interpolations.CATMULLROM),
										new Keyframe(3.25F, KeyframeAnimations.degreeVec(-33.6684F, 13.2971F, 9.8674F), AnimationChannel.Interpolations.CATMULLROM),
											new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("rightarmFist2", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.3F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(0.625F, KeyframeAnimations.degreeVec(-37.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.5F, KeyframeAnimations.degreeVec(-37.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.75F, KeyframeAnimations.degreeVec(-10.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(3.25F, KeyframeAnimations.degreeVec(-10.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
								new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			//new Keyframe(0.3F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.5F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.75F, KeyframeAnimations.degreeVec(47.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(3.25F, KeyframeAnimations.degreeVec(47.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
								new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.3F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(0.625F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
						/*new Keyframe(2.75F, KeyframeAnimations.degreeVec(-10.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(3.25F, KeyframeAnimations.degreeVec(-10.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
								new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)*/))
	.addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.3F, KeyframeAnimations.posVec(0.0F, 3.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(0.625F, KeyframeAnimations.posVec(0.0F, 0.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.75F, KeyframeAnimations.posVec(0.0F, 0.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(3.25F, KeyframeAnimations.posVec(0.0F, 0.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
								new Keyframe(4.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM))).build();
	
	public static final AnimationDefinition DEATH = AnimationDefinition.Builder.withLength(5.0F)
	.addAnimation("zouhanshin", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.3F, KeyframeAnimations.degreeVec(0.0F, 7.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, -7.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.8F, KeyframeAnimations.degreeVec(0.0F, 7.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, -7.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
								new Keyframe(2.29F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
									new Keyframe(2.54F, KeyframeAnimations.degreeVec(-57.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("zouhanshin", new AnimationChannel(AnimationChannel.Targets.POSITION, 
		new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(1.75F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
				new Keyframe(1.91F, KeyframeAnimations.posVec(0.0F, -11.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
								new Keyframe(2.29F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
									new Keyframe(2.54F, KeyframeAnimations.degreeVec(-57.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("rightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.5F, KeyframeAnimations.degreeVec(13.9703F, 24.0929F, 6.8817F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.75F, KeyframeAnimations.degreeVec(13.9703F, 24.0929F, 6.8817F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.91F, KeyframeAnimations.degreeVec(51.4703F, 24.0929F, 6.8817F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.29F, KeyframeAnimations.degreeVec(51.4703F, 24.0929F, 6.8817F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.54F, KeyframeAnimations.degreeVec(111.4703F, 24.0929F, 6.8817F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("rightarmFist", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(0.5F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("leftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(0.5F, KeyframeAnimations.degreeVec(13.9703F, -24.0929F, 6.8817F), AnimationChannel.Interpolations.CATMULLROM), 
					new Keyframe(1.75F, KeyframeAnimations.degreeVec(13.9703F, -24.0929F, 6.8817F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.91F, KeyframeAnimations.degreeVec(43.9703F, -24.0929F, 6.8817F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.29F, KeyframeAnimations.degreeVec(43.9703F, -24.0929F, 6.8817F), AnimationChannel.Interpolations.CATMULLROM),
								new Keyframe(2.54F, KeyframeAnimations.degreeVec(108.9703F, -24.0929F, 6.8817F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("rightarmFist2", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(0.5F, KeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(0.3F, KeyframeAnimations.degreeVec(0.0F, -7.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 7.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.8F, KeyframeAnimations.degreeVec(0.0F, -7.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, -7.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
								new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
									new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
										new Keyframe(2.29F, KeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
											new Keyframe(2.54F, KeyframeAnimations.degreeVec(-32.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), 
				new Keyframe(1.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), 
					new Keyframe(1.91F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)))
	.addAnimation("rightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION, 
		new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(1.75F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
				new Keyframe(1.91F, KeyframeAnimations.posVec(0.0F, -11.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), 
				new Keyframe(1.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), 
					new Keyframe(1.91F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)))
	.addAnimation("leftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION, 
		new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(1.75F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
				new Keyframe(1.91F, KeyframeAnimations.posVec(0.0F, -11.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	/*.addAnimation("arm", new AnimationChannel(AnimationChannel.Targets.SCALE, new Keyframe(0.0F, KeyframeAnimations.degreeVec(1.0F, 0.6F, 1.0F), AnimationChannel.Interpolations.LINEAR)))
	.addAnimation("arm2", new AnimationChannel(AnimationChannel.Targets.SCALE, new Keyframe(0.0F, KeyframeAnimations.degreeVec(1.0F, 0.6F, 1.0F), AnimationChannel.Interpolations.LINEAR)))*/.build();
	
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		new BasaltGuardianAnimation();
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

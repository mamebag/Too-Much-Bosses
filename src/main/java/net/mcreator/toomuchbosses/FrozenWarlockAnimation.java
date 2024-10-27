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
public class FrozenWarlockAnimation {

public static final AnimationDefinition ICE_WALL_FRONT = AnimationDefinition.Builder.withLength(2.17F)
	.addAnimation("UpperBody", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(1.375F, KeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.5F, KeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0F, KeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.17F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("LeftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.75F, KeyframeAnimations.degreeVec(-0.1128F, -0.041F, -20.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.25F, KeyframeAnimations.degreeVec(-0.1128F, -0.041F, -20.0F), AnimationChannel.Interpolations.CATMULLROM), 
					new Keyframe(1.375F, KeyframeAnimations.degreeVec(29.8872F, -0.041F, -20.0F), AnimationChannel.Interpolations.CATMULLROM), 
						new Keyframe(1.875F, KeyframeAnimations.degreeVec(-0.1128F, -0.041F, -20.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.17F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("LeftArmLower", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.75F, KeyframeAnimations.degreeVec(-37.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.25F, KeyframeAnimations.degreeVec(-37.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
					new Keyframe(1.375F, KeyframeAnimations.degreeVec(-37.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
						new Keyframe(1.875F, KeyframeAnimations.degreeVec(-37.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.17F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("Head", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			//new Keyframe(0.75F, KeyframeAnimations.degreeVec(-37.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.25F, KeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
					new Keyframe(1.375F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
						new Keyframe(1.875F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.17F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("RightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.75F, KeyframeAnimations.degreeVec(50.0F, 0.0F, 52.5F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.25F, KeyframeAnimations.degreeVec(50.0F, 0.0F, 52.5F), AnimationChannel.Interpolations.CATMULLROM), 
					new Keyframe(1.375F, KeyframeAnimations.degreeVec(-87.5F, 0.0F, 52.5F), AnimationChannel.Interpolations.CATMULLROM), 
						new Keyframe(1.875F, KeyframeAnimations.degreeVec(-87.5F, 0.0F, 52.5F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.17F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("RightArmLower", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.75F, KeyframeAnimations.degreeVec(-105.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.25F, KeyframeAnimations.degreeVec(-105.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
					new Keyframe(1.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 17.5F), AnimationChannel.Interpolations.CATMULLROM), 
						new Keyframe(1.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 17.5F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.17F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("RightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.75F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.25F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
					new Keyframe(1.375F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
						new Keyframe(1.875F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.17F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("RightLegLower", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.75F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.25F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
					new Keyframe(1.375F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
						new Keyframe(1.875F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.17F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM))).build();

public static final AnimationDefinition ICE_WALL_FRONT_BIGGER = AnimationDefinition.Builder.withLength(3.0F)
	.addAnimation("UpperBody", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(1.0F, KeyframeAnimations.degreeVec(-12.5F, -45.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.5F, KeyframeAnimations.degreeVec(-12.5F, -45.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.66F, KeyframeAnimations.degreeVec(27.5F, -45.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.25F, KeyframeAnimations.degreeVec(27.5F, -45.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(3.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("LeftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(1.0F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.5F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.66F, KeyframeAnimations.degreeVec(51.7933F, 7.3556F, -47.0628F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.25F, KeyframeAnimations.degreeVec(51.7933F, 7.3556F, -47.0628F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(3.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("LeftArmLower", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(1.0F, KeyframeAnimations.degreeVec(-45.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.5F, KeyframeAnimations.degreeVec(-45.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.66F, KeyframeAnimations.degreeVec(-45.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.25F, KeyframeAnimations.degreeVec(-45.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(3.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("Head", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(1.0F, KeyframeAnimations.degreeVec(15.4501F, 45.713F, 14.344F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.5F, KeyframeAnimations.degreeVec(15.4501F, 45.713F, 14.344F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.66F, KeyframeAnimations.degreeVec(46.522F, 21.3677F, 7.4002F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.25F, KeyframeAnimations.degreeVec(46.522F, 21.3677F, 7.4002F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(3.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("RightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(1.0F, KeyframeAnimations.degreeVec(48.187F, 19.0921F, 32.9092F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.5F, KeyframeAnimations.degreeVec(48.187F, 19.0921F, 32.9092F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.66F, KeyframeAnimations.degreeVec(80.7124F, 5.748F, 44.5336F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.25F, KeyframeAnimations.degreeVec(80.7124F, 5.748F, 44.5336F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(3.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("RightArmLower", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(1.0F, KeyframeAnimations.degreeVec(-50.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.5F, KeyframeAnimations.degreeVec(-50.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					//new Keyframe(1.66F, KeyframeAnimations.degreeVec(27.5F, -45.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.25F, KeyframeAnimations.degreeVec(-50.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(3.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("RightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(1.0F, KeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.5F, KeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					//new Keyframe(1.66F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.25F, KeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(3.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("RightLeg", new AnimationChannel(AnimationChannel.Targets.POSITION, 
		new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 2.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 2.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.66F, KeyframeAnimations.posVec(0.0F, -1.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.25F, KeyframeAnimations.posVec(0.0F, -1.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(3.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("RightLegLower", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(1.0F, KeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.5F, KeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					//new Keyframe(1.66F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.25F, KeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(3.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM))).build();

public static final AnimationDefinition EVERFROST = AnimationDefinition.Builder.withLength(2.0F)
	.addAnimation("LeftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.75F, KeyframeAnimations.degreeVec(-80.8696F, 34.6575F, 5.2221F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.25F, KeyframeAnimations.degreeVec(-80.8696F, 34.6575F, 5.2221F), AnimationChannel.Interpolations.CATMULLROM), 
					new Keyframe(1.46F, KeyframeAnimations.degreeVec(0.0F, -5.0F, -90.0F), AnimationChannel.Interpolations.CATMULLROM), 
						new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("LeftArmLower", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.75F, KeyframeAnimations.degreeVec(-17.5F, 0.0F, 55.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.25F, KeyframeAnimations.degreeVec(-17.5F, 0.0F, 55.0F), AnimationChannel.Interpolations.CATMULLROM), 
					new Keyframe(1.46F, KeyframeAnimations.degreeVec(-8.6538F, 2.202F, -6.4966F), AnimationChannel.Interpolations.CATMULLROM), 
						new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("RightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.75F, KeyframeAnimations.degreeVec(-44.2349F, -24.7716F, -3.483F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.25F, KeyframeAnimations.degreeVec(-44.2349F, -24.7716F, -3.483F), AnimationChannel.Interpolations.CATMULLROM), 
					new Keyframe(1.46F, KeyframeAnimations.degreeVec(6.7166F, 4.2916F, 86.4119F), AnimationChannel.Interpolations.CATMULLROM), 
						new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("RightArmLower", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.75F, KeyframeAnimations.degreeVec(-18.2561F, -8.3109F, -23.6624F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.25F, KeyframeAnimations.degreeVec(-18.2561F, -8.3109F, -23.6624F), AnimationChannel.Interpolations.CATMULLROM), 
					new Keyframe(1.46F, KeyframeAnimations.degreeVec(-19.9299F, 1.7082F, 4.6999F), AnimationChannel.Interpolations.CATMULLROM), 
						new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM))).build();

public static final AnimationDefinition ICE_TRAP = AnimationDefinition.Builder.withLength(2.0F)
	.addAnimation("LeftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.5F, KeyframeAnimations.degreeVec(6.4524F, -25.7372F, -37.1432F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.125F, KeyframeAnimations.degreeVec(6.4524F, -25.7372F, -37.1432F), AnimationChannel.Interpolations.CATMULLROM), 
					new Keyframe(1.25F, KeyframeAnimations.degreeVec(-142.4655F, 3.7064F, -21.3954F), AnimationChannel.Interpolations.CATMULLROM), 
						new Keyframe(1.75F, KeyframeAnimations.degreeVec(-142.4655F, 3.7064F, -21.3954F), AnimationChannel.Interpolations.CATMULLROM), 
							new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("LeftArmLower", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.5F, KeyframeAnimations.degreeVec(-45.0F, 0.0F, 37.5F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.125F, KeyframeAnimations.degreeVec(-45.0F, 0.0F, 37.5F), AnimationChannel.Interpolations.CATMULLROM), 
					new Keyframe(1.25F, KeyframeAnimations.degreeVec(-22.682F, -0.5686F, 7.4294F), AnimationChannel.Interpolations.CATMULLROM), 
						new Keyframe(1.75F, KeyframeAnimations.degreeVec(-22.682F, -0.5686F, 7.4294F), AnimationChannel.Interpolations.CATMULLROM), 
							new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("RightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.5F, KeyframeAnimations.degreeVec(-63.0307F, 47.8318F,23.8064F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.125F, KeyframeAnimations.degreeVec(-63.0307F, 47.8318F,23.8064F), AnimationChannel.Interpolations.CATMULLROM), 
					new Keyframe(1.25F, KeyframeAnimations.degreeVec(-33.4161F, -10.749F, -8.4806F), AnimationChannel.Interpolations.CATMULLROM), 
						new Keyframe(1.75F, KeyframeAnimations.degreeVec(-33.4161F, -10.749F, -8.4806F), AnimationChannel.Interpolations.CATMULLROM), 
							new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("RightArmLower", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.5F, KeyframeAnimations.degreeVec(-70.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.125F, KeyframeAnimations.degreeVec(-70.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
					new Keyframe(1.25F, KeyframeAnimations.degreeVec(-10.2838F, -14.24F, -17.6045F), AnimationChannel.Interpolations.CATMULLROM), 
						new Keyframe(1.75F, KeyframeAnimations.degreeVec(-10.2838F, -14.24F, -17.6045F), AnimationChannel.Interpolations.CATMULLROM), 
							new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("UpperBody", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.5F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.125F, KeyframeAnimations.degreeVec(17.5F,  0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
					new Keyframe(1.25F, KeyframeAnimations.degreeVec(-2.5F,  0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
						new Keyframe(1.75F, KeyframeAnimations.degreeVec(-2.5F,  0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
							new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("Head", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.5F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.125F, KeyframeAnimations.degreeVec(15.0F,  0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
					new Keyframe(1.25F, KeyframeAnimations.degreeVec(-27.8976F,  0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
						new Keyframe(1.75F, KeyframeAnimations.degreeVec(-27.8976F,  0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
							new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM))).build();

public static final AnimationDefinition ICE_TOWER = AnimationDefinition.Builder.withLength(2.25F)
	.addAnimation("LeftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.75F, KeyframeAnimations.degreeVec(-60.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.5F, KeyframeAnimations.degreeVec(-60.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
					new Keyframe(1.61F, KeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
						new Keyframe(2.0F, KeyframeAnimations.degreeVec(40.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
							new Keyframe(2.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("LeftArmLower", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.75F, KeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.5F, KeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
					new Keyframe(1.61F, KeyframeAnimations.degreeVec(-95.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
						new Keyframe(2.0F, KeyframeAnimations.degreeVec(-95.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
							new Keyframe(2.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("RightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.75F, KeyframeAnimations.degreeVec(65.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.5F, KeyframeAnimations.degreeVec(65.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
					new Keyframe(1.61F, KeyframeAnimations.degreeVec(-127.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
						new Keyframe(2.0F, KeyframeAnimations.degreeVec(-127.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
							new Keyframe(2.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("RightArmLower", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.75F, KeyframeAnimations.degreeVec(-65.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.5F, KeyframeAnimations.degreeVec(-65.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
					new Keyframe(1.61F, KeyframeAnimations.degreeVec(-40.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
						new Keyframe(2.0F, KeyframeAnimations.degreeVec(-40.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
							new Keyframe(2.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("UpperBody", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.75F, KeyframeAnimations.degreeVec(52.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.5F, KeyframeAnimations.degreeVec(52.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
					new Keyframe(1.61F, KeyframeAnimations.degreeVec(-19.5684F, -26.128F, 8.8967F), AnimationChannel.Interpolations.CATMULLROM), 
						new Keyframe(2.0F, KeyframeAnimations.degreeVec(-19.5684F, -26.128F, 8.8967F), AnimationChannel.Interpolations.CATMULLROM), 
							new Keyframe(2.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("Head", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.75F, KeyframeAnimations.degreeVec(37.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.5F, KeyframeAnimations.degreeVec(37.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
					new Keyframe(1.61F, KeyframeAnimations.degreeVec(2.8861F, 29.9685F, 1.4426F), AnimationChannel.Interpolations.CATMULLROM), 
						new Keyframe(2.0F, KeyframeAnimations.degreeVec(2.8861F, 29.9685F, 1.4426F), AnimationChannel.Interpolations.CATMULLROM), 
							new Keyframe(2.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM))).build();

public static final AnimationDefinition WATER_POTION = AnimationDefinition.Builder.withLength(2.0F)
	.addAnimation("LeftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.75F, KeyframeAnimations.degreeVec(-50.7685F, 37.7612F, 26.5651F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.25F, KeyframeAnimations.degreeVec(-50.7685F, 37.7612F, 26.5651F), AnimationChannel.Interpolations.CATMULLROM), 
					new Keyframe(1.5F, KeyframeAnimations.degreeVec(26.9498F, -57.7252F, -66.088F), AnimationChannel.Interpolations.CATMULLROM), 
						new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("LeftArmLower", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.75F, KeyframeAnimations.degreeVec(-8.4268F, 25.4967F, 28.4835F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.25F, KeyframeAnimations.degreeVec(-8.4268F, 25.4967F, 28.4835F), AnimationChannel.Interpolations.CATMULLROM), 
					new Keyframe(1.5F, KeyframeAnimations.degreeVec(-108.1976F, 3.0334F, 92.1495F), AnimationChannel.Interpolations.CATMULLROM), 
						new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("RightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.75F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 22.5F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.25F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 22.5F), AnimationChannel.Interpolations.CATMULLROM), 
					new Keyframe(1.5F, KeyframeAnimations.degreeVec(-45.0F, 0.0F, 22.5F), AnimationChannel.Interpolations.CATMULLROM), 
						new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("UpperBody", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.75F, KeyframeAnimations.degreeVec(15.0F, 20.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.25F, KeyframeAnimations.degreeVec(15.0F, 20.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
					new Keyframe(1.5F, KeyframeAnimations.degreeVec(14.8827F, -18.7499F, -10.1188F), AnimationChannel.Interpolations.CATMULLROM), 
						new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM))).build();

public static final AnimationDefinition ICE_RUSH = AnimationDefinition.Builder.withLength(3.25F)
	.addAnimation("UpperBody", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.5F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(0.75F, KeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.79F, KeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.04F, KeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.79F, KeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
								new Keyframe(3.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("LeftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.5F, KeyframeAnimations.degreeVec(-22.3912F, -5.0203F, -17.2526F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(0.75F, KeyframeAnimations.degreeVec(-31.2822F, 9.298F, 14.8915F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.79F, KeyframeAnimations.degreeVec(-31.2822F, 9.298F, 14.8915F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.04F, KeyframeAnimations.degreeVec(40.2948F, -55.3274F, -60.6175F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.79F, KeyframeAnimations.degreeVec(40.2948F, -55.3274F, -60.6175F), AnimationChannel.Interpolations.CATMULLROM),
								new Keyframe(3.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("LeftArmLower", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(0.75F, KeyframeAnimations.degreeVec(-20.0F, 0.0F, 35.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.79F, KeyframeAnimations.degreeVec(-20.0F, 0.0F, 35.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.04F, KeyframeAnimations.degreeVec(-20.0F, 0.0F, 35.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.79F, KeyframeAnimations.degreeVec(-20.0F, 0.0F, 35.0F), AnimationChannel.Interpolations.CATMULLROM),
								new Keyframe(3.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("Head", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.37F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(0.75F, KeyframeAnimations.degreeVec(32.5F, 0.0F, 35.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.79F, KeyframeAnimations.degreeVec(32.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.04F, KeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.79F, KeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
								new Keyframe(3.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("RightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.5F, KeyframeAnimations.degreeVec(-22.3912F, 5.0203F, 17.2526F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(0.75F, KeyframeAnimations.degreeVec(-31.2822F, -9.298F, -14.8915F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.79F, KeyframeAnimations.degreeVec(-31.2822F, -9.298F, -14.8915F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.04F, KeyframeAnimations.degreeVec(40.2948F, 55.3274F, 60.6175F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.79F, KeyframeAnimations.degreeVec(40.2948F, 55.3274F, 60.6175F), AnimationChannel.Interpolations.CATMULLROM),
								new Keyframe(3.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("RightArmLower", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(0.75F, KeyframeAnimations.degreeVec(-20.0F, 0.0F, -35.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.79F, KeyframeAnimations.degreeVec(-20.0F, 0.0F, -35.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.04F, KeyframeAnimations.degreeVec(-20.0F, 0.0F, -35.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.79F, KeyframeAnimations.degreeVec(-20.0F, 0.0F, -35.0F), AnimationChannel.Interpolations.CATMULLROM),
								new Keyframe(3.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	/*.addAnimation("RightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(0.75F, KeyframeAnimations.degreeVec(-20.0F, 0.0F, -35.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.79F, KeyframeAnimations.degreeVec(-20.0F, 0.0F, -35.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.04F, KeyframeAnimations.degreeVec(-20.0F, 0.0F, -35.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.79F, KeyframeAnimations.degreeVec(-20.0F, 0.0F, -35.0F), AnimationChannel.Interpolations.CATMULLROM),
								new Keyframe(3.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))*/
	.addAnimation("RightLegLower", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(0.75F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.79F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.04F, KeyframeAnimations.degreeVec(42.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.79F, KeyframeAnimations.degreeVec(42.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
								new Keyframe(3.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("LeftLeg", new AnimationChannel(AnimationChannel.Targets.POSITION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.5F, KeyframeAnimations.degreeVec(-42.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(0.75F, KeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.79F, KeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.04F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.79F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
								new Keyframe(3.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("LeftLegLower", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(0.5F, KeyframeAnimations.degreeVec(32.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(0.75F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.79F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.04F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2.79F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
								new Keyframe(3.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM))).build();

public static final AnimationDefinition ICE_CONTROL = AnimationDefinition.Builder.withLength(3.0F)
	.addAnimation("LeftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(1.0F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.25F, KeyframeAnimations.degreeVec(-182.3844F, 0.7515F, 17.4844F), AnimationChannel.Interpolations.CATMULLROM), 
					new Keyframe(1.75F, KeyframeAnimations.degreeVec(-182.3844F, 0.7515F, 17.4844F), AnimationChannel.Interpolations.CATMULLROM), 
						new Keyframe(2.0F, KeyframeAnimations.degreeVec(19.0978F, -10.138F, -7.2711F), AnimationChannel.Interpolations.CATMULLROM), 
							new Keyframe(2.5F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
								new Keyframe(3.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("LeftArmLower", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(1.0F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.25F, KeyframeAnimations.degreeVec(-50.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
					new Keyframe(1.75F, KeyframeAnimations.degreeVec(-50.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
						new Keyframe(2.0F, KeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
							new Keyframe(2.5F, KeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
								new Keyframe(3.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("RightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(1.0F, KeyframeAnimations.degreeVec(-151.1616F, 8.6474F, -15.2727F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.25F, KeyframeAnimations.degreeVec(-189.7099F, 7.4484F, -22.7501F), AnimationChannel.Interpolations.CATMULLROM), 
					new Keyframe(1.75F, KeyframeAnimations.degreeVec(-189.7099F, 7.4484F, -22.7501F), AnimationChannel.Interpolations.CATMULLROM), 
						new Keyframe(2.0F, KeyframeAnimations.degreeVec(-92.3874F, 26.4461F, 1.6829F), AnimationChannel.Interpolations.CATMULLROM), 
							new Keyframe(2.5F, KeyframeAnimations.degreeVec(-92.3874F, 26.4461F, 1.6829F), AnimationChannel.Interpolations.CATMULLROM), 
								new Keyframe(3.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("RightArmLower", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(1.0F, KeyframeAnimations.degreeVec(-35.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.25F, KeyframeAnimations.degreeVec(-40.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
					new Keyframe(1.75F, KeyframeAnimations.degreeVec(-40.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
						new Keyframe(2.0F, KeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
							new Keyframe(2.5F, KeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
								new Keyframe(3.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("UpperBody", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(1.0F, KeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.25F, KeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
					new Keyframe(1.75F, KeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
						new Keyframe(2.0F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
							new Keyframe(2.5F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
								new Keyframe(3.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)))
	.addAnimation("Head", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
		new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
			new Keyframe(1.0F, KeyframeAnimations.degreeVec(-17.08F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
				new Keyframe(1.5F, KeyframeAnimations.degreeVec(15.63F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
					new Keyframe(1.75F, KeyframeAnimations.degreeVec(15.63F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
						new Keyframe(2.0F, KeyframeAnimations.degreeVec(-30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
							new Keyframe(2.5F, KeyframeAnimations.degreeVec(-30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM), 
								new Keyframe(3.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM))).build();

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		new FrozenWarlockAnimation();
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

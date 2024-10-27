/**
 * The code of this mod element is always locked.
 *
 * You can register new events in this class too.
 *
 * If you want to make a plain independent class, create it using
 * Project Browser -> New... and make sure to make the class
 * outside net.poonggi.somebosses as this package is managed by MCreator.
 *
 * If you change workspace package, modid or prefix, you will need
 * to manually adapt this file to these changes or remake it.
 *
 * This class will be added in the mod root package.
*/
package net.mcreator.toomuchbosses;

//import net.mcreator.toomuchbosses.entity.ScreenShakeEntity;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.entity.player.Player;
import net.minecraft.client.Minecraft;

@OnlyIn(Dist.CLIENT)
public class ClientEvent {
	@SubscribeEvent
	public void onCameraSetup(ViewportEvent.ComputeCameraAngles event) {
		/*Player player = Minecraft.getInstance().player;
		float delta = Minecraft.getInstance().getFrameTime();
		float ticksExistedDelta = player.tickCount + delta;
		if (!Minecraft.getInstance().isPaused()) {
			if (player != null) {
				float shakeAmplitude = 0;
				for (ScreenShakeEntity ScreenShake : player.level().getEntitiesOfClass(ScreenShakeEntity.class,
						player.getBoundingBox().inflate(20, 20, 20))) {
					if (ScreenShake.distanceTo(player) < ScreenShake.getRadius()) {
						shakeAmplitude += ScreenShake.getShakeAmount(player, delta);
					}
				}
				if (shakeAmplitude > 1.0f)
					shakeAmplitude = 1.0f;
				event.setPitch((float) (event.getPitch() + shakeAmplitude * Math.cos(ticksExistedDelta * 3 + 2) * 25));
				event.setYaw((float) (event.getYaw() + shakeAmplitude * Math.cos(ticksExistedDelta * 5 + 1) * 25));
				event.setRoll((float) (event.getRoll() + shakeAmplitude * Math.cos(ticksExistedDelta * 4) * 25));
			}
		}*/
	}
}

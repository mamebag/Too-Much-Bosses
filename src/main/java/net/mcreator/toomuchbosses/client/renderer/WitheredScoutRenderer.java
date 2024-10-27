
package net.mcreator.toomuchbosses.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.toomuchbosses.entity.WitheredScoutEntity;
import net.mcreator.toomuchbosses.client.model.Modelwithered_scout;

public class WitheredScoutRenderer extends MobRenderer<WitheredScoutEntity, Modelwithered_scout<WitheredScoutEntity>> {
	public WitheredScoutRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelwithered_scout(context.bakeLayer(Modelwithered_scout.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(WitheredScoutEntity entity) {
		return new ResourceLocation("too_much_bosses:textures/entities/withered_scout.png");
	}
}

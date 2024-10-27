
package net.mcreator.toomuchbosses.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.toomuchbosses.entity.IcePikesEntity;
import net.mcreator.toomuchbosses.client.model.ModelIceSpikes;

public class IcePikesRenderer extends MobRenderer<IcePikesEntity, ModelIceSpikes<IcePikesEntity>> {
	public IcePikesRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelIceSpikes(context.bakeLayer(ModelIceSpikes.LAYER_LOCATION)), 0f);
	}

	@Override
	public ResourceLocation getTextureLocation(IcePikesEntity entity) {
		return new ResourceLocation("too_much_bosses:textures/entities/frosted_ice_layer_0.png");
	}
}

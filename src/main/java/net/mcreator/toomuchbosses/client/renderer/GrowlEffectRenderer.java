
package net.mcreator.toomuchbosses.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.toomuchbosses.entity.GrowlEffectEntity;
import net.mcreator.toomuchbosses.client.model.Modelgrowl_effect;

public class GrowlEffectRenderer extends MobRenderer<GrowlEffectEntity, Modelgrowl_effect<GrowlEffectEntity>> {
	public GrowlEffectRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelgrowl_effect(context.bakeLayer(Modelgrowl_effect.LAYER_LOCATION)), 0f);
	}

	@Override
	public ResourceLocation getTextureLocation(GrowlEffectEntity entity) {
		return new ResourceLocation("too_much_bosses:textures/entities/white_only.png");
	}
}

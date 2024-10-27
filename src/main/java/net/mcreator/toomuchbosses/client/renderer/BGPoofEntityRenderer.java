
package net.mcreator.toomuchbosses.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import net.mcreator.toomuchbosses.entity.BGPoofEntityEntity;

public class BGPoofEntityRenderer extends HumanoidMobRenderer<BGPoofEntityEntity, HumanoidModel<BGPoofEntityEntity>> {
	public BGPoofEntityRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
	}

	@Override
	public ResourceLocation getTextureLocation(BGPoofEntityEntity entity) {
		return new ResourceLocation("too_much_bosses:textures/entities/nothing.png");
	}
}

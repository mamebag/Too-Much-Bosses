
package net.mcreator.toomuchbosses.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.toomuchbosses.entity.BGPillarEntityEntity;
import net.mcreator.toomuchbosses.client.model.Modelbasalt_pillar;

public class BGPillarEntityRenderer extends MobRenderer<BGPillarEntityEntity, Modelbasalt_pillar<BGPillarEntityEntity>> {
	public BGPillarEntityRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelbasalt_pillar(context.bakeLayer(Modelbasalt_pillar.LAYER_LOCATION)), 0f);
	}

	@Override
	public ResourceLocation getTextureLocation(BGPillarEntityEntity entity) {
		return new ResourceLocation("too_much_bosses:textures/entities/nothing.png");
	}
}

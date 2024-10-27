
package net.mcreator.toomuchbosses.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.toomuchbosses.entity.PakuriEntity;
import net.mcreator.toomuchbosses.client.model.Modelwarden_no_pakuri;

public class PakuriRenderer extends MobRenderer<PakuriEntity, Modelwarden_no_pakuri<PakuriEntity>> {
	public PakuriRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelwarden_no_pakuri(context.bakeLayer(Modelwarden_no_pakuri.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(PakuriEntity entity) {
		return new ResourceLocation("too_much_bosses:textures/entities/warden_no_pakuri.png");
	}
}

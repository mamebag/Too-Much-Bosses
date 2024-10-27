
package net.mcreator.toomuchbosses.client.renderer;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EnergySwirlLayer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.EntityModel;

import net.mcreator.toomuchbosses.entity.SpitterEntity;
import net.mcreator.toomuchbosses.client.model.ModelTheBoss;

import com.mojang.math.Axis;
import com.mojang.blaze3d.vertex.PoseStack;


public class SpitterRenderer extends MobRenderer<SpitterEntity, ModelTheBoss<SpitterEntity>> {
	public SpitterRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelTheBoss(context.bakeLayer(ModelTheBoss.LAYER_LOCATION)), 0.5f);
		this.addLayer(new SpitterAuraLayer(this, context.getModelSet()));
	}

	@Override
	public ResourceLocation getTextureLocation(SpitterEntity entity) {
		return new ResourceLocation("too_much_bosses:textures/entities/theboss.png");
	}

	@OnlyIn(Dist.CLIENT)
	class SpitterAuraLayer extends EnergySwirlLayer<SpitterEntity, ModelTheBoss<SpitterEntity>> {
		private static final ResourceLocation POWER_LOCATION = new ResourceLocation("too_much_bosses:textures/entities/thebossauralayer.png");
		private final ModelTheBoss<SpitterEntity> model;

		public SpitterAuraLayer(RenderLayerParent<SpitterEntity, ModelTheBoss<SpitterEntity>> p_174471_,
				EntityModelSet p_174472_) {
			super(p_174471_);
			this.model = new ModelTheBoss<>(p_174472_.bakeLayer(ModelTheBoss.LAYER_LOCATION));
		}

		public void render(PoseStack p_116970_, MultiBufferSource p_116971_, int p_116972_, SpitterEntity p_116973_, float p_116974_,
				float p_116975_, float p_116976_, float p_116977_, float p_116978_, float p_116979_) {
			p_116970_.pushPose();
			p_116970_.scale(1.0f, 1.0f, 1.0f);
			super.render(p_116970_, p_116971_, p_116972_, p_116973_, p_116974_, p_116975_, p_116976_, p_116977_, p_116978_, p_116979_);
			p_116970_.popPose();
		}

		protected float xOffset(float p_116683_) {
			return p_116683_ * 0.001F;
		}

		protected ResourceLocation getTextureLocation() {
			return POWER_LOCATION;
		}

		protected EntityModel<SpitterEntity> model() {
			return this.model;
		}
	}
}

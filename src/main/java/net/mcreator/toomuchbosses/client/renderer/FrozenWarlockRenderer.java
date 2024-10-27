
package net.mcreator.toomuchbosses.client.renderer;

import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.Minecraft;

//import net.mcreator.toomuchbosses.procedures.FrozenWarlockFrozenLayerShowProcedure;
import net.mcreator.toomuchbosses.entity.FrozenWarlockEntity;
import net.mcreator.toomuchbosses.client.model.Modelfrozen_warlock;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class FrozenWarlockRenderer extends MobRenderer<FrozenWarlockEntity, Modelfrozen_warlock<FrozenWarlockEntity>> {
	public FrozenWarlockRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelfrozen_warlock(context.bakeLayer(Modelfrozen_warlock.LAYER_LOCATION)), 0.0f);
		this.addLayer(new RenderLayer<FrozenWarlockEntity, Modelfrozen_warlock<FrozenWarlockEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("too_much_bosses:textures/entities/frosted_ice_layer_0.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, FrozenWarlockEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (entity.getIsFrozen() && entity.breakingTicks < 20) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityTranslucent(LAYER_TEXTURE, true));/*entityCutoutNoCull*///(LAYER_TEXTURE));
					EntityModel model = new Modelfrozen_warlock(Minecraft.getInstance().getEntityModels().bakeLayer(Modelfrozen_warlock.LAYER_LOCATION));
					this.getParentModel().copyPropertiesTo(model);
					model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
					model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
					poseStack.pushPose();
					poseStack.scale(0.8F,0.8F,0.8F);
					poseStack.popPose();
					model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
		this.addLayer(new RenderLayer<FrozenWarlockEntity, Modelfrozen_warlock<FrozenWarlockEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("too_much_bosses:textures/entities/frosted_ice_layer_1.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, FrozenWarlockEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
					poseStack.pushPose();
					poseStack.scale(1.1F,1.1F,1.1F);
					poseStack.popPose();
				if (entity.getIsFrozen() && entity.breakingTicks > 19 && entity.breakingTicks < 60) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityTranslucent(LAYER_TEXTURE, true));/*entityCutoutNoCull*///(LAYER_TEXTURE));
					EntityModel model = new Modelfrozen_warlock(Minecraft.getInstance().getEntityModels().bakeLayer(Modelfrozen_warlock.LAYER_LOCATION));
					this.getParentModel().copyPropertiesTo(model);
					model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
					model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
					poseStack.pushPose();
					poseStack.scale(1.1F,1.1F,1.1F);
					poseStack.popPose();
					model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
					//PoseStack.pushPose();
					//PoseStack.scale(1.2F,1.2F,1.2F);
					//PoseStack.popPose();
				}
			}
		});
		this.addLayer(new RenderLayer<FrozenWarlockEntity, Modelfrozen_warlock<FrozenWarlockEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("too_much_bosses:textures/entities/frosted_ice_layer_2.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, FrozenWarlockEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
					poseStack.pushPose();
					poseStack.scale(1.1F,1.1F,1.1F);
					poseStack.popPose();
				if (entity.getIsFrozen() && entity.breakingTicks > 59 && entity.breakingTicks < 100) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityTranslucent(LAYER_TEXTURE, true));/*entityCutoutNoCull*///(LAYER_TEXTURE));
					EntityModel model = new Modelfrozen_warlock(Minecraft.getInstance().getEntityModels().bakeLayer(Modelfrozen_warlock.LAYER_LOCATION));
					this.getParentModel().copyPropertiesTo(model);
					model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
					model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
					poseStack.pushPose();
					poseStack.scale(1.1F,1.1F,1.1F);
					poseStack.popPose();
					model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
					//PoseStack.pushPose();
					//PoseStack.popPose();
				}
			}
		});
		this.addLayer(new RenderLayer<FrozenWarlockEntity, Modelfrozen_warlock<FrozenWarlockEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("too_much_bosses:textures/entities/frosted_ice_layer_3.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, FrozenWarlockEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
									poseStack.pushPose();
					poseStack.scale(1.1F,1.1F,1.1F);
					poseStack.popPose();
				if (entity.getIsFrozen() && entity.breakingTicks > 99 && entity.breakingTicks < 150) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityTranslucent(LAYER_TEXTURE, true));/*entityCutoutNoCull*///(LAYER_TEXTURE));
					EntityModel model = new Modelfrozen_warlock(Minecraft.getInstance().getEntityModels().bakeLayer(Modelfrozen_warlock.LAYER_LOCATION));
					this.getParentModel().copyPropertiesTo(model);
					model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
					model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
					poseStack.pushPose();
					poseStack.scale(1.1F,1.1F,1.1F);
					poseStack.popPose();
					model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
					//PoseStack.pushPose();
					//PoseStack.popPose();
				}
			}
		});
	}	
	@Override
	public ResourceLocation getTextureLocation(FrozenWarlockEntity entity) {
		return new ResourceLocation("too_much_bosses:textures/entities/frozen_warlock.png");
	}
}

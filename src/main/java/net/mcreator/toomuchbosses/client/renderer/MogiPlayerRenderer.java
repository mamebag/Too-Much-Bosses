
package net.mcreator.toomuchbosses.client.renderer;

//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
//import net.minecraft.client.renderer.entity.EntityRendererProvider;
//import net.minecraft.client.model.geom.ModelLayers;
//import net.minecraft.client.model.HumanoidModel;
//import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ArmedModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.resources.DefaultPlayerSkin;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;


import net.mcreator.toomuchbosses.entity.MogiPlayerEntity;

//public class MogiPlayerRenderer extends HumanoidMobRenderer<MogiPlayerEntity, HumanoidModel<MogiPlayerEntity>> {
public class MogiPlayerRenderer<T extends MogiPlayerEntity> extends MobRenderer<T, PlayerModel<T>> {
	private final PlayerModel<T> normalModel;
	private final PlayerModel<T> slimModel;

	public MogiPlayerRenderer(EntityRendererProvider.Context context) {
		super(context, new PlayerModel<>(context.bakeLayer(ModelLayers.PLAYER), false), 0.0F);
		normalModel = getModel();
		slimModel = new PlayerModel<>(context.bakeLayer(ModelLayers.PLAYER_SLIM), true);
		this.addLayer(new GiantItemInHandLayer<>(this, context.getItemInHandRenderer()));
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
	}

	@Override 
	public void render(T entityIn, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn) {
		if(entityIn.isSprinting()){
			((HumanoidModel) this.getModel()).rightArmPose = HumanoidModel.ArmPose.BOW_AND_ARROW;
			((HumanoidModel) this.getModel()).leftArmPose = HumanoidModel.ArmPose.BOW_AND_ARROW;
		}else{
		if(entityIn.isShiftKeyDown()){
			((HumanoidModel) this.getModel()).rightArmPose = HumanoidModel.ArmPose.BLOCK;
			((HumanoidModel) this.getModel()).leftArmPose = HumanoidModel.ArmPose.BLOCK;
		}else{
			((HumanoidModel) this.getModel()).rightArmPose = HumanoidModel.ArmPose.ITEM;
			((HumanoidModel) this.getModel()).leftArmPose = HumanoidModel.ArmPose.EMPTY;
			}
		}
		super.render(entityIn, entityYaw, partialTicks, poseStack, bufferIn, packedLightIn);
	}
	
	@Override
	public ResourceLocation getTextureLocation(MogiPlayerEntity entity) {
		Minecraft mc = Minecraft.getInstance();
		boolean slim = false;
		ResourceLocation texture = DefaultPlayerSkin.getDefaultSkin();

		if (mc.getCameraEntity() instanceof AbstractClientPlayer client) {
			texture = client.getSkinTextureLocation();
			slim = client.getModelName().equals("slim");
		}

		model = slim ? slimModel : normalModel;
		return texture;
	}

	@Override
	public void scale(T entitylivingbaseIn, PoseStack stack, float partialTickTime) {
		float scale = 1.0F;
		stack.scale(scale, scale, scale);
	}

	//[VanillaCopy] of ItemInHandLayer, changes noted
	public static class GiantItemInHandLayer<T extends LivingEntity, M extends EntityModel<T> & ArmedModel> extends RenderLayer<T, M> {
		private final ItemInHandRenderer handRenderer;

		public GiantItemInHandLayer(RenderLayerParent<T, M> renderer, ItemInHandRenderer handRenderer) {
			super(renderer);
			this.handRenderer = handRenderer;
		}
		public void render(PoseStack stack, MultiBufferSource buffer, int light, T entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
			boolean flag = entity.getMainArm() == HumanoidArm.RIGHT;
			ItemStack itemstack = flag ? entity.getOffhandItem() : entity.getMainHandItem();
			ItemStack itemstack1 = flag ? entity.getMainHandItem() : entity.getOffhandItem();
			if (!itemstack.isEmpty() || !itemstack1.isEmpty()) {
				stack.pushPose();
				if (this.getParentModel().young) {
					stack.translate(0.0D, 0.75D, 0.0D);
					stack.scale(0.5F, 0.5F, 0.5F);
				}

				this.renderArmWithItem(entity, itemstack1, ItemDisplayContext.THIRD_PERSON_RIGHT_HAND, HumanoidArm.RIGHT, stack, buffer, light);
				this.renderArmWithItem(entity, itemstack, ItemDisplayContext.THIRD_PERSON_LEFT_HAND, HumanoidArm.LEFT, stack, buffer, light);
				stack.popPose();
			}
		}

		protected void renderArmWithItem(LivingEntity entity, ItemStack stack, ItemDisplayContext type, HumanoidArm arm, PoseStack ms, MultiBufferSource buffer, int light) {
			if (!stack.isEmpty()) {
				ms.pushPose();
				this.getParentModel().translateToHand(arm, ms);
				ms.mulPose(Axis.XP.rotationDegrees(-90.0F));
				ms.mulPose(Axis.YP.rotationDegrees(180.0F));
				boolean flag = arm == HumanoidArm.LEFT;
				// TF - move item a bit to actually fit in the giant's hand (y and z changes)
				ms.translate((float)(flag ? -1 : 1) / 16.0F, 0.0D, -0.5D);
				// TF - scale items down to accurately match the actual size it would be in a giant's hand
				ms.scale(1.0F, 1.0F, 1.0F);
				this.handRenderer.renderItem(entity, stack, type, flag, ms, buffer, light);
				ms.popPose();
			}
		}
	}
}

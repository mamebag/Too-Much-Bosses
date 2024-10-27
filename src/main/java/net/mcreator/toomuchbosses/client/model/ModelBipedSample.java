package net.mcreator.toomuchbosses.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports
public class ModelBipedSample<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("too_much_bosses", "model_biped_sample"), "main");
	public final ModelPart waist;

	public ModelBipedSample(ModelPart root) {
		this.waist = root.getChild("waist");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition waist = partdefinition.addOrReplaceChild("waist", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition body = waist.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, -24.0F, 0.0F));
		PartDefinition upperBody = body.addOrReplaceChild("upperBody", CubeListBuilder.create().texOffs(16, 16).addBox(-4.0F, -12.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, 0.0F));
		PartDefinition head = upperBody.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -12.0F, 0.0F));
		PartDefinition hat = head.addOrReplaceChild("hat", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition rightArm = upperBody.addOrReplaceChild("rightArm", CubeListBuilder.create(), PartPose.offset(-6.0F, -11.0F, 0.0F));
		PartDefinition rightArm_r1 = rightArm.addOrReplaceChild("rightArm_r1",
				CubeListBuilder.create().texOffs(40, 16).addBox(-9.0F, -24.0F, -1.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(40, 25).addBox(-9.0F, -20.0F, -1.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(7.0F, 23.0F, -1.0F));
		PartDefinition rightArm2 = rightArm_r1.addOrReplaceChild("rightArm2",
				CubeListBuilder.create().texOffs(40, 24).addBox(-2.0F, 2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(40, 26).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-7.0F, -18.0F, 1.0F));
		PartDefinition leftArm = upperBody.addOrReplaceChild("leftArm", CubeListBuilder.create(), PartPose.offset(6.0F, -11.0F, 0.0F));
		PartDefinition rightArm_r2 = leftArm.addOrReplaceChild("rightArm_r2",
				CubeListBuilder.create().texOffs(40, 16).addBox(-9.0F, -24.0F, -1.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(40, 25).addBox(-9.0F, -20.0F, -1.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(7.0F, 23.0F, -1.0F));
		PartDefinition leftArm2 = rightArm_r2.addOrReplaceChild("leftArm2",
				CubeListBuilder.create().texOffs(40, 24).addBox(-2.0F, 2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(40, 26).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-7.0F, -18.0F, 1.0F));
		PartDefinition rightLeg = body.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.9F, 12.0F, 0.0F));
		PartDefinition rightleg2 = rightLeg.addOrReplaceChild("rightleg2", CubeListBuilder.create().texOffs(0, 16).addBox(-1.9F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.1F, 6.0F, 0.0F));
		PartDefinition leftLeg = body.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.1F, 12.0F, 0.0F));
		PartDefinition leftLeg2 = leftLeg.addOrReplaceChild("leftLeg2", CubeListBuilder.create().texOffs(0, 16).addBox(-1.9F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.1F, 6.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		waist.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.waist.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
	}
}

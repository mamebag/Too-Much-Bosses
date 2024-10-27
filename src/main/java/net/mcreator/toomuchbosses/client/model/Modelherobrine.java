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

// Made with Blockbench 4.10.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelherobrine<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("too_much_bosses", "modelherobrine"), "main");
	public final ModelPart all;
	public final ModelPart UpperBody;
	public final ModelPart LeftArm;
	public final ModelPart LeftArmLower;
	public final ModelPart bedrock_left;
	public final ModelPart Head;
	public final ModelPart Body;
	public final ModelPart RightArm;
	public final ModelPart RightArmLower;
	public final ModelPart command_block;
	public final ModelPart bedrock_right;
	public final ModelPart totem;
	public final ModelPart LowerBody;
	public final ModelPart LeftLeg;
	public final ModelPart LeftLegLower;
	public final ModelPart RightLeg;
	public final ModelPart RightLegLower;

	public Modelherobrine(ModelPart root) {
		this.all = root.getChild("all");
		this.UpperBody = root.getChild("UpperBody");
		this.LeftArm = root.getChild("LeftArm");
		this.LeftArmLower = root.getChild("LeftArmLower");
		this.bedrock_left = root.getChild("bedrock_left");
		this.Head = root.getChild("Head");
		this.Body = root.getChild("Body");
		this.RightArm = root.getChild("RightArm");
		this.RightArmLower = root.getChild("RightArmLower");
		this.command_block = root.getChild("command_block");
		this.bedrock_right = root.getChild("bedrock_right");
		this.totem = root.getChild("totem");
		this.LowerBody = root.getChild("LowerBody");
		this.LeftLeg = root.getChild("LeftLeg");
		this.LeftLegLower = root.getChild("LeftLegLower");
		this.RightLeg = root.getChild("RightLeg");
		this.RightLegLower = root.getChild("RightLegLower");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition all = partdefinition.addOrReplaceChild("all", CubeListBuilder.create(), PartPose.offset(5.0F, 2.0F, 0.0F));
		PartDefinition UpperBody = all.addOrReplaceChild("UpperBody", CubeListBuilder.create(), PartPose.offset(-5.0F, 10.0F, 0.0F));
		PartDefinition LeftArm = UpperBody.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(32, 44).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, -10.0F, 0.0F));
		PartDefinition LeftArmLower = LeftArm.addOrReplaceChild("LeftArmLower", CubeListBuilder.create().texOffs(32, 54).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 4.0F, 0.0F));
		PartDefinition bedrock_left = LeftArmLower.addOrReplaceChild("bedrock_left", CubeListBuilder.create().texOffs(0, 65).addBox(-8.0F, -4.0F, -8.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 3.0F, 0.0F));
		PartDefinition cube_r1 = bedrock_left.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 65).addBox(-8.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(9.0F, -4.0F, 0.0F, 0.0F, -1.5708F, 3.1416F));
		PartDefinition cube_r2 = bedrock_left.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 65).addBox(-8.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-7.0F, -4.0F, 0.0F, 0.0F, -1.5708F, 3.1416F));
		PartDefinition cube_r3 = bedrock_left.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 65).addBox(-8.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -4.0F, 7.0F, 3.1416F, 0.0F, 0.0F));
		PartDefinition cube_r4 = bedrock_left.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 65).addBox(-8.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 13.0F, -8.0F, -1.5708F, 0.0F, 0.0F));
		PartDefinition cube_r5 = bedrock_left.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 65).addBox(-8.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -3.0F, -8.0F, -1.5708F, 0.0F, 0.0F));
		PartDefinition Head = UpperBody.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -12.0F, 0.0F));
		PartDefinition Body = UpperBody.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(16, 16).addBox(-4.0F, -8.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));
		PartDefinition RightArm = UpperBody.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(40, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, -10.0F, 0.0F));
		PartDefinition RightArmLower = RightArm.addOrReplaceChild("RightArmLower", CubeListBuilder.create().texOffs(40, 26).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 4.0F, 0.0F));
		PartDefinition command_block = RightArmLower.addOrReplaceChild("command_block", CubeListBuilder.create().texOffs(0, 81).addBox(-8.0F, -4.0F, -8.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 3.0F, 0.0F));
		PartDefinition cube_r6 = command_block.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 81).addBox(-8.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(9.0F, -4.0F, 0.0F, 0.0F, -1.5708F, 3.1416F));
		PartDefinition cube_r7 = command_block.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 81).addBox(-8.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-7.0F, -4.0F, 0.0F, 0.0F, -1.5708F, 3.1416F));
		PartDefinition cube_r8 = command_block.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 81).addBox(-8.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -4.0F, 7.0F, 3.1416F, 0.0F, 0.0F));
		PartDefinition cube_r9 = command_block.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 81).addBox(-8.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 13.0F, -8.0F, -1.5708F, 0.0F, 0.0F));
		PartDefinition cube_r10 = command_block.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 81).addBox(-8.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -3.0F, -8.0F, -1.5708F, 0.0F, 0.0F));
		PartDefinition bedrock_right = RightArmLower.addOrReplaceChild("bedrock_right", CubeListBuilder.create().texOffs(0, 65).addBox(-8.0F, -4.0F, -8.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 3.0F, 0.0F));
		PartDefinition cube_r11 = bedrock_right.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 65).addBox(-8.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(9.0F, -4.0F, 0.0F, 0.0F, -1.5708F, 3.1416F));
		PartDefinition cube_r12 = bedrock_right.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 65).addBox(-8.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-7.0F, -4.0F, 0.0F, 0.0F, -1.5708F, 3.1416F));
		PartDefinition cube_r13 = bedrock_right.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(0, 65).addBox(-8.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -4.0F, 7.0F, 3.1416F, 0.0F, 0.0F));
		PartDefinition cube_r14 = bedrock_right.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(0, 65).addBox(-8.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 13.0F, -8.0F, -1.5708F, 0.0F, 0.0F));
		PartDefinition cube_r15 = bedrock_right.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(0, 65).addBox(-8.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -3.0F, -8.0F, -1.5708F, 0.0F, 0.0F));
		PartDefinition totem = RightArmLower.addOrReplaceChild("totem", CubeListBuilder.create(), PartPose.offset(-1.0F, 1.0F, 0.0F));
		PartDefinition cube_r16 = totem.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(0, 98).addBox(-15.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(7.0F, 0.0F, 1.0F, 1.5708F, 0.0F, 0.0F));
		PartDefinition LowerBody = all.addOrReplaceChild("LowerBody", CubeListBuilder.create(), PartPose.offset(-4.0F, 10.0F, 0.0F));
		PartDefinition LeftLeg = LowerBody.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(16, 44).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.9F, 0.0F, 0.0F));
		PartDefinition LeftLegLower = LeftLeg.addOrReplaceChild("LeftLegLower", CubeListBuilder.create().texOffs(16, 54).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, 0.0F));
		PartDefinition RightLeg = LowerBody.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.9F, 0.0F, 0.0F));
		PartDefinition RightLegLower = RightLeg.addOrReplaceChild("RightLegLower", CubeListBuilder.create().texOffs(0, 26).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		all.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.all.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.RightArm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.LeftLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.Head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.Head.xRot = headPitch / (180F / (float) Math.PI);
		this.RightArmLower.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.LeftLegLower.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.RightLegLower.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.UpperBody.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.LeftArm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.command_block.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.RightLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.bedrock_left.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.totem.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.bedrock_right.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.LeftArmLower.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
	}
}

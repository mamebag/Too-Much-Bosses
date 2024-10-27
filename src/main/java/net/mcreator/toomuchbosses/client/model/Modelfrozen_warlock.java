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
import net.minecraft.client.model.HierarchicalModel;

import net.mcreator.toomuchbosses.entity.FrozenWarlockEntity;
import net.mcreator.toomuchbosses.FrozenWarlockAnimation;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelfrozen_warlock<T extends Entity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("too_much_bosses", "modelfrozen_warlock"), "main");
	public final ModelPart root;
	public final ModelPart UpperBody;
	public final ModelPart LeftArm;
	public final ModelPart LeftArmLower;
	public final ModelPart icepad;
	public final ModelPart Head;
	public final ModelPart hood;
	public final ModelPart hoodpart4;
	public final ModelPart hoodpart3;
	public final ModelPart hoodpart2;
	public final ModelPart hoodpart1;
	public final ModelPart Body;
	public final ModelPart RightArm;
	public final ModelPart icepad4;
	public final ModelPart icepad3;
	public final ModelPart RightArmLower;
	public final ModelPart icepad2;
	public final ModelPart LowerBody;
	public final ModelPart LeftLeg;
	public final ModelPart LeftLegLower;
	public final ModelPart RightLeg;
	public final ModelPart RightLegLower;

	public Modelfrozen_warlock(ModelPart root) {
		this.root = root.getChild("all");
		this.UpperBody = this.root.getChild("UpperBody");
		this.LeftArm = this.UpperBody.getChild("LeftArm");
		this.LeftArmLower = this.LeftArm.getChild("LeftArmLower");
		this.icepad = this.LeftArm.getChild("icepad");
		this.Head = this.UpperBody.getChild("Head");
		this.hood = this.Head.getChild("hood");
		this.hoodpart4 = this.hood.getChild("hoodpart4");
		this.hoodpart3 = this.hood.getChild("hoodpart3");
		this.hoodpart2 = this.hood.getChild("hoodpart2");
		this.hoodpart1 = this.hood.getChild("hoodpart1");
		this.Body = this.UpperBody.getChild("Body");
		this.RightArm = this.UpperBody.getChild("RightArm");
		this.icepad4 = this.RightArm.getChild("icepad4");
		this.icepad3 = this.RightArm.getChild("icepad3");
		this.RightArmLower = this.RightArm.getChild("RightArmLower");
		this.icepad2 = this.RightArmLower.getChild("icepad2");
		this.LowerBody = this.root.getChild("LowerBody");
		this.LeftLeg = this.LowerBody.getChild("LeftLeg");
		this.LeftLegLower = this.LeftLeg.getChild("LeftLegLower");
		this.RightLeg = this.LowerBody.getChild("RightLeg");
		this.RightLegLower = this.RightLeg.getChild("RightLegLower");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition all = partdefinition.addOrReplaceChild("all", CubeListBuilder.create(), PartPose.offset(0.0F, 7.5F, 0.0F));
		PartDefinition UpperBody = all.addOrReplaceChild("UpperBody", CubeListBuilder.create().texOffs(74, 103).addBox(-4.0F, -12.0F, -3.0F, 8.0F, 14.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 10.0F, 0.0F));
		PartDefinition cube_r1 = UpperBody.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(83, 22).addBox(-1.0F, -4.0F, -3.0F, 2.0F, 4.0F, 6.0F, new CubeDeformation(-0.5F)),
				PartPose.offsetAndRotation(4.0F, -6.0F, 3.0F, 0.0F, -1.5708F, -1.5708F));
		PartDefinition LeftArm = UpperBody.addOrReplaceChild("LeftArm",
				CubeListBuilder.create().texOffs(32, 44).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(-0.01F)).texOffs(31, 99).addBox(-1.0F, -3.0F, -3.0F, 5.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(5.0F, -10.0F, 0.0F));
		PartDefinition LeftArmLower = LeftArm.addOrReplaceChild("LeftArmLower",
				CubeListBuilder.create().texOffs(31, 112).addBox(-2.0F, 0.0F, -3.0F, 5.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(32, 54).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(-0.01F)),
				PartPose.offset(1.0F, 4.0F, 0.0F));
		PartDefinition icepad = LeftArm.addOrReplaceChild("icepad", CubeListBuilder.create().texOffs(83, 22).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 4.0F, 6.0F, new CubeDeformation(-0.5F)), PartPose.offset(4.0F, -3.0F, 0.0F));
		PartDefinition cube_r2 = icepad.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(83, 21).addBox(-1.0F, -4.0F, -3.0F, 2.0F, 4.0F, 6.0F, new CubeDeformation(-0.5F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5708F));
		PartDefinition Head = UpperBody.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(-1.0F)), PartPose.offset(0.0F, -12.0F, 0.0F));
		PartDefinition hood = Head.addOrReplaceChild("hood", CubeListBuilder.create().texOffs(17, 64).addBox(-2.0F, -7.0F, 2.0F, 5.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 0.0F, 0.0F));
		PartDefinition hoodpart4 = hood.addOrReplaceChild("hoodpart4",
				CubeListBuilder.create().texOffs(35, 65).addBox(-1.0F, -9.0F, -5.0F, 1.0F, 9.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(27, 73).addBox(-1.0F, -9.0F, -1.0F, 1.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(5.0F, -1.0F, -1.0F, 0.0F, 0.0F, -1.5708F));
		PartDefinition hoodpart3 = hood.addOrReplaceChild("hoodpart3",
				CubeListBuilder.create().texOffs(35, 65).addBox(-1.0F, -9.0F, -5.0F, 2.0F, 9.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(27, 73).addBox(-1.0F, -9.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.0F, -9.0F, -1.0F, 0.0F, 0.0F, -3.1416F));
		PartDefinition hoodpart2 = hood.addOrReplaceChild("hoodpart2",
				CubeListBuilder.create().texOffs(35, 65).addBox(-1.0F, -9.0F, -5.0F, 2.0F, 9.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(27, 73).addBox(-1.0F, -9.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.0F, -8.0F, -1.0F, 0.0F, 0.0F, 1.5708F));
		PartDefinition hoodpart1 = hood.addOrReplaceChild("hoodpart1",
				CubeListBuilder.create().texOffs(35, 65).addBox(-1.0F, -9.0F, -5.0F, 2.0F, 9.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(27, 73).addBox(-1.0F, -9.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-3.0F, 0.0F, -1.0F));
		PartDefinition Body = UpperBody.addOrReplaceChild("Body",
				CubeListBuilder.create().texOffs(16, 16).addBox(-4.0F, -8.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(-0.01F)).texOffs(45, 54).addBox(-1.0F, -1.0F, -3.8F, 2.0F, 2.0F, 1.0F, new CubeDeformation(-0.3F)).texOffs(45, 54)
						.addBox(-1.0F, -4.0F, -3.8F, 2.0F, 2.0F, 1.0F, new CubeDeformation(-0.3F)).texOffs(45, 54).addBox(-1.0F, -7.0F, -3.8F, 2.0F, 2.0F, 1.0F, new CubeDeformation(-0.3F)),
				PartPose.offset(0.0F, -4.0F, 0.0F));
		PartDefinition RightArm = UpperBody.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(40, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.offset(-5.0F, -10.0F, 0.0F));
		PartDefinition cube_r3 = RightArm.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(2, 99).addBox(-1.0F, -3.0F, -3.0F, 5.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));
		PartDefinition icepad4 = RightArm.addOrReplaceChild("icepad4",
				CubeListBuilder.create().texOffs(71, 57).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 4.0F, 6.0F, new CubeDeformation(-0.5F)).texOffs(108, 70).addBox(-1.0F, -4.0F, 1.0F, 6.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, -3.0F, 3.0F, -1.5708F, -1.5272F, 1.5708F));
		PartDefinition cube_r4 = icepad4.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(108, 70).addBox(-1.0F, -8.0F, 1.0F, 6.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.0F, 4.0F, 0.0F, 0.0F, -1.5708F, 0.0F));
		PartDefinition cube_r5 = icepad4.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(71, 57).addBox(-1.0F, -4.0F, -3.0F, 2.0F, 4.0F, 6.0F, new CubeDeformation(-0.5F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5708F));
		PartDefinition icepad3 = RightArm.addOrReplaceChild("icepad3", CubeListBuilder.create().texOffs(83, 23).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 4.0F, 6.0F, new CubeDeformation(-0.5F)),
				PartPose.offsetAndRotation(-4.0F, 1.0F, -3.0F, 0.0F, 1.5708F, -1.5708F));
		PartDefinition cube_r6 = icepad3.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(83, 23).addBox(-1.0F, -3.0F, -3.0F, 2.0F, 3.0F, 6.0F, new CubeDeformation(-0.5F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5708F));
		PartDefinition RightArmLower = RightArm.addOrReplaceChild("RightArmLower", CubeListBuilder.create().texOffs(40, 26).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.offset(-1.0F, 4.0F, 0.0F));
		PartDefinition cube_r7 = RightArmLower.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(2, 112).addBox(-1.0F, -3.0F, -3.0F, 5.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, 3.0F, 0.0F, 0.0F, 3.1416F, 0.0F));
		PartDefinition icepad2 = RightArmLower.addOrReplaceChild("icepad2", CubeListBuilder.create().texOffs(83, 21).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 4.0F, 6.0F, new CubeDeformation(-0.5F)),
				PartPose.offsetAndRotation(-3.0F, 2.0F, 3.0F, 0.0F, -1.5708F, -1.5708F));
		PartDefinition cube_r8 = icepad2.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(83, 23).addBox(-1.0F, -2.0F, -3.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(-0.5F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5708F));
		PartDefinition LowerBody = all.addOrReplaceChild("LowerBody", CubeListBuilder.create(), PartPose.offset(-4.0F, 10.0F, 0.0F));
		PartDefinition LeftLeg = LowerBody.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(16, 44).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.9F, 0.0F, 0.0F));
		PartDefinition LeftLegLower = LeftLeg.addOrReplaceChild("LeftLegLower", CubeListBuilder.create().texOffs(16, 54).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, 0.0F));
		PartDefinition RightLeg = LowerBody.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.9F, 0.0F, 0.0F));
		PartDefinition RightLegLower = RightLeg.addOrReplaceChild("RightLegLower", CubeListBuilder.create().texOffs(0, 26).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		poseStack.scale(1.0F, 1.0F, 1.0F);
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		FrozenWarlockEntity entityF = (FrozenWarlockEntity) entity;
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.root.y = -1.0f;
		this.Head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.Head.xRot = headPitch / (180F / (float) Math.PI);
		if (entityF.getIsFrozen()) {
			this.UpperBody.xRot = (Mth.cos(limbSwing * 0.8F) + 2) * limbSwingAmount / 6;
			this.UpperBody.zRot = 0f;
			this.RightArm.zRot = 0f;
			this.LeftArm.zRot = 0f;
			this.RightArm.xRot = Mth.cos(limbSwing * 0.4f + (float) Math.PI) * limbSwingAmount / 3;
			this.RightArmLower.xRot = Mth.cos(limbSwing * 0.4f + (float) Math.PI) * limbSwingAmount / 3;
			this.LeftArm.xRot = Mth.cos(limbSwing * 0.4f) * limbSwingAmount / 3;
			this.LeftArmLower.xRot = Mth.cos(limbSwing * 0.4f + (float) Math.PI) * limbSwingAmount / 3;
		} else {
			//this.UpperBody.zRot = ((Mth.sin(ageInTicks / 20.f * 1.1f)) / 10.f) / 8.f;
			this.UpperBody.xRot = ((Mth.cos(limbSwing * 0.8F) + 2) * limbSwingAmount / 6);
			this.RightArm.xRot = (Mth.cos(limbSwing * 0.4f + (float) Math.PI) * limbSwingAmount / 3)/* + (Mth.sin(ageInTicks / 20.f * 0.9f)) / 20.f) / 4.f*/;
			this.RightArm.zRot = (Mth.cos(ageInTicks / 20.f * 1.3f)) / 3.f;
			if ((Mth.cos(ageInTicks / 20.f * 1.3f)) / 3.f < 0) {
				this.RightArm.zRot = 0;
			}
			this.RightArmLower.xRot = Mth.cos(limbSwing * 0.4f + (float) Math.PI) * limbSwingAmount / 3;
			this.LeftArm.xRot = (Mth.cos(limbSwing * 0.4f) * limbSwingAmount / 3);
			this.LeftArm.zRot = (0 - (Mth.cos(ageInTicks / 20.f * 1.3f)) / 3.f)/* / 4.f*/;
			if ((0 - (Mth.cos(ageInTicks / 20.f * 1.3f)) / 3.f) > 0) {
				this.LeftArm.zRot = 0;
			}
			this.LeftArmLower.xRot = Mth.cos(limbSwing * 0.4f + (float) Math.PI) * limbSwingAmount / 3;
		}
		this.LeftLeg.xRot = Mth.cos(limbSwing * 0.4F) * -1.0F * limbSwingAmount / 3;
		this.LeftLegLower.xRot = Mth.cos(limbSwing * 0.4F - (float) Math.PI * 0.4f) * -1.0F * limbSwingAmount / 3;
		this.RightLeg.xRot = Mth.cos(limbSwing * 0.4F) * 1.0F * limbSwingAmount / 2;
		this.RightLegLower.xRot = Mth.cos(limbSwing * 0.4F - (float) Math.PI * 0.4f) * 1.0F * limbSwingAmount / 3;
		/*this.RightLeg.xRot =  Mth.cos(limbSwing * 0.4f) * limbSwingAmount / 2;
		this.RightLegLower.xRot = Mth.cos(limbSwing * 0.4F + (float) Math.PI) * limbSwingAmount / 2;
		this.LeftLeg.xRot = Mth.cos(limbSwing * 0.4F + (float) Math.PI) * limbSwingAmount / 2;
		this.LeftLegLower.xRot = Mth.cos(limbSwing * 0.4F + (float) Math.PI) * limbSwingAmount / 2;*/
		this.animate(entityF.iceWallFrontAnimationState, FrozenWarlockAnimation.ICE_WALL_FRONT, ageInTicks);
		this.animate(entityF.iceWallFrontBiggerAnimationState, FrozenWarlockAnimation.ICE_WALL_FRONT_BIGGER, ageInTicks);
		this.animate(entityF.everfrostAnimationState, FrozenWarlockAnimation.EVERFROST, ageInTicks);
		this.animate(entityF.iceTrapAnimationState, FrozenWarlockAnimation.ICE_TRAP, ageInTicks);
		this.animate(entityF.iceTowerAnimationState, FrozenWarlockAnimation.ICE_TOWER, ageInTicks);
		this.animate(entityF.waterPotionAnimationState, FrozenWarlockAnimation.WATER_POTION, ageInTicks);
		this.animate(entityF.iceRushAnimationState, FrozenWarlockAnimation.ICE_RUSH, ageInTicks);
		this.animate(entityF.iceControlAnimationState, FrozenWarlockAnimation.ICE_CONTROL, ageInTicks);
		//this.animate(entityF.iceDiscsAnimationState, FrozenWarlockAnimation.ICE_DISCS, ageInTicks);
		//this.hood.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		//this.LowerBody.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
	}

	public ModelPart root() {
		return this.root;
	}
}

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

import net.mcreator.toomuchbosses.entity.SpitterEntity;
import net.mcreator.toomuchbosses.SpitterAnimation;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports
public class ModelTheBoss<T extends Entity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("too_much_bosses", "model_the_boss"), "main");
	public final ModelPart root;
	public final ModelPart upperBody;
	public final ModelPart body;
	public final ModelPart head;
	public final ModelPart hat;
	public final ModelPart arms;
	public final ModelPart rightArm;
	public final ModelPart commandBlockRight;
	public final ModelPart leftArm;
	public final ModelPart commandBlockLeft;
	public final ModelPart rightLeg;
	public final ModelPart leftLeg;

	public ModelTheBoss(ModelPart root) {
		this.root = root.getChild("root");
		this.upperBody = this.root.getChild("upperBody");
		this.body = this.upperBody.getChild("body");
		this.head = this.upperBody.getChild("head");
		this.hat = this.head.getChild("hat");
		this.arms = this.upperBody.getChild("arms");
		this.rightArm = this.arms.getChild("rightArm");
		this.commandBlockRight = this.rightArm.getChild("commandBlockRight");
		this.leftArm = this.arms.getChild("leftArm");
		this.commandBlockLeft = this.leftArm.getChild("commandBlockLeft");
		this.rightLeg = this.root.getChild("rightLeg");
		this.leftLeg = this.root.getChild("leftLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition upperBody = root.addOrReplaceChild("upperBody", CubeListBuilder.create(), PartPose.offset(0.0F, -11.0F, 0.0F));
		PartDefinition arms = upperBody.addOrReplaceChild("arms", CubeListBuilder.create(), PartPose.offset(0.0F, -11.0F, 0.0F));
		PartDefinition rightArm = arms.addOrReplaceChild("rightArm", CubeListBuilder.create().texOffs(40, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 0.0F, 0.0F));
		PartDefinition rightItem = rightArm.addOrReplaceChild("rightItem", CubeListBuilder.create(), PartPose.offset(-1.0F, 7.0F, 1.0F));
		PartDefinition commandBlockRight = rightArm.addOrReplaceChild("commandBlockRight", CubeListBuilder.create().texOffs(40, 20).addBox(-9.0F, 0.0F, -9.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, -0.9163F, 0.0F, 0.0F));
		PartDefinition leftArm = arms.addOrReplaceChild("leftArm", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.0F, 0.0F, 0.0F));
		PartDefinition leftItem = leftArm.addOrReplaceChild("leftItem", CubeListBuilder.create(), PartPose.offset(1.0F, 7.0F, 1.0F));
		PartDefinition commandBlockLeft = leftArm.addOrReplaceChild("commandBlockLeft", CubeListBuilder.create().texOffs(40, 20).addBox(-10.0F, -1.0F, -9.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 9.0F, 0.0F, -0.9163F, 0.0F, 0.0F));
		PartDefinition body = upperBody.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -13.0F, 0.0F));
		PartDefinition head = upperBody.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -13.0F, 0.0F));
		PartDefinition hat = head.addOrReplaceChild("hat", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition rightLeg = root.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.9F, -12.0F, 0.0F));
		PartDefinition leftLeg = root.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.9F, -12.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 200, 200);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		SpitterEntity entityS = (SpitterEntity) entity;
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.hat.visible = false;
		if (entityS.isAttacking == true) {
			this.commandBlockRight.visible = true;
			this.commandBlockLeft.visible = true;
		} else {
			this.commandBlockRight.visible = false;
			this.commandBlockLeft.visible = false;
		}
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		if (entityS.cloneFound == true/*entityS.isClone == true*/) {
			this.rightArm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
			this.leftArm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
			this.rightLeg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
			this.leftLeg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		} else {
			this.upperBody.xRot = (Mth.cos(limbSwing * 0.8F) + 2) * limbSwingAmount / 6;
			this.rightLeg.xRot = Mth.cos(limbSwing * 0.4f) * limbSwingAmount / 2;
			this.rightArm.xRot = Mth.cos(limbSwing * 0.4f + (float) Math.PI) * limbSwingAmount / 3;
			this.leftArm.xRot = Mth.cos(limbSwing * 0.4f) * limbSwingAmount / 3;
			this.leftLeg.xRot = Mth.cos(limbSwing * 0.4F + (float) Math.PI) * limbSwingAmount / 2;
		}
		this.animate(entityS.kickAnimationState, SpitterAnimation.KICK, ageInTicks);
		this.animate(entityS.groundPoundAnimationState, SpitterAnimation.GROUND_POUND, ageInTicks);
		this.animate(entityS.jumpAnimationState, SpitterAnimation.HIGH_JUMP, ageInTicks);
		this.animate(entityS.barrageAnimationState, SpitterAnimation.BARRAGE, ageInTicks);
		this.animate(entityS.comboAnimationState, SpitterAnimation.COMBO, ageInTicks);
		this.animate(entityS.launchAnimationState, SpitterAnimation.LAUNCH, ageInTicks);
		this.animate(entityS.spinAnimationState, SpitterAnimation.SPIN, ageInTicks);
		this.animate(entityS.cloneAnimationState, SpitterAnimation.CLONE, ageInTicks);
		this.animate(entityS.reviveAnimationState, SpitterAnimation.REVIVE, ageInTicks);
		this.animate(entityS.deathAnimationState, SpitterAnimation.DEATH, ageInTicks);
	}

	public ModelPart root() {
		return this.root;
	}
}

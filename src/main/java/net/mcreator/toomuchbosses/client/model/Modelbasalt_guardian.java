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

import net.mcreator.toomuchbosses.entity.BasaltGuardianEntity;
import net.mcreator.toomuchbosses.BasaltGuardianAnimation;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelbasalt_guardian<T extends Entity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("too_much_bosses", "modelbasalt_guardian"), "main");
	public final ModelPart root;
	public final ModelPart zouhanshin;
	public final ModelPart head;
	public final ModelPart rightArm;
	public final ModelPart rightarmFist;
	public final ModelPart rightarmAlmost;
	public final ModelPart leftArm;
	public final ModelPart rightArm2;
	public final ModelPart leftArmFist;
	public final ModelPart leftarmAlmost;
	public final ModelPart rightLeg;
	public final ModelPart leftLeg;

	public Modelbasalt_guardian(ModelPart root) {
		this.root = root.getChild("root");
		this.zouhanshin = this.root.getChild("zouhanshin");
		this.head = this.zouhanshin.getChild("head");
		this.rightArm = this.zouhanshin.getChild("rightArm");
		this.rightarmFist = this.rightArm.getChild("rightarmFist");
		this.rightarmAlmost = this.rightArm.getChild("arm");
		this.leftArm = this.zouhanshin.getChild("leftArm");
		this.rightArm2 = this.leftArm.getChild("rightArm2");
		this.leftArmFist = this.rightArm2.getChild("rightarmFist2");
		this.leftarmAlmost = this.rightArm2.getChild("arm2");
		this.rightLeg = this.root.getChild("rightLeg");
		this.leftLeg = this.root.getChild("leftLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 19.0F, 0.0F, -3.1416F, 0.0F, 3.1416F));
		PartDefinition zouhanshin = root.addOrReplaceChild("zouhanshin", CubeListBuilder.create(), PartPose.offset(-1.0F, -12.0F, 2.0F));
		PartDefinition rightArm = zouhanshin.addOrReplaceChild("rightArm", CubeListBuilder.create(), PartPose.offset(14.0F, -16.0F, -2.0F));
		PartDefinition arm = rightArm.addOrReplaceChild("arm", CubeListBuilder.create(), PartPose.offset(3.0F, -0.1532F, 0.5F));
		PartDefinition cube_r7_r1 = arm.addOrReplaceChild("cube_r7_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -5.0F, -14.0F, 9.0F, 9.0F, 36.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, -1.5708F, 0.0F, 0.0F));
		PartDefinition rightarmFist = rightArm.addOrReplaceChild("rightarmFist", CubeListBuilder.create().texOffs(129, 48).addBox(-5.0F, -1.0F, -6.0F, 11.0F, 14.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 17.0F, 1.0F));
		PartDefinition rightarmpad = rightArm.addOrReplaceChild("rightarmpad", CubeListBuilder.create().texOffs(99, 5).addBox(-1.0F, -6.0F, -6.0F, 14.0F, 6.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition cube_r1 = rightarmpad.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(131, 75).addBox(-2.0F, -4.0F, -6.0F, 4.0F, 12.0F, 15.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(5.0F, -7.0F, 0.0F, 0.0F, 0.0F, -1.5708F));
		PartDefinition cube_r2 = rightarmpad.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(95, 21).addBox(6.0F, -12.0F, -1.0F, 0.0F, 6.0F, 14.0F, new CubeDeformation(0.0F)).texOffs(95, 21).addBox(-9.0F, -11.0F, -1.0F, 0.0F, 5.0F, 14.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));
		PartDefinition cube_r3 = rightarmpad.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(95, 13).addBox(-13.0F, -12.0F, -9.0F, 0.0F, 6.0F, 15.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));
		PartDefinition netherwart = rightarmpad.addOrReplaceChild("netherwart", CubeListBuilder.create().texOffs(114, 102).addBox(2.0F, -5.0F, -1.0F, 10.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(8.0F, -4.0F, 1.0F, 0.0F, 0.0F, -1.5708F));
		PartDefinition cube_r4 = netherwart.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(113, 102).addBox(-1.0F, -1.0F, -6.0F, 11.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.0F, -2.0F, 0.0F, -1.5708F, 0.0F, 0.0F));
		PartDefinition netherwart2 = netherwart.addOrReplaceChild("netherwart2", CubeListBuilder.create().texOffs(114, 102).addBox(-6.0F, 0.0F, -2.0F, 10.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(8.0F, 1.0F, 1.0F, -1.5708F, 0.0F, 0.0F));
		PartDefinition cube_r5 = netherwart2.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(113, 102).addBox(-1.0F, -1.0F, -6.0F, 11.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.0F, 3.0F, -1.0F, -1.5708F, 0.0F, 0.0F));
		PartDefinition obi_01 = rightArm.addOrReplaceChild("obi_01", CubeListBuilder.create().texOffs(178, 59).addBox(-2.0F, 1.0F, 0.0F, 5.0F, 15.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, -1.0F, 9.0F));
		PartDefinition obi_02 = rightArm.addOrReplaceChild("obi_02", CubeListBuilder.create(), PartPose.offset(13.0F, -1.0F, 1.0F));
		PartDefinition cube_r6 = obi_02.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(178, 59).addBox(-3.0F, -27.0F, 10.0F, 5.0F, 15.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-10.0F, 28.0F, 0.0F, 0.0F, 1.5708F, 0.0F));
		PartDefinition obi_03 = rightArm.addOrReplaceChild("obi_03", CubeListBuilder.create().texOffs(178, 59).addBox(-3.0F, 1.0F, 0.0F, 5.0F, 15.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, -1.0F, -6.0F));
		PartDefinition leftArm = zouhanshin.addOrReplaceChild("leftArm", CubeListBuilder.create(), PartPose.offset(-11.0F, -16.0F, -2.0F));
		PartDefinition rightArm2 = leftArm.addOrReplaceChild("rightArm2", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.0F, 0.0F, 3.0F, 0.0F, 3.1416F, 0.0F));
		PartDefinition arm2 = rightArm2.addOrReplaceChild("arm2", CubeListBuilder.create(), PartPose.offset(3.0F, -0.1532F, 0.5F));
		PartDefinition cube_r7_r2 = arm2.addOrReplaceChild("cube_r7_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -5.0F, -14.0F, 9.0F, 9.0F, 36.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, -1.5708F, 0.0F, 0.0F));
		PartDefinition rightarmFist2 = rightArm2.addOrReplaceChild("rightarmFist2", CubeListBuilder.create().texOffs(129, 48).addBox(-5.0F, -1.0F, -6.0F, 11.0F, 14.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 17.0F, 1.0F));
		PartDefinition rightarmpad2 = rightArm2.addOrReplaceChild("rightarmpad2", CubeListBuilder.create().texOffs(99, 5).addBox(-1.0F, -6.0F, -6.0F, 14.0F, 6.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition cube_r7 = rightarmpad2.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(109, 1).addBox(-2.0F, -4.0F, -6.0F, 4.0F, 12.0F, 15.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(5.0F, -7.0F, 0.0F, 0.0F, 0.0F, -1.5708F));
		PartDefinition cube_r8 = rightarmpad2.addOrReplaceChild("cube_r8",
				CubeListBuilder.create().texOffs(95, 21).addBox(6.0F, -12.0F, -1.0F, 0.0F, 6.0F, 14.0F, new CubeDeformation(0.0F)).texOffs(95, 21).addBox(-9.0F, -11.0F, -1.0F, 0.0F, 5.0F, 14.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));
		PartDefinition cube_r9 = rightarmpad2.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(95, 13).addBox(-13.0F, -12.0F, -9.0F, 0.0F, 6.0F, 15.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));
		PartDefinition netherwart3 = rightarmpad2.addOrReplaceChild("netherwart3", CubeListBuilder.create(), PartPose.offsetAndRotation(8.0F, -4.0F, 1.0F, 0.0F, 0.0F, -1.5708F));
		PartDefinition netherwart4 = netherwart3.addOrReplaceChild("netherwart4", CubeListBuilder.create(), PartPose.offsetAndRotation(8.0F, 1.0F, 1.0F, -1.5708F, 0.0F, 0.0F));
		PartDefinition obi_2 = rightArm2.addOrReplaceChild("obi_2", CubeListBuilder.create().texOffs(178, 59).addBox(-2.0F, 1.0F, 0.0F, 5.0F, 15.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, -1.0F, 9.0F));
		PartDefinition obi_3 = rightArm2.addOrReplaceChild("obi_3", CubeListBuilder.create(), PartPose.offset(13.0F, -1.0F, 1.0F));
		PartDefinition cube_r10 = obi_3.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(178, 59).addBox(-3.0F, -27.0F, 10.0F, 5.0F, 15.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-10.0F, 28.0F, 0.0F, 0.0F, 1.5708F, 0.0F));
		PartDefinition obi_4 = rightArm2.addOrReplaceChild("obi_4", CubeListBuilder.create().texOffs(178, 59).addBox(-3.0F, 1.0F, 0.0F, 5.0F, 15.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, -1.0F, -6.0F));
		PartDefinition head = zouhanshin.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(1.0F, -15.0F, 4.0F));
		PartDefinition head_r1 = head.addOrReplaceChild("head_r1", CubeListBuilder.create().texOffs(78, 79).addBox(-5.0F, -46.0F, -3.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 40.0F, 3.0F, -0.0436F, 0.0F, 0.0F));
		PartDefinition plants = head.addOrReplaceChild("plants", CubeListBuilder.create().texOffs(98, 99).addBox(-5.0F, -3.0F, 0.0F, 10.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, 10.0F, 3.1416F, 0.0F, 0.0F));
		PartDefinition body = zouhanshin.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(1.0F, 15.0F, -2.0F));
		PartDefinition mainbody = body.addOrReplaceChild("mainbody",
				CubeListBuilder.create().texOffs(54, 0).addBox(-10.0F, -16.0F, -4.0F, 20.0F, 5.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(53, 45).addBox(-12.0F, -36.0F, -6.0F, 24.0F, 20.0F, 14.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition respawn_anchor = mainbody.addOrReplaceChild("respawn_anchor", CubeListBuilder.create().texOffs(0, 89).addBox(-8.0F, -6.0F, -11.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -28.0F, 2.0F));
		PartDefinition plants_on_body = mainbody.addOrReplaceChild("plants_on_body", CubeListBuilder.create().texOffs(199, 30).addBox(3.0F, -40.0F, 0.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition cube_r11 = plants_on_body.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(199, 30).addBox(-4.0F, -3.0F, 0.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(7.0F, -37.0F, 1.0F, 0.0F, -1.5708F, 0.0F));
		PartDefinition plants_on_body2 = mainbody.addOrReplaceChild("plants_on_body2", CubeListBuilder.create().texOffs(199, 30).addBox(3.0F, -43.0F, 0.0F, 8.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-10.0F, 0.0F, 0.0F));
		PartDefinition cube_r12 = plants_on_body2.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(199, 30).addBox(-4.0F, -6.0F, 0.0F, 8.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(7.0F, -37.0F, 1.0F, 0.0F, -1.5708F, 0.0F));
		PartDefinition leftLeg = root.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(0, 18).addBox(-5.0F, 2.0F, -3.0F, 7.0F, 13.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, -10.0F, 2.0F));
		PartDefinition rightLeg = root.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(0, 45).addBox(-2.0F, 2.0F, -3.0F, 7.0F, 13.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, -10.0F, 2.0F));
		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		BasaltGuardianEntity entityB = (BasaltGuardianEntity) entity;
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.idleAndWalkAnimation(limbSwing, limbSwingAmount, netHeadYaw, headPitch, ageInTicks, entityB);
		this.animate(entityB.roarAnimationState, BasaltGuardianAnimation.ROAR, ageInTicks);
		this.animate(entityB.smashAnimationState, BasaltGuardianAnimation.SMASH, ageInTicks);
		this.animate(entityB.hammerAnimationState, BasaltGuardianAnimation.HAMMER, ageInTicks);
		this.animate(entityB.bashAnimationState, BasaltGuardianAnimation.BASH, ageInTicks);
		this.animate(entityB.stompAnimationState, BasaltGuardianAnimation.STOMP, ageInTicks);
		this.animate(entityB.insertAnimationState, BasaltGuardianAnimation.INSERT, ageInTicks);
		this.animate(entityB.enrageAnimationState, BasaltGuardianAnimation.ENRAGE, ageInTicks);
		this.animate(entityB.reviveAnimationState, BasaltGuardianAnimation.REVIVE, ageInTicks);
		this.animate(entityB.beamAnimationState, BasaltGuardianAnimation.BEAM, ageInTicks);
		this.animate(entityB.deathAnimationState, BasaltGuardianAnimation.DEATH, ageInTicks);
	}

	public void idleAndWalkAnimation(float p_233515_, float p_233516_, float p_233517_, float p_233518_, float p_233519_, BasaltGuardianEntity entityB) {
		float limbSwing = p_233515_;
		float limbSwingAmount = p_233516_;
		float netHeadYaw = p_233517_;
		float headPitch = p_233518_;
		float ageInTicks = p_233519_;
		float pie = (float) Math.PI;
		if (entityB.isAttacking == false) {
			this.rightarmAlmost.yScale = 0.6F;
			this.leftarmAlmost.yScale = 0.6F;
		}
		this.root.zRot = 3.1416F + (Mth.sin(limbSwing * 0.5f) * limbSwingAmount * 0.1f);
		this.head.yRot = /*netHeadYaw * ((float)Math.PI / 180F)*/0;
		this.head.xRot = -0.1f + (Mth.sin(ageInTicks / 20.f) / 8.f);
		this.zouhanshin.xRot = 0 - ((Mth.cos(limbSwing * 0.8F) + 2) * limbSwingAmount / 6);
		this.rightArm.xRot = 0.1f + (Mth.sin(ageInTicks / 20.f) / 8.f) + 1.5f * (Mth.cos(limbSwing * 0.6F + pie) * limbSwingAmount / 2.0f);
		this.leftArm.xRot = 0.1f + (Mth.sin(ageInTicks / 20.f) / 8.f) + 1.5f * Mth.cos(limbSwing * 0.6F) * limbSwingAmount / 2.0f;
		this.rightarmFist.xRot = 0.1f + (Mth.sin(ageInTicks / 20.f) / 8.f);
		this.leftArmFist.xRot = 0.1f + (-1f * (Mth.sin(ageInTicks / 20.f) / 8.f));
		this.leftLeg.y += 1.5f * (Mth.clamp(Mth.sin(limbSwing * 0.5f + pie) * limbSwingAmount * 5, -Float.POSITIVE_INFINITY, 0) / 4);
		this.leftLeg.z = 1.5f * (Mth.cos(limbSwing * 0.5f) * limbSwingAmount * 5);
		this.rightLeg.y += 1.5f * (Mth.clamp(Mth.sin(limbSwing * 0.5f) * limbSwingAmount * 5, -Float.POSITIVE_INFINITY, 0) / 4);
		this.rightLeg.z += 1.5f * (Mth.cos(limbSwing * 0.5f + pie) * limbSwingAmount * 5);
	}

	public ModelPart root() {
		return this.root;
	}
}

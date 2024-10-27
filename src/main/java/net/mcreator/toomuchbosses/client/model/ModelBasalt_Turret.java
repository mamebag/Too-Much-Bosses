package net.mcreator.toomuchbosses.client.model;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
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

import net.mcreator.toomuchbosses.entity.BasaltTurretEntity;
import net.mcreator.toomuchbosses.BasaltTurretAnimation;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.9.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class ModelBasalt_Turret<T extends Entity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("too_much_bosses", "model_basalt_turret"), "main");
	public final ModelPart base;
	public final ModelPart head;

	public ModelBasalt_Turret(ModelPart root) {
		this.base = root.getChild("base");
		this.head = this.base.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition base = partdefinition.addOrReplaceChild("base", CubeListBuilder.create().texOffs(0, 28).addBox(-8.0F, -8.0F, -8.0F, 16.0F, 8.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition lid = base.addOrReplaceChild("lid", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -7.0F, -8.0F, 16.0F, 12.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -10.0F, 0.0F));
		PartDefinition fungus = lid.addOrReplaceChild("fungus", CubeListBuilder.create(), PartPose.offset(5.0F, 1.0F, 0.0F));
		PartDefinition cube_r1 = fungus.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(24, 52).addBox(-7.0F, -19.0F, 2.0F, 10.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));
		PartDefinition cube_r2 = fungus.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(24, 52).addBox(-7.0F, -19.0F, -2.0F, 10.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
		PartDefinition head = base.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 52).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -13.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		base.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		BasaltTurretEntity entityT = (BasaltTurretEntity) entity;
		this.root().getAllParts().forEach(ModelPart::resetPose);
		if (((LivingEntity) entity).isAlive()) {
			this.head.visible = true;
			this.head.yRot = (netHeadYaw / (180F / (float) Math.PI)/* + (netHeadYaw / 100.f*/);
			this.head.xRot = headPitch / (180F / (float) Math.PI);
		} else {
			if (entityT.turretDeathTick > 20) {
				this.head.visible = false;
			}
		}
		if (entityT.isShaking) {
			this.head.x = ((float) Math.random()) * 2.f;
			this.head.y = -13.0f + ((float) Math.random()) * 2.f;
			this.head.z = ((float) Math.random()) * 2.f;
		} else {
			this.head.x = 0.0f;
			this.head.y = -13.0f;
			this.head.z = 0.0f;
		}
		this.animate(entityT.shootAnimationState, BasaltTurretAnimation.SHOOT, ageInTicks);
		this.animate(entityT.deathAnimationState, BasaltTurretAnimation.DEATH, ageInTicks);
	}

	public ModelPart root() {
		return this.base;
	}
}

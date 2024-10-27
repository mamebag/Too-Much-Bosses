package net.mcreator.toomuchbosses.client.model;

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

import net.mcreator.toomuchbosses.entity.BGPillarEntityEntity;
import net.mcreator.toomuchbosses.BasaltPillarAnimation;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelbasalt_pillar<T extends Entity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("too_much_bosses", "modelbasalt_pillar"), "main");
	public final ModelPart pillar;

	public Modelbasalt_pillar(ModelPart root) {
		this.pillar = root.getChild("pillar");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition pillar = partdefinition.addOrReplaceChild("pillar", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 21.8468F, 0.5F, 3.1416F, 0.0F, 0.0F));
		PartDefinition cube_r7_r1 = pillar.addOrReplaceChild("cube_r7_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -5.0F, -39.0F, 9.0F, 9.0F, 36.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 37.0F, 0.0F, -1.5708F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		pillar.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		BGPillarEntityEntity entityP = (BGPillarEntityEntity) entity;
		float cnt = entityP.warmupDelayTicks;
		this.root().getAllParts().forEach(ModelPart::resetPose);
		/*if(cnt > 1){
			this.pillar.visible = false;
		}else{
			this.pillar.visible = true;
		}*/
		this.pillar.xRot = entityP.rotateAngleX;
		this.pillar.zRot = entityP.rotateAngleZ;
		this.animate(entityP.spawnAnimationState, BasaltPillarAnimation.SPAWN, ageInTicks);
	}

	public ModelPart root() {
		return this.pillar;
	}
}

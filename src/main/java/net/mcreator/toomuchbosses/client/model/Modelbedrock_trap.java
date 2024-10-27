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
public class Modelbedrock_trap<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("too_much_bosses", "modelbedrock_trap"), "main");
	public final ModelPart bedrock_trap;

	public Modelbedrock_trap(ModelPart root) {
		this.bedrock_trap = root.getChild("bedrock_trap");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition bedrock_trap = partdefinition.addOrReplaceChild("bedrock_trap",
				CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -16.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-8.0F, 0.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-8.0F, 16.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-8.0F, -32.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(6, 4)
						.addBox(-6.0F, -48.0F, -6.0F, 12.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(6, 4).addBox(-6.0F, -64.0F, -6.0F, 12.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(17, 10)
						.addBox(-2.0F, -94.0F, -3.0F, 5.0F, 16.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(17, 10).addBox(-2.0F, -78.0F, -3.0F, 5.0F, 16.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(21, 13)
						.addBox(-1.0F, -126.0F, -1.0F, 3.0F, 16.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(21, 13).addBox(-1.0F, -110.0F, -1.0F, 3.0F, 16.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bedrock_trap.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.bedrock_trap.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
	}
}

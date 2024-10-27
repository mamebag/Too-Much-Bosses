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
import net.minecraft.client.model.EntityModel;

import net.mcreator.toomuchbosses.entity.IcePikesEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.11.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class ModelIceSpikes<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("too_much_bosses", "model_ice_spikes"), "main");
	public final ModelPart bone4;
	public final ModelPart bone;
	public final ModelPart bone3;
	public final ModelPart bone2;
	public final ModelPart bone5;
	public final ModelPart bone6;
	public final ModelPart bone7;
	public final ModelPart bone8;

	public ModelIceSpikes(ModelPart root) {
		this.bone4 = root.getChild("bone4");
		this.bone = this.bone4.getChild("bone");
		this.bone3 = this.bone4.getChild("bone3");
		this.bone2 = this.bone4.getChild("bone2");
		this.bone5 = this.bone4.getChild("bone5");
		this.bone6 = this.bone5.getChild("bone6");
		this.bone7 = this.bone5.getChild("bone7");
		this.bone8 = this.bone5.getChild("bone8");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition bone4 = partdefinition.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(4, 9).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 21.0F, 0.0F));
		PartDefinition bone = bone4.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(11, 12).addBox(-1.0F, -5.0F, -6.0F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(11, 11)
				.addBox(0.0F, -4.0F, -13.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(12, 12).addBox(0.0F, -4.0F, -9.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, -3.0F, -1.5708F, 0.0F, 0.0F));
		PartDefinition bone3 = bone4.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(11, 12).addBox(-1.0F, -5.0F, -6.0F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(11, 11)
				.addBox(0.0F, -4.0F, -13.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(12, 12).addBox(0.0F, -4.0F, -9.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.0F, 1.0F, 0.0F, -3.1416F, 0.0F, -1.5708F));
		PartDefinition bone2 = bone4.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(11, 12).addBox(-1.0F, -5.0F, -6.0F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(11, 11)
				.addBox(0.0F, -4.0F, -13.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(12, 12).addBox(0.0F, -4.0F, -9.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 1.0F, -3.0F, -1.5708F, 0.0F, -1.5708F));
		PartDefinition bone5 = bone4.addOrReplaceChild("bone5", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -3.0F, -1.0F, 0.0F, -1.5708F, 3.1416F));
		PartDefinition bone6 = bone5.addOrReplaceChild("bone6", CubeListBuilder.create().texOffs(11, 12).addBox(-1.0F, -5.0F, -6.0F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(11, 11)
				.addBox(0.0F, -4.0F, -13.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(12, 12).addBox(0.0F, -4.0F, -9.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, -3.0F, -1.5708F, 0.0F, 0.0F));
		PartDefinition bone7 = bone5.addOrReplaceChild("bone7", CubeListBuilder.create().texOffs(11, 12).addBox(-1.0F, -5.0F, -6.0F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(11, 11)
				.addBox(0.0F, -4.0F, -13.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(12, 12).addBox(0.0F, -4.0F, -9.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, -2.0F, 0.0F, -3.1416F, 0.0F, -1.5708F));
		PartDefinition bone8 = bone5.addOrReplaceChild("bone8", CubeListBuilder.create().texOffs(11, 12).addBox(-1.0F, -5.0F, -6.0F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(11, 11)
				.addBox(0.0F, -4.0F, -13.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(12, 12).addBox(0.0F, -4.0F, -9.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, -2.0F, -3.0F, -1.5708F, 0.0F, -1.5708F));
		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bone4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		if (ageInTicks < 20f) {
			this.bone4.xScale = 0.0F + (ageInTicks * 0.15F);
			this.bone4.yScale = 0.0F + (ageInTicks * 0.15F);
			this.bone4.zScale = 0.0F + (ageInTicks * 0.15F);
		} else {
			this.bone4.xScale = 3.0F;
			this.bone4.yScale = 3.0F;
			this.bone4.zScale = 3.0F;
		}
		if (((IcePikesEntity) entity).onLand == false) {
			this.bone4.xRot = ageInTicks / 20.f;
			this.bone4.yRot = ageInTicks / 40.f;
			this.bone4.zRot = ageInTicks / 30.f;
		} else {
			this.bone4.xRot += ageInTicks / 1000000000.f;
			this.bone4.yRot += ageInTicks / 1000000000.f;
			this.bone4.zRot += ageInTicks / 1000000000.f;
		}
	}
}

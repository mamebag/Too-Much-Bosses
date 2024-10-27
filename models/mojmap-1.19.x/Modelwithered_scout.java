import net.minecraft.client.model.HierarchicalModel;

import net.mcreator.toomuchbosses.entity.WitheredScoutEntity;
import net.mcreator.toomuchbosses.WitheredScoutAnimation;
import net.minecraft.util.Mth;
// Made with Blockbench 4.7.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelwithered_scout<T extends Entity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "withered_scout"), "main");
	private final ModelPart all;
	private final ModelPart Head;
	private final ModelPart zyouhanshin;
	private final ModelPart arms;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart legs;
	private final ModelPart RightLeg;
	private final ModelPart LeftLeg;


	public Modelwithered_scout(ModelPart root) {
		this.all = root.getChild("all");
		this.zyouhanshin = this.all.getChild("zyouhanshin");
		this.arms = this.zyouhanshin.getChild("arms");
		this.Head = this.zyouhanshin.getChild("Head");
		this.RightArm = this.arms.getChild("RightArm");
		this.LeftArm = this.arms.getChild("LeftArm");
		this.legs = this.all.getChild("legs");
		this.RightLeg = this.legs.getChild("RightLeg");
		this.LeftLeg = this.legs.getChild("LeftLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition all = partdefinition.addOrReplaceChild("all", CubeListBuilder.create(), PartPose.offset(2.0F, 12.0F, 0.0F));

		PartDefinition zyouhanshin = all.addOrReplaceChild("zyouhanshin", CubeListBuilder.create(), PartPose.offset(-2.0F, 0.0F, 0.0F));

		PartDefinition arms = zyouhanshin.addOrReplaceChild("arms", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition RightArm = arms.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(40, 16).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, -10.0F, 0.0F));

		PartDefinition rightArm_armor = RightArm.addOrReplaceChild("rightArm_armor", CubeListBuilder.create().texOffs(78, 64).addBox(-3.0F, -2.5F, -2.0F, 4.0F, 4.5F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(78, 75).addBox(-1.5F, 3.0F, -2.0F, 2.5F, 7.0F, 3.5F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition sword = RightArm.addOrReplaceChild("sword", CubeListBuilder.create(), PartPose.offset(0.0F, 9.0F, 0.0F));

		PartDefinition blade = sword.addOrReplaceChild("blade", CubeListBuilder.create().texOffs(87, 95).addBox(-1.0F, -2.13F, -16.0F, 1.0F, 2.13F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(97, 109).addBox(-1.0F, -2.13F, -16.6F, 1.0F, 1.13F, 0.72F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 1.0F));

		PartDefinition cube_r1 = blade.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(95, 107).addBox(-1.0F, -1.0F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -16.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r2 = blade.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(103, 92).addBox(-1.5F, -5.9F, -4.48F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition tuka = sword.addOrReplaceChild("tuka", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -12.0F));

		PartDefinition cube_r3 = tuka.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(106, 48).addBox(-1.0F, 7.0F, 7.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(106, 46).addBox(-1.0F, 8.0F, 8.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(106, 48).addBox(-1.0F, 9.0F, 10.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(106, 48).addBox(-1.0F, 9.0F, 9.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(106, 46).addBox(-1.0F, 6.0F, 7.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(102, 48).addBox(-1.0F, 7.0F, 6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(102, 48).addBox(-1.0F, 8.0F, 7.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(102, 48).addBox(-1.0F, 9.0F, 8.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(102, 48).addBox(-1.0F, 10.0F, 9.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(106, 52).addBox(-1.0F, 11.0F, 11.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(102, 50).addBox(-1.0F, 10.0F, 10.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(102, 50).addBox(-1.0F, 11.0F, 10.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(106, 50).addBox(-1.0F, 10.0F, 11.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition LeftArm = arms.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-1.0F, -2.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.0F, -10.0F, 0.0F));

		PartDefinition leftItem = LeftArm.addOrReplaceChild("leftItem", CubeListBuilder.create(), PartPose.offset(1.0F, 7.0F, 1.0F));

		PartDefinition leftArm_armor = LeftArm.addOrReplaceChild("leftArm_armor", CubeListBuilder.create().texOffs(78, 64).addBox(-3.0F, -2.5F, -2.0F, 4.0F, 4.5F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(78, 75).addBox(-1.5F, 3.0F, -2.0F, 2.5F, 7.0F, 3.5F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition Body = zyouhanshin.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -12.0F, 0.0F));

		PartDefinition Legs_part_motomoto = Body.addOrReplaceChild("Legs_part_motomoto", CubeListBuilder.create(), PartPose.offset(0.0F, 11.0F, 0.0F));

		PartDefinition chestplate = Body.addOrReplaceChild("chestplate", CubeListBuilder.create().texOffs(22, 57).addBox(-5.0F, 0.0F, -3.0F, 10.0F, 7.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(22, 79).addBox(-5.0F, 7.0F, -2.0F, 10.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Head = zyouhanshin.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -12.0F, 0.0F));

		PartDefinition helmet = Head.addOrReplaceChild("helmet", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, -32.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition legs = all.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(-2.0F, -1.0F, 0.0F));

		PartDefinition RightLeg = legs.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(0, 16).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 1.0F, 0.0F));

		PartDefinition rightLeg_armor = RightLeg.addOrReplaceChild("rightLeg_armor", CubeListBuilder.create().texOffs(75, 38).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0873F));

		PartDefinition LeftLeg = legs.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, 1.0F, 0.0F));

		PartDefinition LeftLeg_armor = LeftLeg.addOrReplaceChild("LeftLeg_armor", CubeListBuilder.create().texOffs(75, 38).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 3.1416F, 0.0F, 3.0543F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		all.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		WitheredScoutEntity entityWS = (WitheredScoutEntity) entity;
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.Head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.Head.xRot = headPitch / (180F / (float) Math.PI);
		this.zyouhanshin.xRot = (Mth.cos(limbSwing * 0.8F) + 2) * limbSwingAmount / 6;
		this.RightLeg.xRot = Mth.cos(limbSwing * 0.4f) * limbSwingAmount / 2;
		this.RightArm.xRot = Mth.cos(limbSwing * 0.4f + (float) Math.PI) * limbSwingAmount / 3;
		this.LeftArm.xRot = Mth.cos(limbSwing * 0.4f) * limbSwingAmount / 3;
		this.LeftLeg.xRot = Mth.cos(limbSwing * 0.4F + (float) Math.PI) * limbSwingAmount / 2;
		/*this.zyouhanshin.xRot = 0 - 0.75f * ((Mth.cos(limbSwing * 1.2f) * 0.4f + 1.5f) * limbSwingAmount);
		this.RightArm.xRot = 0 + 0.5f * ((Mth.cos(limbSwing * 1.2f) * 0.4f + 1.5f) * limbSwingAmount);
		this.LeftArm.xRot = 0 + 0.5f * ((Mth.cos(limbSwing * 1.2f) * 0.4f + 1.5f) * limbSwingAmount);
		this.RightLeg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.LeftLeg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;*/
		this.animate(entityWS.slashAnimationState, WitheredScoutAnimation.SLASH, ageInTicks);
		this.animate(entityWS.stabAnimationState, WitheredScoutAnimation.STAB, ageInTicks);
		this.animate(entityWS.deathAnimationState, WitheredScoutAnimation.DEATH, ageInTicks);
	}

	public ModelPart root() {
		return this.all;
	}
}
// Made with Blockbench 4.9.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelPumpkin_Scarecrow<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "pumpkin_scarecrow"), "main");
	private final ModelPart all;

	public ModelPumpkin_Scarecrow(ModelPart root) {
		this.all = root.getChild("all");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition all = partdefinition.addOrReplaceChild("all",
				CubeListBuilder.create().texOffs(26, 75)
						.addBox(-2.0F, -23.0F, -1.0F, 4.0F, 23.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 24)
						.addBox(-2.0F, -2.0F, -3.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(37, 24)
						.addBox(2.0F, -3.0F, -1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(37, 20)
						.addBox(-2.0F, -3.0F, 2.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-4.0F, -3.0F, -1.0F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition zyouhanshin = all.addOrReplaceChild("zyouhanshin",
				CubeListBuilder.create().texOffs(50, 14)
						.addBox(-4.0F, -17.0F, -3.0F, 9.0F, 15.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(0, 20)
						.addBox(-6.0F, -16.0F, -6.0F, 13.0F, 15.0F, 11.0F, new CubeDeformation(0.0F)).texOffs(30, 53)
						.addBox(-7.0F, -16.0F, -7.0F, 15.0F, 22.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(0, 46)
						.addBox(-7.0F, -16.0F, 6.0F, 15.0F, 22.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -18.0F, 0.0F));

		PartDefinition cube_r1 = zyouhanshin.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(60, 53)
						.addBox(-7.0F, -53.0F, 7.0F, 13.0F, 22.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(0, 68)
						.addBox(-7.0F, -53.0F, -8.0F, 13.0F, 22.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 37.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition head = zyouhanshin.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-7.0F, -7.0F, -7.0F, 15.0F, 7.0F, 13.0F, new CubeDeformation(0.0F)).texOffs(0, 101)
						.addBox(-7.0F, -10.0F, -7.0F, 15.0F, 3.0F, 13.0F, new CubeDeformation(0.0F)).texOffs(39, 37)
						.addBox(-5.0F, -14.0F, -5.0F, 11.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -16.0F, 0.0F));

		PartDefinition leftArm = zyouhanshin.addOrReplaceChild("leftArm",
				CubeListBuilder.create().texOffs(43, 0)
						.addBox(1.0F, -3.0F, -2.0F, 15.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(77, 0)
						.addBox(8.0F, 1.0F, -2.0F, 6.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(7.0F, -18.0F, 1.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition leftarmJoint = leftArm.addOrReplaceChild("leftarmJoint", CubeListBuilder.create().texOffs(43, 6)
				.addBox(0.0F, -3.0F, -2.0F, 15.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(16.0F, 0.0F, 0.0F));

		PartDefinition crow = leftarmJoint.addOrReplaceChild("crow",
				CubeListBuilder.create().texOffs(0, 20)
						.addBox(32.0F, -7.0F, -2.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(43, 22)
						.addBox(31.0F, -5.0F, -2.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(41, 27)
						.addBox(35.0F, -5.0F, -2.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-30.0F, 0.0F, 0.0F));

		PartDefinition cube_r2 = crow.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(0, 6)
						.addBox(26.0F, -62.0F, -9.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(80, 27)
						.addBox(26.0F, -63.0F, -9.0F, 2.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(7.0F, 55.0F, -1.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r3 = crow.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(76, 78)
						.addBox(24.0F, -62.0F, -19.0F, 1.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(80, 18)
						.addBox(28.0F, -62.0F, -19.0F, 1.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(64, 75)
						.addBox(25.0F, -62.0F, -20.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(7.0F, 55.0F, -1.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r4 = crow.addOrReplaceChild("cube_r4",
				CubeListBuilder.create().texOffs(77, 84)
						.addBox(26.0F, -65.0F, 1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(82, 71)
						.addBox(25.0F, -66.0F, 3.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(7.0F, 55.0F, -1.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition rightArm = zyouhanshin.addOrReplaceChild("rightArm",
				CubeListBuilder.create().texOffs(40, 75)
						.addBox(-12.0F, 1.0F, -2.0F, 10.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(74, 12)
						.addBox(-15.0F, -3.0F, -2.0F, 15.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-7.0F, -18.0F, 1.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition rightArmJoint = rightArm.addOrReplaceChild("rightArmJoint",
				CubeListBuilder.create().texOffs(70, 35)
						.addBox(-16.0F, -3.0F, -2.0F, 15.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(79, 41)
						.addBox(-4.0F, 1.0F, -2.0F, 6.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-14.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		all.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.all.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
	}
}
// Made with Blockbench 4.10.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelbedrock_rain<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "bedrock_rain"), "main");
	private final ModelPart bedrock;

	public Modelbedrock_rain(ModelPart root) {
		this.bedrock = root.getChild("bedrock");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bedrock = partdefinition.addOrReplaceChild("bedrock",
				CubeListBuilder.create().texOffs(-3, -2)
						.addBox(-2.0F, 2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(29, 13)
						.addBox(-3.0F, -5.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(-3, -2)
						.addBox(-2.0F, -7.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-1.0F, -9.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-1.0F, 6.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 16.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		bedrock.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.bedrock.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
	}
}
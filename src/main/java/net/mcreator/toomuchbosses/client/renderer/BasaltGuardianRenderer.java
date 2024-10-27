
package net.mcreator.toomuchbosses.client.renderer;

import net.minecraft.resources.ResourceLocation;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import com.mojang.math.Axis;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.core.Direction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;

import net.mcreator.toomuchbosses.entity.BasaltGuardianEntity;
import net.mcreator.toomuchbosses.network.TooMuchBossesModVariables;
import net.mcreator.toomuchbosses.client.model.Modelbasalt_guardian;
import net.minecraft.world.item.enchantment.ThornsEnchantment;


public class BasaltGuardianRenderer /*<T extends BasaltGuardianEntity> */extends MobRenderer<BasaltGuardianEntity, Modelbasalt_guardian<BasaltGuardianEntity/*T*/>> {
	private static final ResourceLocation beamtexture = new ResourceLocation("too_much_bosses:textures/entities/guardian_beam.png");
	private static final RenderType BEAM_RENDER_TYPE = RenderType.entityCutoutNoCull(beamtexture);
	public boolean revive;
	public BasaltGuardianRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelbasalt_guardian(context.bakeLayer(Modelbasalt_guardian.LAYER_LOCATION)), 0.0f);
			//BasaltGuardianEntity entityB = (BasaltGuardianEntity) T;
			//if(entityB.hasRevived == true){
			this.addLayer(new EyesLayer<BasaltGuardianEntity, Modelbasalt_guardian<BasaltGuardianEntity>>(this) {
				private static final RenderType BASALTGUARDIAN_EMPTY_EYE = RenderType.eyes(new ResourceLocation("too_much_bosses:textures/entities/nothing.png"));
				private static final RenderType BASALTGUARDIAN_EYE = RenderType.eyes(new ResourceLocation("too_much_bosses:textures/entities/basaltguardian_glowlayer.png"));
				public void render(PoseStack p_116983_, MultiBufferSource p_116984_, int p_116985_, BasaltGuardianEntity p_116986_, float p_116987_,
						float p_116988_, float p_116989_, float p_116990_, float p_116991_, float p_116992_) {
						if (p_116986_.hasRevived == true){
							revive = true;
						}else{
							revive = false;
						}
						super.render(p_116983_, p_116984_, p_116985_, p_116986_, p_116987_, p_116988_, p_116989_, p_116990_, p_116991_, p_116992_);
					//}
				}
			@Override
			public RenderType renderType() {
				if(revive == true){
					return BASALTGUARDIAN_EYE;
				}
				return BASALTGUARDIAN_EMPTY_EYE;//("too_much_bosses:textures/entities/basaltguardian_glowlayer.png"));
				}
			});
		//}
	}

/*public boolean shouldRender(BasaltGuardianEntity p_114836_, Frustum p_114837_, double p_114838_, double p_114839_, double p_114840_) {
	  return true;
      if (super.shouldRender(p_114836_, p_114837_, p_114838_, p_114839_, p_114840_)) {
         return true;
      } else {
         if (p_114836_.getOwner() != null) {
            Entity livingentity = (Entity) p_114836_.getOwner();
            if (livingentity != null) {
               Vec3 vec3 = this.getPosition(livingentity, (double) 1.0D, 1.0F);
               Vec3 vec31 = this.getPosition((Entity) p_114836_, (double) 1.0D, 1.0F);
               return p_114837_.isVisible(new AABB(vec31.x, vec31.y, vec31.z, vec3.x, vec3.y, vec3.z));
            }
         }

         return false;
      }
   }*/

   private Vec3 getPosition(Entity p_114803_, double p_114804_, float p_114805_) {
      double d0 = Mth.lerp((double)p_114805_, p_114803_.xOld, p_114803_.getX());
      double d1 = Mth.lerp((double)p_114805_, p_114803_.yOld, p_114803_.getY()) + p_114804_;
      double d2 = Mth.lerp((double)p_114805_, p_114803_.zOld, p_114803_.getZ());
      return new Vec3(d0, d1, d2);
   }

    @Override
    		public void render(BasaltGuardianEntity entityIn, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn) {
		VertexConsumer vb = bufferIn.getBuffer(RenderType.entityCutout(this.getTextureLocation(entityIn)));
		super.render(entityIn, entityYaw, partialTicks, poseStack, bufferIn, packedLightIn);
		model.renderToBuffer(poseStack, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
		//BasaltTurretRenderer.setupRotations(entityIn, poseStack, 0f, 0f, partialTicks);
		 Level world = entityIn.level();
		 /*poseStack.pushPose();
		 poseStack.mulPose(Vector3f.XP.rotationDegrees(-90.0F));
		 poseStack.mulPose(Vector3f.YP.rotationDegrees(-90.0F));
		 poseStack.mulPose(Vector3f.ZP.rotationDegrees(0.0F));
		 poseStack.popPose();*/
		 if(TooMuchBossesModVariables.MapVariables.get(world).doesShooting == true){
		 float f = 0;//entityIn.getAttackAnimationScale(partialTicks);
         float f1 = (float)entityIn.level().getGameTime() + partialTicks;
         float f2 = f1 * 0.5F % 1.0F;
         float f3 = /*(float)*/ 3.45f;
         poseStack.pushPose();
         poseStack.translate(0.0D, (double)f3, 0.0D);
         Vec3 vec3 = new Vec3(/*entityIn.shooteX,entityIn.shooteY,entityIn.shooteZ);*/(double)(TooMuchBossesModVariables.MapVariables.get(world).shootBX)/*entityIn.shootX*/,(double)(TooMuchBossesModVariables.MapVariables.get(world).shootBY)/*entityIn.shootY*/,(double)(TooMuchBossesModVariables.MapVariables.get(world).shootBZ)/*entityIn.shootZ*/); //= this.getPosition((Entity) livingentity, (double)livingentity.getBbHeight() * 0.5D, partialTicks);
         Vec3 vec31 = new Vec3(entityIn.getX(),entityIn.getY() + 3.45,entityIn.getZ());//this.getPosition(((Entity) entityIn), (double)f3, partialTicks);
         Vec3 vec32 = vec3.subtract(vec31);
         float f4 = (float)(vec32.length() + 1.0D);
         vec32 = vec32.normalize();
         float f5 = (float)Math.acos(vec32.y);
         float f6 = (float)Math.atan2(vec32.z, vec32.x);
         poseStack.mulPose(Axis.YP.rotationDegrees((((float)Math.PI / 2F) - f6) * (180F / (float)Math.PI)));
         poseStack.mulPose(Axis.XP.rotationDegrees(f5 * (180F / (float)Math.PI)));
         int i = 1;
         float f7 = f1 * 0.05F * -1.5F;
         float f8 = f * f;
         int j = 255;
         int k = 255 - ((((int)(entityIn.attackTicks - 30))) * 12);//+ (int)(entityIn.lifeStealTicks) * 6;
         int l = 0;
         float f9 = 0.2F;
         float f10 = 0.282F;
         float f11 = Mth.cos(f7 + 2.3561945F) * 0.282F;
         float f12 = Mth.sin(f7 + 2.3561945F) * 0.282F;
         float f13 = Mth.cos(f7 + ((float)Math.PI / 4F)) * 0.282F;
         float f14 = Mth.sin(f7 + ((float)Math.PI / 4F)) * 0.282F;
         float f15 = Mth.cos(f7 + 3.926991F) * 0.282F;
         float f16 = Mth.sin(f7 + 3.926991F) * 0.282F;
         float f17 = Mth.cos(f7 + 5.4977875F) * 0.282F;
         float f18 = Mth.sin(f7 + 5.4977875F) * 0.282F;
         float f19 = Mth.cos(f7 + (float)Math.PI) * 0.2F;
         float f20 = Mth.sin(f7 + (float)Math.PI) * 0.2F;
         float f21 = Mth.cos(f7 + 0.0F) * 0.2F;
         float f22 = Mth.sin(f7 + 0.0F) * 0.2F;
         float f23 = Mth.cos(f7 + ((float)Math.PI / 2F)) * 0.2F;
         float f24 = Mth.sin(f7 + ((float)Math.PI / 2F)) * 0.2F;
         float f25 = Mth.cos(f7 + ((float)Math.PI * 1.5F)) * 0.2F;
         float f26 = Mth.sin(f7 + ((float)Math.PI * 1.5F)) * 0.2F;
         float f27 = 0.0F;
         float f28 = 0.4999F;
         float f29 = -1.0F + f2;
         float f30 = f4 * 2.5F + f29;
         VertexConsumer vertexconsumer = bufferIn.getBuffer(BEAM_RENDER_TYPE);
         PoseStack.Pose posestack$pose = poseStack.last();
         Matrix4f matrix4f = posestack$pose.pose();
         Matrix3f matrix3f = posestack$pose.normal();
         vertex(vertexconsumer, matrix4f, matrix3f, f19, f4, f20, j, k, l, 0.4999F, f30);
         vertex(vertexconsumer, matrix4f, matrix3f, f19, 0.0F, f20, j, k, l, 0.4999F, f29);
         vertex(vertexconsumer, matrix4f, matrix3f, f21, 0.0F, f22, j, k, l, 0.0F, f29);
         vertex(vertexconsumer, matrix4f, matrix3f, f21, f4, f22, j, k, l, 0.0F, f30);
         vertex(vertexconsumer, matrix4f, matrix3f, f23, f4, f24, j, k, l, 0.4999F, f30);
         vertex(vertexconsumer, matrix4f, matrix3f, f23, 0.0F, f24, j, k, l, 0.4999F, f29);
         vertex(vertexconsumer, matrix4f, matrix3f, f25, 0.0F, f26, j, k, l, 0.0F, f29);
         vertex(vertexconsumer, matrix4f, matrix3f, f25, f4, f26, j, k, l, 0.0F, f30);
         float f31 = 0.0F;
         if (entityIn.tickCount % 2 == 0) {
            f31 = 0.5F;
         }

         vertex(vertexconsumer, matrix4f, matrix3f, f11, f4, f12, j, k, l, 0.5F, f31 + 0.5F);
         vertex(vertexconsumer, matrix4f, matrix3f, f13, f4, f14, j, k, l, 1.0F, f31 + 0.5F);
         vertex(vertexconsumer, matrix4f, matrix3f, f17, f4, f18, j, k, l, 1.0F, f31);
         vertex(vertexconsumer, matrix4f, matrix3f, f15, f4, f16, j, k, l, 0.5F, f31);
         poseStack.popPose();
			//}
		//}
        //poseStack.popPose();
		}
	}

	
	@Override
	public ResourceLocation getTextureLocation(BasaltGuardianEntity entity) {
		return new ResourceLocation("too_much_bosses:textures/entities/basalt_guardianae.png");
	}

	private static void vertex(VertexConsumer p_114842_, Matrix4f p_114843_, Matrix3f p_114844_, float p_114845_, float p_114846_, float p_114847_, int p_114848_, int p_114849_, int p_114850_, float p_114851_, float p_114852_) {
      p_114842_.vertex(p_114843_, p_114845_, p_114846_, p_114847_).color(p_114848_, p_114849_, p_114850_, 255).uv(p_114851_, p_114852_).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(15728880).normal(p_114844_, 0.0F, 1.0F, 0.0F).endVertex();
   }
   protected void scale(BasaltGuardianEntity p_114046_, PoseStack p_114047_, float p_114048_) {
		p_114047_.scale(1.5F, 1.5F, 1.5F);
   }
}

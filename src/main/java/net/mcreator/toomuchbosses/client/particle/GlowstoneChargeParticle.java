
package net.mcreator.toomuchbosses.client.particle;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.Particle;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.client.multiplayer.ClientLevel;

@OnlyIn(Dist.CLIENT)
public class GlowstoneChargeParticle extends TextureSheetParticle {
	public double spawnX;
	public double spawnY;
	public double spawnZ;
	public double targetX;
	public double targetY;
	public double targetZ;
	
	public static GlowstoneChargeParticleProvider provider(SpriteSet spriteSet) {
		return new GlowstoneChargeParticleProvider(spriteSet);
	}

	public static class GlowstoneChargeParticleProvider implements ParticleProvider<SimpleParticleType> {
		private final SpriteSet spriteSet;

		public GlowstoneChargeParticleProvider(SpriteSet spriteSet) {
			this.spriteSet = spriteSet;
		}

		public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
			return new GlowstoneChargeParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
		}
	}

	private final SpriteSet spriteSet;

	protected GlowstoneChargeParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
		super(world, x, y, z);
		this.spriteSet = spriteSet;
		this.setSize(0.2f, 0.2f);
		this.targetX = vx;
		this.targetY = vy;
		this.targetZ = vz;
		this.xd = 0;
		this.yd = 0;
		this.zd = 0;
		this.lifetime = 10;
		this.gravity = 0f;
		this.hasPhysics = false;
		this.spawnX = this.x + Mth.nextDouble(RandomSource.create(), -0.5, 0.5);
		this.spawnY = this.y + 1.5D + Mth.nextDouble(RandomSource.create(), -0.5, 0.5);
		this.spawnZ = this.z + Mth.nextDouble(RandomSource.create(), -0.5, 0.5);
		this.x = this.spawnX;
		this.y = this.spawnY;
		this.z = this.spawnZ;
		this.pickSprite(spriteSet);
	}

	@Override
	public int getLightColor(float partialTick) {
		return 15728880;
	}

	@Override
	public ParticleRenderType getRenderType() {
		return ParticleRenderType.PARTICLE_SHEET_LIT;
	}

	@Override
	public void tick() {
		super.tick();
		float tickCount = (float) this.age;
		if(this.age == 1){
			/*this.spawnX = this.x + Mth.nextDouble(RandomSource.create(), -0.5, 0.5);
			this.spawnY = this.y + 1.5D + Mth.nextDouble(RandomSource.create(), -0.5, 0.5);
			this.spawnZ = this.z + Mth.nextDouble(RandomSource.create(), -0.5, 0.5);
			this.x = this.spawnX;
			this.y = this.spawnY;
			this.z = this.spawnZ;*/
		}
		if(this.age > 1){
			double dis = Math.sqrt(Math.pow(this.targetX - this.x, 2) + Math.pow((this.targetY + 2) - this.y, 2) + Math.pow(targetZ - this.z, 2));
			this.x = this.x + (((targetX - this.x) / dis) / 2.0);
			this.y = this.y + ((((targetY + 1) - this.y) / dis) / 2.0);
			this.z = this.z + (((targetZ - this.z) / dis) / 2.0);
			//this.setAlpha(1.0f - ((4.f + tickCount) * 0.025f));
		}
	}
}

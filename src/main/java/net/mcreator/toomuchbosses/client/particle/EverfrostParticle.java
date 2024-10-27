
package net.mcreator.toomuchbosses.client.particle;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.Mth;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.multiplayer.ClientLevel;

@OnlyIn(Dist.CLIENT)
public class EverfrostParticle extends TextureSheetParticle {
	public float spawnX;
	public float spawnZ;
	public float savedX;
	public float savedZ;
	public float spawnRandomizer;

	public static EverfrostParticleProvider provider(SpriteSet spriteSet) {
		return new EverfrostParticleProvider(spriteSet);
	}

	public static class EverfrostParticleProvider implements ParticleProvider<SimpleParticleType> {
		private final SpriteSet spriteSet;

		public EverfrostParticleProvider(SpriteSet spriteSet) {
			this.spriteSet = spriteSet;
		}

		public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
			return new EverfrostParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
		}
	}

	private final SpriteSet spriteSet;

	protected EverfrostParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
		super(world, x, y, z);
		this.spriteSet = spriteSet;
		this.setSize(Mth.clamp((float) Math.random(), 2.0f, 6.0f), Mth.clamp((float) Math.random(), 2.0f, 6.0f));
		this.lifetime = 40;
		this.gravity = 0f;
		this.hasPhysics = false;
		this.xd = vx * 0;
		this.yd = (double) Mth.clamp(Math.random(), 0.1f, 0.25f);///*vy*/(double) Math.random() * 1;
		this.zd = vz * 0;
		this.pickSprite(spriteSet);
	}

	@Override
	public ParticleRenderType getRenderType() {
		return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
	}

	@Override
	public void tick() {
		super.tick();
		float tickCount = (float) this.age;
		if (this.age == 1) {
			this.spawnRandomizer = Mth.clamp((float) Math.random(), 0.1f, 1.0f) * 100.f;
			this.savedX = (float) this.x;
			this.savedZ = (float) this.z;
			/*this.spawnX = ((float) this.x) + (2.f * (Mth.sin(spawnRandomizer) * 1.5f));
			this.spawnZ = ((float) this.z) + (2.f * (Mth.cos(spawnRandomizer) * 1.5f));*/
		}
		//this.scale(1.f / (tickCount / 25.f));
		this.setAlpha(1.0f - (tickCount * 0.025f));
		this.setSize(5.0f - (tickCount * 0.125f), 5.0f - (tickCount * 0.125f));
		//this.setColor(tickCount, tickCount, tickCount);
		this.x = /*yd*/savedX + (1.0f * Mth.sin((this.spawnRandomizer + tickCount) * 50.f) * 3.0f/*1.5f*/);
		this.z = /*yd*/savedZ + (1.0f * Mth.cos((this.spawnRandomizer + tickCount) * 50.f) * 3.0f/*1.5f*/);
	}
}

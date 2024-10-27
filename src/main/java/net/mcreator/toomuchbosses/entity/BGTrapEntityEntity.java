
package net.mcreator.toomuchbosses.entity;

import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;

import net.mcreator.toomuchbosses.init.TooMuchBossesModEntities;
import net.mcreator.toomuchbosses.CrackBlockEffect;

public class BGTrapEntityEntity extends Monster {
	public BGTrapEntityEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(TooMuchBossesModEntities.BG_TRAP_ENTITY.get(), world);
	}

	public BGTrapEntityEntity(EntityType<BGTrapEntityEntity> type, Level world) {
		super(type, world);
		setMaxUpStep(0.6f);
		xpReward = 0;
		setNoAi(false);
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false) {
					protected void checkAndPerformAttack(LivingEntity p_25557_, double p_25558_) {
          	}
			@Override
			protected double getAttackReachSqr(LivingEntity entity) {
				return this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth();
			}
		});
	}

	public void tick(){
		super.tick();
		Level world = this.level();
		this.setDeltaMovement(0, 0, 0);
		if(this.tickCount == 1){
		this.playSound(SoundEvents.ZOMBIE_ATTACK_WOODEN_DOOR, 2.0F, 0.75F);
		this.playSound(SoundEvents.GENERIC_BURN, 1.0F, 1.0F);
		CrackBlockEffect.Crack(this, Mth.nextInt(RandomSource.create(), 5, 9), this.getX(),this.getY() - 0.5,this.getZ(),120);
		}
		if(this.tickCount > 40){
			this.discard();
			this.playSound(SoundEvents.GENERIC_EXPLODE, 2.0F, 2.0F);
			if (world instanceof ServerLevel _level){
				_level.sendParticles(ParticleTypes.LAVA, this.getX(), this.getY(), this.getZ(), 40, 0, 0, 0, 0);
			}
         for(LivingEntity livingentity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(1.0D))) {
            if (!(livingentity instanceof BasaltGuardianEntity)) {
               if(livingentity.hurtTime == 0){
				if(!(this.getTarget() == null)){
               if (!(livingentity instanceof BGTrapEntityEntity)) {
					Entity ent = (Entity) livingentity;
              		livingentity.hurt(this.damageSources().mobAttack(this.getTarget()), 9);
					ent.setSecondsOnFire(5);
					ent.setDeltaMovement(0, 0.35d, 0);
                		}
                	}
               }
            }
         }	
		}
		if(this.tickCount > 30){
			if (world instanceof ServerLevel _level){
					_level.sendParticles(ParticleTypes.LARGE_SMOKE, this.getX(), this.getY(), this.getZ(), 10, 0, 0, 0, 0);
			}
		}
		if(this.tickCount < 40){
			if(this.tickCount % 5 == 0){
				if (world instanceof ServerLevel _level){
					_level.sendParticles(ParticleTypes.SMOKE, this.getX(), this.getY(), this.getZ(), 10, 0, 0, 0, 0);
				}
			}
		}
	}
	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	@Override
	public double getMyRidingOffset() {
		return -0.35D;
	}

	@Override
	public boolean hurt(DamageSource damagesource, float amount) {
		return false;
	}

	@Override
	public boolean ignoreExplosion() {
		return true;
	}

	public static void init() {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0);
		builder = builder.add(Attributes.MAX_HEALTH, 1);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 0);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		return builder;
	}
}

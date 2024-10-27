
package net.mcreator.toomuchbosses.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.PowerableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;



import net.mcreator.toomuchbosses.init.TooMuchBossesModEntities;
import net.mcreator.toomuchbosses.entity.TNTbarrageProjectileEntity;
import net.mcreator.toomuchbosses.entity.BGFlameEntityEntity;
import net.mcreator.toomuchbosses.init.TooMuchBossesModMobEffects;
import net.mcreator.toomuchbosses.entity.TheBossCloneEntity;


import java.util.List;
import java.util.function.Predicate;
import org.checkerframework.checker.units.qual.radians;
import net.minecraft.world.entity.animal.frog.ShootTongue;
import org.apache.commons.lang3.exception.CloneFailedException;

public class SpitterEntity extends Monster implements PowerableMob {

   	private static final Predicate<LivingEntity> LIVING_ENTITY_SELECTOR = (p_31504_) -> {
      return (!(p_31504_ instanceof SpitterEntity)&&!(p_31504_ instanceof MogiPlayerEntity));
   	};

	public final AnimationState kickAnimationState = new AnimationState();
	public final AnimationState groundPoundAnimationState = new AnimationState();
	public final AnimationState jumpAnimationState = new AnimationState();
	public final AnimationState barrageAnimationState = new AnimationState();
	public final AnimationState comboAnimationState = new AnimationState();
	public final AnimationState launchAnimationState = new AnimationState();
	public final AnimationState spinAnimationState = new AnimationState();
	public final AnimationState cloneAnimationState = new AnimationState();
	public final AnimationState reviveAnimationState = new AnimationState();
	public final AnimationState deathAnimationState = new AnimationState();
	public float summonDelay;
	public float jumpCoolDown;
	public float attackCoolDown;
	public float attackTicks;
	public float jumpTicks;
	public float deathTicks;
	public double utiageX;
	public double utiageY;
	public double utiageZ;
	public boolean isAttacking;
	public boolean isJumping;
	public boolean hasRevived;
	public boolean isClone;
	public boolean cloneFound;
	public boolean aura;
	public boolean combo;

	private final ServerBossEvent bossInfo = new ServerBossEvent(this.getDisplayName(), ServerBossEvent.BossBarColor.RED,
			ServerBossEvent.BossBarOverlay.PROGRESS);

	public SpitterEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(TooMuchBossesModEntities.SPITTER.get(), world);
	}

	public SpitterEntity(EntityType<SpitterEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(false);
		this.isClone = false;
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
				this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 0, false, false, LIVING_ENTITY_SELECTOR){
		});
		this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2, false) {
			protected void checkAndPerformAttack(LivingEntity p_25557_, double p_25558_) {
          	}
			@Override
			protected double getAttackReachSqr(LivingEntity entity) {
				return this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth();
			}
		});
		this.goalSelector.addGoal(3, new RandomStrollGoal(this, 1));
		this.targetSelector.addGoal(4, new HurtByTargetGoal(this));
		this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(6, new FloatGoal(this));
	}

	public void tick(){
		super.tick();
		if(this.hasRevived == true){
		this.bossInfo.setDarkenScreen(true);
	  	}else{
		this.bossInfo.setDarkenScreen(false);
	  	}
	  	float animationType = (float) this.getAttributeValue(Attributes.JUMP_STRENGTH);
	  	if(this.isAlive() == true){
	  		if(isSprinting() == true){
	  			if(animationType == 0.1f){
					this.kickAnimationState.start(this.tickCount);
	  			}
	  			if(animationType == 0.2f){
					this.groundPoundAnimationState.start(this.tickCount);
	  			}
	  			if(animationType == 0.3f){
					this.jumpAnimationState.start(this.tickCount);
	  			}
	  			if(animationType == 0.4f){
					this.barrageAnimationState.start(this.tickCount);
	  			}
	  			if(animationType == 0.5f){
					this.comboAnimationState.start(this.tickCount);
	  			}
	  			if(animationType == 0.6f){
					this.launchAnimationState.start(this.tickCount);
	  			}
	  			if(animationType == 0.7f){
					this.spinAnimationState.start(this.tickCount);
	  			}
	  			if(animationType == 0.8f){
					this.cloneAnimationState.start(this.tickCount);
	  			}
	  		}
	 	 }
		if(this.isAlive() == true){
			Level world = this.level();
			if(this.hasRevived){
			this.clearFire();
			this.removeAllEffects();
			}
			this.cloneFound = false;
			for(LivingEntity livingentity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(70.D))) {
      		  if (livingentity instanceof TheBossCloneEntity) {
					if(livingentity.isAlive() == true){
        				this.cloneFound = true;
					}
				}
			}
			this.aura = false;
			if(this./*isShiftKeyDown()*/isClone == false){
				this.aura = true;
			}
			if(cloneFound == false){
			/*this.playSound(SoundEvents.SHULKER_BULLET_HURT, 2.0F, 1.0F);
			if (world instanceof ServerLevel _level){
			_level.sendParticles(ParticleTypes.POOF, this.getX(), this.getY(), this.getZ(), 40, this.getBbWidth() / 2, this.getBbHeight() / 2, this.getBbWidth() / 2, 0.05);
	      	}*/
				this.isClone = false;
			}
			if(!(this.getTarget() == null)){
				LivingEntity livingentity = this.getTarget();
				if(this.getTarget() instanceof TheBossCloneEntity){
				Level worlda = SpitterEntity.this.level();
				for(LivingEntity living : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(70.D))) {
           		 if (living instanceof TheBossCloneEntity) {
						Entity ent = (Entity) living;
						if (worlda instanceof ServerLevel _level){
							_level.sendParticles(ParticleTypes.POOF, ent.getX(), ent.getY(), ent.getZ(), 40, ent.getBbWidth() / 2, ent.getBbHeight() / 2, ent.getBbWidth() / 2, 0.05);
	      					}
							ent.remove(Entity.RemovalReason.KILLED);
						}
					}
					this.playSound(SoundEvents.SHULKER_BULLET_HURT, 2.0F, 1.0F);
					if (worlda instanceof ServerLevel _level){
					_level.sendParticles(ParticleTypes.POOF, this.getX(), this.getY(), this.getZ(), 40, this.getBbWidth() / 2, this.getBbHeight() / 2, this.getBbWidth() / 2, 0.05);
	      			}
				}
				double d0 = this.distanceToSqr(livingentity.getX(), livingentity.getY(), livingentity.getZ());
					if(isAttacking == false){
						if(attackCoolDown == 0){
							if(this./*isShiftKeyDown()*/isClone == true){
								if(d0 < 7){
									//kick
									this.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(0.1f);
									this.attackCoolDown = 45;
									this.isAttacking = true;
									this.setSprinting(true);
								}
							}else{
								if(d0 > 60){
								if(Math.random() < 0.5){
									//jump
									this.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(0.3f);
									this.isAttacking = true;
									this.attackCoolDown = 33;
									this.setSprinting(true);
								}else{
								if(Math.random() < 0.5){
									//barrage
									this.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(0.4f);
									this.isAttacking = true;
									this.attackCoolDown = 60;
									this.setSprinting(true);
								}else{
									//launch
									this.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(0.6f);
									this.isAttacking = true;
									this.attackCoolDown = 40;
									this.setSprinting(true);
									}
								}	
							}else{
							if(d0 < 13){
								if(livingentity.getHealth() < 0){
									if(d0 < 7){
									//kick
									this.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(0.1f);
									this.attackCoolDown = 45;
									this.isAttacking = true;
									this.setSprinting(true);
										}
									}else{
									if(Math.random() < 0.7){
										if(Math.random() < 0.6){
											//spin
											this.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(0.7f);
											this.attackCoolDown = 50;
											this.isAttacking = true;
											this.setSprinting(true);
										}else{
											//groundpound
											this.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(0.2f);
											this.attackCoolDown = 23;
											this.isAttacking = true;
											this.setSprinting(true);
											}
										}else{
											if((Math.random() < 0.5)&&(this.hasRevived == true)){
												//clone
												this.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(0.8f);
												this.attackCoolDown = 40;
												this.isAttacking = true;
												this.setSprinting(true);
											}
											if(this.isAttacking == false){
												//combo
												this.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(0.5f);
												this.attackCoolDown = 70;
												this.isAttacking = true;
												this.setSprinting(true);
												}
											}
										}
									}		
								}
							}
						}
					}
				}else{
				if(this./*isShiftKeyDown()*/isClone == true){
				Level worlda = SpitterEntity.this.level();
				for(LivingEntity livingentity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(70.D))) {
           		 if (livingentity instanceof TheBossCloneEntity) {
						Entity ent = (Entity) livingentity;
						if (worlda instanceof ServerLevel _level){
							_level.sendParticles(ParticleTypes.POOF, ent.getX(), ent.getY(), ent.getZ(), 40, ent.getBbWidth() / 2, ent.getBbHeight() / 2, ent.getBbWidth() / 2, 0.05);
	      					}
							ent.remove(Entity.RemovalReason.KILLED);
						}
					}
					this.playSound(SoundEvents.SHULKER_BULLET_HURT, 2.0F, 1.0F);
					if (worlda instanceof ServerLevel _level){
					_level.sendParticles(ParticleTypes.POOF, this.getX(), this.getY(), this.getZ(), 40, this.getBbWidth() / 2, this.getBbHeight() / 2, this.getBbWidth() / 2, 0.05);
	      			}
					//this.setShiftKeyDown(false);
					this.isClone = false;
				}
			}
			if(animationType == 0.1f){
				this.attackKick();
			}
			if(animationType == 0.2f){
				this.attackGroundPound();
			}
			if(animationType == 0.3f){
				this.jumpingProce();
			}
			if(animationType == 0.4f){
				this.attackBarrage();
			}
			if(animationType == 0.5f){
				this.attackCombo();
			}
			if(animationType == 0.6f){
				this.attackLaunch();
			}
			if(animationType == 0.7f){
				this.attackSpin();
			}
			if(animationType == 0.8f){
				this.attackClone();
			}
			this.attackCoolDown = this.attackCoolDown - 1;
			this.attackCoolDown = Mth.clamp(this.attackCoolDown, 0, 100);
			this.jumpCoolDown = this.jumpCoolDown - 1;
			this.jumpCoolDown = Mth.clamp(this.jumpCoolDown, 0, 200);
			if(this.isAttacking == true){
				this.attackTicks = this.attackTicks + 1;
				this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.0D);
				this.getAttribute(Attributes.KNOCKBACK_RESISTANCE).setBaseValue(11.0D);
				}else{
				this.attackTicks = 0;
				this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.3D);
				this.getAttribute(Attributes.KNOCKBACK_RESISTANCE).setBaseValue(0.0D);
				}
				if(this./*isShiftKeyDown()*/isClone == true){
					this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.2D);
				}
				if((!world.isClientSide)&&(this.isAttacking == false)){
					List<Projectile> projectilesNearby = getEntitiesNearby(Projectile.class, 100);
							for (Projectile a : projectilesNearby) {
							if(!(a instanceof TNTbarrageProjectileEntity)){
                      		  Vec3 aActualMotion = new Vec3(a.getX() - a.xo, a.getY() - a.yo, a.getZ() - a.zo);
                      		  if (aActualMotion.length() < 0.1 /*|| a.tickCount <= 1*/) {
                        		    continue;
                      		  }
                  		      float dot = (float) a.getDeltaMovement().normalize().dot(this.position().subtract(a.position()).normalize());
                  		      if (dot > 0.96) {
                       		     Vec3 dodgeVec = a.getDeltaMovement().cross(new Vec3(0, 1, 0)).normalize().scale(1.2);
                        		    Vec3 newPosLeft = position().add(dodgeVec.scale(2));
                        		    Vec3 newPosRight = position().add(dodgeVec.scale(-2));
                         		   Vec3 diffLeft = newPosLeft.subtract(a.position());
                         		   Vec3 diffRight = newPosRight.subtract(a.position());
                		            if (diffRight.dot(a.getDeltaMovement()) > diffLeft.dot(a.getDeltaMovement())) {
                		                dodgeVec = dodgeVec.scale(-1);
             		               }
								this.setDeltaMovement(getDeltaMovement().add(dodgeVec));
        						}
							}
						}
				}
				}else{
			this.cloneAnimationState.stop();
			this.isAttacking = false;		
			if(this.isClone/*isShiftKeyDown()*/ == true){
			Level worlda = SpitterEntity.this.level();
			for(LivingEntity livingentity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(70.D))) {
           	 if (livingentity instanceof TheBossCloneEntity) {
					Entity ent = (Entity) livingentity;
					if (worlda instanceof ServerLevel _level){
						_level.sendParticles(ParticleTypes.POOF, ent.getX(), ent.getY(), ent.getZ(), 40, ent.getBbWidth() / 2, ent.getBbHeight() / 2, ent.getBbWidth() / 2, 0.05);
	      				}
						ent.remove(Entity.RemovalReason.KILLED);
					}
				}
				this.playSound(SoundEvents.SHULKER_BULLET_HURT, 2.0F, 1.0F);
				if (worlda instanceof ServerLevel _level){
				_level.sendParticles(ParticleTypes.POOF, this.getX(), this.getY(), this.getZ(), 40, this.getBbWidth() / 2, this.getBbHeight() / 2, this.getBbWidth() / 2, 0.05);
	      		}
				//this.setShiftKeyDown(false);
				this.isClone = false;
			}
     	 }
	}

	public void attackKick(){
		Level world = SpitterEntity.this.level();
			if(attackTicks == 1){
			this.setSprinting(false);
			//ScreenShakeEntity.ScreenShake(world, position(), 30, 0.05f, 10, 30);
			}
			if(attackTicks == 13){
			if(!(this.getTarget() == null)){
			LivingEntity livingentity = this.getTarget();
			Entity entitya = (Entity) livingentity;
			double d0 = this.distanceToSqr(livingentity.getX(), livingentity.getY(), livingentity.getZ());
			if(d0 < 7){
				this.playSound(SoundEvents.PLAYER_ATTACK_STRONG, 2.0F, 1.0F);
				entitya.hurt(this.damageSources().mobAttack(this), 15);
				this.strongKnockback((Entity)this.getTarget());
				}
			}
		}
		if(attackTicks == 30){
		this.isAttacking = false;
		this.kickAnimationState.stop();
		}
	}

	public void attackGroundPound(){
		Level world = SpitterEntity.this.level();
		if(attackTicks == 1){
		this.setSprinting(false);
		//ScreenShakeEntity.ScreenShake(world, position(), 30, 0.05f, 10, 30);
		}
		if(attackTicks == 13){
			this.aoeDamage(10D, 10F);
			this.playSound(SoundEvents.GENERIC_EXPLODE, 1.0F, 1.0F);
			if(this.hasRevived == true){
				if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new BGFlameEntityEntity(TooMuchBossesModEntities.BG_FLAME_ENTITY.get(), _level);
				Mob trap = (Mob) entityToSpawn;
				entityToSpawn.moveTo(this.getX(), this.getY(), this.getZ(), world.getRandom().nextFloat() * 360F, 0);
				trap.setTarget(this);
				entityToSpawn.setYBodyRot(0);
				entityToSpawn.setYHeadRot(0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
				world.addFreshEntity(entityToSpawn);
				}
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new BGPoofEntityEntity(TooMuchBossesModEntities.BG_POOF_ENTITY.get(), _level);
				entityToSpawn.moveTo(this.getX(), this.getY(), this.getZ(), world.getRandom().nextFloat() * 360F, 0);
				entityToSpawn.setYBodyRot(0);
				entityToSpawn.setYHeadRot(0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
				world.addFreshEntity(entityToSpawn);
			}
		}
		if(attackTicks == 23){
		this.isAttacking = false;
		this.groundPoundAnimationState.stop();
		}
	}

	public void jumpingProce(){
		Level world = SpitterEntity.this.level();
		if(!(this.getTarget() == null)){
		this.getLookControl().setLookAt(this.getTarget(), 30.0F, 30.0F);
		}
		if(attackTicks == 1){
		this.setSprinting(false);
		//ScreenShakeEntity.ScreenShake(world, position(), 30, 0.05f, 10, 30);
		}
		if(attackTicks == 12){
		if(!(this.getTarget() == null)){
		Entity target = (Entity) this.getTarget();
		double dis = 0;
		dis = Math.sqrt(Math.pow(target.getX() - this.getX(), 2) + Math.pow(target.getY() - this.getY(), 2) + Math.pow(target.getZ() - this.getZ(), 2));
		this.setDeltaMovement(new Vec3((((target.getX() - this.getX()) / dis) * 3), /*(((target.getY() - this.getY()) / dis) * 3)*/0.4D, (((target.getZ() - this.getZ()) / dis) * 3)));
		}
		this.playSound(SoundEvents.PLAYER_SMALL_FALL, 2.0F, 1.0F);
		if (world instanceof ServerLevel _level){
		int i = Mth.floor(this.getX());
        int j = Mth.floor(this.getY() - (double)1.0F);
        int k = Mth.floor(this.getZ());
        BlockPos pos = new BlockPos(i, j, k);
        BlockState blockstate = this.level().getBlockState(pos);
				_level.sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, blockstate).setPos(pos), this.getX(), this.getY(), this.getZ(), 10, 0.3, 0.1, 0.3, 0);
			}
		}
		if(attackTicks == 33){
		if(!(this.getTarget() == null)){
		Entity target = (Entity) this.getTarget();
		this.getNavigation().moveTo(target.getX(), target.getY(), target.getZ(), 1.2);
		}
		this.isAttacking = false;
		this.jumpAnimationState.stop();
		}
	}

	public void attackBarrage(){
		Level world = SpitterEntity.this.level();
			if(attackTicks == 1){
			this.setSprinting(false);
			//ScreenShakeEntity.ScreenShake(world, position(), 30, 0.05f, 10, 30);
			}
		if((attackTicks > 15)&&(attackTicks < 30)){
			if(this.summonDelay == 0){
			this.summonDelay = 2;
			float f = this.yBodyRot * ((float)Math.PI / 180F) + Mth.cos((float)this.tickCount * 0.6662F) * 0.25F;
			float f1 = Mth.cos(f);
			float f2 = Mth.sin(f);
			for(int l = 0; l < 2; l++) {
			this.playSound(SoundEvents.SHULKER_SHOOT, 2.0F, 1.0F);
			if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getArrow(Level level, Entity shooter, float damage, float knockback) {
							AbstractArrow entityToSpawn = new TNTbarrageProjectileEntity(TooMuchBossesModEntities.TN_TBARRAGE_PROJECTILE.get(), level);
							entityToSpawn.setOwner(shooter);
							entityToSpawn.setBaseDamage(damage);
							entityToSpawn.setKnockback((int)knockback);
							entityToSpawn.setSilent(true);
							return entityToSpawn;
						}
					}.getArrow(projectileLevel, this, 2, 0.1f);
					if(Math.random() < 0.5){
					_entityToSpawn.setPos(this.getX() + (double)f1 * 0.6D, this.getY() + 1.8D, this.getZ() + (double)f2 * 0.6D);
					}else{
					_entityToSpawn.setPos(this.getX() - (double)f1 * 0.6D, this.getY() + 1.8D, this.getZ() - (double)f2 * 0.6D);
					}
					_entityToSpawn.shoot(1, 1, 1, 1, 0);
					projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
			}else{
				this.summonDelay = this.summonDelay - 1;
				this.summonDelay = Mth.clamp(this.summonDelay, 0, 100);
			}
		}
		if(attackTicks == 40){
		this.isAttacking = false;
		this.barrageAnimationState.stop();
		//this.attackCoolDown = 0;
		}
		/*if(attackTicks > 40){
			if(!(this.getTarget() == null)){
			LivingEntity livingentity = this.getTarget();
			double d0 = this.distanceToSqr(livingentity.getX(), livingentity.getY(), livingentity.getZ());
			if(d0 < 10){
					this.isAttacking = false;
					this.attackCoolDown = 0;
				}
			}
		}*/
	}

	public void attackCombo(){
		Level world = SpitterEntity.this.level();
		if(attackTicks == 1){
			this.combo = true;
			this.setSprinting(false);
		}
		if(!(this.getTarget() == null)){
		if(this.getTarget() instanceof Mob){
		if(attackTicks == 7){
			if(!(this.getTarget() == null)){
			LivingEntity livingentity = this.getTarget();
			Entity entitya = (Entity) livingentity;
			double d0 = this.distanceToSqr(livingentity.getX(), livingentity.getY(), livingentity.getZ());
			if(d0 < 12){
				this.utiageX = entitya.getX();
				this.utiageY = entitya.getY() + 5;
				this.utiageZ = entitya.getZ();
				this.playSound(SoundEvents.PLAYER_ATTACK_STRONG, 2.0F, 1.0F);
				entitya.hurt(this.damageSources().mobAttack(this), 8);
				entitya.setDeltaMovement(Mth.nextDouble(RandomSource.create(), -0.5, 0.5), 1.6D, Mth.nextDouble(RandomSource.create(), -0.5, 0.5));
				}else{
					this.combo = false;
					this.attackCoolDown = 0;
					this.isAttacking = false;
					this.comboAnimationState.stop();
				}
			}else{
				this.combo = false;
				this.attackCoolDown = 0;
				this.isAttacking = false;
				this.comboAnimationState.stop();
			}
		}
		if(this.attackTicks == 29){
		if(!(this.getTarget() == null)){
		Entity target = (Entity) this.getTarget();
		double d1 = target.getX() - this.getX();
		double d2 = target.getY() - this.getY();
		double x = target.getZ () - this.getZ();
		double z = Math.sqrt(d1 * d1 + d2 * d2 + x * x);
		this.playSound(SoundEvents.RABBIT_JUMP, 2.0F, 1.0F);
		if (world instanceof ServerLevel _level){
		int i = Mth.floor(this.getX());
        int j = Mth.floor(this.getY() - (double)1.0F);
        int k = Mth.floor(this.getZ());
        BlockPos pos = new BlockPos(i, j, k);
        BlockState blockstate = this.level().getBlockState(pos);
				_level.sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, blockstate).setPos(pos), this.getX(), this.getY(), this.getZ(), 10, 0.3, 0.1, 0.3, 0);
				}
		this.setDeltaMovement(d1 / z * 3.4000000953674316D, d2 / z * 1.399999976158142D, x / z * 3.4000000953674316D);
		//this.moveTo(target.getX(), target.getY() + ((double) target.getEyeHeight() + 4), target.getZ(), this.getYRot(), this.getXRot());
			}
		}
		if(attackTicks == 39){
			if(!(this.getTarget() == null)){
			LivingEntity livingentity = this.getTarget();
			Entity entitya = (Entity) livingentity;
			double d0 = this.distanceToSqr(livingentity.getX(), livingentity.getY(), livingentity.getZ());
			if(d0 < 13){
			if(livingentity.hurtTime != 0){
				livingentity.addEffect(new MobEffectInstance(TooMuchBossesModMobEffects.NUMB.get(), 60, 2, false, true));
			}
			this.playSound(SoundEvents.PLAYER_ATTACK_CRIT, 2.0F, 1.0F);
			if (world instanceof ServerLevel _level){
			_level.sendParticles(ParticleTypes.CRIT, entitya.getX(), entitya.getY(), entitya.getZ(), 40, entitya.getBbWidth() / 2, entitya.getBbHeight() / 2, entitya.getBbWidth() / 2, 0);
      		}
			entitya.hurt(this.damageSources().mobAttack(this), 20);
			entitya.setDeltaMovement(Mth.nextDouble(RandomSource.create(), -0.5, 0.5), -1.2, Mth.nextDouble(RandomSource.create(), -0.5, 0.5));
				}
			}
		}
		if((attackTicks > 20)&&(attackTicks < 40)){
			if(!(this.getTarget() == null)){
			LivingEntity livingentity = this.getTarget();
			Entity entitya = (Entity) livingentity;
			Entity target = (Entity) this.getTarget();
			double d0 = this.distanceToSqr(livingentity.getX(), livingentity.getY(), livingentity.getZ());
			if((attackTicks > 20)&&(attackTicks < 40)){
				if(!(this.getTarget() instanceof ArmorStand)){
				if(!(this.getTarget() instanceof Player)&&(!((this.getTarget() instanceof ServerPlayer)))){
				Mob bumo = (Mob) this.getTarget();
				bumo.setTarget(null);
					}
				}
			}
			}else{
				this.attackCoolDown = 0;
				this.isAttacking = false;
				this.comboAnimationState.stop();
				this.combo = false;
					}
				}
			}
		}
		if(attackTicks == 50){
		if(!(this.getTarget() == null)){
		if(!(this.getTarget() instanceof Player)&&(!((this.getTarget() instanceof ServerPlayer)))){
				Mob bumo = (Mob) this.getTarget();
				bumo.setTarget(this);
			}
		}
		this.isAttacking = false;
		this.combo = false;
		this.comboAnimationState.stop();
		}
	}

	public void attackLaunch(){
		Level world = SpitterEntity.this.level();
			if(attackTicks == 1){
			this.setSprinting(false);
			//ScreenShakeEntity.ScreenShake(world, position(), 30, 0.05f, 10, 30);
			}
			if(attackTicks == 10){
			if(!(this.getTarget() == null)){
				LivingEntity livingentity = this.getTarget();
				BigTNTProjectileEntity.shoot(this, livingentity);
			}
		}
		if(attackTicks == 20){
		this.isAttacking = false;
		this.launchAnimationState.stop();
		}
	}

	public void attackSpin(){
		Level world = SpitterEntity.this.level();
		if(attackTicks == 1){
		this.setSprinting(false);
		//ScreenShakeEntity.ScreenShake(world, position(), 30, 0.05f, 10, 30);
		}
		if((attackTicks > 27)&&(attackTicks < 40)){
			this.aoeDamage(7D, 10.0F);
			this.playSound(SoundEvents.WITCH_THROW, 3.0F, 1.0F);
		}
		if(attackTicks == 50){
		this.isAttacking = false;
		this.spinAnimationState.stop();
		}
	}

	public void attackClone(){
		Level world = SpitterEntity.this.level();
		if(attackTicks == 1){
		this.setSprinting(false);
		//ScreenShakeEntity.ScreenShake(world, position(), 30, 0.05f, 10, 30);
		}
		if(attackTicks == 10){
		this.playSound(SoundEvents.ZOMBIE_VILLAGER_CURE, 2, 1f);
		}
		if(attackTicks == 30){
			if(!(this.getTarget() == null)){
				for(int gom = 0; gom < 8; gom++) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new TheBossCloneEntity(TooMuchBossesModEntities.THE_BOSS_CLONE.get(), _level);
					Mob clone = (Mob) entityToSpawn;
					clone.setTarget(this.getTarget());
					entityToSpawn.moveTo(this.getX(), this.getY(), this.getZ(), world.getRandom().nextFloat() * 360F, 0);
					entityToSpawn.setYBodyRot(0);
					entityToSpawn.setYHeadRot(0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
				world.addFreshEntity(entityToSpawn);
				}
			}
			//this.setShiftKeyDown(true);
			this.isClone = true;
			this.isAttacking = false;
			this.cloneAnimationState.stop();
			this.playSound(SoundEvents.ILLUSIONER_MIRROR_MOVE, 2.0F, 1.0F);
			this.moveTo(this.getX() + Mth.nextDouble(RandomSource.create(), -12.0, 12.0), this.getY(), this.getZ() + Mth.nextDouble(RandomSource.create(), -12.0, 12.0), this.getYRot(), this.getXRot());
			}else{
			this.isClone = false;
			this.isAttacking = false;
			this.cloneAnimationState.stop();
			}
		}
		if(this.attackTicks == 31){
			this.cloneAnimationState.stop();
		}
	}
	
	public void aoeDamage(double radius, float damageAmount){
		for(LivingEntity livingentity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(radius))) {
			if(this.getAttributeValue(Attributes.JUMP_STRENGTH) == 0.2f){
				if(livingentity.hurtTime == 0){
					if(!(livingentity instanceof SpitterEntity)) {
					if(this.hasRevived){
							livingentity.setSecondsOnFire(5);
						}
					}
				}
			}
            if (!(livingentity instanceof SpitterEntity)) {
					if(livingentity.hurtTime == 0){
								if(this.hasRevived == true){
									float damageAmped = damageAmount * 1.35f; 
									//entitya.hurt(this.damageSources().mobAttack(this), 15);
									livingentity.hurt(this.damageSources().mobAttack(this), damageAmped);
								}else{
									livingentity.hurt(this.damageSources().mobAttack(this), damageAmount);
								}
								if(livingentity.hurtTime != 0){
								this.strongKnockback(livingentity);
								}
							}
					}
			}
	}
	
	public void strongKnockback(Entity p_33340_) {
      double d0 = p_33340_.getX() - this.getX();
      double d1 = p_33340_.getZ() - this.getZ();
      double d2 = Math.max(d0 * d0 + d1 * d1, 0.001D);
     p_33340_.push(d0 / d2 * 2.0D, 0.5D, d1 / d2 * 2.0D);
    }

	protected void tickDeath() {
     Level world = SpitterEntity.this.level();
     ++this.deathTicks;
      if((this.isSprinting() == true)&&(this.isShiftKeyDown() == true)){
      	this.setSprinting(false);
      	this.kickAnimationState.stop();
		this.groundPoundAnimationState.stop();
		this.jumpAnimationState.stop();
		this.barrageAnimationState.stop();
		this.comboAnimationState.stop();
		this.launchAnimationState.stop();
		this.spinAnimationState.stop();
		this.reviveAnimationState.stop();
		this.cloneAnimationState.stop();
      	this.deathAnimationState.start(this.tickCount);
      }
      if(this.hasRevived == true){
	 if(this.deathTicks == 13){
		if (world instanceof ServerLevel _level){
      		_level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, this.getX(), this.getY() + 1, this.getZ(), 100, 0, 0, 0, 0.25);
      	}
      	this.playSound(SoundEvents.GENERIC_BURN, 2.0F, 0.5F);
      	this.aura = false;
      }
      if(this.deathTicks > 13){
      	this.hurtTime = 1;
      }
      if(this.deathTicks > 60){
      	if (world instanceof ServerLevel _level){
			_level.sendParticles(ParticleTypes.POOF, this.getX(), this.getY(), this.getZ(), 20, this.getBbWidth() / 2, this.getBbHeight() / 2, this.getBbWidth() / 2, 0);
      		}
      		this.remove(Entity.RemovalReason.KILLED);
      		}
      	}else{
      		if(this.deathTicks == 68){
      			this.playSound(getAmbientSound(), 5.0F, 1.0F);
    		}
    	    if(this.deathTicks == 120){
				this.playSound(SoundEvents.WITHER_SPAWN, 2.0F, 1.0F);
      			if (world instanceof ServerLevel _level){
      				_level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, this.getX(), this.getY() + 1, this.getZ(), 100, 0, 0, 0, 0.5);
      			}
      			this.setHealth((float) 200);
      			this.hasRevived = true;
    	    	this.deathTicks = 0;
    	    	this.reviveAnimationState.stop();
    	    	this.setShiftKeyDown(true);
    	    	this.setSprinting(false);
    	    }
    	}
	}

	@Override
	public void die(DamageSource source) {
		super.die(source);
		this.setSprinting(true);
      	this.kickAnimationState.stop();
		this.groundPoundAnimationState.stop();
		this.jumpAnimationState.stop();
		this.barrageAnimationState.stop();
		this.comboAnimationState.stop();
		this.launchAnimationState.stop();
		this.spinAnimationState.stop();
		this.reviveAnimationState.start(this.tickCount);
	}

   public boolean isPowered() {
		
	//if((this.hasRevived == true)&&(this.aura == true)){
      	return (this.hasRevived == true)&&(this.aura == true)&&!(this.cloneFound == true/*this.isShiftKeyDown()isClone == true*/);
   }

   public <T extends Entity> List<T> getEntitiesNearby(Class<T> entityClass, double r) {
        return level().getEntitiesOfClass(entityClass, getBoundingBox().inflate(r, r, r), e -> e != this && distanceTo(e) <= r + e.getBbWidth() / 2f);
    }

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	@Override
	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return false;
	}

	@Override
	public SoundEvent getAmbientSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave"));
	}
	
	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
	}

	@Override
	public boolean hurt(DamageSource source, float amount) {
		float damageReducer;
		Level world = SpitterEntity.this.level();
		if(this.hasRevived == true){
			damageReducer = 1.75f;
		}else{
			damageReducer = 1.f;
		}
		if(this.combo == true){
			return false;
		}
		if(source.getEntity() instanceof SpitterEntity){
			return false;
		}
		if ((source.is(DamageTypes.FALL))||(source.is(DamageTypes.EXPLOSION))){
			return false;
		}
		if(this.hasRevived == true){
			if((source.is(DamageTypes.ON_FIRE))||(source.is(DamageTypes.IN_FIRE))){
				return false;
			}

		}
		if(/*(!(source.getEntity() instanceof SpitterEntity))&&(!(source == DamageSource.FALL))&&(!(source.isExplosion()))&&*/(this./*isShiftKeyDown()*/isClone == true)){
			for(LivingEntity livingentity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(70.D))) {
            if (livingentity instanceof TheBossCloneEntity) {
				Entity ent = (Entity) livingentity;
				if (world instanceof ServerLevel _level){
					_level.sendParticles(ParticleTypes.POOF, ent.getX(), ent.getY(), ent.getZ(), 40, ent.getBbWidth() / 2, ent.getBbHeight() / 2, ent.getBbWidth() / 2, 0.05);
	      			}
					ent.remove(Entity.RemovalReason.KILLED);
				}
			}
			this.playSound(SoundEvents.SHULKER_BULLET_HURT, 2.0F, 1.0F);
			if (world instanceof ServerLevel _level){
			_level.sendParticles(ParticleTypes.POOF, this.getX(), this.getY(), this.getZ(), 40, this.getBbWidth() / 2, this.getBbHeight() / 2, this.getBbWidth() / 2, 0.05);
	      	}
			//this.setShiftKeyDown(false);
			this.isClone = false;
		}
		return super.hurt(source, amount / damageReducer);
	}

	@Override
	public void startSeenByPlayer(ServerPlayer player) {
		super.startSeenByPlayer(player);
		this.bossInfo.addPlayer(player);
	}

	@Override
	public void stopSeenByPlayer(ServerPlayer player) {
		super.stopSeenByPlayer(player);
		this.bossInfo.removePlayer(player);
	}

	@Override
	public void customServerAiStep() {
		super.customServerAiStep();
		this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
		if(this.hasRevived == true){
		this.bossInfo.setColor(ServerBossEvent.BossBarColor.BLUE);
		}else{
			this.bossInfo.setColor(ServerBossEvent.BossBarColor.RED);
		}
	}

	public static void init() {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 0);
		builder = builder.add(Attributes.MAX_HEALTH, 150);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 10);
		builder = builder.add(Attributes.FOLLOW_RANGE, 100);
		builder = builder.add(Attributes.JUMP_STRENGTH, 0.2);
		return builder;
	}
}

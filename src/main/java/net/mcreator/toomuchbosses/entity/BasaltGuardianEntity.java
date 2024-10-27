
package net.mcreator.toomuchbosses.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.util.SpawnUtil;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;

import net.mcreator.toomuchbosses.procedures.BasaltguardianAttackConditionProcedure;
import net.mcreator.toomuchbosses.procedures.BGflameEffectsProcedure;
import net.mcreator.toomuchbosses.init.TooMuchBossesModEntities;
import net.mcreator.toomuchbosses.network.TooMuchBossesModVariables;
import net.mcreator.toomuchbosses.init.TooMuchBossesModMobEffects;
import net.mcreator.toomuchbosses.entity.BGTrapEntityEntity;
import net.mcreator.toomuchbosses.entity.BGFlameEntityEntity;
import net.mcreator.toomuchbosses.entity.BGPillarEntityEntity;
import net.mcreator.toomuchbosses.entity.BGEarthQuakeEntityEntity;
import net.mcreator.toomuchbosses.entity.BGCrackEntityEntity;
//import net.mcreator.toomuchbosses.entity.ScreenShakeEntity;
import net.mcreator.toomuchbosses.CrackBlockEffect;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;
import java.util.function.Predicate;
import net.minecraftforge.client.event.sound.SoundEvent.SoundSourceEvent;
import com.sun.jna.platform.win32.COM.IStream;
import net.minecraftforge.event.entity.player.AttackEntityEvent;


public class BasaltGuardianEntity extends Monster {
   	private static final Predicate<LivingEntity> LIVING_ENTITY_SELECTOR = (p_31504_) -> {
      return (!(p_31504_ instanceof BasaltTurretEntity)&&!(p_31504_ instanceof BasaltGuardianEntity)&&!(p_31504_ instanceof BGTrapEntityEntity)&&!(p_31504_ instanceof BGPillarEntityEntity)&&!(p_31504_ instanceof BGEarthQuakeEntityEntity)&&!(p_31504_ instanceof BGCrackEntityEntity));
   	};
	public final AnimationState roarAnimationState = new AnimationState();
	public final AnimationState smashAnimationState = new AnimationState();
	public final AnimationState hammerAnimationState = new AnimationState();
	public final AnimationState bashAnimationState = new AnimationState();
	public final AnimationState stompAnimationState = new AnimationState();
	public final AnimationState insertAnimationState = new AnimationState();
	public final AnimationState enrageAnimationState = new AnimationState();
	public final AnimationState deathAnimationState = new AnimationState();
	public final AnimationState beamAnimationState = new AnimationState();
	public final AnimationState reviveAnimationState = new AnimationState();
	public int guardianDeathTime;
	public double savedTargetX;
	public double savedTargetY;
	public double savedTargetZ;
	public double shootX;
	public double shootY;
	public double shootZ;
	public float attackType;
	public float attackCoolDown;
	public float rangedAttackCoolDown;
	public float attackTicks;
	public float summonDelay;
	public boolean isAttacking;
	public boolean isShooting;
	public boolean isAnimating;
	public boolean isDying;
	public boolean hasRevived;
	
	private final ServerBossEvent bossInfo = new ServerBossEvent(this.getDisplayName(), ServerBossEvent.BossBarColor.PURPLE,
			ServerBossEvent.BossBarOverlay.PROGRESS);

	public BasaltGuardianEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(TooMuchBossesModEntities.BASALT_GUARDIAN.get(), world);
	}

	public BasaltGuardianEntity(EntityType<BasaltGuardianEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(false);
		setMaxUpStep(3f);
		setPersistenceRequired();
		this.attackType = 0;
		this.attackCoolDown = 0;
		this.attackTicks = 0;
		this.summonDelay = 0;
		this.isAttacking = false;
		this.isAnimating = false;
		this.isDying = false;
		this.hasRevived = false;
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
          	public void tick(){
          	if(BasaltGuardianEntity.this.isAlive()){
          	if(!(BasaltGuardianEntity.this.getTarget() == null)){
			LivingEntity livingentity = BasaltGuardianEntity.this.getTarget();
			if(BasaltGuardianEntity.this.isAttacking == false){
				this.mob.getLookControl().setLookAt(livingentity, 30.0F, 30.0F);
				BasaltGuardianEntity.this.getNavigation().moveTo(livingentity.getX(), livingentity.getY(), livingentity.getZ(), 1.0);
			}
		/*LivingEntity livingentity = this.mob.getTarget();*/
					}
          		}
          	};
			@Override
			protected double getAttackReachSqr(LivingEntity entity) {
				return (double) (4.0 + entity.getBbWidth() * entity.getBbWidth());
			}
		});
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 0, false, false, LIVING_ENTITY_SELECTOR){

		});
		this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1));
		this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
		this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
	}

	  public void tick() {
	  	this.noCulling = true;
	  	if(this.hasRevived == true){
		this.bossInfo.setDarkenScreen(true);
	  	}else{
		this.bossInfo.setDarkenScreen(false);
	  	}
	  	this.removeAllEffects();
	  	float animationType = (float) this.getAttributeValue(Attributes.JUMP_STRENGTH);
	  	if(this.isAlive() == true){
	  		if(isSprinting() == true){
	  			if(animationType == 1){
	  			this.smashAnimationState.start(this.tickCount);
	  			}
				if(animationType == 0.1f){
	  			this.beamAnimationState.start(this.tickCount);
	  			}
	  			if(animationType == 2){
	  			this.bashAnimationState.start(this.tickCount);
	  			}
	  			if(animationType == 1.5f){
	  			this.insertAnimationState.start(this.tickCount);
	  			}
	  			if(animationType == 1.4f){
	  			this.enrageAnimationState.start(this.tickCount);
	  			}
	  			if(animationType == 1.3f){
	  			this.hammerAnimationState.start(this.tickCount);
	  			}
	  			if(animationType == 1.2f){
	  			this.stompAnimationState.start(this.tickCount);
	  			}
	  		}
	  }else{
	Level world = this.level();
     ++this.guardianDeathTime;
     this.hurtTime = 0;
      if((this.isSprinting() == true)&&(this.isShiftKeyDown() == true)){
      	this.setSprinting(false);
      	this.smashAnimationState.stop();
		this.bashAnimationState.stop();
		this.insertAnimationState.stop();
		this.enrageAnimationState.stop();
		this.reviveAnimationState.stop();
		this.hammerAnimationState.stop();
		this.stompAnimationState.stop();
		this.beamAnimationState.stop();
      	this.deathAnimationState.start(this.tickCount);
      }
      if(this.hasRevived == true){
      if(this.guardianDeathTime > 100){
      	if (world instanceof ServerLevel _level){
			_level.sendParticles(ParticleTypes.POOF, this.getX(), this.getY(), this.getZ(), 20, 1, 1.8, 1, 0);
      		}
      		this.remove(Entity.RemovalReason.KILLED);
      		}
      	}else{
      		if(this.guardianDeathTime == 52){
      			this.playSound(SoundEvents.RESPAWN_ANCHOR_SET_SPAWN, 4.0F, 1.0F);
      		if (world instanceof ServerLevel _level){
				_level.sendParticles(ParticleTypes.LAVA, this.getX(), this.getY(), this.getZ(), 50, 1, 1.8, 1, 0);
      			_level.sendParticles(ParticleTypes.END_ROD, this.getX(), this.getY(), this.getZ(), 50, 0, 0, 0, 0.2);
      				}
    		}
    	    if(this.guardianDeathTime == 90){
      			this.setHealth((float) 250);
      			this.hasRevived = true;
      			//this.setShiftKeyDown(true);
    	    	//this.getAttribute(Attributes.SPAWN_REINFORCEMENTS_CHANCE).setBaseValue(1);
    	    	this.guardianDeathTime = 0;
    	    	this.reviveAnimationState.stop();
    	    	this.setShiftKeyDown(true);
    	    	this.setSprinting(false);
    	    }
    	}
	  }
	  	this.setBoundingBox((new AABB(this.getX() - 1.35D, this.getY(), this.getZ() - 1.0D, this.getX() + 1.35D, this.getY() + 3.6D, this.getZ() + 1.0D)));
     	 if (this.isAlive()) {
				if(this.hasRevived == true){
				/*Level world = BasaltGuardianEntity.this.level;
				if (world instanceof ServerLevel _level){
				_level.sendParticles(ParticleTypes.LARGE_SMOKE, this.getX(), this.getY(), this.getZ(), 10, 1, 1.8, 1, 0);
      				}*/
				}
				if(!(this.getTarget() == null)){
				LivingEntity livingentity = this.getTarget();
				double d0 = this.distanceToSqr(livingentity.getX(), livingentity.getY(), livingentity.getZ());
				if(d0 < 15){
					if(animationType == 1.2f){
						if(this.isAttacking == false){
							this.attackCoolDown = 0;
						}
					}
				}
				if(d0 < 100){
					if(isAttacking == false){
						if(attackCoolDown == 0){
							if(d0 < 15){
								if(Math.random() < 0.2){
									/*insert
									this.attackType = 3;*/
									this.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(1.5f);
									this.attackCoolDown = 80;
									this.isAttacking = true;
									this.setSprinting(true);
								}else{
								if(Math.random() < 0.5){
									/*smash
									this.attackType = 1;*/
									this.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(1);
									this.attackCoolDown = 60;
									this.isAttacking = true;
									this.setSprinting(true);
									}else{
										if(this.hasRevived == true){
											if(Math.random() < 0.3){
											/*enrage
											this.attackType = 1.4f;*/
											this.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(1.4f);
											this.attackCoolDown = 80;
											this.isAttacking = true;
											this.setSprinting(true);
											}else{
											if(Math.random() < 0.5){
												/*hammer
												this.attackType = 1.3f;*/
												this.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(1.3f);
												this.attackCoolDown = 45;
												this.isAttacking = true;
												this.setSprinting(true);
											}else{
												/*bash
												this.attackType = 2;*/
												this.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(2);
												this.attackCoolDown = 40;
												this.isAttacking = true;
												this.setSprinting(true);
												}
											}
										}else{
											if(Math.random() < 0.5){
												/*hammer
												this.attackType = 1.3f;*/
												this.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(1.3f);
												this.attackCoolDown = 45;
												this.isAttacking = true;
												this.setSprinting(true);
											}else{
												/*bash
												this.attackType = 2;*/
												this.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(2);
												this.attackCoolDown = 40;
												this.isAttacking = true;
												this.setSprinting(true);
												}
											}
										}
									}
								}else{

									}
								}
							}
						}else{
							if(isAttacking == false){
								if(rangedAttackCoolDown == 0){
								if(this.hasRevived == true ){
									if(Math.random() < 0.4){
									/*beam
									this.attackType = 1.2f;*/
									//if((d0 < 120)&&(d0 > 100)){
									this.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(0.1f);
									this.rangedAttackCoolDown = 100;
									this.isAttacking = true;
									this.setSprinting(true);
									//}
									}else{
									/*stomp
									this.attackType = 1.2f;*/
									//if((d0 < 120)&&(d0 > 100)){
									this.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(1.2f);
									this.rangedAttackCoolDown = 100;
									this.isAttacking = true;
									this.setSprinting(true);
									//}
									}
									}else{
									/*stomp
									this.attackType = 1.2f;*/
									//if((d0 < 120)&&(d0 > 100)){
									this.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(1.2f);
									this.rangedAttackCoolDown = 100;
									this.isAttacking = true;
									this.setSprinting(true);
								}
						}
					}else{
				}
				}
				if(animationType == 1){
					this.attackSmash();
				}
				if(animationType == 2){
					this.attackBash();
				}
				if(animationType == 0.1f){
					this.attackBeam();
				}
				if(animationType == 1.5f){
					this.attackInsert();
				}
				if(animationType == 1.4f){
					this.attackEnrage();
				}
				if(animationType == 1.3f){
					this.attackHammer();
				}
				if(animationType == 1.2f){
					this.attackStomp();
				}
				this.attackCoolDown = this.attackCoolDown - 1;
				this.attackCoolDown = Mth.clamp(this.attackCoolDown, 0, 100);
				this.rangedAttackCoolDown = this.rangedAttackCoolDown - 1;
				this.rangedAttackCoolDown = Mth.clamp(this.rangedAttackCoolDown, 0, 300);
				if(this.isAttacking == true){
					this.attackTicks = this.attackTicks + 1;
					this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.0D);
				}else{
					this.attackTicks = 0;
					this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.25D);
				}
				}else{
				this.isAttacking = false;		
     			 }
				super.tick();
		}
	}

	protected void tickDeath() {
     /*Level world = BasaltGuardianEntity.this.level;
     ++this.guardianDeathTime;
     this.hurtTime = 0;
      if((this.isSprinting() == true)&&(this.isShiftKeyDown() == true)){
      	this.setSprinting(false);
      	this.smashAnimationState.stop();
		this.bashAnimationState.stop();
		this.insertAnimationState.stop();
		this.enrageAnimationState.stop();
		this.reviveAnimationState.stop();
		this.hammerAnimationState.stop();
		this.stompAnimationState.stop();
		this.beamAnimationState.stop();
      	this.deathAnimationState.start(this.tickCount);
      }
      if(this.hasRevived == true){
      if(this.guardianDeathTime > 100){
      	if (world instanceof ServerLevel _level){
			_level.sendParticles(ParticleTypes.POOF, this.getX(), this.getY(), this.getZ(), 20, 1, 1.8, 1, 0);
      		}
      		this.remove(Entity.RemovalReason.KILLED);
      		}
      	}else{
      		if(this.guardianDeathTime == 52){
      			this.playSound(SoundEvents.RESPAWN_ANCHOR_SET_SPAWN, 4.0F, 1.0F);
      		if (world instanceof ServerLevel _level){
				_level.sendParticles(ParticleTypes.LAVA, this.getX(), this.getY(), this.getZ(), 50, 1, 1.8, 1, 0);
      			_level.sendParticles(ParticleTypes.END_ROD, this.getX(), this.getY(), this.getZ(), 50, 0, 0, 0, 0.2);
      				}
    		}
    	    if(this.guardianDeathTime == 90){
      			this.setHealth((float) 250);
      			this.hasRevived = true;
      			//this.setShiftKeyDown(true);
    	    	//this.getAttribute(Attributes.SPAWN_REINFORCEMENTS_CHANCE).setBaseValue(1);
    	    	this.guardianDeathTime = 0;
    	    	this.reviveAnimationState.stop();
    	    	this.setShiftKeyDown(true);
    	    	this.setSprinting(false);
    	    }
    	}*/
	}
	
	public void attackSmash(){
	Level world = /*BasaltGuardianEntity.*/this.level();
			if(attackTicks == 1){
			this.setSprinting(false);
			//ScreenShakeEntity.ScreenShake(world, position(), 30, 0.05f, 10, 30);
			}
			if(attackTicks == 35){
			this.playSound(SoundEvents.GENERIC_EXPLODE, 2.0F, 0.5F);
			{
			final Vec3 _center = new Vec3(this.getX(), this.getY(), this.getZ());
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10 / 2d), e -> true).stream()
					.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).collect(Collectors.toList());
			for (Entity entityiterator : _entfound) {
				 if (!(this == entityiterator)) {
				 	if ((entityiterator instanceof LivingEntity)) {
				 		entityiterator.hurt(this.damageSources().mobAttack(this), 20);
				 		if(((LivingEntity)entityiterator).hurtTime != 0){
						((LivingEntity)entityiterator).addEffect(new MobEffectInstance(TooMuchBossesModMobEffects.NUMB.get(), 60, 2, false, true));
						this.strongKnockback(entityiterator, 1);
				 		}
				 		}
					}
				}
			}
		}
		if(attackTicks == 60){
		this.isAttacking = false;
		this.smashAnimationState.stop();
		}
	}
	
	public void attackBash(){
	Level world = /*BasaltGuardianEntity.*/this.level();
			if(attackTicks == 1){
			this.setSprinting(false);
			}
			if(attackTicks == 20){
			this.playSound(SoundEvents.GENERIC_EXPLODE, 1.0F, 1.0F);
			if(!(this.getTarget() == null)){
			double a0 = this.getTarget().getX() - this.getX();
    		double a1 = this.getTarget().getZ() - this.getZ();
     		double a2 = Math.max(a0 * a0 + a1 * a1, 0.001D);
      		this.push(a0 / a2 * 2.0D, 0, a1 / a2 * 2.0D);
			}
		}
		if((attackTicks == 21)/*||(attackTicks == 22)||(attackTicks == 23)*/){
					if(!(this.getTarget() == null)){
		Entity target = (Entity) this.getTarget();
		double dis = 0;
		dis = Math.sqrt(Math.pow(target.getX() - this.getX(), 2) + Math.pow(target.getY() - this.getY(), 2) + Math.pow(target.getZ() - this.getZ(), 2));
		this.setDeltaMovement(new Vec3((((target.getX() - this.getX()) / dis) * 3), /*(((target.getY() - this.getY()) / dis) * 3)*/0.0D, (((target.getZ() - this.getZ()) / dis) * 3)));
		}
		//entityiterator.hurt(this.damageSources().mobAttack(this), 16);
			{
			final Vec3 _center = new Vec3(this.getX(), this.getY(), this.getZ());
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(7 / 2d), e -> true).stream()
					.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).collect(Collectors.toList());
			for (Entity entityiterator : _entfound) {
				 if (!(this == entityiterator)) {
				 	if(entityiterator.isAlive() == true){
				 		if (entityiterator instanceof LivingEntity) {
							LivingEntity entity = (LivingEntity) entityiterator;
							if (entity.hurtTime == 0){
									entityiterator.hurt(this.damageSources().mobAttack(this), 14);
									if(((LivingEntity)entityiterator).hurtTime != 0){
									this.strongKnockback(entityiterator, 2);
									}
				 				}
				 			}
				 		}
					}
				}
			}
		}
		if(attackTicks == 34){
		this.isAttacking = false;
		this.bashAnimationState.stop();
		}
	}
	
	public void attackInsert(){
	Level world = this.level();
		if(attackTicks == 1){
			this.setSprinting(false);
		}
		if(attackTicks == 23){
		if(this.hasRevived == true){
			this.flameParticles();
			//BGflameEffectsProcedure.execute(this.level, this);
		}
		this.playSound(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("too_much_bosses:basalt_guardian.insert")), 2, 1);
		}
		if(attackTicks == 23){
			{
			final Vec3 _center = new Vec3(this.getX(), this.getY(), this.getZ());
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(7 / 2d), e -> true).stream()
					.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).collect(Collectors.toList());
			for (Entity entityiterator : _entfound) {
				 if (!(this == entityiterator)) {
				 	if (entityiterator instanceof LivingEntity) {
						entityiterator.hurt(this.damageSources().mobAttack(this), 12);
				 			if(this.hasRevived == true){
				 				entityiterator.setSecondsOnFire(5);
				 			}
				 		}
					}
				}
			}
		}
		if((attackTicks > 18)&&(attackTicks < 50)){
			/*if (world instanceof ServerLevel _level) {
			SpawnUtil.trySpawnMob(TooMuchBossesModEntities.BG_TRAP_ENTITY, MobSpawnType.TRIGGERED, world, this.getBlockPos(), Mth.nextInt(RandomSource.create(), -10, 10), 0, Mth.nextInt(RandomSource.create(), -10, 10), SpawnUtil.Strategy.ON_TOP_OF_COLLIDER).isPresent();
			}*/
			if(this.summonDelay == 0){
			if(this.hasRevived == true){
			this.summonDelay = 2;
			}else{
			this.summonDelay = 5;
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new BGTrapEntityEntity(TooMuchBossesModEntities.BG_TRAP_ENTITY.get(), _level);
				Mob trap = (Mob) entityToSpawn;
				if(Math.random() < 0.7D){
				entityToSpawn.moveTo((this.getX() + Mth.nextDouble(RandomSource.create(), -10, 10)),
				(this.getY()),
				(this.getZ() + Mth.nextDouble(RandomSource.create(), -10, 10)), 0, 0);
				}else{
				if(!(this.getTarget() == null)){
				entityToSpawn.moveTo((this.getTarget().getX()),
				(this.getTarget().getY()),
				(this.getTarget().getZ()), 0, 0);
					}else{
					entityToSpawn.moveTo((this.getX() + Mth.nextDouble(RandomSource.create(), -10, 10)),
					(this.getY()),
					(this.getZ() + Mth.nextDouble(RandomSource.create(), -10, 10)), 0, 0);
					}
				}
				trap.setTarget(this);
				entityToSpawn.setYBodyRot(0);
				entityToSpawn.setYHeadRot(0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
				world.addFreshEntity(entityToSpawn);
			}				
			}else{
				this.summonDelay = this.summonDelay - 1;
				this.summonDelay = Mth.clamp(this.summonDelay, 0, 100);
			}
		}
		if(attackTicks == 68){
			this.isAttacking = false;
			this.insertAnimationState.stop();
			if(!(this.getTarget() == null)){
				LivingEntity livingentity = this.getTarget();
				double d0 = this.distanceToSqr(livingentity.getX(), livingentity.getY(), livingentity.getZ());
				if(d0 < 15){
					this.attackCoolDown = 0;	
				}
			}
		}
	}
	
	public void attackEnrage(){
	Level world = /*BasaltGuardianEntity.*/this.level();
			if(attackTicks == 1){
			this.setSprinting(false);
			//ScreenShakeEntity.ScreenShake(world, position(), 30, 0.05f, 10, 30);
			}
			if(attackTicks == 12){
			this.playSound(SoundEvents.ZOMBIE_ATTACK_IRON_DOOR, 1.0F, 0.5F);
			{
			final Vec3 _center = new Vec3(this.getX(), this.getY(), this.getZ());
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5 / 2d), e -> true).stream()
					.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).collect(Collectors.toList());
			for (Entity entityiterator : _entfound) {
				 if (!(this == entityiterator)) {
				 	if (entityiterator instanceof LivingEntity) {
						entityiterator.hurt(this.damageSources().mobAttack(this), 6);
						entityiterator.setDeltaMovement(new Vec3(0, 0.3f, 0));
				 		}
					}
				}
			}
		}
		if(attackTicks == 31){
		this.poofParticles();
		this.playSound(SoundEvents.ENDER_DRAGON_GROWL, 2.0F, 1.0F);
		}
		if(attackTicks == 56){
		this.playSound(SoundEvents.GENERIC_EXPLODE, 1.0F, 1.0F);
		if(!(this.getTarget() == null)){
		LivingEntity livingentity = this.getTarget();
		double d0 = Math.min(livingentity.getY(), this.getY());
        double d1 = Math.max(livingentity.getY(), this.getY()) + 1.0D;
		double dis = 0;
		double summonX = this.getX();
		double summonZ = this.getZ();
		float f = (float)Mth.atan2(livingentity.getZ() - this.getZ(), livingentity.getX() - this.getX());
		for(int l = 0; l < 32; l++) {
            double d2 = 1.25D * (double)(l + 1);
            int j = 1 * l;
            this.createSpellEntity(this.getX() + (double)Mth.cos(f) * d2, this.getZ() + (double)Mth.sin(f) * d2, d0, d1, f, j);
        	}
        for(int gom = 0; gom < 16; gom++) {
            double b2 = 1.25D * (double)(gom + 1);
            int g = 1 * gom;
            this.createSpellEntity(this.getX() + (double)Mth.cos(f) * b2, this.getZ() + (double)Mth.sin(f) * b2, d0, d1, f, g);
        	}
        	for(int omu = 0; omu < 8; omu++) {
            double a2 = 1.25D * (double)(omu + 1);
            int ba = 1 * omu;
            this.createSpellEntity(this.getX() + (double)Mth.cos(f) * ba, this.getZ() + (double)Mth.sin(f) * ba, d0, d1, f, ba);
        	}
		}
		/*for (int index0 = 0; index0 < (int) (16); index0++) {
			dis = Math.sqrt(Math.pow(livingentity.getX() - summonX, 2) + 0 + Math.pow(livingentity.getZ() - summonZ, 2));
			//double d2 = 1.25D * (double)(l + 1);
			summonX = summonX + ((livingentity.getX() - summonX) / dis) / 2;
			summonZ = summonZ + ((livingentity.getZ() - summonZ) / dis) / 2;
			this.createSpellEntity(summonX, summonZ, this.getY() - 1/*d0*//*, d1, f, index0);
			}*/
		}
		if((attackTicks > 56)&&(attackTicks < 66)){
		/*if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new BGPillarEntityEntity(TooMuchBossesModEntities.BG_PILLAR_ENTITY.get(), _level);
				Mob trap = (Mob) entityToSpawn;
				if(Math.random() < 0.7D){
				entityToSpawn.moveTo((this.getX() + Mth.nextDouble(RandomSource.create(), -10, 10)),
				(this.getY()),
				(this.getZ() + Mth.nextDouble(RandomSource.create(), -10, 10)), 0, 0);
				}else{
				if(!(this.getTarget() == null)){
				entityToSpawn.moveTo((this.getTarget().getX()),
				(this.getTarget().getY()),
				(this.getTarget().getZ()), 0, 0);
					}else{
					entityToSpawn.moveTo((this.getX() + Mth.nextDouble(RandomSource.create(), -10, 10)),
					(this.getY()),
					(this.getZ() + Mth.nextDouble(RandomSource.create(), -10, 10)), 0, 0);
					}
				}
				trap.setTarget(this);
				entityToSpawn.setYBodyRot(0);
				entityToSpawn.setYHeadRot(0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
				world.addFreshEntity(entityToSpawn);
			}*/
		}
		if(attackTicks == 60){
		this.isAttacking = false;
		this.enrageAnimationState.stop();
		}
	}
	
	public void attackHammer(){
	Level world = /*BasaltGuardianEntity.*/this.level();
			if(attackTicks == 1){
			this.setSprinting(false);
			//ScreenShakeEntity.ScreenShake(world, position(), 30, 0.05f, 10, 30);
			}
			if(attackTicks == 23){
			this.playSound(SoundEvents.TOTEM_USE, 1.0F, 1.0F);
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new BGEarthQuakeEntityEntity(TooMuchBossesModEntities.BG_EARTH_QUAKE_ENTITY.get(), _level);
					Mob pillar = (Mob) entityToSpawn;
					entityToSpawn.moveTo((this.getX()),
					(this.getY()),
					(this.getZ()), 0, 0);
					pillar.setTarget(this);
					entityToSpawn.setYBodyRot(0);
					entityToSpawn.setYHeadRot(0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					world.addFreshEntity(entityToSpawn);
			}
		}
		if(attackTicks == 45){
		this.isAttacking = false;
		this.hammerAnimationState.stop();
		}
	}
	
	public void attackStomp(){
		Level world = /*BasaltGuardianEntity.*/this.level();
			if(attackTicks > 1){
			this.setSprinting(false);
			//ScreenShakeEntity.ScreenShake(world, position(), 30, 0.05f, 10, 30);
			}
			if(attackTicks == 21){
			this.playSound(SoundEvents.GENERIC_EXPLODE, 1.0F, 1.0F);
			if(!(this.getTarget() == null)){
        	if(this.hasRevived == true){
				LivingEntity livingentity = this.getTarget();
				double d0 = Math.min(livingentity.getY(), this.getY());
       			 double d1 = Math.max(livingentity.getY(), this.getY()) + 1.0D;
				double dis = 0;
				double summonX = this.getX();
				double summonZ = this.getZ();
				float f = (float)Mth.atan2((livingentity.getZ() - 4) - this.getZ(), (livingentity.getX() + 4) - this.getX());
				for(int l = 0; l < 32; l++) {
       	 	    double d2 = 1.25D * (double)(l + 1);
       	 	    int j = 1 * l;
        	    	this.createSpellEntity(this.getX() + (double)Mth.cos(f) * d2, this.getZ() + (double)Mth.sin(f) * d2, d0, d1, f, j);
        		}
        		f = (float)Mth.atan2((livingentity.getZ() + 4) - this.getZ(), (livingentity.getX() - 4) - this.getX());
				for(int l = 0; l < 32; l++) {
       	 	    double d2 = 1.25D * (double)(l + 1);
       	 	    int j = 1 * l;
        	    	this.createSpellEntity(this.getX() + (double)Mth.cos(f) * d2, this.getZ() + (double)Mth.sin(f) * d2, d0, d1, f, j);
        		}
        	}else{
				LivingEntity livingentity = this.getTarget();
				double d0 = Math.min(livingentity.getY(), this.getY());
       			 double d1 = Math.max(livingentity.getY(), this.getY()) + 1.0D;
				double dis = 0;
				double summonX = this.getX();
				double summonZ = this.getZ();
				float f = (float)Mth.atan2(livingentity.getZ() - this.getZ(), livingentity.getX() - this.getX());
				for(int l = 0; l < 32; l++) {
       	     	double d2 = 1.25D * (double)(l + 1);
       	     	int j = 1 * l;
        	    	this.createSpellEntity(this.getX() + (double)Mth.cos(f) * d2, this.getZ() + (double)Mth.sin(f) * d2, d0, d1, f, j);
        		}
        	}
			{
			final Vec3 _center = new Vec3(this.getX(), this.getY(), this.getZ());
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5 / 2d), e -> true).stream()
					.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).collect(Collectors.toList());
			for (Entity entityiterator : _entfound) {
				 if (!(this == entityiterator)) {
				 	if (entityiterator instanceof LivingEntity) {
						entityiterator.hurt(this.damageSources().mobAttack(this), 12);
						entityiterator.setDeltaMovement(new Vec3(0, 0.3f, 0));
				 			}
						}
					}
				}
			}
		}
		if(attackTicks == 30){
		this.isAttacking = false;
		this.stompAnimationState.stop();
		}
	}

	public void attackBeam(){
	Level world = /*BasaltGuardianEntity.*/this.level();
			this.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(this.savedTargetX, this.savedTargetY, this.savedTargetZ));
			if(attackTicks == 1){
			this.setSprinting(false);
			if(this.getTarget() != null){
			this.savedTargetX = this.getTarget().getX();//this.level.clip(new ClipContext(this.getEyePosition(1f), this.getEyePosition(1f).add(this.getViewVector(1f).scale(20)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, this)).getBlockPos().getX();
			this.savedTargetY = this.getTarget().getY() - 0.5;//this.level.clip(new ClipContext(this.getEyePosition(1f), this.getEyePosition(1f).add(this.getViewVector(1f).scale(20)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, this)).getBlockPos().getY();
			this.savedTargetZ = this.getTarget().getZ();//this.level.clip(new ClipContext(this.getEyePosition(1f), this.getEyePosition(1f).add(this.getViewVector(1f).scale(20)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, this)).getBlockPos().getZ();
			}
			//ScreenShakeEntity.ScreenShake(world, position(), 30, 0.05f, 10, 30);
			}
			if(attackTicks == 30){
			this.playSound(SoundEvents.RESPAWN_ANCHOR_CHARGE, 2.0F, 0.5F);
			this.isShooting = true;
			TooMuchBossesModVariables.MapVariables.get(world).doesShooting = true;
			TooMuchBossesModVariables.MapVariables.get(world).syncData(world);
			double dis = Math.sqrt(Math.pow(this.savedTargetX - this.getX(), 2) + Math.pow(this.savedTargetY - this.getY(), 2) + Math.pow(this.savedTargetZ - this.getZ(), 2));
				for(int i = 0; i < 100; ++i) {
				this.shootX = this.shootX + (((this.savedTargetX - this.shootX) / dis) / 2.0);
				this.shootY = this.shootY + (((this.savedTargetY - this.shootY) / dis) / 2.0);
				this.shootZ = this.shootZ + (((this.savedTargetZ - this.shootZ) / dis) / 2.0);
				}
			this.savedTargetX = this.shootX;
			this.savedTargetY = this.shootY;
			this.savedTargetZ = this.shootZ;
			TooMuchBossesModVariables.MapVariables.get(world).shootBX = this.shootX;
			TooMuchBossesModVariables.MapVariables.get(world).shootBY = this.shootY;
			TooMuchBossesModVariables.MapVariables.get(world).shootBZ = this.shootZ;
			TooMuchBossesModVariables.MapVariables.get(world).syncData(world);
		}
		if((this.attackTicks > 30)&&(this.attackTicks < 50)){
			
		}
		if(this.attackTicks == 50){
			TooMuchBossesModVariables.MapVariables.get(world).doesShooting = false;
			TooMuchBossesModVariables.MapVariables.get(world).syncData(world);
			this.shootX = this.getX();//this.shootX + (((this.savedTargetX - this.shootX) / dis) / 2.0);
			this.shootY = this.getY() + 3.45;//this.shootY + (((this.savedTargetY - this.shootY) / dis) / 2.0);
			this.shootZ = this.getZ();//this.shootZ + (((this.savedTargetZ - this.shootZ) / dis) / 2.0);
			this.playSound(SoundEvents.GENERIC_EXPLODE, 2.0F, 0.5F);
			this.playSound(SoundEvents.TOTEM_USE, 2.0F, 0.5F);
			for(int i = 0; i < 100; ++i) {
				double dis = Math.sqrt(Math.pow(this.savedTargetX - this.getX(), 2) + Math.pow(this.savedTargetY - this.getY(), 2) + Math.pow(this.savedTargetZ - this.getZ(), 2));
				if (!((world.getBlockState(new BlockPos(((int)this.shootX), ((int)this.shootY) - 1, ((int)this.shootZ)))).getBlock() == Blocks.AIR)) {
					CrackBlockEffect.Crack(this, Mth.nextInt(RandomSource.create(), 5, 9), this.shootX,this.shootY,this.shootZ,120);
					if (world instanceof ServerLevel _level){
						_level.sendParticles(ParticleTypes.LAVA, this.shootX, this.shootY, this.shootZ, 5, 2, 2, 2, 0);
						//_level.sendParticles(ParticleTypes.EXPLOSION, this.shootX, this.shootY, this.shootZ, 1, 0, 0, 0, 0);
      				}
					{
					final Vec3 _center = new Vec3(this.shootX, this.shootY, this.shootZ);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).collect(Collectors.toList());
					for (Entity entityiterator : _entfound) {
						if((entityiterator instanceof LivingEntity)&&(!(entityiterator instanceof GlowstonebeamEntity))){
							LivingEntity entityL = (LivingEntity) entityiterator;
							if(!(entityL instanceof BasaltTurretEntity)&&!(entityL instanceof BasaltGuardianEntity)){
							entityL.hurt(this.damageSources().mobAttack(this), 10);
							//entityL.hurt(DamageSource.indirectMagic(this, this), 4.5F);
							entityL.setSecondsOnFire(7);
							//break;
								}
							}
						}
					}
				}
				this.shootX = this.shootX + (((this.savedTargetX - this.shootX) / dis) / 2.0);
				this.shootY = this.shootY + (((this.savedTargetY - this.shootY) / dis) / 2.0);
				this.shootZ = this.shootZ + (((this.savedTargetZ - this.shootZ) / dis) / 2.0);
				if (world instanceof ServerLevel _level){
					_level.sendParticles(ParticleTypes.END_ROD, this.shootX, this.shootY, this.shootZ, 5, 1, 1, 1, 0);
					_level.sendParticles(ParticleTypes.EXPLOSION, this.shootX, this.shootY, this.shootZ, 1, 0, 0, 0, 0);
      			}
				{
					final Vec3 _center = new Vec3(this.shootX, this.shootY, this.shootZ);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).collect(Collectors.toList());
					for (Entity entityiterator : _entfound) {
						if((entityiterator instanceof LivingEntity)&&(!(entityiterator instanceof GlowstonebeamEntity))){
							LivingEntity entityL = (LivingEntity) entityiterator;
							if(!(entityL instanceof BasaltTurretEntity)&&!(entityL instanceof BasaltGuardianEntity)){
							entityL.hurt(this.damageSources().mobAttack(this), 50 + (entityL.getMaxHealth() / 10.f));
							//entityL.hurt(DamageSource.indirectMagic(this, this), 4.5F);
							entityL.setSecondsOnFire(7);
							//break;
							}
						}
					}
				}
			}
		}
		if(attackTicks == 80){
		TooMuchBossesModVariables.MapVariables.get(world).doesShooting = false;
		TooMuchBossesModVariables.MapVariables.get(world).syncData(world);
		this.isAttacking = false;
		this.beamAnimationState.stop();
		}
	}
	
	public void strongKnockback(Entity p_33340_, int knockBackType) {
      double d0 = p_33340_.getX() - this.getX();
      double d1 = p_33340_.getZ() - this.getZ();
      double d2 = Math.max(d0 * d0 + d1 * d1, 0.001D);
      if(knockBackType == 1){
     	 p_33340_.push(d0 / d2 * 2.0D, 0.5D, d1 / d2 * 2.0D);
      }
      if(knockBackType == 2){
   		 p_33340_.push(d0 / d2 * 2.0D, 0.2D, d1 / d2 * 2.0D);
      }
      
      if(knockBackType == 3){
   		 p_33340_.push(d0 / d2 * 2.0D, 0.2D, d1 / d2 * 2.0D);
      }
    }

	public void flameParticles(){
		Level world = /*BasaltGuardianEntity.*/this.level();
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
		/*double dis = 0;
		double a = 0;
		double r = 0;
		double b = 0;
		double b1 = 0;
		double b2 = 0;
		double b3 = 0;
		r = 0.5;
		a = Math.random() * 12;
		b = 90;
		for (int index0 = 0; index0 < (int) (30); index0++) {
			for (int index1 = 0; index1 < (int) (16); index1++) {
				b = b + 12;
				dis = Math.sqrt(Math.pow((this.getX() - r * Math.cos(Math.toRadians(b)) * Math.sin(Math.toRadians(a))) - this.getX(), 2)
						+ Math.pow((this.getY() - r * Math.sin(Math.toRadians(b))) - this.getY(), 2)
						+ Math.pow((this.getZ() + r * Math.cos(Math.toRadians(b)) * Math.cos(Math.toRadians(a))) - this.getZ(), 2));
				this.level.addParticle(ParticleTypes.FLAME, (this.getX()), (this.getY()), (this.getZ()),
						((((this.getX() - r * Math.cos(Math.toRadians(b)) * Math.sin(Math.toRadians(a))) - this.getX()) / dis) / 3),
						((((this.getY() - r * Math.sin(Math.toRadians(b))) - this.getY()) / dis) / 3),
						((((this.getZ() + r * Math.cos(Math.toRadians(b)) * Math.cos(Math.toRadians(a))) - this.getZ()) / dis) / 3));
			}
			b = 90;
			a = a + 12;
		}*/	
	}
	
	public void poofParticles(){
		Level world = /*BasaltGuardianEntity.*/this.level();
		for(LivingEntity livingentity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(7.0D))) {
            if (!(livingentity == this)) {
           		this.strongKnockback(livingentity, 3);
           }
        }
		if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new BGPoofEntityEntity(TooMuchBossesModEntities.BG_POOF_ENTITY.get(), _level);
				Vec3 vec3 = this.getBoundingBox().getCenter();
				entityToSpawn.moveTo(vec3.x, vec3.y, vec3.z, world.getRandom().nextFloat() * 360F, 0);
				entityToSpawn.setYBodyRot(0);
				entityToSpawn.setYHeadRot(0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
				world.addFreshEntity(entityToSpawn);
		}
		/*double dis = 0;
		double a = 0;
		double r = 0;
		double b = 0;
		double b1 = 0;
		double b2 = 0;
		double b3 = 0;
		r = 0.5;
		a = Math.random() * 12;
		b = 90;
		for (int index0 = 0; index0 < (int) (30); index0++) {
			for (int index1 = 0; index1 < (int) (16); index1++) {
				b = b + 12;
				dis = Math.sqrt(Math.pow((this.getX() - r * Math.cos(Math.toRadians(b)) * Math.sin(Math.toRadians(a))) - this.getX(), 2)
						+ Math.pow((this.getY() - r * Math.sin(Math.toRadians(b))) - this.getY(), 2)
						+ Math.pow((this.getZ() + r * Math.cos(Math.toRadians(b)) * Math.cos(Math.toRadians(a))) - this.getZ(), 2));
				this.level.addParticle(ParticleTypes.FLAME, (this.getX()), (this.getY()), (this.getZ()),
						((((this.getX() - r * Math.cos(Math.toRadians(b)) * Math.sin(Math.toRadians(a))) - this.getX()) / dis) / 3),
						((((this.getY() - r * Math.sin(Math.toRadians(b))) - this.getY()) / dis) / 3),
						((((this.getZ() + r * Math.cos(Math.toRadians(b)) * Math.cos(Math.toRadians(a))) - this.getZ()) / dis) / 3));
			}
			b = 90;
			a = a + 12;
		}*/	
	}

	private void createSpellEntity(double p_32673_, double p_32674_, double p_32675_, double p_32676_, float p_32677_, int p_32678_) {
         BlockPos blockpos = new BlockPos(((int)p_32673_), ((int)this.getY()), ((int)p_32674_));
         boolean flag = false;
         double d0 = 0.0D;

         do {
            BlockPos blockpos1 = blockpos.below();
            BlockState blockstate = this.level().getBlockState(blockpos1);
            if (blockstate.isFaceSturdy(this.level(), blockpos1, Direction.UP)) {
               if (!this.level().isEmptyBlock(blockpos)) {
                  BlockState blockstate1 = this.level().getBlockState(blockpos);
                  VoxelShape voxelshape = blockstate1.getCollisionShape(this.level(), blockpos);
                  if (!voxelshape.isEmpty()) {
                     d0 = voxelshape.max(Direction.Axis.Y);
                  }
               }

               flag = true;
               break;
            }

            blockpos = blockpos.below();
         } while(blockpos.getY() >= Mth.floor(p_32675_) - 1);

        if (flag) {
        Level world = this.level();
        float animationType = (float) this.getAttributeValue(Attributes.JUMP_STRENGTH);
        if(animationType == 1.4f){
			if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new BGPillarEntityEntity(TooMuchBossesModEntities.BG_PILLAR_ENTITY.get(), _level);
					Mob pillar = (Mob) entityToSpawn;
					BGPillarEntityEntity entityP = (BGPillarEntityEntity) entityToSpawn;
					entityToSpawn.moveTo((p_32673_ + Mth.nextFloat(RandomSource.create(), -2, 2)),
					((double)blockpos.getY() + d0),
					(p_32674_ + Mth.nextFloat(RandomSource.create(), -2, 2)), 0, 0);
					entityP.startPosX = p_32673_ + Mth.nextFloat(RandomSource.create(), -2, 2);
					entityP.startPosY = (double)blockpos.getY() + d0;
					entityP.startPosZ = p_32674_ + Mth.nextFloat(RandomSource.create(), -2, 2);
					entityP.rotateAngleX = Mth.nextFloat(RandomSource.create(), -2.8362F, 2.8362F);
					entityP.rotateAngleZ = Mth.nextFloat(RandomSource.create(), -0.3054F, 0.3054F);
					entityP.warmupDelayTicks = p_32678_;
					entityP.warmupDelayTicksOrg = p_32678_;
					pillar.setTarget(this);
					entityToSpawn.setYBodyRot(0);
					entityToSpawn.setYHeadRot(0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					world.addFreshEntity(entityToSpawn);
				}
        	 }else{
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new BGCrackEntityEntity(TooMuchBossesModEntities.BG_CRACK_ENTITY.get(), _level);
					Mob pillar = (Mob) entityToSpawn;
					BGCrackEntityEntity entityP = (BGCrackEntityEntity) entityToSpawn;
					entityToSpawn.moveTo((p_32673_ + Mth.nextFloat(RandomSource.create(), -2, 2)),
					((double)blockpos.getY() + d0),
					(p_32674_ + Mth.nextFloat(RandomSource.create(), -2, 2)), 0, 0);
					entityP.startPosX = p_32673_ + Mth.nextFloat(RandomSource.create(), -2, 2);
					entityP.startPosY = (double)blockpos.getY() + d0;
					entityP.startPosZ = p_32674_ + Mth.nextFloat(RandomSource.create(), -2, 2);
					entityP.rotateAngleX = Mth.nextFloat(RandomSource.create(), -2.8362F, 2.8362F);
					entityP.rotateAngleZ = Mth.nextFloat(RandomSource.create(), -0.3054F, 0.3054F);
					entityP.warmupDelayTicks = p_32678_;
					entityP.warmupDelayTicksOrg = p_32678_;
					pillar.setTarget(this);
					entityToSpawn.setYBodyRot(0);
					entityToSpawn.setYHeadRot(0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					world.addFreshEntity(entityToSpawn);
				}
        	 }
        }
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
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.damage"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.death"));
	}

	@Override
	public void die(DamageSource source) {
		super.die(source);
		Level world = /*BasaltGuardianEntity.*/this.level();
		this.setSprinting(true);
      	this.smashAnimationState.stop();
		this.bashAnimationState.stop();
		this.insertAnimationState.stop();
		this.enrageAnimationState.stop();
		this.hammerAnimationState.stop();
		this.stompAnimationState.stop();
		this.beamAnimationState.stop();
		this.reviveAnimationState.start(this.tickCount);
		TooMuchBossesModVariables.MapVariables.get(world).doesShooting = false;
		TooMuchBossesModVariables.MapVariables.get(world).syncData(world);
		//this.isDeadOrDying() = true;
	}

	@Override
	public boolean hurt(DamageSource source, float amount) {
		if ((source.is(DamageTypes.FALL))||(source.is(DamageTypes.LAVA))||(source.is(DamageTypes.DROWN)))
			return false;
		return super.hurt(source, amount);
	}

	@Override
	public boolean canChangeDimensions() {
		return false;
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
		this.bossInfo.setColor(ServerBossEvent.BossBarColor.YELLOW);
		}else{
			this.bossInfo.setColor(ServerBossEvent.BossBarColor.PURPLE);
		}
	}

	public static void init() {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.25);
		builder = builder.add(Attributes.MAX_HEALTH, 250);
		builder = builder.add(Attributes.ARMOR, 15);
		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 5);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 20);
		builder = builder.add(Attributes.FOLLOW_RANGE, 100);
		builder = builder.add(Attributes.JUMP_STRENGTH, 0);
		//builder = builder.add(Attributes.SPAWN_REINFORCEMENTS_CHANCE, 0);

		return builder;
	}
}

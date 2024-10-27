
package net.mcreator.toomuchbosses.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.piglin.PiglinBrute;
import net.minecraft.world.entity.monster.piglin.Piglin;
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
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.toomuchbosses.init.TooMuchBossesModEntities;
import net.mcreator.toomuchbosses.MoveAttackGoal;
import net.minecraft.world.item.enchantment.ThornsEnchantment;


public class WitheredScoutEntity extends Monster {
	public final AnimationState slashAnimationState = new AnimationState();
	public final AnimationState stabAnimationState = new AnimationState();
	public final AnimationState deathAnimationState = new AnimationState();
	public boolean isAttacking;
	public boolean isBackwarding;
	public int attackType;
	public float attackProgress;
	public float attackCoolDown;
	public float backwardProgress;
	public float backwardCoolDown;
	public float deathTicks;
	
	public WitheredScoutEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(TooMuchBossesModEntities.WITHERED_SCOUT.get(), world);
	}

	public WitheredScoutEntity(EntityType<WitheredScoutEntity> type, Level world) {
		super(type, world);
		//maxUpStep = 0.6f;
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
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, Piglin.class, false, false));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, PiglinBrute.class, false, false));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, Player.class, false, false));
		this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.2, false) {
			protected void checkAndPerformAttack(LivingEntity p_25557_, double p_25558_) {
          	}
			@Override
			protected double getAttackReachSqr(LivingEntity entity) {
				return this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth();
			}
		});
		this.goalSelector.addGoal(2, new MoveAttackGoal(this, 1.35D/*0.85D*/, 25.0F){
			@Override
			public boolean canUse() {
				return (!(WitheredScoutEntity.this.getTarget() == null))&&(WitheredScoutEntity.this.isBackwarding == true);
			}
		});
		this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1));
		this.targetSelector.addGoal(6, new HurtByTargetGoal(this));
		this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(8, new FloatGoal(this));
	}

	public void tick(){
	super.tick();
	if(this.isAlive()){
	float animationType = (float) this.getAttributeValue(Attributes.JUMP_STRENGTH);
	if(this.isSprinting() == true){
		if(animationType == 0.1f){
			this.slashAnimationState.start(this.tickCount);
			//this.playAnim("SLASH");
		}
		if(animationType == 0.2f){
			this.stabAnimationState.start(this.tickCount);
			//this.playAnim("STAB");
		}
	}
	if(!(this.getTarget() == null)){
			if((this.attackCoolDown == 0)&&(this.attackProgress == 0)&&(this.isAttacking == false)
				&&(this.isBackwarding == false)){
				LivingEntity living = (LivingEntity) this.getTarget();
				if(this.distanceToSqr(living) < 7){
					if(Math.random() < 0.6){
						this.attackType = 1;
						this.isAttacking = true;
						this.attackCoolDown = 20;
						this.setSprinting(true);
						this.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(0.1f);
					}else{
						this.attackType = 2;
						this.isAttacking = true;
						this.attackCoolDown = 18;
						this.setSprinting(true);
						this.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(0.2f);
						}
					}
				}
			}else{
				this.attackProgress = 0;
				this.isAttacking = false;		
			}
		if(this.isAttacking == true){
			if(this.attackType == 1){
				this.attackSlash();
			}
			if(this.attackType == 2){
				this.attackStab();
			}
			++this.attackProgress;
		}else{
			this.attackProgress = 0;
		if(!(this.getTarget() == null)){
				LivingEntity living = (LivingEntity) this.getTarget();
				if(this.distanceToSqr(living) < 10){
					if((this.getHealth() > 16)&&(this.backwardCoolDown == 0)){
					this.backwardCoolDown = 80;
					this.isBackwarding = true;
					}
				}
			}
		}
		if(this.isBackwarding == true){
			++this.backwardProgress;
			if(!(this.getTarget() == null)){
				LivingEntity living = (LivingEntity) this.getTarget();
				if((this.distanceToSqr(living) > 30)||(this.backwardProgress > 40)||((this.backwardProgress > 30)&&(this.distanceToSqr(living) < 8))){
						this.isBackwarding = false;
					}
				}
			}else{
				this.backwardProgress = 0;
			}
		}
		if(this.isAttacking == true){
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.0D);
			this.getAttribute(Attributes.KNOCKBACK_RESISTANCE).setBaseValue(11.0D);
		}else{
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.3D);
			this.getAttribute(Attributes.KNOCKBACK_RESISTANCE).setBaseValue(0.0D);
		}
		--this.attackCoolDown;
		this.attackCoolDown = Mth.clamp(this.attackCoolDown, 0, 100);
		--this.backwardCoolDown;
		this.backwardCoolDown = Mth.clamp(this.backwardCoolDown, 0, 100);
	}

	public void attackSlash(){
	if(this.attackProgress == 1){
		this.setSprinting(false);
	}
	if(this.attackProgress == 12){
			this.playSound(SoundEvents.PLAYER_ATTACK_SWEEP, 2.0F, 0.5F);
			this.attackProcedure(10.f, 7D);
		}
	if(this.attackProgress == 20){
			this.isAttacking = false;
		}
	}

	public void attackStab(){
	if(this.attackProgress == 1){
		this.setSprinting(false);
	}
	if(this.attackProgress == 12){
			this.playSound(SoundEvents.PLAYER_ATTACK_SWEEP, 1.0F, 1.0F);
			this.attackProcedure(10.f, 10D);
		}
	if(this.attackProgress == 18){
			this.isAttacking = false;
		}
	}
	
	public void attackProcedure(float damage, double range){
	if(!(this.getTarget() == null)){
		LivingEntity living = (LivingEntity) this.getTarget();
		if(this.distanceToSqr(living) < range){
				living.hurt(this.damageSources().mobAttack(this), damage);
				//living.hurt(DamageSource.mobAttack(this), damage);		
			}
		}
	}
	
	public void playAnim(String animType){
		if(animType == "SLASH"){
			this.slashAnimationState.start(this.tickCount);
		}
		if(animType == "STAB"){
			this.stabAnimationState.start(this.tickCount);
		}
		if(animType == "DEATH"){
			this.deathAnimationState.start(this.tickCount);
		}
	}
	
	protected void tickDeath() {
     Level world =/* WitheredScoutEntity.*/this.level();
     ++this.deathTicks;
      if(this.deathTicks > 50){
      	if (world instanceof ServerLevel _level){
			_level.sendParticles(ParticleTypes.POOF, this.getX(), this.getY(), this.getZ(), 20, this.getBbWidth() / 2, this.getBbHeight() / 2, this.getBbWidth() / 2, 0);
      		}
      		this.remove(Entity.RemovalReason.KILLED);
      	}
	}
	
	@Override
	public MobType getMobType() {
		return MobType.UNDEAD;
	}

	@Override
	public SoundEvent getAmbientSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.skeleton.ambient"));
	}

	@Override
	public void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.ancient_debris.break")), 0.15f, 1);
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.skeleton.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.skeleton.death"));
	}

	@Override
	public boolean hurt(DamageSource source, float amount) {
		if (source.is(DamageTypes.WITHER))
			return false;
		if (source.getMsgId().equals("witherSkull"))
			return false;
		if(this.isAttacking == true){
			this.setDeltaMovement(0, 0, 0);
		}
		return super.hurt(source, amount);
	}

	@Override
	public void die(DamageSource source) {
		super.die(source);
		this.slashAnimationState.stop();
		this.stabAnimationState.stop();
      	this.deathAnimationState.start(this.tickCount);
	}

	public static void init() {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 30);
		builder = builder.add(Attributes.ARMOR, 15);
		builder = builder.add(Attributes.ARMOR_TOUGHNESS, 8);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 8);
		builder = builder.add(Attributes.FOLLOW_RANGE, 64);
		builder = builder.add(Attributes.JUMP_STRENGTH, 0.5);
		return builder;
	}
}

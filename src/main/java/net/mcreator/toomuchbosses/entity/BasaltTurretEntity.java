
package net.mcreator.toomuchbosses.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.toomuchbosses.init.TooMuchBossesModEntities;
import net.mcreator.toomuchbosses.network.TooMuchBossesModVariables;
import net.mcreator.toomuchbosses.init.TooMuchBossesModParticleTypes;
import net.mcreator.toomuchbosses.entity.BasaltGuardianEntity;

import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;



public class BasaltTurretEntity extends Monster {
   	private static final Predicate<LivingEntity> LIVING_ENTITY_SELECTOR = (p_31504_) -> {
      return (!(p_31504_ instanceof BasaltTurretEntity)&&!(p_31504_ instanceof BasaltGuardianEntity));
   	};
	private static final EntityDataAccessor<Integer> ID_FUNGUS = SynchedEntityData.defineId(BasaltTurretEntity.class, EntityDataSerializers.INT);
	public final AnimationState shootAnimationState = new AnimationState();
	public final AnimationState deathAnimationState = new AnimationState();
	public boolean isOpen;
	public boolean isShooting;
	public boolean isAttacking;
	public boolean isShaking;
	public double shootHomingX;
	public double shootHomingY;
	public double shootHomingZ;
	public double shootX;
	public double shootY;
	public double shootZ;
	public double shooteX;
	public double shooteY;
	public double shooteZ;
	public int attackTick;
	public int attackCoolDown;
	public int turretDeathTick;
	
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(ID_FUNGUS, 1);
	}
	
	public void setFungus(int p_33594_) {
		this.entityData.set(ID_FUNGUS, p_33594_);
	}

	public int getFungus() {
		return this.entityData.get(ID_FUNGUS);
	}
	public void addAdditionalSaveData(CompoundTag p_33619_) {
		super.addAdditionalSaveData(p_33619_);
		p_33619_.putInt("fungus", this.getFungus());
	}

	public void readAdditionalSaveData(CompoundTag p_33607_) {
		super.readAdditionalSaveData(p_33607_);
		this.setFungus(p_33607_.getInt("fungus"));
	}

	public BasaltTurretEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(TooMuchBossesModEntities.BASALT_TURRET.get(), world);
	}

	public BasaltTurretEntity(EntityType<BasaltTurretEntity> type, Level world) {
		super(type, world);
		//maxUpStep = 0f;
		xpReward = 0;
		setNoAi(false);
		setPersistenceRequired();
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}


	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 0, false) {
			protected void checkAndPerformAttack(LivingEntity p_25557_, double p_25558_) {
          	}
			@Override
			protected double getAttackReachSqr(LivingEntity entity) {
				return this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth();
			}
		});
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 0, false, false, LIVING_ENTITY_SELECTOR){

		});
		this.goalSelector.addGoal(3, new RandomStrollGoal(this, 1));
	}
	
	public void baseTick(){
		super.baseTick();
		Level world = this.level();
		this.noCulling = true;
		this.setDeltaMovement(0, 0, 0);
		if(this.tickCount == 2){
			if(Math.random() > 0.5){
				this.setFungus(2);
			}
		}
		if(this.isAlive()){
			/*for(LivingEntity livingentity : this.level.getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(100.0D))) {
            	if((livingentity.isAlive() == true)&&(livingentity instanceof GlowstonebeamEntity)){
           			this.shooteX = livingentity.getX();
					this.shooteX = livingentity.getY();
					this.shooteX = livingentity.getZ();
           		}
        	}*/
			if(this.isSprinting() == true){
				this.shootAnimationState.start(this.tickCount);
			}
			if(this.isShooting == true){
			/*TooMuchBossesModVariables.MapVariables.get(world).shootX = this.shootX;
			TooMuchBossesModVariables.MapVariables.get(world).shootY = this.shootY;
			TooMuchBossesModVariables.MapVariables.get(world).shootZ = this.shootZ;
			TooMuchBossesModVariables.MapVariables.get(world).syncData(world);*/
			}
			if(this.getTarget() != null){
				if((this.isAttacking == false)&&(this.attackCoolDown == 0)){
					this.isAttacking = true;
					this.attackCoolDown = 200;
					this.setSprinting(true);
				}
			}
			if(this.isAttacking == true){
				this.attackShoot();
				++this.attackTick;
			}else{
				this.attackTick = 0;
			}
			--this.attackCoolDown;
			this.attackCoolDown = Mth.clamp(this.attackCoolDown, 0, 6000);
		}
	}

	public void attackShoot(){
		Level world = this.level();
		if(this.attackTick == 1){
			TooMuchBossesModVariables.MapVariables.get(world).isShooting = false;
			TooMuchBossesModVariables.MapVariables.get(world).syncData(world);
			this.isOpen = true;
			this.setSprinting(false);
			this.playSound(SoundEvents.SHULKER_BOX_OPEN, 2.0F, 0.5F);
		}

		if(this.attackTick == 30){
			this.playSound(SoundEvents.BEACON_POWER_SELECT, 1.0F, 2.0F);
		}

		if((this.attackTick > 30)&&(this.attackTick < 60)){
			world.addParticle((SimpleParticleType) (TooMuchBossesModParticleTypes.GLOWSTONE_CHARGE.get()), (this.getX() + Mth.nextDouble(RandomSource.create(), -2, 2)), (this.getY() + Mth.nextDouble(RandomSource.create(), -2, 2)), (this.getZ() + Mth.nextDouble(RandomSource.create(), -2, 2)), this.getX(), this.getY() + 0.9375D, this.getZ());
		}
		
		if(this.attackTick == 60){
			this.isShaking = true;
			TooMuchBossesModVariables.MapVariables.get(world).isShooting = true;
			TooMuchBossesModVariables.MapVariables.get(world).syncData(world);
			this.isShooting = true;
			this.shootHomingX = this.getX();
			this.shootHomingY = this.getY() - 1;
			this.shootHomingZ = this.getZ();
			this.shootX = this.getX();
			this.shootY = this.getY() + 2;
			this.shootZ = this.getZ();
			this.isShaking = true;
			this.playSound(SoundEvents.TOTEM_USE, 3.0F, 0.25F);
			this.playSound(SoundEvents.GENERIC_BURN, 3.0F, 0.25F);
		}

		if((this.attackTick > 60)&&(this.attackTick < 125)){
				if(this.getTarget() != null){
				Entity target = (Entity) this.getTarget();
				double dis = Math.sqrt(Math.pow((target.getX() + ((double)(Mth.sin(this.tickCount * 10)))) - this.shootHomingX, 2) + Math.pow((target.getY()  - this.shootHomingY + (target.getEyeHeight() / 2)), 2) + Math.pow((target.getZ() + ((double)(Mth.sin(this.tickCount * 10)))) - this.shootHomingZ, 2));
				this.shootHomingX = this.shootHomingX + ((((target.getX()+ ((double)(Mth.sin(this.tickCount * 10)))) - this.shootHomingX) / dis) / 5);
				this.shootHomingY = this.shootHomingY +  ((target.getY()  - this.shootHomingY + (target.getEyeHeight() / 2)) / 5);
				this.shootHomingZ = this.shootHomingZ +  ((((target.getZ() + ((double)(Mth.sin(this.tickCount * 10)))) - this.shootHomingZ) / dis) / 5);
				}
				double proceX = this.getX(); 
				double proceY = this.getY() + 1;
				double proceZ = this.getZ();
			for(int i = 0; i < 70; ++i) {
				if(this.getTarget() != null){
				Entity target = (Entity) this.getTarget();
				double dis = Math.sqrt(Math.pow(this.shootHomingX - proceX, 2) + Math.pow(this.shootHomingY - proceY, 2) + Math.pow(this.shootHomingZ - proceZ, 2));
				proceX = proceX + (((this.shootHomingX - proceX) / dis) / 7.0);
				proceY = proceY + (((this.shootHomingY - proceY) / dis) / 7.0);
				proceZ = proceZ + (((this.shootHomingZ - proceZ) / dis) / 7.0);
				this.shootX = proceX;
				this.shootY = proceY;
				this.shootZ = proceZ;
				{
					final Vec3 _center = new Vec3(proceX, proceY, proceZ);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).collect(Collectors.toList());
					for (Entity entityiterator : _entfound) {
						if((entityiterator instanceof LivingEntity)&&(!(entityiterator instanceof GlowstonebeamEntity))){
							LivingEntity entityL = (LivingEntity) entityiterator;
							if(!(entityL instanceof BasaltTurretEntity)&&!(entityL instanceof BasaltGuardianEntity)){
							entityL.hurt(this.damageSources().mobAttack(this), 5);
							//entityL.hurt(DamageSource.indirectMagic(this, this), 4.5F);
							entityL.setSecondsOnFire(3);
							if(i % 10 == 0){
								if (world instanceof ServerLevel _level){
									_level.sendParticles(ParticleTypes.FLAME, proceX, proceY, proceZ, 1, 0, 0, 0, 0.05);
      							}
							}
							//break;
							}
						}
					}
				}
				
					if (!((world.getBlockState(new BlockPos(((int)proceX), ((int)proceY), ((int)proceZ)))).getBlock() == Blocks.AIR)) {
						break;
					}
				}
			}
			if (world instanceof ServerLevel _level){
				_level.sendParticles(ParticleTypes.LARGE_SMOKE, proceX, proceY, proceZ, 1, 0.1, 0.1, 0.1, 0.05);
      		}
			this.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(this.shootX, this.shootY, this.shootZ));
			TooMuchBossesModVariables.MapVariables.get(world).shootX = this.shootX;
			TooMuchBossesModVariables.MapVariables.get(world).shootY = this.shootY;
			TooMuchBossesModVariables.MapVariables.get(world).shootZ = this.shootZ;
			TooMuchBossesModVariables.MapVariables.get(world).syncData(world);
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new GlowstonebeamEntity(TooMuchBossesModEntities.GLOWSTONEBEAM.get(), _level);
				//Vec3 vec3 = this.getBoundingBox().getCenter();
				entityToSpawn.moveTo(this.shootX, this.shootY, this.shootZ, world.getRandom().nextFloat() * 360F, 0);
				entityToSpawn.setYBodyRot(0);
				entityToSpawn.setYHeadRot(0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
				world.addFreshEntity(entityToSpawn);
		}
			//this.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(this.shootX, this.shootY, this.shootZ));
		}

		if(this.attackTick == 125){
			this.isShaking = false;
			TooMuchBossesModVariables.MapVariables.get(world).isShooting = false;
			TooMuchBossesModVariables.MapVariables.get(world).syncData(world);
			this.isShooting = false;
		}
				
		if(this.attackTick == 145){
			this.isOpen = false;
			this.playSound(SoundEvents.SHULKER_BOX_CLOSE, 2.0F, 0.5F);
		}
		
		if(this.attackTick == 160){
			this.isAttacking = false;
		}
	}

	public float getScale() {
		return 0.666666f;
	}

	protected void tickDeath() {
     Level world = this.level();
     ++this.turretDeathTick;
     if(this.turretDeathTick < 10){
		this.isShaking = true;
     }else{
		this.isShaking = false;
     }
     if(this.turretDeathTick == 20){
		this.playSound(SoundEvents.GLASS_BREAK, 2.0F, 0.5F);
		if (world instanceof ServerLevel _level){
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(this.getX(), this.getY() + 0.9375D, this.getZ()), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
			"/particle block glowstone ~ ~ ~ 0.25 0.25 0.25 1 10 normal");
		}
     }
      if(this.turretDeathTick > 60){
      	if (world instanceof ServerLevel _level){
			_level.sendParticles(ParticleTypes.POOF, this.getX(), this.getY(), this.getZ(), 20, this.getBbWidth() / 2, this.getBbHeight() / 2, this.getBbWidth() / 2, 0);
      		}
      		this.remove(Entity.RemovalReason.KILLED);
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
	public double getPassengersRidingOffset() {
		return super.getPassengersRidingOffset() + 1.5;
	}

	@Override
	public SoundEvent getAmbientSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.respawn_anchor.ambient"));
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.respawn_anchor.charge"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.respawn_anchor.deplete"));
	}

	@Override
	public boolean hurt(DamageSource source, float amount) {
		this.setDeltaMovement(0, 0, 0);
		if(source.getEntity() instanceof BasaltGuardianEntity){
			return false;
		}
		
		if (source.is(DamageTypes.CRAMMING)){
			return false;
		}
		if (source.is(DamageTypes.IN_WALL)){
			return false;
		}
		if (source.is(DamageTypes.LAVA)){
			return false;
		}		
		if (source.is(DamageTypes.FALL)){
			return false;
		}
		if(this.isOpen == false){
			if (!(source.is(DamageTypes.FELL_OUT_OF_WORLD))){
				this.playSound(SoundEvents.ANVIL_PLACE, 1.0F, 2.0F);
				return false;
			}
		}
		return super.hurt(source, amount);
	}

	@Override
	public boolean canCollideWith(Entity entity) {
		return true;
	}

	@Override
	public boolean canBeCollidedWith() {
		return true;
	}

	@Override
	public void die(DamageSource source) {
		super.die(source);
		Level world = this.level();
		this.shootAnimationState.stop();
      	this.deathAnimationState.start(this.tickCount);
      				TooMuchBossesModVariables.MapVariables.get(world).isShooting = false;
			TooMuchBossesModVariables.MapVariables.get(world).syncData(world);
	}

	public static void init() {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0);
		builder = builder.add(Attributes.MAX_HEALTH, 20);
		builder = builder.add(Attributes.ARMOR, 10);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 15);
		builder = builder.add(Attributes.ATTACK_KNOCKBACK, 0);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		return builder;
	}
}

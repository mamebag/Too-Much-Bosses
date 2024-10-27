
package net.mcreator.toomuchbosses.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;


import net.mcreator.toomuchbosses.init.TooMuchBossesModEntities;
import net.mcreator.toomuchbosses.entity.BasaltGuardianEntity;

public class BGCrackEntityEntity extends Monster {
	public boolean isFlaming;
	public float warmupDelayTicks;
	public float warmupDelayTicksOrg;
	public float rotateAngleX;
	public float rotateAngleZ;
	public double startPosX;
	public double startPosY;
	public double startPosZ;

	public BGCrackEntityEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(TooMuchBossesModEntities.BG_CRACK_ENTITY.get(), world);
	}

	public BGCrackEntityEntity(EntityType<BGCrackEntityEntity> type, Level world) {
		super(type, world);
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
		this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1));
		this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
		this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(5, new FloatGoal(this));
	}

	public void tick(){
		super.tick();
		Level world = this.level();
		this.clearFire();
		this.setDeltaMovement(0, 0, 0);
		if(!(this.getTarget() == null)){
			if(this.getTarget() instanceof BasaltGuardianEntity){
				BasaltGuardianEntity entityB = (BasaltGuardianEntity) this.getTarget();
				if(entityB.hasRevived == true){
				if(this.warmupDelayTicks == -10){
				this.playSound(SoundEvents.FIRECHARGE_USE, 1.0F, (float) Mth.clamp(Math.random() , 0.5, 1));
				}
				if(this.warmupDelayTicks < -10){
					this.isFlaming = true;
					this.customExplode();
					this.setShiftKeyDown(true);
					}else{
					if (world instanceof ServerLevel _level){
						int i = Mth.floor(this.getX());
      				  int j = Mth.floor(this.getY() - (double)1.0F);
       				 int k = Mth.floor(this.getZ());
        			BlockPos pos = new BlockPos(i, j, k);
     			   BlockState blockstate = this.level().getBlockState(pos);
						_level.sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, blockstate).setPos(pos), this.getX(), this.getY(), this.getZ(), 4, 0.1, 0.1, 0.1, 0);
						}
					}
				}else{
				if(this.warmupDelayTicks == -30){
				this.playSound(SoundEvents.FIRECHARGE_USE, 1.0F, (float) Mth.clamp(Math.random() , 0.5, 1));
				}
				if(this.warmupDelayTicks < -30){
					this.isFlaming = true;
					this.customExplode();
					this.setShiftKeyDown(true);
					}else{
					if (world instanceof ServerLevel _level){
						int i = Mth.floor(this.getX());
      				  int j = Mth.floor(this.getY() - (double)1.0F);
       				 int k = Mth.floor(this.getZ());
        			BlockPos pos = new BlockPos(i, j, k);
     			   BlockState blockstate = this.level().getBlockState(pos);
						_level.sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, blockstate).setPos(pos), this.getX(), this.getY(), this.getZ(), 4, 0.1, 0.1, 0.1, 0);
						}
					}
				}
			}
		}
		if(warmupDelayTicks == -60){
		this.remove(Entity.RemovalReason.KILLED);
		}
		this.warmupDelayTicks--;
	}

	public void customExplode(){
         for(LivingEntity livingentity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(1.0D))) {
            if (!(livingentity instanceof BasaltGuardianEntity)) {
               if(livingentity.hurtTime == 0){
				if(!(this.getTarget() == null)){
               if (!(livingentity instanceof BGCrackEntityEntity)) {
					Entity ent = (Entity) livingentity;
              		livingentity.hurt(this.damageSources().mobAttack(this.getTarget()), 7);
					ent.setSecondsOnFire(5);
                		}
                	}
               }
            }
         }	
	}
	
	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
	}

	@Override
	public boolean hurt(DamageSource source, float amount) {
		return false;
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

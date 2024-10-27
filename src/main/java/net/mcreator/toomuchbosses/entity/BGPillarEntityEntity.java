
package net.mcreator.toomuchbosses.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;

import net.mcreator.toomuchbosses.init.TooMuchBossesModEntities;
import net.mcreator.toomuchbosses.init.TooMuchBossesModMobEffects;
import net.mcreator.toomuchbosses.entity.BasaltGuardianEntity;

public class BGPillarEntityEntity extends Monster {
	public final AnimationState spawnAnimationState = new AnimationState();
	public float warmupDelayTicks;
	public float warmupDelayTicksOrg;
	public float rotateAngleX;
	public float rotateAngleZ;
	public double startPosX;
	public double startPosY;
	public double startPosZ;
	
	public void addAdditionalSaveData(CompoundTag p_33619_) {
		super.addAdditionalSaveData(p_33619_);
		p_33619_.putFloat("warmupDelayTicks", this.warmupDelayTicks);
		p_33619_.putFloat("warmupDelayTicksOrg", this.warmupDelayTicksOrg);
		p_33619_.putFloat("rotateAngleX", this.rotateAngleX);
		p_33619_.putFloat("rotateAngleZ", this.rotateAngleZ);
		p_33619_.putDouble("startPosX", this.startPosX);
		p_33619_.putDouble("startPosY", this.startPosY);
		p_33619_.putDouble("startPosZ", this.startPosZ);
	}

	public void readAdditionalSaveData(CompoundTag p_33607_) {
		super.readAdditionalSaveData(p_33607_);
		this.warmupDelayTicks = p_33607_.getFloat("warmupDelayTicks");
		this.warmupDelayTicksOrg = p_33607_.getFloat("warmupDelayTicksOrg");
		this.rotateAngleX = p_33607_.getFloat("rotateAngleX");
		this.rotateAngleZ = p_33607_.getFloat("rotateAngleZ");
		this.startPosX = p_33607_.getDouble("startPosX");
		this.startPosY = p_33607_.getDouble("startPosY");
		this.startPosZ = p_33607_.getDouble("startPosZ");
	}
	
	public BGPillarEntityEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(TooMuchBossesModEntities.BG_PILLAR_ENTITY.get(), world);
	}

	public BGPillarEntityEntity(EntityType<BGPillarEntityEntity> type, Level world) {
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
				return (double) (4.0 + entity.getBbWidth() * entity.getBbWidth());
			}
		});
	}

	public void tick(){
		super.tick();
		Level world = this.level();
		this.clearFire();
		//this.mogiBackWard();
		this.setDeltaMovement(0, 0, 0);	
		for(Entity entity : this.level().getEntitiesOfClass(Entity.class, this.getBoundingBox().inflate(2.5D))) {
            if (entity instanceof FallingBlockEntity){
            	if(entity.isShiftKeyDown() == true){
            		if (world instanceof ServerLevel _level){
            			if(entity.getDeltaMovement().y() < -0.2D ){
            			//if (!((_level.getBlockState(new BlockPos(entity.getX(), entity.getY() - 0.5, entity.getZ()))).getBlock() == Blocks.AIR)) {
						entity.remove(Entity.RemovalReason.KILLED);
						/*if (entity.getPersistentData().getDouble("blockNum") == (double) this.warmupDelayTicksOrg) {
							entity.remove(Entity.RemovalReason.KILLED);
							}*/
						}
            		}
            	}else{
            		entity.setShiftKeyDown(true);
            		entity.getPersistentData().putDouble("blockNum", (double) warmupDelayTicksOrg);
            		entity.setDeltaMovement(0, Mth.nextDouble(RandomSource.create(), 0.5D, 0.7D), 0);
						}
				}
		}
		
		if(this.tickCount == 1){
		this.teleportTo(Math.round(this.getX()), this.getY(), Math.round(this.getZ()));
		}
		if(this.warmupDelayTicks == 0){
		if (world instanceof ServerLevel _level){
		FallingBlockEntity.fall(_level, new BlockPos(((int)this.getX()), ((int)this.getY()) + 1, ((int)this.getZ())), (world.getBlockState(new BlockPos((int) this.getX(), (int) this.getY() - 1, (int) this.getZ()))));
		//BlockSplashing(_level, new BlockPos(this.getX(), this.getY(), this.getZ()), (world.getBlockState(new BlockPos(this.getX(), this.getY() - 1, this.getZ()))));
		}
		this.playSound(SoundEvents.WARDEN_ATTACK_IMPACT, 1.5F, (float) Mth.clamp(Math.random() , 0.5, 2));
		this.customExplode();
		if (world instanceof ServerLevel _level){
		int i = Mth.floor(this.getX());
        int j = Mth.floor(this.getY() - (double)1.0F);
        int k = Mth.floor(this.getZ());
        BlockPos pos = new BlockPos(i, j, k);
        BlockState blockstate = this.level().getBlockState(pos);
				_level.sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, blockstate).setPos(pos), this.getX(), this.getY(), this.getZ(), 10, 0.3, 0.1, 0.3, 0);
			}
		}
		if(warmupDelayTicks == -55){
		this.remove(Entity.RemovalReason.KILLED);
		}
		this.warmupDelayTicks--;
	}

	public void customExplode(){
         for(LivingEntity livingentity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(1.0D))) {
            if (!(livingentity instanceof BasaltGuardianEntity)) {
               if(livingentity.hurtTime == 0){
                if (!(livingentity instanceof BGPillarEntityEntity)) {
              		 //livingentity.hurt(DamageSource.mobAttack(this.getTarget()), 23.0F);
					 livingentity.hurt(this.damageSources().mobAttack(this.getTarget()), 23);
               		if(!(this.getTarget() == null)){
               			if(livingentity.hurtTime != 0){
						livingentity.addEffect(new MobEffectInstance(TooMuchBossesModMobEffects.NUMB.get(), 60, 2, false, true));
						//this.strongKnockback(entityiterator, 1);
             				 this.strongKnockback(livingentity);
               					}
                		}
                	}
               }
            }
         }	
	}

	public void mogiBackWard(){
		double Zknockback = 0;
		double Yknockback = 0;
		double Xknockback = 0;
		double dis = 0;
		for(Entity entity : this.level().getEntitiesOfClass(Entity.class, this.getBoundingBox().inflate(1.2D))) {
		if (entity instanceof BGPillarEntityEntity) {
			Xknockback = entity.getX() - this.getX();
			Yknockback = entity.getY() - this.getY();
			Zknockback = entity.getZ() - this.getZ();
			dis = Math.abs(Xknockback) + Math.abs(Yknockback) + Math.abs(Zknockback);
			if (dis != 0) {
					Xknockback = (Xknockback / dis) * 3;
					Yknockback = Math.min((Yknockback / dis) * 3, 2);
					Zknockback = (Zknockback / dis) * 3;
				} else {
					Xknockback = 0;
					Yknockback = 0;
					Zknockback = 0;
					}
				this.setDeltaMovement(new Vec3((Xknockback / 0.75D), (Yknockback / 0.75D), (Zknockback / 0.75D)));
			}
		}
	}
	
	/*public void BlockSplashing(Level p_201972_, BlockPos p_201973_, BlockState p_201974_) {
     //FallingBlockEntity fallingblockentity = new FallingBlockEntity(p_201972_, (double)p_201973_.getX() + 0.5D, (double)p_201973_.getY(), (double)p_201973_.getZ() + 0.5D, p_201974_.hasProperty(BlockStateProperties.WATERLOGGED) ? p_201974_.setValue(BlockStateProperties.WATERLOGGED, Boolean.valueOf(false)) : p_201974_);
     FallingBlockEntity fallingblockentity = new FallingBlockEntity(p_201972_, (double)p_201973_.getX() + 0.5D, (double)p_201973_.getY(), (double)p_201973_.getZ() + 0.5D, p_201974_){
      	public void tick(){
      		super.tick();
      		Entity SplashingBlock = (Entity) fallingblockentity;
      		if (!((p_201972_.getBlockState(new BlockPos(SplashingBlock.getX(), SplashingBlock.getY() - 0.2, SplashingBlock.getZ()))).getBlock() == Blocks.AIR)) {
					SplashingBlock.remove(Entity.RemovalReason.KILLED);
			}
    	  }
      	};
      Entity SplashingBlock = (Entity) fallingblockentity;
      p_201972_.setBlock(p_201973_, p_201974_.getFluidState().createLegacyBlock(), 3);
   	  SplashingBlock.setDeltaMovement(0, Mth.nextDouble(RandomSource.create(), 0.3D, 0.6D), 0);
      p_201972_.addFreshEntity(fallingblockentity);
   	}*/
	
	public void strongKnockback(Entity p_33340_) {
      double d0 = p_33340_.getX() - this.getX();
      double d1 = p_33340_.getZ() - this.getZ();
      double d2 = Math.max(d0 * d0 + d1 * d1, 0.001D);
     p_33340_.push(d0 / d2 * 2.0D, 0.5D, d1 / d2 * 2.0D);
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
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 1);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 0);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		return builder;
	}
}

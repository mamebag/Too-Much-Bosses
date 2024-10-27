
package net.mcreator.toomuchbosses.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
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
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;

import net.mcreator.toomuchbosses.init.TooMuchBossesModEntities;
import net.mcreator.toomuchbosses.entity.BasaltGuardianEntity;

public class BGEarthQuakeEntityEntity extends Monster {
	public BGEarthQuakeEntityEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(TooMuchBossesModEntities.BG_EARTH_QUAKE_ENTITY.get(), world);
	}

	public BGEarthQuakeEntityEntity(EntityType<BGEarthQuakeEntityEntity> type, Level world) {
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
	}

	public void tick(){
		super.tick();
		Level world = this.level();		
		this.clearFire();
		this.setDeltaMovement(0, 0, 0);
		if(this.tickCount > 40){
			this.remove(Entity.RemovalReason.KILLED);
		}
		if(this.tickCount < 3){
			double loop = 0;
			double XRadius2 = 0;
			double ZRadius2 = 0;
			double X = 0;
			double Y = 0;
			double Z = 0;
			loop = Math.toRadians(this.getYRot());
			XRadius2 = this.tickCount * 2;
			ZRadius2 = this.tickCount * 2;
			for (int index0 = 0; index0 < (int) (18); index0++) {
				X = this.getX() + Math.cos(loop) * XRadius2;
				Y = this.getY();
				Z = this.getZ() + Math.sin(loop) * ZRadius2;
				loop = loop + Math.toRadians(20);
				if ((this.level()) instanceof ServerLevel _level){
						int i = Mth.floor(X);
      					int j = Mth.floor(Y - (double)1.0F);
       					int k = Mth.floor(Z);
        				BlockPos pos = new BlockPos(i, j, k);
     		  	 		BlockState blockstate = this.level().getBlockState(pos);
						_level.sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, blockstate).setPos(pos), X, Y, Z, 20, 0.4, 0.2, 0.4, 0);
				}
				if (world instanceof ServerLevel _level){
					FallingBlockEntity.fall(_level, new BlockPos(((int)X), ((int)Y) + 1, ((int)Z)), (world.getBlockState(new BlockPos((int) X, (int) Y - 1, (int) Z))));
				}
			for(Entity entity : this.level().getEntitiesOfClass(Entity.class, this.getBoundingBox().inflate(6.0D))) {
           		if (!(entity instanceof BasaltGuardianEntity)){
						if(!(this.getTarget() == null)){
							entity.hurt(this.damageSources().mobAttack(this.getTarget()), 20);
							//entity.hurt(DamageSource.mobAttack(this.getTarget()), 20.0F);
						}
					}
				}
			}
		}
		for(Entity entity : this.level().getEntitiesOfClass(Entity.class, this.getBoundingBox().inflate(20.0D))) {
            if (entity instanceof FallingBlockEntity){
            	if(entity.isShiftKeyDown() == true){
            		if (world instanceof ServerLevel _level){
            			if(entity.getDeltaMovement().y() < -0.2D ){
            			entity.remove(Entity.RemovalReason.KILLED);
						}
            		}
            	}else{
            		entity.setShiftKeyDown(true);
            		entity.setDeltaMovement(0, Mth.nextDouble(RandomSource.create(), 0.5D, 0.7D), 0);
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

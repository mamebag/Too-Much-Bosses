
package net.mcreator.toomuchbosses.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.projectile.AbstractArrow;
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
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;

import net.mcreator.toomuchbosses.init.TooMuchBossesModEntities;

public class TheBossCloneEntity extends Monster {
	public double waitTicks;
	public double attackCoolDown;
	
	public TheBossCloneEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(TooMuchBossesModEntities.THE_BOSS_CLONE.get(), world);
	}
	
	public TheBossCloneEntity(EntityType<TheBossCloneEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(false);
		this.waitTicks =  Math.round(Mth.nextDouble(RandomSource.create(), 3.0, 5.0));
		if(Math.random() < 0.5){
			this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.WOODEN_AXE));
		}
		if(Math.random() < 0.5){
			this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.WOODEN_HOE));
		}
		if(Math.random() < 0.5){
			this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.WOODEN_PICKAXE));
		}
		if(Math.random() < 0.5){
			this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.WOODEN_SHOVEL));
		}
		if(Math.random() < 0.5){
			this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.WOODEN_SWORD));
		}
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false) {
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
		Level world = TheBossCloneEntity.this.level();
			if(this.attackCoolDown == 0){
				this.setPose(Pose.STANDING);
			}
			if(this.tickCount == 2){
				this.playSound(SoundEvents.ENDERMAN_TELEPORT, 1.0F, 1.0F);
				this.moveTo(this.getX() + Mth.nextDouble(RandomSource.create(), -10.0, 10.0), this.getY(), this.getZ() + Mth.nextDouble(RandomSource.create(), -10.0, 10.0), this.getYRot(), this.getXRot());
			}
			if(this.tickCount > 5){
			if(!(this.getTarget() == null)){
			if(this.getTarget() instanceof Mob){
				Mob mob = (Mob) this.getTarget();
				if(!(mob.getTarget() instanceof TheBossCloneEntity)){
					mob.setTarget(this);
					}
				}
			}
			this.attackCoolDown = this.attackCoolDown - 1;
			this.attackCoolDown = Mth.clamp(this.attackCoolDown, 0, 200);
		}
	}
	
	public boolean doHurtTarget(Entity entityIn) {
		entityIn.invulnerableTime = 0;
		this.attackCoolDown = 10;
		this.setPose(Pose.FALL_FLYING);
		if(Math.random() < 0.5){
			this.playSound(SoundEvents.ENDERMAN_TELEPORT, 1.0F, 1.0F);
			this.moveTo(this.getX() + Mth.nextDouble(RandomSource.create(), -5.0, 5.0), this.getY(), this.getZ() + Mth.nextDouble(RandomSource.create(), -5.0, 5.0), this.getYRot(), this.getXRot());
		}
		return super.doHurtTarget(entityIn);
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
		Level world = TheBossCloneEntity.this.level();
		if((!(source.is(DamageTypes.EXPLOSION)))&&(!(source.is(DamageTypes.FALL)))&&(!(source.is(DamageTypes.LAVA)))){
		if(Math.random() < 0.52){
			this.playSound(SoundEvents.ENDERMAN_TELEPORT, 1.0F, 1.0F);
			this.moveTo(this.getX() + Mth.nextDouble(RandomSource.create(), -5.0, 5.0), this.getY(), this.getZ() + Mth.nextDouble(RandomSource.create(), -5.0, 5.0), this.getYRot(), this.getXRot());
			return false;
		}
		this.playSound(SoundEvents.SHULKER_BULLET_HURT, 2.0F, 1.0F);
		if (world instanceof ServerLevel _level){
			_level.sendParticles(ParticleTypes.POOF, this.getX(), this.getY(), this.getZ(), 40, this.getBbWidth() / 2, this.getBbHeight() / 2, this.getBbWidth() / 2, 0);
      	}
		this.remove(Entity.RemovalReason.KILLED);
		}
		if ((source.is(DamageTypes.FALL))||(source.is(DamageTypes.EXPLOSION))){
			return false;
		}
		return super.hurt(source, amount);
	}

	public static void init() {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 1);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
		builder = builder.add(Attributes.FOLLOW_RANGE, 100);
		return builder;
	}
}

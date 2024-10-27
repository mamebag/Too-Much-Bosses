
package net.mcreator.toomuchbosses.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.OpenDoorGoal;
import net.minecraft.world.entity.ai.goal.MoveBackToVillageGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;

import net.mcreator.toomuchbosses.init.TooMuchBossesModEntities;
//import net.mcreator.toomuchbosses.init.TooMuchBossesModBlocks;
import net.mcreator.toomuchbosses.network.TooMuchBossesModVariables;
import net.mcreator.toomuchbosses.init.TooMuchBossesModMobEffects;
import net.mcreator.toomuchbosses.entity.SpitterEntity;
import net.mcreator.toomuchbosses.CrackBlockEffect;
import net.mcreator.toomuchbosses.MoveAttackGoal;
import net.mcreator.toomuchbosses.TooMuchBossesMod;


import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;
import java.util.function.Predicate;
import net.minecraftforge.client.event.sound.SoundEvent.SoundSourceEvent;
import com.sun.jna.platform.win32.COM.IStream;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;

public class MogiPlayerEntity extends Monster {
   	private static final Predicate<LivingEntity> LIVING_ENTITY_SELECTOR = (p_31504_) -> {
      return (!(p_31504_ instanceof SpitterEntity)&&!(p_31504_ instanceof MogiPlayerEntity));
   	};

   	public ItemStack mainhand;
	public ItemStack offhand;
	public ItemStack head;
	public ItemStack chest;
	public ItemStack leg;
	public ItemStack foot;

	public boolean isAttacking;
	public boolean isEating;
	public boolean isBackwarding;
	public boolean isAvoiding;
	public boolean isBlockingWithShield;
	public boolean isShootingWithBow;
	public boolean shouldBlockWithShiled;
	public boolean hasEatenAnApple;
	public boolean isTargetFarAway;
	public boolean isTargetTooHigh;
	
	public double skillType;
	
	public double attackTicks;
	//public double eatTicks;
	
	public double meleeCoolDown;		//1
	public double bowCoolDown;			//2
	public double shieldCoolDown;		//3
	public double pileUpCoolDown;		//4
	public double waterBucketCoolDown;	//5
	public double eatSteakCoolDown;		//6
	public double eatAnAppleCoolDown;	//7

	public double DPSfromEnemy;
	public double damagefromEnemy;
	
	public Vec3 waterPos = new Vec3(0,0,0);
	public Vec3 avoidPos = new Vec3(0,0,0);
	
	public MogiPlayerEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(TooMuchBossesModEntities.MOGI_PLAYER.get(), world);
	}

	public MogiPlayerEntity(EntityType<MogiPlayerEntity> type, Level world) {
		super(type, world);
		//maxUpStep = 0.6f;
		xpReward = 0;
		setNoAi(false);
		this.setLeftHanded(false);
		this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_SWORD));
		this.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(Items.SHIELD));
		this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Items.IRON_HELMET));
		this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Items.IRON_CHESTPLATE));
		this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Items.IRON_LEGGINGS));
		this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Items.IRON_BOOTS));
		if(Math.random() < 0.1){
			this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.NETHERITE_SWORD));
			this.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(Items.SHIELD));
			this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Items.NETHERITE_HELMET));
			this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Items.NETHERITE_CHESTPLATE));
			this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Items.NETHERITE_LEGGINGS));
			this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Items.NETHERITE_BOOTS));
		}
		if(Math.random() < 0.2){
			this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.DIAMOND_SWORD));
			this.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(Items.SHIELD));
			this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Items.DIAMOND_HELMET));
			this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Items.DIAMOND_CHESTPLATE));
			this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Items.DIAMOND_LEGGINGS));
			this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Items.DIAMOND_BOOTS));
		}
		if(Math.random() < 0.2){
			this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.GOLDEN_SWORD));
			this.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(Items.SHIELD));
			this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Items.GOLDEN_HELMET));
			this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Items.GOLDEN_CHESTPLATE));
			this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Items.GOLDEN_LEGGINGS));
			this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Items.GOLDEN_BOOTS));
		}
		if(Math.random() < 0.2){
			this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.WOODEN_SWORD));
			this.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(Items.SHIELD));
			this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Items.LEATHER_HELMET));
			this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Items.LEATHER_CHESTPLATE));
			this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Items.LEATHER_LEGGINGS));
			this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Items.LEATHER_BOOTS));
		}
		this.mainhand = this.getItemBySlot(EquipmentSlot.MAINHAND);
		this.offhand = this.getItemBySlot(EquipmentSlot.OFFHAND);
		this.head = this.getItemBySlot(EquipmentSlot.HEAD);
		this.chest = this.getItemBySlot(EquipmentSlot.CHEST);
		this.leg = this.getItemBySlot(EquipmentSlot.LEGS);
		this.foot = this.getItemBySlot(EquipmentSlot.FEET);
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
		this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, LivingEntity.class, (float) 15, 1, 1.2) {
			@Override
			public boolean canUse() {
				return super.canUse() && MogiPlayerEntity.this.isAvoiding;
			}

			@Override
			public boolean canContinueToUse() {
				return super.canContinueToUse() && (MogiPlayerEntity.this.getHealth() < 8)/*||(MogiPlayerEntity.this.isAvoiding)*/;
			}
		});
		this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2, false) {
			protected void checkAndPerformAttack(LivingEntity p_25557_, double p_25558_) {
          	}
			@Override
			protected double getAttackReachSqr(LivingEntity entity) {
				return this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth();
			}
		});
		this.goalSelector.addGoal(3, new OpenDoorGoal(this, true));
		this.goalSelector.addGoal(4, new OpenDoorGoal(this, false));
		this.goalSelector.addGoal(5, new MoveAttackGoal(this, 1.35D, 25.0F){
			@Override
			public boolean canUse() {
				return (MogiPlayerEntity.this.getTarget() != null)&&(MogiPlayerEntity.this.isBackwarding == true);
			}
		});
		this.goalSelector.addGoal(6, new MoveBackToVillageGoal(this, 0.6, false));
		this.goalSelector.addGoal(7, new RandomStrollGoal(this, 1));
		this.targetSelector.addGoal(8, new HurtByTargetGoal(this));
		this.goalSelector.addGoal(9, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(10, new FloatGoal(this));
	}

	public void tick(){
		super.tick();
		Level world = this.level();
		if((this.tickCount > 2)&&(this.isEating != true)&&(this.isAttacking != true)&&(this.isBackwarding != true)&&(this.isAvoiding != true)&&(this.isBlockingWithShield != true)&&(this.isShootingWithBow != true)){
			this.mainhand = this.getItemBySlot(EquipmentSlot.MAINHAND);
			this.offhand = this.getItemBySlot(EquipmentSlot.OFFHAND);
			this.head = this.getItemBySlot(EquipmentSlot.HEAD);
			this.chest = this.getItemBySlot(EquipmentSlot.CHEST);
			this.leg = this.getItemBySlot(EquipmentSlot.LEGS);
			this.foot = this.getItemBySlot(EquipmentSlot.FEET);
		}
		if(this.tickCount % 60 == 0){
			this.DPSfromEnemy = 0;
			this.shouldBlockWithShiled = false;
		}
		if(this.isAlive()){
			if(this.getTarget() != null){
			boolean found = true;
			this.isTargetTooHigh = false;
			/*if(this.tickCount % 40 == 0){
				this.isTargetTooHigh = false;
			}
			if(((this.getTarget().getY()) > this.getY())&&(Math.abs((this.getTarget().getY()) - this.getY()) > 6)){
					this.isTargetTooHigh = true;
			}*/
			{
			final Vec3 _center = new Vec3(this.getX(), this.getY(), this.getZ());
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10 / 2d), e -> true).stream()
					.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).collect(Collectors.toList());
			for (Entity entityiterator : _entfound) {
				LivingEntity target = (LivingEntity) this.getTarget();
				if(entityiterator == target){
					found = false;
						}
					}
				}
				this.isTargetFarAway = found;
				if(this.DPSfromEnemy > 3){
					this.shouldBlockWithShiled = true;
				}else{
					this.shouldBlockWithShiled = false;
				}
				if(damagefromEnemy > 6){
					this.shouldBlockWithShiled = true;
				}
				if(this.isAvoiding == true){
					this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.3D);
					this.shouldBlockWithShiled = false;
					//this.getNavigation().moveTo(this.getX() + (double)(Mth.sin(this.tickCount * 2) * 10) , this.getY(), this.getZ() + (double)(Mth.cos(this.tickCount * 2) * 10) , 1.3);
				}else{
					if(this.isShootingWithBow){
						this.isBackwarding = true;
						this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.2D);
					}else{
						if(this.isBlockingWithShield){
							this.isBackwarding = false;
							this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.0D);
						}else{
							this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.3D);
						}
					}
					if((this.skillType == 4)&&(this.isAttacking == true)){
						this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.0D);
					}
				}
				if((this.isEating != true)&&(this.isAttacking != true)&&(this.eatSteakCoolDown == 0)&&(this.getHealth() < 8)){
					this.isAttacking = true;
					this.attackTicks = 0;
					this.eatSkills();
				}
				if(this.isAttacking != true){
					this.isAttacking = true;
					this.attackTicks = 0;
					this.attackSkills();
				}
			}else{
				this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.3D);
				if((this.isEating != true)&&(this.isAttacking != true)&&(this.eatSteakCoolDown == 0)&&(this.getHealth() < 8)){
					this.isAttacking = true;
					this.attackTicks = 0;
					this.eatSkills();
				}
			}
			if(this.isAttacking == true){
				if(this.skillType != 5){
						if(this.skillType != 5){
							if(this.skillType == 1){
								this.meleeAttack();
							}
							if(this.skillType == 2){
								this.bowAttack();
							}
							if(this.skillType == 3){
								this.shieldAttack();
							}
							if(this.skillType == 4){
								this.pileUpAttack();
							}
							if(this.skillType == 5){
							//none
							}
					}
					if(this.skillType == 6){
						this.eatSteak();
					}
					if(this.skillType == 7){
						this.eatAnApple();
					}
					++this.attackTicks;
				}
			}else{
				if(this.getHealth() < 8){
					this.isAvoiding = true;
				}else{
					//this.isAvoiding = true;
				}
			}
		}
		--this.meleeCoolDown;
		this.meleeCoolDown = Mth.clamp(this.meleeCoolDown, 0, 300);
		--this.bowCoolDown;
		this.bowCoolDown = Mth.clamp(this.bowCoolDown, 0, 300);
		--this.shieldCoolDown;
		this.shieldCoolDown = Mth.clamp(this.shieldCoolDown, 0, 300);
		--this.pileUpCoolDown;
		this.pileUpCoolDown = Mth.clamp(this.pileUpCoolDown, 0, 300);
		--this.waterBucketCoolDown;
		this.waterBucketCoolDown = Mth.clamp(this.waterBucketCoolDown, 0, 300);
		--this.eatSteakCoolDown;
		this.eatSteakCoolDown = Mth.clamp(this.eatSteakCoolDown, 0, 300);
	}

	public void attackSkills(){
		if((this.shouldBlockWithShiled)&&(this.shieldCoolDown == 0)){
			if(this.shouldBlockWithShiled){
				//shield
				this.skillType = 3;
				this.attackTicks = 0;
				this.shieldCoolDown = 80;
				this.isAttacking = true;
			}
		}else{
		if(this.isTargetTooHigh){
			if(this.pileUpCoolDown == 0){
				//pileup
				this.skillType = 4;
				this.attackTicks = 0;
				this.pileUpCoolDown = 200;
				this.isAttacking = true;
			}
		}else{
			if(this.isTargetFarAway){
				if(this.bowCoolDown == 0){
					//bow
					this.skillType = 2;
					this.attackTicks = 0;
					this.bowCoolDown = 100;
					this.isAttacking = true;
				}
			}else{
				if(this.meleeCoolDown == 0){
					//melee
					this.skillType = 1;
					this.attackTicks = 0;
					this.meleeCoolDown = 80;
					this.isAttacking = true;
					}
				}
			}
		}
	}

	public void eatSkills(){
		if(this.getTarget() != null){
			if((this.eatSteakCoolDown == 0)&&(this.hasEatenAnApple == false)&&((this.getTarget().getMaxHealth() >= 50)||((this.getTarget().getAttributeValue(Attributes.ARMOR)) >= 14))){
				//eatAnApple
				this.hasEatenAnApple = true;
				this.skillType = 7;
				this.attackTicks = 0;
				this.eatSteakCoolDown = 60;
				this.isAttacking = true;
			}
		}
		if((this.eatSteakCoolDown == 0)&&(this.getHealth() < 8)){
			//eatSteak
			this.skillType = 6;
			this.attackTicks = 0;
			this.eatSteakCoolDown = 150;
			this.isAttacking = true;
		}
	}

	public void meleeAttack(){
		Level world = this.level();
		if(this.attackTicks == 1){
			if(this.getTarget() != null){
				if(this.distanceToSqr(((Entity)(this.getTarget()))) > 10){
					this.meleeCoolDown = 0;
					this.isAttacking = false;
				}
			}
		}
		if(this.attackTicks == 10){
			if(this.getTarget() != null){
			//if(this.getHealth() < 16){
			this.isBackwarding = true;
			//}
			this.swing(InteractionHand.MAIN_HAND, true);
			if(this.distanceToSqr(((Entity)(this.getTarget()))) < 10/*this.getAttackReach((LivingEntity)(this.getTarget()))*/){
				this.doHurtTarget(this.getTarget());
				}
			}
		}
		if(this.attackTicks == 20){
			if(this.getTarget() != null){
			this.swing(InteractionHand.MAIN_HAND, true);
			if(this.distanceToSqr(((Entity)(this.getTarget()))) < 10/*this.getAttackReach((LivingEntity)(this.getTarget()))*/){
				this.doHurtTarget(this.getTarget());
				if((this.getTarget().hurtTime) != 0){
							this.playSound(SoundEvents.PLAYER_ATTACK_WEAK, 2.0F, 1.0F);
						}
					}
				}
			}
		if(this.attackTicks == 30){
			if(this.getTarget() != null){
			this.swing(InteractionHand.MAIN_HAND, true);
			if(this.distanceToSqr(((Entity)(this.getTarget()))) < 10/*this.getAttackReach((LivingEntity)(this.getTarget()))*/){
				this.doHurtTarget(this.getTarget());
				if((this.getTarget().hurtTime) != 0){
							this.playSound(SoundEvents.PLAYER_ATTACK_STRONG, 2.0F, 1.0F);
						}
					}
				}
			}
		if(this.getHealth() < 8){
			this.stopAttacking();
		}
		if(this.attackTicks == 40){
			if(this.getTarget() != null){
			if(this.getTarget().isBlocking()){
				this.mainhand = this.getItemBySlot(EquipmentSlot.MAINHAND);
				this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_AXE));
				
			}
			if(Math.random() < 0.4){
				if(this.distanceToSqr(((Entity)(this.getTarget()))) < 10/*this.getAttackReach((LivingEntity)(this.getTarget()))*/){
					this.setDeltaMovement(0, 0.45 ,0);
					}
				}
			}
		}
		if(this.attackTicks == 50){
			if(this.getTarget() != null){
			this.swing(InteractionHand.MAIN_HAND, true);
			if(this.distanceToSqr(((Entity)(this.getTarget()))) < 10/*this.getAttackReach((LivingEntity)(this.getTarget()))*/){
				if(Math.abs((this.getDeltaMovement().y)) > 0.2){
				this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(2 * (this.getAttributeValue(Attributes.ATTACK_DAMAGE)));
				this.doHurtTarget(this.getTarget());
				if(this.getTarget() instanceof Mob){
					if((this.getTarget().hurtTime) != 0){
						Mob target = (Mob) this.getTarget();
							this.playSound(SoundEvents.PLAYER_ATTACK_CRIT, 2.0F, 1.0F);
							if (world instanceof ServerLevel _level){
								_level.sendParticles(ParticleTypes.CRIT, this.getTarget().getX(), this.getTarget().getY(), this.getTarget().getZ(), 40, target.getBbWidth() / 2, target.getBbHeight() / 2, target.getBbWidth() / 2, 0);
								}
      						}
						}else{
							this.playSound(SoundEvents.PLAYER_ATTACK_CRIT, 2.0F, 1.0F);
							if (world instanceof ServerLevel _level){
								_level.sendParticles(ParticleTypes.CRIT, this.getTarget().getX(), this.getTarget().getY(), this.getTarget().getZ(), 40, this.getTarget().getBbWidth() / 2, this.getTarget().getBbHeight() / 2, this.getTarget().getBbWidth() / 2, 0);
							}
						}
					}else{
						this.doHurtTarget(this.getTarget());
						}
					}
				}
			}
			if(this.attackTicks == 60){
				this.isBackwarding = false;
				this.stopAttacking();
			}
	}

	public void bowAttack(){
		Level world = /*MogiPlayerEntity.*/this.level();
		if(this.attackTicks == 1){
			this.setSprinting(true);
			this.isShootingWithBow = true;
			this.mainhand = this.getItemBySlot(EquipmentSlot.MAINHAND);
		}
		if(this.attackTicks == 2){
			this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.BOW));
			this.startUsingItem(ProjectileUtil.getWeaponHoldingHand(this, item -> item instanceof BowItem));
		}
		if((this.attackTicks < 20)&&(this.attackTicks > 2)){
			this.startUsingItem(ProjectileUtil.getWeaponHoldingHand(this, item -> item instanceof BowItem));
		}
		if(this.attackTicks == 20){
			if(this.getTarget() != null){
			Entity entity = (Entity) this;
			Entity target = (Entity) this.getTarget();
			//this.setDeltaMovement(new Vec3((((target.getX() - this.getX()) / dis) * 3), /*(((target.getY() - this.getY()) / dis) * 3)*/0.4D, (((target.getZ() - this.getZ()) / dis) * 3)));
			if (world instanceof ServerLevel projectileLevel) {
			Projectile _entityToSpawn = new Object() {
				public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
					AbstractArrow entityToSpawn = new Arrow(EntityType.ARROW, level);
					entityToSpawn.setOwner(shooter);
					entityToSpawn.setBaseDamage(damage);
					entityToSpawn.setKnockback(knockback);
					entityToSpawn.setCritArrow(true);
								double dis = 0;
			dis = Math.sqrt(Math.pow(target.getX() - entity.getX(), 2) + Math.pow(target.getY() - entity.getY(), 2) + Math.pow(target.getZ() - entity.getZ(), 2));
					entityToSpawn.setDeltaMovement(new Vec3((((target.getX() - entity.getX()) / dis) * 3), ((target.getY() - entity.getY()) / dis) * 3, (((target.getZ() - entity.getZ()) / dis) * 3)));
					return entityToSpawn;
				}
			}.getArrow(projectileLevel, entity, 2, 1);
			_entityToSpawn.setPos(this.getX(), this.getY() + 1.5, this.getZ());
			_entityToSpawn.shoot(/*(((target.getX() - this.getX()) / dis) * 3)*/0
								, //(((target.getY() - this.getY()) / dis) * 3)
								0,
								0/*(((target.getZ() - this.getZ()) / dis) * 3)*/, 2.0f, 0);
			double dis = Math.sqrt(Math.pow(target.getX() - entity.getX(), 2) + Math.pow(target.getY() - entity.getY(), 2) + Math.pow(target.getZ() - entity.getZ(), 2));
			_entityToSpawn.setDeltaMovement(new Vec3((((target.getX() - entity.getX()) / dis) * 3), ((target.getY() - entity.getY()) / dis) * 3, (((target.getZ() - entity.getZ()) / dis) * 3)));
			projectileLevel.addFreshEntity(_entityToSpawn);
				}
			}
		}
		if(this.attackTicks == 50){
			this.stopAttacking();
		}
	}

	public void shieldAttack(){
		if(this.attackTicks == 1){
			this.isBlockingWithShield = true;
			this.setShiftKeyDown(true);
			this.startUsingItem(ProjectileUtil.getWeaponHoldingHand(this, item -> item instanceof ShieldItem));
		}
		if(this.attackTicks == 40){
			this.stopAttacking();
			//this.
		}
	}

	public void pileUpAttack(){
		Level world = /*MogiPlayerEntity.*/this.level();
		this.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(this.getX(), this.getY() - 1, this.getZ()));
		if(this.attackTicks == 1){
			this.mainhand = this.getItemBySlot(EquipmentSlot.MAINHAND);
		}
		if(this.attackTicks == 2){
			//this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Blocks.COBBLESTONE));
		}
		
		if(this.attackTicks % 20 == 0){
			this.setDeltaMovement(0, 0.5, 0);
		}
		if(this.attackTicks % 30 == 0){
			this.swing(InteractionHand.MAIN_HAND, true);
			this.playSound(SoundEvents.STONE_PLACE, 2.0F, 1.0F);
			//world.setBlock(new BlockPos(((int)this.getX()), ((int)this.getY()) - 1, ((int)this.getZ()), TooMuchBossesModBlocks.CUSTOM_COBBLE_STONE.get().defaultBlockState(), 3);
		}
		if(this.attackTicks > 140){
			this.stopAttacking();
		}
		if(this.getTarget() == null){
			this.stopAttacking();
		}
		if(this.getTarget() != null){
			if(this.getY() >= (this.getTarget().getY())){
				this.stopAttacking();
			}
		}
	}

	public void eatSteak(){
		if(this.attackTicks == 1){
			this.mainhand = this.getItemBySlot(EquipmentSlot.MAINHAND);
		}
		if(this.attackTicks == 2){
			this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.COOKED_BEEF));
			this.isAvoiding = true;
		}
		if((this.attackTicks % 5 == 0)&&(this.attackTicks < 40)){
			this.swing(InteractionHand.MAIN_HAND, true);
			this.playSound(SoundEvents.GENERIC_EAT, 1.0F, 1.0F);
		}
		if(this.attackTicks == 40){
			this.swing(InteractionHand.MAIN_HAND, true);
			this.playSound(SoundEvents.PLAYER_BURP, 1.0F, 1.0F);
			this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.AIR));
			this.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 150, (int) 2));
		}
		if(this.attackTicks == 50){
			this.setItemSlot(EquipmentSlot.MAINHAND, this.mainhand);
		}
		if(this.attackTicks == 60){
			this.isAvoiding = false;
			this.stopAttacking();
		}
	}

	public void eatAnApple(){
		if(this.attackTicks == 1){
			this.mainhand = this.getItemBySlot(EquipmentSlot.MAINHAND);
			this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.ENCHANTED_GOLDEN_APPLE));
			this.isAvoiding = true;
		}
		if((this.attackTicks % 5 == 0)&&(this.attackTicks < 40)){
			this.swing(InteractionHand.MAIN_HAND, true);
			this.playSound(SoundEvents.GENERIC_EAT, 1.0F, 1.0F);
		}
		if(this.attackTicks == 40){
			this.swing(InteractionHand.MAIN_HAND, true);
			this.playSound(SoundEvents.PLAYER_BURP, 1.0F, 1.0F);
			this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.AIR));
			this.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 400, (int) 2));
			this.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 2400, (int) 4));
			this.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000, (int) 1));
			this.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000, (int) 1));
		}
		if(this.attackTicks == 50){
			this.setItemSlot(EquipmentSlot.MAINHAND, this.mainhand);
			this.isAvoiding = false;
			this.stopAttacking();
		}
	}
	public void stopAttacking(){
		this.stopUsingItem();
		this.isShootingWithBow = false;
		this.isBlockingWithShield = false;
		this.isAttacking = false;
		this.setShiftKeyDown(false);
		this.setSprinting(false);
		this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(1);
		this.setItemSlot(EquipmentSlot.MAINHAND, this.mainhand);
	}

	protected double getAttackReach(LivingEntity entity) {
		return this.getBbWidth() * this.getBbWidth() + entity.getBbWidth();
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
	public boolean hurt(DamageSource source, float amount) {
		Level world = /*MogiPlayerEntity.*/this.level();
		if(source.is(DamageTypes.FALL)){
			if(this.isAlive()){
			if(/*(this.isAttacking == false)&&*/(this.waterBucketCoolDown == 0)){
				this.stopAttacking();
				this.mainhand = this.getItemBySlot(EquipmentSlot.MAINHAND);
				this.isAttacking = true;
				this.skillType = 5;
				this.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(this.getX(), this.getY() - 1, this.getZ()));
				this.waterBucketCoolDown = 1500;
				this.waterPos = new Vec3(this.getX(),this.getY(),this.getZ());
				this.swing(InteractionHand.MAIN_HAND, true);
				this.playSound(SoundEvents.BUCKET_EMPTY, 2.0F, 1.0F);
				this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.BUCKET));
				world.setBlock(new BlockPos(((int)this.getX()), ((int)this.getY()), ((int)this.getZ())), Blocks.WATER.defaultBlockState(), 3);
				TooMuchBossesMod.queueServerWork(20, () -> {
					this.playSound(SoundEvents.BUCKET_FILL, 2.0F, 1.0F);
					this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.WATER_BUCKET));
					this.swing(InteractionHand.MAIN_HAND, true);
					world.setBlock(new BlockPos(((int)this.waterPos.x), ((int)this.waterPos.y), ((int)this.waterPos.z)), Blocks.AIR.defaultBlockState(), 3);
				});
				TooMuchBossesMod.queueServerWork(30, () -> {
					this.setItemSlot(EquipmentSlot.MAINHAND, this.mainhand);
					//this.swing(InteractionHand.MAIN_HAND, true);
					//world.setBlock(new BlockPos(this.waterPos.x, this.waterPos.y, this.waterPos.z), Blocks.AIR.defaultBlockState(), 3);
					this.isAttacking = false;
					});
				return false;
				}
			}
		}
		if((source.getEntity() instanceof MogiPlayerEntity)||(source.getEntity() instanceof SpitterEntity)){
			return false;
		}
		if(source.getEntity() != null){
			++this.DPSfromEnemy;
		}
		if(amount > 6){
			if(this.hurtTime != 0){
				this.shouldBlockWithShiled = true;
			}
		}
		this.damagefromEnemy = amount;
		return super.hurt(source, amount);
	}

	@Override
	public void die(DamageSource source) {
		super.die(source);
		Level world = /*MogiPlayerEntity.*/this.level();
		if (!world.isClientSide()) {
			ItemEntity entityToSpawn = new ItemEntity(world, this.getX(), this.getY(), this.getZ(), this.getItemBySlot(EquipmentSlot.MAINHAND));
			entityToSpawn.setPickUpDelay(10);
			entityToSpawn.setDeltaMovement((Math.random() - 0.5) * 2, (Math.random() - 0.5) * 2, (Math.random() - 0.5) * 2);
			world.addFreshEntity(entityToSpawn);
		}
		if (!world.isClientSide()) {
			ItemEntity entityToSpawn = new ItemEntity(world, this.getX(), this.getY(), this.getZ(), this.getItemBySlot(EquipmentSlot.MAINHAND));
			entityToSpawn.setPickUpDelay(10);
			entityToSpawn.setDeltaMovement((Math.random() - 0.5) * 2, (Math.random() - 0.5) * 2, (Math.random() - 0.5) * 2);
			world.addFreshEntity(entityToSpawn);
		}
		if (!world.isClientSide()) {
			ItemEntity entityToSpawn = new ItemEntity(world, this.getX(), this.getY(), this.getZ(), this.getItemBySlot(EquipmentSlot.OFFHAND));
			entityToSpawn.setPickUpDelay(10);
			entityToSpawn.setDeltaMovement((Math.random() - 0.5) * 2, (Math.random() - 0.5) * 2, (Math.random() - 0.5) * 2);
			world.addFreshEntity(entityToSpawn);
		}
		if (!world.isClientSide()) {
			ItemEntity entityToSpawn = new ItemEntity(world, this.getX(), this.getY(), this.getZ(), this.getItemBySlot(EquipmentSlot.CHEST));
			entityToSpawn.setPickUpDelay(10);
			entityToSpawn.setDeltaMovement((Math.random() - 0.5) * 2, (Math.random() - 0.5) * 2, (Math.random() - 0.5) * 2);
			world.addFreshEntity(entityToSpawn);
		}
		if (!world.isClientSide()) {
			ItemEntity entityToSpawn = new ItemEntity(world, this.getX(), this.getY(), this.getZ(), this.getItemBySlot(EquipmentSlot.LEGS));
			entityToSpawn.setPickUpDelay(10);
			entityToSpawn.setDeltaMovement((Math.random() - 0.5) * 2, (Math.random() - 0.5) * 2, (Math.random() - 0.5) * 2);
			world.addFreshEntity(entityToSpawn);
		}
		if (!world.isClientSide()) {
			ItemEntity entityToSpawn = new ItemEntity(world, this.getX(), this.getY(), this.getZ(), this.getItemBySlot(EquipmentSlot.FEET));
			entityToSpawn.setPickUpDelay(10);
			entityToSpawn.setDeltaMovement((Math.random() - 0.5) * 2, (Math.random() - 0.5) * 2, (Math.random() - 0.5) * 2);
			world.addFreshEntity(entityToSpawn);
		}
			this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.AIR));
			this.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(Items.AIR));
			this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Items.AIR));
			this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Items.AIR));
			this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Items.AIR));
			this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Items.AIR));
	}
	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		if(this.isBlockingWithShield){
			return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.block"));
		}
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.death"));
	}

	public static void init() {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 20);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 1);
		builder = builder.add(Attributes.FOLLOW_RANGE, 64);
		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 0.5);
		return builder;
	}
}

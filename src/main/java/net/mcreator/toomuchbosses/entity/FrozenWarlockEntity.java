
package net.mcreator.toomuchbosses.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.AbstractIllager;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.toomuchbosses.procedures.LiftIceProcedure;
import net.mcreator.toomuchbosses.procedures.BGflameEffectsProcedure;
import net.mcreator.toomuchbosses.init.TooMuchBossesModMobEffects;
import net.mcreator.toomuchbosses.init.TooMuchBossesModEntities;
import net.mcreator.toomuchbosses.init.TooMuchBossesModBlocks;
import net.mcreator.toomuchbosses.MoveAttackGoal;

import javax.annotation.Nullable;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

public class FrozenWarlockEntity extends Monster {
	public static final EntityDataAccessor<Integer> DATA_yo = SynchedEntityData.defineId(FrozenWarlockEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Boolean> IS_FROZEN = SynchedEntityData.defineId(FrozenWarlockEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<String> DATA_yooo = SynchedEntityData.defineId(FrozenWarlockEntity.class, EntityDataSerializers.STRING);
	public final AnimationState iceWallFrontAnimationState = new AnimationState();
	public final AnimationState iceWallFrontBiggerAnimationState = new AnimationState();
	public final AnimationState everfrostAnimationState = new AnimationState();
	public final AnimationState iceTrapAnimationState = new AnimationState();
	public final AnimationState iceTowerAnimationState = new AnimationState();
	public final AnimationState waterPotionAnimationState = new AnimationState();
	public final AnimationState iceRushAnimationState = new AnimationState();
	public final AnimationState iceControlAnimationState = new AnimationState();
	public boolean isAttacking;
	public boolean isBackwarding;
	public boolean isBreaking;
	public int attackType;
	public float attackProgress;
	public float meleeAttackCoolDown;
	public float rangedAttackCoolDown;
	public float breakingTicks;
	public float deathTicks;
	public double iceTargetX;
	public double iceTargetY;
	public double iceTargetZ;
	private final ServerBossEvent bossInfo = new ServerBossEvent(this.getDisplayName(), ServerBossEvent.BossBarColor.WHITE, ServerBossEvent.BossBarOverlay.PROGRESS);

	public FrozenWarlockEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(TooMuchBossesModEntities.FROZEN_WARLOCK.get(), world);
	}

	public FrozenWarlockEntity(EntityType<FrozenWarlockEntity> type, Level world) {
		super(type, world);
		setMaxUpStep(2f);
		xpReward = 0;
		this.isBreaking = false;
		this.breakingTicks = 0;
		this.setIsFrozen(true);
		setNoAi(false);
		setPersistenceRequired();
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(DATA_yo, 1);
		this.entityData.define(IS_FROZEN, true);
		this.entityData.define(DATA_yooo, "hm");
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, AbstractIllager.class, false, false));
		/*this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, Vindicator.class, false, false));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, Evoker.class, false, false));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, Ravager.class, false, false));*/
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, Player.class, false, false));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, AbstractGolem.class, false, false));
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal(this, Villager.class, false, false));
		this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.2, false) {
			protected void checkAndPerformAttack(LivingEntity p_25557_, double p_25558_) {
			}

			public void tick() {
				if ((FrozenWarlockEntity.this.getIsFrozen() != true) && (FrozenWarlockEntity.this.isAlive())) {
					if (!(FrozenWarlockEntity.this.getTarget() == null)) {
						LivingEntity livingentity = FrozenWarlockEntity.this.getTarget();
						if (FrozenWarlockEntity.this.isAttacking == false) {
							this.mob.getLookControl().setLookAt(livingentity, 30.0F, 30.0F);
							FrozenWarlockEntity.this.getNavigation().moveTo(livingentity.getX(), livingentity.getY(), livingentity.getZ(), 1.0);
						}
					}
				}
			};

			@Override
			protected double getAttackReachSqr(LivingEntity entity) {
				return (double) (4.0 + entity.getBbWidth() * entity.getBbWidth());
			}
		});
		this.goalSelector.addGoal(2, new MoveAttackGoal(this, 1.0D/*0.85D*/, 25.0F) {
			@Override
			public boolean canUse() {
				return (!(FrozenWarlockEntity.this.getTarget() == null)) && (FrozenWarlockEntity.this.isBackwarding == true);
			}
		});
		this.targetSelector.addGoal(6, new NearestAttackableTargetGoal(this, Animal.class, false, false));
		this.goalSelector.addGoal(6, new RandomStrollGoal(this, 1));
		this.targetSelector.addGoal(7, new HurtByTargetGoal(this));
		//this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(9, new FloatGoal(this));
	}

	public void tick() {
		super.tick();
		Level world = this.level();
		if (this.isAlive()) {
			float animationType = (float) this.getAttributeValue(Attributes.JUMP_STRENGTH);
			if (this.isSprinting() == true) {
				if (animationType == 0.1f) {
					this.iceWallFrontAnimationState.start(this.tickCount);
				}
				if (animationType == 0.2f) {
					this.iceWallFrontBiggerAnimationState.start(this.tickCount);
				}
				if (animationType == 0.3f) {
					this.everfrostAnimationState.start(this.tickCount);
				}
				if (animationType == 0.4f) {
					this.iceTrapAnimationState.start(this.tickCount);
				}
				if (animationType == 0.5f) {
					this.waterPotionAnimationState.start(this.tickCount);
				}
				if (animationType == 0.6f) {
					this.iceRushAnimationState.start(this.tickCount);
				}
				if (animationType == 0.7f) {
					this.iceControlAnimationState.start(this.tickCount);
				}
			}
			if (!(this.getTarget() == null)) {
				if (this.attackProgress == 0 && this.isAttacking == false && this.getIsFrozen() != true) {
					LivingEntity living = (LivingEntity) this.getTarget();
					if (this.distanceToSqr(living) < 10) {
						//this.meleeAttack();
						this.meleeAttack();
					} else {
						this.rangedAttack();
					}
					//this.isBackwarding = false;
				} else {
					if (this.getIsFrozen() != true) {
						this.isBackwarding = true;
					}
				}
			} else {
				this.attackProgress = 0;
				this.isAttacking = false;
			}
			if (this.isAttacking == true) {
				if (this.attackType == 1) {
					this.attackIceWallFront();
				}
				if (this.attackType == 2) {
					this.attackIceWallFrontBigger();
				}
				if (this.attackType == 3) {
					this.attackEverfrost();
				}
				if (this.attackType == 4) {
					this.attackIceTrap();
				}
				if (this.attackType == 5) {
					this.attackWaterPotion();
				}
				if (this.attackType == 6) {
					this.attackIceRush();
				}
				if (this.attackType == 7) {
					this.attackIceControl();
				}
				++this.attackProgress;
			} else {
				/*none*/
				this.attackProgress = 0;
			}
		}
		if (this.isAttacking == true) {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.0D);
			this.getAttribute(Attributes.KNOCKBACK_RESISTANCE).setBaseValue(11.0D);
			this.setDeltaMovement(0, this.getDeltaMovement().y, 0);
		} else {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.3D);
			this.getAttribute(Attributes.KNOCKBACK_RESISTANCE).setBaseValue(0.0D);
		}
		--this.meleeAttackCoolDown;
		this.meleeAttackCoolDown = Mth.clamp(this.meleeAttackCoolDown, 0, 500);
		--this.rangedAttackCoolDown;
		this.rangedAttackCoolDown = Mth.clamp(this.rangedAttackCoolDown, 0, 500);
		if (this.getIsFrozen()) {
			this.setRot(0, 30);
			this.setDeltaMovement(0, 0, 0);
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.0D);
		}
		if (this.getTarget() != null) {
			//this.isBreaking = true;
		}
		if (this.isBreaking == true) {
			if (this.getIsFrozen()) {
				++this.breakingTicks;
				if (this.breakingTicks == 20) {
					for (int l = 0; l < 20; l++) {
						if (world instanceof ServerLevel _level) {
							_level.getServer().getCommands()
									.performPrefixedCommand(new CommandSourceStack(CommandSource.NULL,
											new Vec3(this.getX() + Mth.nextDouble(RandomSource.create(), -1 * (this.getBbWidth() / 2), this.getBbWidth() / 2), this.getY() + Mth.nextDouble(RandomSource.create(), 0, this.getBbHeight()),
													this.getZ() + Mth.nextDouble(RandomSource.create(), -1 * (this.getBbWidth() / 2), this.getBbWidth() / 2)),
											Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), "/particle block ice ~ ~ ~ 0 0 0 1 1 normal");
						}
					}
					this.playSound(SoundEvents.GLASS_BREAK, 1.0F, 1.0F);
				}
				if (this.breakingTicks == 60) {
					this.playSound(SoundEvents.GLASS_BREAK, 2.0F, 0.5F);
					for (int l = 0; l < 40; l++) {
						if (world instanceof ServerLevel _level) {
							_level.getServer().getCommands()
									.performPrefixedCommand(new CommandSourceStack(CommandSource.NULL,
											new Vec3(this.getX() + Mth.nextDouble(RandomSource.create(), -1 * (this.getBbWidth() / 2), this.getBbWidth() / 2), this.getY() + Mth.nextDouble(RandomSource.create(), 0, this.getBbHeight()),
													this.getZ() + Mth.nextDouble(RandomSource.create(), -1 * (this.getBbWidth() / 2), this.getBbWidth() / 2)),
											Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), "/particle block ice ~ ~ ~ 0 0 0 1 1 normal");
						}
					}
				}
				if (this.breakingTicks == 100) {
					this.playSound(SoundEvents.GLASS_BREAK, 3.0F, 0.33F);
					for (int l = 0; l < 60; l++) {
						if (world instanceof ServerLevel _level) {
							_level.getServer().getCommands()
									.performPrefixedCommand(new CommandSourceStack(CommandSource.NULL,
											new Vec3(this.getX() + Mth.nextDouble(RandomSource.create(), -1 * (this.getBbWidth() / 2), this.getBbWidth() / 2), this.getY() + Mth.nextDouble(RandomSource.create(), 0, this.getBbHeight()),
													this.getZ() + Mth.nextDouble(RandomSource.create(), -1 * (this.getBbWidth() / 2), this.getBbWidth() / 2)),
											Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), "/particle block ice ~ ~ ~ 0 0 0 1 1 normal");
						}
					}
				}
				if (this.breakingTicks == 150) {
					this.playSound(SoundEvents.TRIDENT_THUNDER, 2.0F, 0.5F);
					this.setIsFrozen(false);
					this.isBreaking = false;
					this.breakingTicks = 0;
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
					for (int l = 0; l < 100; l++) {
						if (world instanceof ServerLevel _level) {
							_level.getServer().getCommands()
									.performPrefixedCommand(new CommandSourceStack(CommandSource.NULL,
											new Vec3(this.getX() + Mth.nextDouble(RandomSource.create(), -1 * (this.getBbWidth() / 2), this.getBbWidth() / 2), this.getY() + Mth.nextDouble(RandomSource.create(), 0, this.getBbHeight()),
													this.getZ() + Mth.nextDouble(RandomSource.create(), -1 * (this.getBbWidth() / 2), this.getBbWidth() / 2)),
											Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), "/particle block ice ~ ~ ~ 0 0 0 1 1 normal");
						}
					}
				}
			}
		}
	}

	public void meleeAttack() {
		Level world = this.level();
		boolean canThrow = true;
		final Vec3 _center = new Vec3(this.getX(), this.getY(), this.getZ());
		List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).collect(Collectors.toList());
		for (Entity entityiterator : _entfound) {
			if (entityiterator instanceof IcePikesEntity) {
				canThrow = false;
			}
		}
		if (this.meleeAttackCoolDown == 0) {
			if ((this.getHealth() / this.getMaxHealth() < 0.5f) && (!(this.hasEffect(TooMuchBossesModMobEffects.EVERFROSTPOTION.get())))) {
				this.attackType = 3;
				this.isAttacking = true;
				this.meleeAttackCoolDown = 50;
				this.setSprinting(true);
				this.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(0.3f);
			} else {
				if (this.getHealth() / this.getMaxHealth() > 0.5f) {
					this.attackType = 4;
					this.isAttacking = true;
					this.meleeAttackCoolDown = 80;
					this.setSprinting(true);
					this.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(0.4f);
				} else {
					if (Math.random() < 0.5) {
						this.attackType = 4;
						this.isAttacking = true;
						this.meleeAttackCoolDown = 80;
						this.setSprinting(true);
						this.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(0.4f);
					} else {
						/*if (Math.random() > 0.5){ 
						
						}else{*/
						if (canThrow) {
							this.attackType = 5;
							this.isAttacking = true;
							this.meleeAttackCoolDown = 60;
							this.setSprinting(true);
							this.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(0.5f);
						} else {
							this.attackType = 1;
							this.isAttacking = true;
							this.meleeAttackCoolDown = 90;
							this.setSprinting(true);
							this.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(0.1f);
						}
						//}
					}
				}
			}
		}
	}

	public void rangedAttack() {
		Level world = this.level();
		boolean canThrow = true;
		final Vec3 _center = new Vec3(this.getX(), this.getY(), this.getZ());
		List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).collect(Collectors.toList());
		for (Entity entityiterator : _entfound) {
			if (entityiterator instanceof IcePikesEntity) {
				canThrow = false;
			}
		}
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double width = 15;
		sx = 0 - width / 2;
		found = false;
		for (int index0 = 0; index0 < ((int) width); index0++) {
			sy = 0 - width / 2;
			for (int index1 = 0; index1 < ((int) width); index1++) {
				sz = 0 - width / 2;
				for (int index2 = 0; index2 < ((int) width); index2++) {
					if ((world.getBlockState(BlockPos.containing(this.getX() + sx, this.getY() + sy, this.getZ() + sz))).getBlock() == TooMuchBossesModBlocks.WARLOCKS_ICE.get()) {
						found = true;
					}
					sz = sz + 1;
				}
				sy = sy + 1;
			}
			sx = sx + 1;
		}
		if (this.rangedAttackCoolDown == 0) {
			if ((this.getHealth() / this.getMaxHealth() < 0.66f) && (!(this.hasEffect(TooMuchBossesModMobEffects.EVERFROSTPOTION.get())))) {
				this.attackType = 3;
				this.isAttacking = true;
				this.rangedAttackCoolDown = 50;
				this.setSprinting(true);
				this.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(0.3f);
			} else {
				if (this.getHealth() / this.getMaxHealth() > 0.66f) {
					this.attackType = 1;
					this.isAttacking = true;
					this.rangedAttackCoolDown = 100;
					this.setSprinting(true);
					this.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(0.1f);
				} else {
					if (Math.random() < 0.35) {
						this.attackType = 2;
						this.isAttacking = true;
						this.rangedAttackCoolDown = 140;
						this.setSprinting(true);
						this.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(0.2f);
					} else {
						if (Math.random() < 0.2) {
							this.attackType = 6;
							this.isAttacking = true;
							this.rangedAttackCoolDown = 140;
							this.setSprinting(true);
							this.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(0.6f);
						} else {
							if (Math.random() < 0.5) {
								this.attackType = 7;
								this.isAttacking = true;
								this.rangedAttackCoolDown = 120;
								this.setSprinting(true);
								this.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(0.7f);
							} else {
								if (canThrow) {
									this.attackType = 5;
									this.isAttacking = true;
									this.rangedAttackCoolDown = 100;
									this.setSprinting(true);
									this.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(0.5f);
								} else {
									this.attackType = 1;
									this.isAttacking = true;
									this.rangedAttackCoolDown = 100;
									this.setSprinting(true);
									this.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(0.1f);
								}
							}
						}
					}
				}
			}
		}
	}

	public void attackIceWallFront() {
		Level world = this.level();
		if ((this.attackProgress > 1) && (this.attackProgress < 10)) {
			this.setSprinting(false);
			if (this.getTarget() != null) {
				LivingEntity livingentity = (LivingEntity) this.getTarget();
				this.getLookControl().setLookAt(livingentity, 30.0F, 30.0F);
			}
		}
		if (this.getTarget() != null) {
			LivingEntity livingentity = (LivingEntity) this.getTarget();
			this.getLookControl().setLookAt(livingentity, 30.0F, 30.0F);
		}
		if (this.attackProgress == 25) {
			this.playSound(SoundEvents.GLASS_BREAK, 4.0F, 0.25F);
			if (this.getTarget() != null) {
				LivingEntity livingentity = this.getTarget();
				IceWallFrontShootEntity.shoot(this, livingentity);
			}
		}
		if (this.attackProgress == 44) {
			this.isAttacking = false;
			this.attackProgress = 0;
			this.iceWallFrontAnimationState.stop();
		}
	}

	public void attackIceWallFrontBigger() {
		Level world = this.level();
		if (this.attackProgress == 1) {
			if (this.getTarget() != null) {
				LivingEntity livingentity = (LivingEntity) this.getTarget();
				this.getLookControl().setLookAt(livingentity, 30.0F, 30.0F);
			}
			this.setSprinting(false);
		}
		if (this.attackProgress == 32) {
			this.playSound(SoundEvents.PLAYER_ATTACK_SWEEP, 2.0F, 0.5F);
			if (this.getTarget() != null) {
				LivingEntity livingentity = this.getTarget();
				IceWallFrontBiggerEntity.shoot(this, livingentity);
			}
		}
		if (this.attackProgress == 60) {
			this.isAttacking = false;
			this.attackProgress = 0;
			this.iceWallFrontBiggerAnimationState.stop();
		}
	}

	public void attackEverfrost() {
		Level world = this.level();
		if ((this.attackProgress > 1) && (this.attackProgress < 10)) {
			this.setSprinting(false);
		}
		if (this.attackProgress == 25) {
			this.playSound(SoundEvents.ENCHANTMENT_TABLE_USE, 6.0F, 0.75F);
			this.addEffect(new MobEffectInstance(TooMuchBossesModMobEffects.EVERFROSTPOTION.get(), 900, 2));
		}
		if (this.attackProgress == 40) {
			this.isAttacking = false;
			this.attackProgress = 0;
			this.everfrostAnimationState.stop();
		}
	}

	public void attackIceTrap() {
		Level world = this.level();
		if (this.attackProgress == 1) {
			if (this.getTarget() != null) {
				LivingEntity livingentity = (LivingEntity) this.getTarget();
				this.getLookControl().setLookAt(livingentity, 30.0F, 30.0F);
			}
			this.setSprinting(false);
		}
		if (this.attackProgress == 23) {
			this.playSound(SoundEvents.ARMOR_EQUIP_DIAMOND, 4.0F, 0.5F);
			if (this.getTarget() != null) {
				LivingEntity livingentity = this.getTarget();
				IceTrapShootEntity.shoot(this, livingentity);
			}
		}
		/*if(45 < this.attackProgress && this.attackProgress < 59){
			FrozenWarlockEntity.this.getNavigation().moveTo(livingentity.getX(), livingentity.getY(), livingentity.getZ(), 1.0);
		}*/
		if (this.attackProgress == 50) {
			this.isAttacking = false;
			this.attackProgress = 0;
			this.iceTrapAnimationState.stop();
		}
	}

	public void attackWaterPotion() {
		Level world = this.level();
		if (this.attackProgress == 1) {
			if (this.getTarget() != null) {
				LivingEntity livingentity = (LivingEntity) this.getTarget();
				this.getLookControl().setLookAt(livingentity, 30.0F, 30.0F);
			}
			this.setSprinting(false);
		}
		if (this.attackProgress == 25) {
			this.playSound(SoundEvents.WITCH_THROW, 3.0F, 0.5F);
			if (this.getTarget() != null) {
				LivingEntity livingentity = this.getTarget();
				/*if(Math.random() > 0.4){
					WaterPotionEntity.shoot(this, livingentity);
				}
				if(Math.random() > 0.3){
					WaterPotionEntity.shoot(this, livingentity);
				}*/
				WaterPotionEntity.shoot(this, livingentity);
			}
		}
		/*if(45 < this.attackProgress && this.attackProgress < 59){
			FrozenWarlockEntity.this.getNavigation().moveTo(livingentity.getX(), livingentity.getY(), livingentity.getZ(), 1.0);
		}*/
		if (this.attackProgress == 40) {
			this.isAttacking = false;
			this.attackProgress = 0;
			this.waterPotionAnimationState.stop();
		}
	}

	public void attackIceRush() {
		Level world = this.level();
		if (this.attackProgress == 1) {
			if (this.getTarget() != null) {
				LivingEntity livingentity = (LivingEntity) this.getTarget();
				this.getLookControl().setLookAt(livingentity, 30.0F, 30.0F);
			}
			this.setSprinting(false);
		}
		if ((this.attackProgress >= 40) && (this.attackProgress <= 55)) {
			if (this.tickCount % 5 == 0) {
				this.playSound(SoundEvents.EVOKER_CAST_SPELL, 3.0F, 0.5F);
				if (this.getTarget() != null) {
					LivingEntity livingentity = this.getTarget();
					//IceWallFrontShootEntity.shoot(this, livingentity);
					IcerushthemostEntity.shoot(this, livingentity);
				}
			}
		}
		/*if(45 < this.attackProgress && this.attackProgress < 59){
			FrozenWarlockEntity.this.getNavigation().moveTo(livingentity.getX(), livingentity.getY(), livingentity.getZ(), 1.0);
		}*/
		if (this.attackProgress == 65) {
			this.isAttacking = false;
			this.attackProgress = 0;
			this.iceRushAnimationState.stop();
		}
	}

	public void attackIceControl() {
		Level world = this.level();
		if (this.attackProgress == 1) {
			if (this.getTarget() != null) {
				LivingEntity livingentity = (LivingEntity) this.getTarget();
				this.getLookControl().setLookAt(livingentity, 30.0F, 30.0F);
			}
			this.setSprinting(false);
		}
		if (attackProgress < 30) {
			LiftIceProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this, (double) (this.attackProgress));
		}
		if (this.attackProgress == 60) {
			this.isAttacking = false;
			this.attackProgress = 0;
			this.iceControlAnimationState.stop();
		}
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEAD;
	}

	@Override
	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return false;
	}

	@Override
	public SoundEvent getAmbientSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither_skeleton.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither_skeleton.death"));
	}

	@Override
	public boolean hurt(DamageSource damagesource, float amount) {
		if (damagesource.is(DamageTypes.FALL)) {
			return false;
		}
		if (damagesource.is(DamageTypes.FREEZE)) {
			return false;
		}
		if (damagesource.is(DamageTypes.DROWN)) {
			return false;
		}
		if (damagesource.is(DamageTypes.IN_WALL)) {
			return false;
		}
		if (this.getIsFrozen()) {
			this.playSound(SoundEvents.GLASS_PLACE, 3.0F, 1.0F);
			this.isBreaking = true;
			return false;
		}
		if (amount > 12) {
			if (!(damagesource.is(DamageTypes.FELL_OUT_OF_WORLD)) && !(damagesource.is(DamageTypes.OUTSIDE_BORDER))) {
				return super.hurt(damagesource, 12);
			}
		}
		if (this.attackType == 3 && this.isAttacking == true) {
			return super.hurt(damagesource, amount / 2);
		}
		if (damagesource.is(DamageTypes.IN_FIRE) || damagesource.is(DamageTypes.ON_FIRE) || damagesource.is(DamageTypes.HOT_FLOOR) || damagesource.is(DamageTypes.LAVA)) {
			return super.hurt(damagesource, amount / 4);
		}
		if (null != damagesource.getEntity()) {
			Entity sourceentity = damagesource.getEntity();
			if (sourceentity.getTicksFrozen() > 99) {
				return super.hurt(damagesource, amount / 4);
			}
		}
		return super.hurt(damagesource, amount);
	}

	@Override
	public void die(DamageSource source) {
		super.die(source);
		BGflameEffectsProcedure.execute(this.level(), this);
	}

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag) {
		SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata, tag);
		BGflameEffectsProcedure.execute(world, this);
		return retval;
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putInt("Datayo", this.entityData.get(DATA_yo));
		compound.putBoolean("isFrozen", this.entityData.get(IS_FROZEN));
		compound.putString("Datayooo", this.entityData.get(DATA_yooo));
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("Datayo"))
			this.entityData.set(DATA_yo, compound.getInt("Datayo"));
		if (compound.contains("isFrozen"))
			this.entityData.set(IS_FROZEN, compound.getBoolean("isFrozen"));
		if (compound.contains("Datayooo"))
			this.entityData.set(DATA_yooo, compound.getString("Datayooo"));
	}

	public void setIsFrozen(boolean froze) {
		this.entityData.set(IS_FROZEN, froze);
	}

	public boolean getIsFrozen() {
		return this.entityData.get(IS_FROZEN);
	}

	public Vec3 getHorizontalLookAngle(float YRot) {
		return this.calculateViewVector(0, YRot/*this.getYRot()*/);
	}

	@Override
	public void baseTick() {
		super.baseTick();
		BGflameEffectsProcedure.execute(this.level(), this);
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
	}

	public static void init() {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 120);
		builder = builder.add(Attributes.ARMOR, 10);
		//builder = builder.add(Attributes.ARMOR_TOUGHNESS, 10);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
		builder = builder.add(Attributes.FOLLOW_RANGE, 64);
		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 10);
		builder = builder.add(Attributes.JUMP_STRENGTH, 0.5);
		return builder;
	}
}

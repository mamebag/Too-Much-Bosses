package net.mcreator.toomuchbosses.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.toomuchbosses.init.TooMuchBossesModMobEffects;
import net.mcreator.toomuchbosses.init.TooMuchBossesModEntities;
import net.mcreator.toomuchbosses.entity.FrozenWarlockEntity;

import java.util.List;
import java.util.Comparator;

public class IcePikesOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity warlock = null;
		double Zknockback = 0;
		double Yknockback = 0;
		double Xknockback = 0;
		double dis = 0;
		double rad = 0;
		double theta = 0;
		double spawnX = 0;
		double spawnZ = 0;
		boolean hit = false;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof FrozenWarlockEntity) {
					warlock = entityiterator;
				}
			}
		}
		if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.AIR) {
			hit = false;
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(7 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator instanceof FrozenWarlockEntity)) {
						if (!(entityiterator instanceof LivingEntity _livEnt5 && _livEnt5.hasEffect(TooMuchBossesModMobEffects.EVERFROSTPOTION.get()))) {
							if (entityiterator instanceof LivingEntity) {
								if (((LivingEntity) entityiterator).hurtTime == 0) {
									entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.FREEZE), warlock), 14);
									if (entityiterator instanceof LivingEntity) {
										if (((LivingEntity) entityiterator).hurtTime != 0) {
											entityiterator.setTicksFrozen(250);
											if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 1));
											hit = true;
											Xknockback = entityiterator.getX() - x;
											Yknockback = entityiterator.getY() - y;
											Zknockback = entityiterator.getZ() - z;
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
											entityiterator.setDeltaMovement(new Vec3((Xknockback / 1.5), (Yknockback + -2), (Zknockback / 1.5)));
										}
									}
								}
							}
						}
					}
				}
			}
			if (hit) {
				if (!entity.getPersistentData().getBoolean("hashit")) {
					entity.getPersistentData().putBoolean("hashit", true);
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = TooMuchBossesModEntities.ICEPOOF_MAKER.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.hurt_freeze")), SoundSource.NEUTRAL, 5, (float) 0.25);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.hurt_freeze")), SoundSource.NEUTRAL, 5, (float) 0.25, false);
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float) 1.5, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float) 1.5, 1, false);
						}
					}
				}
			}
		} else {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = TooMuchBossesModEntities.ICEPOOF_MAKER.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.hurt_freeze")), SoundSource.NEUTRAL, 5, (float) 0.25);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.hurt_freeze")), SoundSource.NEUTRAL, 5, (float) 0.25, false);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float) 1.5, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float) 1.5, 1, false);
				}
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(7 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator instanceof FrozenWarlockEntity)) {
						if (!(entityiterator instanceof LivingEntity _livEnt25 && _livEnt25.hasEffect(TooMuchBossesModMobEffects.EVERFROSTPOTION.get()))) {
							if (entityiterator instanceof LivingEntity) {
								entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.FREEZE), warlock), 14);
								if (entityiterator instanceof LivingEntity) {
									if (((LivingEntity) entityiterator).hurtTime != 0) {
										entityiterator.setTicksFrozen(250);
										if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 1));
										Xknockback = entityiterator.getX() - x;
										Yknockback = entityiterator.getY() - y;
										Zknockback = entityiterator.getZ() - z;
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
										entityiterator.setDeltaMovement(new Vec3((Xknockback * 2), (Yknockback + 0.75), (Zknockback * 2)));
									}
								}
							}
						}
					}
				}
			}
		}
	}
}

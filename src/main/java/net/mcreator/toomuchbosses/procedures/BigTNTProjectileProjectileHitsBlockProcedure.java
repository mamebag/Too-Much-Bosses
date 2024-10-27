package net.mcreator.toomuchbosses.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.toomuchbosses.entity.SpitterEntity;
import net.mcreator.toomuchbosses.entity.BigTNTProjectileEntity;
import net.mcreator.toomuchbosses.TooMuchBossesMod;

public class BigTNTProjectileProjectileHitsBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
			return;
		if (entity instanceof SpitterEntity) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(immediatesourceentity.getX(), immediatesourceentity.getY(), immediatesourceentity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.grass.place")),
							SoundSource.NEUTRAL, 2, 1);
				} else {
					_level.playLocalSound((immediatesourceentity.getX()), (immediatesourceentity.getY()), (immediatesourceentity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.grass.place")), SoundSource.NEUTRAL, 2, 1,
							false);
				}
			}
			if (((SpitterEntity) entity).hasRevived == true) {
				TooMuchBossesMod.queueServerWork(2, () -> {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(immediatesourceentity.getX(), immediatesourceentity.getY(), immediatesourceentity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.creeper.primed")),
									SoundSource.NEUTRAL, 2, 1);
						} else {
							_level.playLocalSound((immediatesourceentity.getX()), (immediatesourceentity.getY()), (immediatesourceentity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.creeper.primed")),
									SoundSource.NEUTRAL, 2, 1, false);
						}
					}
					TooMuchBossesMod.queueServerWork(5, () -> {
						((BigTNTProjectileEntity) immediatesourceentity).whited = true;
						TooMuchBossesMod.queueServerWork(5, () -> {
							((BigTNTProjectileEntity) immediatesourceentity).whited = false;
							TooMuchBossesMod.queueServerWork(5, () -> {
								((BigTNTProjectileEntity) immediatesourceentity).whited = true;
								TooMuchBossesMod.queueServerWork(5, () -> {
									((BigTNTProjectileEntity) immediatesourceentity).whited = false;
									TooMuchBossesMod.queueServerWork(5, () -> {
										((BigTNTProjectileEntity) immediatesourceentity).whited = true;
										TooMuchBossesMod.queueServerWork(5, () -> {
											((BigTNTProjectileEntity) immediatesourceentity).whited = false;
											AnotherexplosionProcedure.execute(world, (immediatesourceentity.getX()), (immediatesourceentity.getY()), (immediatesourceentity.getZ()), entity);
										});
									});
								});
							});
						});
					});
				});
			} else {
				TooMuchBossesMod.queueServerWork(20, () -> {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(immediatesourceentity.getX(), immediatesourceentity.getY(), immediatesourceentity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.creeper.primed")),
									SoundSource.NEUTRAL, 2, 1);
						} else {
							_level.playLocalSound((immediatesourceentity.getX()), (immediatesourceentity.getY()), (immediatesourceentity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.creeper.primed")),
									SoundSource.NEUTRAL, 2, 1, false);
						}
					}
					TooMuchBossesMod.queueServerWork(10, () -> {
						((BigTNTProjectileEntity) immediatesourceentity).whited = true;
						TooMuchBossesMod.queueServerWork(10, () -> {
							((BigTNTProjectileEntity) immediatesourceentity).whited = false;
							TooMuchBossesMod.queueServerWork(10, () -> {
								((BigTNTProjectileEntity) immediatesourceentity).whited = true;
								TooMuchBossesMod.queueServerWork(10, () -> {
									((BigTNTProjectileEntity) immediatesourceentity).whited = false;
									TooMuchBossesMod.queueServerWork(10, () -> {
										((BigTNTProjectileEntity) immediatesourceentity).whited = true;
										TooMuchBossesMod.queueServerWork(10, () -> {
											((BigTNTProjectileEntity) immediatesourceentity).whited = false;
											AnotherexplosionProcedure.execute(world, (immediatesourceentity.getX()), (immediatesourceentity.getY()), (immediatesourceentity.getZ()), entity);
										});
									});
								});
							});
						});
					});
				});
			}
		}
		if (!immediatesourceentity.level().isClientSide())
			immediatesourceentity.discard();
	}
}

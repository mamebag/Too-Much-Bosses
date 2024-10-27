package net.mcreator.toomuchbosses.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.toomuchbosses.init.TooMuchBossesModMobEffects;
import net.mcreator.toomuchbosses.entity.IcePikesEntity;
import net.mcreator.toomuchbosses.entity.FrozenWarlockEntity;
import net.mcreator.toomuchbosses.TooMuchBossesMod;

import java.util.List;
import java.util.Comparator;

public class WarlocksIceBlockAddedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double Zknockback = 0;
		double Yknockback = 0;
		double Xknockback = 0;
		double dis = 0;
		Entity warlock = null;
		boolean found = false;
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.respawn_anchor.deplete")), SoundSource.NEUTRAL, 1, 3);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.respawn_anchor.deplete")), SoundSource.NEUTRAL, 1, 3, false);
			}
		}
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof IcePikesEntity) {
					world.destroyBlock(BlockPos.containing(x, y, z), false);
				}
			}
		}
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof FrozenWarlockEntity) {
					warlock = entityiterator;
				}
			}
		}
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (!(entityiterator instanceof FrozenWarlockEntity)) {
					if (!(entityiterator instanceof LivingEntity _livEnt7 && _livEnt7.hasEffect(TooMuchBossesModMobEffects.EVERFROSTPOTION.get()))) {
						if (entityiterator instanceof LivingEntity) {
							entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.FREEZE), warlock), 7);
							if (entityiterator instanceof LivingEntity) {
								if (((LivingEntity) entityiterator).hurtTime != 0) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.hurt_freeze")),
													SoundSource.NEUTRAL, 5, 1);
										} else {
											_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.hurt_freeze")),
													SoundSource.NEUTRAL, 5, 1, false);
										}
									}
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
									entityiterator.setDeltaMovement(new Vec3((Xknockback / 1.5), (Yknockback + 0.75), (Zknockback / 1.5)));
								}
							}
						}
					}
				}
			}
		}
		TooMuchBossesMod.queueServerWork(Mth.nextInt(RandomSource.create(), 130, 150), () -> {
			IcebreakerProcedure.execute(world, (x + 0), (y + 0), (z + 0));
			for (int index0 = 0; index0 < 1; index0++) {
				IcebreakerProcedure.execute(world, (x + 0), (y + -2), (z + 0));
				IcebreakerProcedure.execute(world, (x + 1), (y + -2), (z + 0));
				IcebreakerProcedure.execute(world, (x + -1), (y + -2), (z + 0));
				IcebreakerProcedure.execute(world, (x + 1), (y + -2), (z + 1));
				IcebreakerProcedure.execute(world, (x + -1), (y + -2), (z + -1));
				IcebreakerProcedure.execute(world, (x + 1), (y + -2), (z + -1));
				IcebreakerProcedure.execute(world, (x + -1), (y + -2), (z + 1));
			}
			for (int index1 = 0; index1 < 1; index1++) {
				IcebreakerProcedure.execute(world, (x + 0), (y + -1), (z + 0));
				IcebreakerProcedure.execute(world, (x + 1), (y + -1), (z + 0));
				IcebreakerProcedure.execute(world, (x + -1), (y + -1), (z + 0));
				IcebreakerProcedure.execute(world, (x + 1), (y + -1), (z + 1));
				IcebreakerProcedure.execute(world, (x + -1), (y + -1), (z + -1));
				IcebreakerProcedure.execute(world, (x + 1), (y + -1), (z + -1));
				IcebreakerProcedure.execute(world, (x + -1), (y + -1), (z + 1));
			}
			for (int index2 = 0; index2 < 1; index2++) {
				IcebreakerProcedure.execute(world, (x + 0), (y + 1), (z + 0));
				IcebreakerProcedure.execute(world, (x + 1), (y + 1), (z + 0));
				IcebreakerProcedure.execute(world, (x + -1), (y + 1), (z + 0));
				IcebreakerProcedure.execute(world, (x + 1), (y + 1), (z + 1));
				IcebreakerProcedure.execute(world, (x + -1), (y + 1), (z + -1));
				IcebreakerProcedure.execute(world, (x + 1), (y + 1), (z + -1));
				IcebreakerProcedure.execute(world, (x + -1), (y + -1), (z + 1));
			}
			for (int index3 = 0; index3 < 1; index3++) {
				IcebreakerProcedure.execute(world, (x + 0), (y + 2), (z + 0));
				IcebreakerProcedure.execute(world, (x + 1), (y + 2), (z + 0));
				IcebreakerProcedure.execute(world, (x + -1), (y + 2), (z + 0));
				IcebreakerProcedure.execute(world, (x + 1), (y + 2), (z + 1));
				IcebreakerProcedure.execute(world, (x + -1), (y + 2), (z + -1));
				IcebreakerProcedure.execute(world, (x + 1), (y + 2), (z + -1));
				IcebreakerProcedure.execute(world, (x + -1), (y + 2), (z + 1));
			}
			for (int index4 = 0; index4 < 1; index4++) {
				IcebreakerProcedure.execute(world, (x + 0), (y + 3), (z + 0));
				IcebreakerProcedure.execute(world, (x + 1), (y + 3), (z + 0));
				IcebreakerProcedure.execute(world, (x + -1), (y + 3), (z + 0));
				IcebreakerProcedure.execute(world, (x + 1), (y + 3), (z + 1));
				IcebreakerProcedure.execute(world, (x + -1), (y + 3), (z + -1));
				IcebreakerProcedure.execute(world, (x + 1), (y + 3), (z + -1));
				IcebreakerProcedure.execute(world, (x + -1), (y + 3), (z + 1));
			}
		});
	}
}

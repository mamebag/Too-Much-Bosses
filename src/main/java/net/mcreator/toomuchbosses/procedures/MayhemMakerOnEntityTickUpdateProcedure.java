package net.mcreator.toomuchbosses.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Vindicator;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.animal.horse.SkeletonHorse;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.toomuchbosses.TooMuchBossesMod;

import java.util.List;
import java.util.Comparator;

public class MayhemMakerOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean moddedIsThere = false;
		double placeY = 0;
		double placeZ = 0;
		double placeX = 0;
		double radius = 0;
		double Zknockback = 0;
		double Yknockback = 0;
		double Xknockback = 0;
		double dis = 0;
		if (entity.tickCount == 1) {
			entity.getPersistentData().putDouble("summonNum", 5);
		}
		moddedIsThere = false;
		if (entity.isAlive()) {
			if (entity.tickCount % 35 == 0) {
				if (1 == Mth.nextInt(RandomSource.create(), 1, 2)) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"/item replace entity @e[tag=wizard] weapon.mainhand with bow{Enchantments:[{id:\"minecraft:unbreaking\",lvl:4s},{id:\"minecraft:power\",lvl:4s},{id:\"minecraft:punch\",lvl:2s},{id:\"minecraft:flame\",lvl:4s},{id:\"minecraft:infinity\",lvl:4s},{id:\"minecraft:mending\",lvl:4s}]} 1");
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if ((entityiterator.getDisplayName().getString()).equals("The Modded Mob")) {
								if (entityiterator instanceof Skeleton) {
									if (Items.ELYTRA == (entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem()) {
										if ((entityiterator instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity) {
											if (!((world.getBlockState(BlockPos.containing(entityiterator.getX(), entityiterator.getY() - 1, entityiterator.getZ()))).getBlock() == Blocks.AIR)) {
												if (1 == Mth.nextInt(RandomSource.create(), 1, 2)) {
													Xknockback = entityiterator.getX() - (entityiterator instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX();
													Yknockback = entityiterator.getY() - (entityiterator instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY();
													Zknockback = entityiterator.getZ() - (entityiterator instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ();
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
													entityiterator.setDeltaMovement(new Vec3((0 - Xknockback), (Mth.nextDouble(RandomSource.create(), 0.7, 1.3)), (0 - Zknockback)));
												} else {
													Xknockback = entityiterator.getX() - (entityiterator instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX();
													Yknockback = entityiterator.getY() - (entityiterator instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY();
													Zknockback = entityiterator.getZ() - (entityiterator instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ();
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
													entityiterator.setDeltaMovement(new Vec3(Xknockback, (Mth.nextDouble(RandomSource.create(), 0.4, 1)), Zknockback));
												}
											}
										}
									}
								}
							}
						}
					}
				} else {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"/item replace entity @e[tag=wizard,type=skeleton] weapon.mainhand with diamond_sword{Enchantments:[{id:\"minecraft:protection\",lvl:5s},{id:\"minecraft:fire_protection\",lvl:5s},{id:\"minecraft:feather_falling\",lvl:5s},{id:\"minecraft:blast_protection\",lvl:5s},{id:\"minecraft:projectile_protection\",lvl:5s},{id:\"minecraft:respiration\",lvl:5s},{id:\"minecraft:aqua_affinity\",lvl:5s},{id:\"minecraft:thorns\",lvl:5s},{id:\"minecraft:depth_strider\",lvl:5s},{id:\"minecraft:frost_walker\",lvl:5s},{id:\"minecraft:binding_curse\",lvl:5s},{id:\"minecraft:sharpness\",lvl:5s},{id:\"minecraft:smite\",lvl:5s},{id:\"minecraft:bane_of_arthropods\",lvl:5s},{id:\"minecraft:knockback\",lvl:2s},{id:\"minecraft:fire_aspect\",lvl:5s},{id:\"minecraft:looting\",lvl:5s},{id:\"minecraft:sweeping\",lvl:5s},{id:\"minecraft:efficiency\",lvl:5s},{id:\"minecraft:silk_touch\",lvl:5s},{id:\"minecraft:unbreaking\",lvl:5s},{id:\"minecraft:fortune\",lvl:5s},{id:\"minecraft:power\",lvl:5s},{id:\"minecraft:punch\",lvl:5s},{id:\"minecraft:flame\",lvl:5s},{id:\"minecraft:infinity\",lvl:5s},{id:\"minecraft:luck_of_the_sea\",lvl:5s},{id:\"minecraft:lure\",lvl:5s},{id:\"minecraft:loyalty\",lvl:5s},{id:\"minecraft:impaling\",lvl:5s},{id:\"minecraft:riptide\",lvl:5s},{id:\"minecraft:channeling\",lvl:5s},{id:\"minecraft:mending\",lvl:5s},{id:\"minecraft:vanishing_curse\",lvl:5s},{id:\"minecraft:multishot\",lvl:5s},{id:\"minecraft:piercing\",lvl:5s},{id:\"minecraft:quick_charge\",lvl:5s},{id:\"minecraft:soul_speed\",lvl:5s},{id:\"minecraft:swift_sneak\",lvl:5s}]} 1");
				}
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if ((entityiterator.getDisplayName().getString()).equals("The Modded Mob")) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 10, 5));
						if (entityiterator instanceof Vindicator) {
							if (!entityiterator.isAlive()) {
								if (entityiterator.tickCount % 20 == 0) {
									for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 5, 15); index0++) {
										if (world instanceof Level _level && !_level.isClientSide())
											_level.explode(null, (entityiterator.getX() + Mth.nextDouble(RandomSource.create(), -1, 1)), (entityiterator.getY() + Mth.nextDouble(RandomSource.create(), -1, 2)),
													(entityiterator.getZ() + Mth.nextDouble(RandomSource.create(), -1, 1)), (float) 1.5, Level.ExplosionInteraction.NONE);
									}
								}
							}
						}
						if (entityiterator.isAlive()) {
							moddedIsThere = true;
						}
					}
				}
			}
			if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity) {
				if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof Mob _entity && entity instanceof LivingEntity _ent)
					_entity.setTarget(_ent);
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof SkeletonHorse) {
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60, 2));
						}
						if ((entityiterator.getDisplayName().getString()).equals("The Modded Mob")) {
							if (entityiterator instanceof Mob _entity && (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity _ent)
								_entity.setTarget(_ent);
							if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof Player)) {
								if (((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity) {
									if (!((((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getDisplayName().getString()).equals("The Modded Mob"))) {
										if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof Mob _entity && entityiterator instanceof LivingEntity _ent)
											_entity.setTarget(_ent);
									}
								}
							}
						}
					}
				}
			}
			if (5 == entity.getPersistentData().getDouble("summonNum") && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 80 && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 99) {
				entity.getPersistentData().putDouble("summonNum", 4);
				for (int index1 = 0; index1 < 6; index1++) {
					for (int index2 = 0; index2 < 1; index2++) {
						entity.getPersistentData().putDouble("rad", 10);
						entity.getPersistentData().putDouble("x", (entity.getX() + Math.cos(entity.getPersistentData().getDouble("theta")) * entity.getPersistentData().getDouble("rad")));
						entity.getPersistentData().putDouble("y", (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entity.getPersistentData().getDouble("x"), (int) entity.getPersistentData().getDouble("z"))));
						entity.getPersistentData().putDouble("z", (entity.getZ() + Math.sin(entity.getPersistentData().getDouble("theta")) * entity.getPersistentData().getDouble("rad")));
						entity.getPersistentData().putDouble("theta", (Mth.nextInt(RandomSource.create(), 0, 360)));
					}
					if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(
									new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getPersistentData().getDouble("x")), (entity.getPersistentData().getDouble("y")), (entity.getPersistentData().getDouble("z"))), Vec2.ZERO, _level, 4, "",
											Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"/summon zombie ~ ~ ~ {CustomName:'{\"text\":\"The Modded Mob\"}'HandItems:[{id:\"minecraft:iron_sword\",Count:1b,tag:{Enchantments:[{}]}},{}],ArmorItems:[{},{},{},{id:\"minecraft:leather_helmet\",Count:1b,tag:{Enchantments:[{}]}}]}");
					}
				}
				TooMuchBossesMod.queueServerWork(20, () -> {
					for (int index3 = 0; index3 < 6; index3++) {
						for (int index4 = 0; index4 < 1; index4++) {
							entity.getPersistentData().putDouble("rad", 10);
							entity.getPersistentData().putDouble("x", (entity.getX() + Math.cos(entity.getPersistentData().getDouble("theta")) * entity.getPersistentData().getDouble("rad")));
							entity.getPersistentData().putDouble("y", (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entity.getPersistentData().getDouble("x"), (int) entity.getPersistentData().getDouble("z"))));
							entity.getPersistentData().putDouble("z", (entity.getZ() + Math.sin(entity.getPersistentData().getDouble("theta")) * entity.getPersistentData().getDouble("rad")));
							entity.getPersistentData().putDouble("theta", (Mth.nextInt(RandomSource.create(), 0, 360)));
						}
						if (Mth.nextInt(RandomSource.create(), 1, 3) == 1) {
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getPersistentData().getDouble("x")), (entity.getPersistentData().getDouble("y")), (entity.getPersistentData().getDouble("z"))), Vec2.ZERO, _level, 4,
												"", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"/summon husk ~ ~ ~ {CustomName:'{\"text\":\"The Modded Mob\"}',HandItems:[{id:\"minecraft:iron_sword\",Count:1b,tag:{Enchantments:[{}]}},{}],Attributes:[{Name:generic.follow_range,Base:100}]}");
						}
					}
					TooMuchBossesMod.queueServerWork(20, () -> {
						for (int index5 = 0; index5 < 6; index5++) {
							for (int index6 = 0; index6 < 1; index6++) {
								entity.getPersistentData().putDouble("rad", 35);
								entity.getPersistentData().putDouble("x", (entity.getX() + Math.cos(entity.getPersistentData().getDouble("theta")) * entity.getPersistentData().getDouble("rad")));
								entity.getPersistentData().putDouble("y", (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entity.getPersistentData().getDouble("x"), (int) entity.getPersistentData().getDouble("z"))));
								entity.getPersistentData().putDouble("z", (entity.getZ() + Math.sin(entity.getPersistentData().getDouble("theta")) * entity.getPersistentData().getDouble("rad")));
								entity.getPersistentData().putDouble("theta", (Mth.nextInt(RandomSource.create(), 0, 360)));
							}
							if (Mth.nextInt(RandomSource.create(), 1, 5) == 1) {
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getPersistentData().getDouble("x")), (entity.getPersistentData().getDouble("y")), (entity.getPersistentData().getDouble("z"))), Vec2.ZERO, _level,
													4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											"/summon zombie ~ ~ ~ {CustomName:'{\"text\":\"The Modded Mob\"}',HandItems:[{id:\"minecraft:iron_sword\",Count:1b,tag:{Enchantments:[{}]}},{}],ArmorItems:[{id:\"minecraft:leather_boots\",Count:1b},{id:\"minecraft:leather_leggings\",Count:1b},{id:\"minecraft:leather_chestplate\",Count:1b},{id:\"minecraft:leather_helmet\",Count:1b}],Attributes:[{Name:generic.follow_range,Base:100}]}");
							}
						}
					});
				});
			}
			if (4 == entity.getPersistentData().getDouble("summonNum") && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 60 && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 80) {
				entity.getPersistentData().putDouble("summonNum", 3);
				for (int index7 = 0; index7 < 6; index7++) {
					for (int index8 = 0; index8 < 1; index8++) {
						entity.getPersistentData().putDouble("rad", 10);
						entity.getPersistentData().putDouble("x", (entity.getX() + Math.cos(entity.getPersistentData().getDouble("theta")) * entity.getPersistentData().getDouble("rad")));
						entity.getPersistentData().putDouble("y", (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entity.getPersistentData().getDouble("x"), (int) entity.getPersistentData().getDouble("z"))));
						entity.getPersistentData().putDouble("z", (entity.getZ() + Math.sin(entity.getPersistentData().getDouble("theta")) * entity.getPersistentData().getDouble("rad")));
						entity.getPersistentData().putDouble("theta", (Mth.nextInt(RandomSource.create(), 0, 360)));
					}
					if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(
									new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getPersistentData().getDouble("x")), (entity.getPersistentData().getDouble("y")), (entity.getPersistentData().getDouble("z"))), Vec2.ZERO, _level, 4, "",
											Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"/summon husk ~ ~ ~ {CustomName:'{\"text\":\"The Modded Mob\"}',HandItems:[{id:\"minecraft:iron_sword\",Count:1b,tag:{Enchantments:[{}]}},{}],Attributes:[{Name:generic.follow_range,Base:100}]}");
					}
				}
				TooMuchBossesMod.queueServerWork(20, () -> {
					for (int index9 = 0; index9 < 6; index9++) {
						for (int index10 = 0; index10 < 1; index10++) {
							entity.getPersistentData().putDouble("rad", 35);
							entity.getPersistentData().putDouble("x", (entity.getX() + Math.cos(entity.getPersistentData().getDouble("theta")) * entity.getPersistentData().getDouble("rad")));
							entity.getPersistentData().putDouble("y", (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entity.getPersistentData().getDouble("x"), (int) entity.getPersistentData().getDouble("z"))));
							entity.getPersistentData().putDouble("z", (entity.getZ() + Math.sin(entity.getPersistentData().getDouble("theta")) * entity.getPersistentData().getDouble("rad")));
							entity.getPersistentData().putDouble("theta", (Mth.nextInt(RandomSource.create(), 0, 360)));
						}
						if (Mth.nextInt(RandomSource.create(), 1, 3) == 1) {
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getPersistentData().getDouble("x")), (entity.getPersistentData().getDouble("y")), (entity.getPersistentData().getDouble("z"))), Vec2.ZERO, _level, 4,
												"", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"/summon skeleton ~ ~ ~ {CustomName:'{\"text\":\"The Modded Mob\"}',HandItems:[{id:\"minecraft:bow\",Count:1b,tag:{Enchantments:[{id:\"minecraft:unbreaking\",lvl:1s},{id:\"minecraft:power\",lvl:1s},{id:\"minecraft:infinity\",lvl:1s},{id:\"minecraft:mending\",lvl:1s}]}},{}],HandDropChances:[1.000F,0.085F],ArmorItems:[{},{},{},{id:\"minecraft:chainmail_helmet\",Count:1b,tag:{Enchantments:[{}]}}],Attributes:[{Name:generic.follow_range,Base:100}]}");
						}
					}
					TooMuchBossesMod.queueServerWork(20, () -> {
						for (int index11 = 0; index11 < 6; index11++) {
							for (int index12 = 0; index12 < 1; index12++) {
								entity.getPersistentData().putDouble("rad", 35);
								entity.getPersistentData().putDouble("x", (entity.getX() + Math.cos(entity.getPersistentData().getDouble("theta")) * entity.getPersistentData().getDouble("rad")));
								entity.getPersistentData().putDouble("y", (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entity.getPersistentData().getDouble("x"), (int) entity.getPersistentData().getDouble("z"))));
								entity.getPersistentData().putDouble("z", (entity.getZ() + Math.sin(entity.getPersistentData().getDouble("theta")) * entity.getPersistentData().getDouble("rad")));
								entity.getPersistentData().putDouble("theta", (Mth.nextInt(RandomSource.create(), 0, 360)));
							}
							if (Mth.nextInt(RandomSource.create(), 1, 5) == 1) {
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getPersistentData().getDouble("x")), (entity.getPersistentData().getDouble("y")), (entity.getPersistentData().getDouble("z"))), Vec2.ZERO, _level,
													4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											"/summon drowned ~ ~ ~ {Health:40f,CustomName:'{\"text\":\"The Modded Mob\"}',HandItems:[{id:\"minecraft:trident\",Count:1b,tag:{Enchantments:[{id:\"minecraft:unbreaking\",lvl:2s},{id:\"minecraft:impaling\",lvl:2s},{id:\"minecraft:riptide\",lvl:2s},{id:\"minecraft:mending\",lvl:2s}]}},{id:\"minecraft:nautilus_shell\",Count:3b,tag:{Enchantments:[{}]}}],HandDropChances:[1.000F,1.000F],ArmorItems:[{id:\"minecraft:leather_boots\",Count:1b,tag:{display:{color:2303},Enchantments:[{}],Trim:{material:\"minecraft:diamond\",pattern:\"minecraft:tide\"}}},{id:\"minecraft:leather_leggings\",Count:1b,tag:{display:{color:2303},Enchantments:[{}],Trim:{material:\"minecraft:diamond\",pattern:\"minecraft:tide\"}}},{id:\"minecraft:leather_chestplate\",Count:1b,tag:{display:{color:2303},Enchantments:[{}],Trim:{material:\"minecraft:diamond\",pattern:\"minecraft:tide\"}}},{id:\"minecraft:leather_helmet\",Count:1b,tag:{display:{color:2303},Enchantments:[{id:\"minecraft:unbreaking\",lvl:3s}],Trim:{material:\"minecraft:diamond\",pattern:\"minecraft:tide\"}}}],Attributes:[{Name:generic.follow_range,Base:100},{Name:generic.armor,Base:22}]}");
							}
						}
						TooMuchBossesMod.queueServerWork(20, () -> {
							for (int index13 = 0; index13 < 1; index13++) {
								entity.getPersistentData().putDouble("rad", 10);
								entity.getPersistentData().putDouble("x", (entity.getX() + Math.cos(entity.getPersistentData().getDouble("theta")) * entity.getPersistentData().getDouble("rad")));
								entity.getPersistentData().putDouble("y", (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entity.getPersistentData().getDouble("x"), (int) entity.getPersistentData().getDouble("z"))));
								entity.getPersistentData().putDouble("z", (entity.getZ() + Math.sin(entity.getPersistentData().getDouble("theta")) * entity.getPersistentData().getDouble("rad")));
								entity.getPersistentData().putDouble("theta", (Mth.nextInt(RandomSource.create(), 0, 360)));
							}
							if (Mth.nextInt(RandomSource.create(), 1, 5) == 1) {
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getPersistentData().getDouble("x")), (entity.getPersistentData().getDouble("y")), (entity.getPersistentData().getDouble("z"))), Vec2.ZERO, _level,
													4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											"/summon zombie ~ ~ ~ {Health:50f,CustomName:'{\"text\":\"The Modded Mob\"}',HandItems:[{id:\"minecraft:diamond_sword\",Count:1b,tag:{Enchantments:[{id:\"minecraft:sharpness\",lvl:3s},{id:\"minecraft:smite\",lvl:3s},{id:\"minecraft:bane_of_arthropods\",lvl:3s},{id:\"minecraft:knockback\",lvl:2s},{id:\"minecraft:looting\",lvl:2s},{id:\"minecraft:sweeping\",lvl:2s},{id:\"minecraft:unbreaking\",lvl:2s},{id:\"minecraft:mending\",lvl:2s}]}},{id:\"minecraft:diamond_sword\",Count:1b,tag:{Damage:1,Enchantments:[{id:\"minecraft:sharpness\",lvl:3s},{id:\"minecraft:smite\",lvl:2s},{id:\"minecraft:bane_of_arthropods\",lvl:2s},{id:\"minecraft:knockback\",lvl:2s},{id:\"minecraft:looting\",lvl:2s},{id:\"minecraft:sweeping\",lvl:2s},{id:\"minecraft:unbreaking\",lvl:2s},{id:\"minecraft:mending\",lvl:2s}]}}],HandDropChances:[1.000F,0.085F],ArmorItems:[{id:\"minecraft:diamond_boots\",Count:1b,tag:{Enchantments:[{}]}},{id:\"minecraft:diamond_leggings\",Count:1b,tag:{Enchantments:[{}]}},{id:\"minecraft:diamond_chestplate\",Count:1b,tag:{Enchantments:[{}]}},{id:\"minecraft:diamond_helmet\",Count:1b,tag:{Enchantments:[{}]}}],Attributes:[{Name:generic.max_health,Base:50},{Name:generic.follow_range,Base:100},{Name:generic.knockback_resistance,Base:2},{Name:generic.movement_speed,Base:0.3},{Name:generic.armor_toughness,Base:14}]}");
							}
						});
					});
				});
			}
			if (3 == entity.getPersistentData().getDouble("summonNum") && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 40 && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 60) {
				entity.getPersistentData().putDouble("summonNum", 2);
				for (int index14 = 0; index14 < 6; index14++) {
					for (int index15 = 0; index15 < 1; index15++) {
						entity.getPersistentData().putDouble("rad", 35);
						entity.getPersistentData().putDouble("x", (entity.getX() + Math.cos(entity.getPersistentData().getDouble("theta")) * entity.getPersistentData().getDouble("rad")));
						entity.getPersistentData().putDouble("y", (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entity.getPersistentData().getDouble("x"), (int) entity.getPersistentData().getDouble("z"))));
						entity.getPersistentData().putDouble("z", (entity.getZ() + Math.sin(entity.getPersistentData().getDouble("theta")) * entity.getPersistentData().getDouble("rad")));
						entity.getPersistentData().putDouble("theta", (Mth.nextInt(RandomSource.create(), 0, 360)));
					}
					if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(
									new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getPersistentData().getDouble("x")), (entity.getPersistentData().getDouble("y")), (entity.getPersistentData().getDouble("z"))), Vec2.ZERO, _level, 4, "",
											Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"/summon skeleton ~ ~ ~ {CustomName:'{\"text\":\"The Modded Mob\"}',HandItems:[{id:\"minecraft:bow\",Count:1b,tag:{Enchantments:[{id:\"minecraft:unbreaking\",lvl:1s},{id:\"minecraft:power\",lvl:1s},{id:\"minecraft:infinity\",lvl:1s},{id:\"minecraft:mending\",lvl:1s}]}},{}],HandDropChances:[1.000F,0.085F],ArmorItems:[{},{},{},{id:\"minecraft:chainmail_helmet\",Count:1b,tag:{Enchantments:[{}]}}],Attributes:[{Name:generic.follow_range,Base:100}]}");
					}
					if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(
									new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getPersistentData().getDouble("x")), (entity.getPersistentData().getDouble("y")), (entity.getPersistentData().getDouble("z"))), Vec2.ZERO, _level, 4, "",
											Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"/summon skeleton ~ ~ ~ {CustomName:'{\"text\":\"The Modded Mob\"}',HandItems:[{id:\"minecraft:bow\",Count:1b,tag:{Enchantments:[{id:\"minecraft:unbreaking\",lvl:1s},{id:\"minecraft:power\",lvl:1s},{id:\"minecraft:infinity\",lvl:1s},{id:\"minecraft:mending\",lvl:1s}]}},{}],HandDropChances:[1.000F,0.085F],ArmorItems:[{id:\"minecraft:chainmail_boots\",Count:1b},{id:\"minecraft:chainmail_leggings\",Count:1b},{id:\"minecraft:chainmail_chestplate\",Count:1b},{id:\"minecraft:chainmail_helmet\",Count:1b}],Attributes:[{Name:generic.follow_range,Base:100}]}");
					}
				}
				TooMuchBossesMod.queueServerWork(40, () -> {
					for (int index16 = 0; index16 < 6; index16++) {
						for (int index17 = 0; index17 < 1; index17++) {
							entity.getPersistentData().putDouble("rad", 35);
							entity.getPersistentData().putDouble("x", (entity.getX() + Math.cos(entity.getPersistentData().getDouble("theta")) * entity.getPersistentData().getDouble("rad")));
							entity.getPersistentData().putDouble("y", (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entity.getPersistentData().getDouble("x"), (int) entity.getPersistentData().getDouble("z"))));
							entity.getPersistentData().putDouble("z", (entity.getZ() + Math.sin(entity.getPersistentData().getDouble("theta")) * entity.getPersistentData().getDouble("rad")));
							entity.getPersistentData().putDouble("theta", (Mth.nextInt(RandomSource.create(), 0, 360)));
						}
						if (Mth.nextInt(RandomSource.create(), 1, 5) == 1) {
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getPersistentData().getDouble("x")), (entity.getPersistentData().getDouble("y")), (entity.getPersistentData().getDouble("z"))), Vec2.ZERO, _level, 4,
												"", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"/summon skeleton_horse ~ ~ ~ {CustomName:'{\"text\":\"The Modded Mob\"}',Health:40f,Passengers:[{id:\"minecraft:skeleton\",CustomName:'{\"text\":\"The Modded Mob\"}',HandItems:[{id:\"minecraft:bow\",Count:1b,tag:{Enchantments:[{id:\"minecraft:unbreaking\",lvl:1s},{id:\"minecraft:power\",lvl:1s},{id:\"minecraft:punch\",lvl:1s},{id:\"minecraft:flame\",lvl:1s},{id:\"minecraft:infinity\",lvl:1s},{id:\"minecraft:mending\",lvl:1s}]}},{id:\"minecraft:diamond\",Count:1b,tag:{Enchantments:[{}]}}],HandDropChances:[1.000F,1.000F],ArmorItems:[{id:\"minecraft:iron_boots\",Count:1b,tag:{Enchantments:[{}]}},{id:\"minecraft:iron_leggings\",Count:1b,tag:{Enchantments:[{}]}},{id:\"minecraft:iron_chestplate\",Count:1b,tag:{Enchantments:[{}]}},{id:\"minecraft:iron_helmet\",Count:1b,tag:{Enchantments:[{}]}}],Attributes:[{Name:generic.follow_range,Base:100}]}],HandItems:[{id:\"minecraft:bow\",Count:1b,tag:{Enchantments:[{id:\"minecraft:unbreaking\",lvl:1s},{id:\"minecraft:power\",lvl:2s},{id:\"minecraft:infinity\",lvl:1s},{id:\"minecraft:mending\",lvl:1s}]}},{}],HandDropChances:[1.000F,0.085F],ArmorItems:[{id:\"minecraft:chainmail_boots\",Count:1b},{id:\"minecraft:chainmail_leggings\",Count:1b},{id:\"minecraft:chainmail_chestplate\",Count:1b},{id:\"minecraft:chainmail_helmet\",Count:1b}],Attributes:[{Name:generic.movement_speed,Base:0.5},{Name:generic.follow_range,Base:100}]}");
						}
					}
					TooMuchBossesMod.queueServerWork(20, () -> {
						for (int index18 = 0; index18 < 6; index18++) {
							for (int index19 = 0; index19 < 1; index19++) {
								entity.getPersistentData().putDouble("rad", 10);
								entity.getPersistentData().putDouble("x", (entity.getX() + Math.cos(entity.getPersistentData().getDouble("theta")) * entity.getPersistentData().getDouble("rad")));
								entity.getPersistentData().putDouble("y", (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entity.getPersistentData().getDouble("x"), (int) entity.getPersistentData().getDouble("z"))));
								entity.getPersistentData().putDouble("z", (entity.getZ() + Math.sin(entity.getPersistentData().getDouble("theta")) * entity.getPersistentData().getDouble("rad")));
								entity.getPersistentData().putDouble("theta", (Mth.nextInt(RandomSource.create(), 0, 360)));
							}
							if (Mth.nextInt(RandomSource.create(), 1, 3) == 1) {
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getPersistentData().getDouble("x")), (entity.getPersistentData().getDouble("y")), (entity.getPersistentData().getDouble("z"))), Vec2.ZERO, _level,
													4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											"/summon wither_skeleton ~ ~ ~ {CustomName:'{\"text\":\"The Modded Mob\"}',HandItems:[{id:\"minecraft:iron_axe\",Count:1b,tag:{Enchantments:[{}]}},{}]}");
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getPersistentData().getDouble("x")), (entity.getPersistentData().getDouble("y")), (entity.getPersistentData().getDouble("z"))), Vec2.ZERO, _level,
													4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											"/summon wither_skeleton ~ ~ ~ {CustomName:'{\"text\":\"The Modded Mob\"}',HandItems:[{id:\"minecraft:iron_axe\",Count:1b,tag:{Enchantments:[{}]}},{}]}");
							}
						}
					});
				});
			}
			if (2 == entity.getPersistentData().getDouble("summonNum") && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 20 && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 40) {
				entity.getPersistentData().putDouble("summonNum", 1);
				if (entity instanceof LivingEntity _entity)
					_entity.setHealth(40);
				for (int index20 = 0; index20 < 6; index20++) {
					for (int index21 = 0; index21 < 1; index21++) {
						entity.getPersistentData().putDouble("rad", 35);
						entity.getPersistentData().putDouble("x", (entity.getX() + Math.cos(entity.getPersistentData().getDouble("theta")) * entity.getPersistentData().getDouble("rad")));
						entity.getPersistentData().putDouble("y", (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entity.getPersistentData().getDouble("x"), (int) entity.getPersistentData().getDouble("z"))));
						entity.getPersistentData().putDouble("z", (entity.getZ() + Math.sin(entity.getPersistentData().getDouble("theta")) * entity.getPersistentData().getDouble("rad")));
						entity.getPersistentData().putDouble("theta", (Mth.nextInt(RandomSource.create(), 0, 360)));
					}
					if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(
									new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getPersistentData().getDouble("x")), (entity.getPersistentData().getDouble("y")), (entity.getPersistentData().getDouble("z"))), Vec2.ZERO, _level, 4, "",
											Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"/summon pillager ~ ~ ~ {CustomName:'{\"text\":\"The Modded Mob\"}',HandItems:[{id:\"minecraft:crossbow\",Count:1b,tag:{Enchantments:[{id:\"minecraft:multishot\",lvl:3s}],ChargedProjectiles:[{id:\"minecraft:spectral_arrow\",Count:1b},{id:\"minecraft:firework_rocket\",Count:1b,tag:{Fireworks:{Flight:6b,Explosions:[{Type:2,Colors:[I;16774917],FadeColors:[I;16741235]}]}}},{id:\"minecraft:firework_rocket\",Count:1b,tag:{Fireworks:{Explosions:[{Type:2,Colors:[I;15662848],FadeColors:[I;16711680]}]}}}],Charged:1b}},{}],Attributes:[{Name:generic.follow_range,Base:100}]}");
					}
				}
				TooMuchBossesMod.queueServerWork(80, () -> {
					for (int index22 = 0; index22 < 6; index22++) {
						for (int index23 = 0; index23 < 1; index23++) {
							entity.getPersistentData().putDouble("rad", 10);
							entity.getPersistentData().putDouble("x", (entity.getX() + Math.cos(entity.getPersistentData().getDouble("theta")) * entity.getPersistentData().getDouble("rad")));
							entity.getPersistentData().putDouble("y", (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entity.getPersistentData().getDouble("x"), (int) entity.getPersistentData().getDouble("z"))));
							entity.getPersistentData().putDouble("z", (entity.getZ() + Math.sin(entity.getPersistentData().getDouble("theta")) * entity.getPersistentData().getDouble("rad")));
							entity.getPersistentData().putDouble("theta", (Mth.nextInt(RandomSource.create(), 0, 360)));
						}
						if (Mth.nextInt(RandomSource.create(), 1, 3) == 1) {
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getPersistentData().getDouble("x")), (entity.getPersistentData().getDouble("y")), (entity.getPersistentData().getDouble("z"))), Vec2.ZERO, _level, 4,
												"", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"/summon vindicator ~ ~ ~ {CustomName:'{\"text\":\"The Modded Mob\"}',HandItems:[{id:\"minecraft:iron_axe\",Count:1b,tag:{Enchantments:[{}]}},{id:\"minecraft:tnt\",Count:1b}],HandDropChances:[1.000F,1.000F],Attributes:[{Name:generic.follow_range,Base:100}]}");
							if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getPersistentData().getDouble("x")), (entity.getPersistentData().getDouble("y")), (entity.getPersistentData().getDouble("z"))), Vec2.ZERO, _level,
													4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											"/summon vindicator ~ ~ ~ {CustomName:'{\"text\":\"The Modded Mob\"}',HandItems:[{id:\"minecraft:iron_axe\",Count:1b,tag:{Enchantments:[{}]}},{id:\"minecraft:tnt\",Count:1b}],HandDropChances:[1.000F,1.000F],Attributes:[{Name:generic.follow_range,Base:100}]}");
								if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getPersistentData().getDouble("x")), (entity.getPersistentData().getDouble("y")), (entity.getPersistentData().getDouble("z"))), Vec2.ZERO,
														_level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/summon vindicator ~ ~ ~ {CustomName:'{\"text\":\"The Modded Mob\"}',HandItems:[{id:\"minecraft:iron_axe\",Count:1b,tag:{Enchantments:[{}]}},{id:\"minecraft:tnt\",Count:1b}],HandDropChances:[1.000F,1.000F],Attributes:[{Name:generic.follow_range,Base:100}]}");
									if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
										if (world instanceof ServerLevel _level)
											_level.getServer().getCommands().performPrefixedCommand(
													new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getPersistentData().getDouble("x")), (entity.getPersistentData().getDouble("y")), (entity.getPersistentData().getDouble("z"))), Vec2.ZERO,
															_level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
													"/summon vindicator ~ ~ ~ {CustomName:'{\"text\":\"The Modded Mob\"}',HandItems:[{id:\"minecraft:iron_axe\",Count:1b,tag:{Enchantments:[{}]}},{id:\"minecraft:tnt\",Count:1b}],HandDropChances:[1.000F,1.000F],Attributes:[{Name:generic.follow_range,Base:100}]}");
									}
								}
							}
						}
					}
					TooMuchBossesMod.queueServerWork(20, () -> {
						for (int index24 = 0; index24 < 6; index24++) {
							for (int index25 = 0; index25 < 1; index25++) {
								entity.getPersistentData().putDouble("rad", 35);
								entity.getPersistentData().putDouble("x", (entity.getX() + Math.cos(entity.getPersistentData().getDouble("theta")) * entity.getPersistentData().getDouble("rad")));
								entity.getPersistentData().putDouble("y", (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entity.getPersistentData().getDouble("x"), (int) entity.getPersistentData().getDouble("z"))));
								entity.getPersistentData().putDouble("z", (entity.getZ() + Math.sin(entity.getPersistentData().getDouble("theta")) * entity.getPersistentData().getDouble("rad")));
								entity.getPersistentData().putDouble("theta", (Mth.nextInt(RandomSource.create(), 0, 360)));
							}
							if (Mth.nextInt(RandomSource.create(), 1, 5) == 1) {
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getPersistentData().getDouble("x")), (entity.getPersistentData().getDouble("y")), (entity.getPersistentData().getDouble("z"))), Vec2.ZERO, _level,
													4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											"/summon ravager ~ ~ ~ {Passengers:[{id:\"minecraft:evoker\",PatrolLeader:1b,Health:40f,CustomName:'{\"text\":\"The Modded Mob\"}',HandItems:[{},{id:\"minecraft:totem_of_undying\",Count:2b}],ArmorItems:[{},{},{},{}],Attributes:[{Name:generic.max_health,Base:40},{Name:generic.follow_range,Base:100},{Name:generic.armor,Base:15}]}],CustomName:'{\"text\":\"The Modded Mob\"}',Attributes:[{Name:generic.follow_range,Base:100}]}");
							}
						}
					});
				});
			}
			if (1 == entity.getPersistentData().getDouble("summonNum") && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 10 && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 20) {
				entity.getPersistentData().putDouble("summonNum", 0);
				if (entity instanceof LivingEntity _entity)
					_entity.setHealth(20);
				for (int index26 = 0; index26 < 3; index26++) {
					for (int index27 = 0; index27 < 1; index27++) {
						entity.getPersistentData().putDouble("rad", 35);
						entity.getPersistentData().putDouble("x", (entity.getX() + Math.cos(entity.getPersistentData().getDouble("theta")) * entity.getPersistentData().getDouble("rad")));
						entity.getPersistentData().putDouble("y", (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entity.getPersistentData().getDouble("x"), (int) entity.getPersistentData().getDouble("z"))));
						entity.getPersistentData().putDouble("z", (entity.getZ() + Math.sin(entity.getPersistentData().getDouble("theta")) * entity.getPersistentData().getDouble("rad")));
						entity.getPersistentData().putDouble("theta", (Mth.nextInt(RandomSource.create(), 0, 360)));
					}
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getPersistentData().getDouble("x")), (entity.getPersistentData().getDouble("y")), (entity.getPersistentData().getDouble("z"))), Vec2.ZERO, _level, 4, "",
										Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"/summon zombie ~ ~ ~ {CustomName:'{\"text\":\"The Modded Mob\"}',HandItems:[{id:\"minecraft:iron_sword\",Count:1b,tag:{Enchantments:[{}]}},{}],ArmorItems:[{id:\"minecraft:leather_boots\",Count:1b},{id:\"minecraft:leather_leggings\",Count:1b},{id:\"minecraft:leather_chestplate\",Count:1b},{id:\"minecraft:leather_helmet\",Count:1b}],Attributes:[{Name:generic.follow_range,Base:100}]}");
					TooMuchBossesMod.queueServerWork(40, () -> {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(
									new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getPersistentData().getDouble("x")), (entity.getPersistentData().getDouble("y")), (entity.getPersistentData().getDouble("z"))), Vec2.ZERO, _level, 4, "",
											Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"/summon drowned ~ ~ ~ {Health:40f,CustomName:'{\"text\":\"The Modded Mob\"}',HandItems:[{id:\"minecraft:trident\",Count:1b,tag:{Enchantments:[{id:\"minecraft:unbreaking\",lvl:2s},{id:\"minecraft:impaling\",lvl:2s},{id:\"minecraft:riptide\",lvl:2s},{id:\"minecraft:mending\",lvl:2s}]}},{id:\"minecraft:nautilus_shell\",Count:3b,tag:{Enchantments:[{}]}}],HandDropChances:[1.000F,1.000F],ArmorItems:[{id:\"minecraft:leather_boots\",Count:1b,tag:{display:{color:2303},Enchantments:[{}],Trim:{material:\"minecraft:diamond\",pattern:\"minecraft:tide\"}}},{id:\"minecraft:leather_leggings\",Count:1b,tag:{display:{color:2303},Enchantments:[{}],Trim:{material:\"minecraft:diamond\",pattern:\"minecraft:tide\"}}},{id:\"minecraft:leather_chestplate\",Count:1b,tag:{display:{color:2303},Enchantments:[{}],Trim:{material:\"minecraft:diamond\",pattern:\"minecraft:tide\"}}},{id:\"minecraft:leather_helmet\",Count:1b,tag:{display:{color:2303},Enchantments:[{id:\"minecraft:unbreaking\",lvl:3s}],Trim:{material:\"minecraft:diamond\",pattern:\"minecraft:tide\"}}}],Attributes:[{Name:generic.follow_range,Base:100},{Name:generic.armor,Base:20}]}");
						TooMuchBossesMod.queueServerWork(20, () -> {
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getPersistentData().getDouble("x")), (entity.getPersistentData().getDouble("y")), (entity.getPersistentData().getDouble("z"))), Vec2.ZERO, _level, 4,
												"", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"/summon skeleton_horse ~ ~ ~ {CustomName:'{\"text\":\"The Modded Mob\"}',Health:40f,Passengers:[{id:\"minecraft:skeleton\",CustomName:'{\"text\":\"The Modded Mob\"}',HandItems:[{id:\"minecraft:bow\",Count:1b,tag:{Enchantments:[{id:\"minecraft:unbreaking\",lvl:1s},{id:\"minecraft:power\",lvl:1s},{id:\"minecraft:punch\",lvl:1s},{id:\"minecraft:flame\",lvl:1s},{id:\"minecraft:infinity\",lvl:1s},{id:\"minecraft:mending\",lvl:1s}]}},{id:\"minecraft:diamond\",Count:1b,tag:{Enchantments:[{}]}}],HandDropChances:[1.000F,1.000F],ArmorItems:[{id:\"minecraft:iron_boots\",Count:1b,tag:{Enchantments:[{}]}},{id:\"minecraft:iron_leggings\",Count:1b,tag:{Enchantments:[{}]}},{id:\"minecraft:iron_chestplate\",Count:1b,tag:{Enchantments:[{}]}},{id:\"minecraft:iron_helmet\",Count:1b,tag:{Enchantments:[{}]}}],Attributes:[{Name:generic.follow_range,Base:100}]}],HandItems:[{id:\"minecraft:bow\",Count:1b,tag:{Enchantments:[{id:\"minecraft:unbreaking\",lvl:1s},{id:\"minecraft:power\",lvl:2s},{id:\"minecraft:infinity\",lvl:1s},{id:\"minecraft:mending\",lvl:1s}]}},{}],HandDropChances:[1.000F,0.085F],ArmorItems:[{id:\"minecraft:chainmail_boots\",Count:1b},{id:\"minecraft:chainmail_leggings\",Count:1b},{id:\"minecraft:chainmail_chestplate\",Count:1b},{id:\"minecraft:chainmail_helmet\",Count:1b}],Attributes:[{Name:generic.movement_speed,Base:0.5},{Name:generic.follow_range,Base:100}]}");
							TooMuchBossesMod.queueServerWork(20, () -> {
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getPersistentData().getDouble("x")), (entity.getPersistentData().getDouble("y")), (entity.getPersistentData().getDouble("z"))), Vec2.ZERO, _level,
													4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											"/summon ravager ~ ~ ~ {Passengers:[{id:\"minecraft:evoker\",PatrolLeader:1b,Health:40f,CustomName:'{\"text\":\"The Modded Mob\"}',HandItems:[{},{id:\"minecraft:totem_of_undying\",Count:2b}],ArmorItems:[{},{},{},{}],Attributes:[{Name:generic.max_health,Base:40},{Name:generic.follow_range,Base:100},{Name:generic.armor,Base:15}]}],CustomName:'{\"text\":\"The Modded Mob\"}',Attributes:[{Name:generic.follow_range,Base:100}]}");
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											"/summon ravager ~ ~ ~ {Passengers:[{id:\"minecraft:evoker\",PatrolLeader:1b,Health:40f,CustomName:'{\"text\":\"The Modded Mob\"}',HandItems:[{},{id:\"minecraft:totem_of_undying\",Count:2b}],ArmorItems:[{},{},{},{}],Attributes:[{Name:generic.max_health,Base:40},{Name:generic.follow_range,Base:100},{Name:generic.armor,Base:15}]}],CustomName:'{\"text\":\"The Modded Mob\"}',Attributes:[{Name:generic.follow_range,Base:100}]}");
								TooMuchBossesMod.queueServerWork(20, () -> {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getPersistentData().getDouble("x")), (entity.getPersistentData().getDouble("y")), (entity.getPersistentData().getDouble("z"))), Vec2.ZERO,
														_level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/summon zombie ~ ~ ~ {Health:50f,CustomName:'{\"text\":\"The Modded Mob\"}',HandItems:[{id:\"minecraft:diamond_sword\",Count:1b,tag:{Enchantments:[{id:\"minecraft:sharpness\",lvl:3s},{id:\"minecraft:smite\",lvl:3s},{id:\"minecraft:bane_of_arthropods\",lvl:3s},{id:\"minecraft:knockback\",lvl:2s},{id:\"minecraft:looting\",lvl:2s},{id:\"minecraft:sweeping\",lvl:2s},{id:\"minecraft:unbreaking\",lvl:2s},{id:\"minecraft:mending\",lvl:2s}]}},{id:\"minecraft:diamond_sword\",Count:1b,tag:{Damage:1,Enchantments:[{id:\"minecraft:sharpness\",lvl:3s},{id:\"minecraft:smite\",lvl:2s},{id:\"minecraft:bane_of_arthropods\",lvl:2s},{id:\"minecraft:knockback\",lvl:2s},{id:\"minecraft:looting\",lvl:2s},{id:\"minecraft:sweeping\",lvl:2s},{id:\"minecraft:unbreaking\",lvl:2s},{id:\"minecraft:mending\",lvl:2s}]}}],HandDropChances:[1.000F,0.085F],ArmorItems:[{id:\"minecraft:diamond_boots\",Count:1b,tag:{Enchantments:[{}]}},{id:\"minecraft:diamond_leggings\",Count:1b,tag:{Enchantments:[{}]}},{id:\"minecraft:diamond_chestplate\",Count:1b,tag:{Enchantments:[{}]}},{id:\"minecraft:diamond_helmet\",Count:1b,tag:{Enchantments:[{}]}}],Attributes:[{Name:generic.max_health,Base:50},{Name:generic.follow_range,Base:100},{Name:generic.knockback_resistance,Base:2},{Name:generic.movement_speed,Base:0.3},{Name:generic.armor_toughness,Base:14}]}");
								});
							});
						});
					});
				}
			}
			if (-2 <= entity.getPersistentData().getDouble("summonNum") && entity.getPersistentData().getDouble("summonNum") <= 0 && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0
					&& (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 10) {
				if (!moddedIsThere) {
					if (0 == entity.getPersistentData().getDouble("summonNum")) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(
									new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"/summon zombie ~ ~ ~ {Silent:1b,Health:80f,Passengers:[{id:\"minecraft:zombie\",Silent:1b,Health:50f,CustomName:'{\"text\":\"The Modded Mob\"}',ArmorItems:[{},{},{},{id:\"minecraft:jungle_leaves\",Count:1b,tag:{Enchantments:[{}]}}],ActiveEffects:[{Id:14,Amplifier:1b,Duration:200000,ShowParticles:0b}],Attributes:[{Name:generic.max_health,Base:50},{Name:generic.follow_range,Base:100},{Name:generic.movement_speed,Base:0.2},{Name:generic.attack_damage,Base:5}]}],CustomName:'{\"text\":\"The Modded Mob\"}',HandItems:[{id:\"minecraft:oak_wood\",Count:1b,tag:{Enchantments:[{}]}},{id:\"minecraft:oak_wood\",Count:1b,tag:{Enchantments:[{}]}}],ArmorItems:[{},{},{},{id:\"minecraft:oak_wood\",Count:1b,tag:{Enchantments:[{}]}}],ActiveEffects:[{Id:14,Amplifier:1b,Duration:200000,ShowParticles:0b}],Attributes:[{Name:generic.max_health,Base:80},{Name:generic.follow_range,Base:100},{Name:generic.movement_speed,Base:0.4},{Name:generic.attack_damage,Base:5},{Name:generic.armor,Base:15},{Name:generic.attack_knockback,Base:1.5}]}");
						entity.getPersistentData().putDouble("summonNum", (entity.getPersistentData().getDouble("summonNum") - 1));
					} else {
						if (-1 == entity.getPersistentData().getDouble("summonNum")) {
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY() + 5), (entity.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"/summon vex ~ ~ ~ {Silent:1b,Health:80f,Passengers:[{id:\"minecraft:creeper\",Silent:1b,Health:80f,powered:1b,Fuse:1,Passengers:[{id:\"minecraft:minecart\",Passengers:[{id:\"minecraft:skeleton\",Silent:1b,Health:80f,CustomName:'{\"text\":\"The Modded Mob\"}',HandItems:[{id:\"minecraft:bow\",Count:1b,tag:{Enchantments:[{id:\"minecraft:unbreaking\",lvl:1s},{id:\"minecraft:power\",lvl:1s},{id:\"minecraft:punch\",lvl:1s},{id:\"minecraft:flame\",lvl:1s}]}},{id:\"minecraft:tipped_arrow\",Count:64b,tag:{CustomPotionEffects:[{Id:2,Amplifier:1b,Duration:200},{Id:17,Amplifier:10b,Duration:100},{Id:19,Amplifier:1b,Duration:200}]}}],HandDropChances:[0.085F,1.000F],ArmorItems:[{id:\"minecraft:iron_boots\",Count:1b,tag:{Enchantments:[{id:\"minecraft:blast_protection\",lvl:100s}]}},{id:\"minecraft:iron_leggings\",Count:1b,tag:{Enchantments:[{id:\"minecraft:blast_protection\",lvl:100s}]}},{id:\"minecraft:iron_chestplate\",Count:1b,tag:{Enchantments:[{id:\"minecraft:blast_protection\",lvl:100s}]}},{id:\"minecraft:observer\",Count:1b,tag:{Enchantments:[{}]}}],ActiveEffects:[{Id:14,Amplifier:1b,Duration:200000,ShowParticles:0b}],Attributes:[{Name:generic.max_health,Base:80},{Name:generic.follow_range,Base:100},{Name:generic.movement_speed,Base:0.3}]}]}],CustomName:'{\"text\":\"The Modded Mob\"}',ActiveEffects:[{Id:14,Amplifier:1b,Duration:200000,ShowParticles:0b}],Attributes:[{Name:generic.max_health,Base:80},{Name:generic.follow_range,Base:100}]}],CustomName:'{\"text\":\"The Modded Mob\"}',ActiveEffects:[{Id:14,Amplifier:1b,Duration:200000,ShowParticles:0b}],Attributes:[{Name:generic.max_health,Base:80},{Name:generic.follow_range,Base:100},{Name:generic.movement_speed,Base:0.5},{Name:generic.armor,Base:0},{Name:generic.armor_toughness,Base:0}]}");
							entity.getPersistentData().putDouble("summonNum", (entity.getPersistentData().getDouble("summonNum") - 1));
						} else {
							if (-2 == entity.getPersistentData().getDouble("summonNum")) {
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											"/summon skeleton ~ ~ ~ {Silent:1b,FallFlying:1b,Health:80f,Tags:[\"wizard\"],CustomName:'{\"text\":\"The Modded Mob\"}',HandItems:[{id:\"minecraft:knowledge_book\",Count:1b},{id:\"minecraft:spectral_arrow\",Count:64b,tag:{Enchantments:[{}]}}],HandDropChances:[0.000F,1.000F],ArmorItems:[{},{},{id:\"minecraft:elytra\",Count:1b,tag:{Enchantments:[{id:\"minecraft:unbreaking\",lvl:1s},{id:\"minecraft:mending\",lvl:1s}]}},{id:\"minecraft:creeper_head\",Count:1b,tag:{Enchantments:[{}]}}],ArmorDropChances:[0.085F,0.085F,0.000F,0.000F],ActiveEffects:[{Id:14,Amplifier:1b,Duration:200000,ShowParticles:0b}],Attributes:[{Name:generic.max_health,Base:80},{Name:generic.follow_range,Base:100},{Name:generic.movement_speed,Base:0.5},{Name:generic.armor,Base:15},{Name:generic.armor_toughness,Base:10}]}");
								entity.getPersistentData().putDouble("summonNum", (entity.getPersistentData().getDouble("summonNum") - 1));
							}
						}
					}
				}
				if (entity instanceof LivingEntity _entity)
					_entity.setHealth(10);
			}
		}
	}
}

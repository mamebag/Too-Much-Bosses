package net.mcreator.toomuchbosses.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.monster.Vex;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.toomuchbosses.TooMuchBossesMod;

import java.util.List;
import java.util.Comparator;

public class MayhemMakerEntityDiesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.POOF, x, y, z, 100, 0, 0, 0, 1);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.EXPLOSION_EMITTER, x, y, z, 3, 0, 0, 0, 1);
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"/summon iron_golem ~ ~ ~ {CustomName:'{\"text\":\"The Modded Mob\"}',Health:120f,Motion:[0.0,1.0,0.0],Passengers:[{id:\"minecraft:chest_minecart\",Items:[{Slot:0b,id:\"minecraft:enchanted_golden_apple\",Count:16b},{Slot:1b,id:\"minecraft:gold_nugget\",Count:64b},{Slot:2b,id:\"minecraft:gold_nugget\",Count:64b},{Slot:3b,id:\"minecraft:gold_nugget\",Count:64b},{Slot:4b,id:\"minecraft:raw_gold\",Count:64b},{Slot:5b,id:\"minecraft:gold_block\",Count:16b},{Slot:6b,id:\"minecraft:raw_gold_block\",Count:32b},{Slot:7b,id:\"minecraft:nether_gold_ore\",Count:64b},{Slot:8b,id:\"minecraft:iron_sword\",Count:1b,tag:{Enchantments:[{}]}},{Slot:9b,id:\"minecraft:trident\",Count:1b,tag:{Enchantments:[{id:\"minecraft:unbreaking\",lvl:3s},{id:\"minecraft:loyalty\",lvl:3s},{id:\"minecraft:impaling\",lvl:3s},{id:\"minecraft:channeling\",lvl:3s},{id:\"minecraft:mending\",lvl:3s}]}},{Slot:10b,id:\"minecraft:golden_axe\",Count:1b,tag:{Enchantments:[{id:\"minecraft:sharpness\",lvl:3s},{id:\"minecraft:smite\",lvl:3s},{id:\"minecraft:bane_of_arthropods\",lvl:3s},{id:\"minecraft:efficiency\",lvl:3s},{id:\"minecraft:silk_touch\",lvl:3s},{id:\"minecraft:unbreaking\",lvl:3s},{id:\"minecraft:fortune\",lvl:3s},{id:\"minecraft:mending\",lvl:3s}]}},{Slot:11b,id:\"minecraft:bow\",Count:1b,tag:{Enchantments:[{id:\"minecraft:unbreaking\",lvl:3s},{id:\"minecraft:power\",lvl:3s},{id:\"minecraft:punch\",lvl:3s},{id:\"minecraft:infinity\",lvl:3s},{id:\"minecraft:mending\",lvl:3s}]}},{Slot:12b,id:\"minecraft:diamond\",Count:64b,tag:{Enchantments:[{}]}},{Slot:13b,id:\"minecraft:diamond_sword\",Count:1b,tag:{Enchantments:[{id:\"minecraft:sharpness\",lvl:3s},{id:\"minecraft:smite\",lvl:3s},{id:\"minecraft:bane_of_arthropods\",lvl:3s},{id:\"minecraft:knockback\",lvl:3s},{id:\"minecraft:looting\",lvl:3s},{id:\"minecraft:sweeping\",lvl:3s},{id:\"minecraft:unbreaking\",lvl:3s},{id:\"minecraft:mending\",lvl:3s}]}},{Slot:14b,id:\"minecraft:shield\",Count:1b,tag:{Unbreakable:1b,Enchantments:[{id:\"minecraft:unbreaking\",lvl:3s},{id:\"minecraft:mending\",lvl:3s}]}},{Slot:15b,id:\"minecraft:netherite_axe\",Count:1b,tag:{Enchantments:[{id:\"minecraft:sharpness\",lvl:6s},{id:\"minecraft:smite\",lvl:6s},{id:\"minecraft:bane_of_arthropods\",lvl:6s},{id:\"minecraft:efficiency\",lvl:6s},{id:\"minecraft:silk_touch\",lvl:6s},{id:\"minecraft:unbreaking\",lvl:6s},{id:\"minecraft:fortune\",lvl:6s},{id:\"minecraft:mending\",lvl:6s}]}},{Slot:16b,id:\"minecraft:totem_of_undying\",Count:64b,tag:{Enchantments:[{}]}}]}],HandItems:[{},{id:\"minecraft:totem_of_undying\",Count:6b}],ArmorItems:[{},{},{id:\"minecraft:leather_chestplate\",Count:1b,tag:{Unbreakable:1b,Enchantments:[{id:\"minecraft:protection\",lvl:2s},{id:\"minecraft:fire_protection\",lvl:2s},{id:\"minecraft:blast_protection\",lvl:2s},{id:\"minecraft:projectile_protection\",lvl:2s},{id:\"minecraft:thorns\",lvl:5s}]}},{}],ActiveEffects:[{Id:10,Amplifier:2b,Duration:200000,ShowParticles:1b},{Id:12,Amplifier:2b,Duration:200000,ShowParticles:1b},{Id:26,Amplifier:2b,Duration:200000,ShowParticles:1b},{Id:32,Amplifier:2b,Duration:200000,ShowParticles:1b}],Attributes:[{Name:generic.max_health,Base:120},{Name:generic.follow_range,Base:100},{Name:generic.knockback_resistance,Base:10},{Name:generic.movement_speed,Base:0.4},{Name:generic.attack_damage,Base:20},{Name:generic.armor_toughness,Base:15}]}");
		TooMuchBossesMod.queueServerWork(20, () -> {
			if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if ((entityiterator.getDisplayName().getString()).equals("The Modded Mob")) {
							if (entityiterator instanceof Mob _entity && (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity _ent)
								_entity.setTarget(_ent);
						}
						if (entityiterator instanceof Vex) {
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 10000, 2));
						}
					}
				}
			}
		});
	}
}

package net.mcreator.toomuchbosses.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.toomuchbosses.init.TooMuchBossesModBlocks;
import net.mcreator.toomuchbosses.entity.FrozenWarlockEntity;
import net.mcreator.toomuchbosses.TooMuchBossesMod;

import java.util.List;
import java.util.Comparator;

public class WarlocksTowerIceBlockAddedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.place")), SoundSource.NEUTRAL, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.place")), SoundSource.NEUTRAL, 1, 1, false);
			}
		}
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof Player || entityiterator instanceof FrozenWarlockEntity) {
					entityiterator.setDeltaMovement(new Vec3(0, 0, 0));
					{
						Entity _ent = entityiterator;
						_ent.teleportTo((entityiterator.getX()), (entityiterator.getY() + 1.3), (entityiterator.getZ()));
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport((entityiterator.getX()), (entityiterator.getY() + 1.3), (entityiterator.getZ()), _ent.getYRot(), _ent.getXRot());
					}
				}
			}
		}
		TooMuchBossesMod.queueServerWork(Mth.nextInt(RandomSource.create(), 300, 340), () -> {
			if (TooMuchBossesModBlocks.WARLOCKS_TOWER_ICE.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
				world.destroyBlock(BlockPos.containing(x, y, z), false);
			}
		});
	}
}

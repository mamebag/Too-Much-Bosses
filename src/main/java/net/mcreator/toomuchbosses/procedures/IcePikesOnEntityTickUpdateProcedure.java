package net.mcreator.toomuchbosses.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.toomuchbosses.init.TooMuchBossesModBlocks;
import net.mcreator.toomuchbosses.entity.IcePikesEntity;

public class IcePikesOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean found = false;
		Entity warlock = null;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double Zknockback = 0;
		double Yknockback = 0;
		double Xknockback = 0;
		double dis = 0;
		if (!(Blocks.AIR == (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock())) {
			((IcePikesEntity) entity).onLand = true;
		} else {
			((IcePikesEntity) entity).onLand = false;
		}
		if (200 < entity.tickCount) {
			if (((IcePikesEntity) entity).onLand) {
				world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.BLUE_ICE.defaultBlockState()));
				world.levelEvent(2001, BlockPos.containing(x + 1, y, z + 1), Block.getId(Blocks.BLUE_ICE.defaultBlockState()));
				world.levelEvent(2001, BlockPos.containing(x + -1, y, z + -1), Block.getId(Blocks.BLUE_ICE.defaultBlockState()));
				world.levelEvent(2001, BlockPos.containing(x + -1, y, z + 1), Block.getId(Blocks.BLUE_ICE.defaultBlockState()));
				world.levelEvent(2001, BlockPos.containing(x + 1, y, z + -1), Block.getId(Blocks.BLUE_ICE.defaultBlockState()));
				if (!entity.level().isClientSide())
					entity.discard();
			}
		}
		if (entity.tickCount < 20) {
			entity.getPersistentData().putBoolean("hashit", false);
			entity.setNoGravity(true);
			entity.setDeltaMovement(new Vec3(0, 0, 0));
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SPLASH, x, y, z, 100, (((double) entity.tickCount) * 0.1), (((double) entity.tickCount) * 0.1), (((double) entity.tickCount) * 0.1), 0);
		} else {
			entity.setNoGravity(false);
			if ((entity.tickCount == 20) || (entity.tickCount == 21)) {
				entity.setDeltaMovement(new Vec3(0, (-1), 0));
			}
			if (((IcePikesEntity) entity).onLand) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.SNOWFLAKE, x, y, z, 50, 0.5, 0.5, 0.5, 0);
			} else {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/particle block packed_ice ~ ~ ~ 0.5 0.5 0.5 0 20 normal");
			}
		}
		sx = -3;
		found = false;
		for (int index0 = 0; index0 < 6; index0++) {
			sy = -3;
			for (int index1 = 0; index1 < 6; index1++) {
				sz = -3;
				for (int index2 = 0; index2 < 6; index2++) {
					if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == TooMuchBossesModBlocks.WARLOCKS_SNOW.get()
							|| (world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == TooMuchBossesModBlocks.WARLOCKS_ICE.get()) {
						world.destroyBlock(BlockPos.containing(x + sx, y + sy, z + sz), false);
					}
					sz = sz + 1;
				}
				sy = sy + 1;
			}
			sx = sx + 1;
		}
	}
}

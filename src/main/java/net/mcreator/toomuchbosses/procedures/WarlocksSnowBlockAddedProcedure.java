package net.mcreator.toomuchbosses.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.toomuchbosses.init.TooMuchBossesModBlocks;
import net.mcreator.toomuchbosses.TooMuchBossesMod;

public class WarlocksSnowBlockAddedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.powder_snow.fall")), SoundSource.NEUTRAL, 2, (float) 0.5);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.powder_snow.fall")), SoundSource.NEUTRAL, 2, (float) 0.5, false);
			}
		}
		TooMuchBossesMod.queueServerWork(Mth.nextInt(RandomSource.create(), 120, 180), () -> {
			if (TooMuchBossesModBlocks.WARLOCKS_SNOW.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
				world.destroyBlock(BlockPos.containing(x, y, z), false);
			}
		});
	}
}

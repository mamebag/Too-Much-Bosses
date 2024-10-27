
package net.mcreator.toomuchbosses.block;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;

import net.mcreator.toomuchbosses.procedures.WarlocksTowerIceBlockAddedProcedure;

public class WarlocksTowerIceBlock extends Block {
	public WarlocksTowerIceBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.GLASS).strength(1f, 10f));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
		super.onPlace(blockstate, world, pos, oldState, moving);
		WarlocksTowerIceBlockAddedProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}
}

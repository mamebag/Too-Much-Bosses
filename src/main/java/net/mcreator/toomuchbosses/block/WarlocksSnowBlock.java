
package net.mcreator.toomuchbosses.block;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.toomuchbosses.procedures.WarlocksSnowEntityCollidesInTheBlockProcedure;
import net.mcreator.toomuchbosses.procedures.WarlocksSnowBlockAddedProcedure;

public class WarlocksSnowBlock extends FallingBlock {
	public WarlocksSnowBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.SNOW).strength(1f, 10f).noCollission());
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
		super.onPlace(blockstate, world, pos, oldState, moving);
		WarlocksSnowBlockAddedProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}

	@Override
	public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
		super.entityInside(blockstate, world, pos, entity);
		WarlocksSnowEntityCollidesInTheBlockProcedure.execute(entity);
	}
}

/**
 * The code of this mod element is always locked.
 *
 * You can register new events in this class too.
 *
 * If you want to make a plain independent class, create it using
 * Project Browser -> New... and make sure to make the class
 * outside net.mcreator.toomuchbosses as this package is managed by MCreator.
 *
 * If you change workspace package, modid or prefix, you will need
 * to manually adapt this file to these changes or remake it.
 *
 * This class will be added in the mod root package.
*/
package net.mcreator.toomuchbosses;

import net.minecraft.util.Mth;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;


@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CrackBlockEffect {
	public static void Crack(Entity entity, int crackLevel, double posX, double posY, double posZ, int duration) {
		BlockPos _bp = new BlockPos(((int)posX), ((int)posY) - 1, ((int)posZ));
			entity.level().destroyBlockProgress(entity.getId(), _bp, crackLevel);
			TooMuchBossesMod.queueServerWork(duration, () -> {
			if (!entity.level().isClientSide()){
					entity.level().destroyBlockProgress(entity.getId(), _bp, -1);
					if ((entity.level()) instanceof ServerLevel _level){
						int i = Mth.floor(posX);
      					int j = Mth.floor(posY - (double)1.0F);
       					int k = Mth.floor(posZ);
        				BlockPos pos = new BlockPos(i, j, k);
     		  	 		BlockState blockstate = entity.level().getBlockState(pos);
						_level.sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, blockstate).setPos(pos), posX, posY, posZ, 20, 0.5, 0.1, 0.5, 0);
				}
			}
		});		
	}

}


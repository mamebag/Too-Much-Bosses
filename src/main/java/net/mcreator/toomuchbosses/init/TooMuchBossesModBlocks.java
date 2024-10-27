
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.toomuchbosses.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.toomuchbosses.block.WarlocksTowerIceBlock;
import net.mcreator.toomuchbosses.block.WarlocksSnowBlock;
import net.mcreator.toomuchbosses.block.WarlocksIceBlock;
import net.mcreator.toomuchbosses.TooMuchBossesMod;

public class TooMuchBossesModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, TooMuchBossesMod.MODID);
	public static final RegistryObject<Block> WARLOCKS_ICE = REGISTRY.register("warlocks_ice", () -> new WarlocksIceBlock());
	public static final RegistryObject<Block> WARLOCKS_TOWER_ICE = REGISTRY.register("warlocks_tower_ice", () -> new WarlocksTowerIceBlock());
	public static final RegistryObject<Block> WARLOCKS_SNOW = REGISTRY.register("warlocks_snow", () -> new WarlocksSnowBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}

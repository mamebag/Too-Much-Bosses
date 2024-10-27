
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.toomuchbosses.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.toomuchbosses.item.IcePotionItem;
import net.mcreator.toomuchbosses.TooMuchBossesMod;

public class TooMuchBossesModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, TooMuchBossesMod.MODID);
	public static final RegistryObject<Item> PAKURI_SPAWN_EGG = REGISTRY.register("pakuri_spawn_egg", () -> new ForgeSpawnEggItem(TooMuchBossesModEntities.PAKURI, -1, -1, new Item.Properties()));
	public static final RegistryObject<Item> BASALT_GUARDIAN_SPAWN_EGG = REGISTRY.register("basalt_guardian_spawn_egg", () -> new ForgeSpawnEggItem(TooMuchBossesModEntities.BASALT_GUARDIAN, -13421773, -6710887, new Item.Properties()));
	public static final RegistryObject<Item> SPITTER_SPAWN_EGG = REGISTRY.register("spitter_spawn_egg", () -> new ForgeSpawnEggItem(TooMuchBossesModEntities.SPITTER, -1, -1, new Item.Properties()));
	public static final RegistryObject<Item> WITHERED_SCOUT_SPAWN_EGG = REGISTRY.register("withered_scout_spawn_egg", () -> new ForgeSpawnEggItem(TooMuchBossesModEntities.WITHERED_SCOUT, -3355444, -13421773, new Item.Properties()));
	public static final RegistryObject<Item> BASALT_TURRET_SPAWN_EGG = REGISTRY.register("basalt_turret_spawn_egg", () -> new ForgeSpawnEggItem(TooMuchBossesModEntities.BASALT_TURRET, -6710887, -256, new Item.Properties()));
	public static final RegistryObject<Item> MOGI_PLAYER_SPAWN_EGG = REGISTRY.register("mogi_player_spawn_egg", () -> new ForgeSpawnEggItem(TooMuchBossesModEntities.MOGI_PLAYER, -16724737, -10079488, new Item.Properties()));
	public static final RegistryObject<Item> FROZEN_WARLOCK_SPAWN_EGG = REGISTRY.register("frozen_warlock_spawn_egg", () -> new ForgeSpawnEggItem(TooMuchBossesModEntities.FROZEN_WARLOCK, -13369345, -13421773, new Item.Properties()));
	public static final RegistryObject<Item> WARLOCKS_ICE = block(TooMuchBossesModBlocks.WARLOCKS_ICE);
	public static final RegistryObject<Item> WARLOCKS_TOWER_ICE = block(TooMuchBossesModBlocks.WARLOCKS_TOWER_ICE);
	public static final RegistryObject<Item> MAYHEM_MAKER_SPAWN_EGG = REGISTRY.register("mayhem_maker_spawn_egg", () -> new ForgeSpawnEggItem(TooMuchBossesModEntities.MAYHEM_MAKER, -205, -6684673, new Item.Properties()));
	public static final RegistryObject<Item> ICE_POTION = REGISTRY.register("ice_potion", () -> new IcePotionItem());
	public static final RegistryObject<Item> WARLOCKS_SNOW = block(TooMuchBossesModBlocks.WARLOCKS_SNOW);
	public static final RegistryObject<Item> ICEPOOF_MAKER_SPAWN_EGG = REGISTRY.register("icepoof_maker_spawn_egg", () -> new ForgeSpawnEggItem(TooMuchBossesModEntities.ICEPOOF_MAKER, -1, -1, new Item.Properties()));

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}

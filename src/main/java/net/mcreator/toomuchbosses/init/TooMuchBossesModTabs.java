
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.toomuchbosses.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.toomuchbosses.TooMuchBossesMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TooMuchBossesModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TooMuchBossesMod.MODID);
	public static final RegistryObject<CreativeModeTab> TOO_MUCH_BOSSES_TAB = REGISTRY.register("too_much_bosses_tab",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.too_much_bosses.too_much_bosses_tab")).icon(() -> new ItemStack(Items.DIAMOND_SWORD)).displayItems((parameters, tabData) -> {
				tabData.accept(TooMuchBossesModItems.BASALT_GUARDIAN_SPAWN_EGG.get());
				tabData.accept(TooMuchBossesModItems.SPITTER_SPAWN_EGG.get());
				tabData.accept(TooMuchBossesModItems.WITHERED_SCOUT_SPAWN_EGG.get());
				tabData.accept(TooMuchBossesModItems.BASALT_TURRET_SPAWN_EGG.get());
				tabData.accept(TooMuchBossesModItems.MOGI_PLAYER_SPAWN_EGG.get());
				tabData.accept(TooMuchBossesModItems.FROZEN_WARLOCK_SPAWN_EGG.get());
				tabData.accept(TooMuchBossesModBlocks.WARLOCKS_ICE.get().asItem());
				tabData.accept(TooMuchBossesModItems.MAYHEM_MAKER_SPAWN_EGG.get());
				tabData.accept(TooMuchBossesModBlocks.WARLOCKS_SNOW.get().asItem());
			})

					.build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			tabData.accept(TooMuchBossesModItems.PAKURI_SPAWN_EGG.get());
		}
	}
}

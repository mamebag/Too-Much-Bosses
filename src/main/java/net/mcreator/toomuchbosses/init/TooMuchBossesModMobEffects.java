
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.toomuchbosses.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.toomuchbosses.potion.NumbMobEffect;
import net.mcreator.toomuchbosses.potion.EverfrostpotionMobEffect;
import net.mcreator.toomuchbosses.TooMuchBossesMod;

public class TooMuchBossesModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, TooMuchBossesMod.MODID);
	public static final RegistryObject<MobEffect> NUMB = REGISTRY.register("numb", () -> new NumbMobEffect());
	public static final RegistryObject<MobEffect> EVERFROSTPOTION = REGISTRY.register("everfrostpotion", () -> new EverfrostpotionMobEffect());
}


/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.toomuchbosses.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.toomuchbosses.TooMuchBossesMod;

public class TooMuchBossesModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, TooMuchBossesMod.MODID);
	public static final RegistryObject<SoundEvent> BASALT_GUARDIAN_INSERT = REGISTRY.register("basalt_guardian.insert", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("too_much_bosses", "basalt_guardian.insert")));
	public static final RegistryObject<SoundEvent> ICE_PRESS = REGISTRY.register("ice_press", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("too_much_bosses", "ice_press")));
}

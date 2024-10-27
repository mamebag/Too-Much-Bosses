
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.toomuchbosses.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.mcreator.toomuchbosses.TooMuchBossesMod;

public class TooMuchBossesModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, TooMuchBossesMod.MODID);
	public static final RegistryObject<SimpleParticleType> GLOWSTONE_CHARGE = REGISTRY.register("glowstone_charge", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> EVERFROST = REGISTRY.register("everfrost", () -> new SimpleParticleType(false));
}

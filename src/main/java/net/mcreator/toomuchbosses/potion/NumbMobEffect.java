
package net.mcreator.toomuchbosses.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.toomuchbosses.procedures.NumbOnEffectActiveTickProcedure;

public class NumbMobEffect extends MobEffect {
	public NumbMobEffect() {
		super(MobEffectCategory.HARMFUL, -205);
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		NumbOnEffectActiveTickProcedure.execute(entity.level(), entity);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		NumbOnEffectActiveTickProcedure.execute(entity.level(), entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		NumbOnEffectActiveTickProcedure.execute(entity.level(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}

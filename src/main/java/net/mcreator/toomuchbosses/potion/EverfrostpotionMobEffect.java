
package net.mcreator.toomuchbosses.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.toomuchbosses.procedures.EverfrostpotionOnEffectActiveTickProcedure;

public class EverfrostpotionMobEffect extends MobEffect {
	public EverfrostpotionMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -3342337);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		EverfrostpotionOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}

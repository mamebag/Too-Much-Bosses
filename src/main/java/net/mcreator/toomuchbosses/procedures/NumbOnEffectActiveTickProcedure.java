package net.mcreator.toomuchbosses.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.toomuchbosses.init.TooMuchBossesModMobEffects;

public class NumbOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		boolean particleY = false;
		double particleX = 0;
		double particleZ = 0;
		if (entity instanceof Mob) {
			((Mob) entity).setTarget(null);
		}
		if (entity instanceof Player) {
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem(), 20);
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem(), 20);
		}
		if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TooMuchBossesModMobEffects.NUMB.get()) ? _livEnt.getEffect(TooMuchBossesModMobEffects.NUMB.get()).getDuration() : 0) < 40) {
			entity.setDeltaMovement(new Vec3(0, (entity.getDeltaMovement().y()), 0));
		}
		if ((entity.tickCount % 10) == 0) {
			for (int index0 = 0; index0 < 20; index0++) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.CRIT, (entity.getX() + (entity.getBbWidth() / Mth.nextDouble(RandomSource.create(), 1.111, 9.999)) * Mth.nextInt(RandomSource.create(), -1, 1)),
							(entity.getY() + (entity.getBbHeight() / Mth.nextDouble(RandomSource.create(), 1.111, 9.999)) * Mth.nextInt(RandomSource.create(), -1, 1)),
							(entity.getZ() + (entity.getBbWidth() / Mth.nextDouble(RandomSource.create(), 1.111, 9.999)) * Mth.nextInt(RandomSource.create(), -1, 1)), 1, 0, 0, 0, 0);
			}
		}
	}
}

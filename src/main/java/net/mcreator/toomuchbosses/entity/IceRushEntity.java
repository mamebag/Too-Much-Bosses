
package net.mcreator.toomuchbosses.entity;

import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;

import net.mcreator.toomuchbosses.procedures.IcelastProcedure;
import net.mcreator.toomuchbosses.procedures.IceRushWhileProjectileFlyingTickProcedure;
import net.mcreator.toomuchbosses.init.TooMuchBossesModEntities;

import java.util.List;
import java.util.Comparator;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class IceRushEntity extends AbstractArrow implements ItemSupplier {
	public double theta;
	public double degvec;
	//public Vec3 dest = new Vec3(0, 0, 0);
	public double destX;
	public double destY;
	public double destZ;
	public static final ItemStack PROJECTILE_ITEM = new ItemStack(Blocks.AIR);

	public IceRushEntity(PlayMessages.SpawnEntity packet, Level world) {
		super(TooMuchBossesModEntities.ICE_RUSH.get(), world);
	}

	public IceRushEntity(EntityType<? extends IceRushEntity> type, Level world) {
		super(type, world);
	}

	public IceRushEntity(EntityType<? extends IceRushEntity> type, double x, double y, double z, Level world) {
		super(type, x, y, z, world);
	}

	public IceRushEntity(EntityType<? extends IceRushEntity> type, LivingEntity entity, Level world) {
		super(type, entity, world);
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public ItemStack getItem() {
		return PROJECTILE_ITEM;
	}

	@Override
	protected ItemStack getPickupItem() {
		return PROJECTILE_ITEM;
	}

	@Override
	protected void doPostHurtEffects(LivingEntity entity) {
		super.doPostHurtEffects(entity);
		entity.setArrowCount(entity.getArrowCount() - 1);
	}

	@Override
	public void playerTouch(Player entity) {
		super.playerTouch(entity);
		IcelastProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
	}

	@Override
	public void onHitEntity(EntityHitResult entityHitResult) {
		super.onHitEntity(entityHitResult);
		IcelastProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
	}

	@Override
	public void tick() {
		super.tick();
		Level world = this.level();
		IceRushWhileProjectileFlyingTickProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this.getOwner(), this);
		//if (this.getOwner() != null) {
		/*Mob owner = null;
		{
			final Vec3 _center = new Vec3(this.getX(), this.getY(), this.getZ());
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof FrozenWarlockEntity) {
					owner = (Mob) entityiterator;
				}
			}
		}
		if (owner != null) {
			if ((owner.getTarget()) != null) {
				LivingEntity entityL = (LivingEntity) (owner.getTarget());
				if (this.tickCount <= 2) {
					this.destX = entityL.getX();
					this.destX = entityL.getY();
					this.destX = entityL.getZ();
					this.theta = Mth.nextDouble(RandomSource.create(), 0, 359);
				}
				this.degvec = this.tickCount / 5;
				this.theta += this.degvec;
				if (this.tickCount < 60) {
					this.homing(this.destX + (10 - (this.tickCount * 0.16)) * ((double) (Mth.sin((float) (this.theta)))), 
					this.destY + (10 - (this.tickCount * 0.16)) * ((double) (Mth.cos((float) (this.theta)))),
					this.destZ + (10 - (this.tickCount * 0.16)) * ((double) (Mth.cos((float) (this.theta)))),
					5 - (this.tickCount * 0.08));
				}
			}
		}:/
		//}
		/*if (this.inGround)
			this.discard();
		*/
	}

	public void homing(double adestX, double adestY, double adestZ, double amplifier) {
		double dis = 0;
		dis = Math.sqrt(Math.pow(adestX - this.getX(), 2) + Math.pow(adestY - this.getY(), 2) + Math.pow(adestZ - this.getZ(), 2));
		this.setDeltaMovement(new Vec3((((adestX - this.getX()) / dis) * amplifier), (((adestY - this.getY()) / dis) * amplifier), (((adestX - this.getZ()) / dis) * amplifier)));
	}

	public static IceRushEntity shoot(Level world, LivingEntity entity, RandomSource source) {
		return shoot(world, entity, source, 1f, 0, 0);
	}

	public static IceRushEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {
		IceRushEntity entityarrow = new IceRushEntity(TooMuchBossesModEntities.ICE_RUSH.get(), entity, world);
		entityarrow.shoot(entity.getViewVector(1).x, entity.getViewVector(1).y, entity.getViewVector(1).z, power * 2, 0);
		entityarrow.setSilent(true);
		entityarrow.setCritArrow(false);
		entityarrow.setBaseDamage(damage);
		entityarrow.setKnockback(knockback);
		world.addFreshEntity(entityarrow);
		return entityarrow;
	}

	public static IceRushEntity shoot(LivingEntity entity, LivingEntity target) {
		IceRushEntity entityarrow = new IceRushEntity(TooMuchBossesModEntities.ICE_RUSH.get(), entity, entity.level());
		double dx = target.getX() - entity.getX();
		double dy = target.getY() + target.getEyeHeight() - 1.1;
		double dz = target.getZ() - entity.getZ();
		entityarrow.shoot(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * 0.2F, dz, 0f * 2, 12.0F);
		entityarrow.setSilent(true);
		entityarrow.setBaseDamage(0);
		entityarrow.setKnockback(0);
		entityarrow.setCritArrow(false);
		entity.level().addFreshEntity(entityarrow);
		return entityarrow;
	}
}

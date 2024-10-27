
package net.mcreator.toomuchbosses.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;


import net.mcreator.toomuchbosses.init.TooMuchBossesModEntities;
import net.mcreator.toomuchbosses.network.TooMuchBossesModVariables;

public class GlowstonebeamEntity extends Monster {
	public GlowstonebeamEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(TooMuchBossesModEntities.GLOWSTONEBEAM.get(), world);
	}

	public GlowstonebeamEntity(EntityType<GlowstonebeamEntity> type, Level world) {
		super(type, world);
		//maxUpStep = 0f;
		xpReward = 0;
		setNoAi(false);
	}
	
	public void tick(){
		Level world = this.level();
			if(this.isAlive() == true){
			TooMuchBossesModVariables.MapVariables.get(world).shootX = this.getX();
			TooMuchBossesModVariables.MapVariables.get(world).shootY = this.getY();
			TooMuchBossesModVariables.MapVariables.get(world).shootZ = this.getZ();
			TooMuchBossesModVariables.MapVariables.get(world).syncData(world);
			}
		if(this.tickCount > 1){
			this.discard();
		}
	}
	
	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}


	@Override
	protected void registerGoals() {
		super.registerGoals();

	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	@Override
	public double getMyRidingOffset() {
		return -0.35D;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
	}

	@Override
	public boolean hurt(DamageSource source, float amount) {
		return false;
	}

	public static void init() {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0);
		builder = builder.add(Attributes.MAX_HEALTH, 1);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 0);
		builder = builder.add(Attributes.FOLLOW_RANGE, 0);
		return builder;
	}
}

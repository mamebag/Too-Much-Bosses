
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.toomuchbosses.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.toomuchbosses.entity.WitheredScoutEntity;
import net.mcreator.toomuchbosses.entity.WaterPotionEntity;
import net.mcreator.toomuchbosses.entity.TheBossCloneEntity;
import net.mcreator.toomuchbosses.entity.TNTbarrageProjectileEntity;
import net.mcreator.toomuchbosses.entity.SpitterEntity;
import net.mcreator.toomuchbosses.entity.PakuriEntity;
import net.mcreator.toomuchbosses.entity.MogiPlayerEntity;
import net.mcreator.toomuchbosses.entity.MayhemMakerEntity;
import net.mcreator.toomuchbosses.entity.IcerushthemostEntity;
import net.mcreator.toomuchbosses.entity.IcepoofMakerEntity;
import net.mcreator.toomuchbosses.entity.IceWallFrontShootEntity;
import net.mcreator.toomuchbosses.entity.IceWallFrontEntity;
import net.mcreator.toomuchbosses.entity.IceWallFrontBiggerEntity;
import net.mcreator.toomuchbosses.entity.IceTrapShootEntity;
import net.mcreator.toomuchbosses.entity.IceRushEntity;
import net.mcreator.toomuchbosses.entity.IceProjectileEntity;
import net.mcreator.toomuchbosses.entity.IcePikesEntity;
import net.mcreator.toomuchbosses.entity.GrowlEffectEntity;
import net.mcreator.toomuchbosses.entity.GlowstonebeamEntity;
import net.mcreator.toomuchbosses.entity.FrozenWarlockEntity;
import net.mcreator.toomuchbosses.entity.BigTNTProjectileEntity;
import net.mcreator.toomuchbosses.entity.BasaltTurretEntity;
import net.mcreator.toomuchbosses.entity.BasaltGuardianEntity;
import net.mcreator.toomuchbosses.entity.BGTrapEntityEntity;
import net.mcreator.toomuchbosses.entity.BGPoofEntityEntity;
import net.mcreator.toomuchbosses.entity.BGPillarEntityEntity;
import net.mcreator.toomuchbosses.entity.BGFlameEntityEntity;
import net.mcreator.toomuchbosses.entity.BGEarthQuakeEntityEntity;
import net.mcreator.toomuchbosses.entity.BGCrackEntityEntity;
import net.mcreator.toomuchbosses.TooMuchBossesMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TooMuchBossesModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, TooMuchBossesMod.MODID);
	public static final RegistryObject<EntityType<PakuriEntity>> PAKURI = register("pakuri",
			EntityType.Builder.<PakuriEntity>of(PakuriEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PakuriEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<BasaltGuardianEntity>> BASALT_GUARDIAN = register("basalt_guardian", EntityType.Builder.<BasaltGuardianEntity>of(BasaltGuardianEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BasaltGuardianEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<GrowlEffectEntity>> GROWL_EFFECT = register("growl_effect",
			EntityType.Builder.<GrowlEffectEntity>of(GrowlEffectEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(GrowlEffectEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<BGTrapEntityEntity>> BG_TRAP_ENTITY = register("bg_trap_entity",
			EntityType.Builder.<BGTrapEntityEntity>of(BGTrapEntityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BGTrapEntityEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<BGFlameEntityEntity>> BG_FLAME_ENTITY = register("bg_flame_entity",
			EntityType.Builder.<BGFlameEntityEntity>of(BGFlameEntityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BGFlameEntityEntity::new)

					.sized(1f, 1f));
	public static final RegistryObject<EntityType<BGPillarEntityEntity>> BG_PILLAR_ENTITY = register("bg_pillar_entity",
			EntityType.Builder.<BGPillarEntityEntity>of(BGPillarEntityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BGPillarEntityEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<BGPoofEntityEntity>> BG_POOF_ENTITY = register("bg_poof_entity",
			EntityType.Builder.<BGPoofEntityEntity>of(BGPoofEntityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BGPoofEntityEntity::new)

					.sized(1f, 1f));
	public static final RegistryObject<EntityType<BGEarthQuakeEntityEntity>> BG_EARTH_QUAKE_ENTITY = register("bg_earth_quake_entity",
			EntityType.Builder.<BGEarthQuakeEntityEntity>of(BGEarthQuakeEntityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BGEarthQuakeEntityEntity::new)

					.sized(0.2f, 0.2f));
	public static final RegistryObject<EntityType<SpitterEntity>> SPITTER = register("spitter",
			EntityType.Builder.<SpitterEntity>of(SpitterEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SpitterEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<TheBossCloneEntity>> THE_BOSS_CLONE = register("the_boss_clone", EntityType.Builder.<TheBossCloneEntity>of(TheBossCloneEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(TheBossCloneEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<BGCrackEntityEntity>> BG_CRACK_ENTITY = register("bg_crack_entity",
			EntityType.Builder.<BGCrackEntityEntity>of(BGCrackEntityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BGCrackEntityEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<WitheredScoutEntity>> WITHERED_SCOUT = register("withered_scout", EntityType.Builder.<WitheredScoutEntity>of(WitheredScoutEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(WitheredScoutEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<BasaltTurretEntity>> BASALT_TURRET = register("basalt_turret", EntityType.Builder.<BasaltTurretEntity>of(BasaltTurretEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BasaltTurretEntity::new).fireImmune().sized(1.5f, 1.5f));
	public static final RegistryObject<EntityType<GlowstonebeamEntity>> GLOWSTONEBEAM = register("glowstonebeam",
			EntityType.Builder.<GlowstonebeamEntity>of(GlowstonebeamEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(0).setUpdateInterval(3).setCustomClientFactory(GlowstonebeamEntity::new)

					.sized(0.01f, 0.01f));
	public static final RegistryObject<EntityType<MogiPlayerEntity>> MOGI_PLAYER = register("mogi_player",
			EntityType.Builder.<MogiPlayerEntity>of(MogiPlayerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MogiPlayerEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<TNTbarrageProjectileEntity>> TN_TBARRAGE_PROJECTILE = register("tn_tbarrage_projectile", EntityType.Builder.<TNTbarrageProjectileEntity>of(TNTbarrageProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(TNTbarrageProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<BigTNTProjectileEntity>> BIG_TNT_PROJECTILE = register("big_tnt_projectile", EntityType.Builder.<BigTNTProjectileEntity>of(BigTNTProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(BigTNTProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<FrozenWarlockEntity>> FROZEN_WARLOCK = register("frozen_warlock",
			EntityType.Builder.<FrozenWarlockEntity>of(FrozenWarlockEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(FrozenWarlockEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<IceWallFrontEntity>> ICE_WALL_FRONT = register("ice_wall_front",
			EntityType.Builder.<IceWallFrontEntity>of(IceWallFrontEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(IceWallFrontEntity::new)

					.sized(0.1f, 0.1f));
	public static final RegistryObject<EntityType<IceWallFrontShootEntity>> ICE_WALL_FRONT_SHOOT = register("ice_wall_front_shoot", EntityType.Builder.<IceWallFrontShootEntity>of(IceWallFrontShootEntity::new, MobCategory.MISC)
			.setCustomClientFactory(IceWallFrontShootEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<IceWallFrontBiggerEntity>> ICE_WALL_FRONT_BIGGER = register("ice_wall_front_bigger", EntityType.Builder.<IceWallFrontBiggerEntity>of(IceWallFrontBiggerEntity::new, MobCategory.MISC)
			.setCustomClientFactory(IceWallFrontBiggerEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<IceTrapShootEntity>> ICE_TRAP_SHOOT = register("ice_trap_shoot",
			EntityType.Builder.<IceTrapShootEntity>of(IceTrapShootEntity::new, MobCategory.MISC).setCustomClientFactory(IceTrapShootEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<MayhemMakerEntity>> MAYHEM_MAKER = register("mayhem_maker", EntityType.Builder.<MayhemMakerEntity>of(MayhemMakerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MayhemMakerEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<IcePikesEntity>> ICE_PIKES = register("ice_pikes",
			EntityType.Builder.<IcePikesEntity>of(IcePikesEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(IcePikesEntity::new)

					.sized(3f, 3f));
	public static final RegistryObject<EntityType<WaterPotionEntity>> WATER_POTION = register("water_potion",
			EntityType.Builder.<WaterPotionEntity>of(WaterPotionEntity::new, MobCategory.MISC).setCustomClientFactory(WaterPotionEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<IcepoofMakerEntity>> ICEPOOF_MAKER = register("icepoof_maker",
			EntityType.Builder.<IcepoofMakerEntity>of(IcepoofMakerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(IcepoofMakerEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<IceRushEntity>> ICE_RUSH = register("ice_rush",
			EntityType.Builder.<IceRushEntity>of(IceRushEntity::new, MobCategory.MISC).setCustomClientFactory(IceRushEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<IcerushthemostEntity>> ICERUSHTHEMOST = register("icerushthemost",
			EntityType.Builder.<IcerushthemostEntity>of(IcerushthemostEntity::new, MobCategory.MISC).setCustomClientFactory(IcerushthemostEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<IceProjectileEntity>> ICE_PROJECTILE = register("ice_projectile",
			EntityType.Builder.<IceProjectileEntity>of(IceProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(IceProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			PakuriEntity.init();
			BasaltGuardianEntity.init();
			GrowlEffectEntity.init();
			BGTrapEntityEntity.init();
			BGFlameEntityEntity.init();
			BGPillarEntityEntity.init();
			BGPoofEntityEntity.init();
			BGEarthQuakeEntityEntity.init();
			SpitterEntity.init();
			TheBossCloneEntity.init();
			BGCrackEntityEntity.init();
			WitheredScoutEntity.init();
			BasaltTurretEntity.init();
			GlowstonebeamEntity.init();
			MogiPlayerEntity.init();
			FrozenWarlockEntity.init();
			IceWallFrontEntity.init();
			MayhemMakerEntity.init();
			IcePikesEntity.init();
			IcepoofMakerEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(PAKURI.get(), PakuriEntity.createAttributes().build());
		event.put(BASALT_GUARDIAN.get(), BasaltGuardianEntity.createAttributes().build());
		event.put(GROWL_EFFECT.get(), GrowlEffectEntity.createAttributes().build());
		event.put(BG_TRAP_ENTITY.get(), BGTrapEntityEntity.createAttributes().build());
		event.put(BG_FLAME_ENTITY.get(), BGFlameEntityEntity.createAttributes().build());
		event.put(BG_PILLAR_ENTITY.get(), BGPillarEntityEntity.createAttributes().build());
		event.put(BG_POOF_ENTITY.get(), BGPoofEntityEntity.createAttributes().build());
		event.put(BG_EARTH_QUAKE_ENTITY.get(), BGEarthQuakeEntityEntity.createAttributes().build());
		event.put(SPITTER.get(), SpitterEntity.createAttributes().build());
		event.put(THE_BOSS_CLONE.get(), TheBossCloneEntity.createAttributes().build());
		event.put(BG_CRACK_ENTITY.get(), BGCrackEntityEntity.createAttributes().build());
		event.put(WITHERED_SCOUT.get(), WitheredScoutEntity.createAttributes().build());
		event.put(BASALT_TURRET.get(), BasaltTurretEntity.createAttributes().build());
		event.put(GLOWSTONEBEAM.get(), GlowstonebeamEntity.createAttributes().build());
		event.put(MOGI_PLAYER.get(), MogiPlayerEntity.createAttributes().build());
		event.put(FROZEN_WARLOCK.get(), FrozenWarlockEntity.createAttributes().build());
		event.put(ICE_WALL_FRONT.get(), IceWallFrontEntity.createAttributes().build());
		event.put(MAYHEM_MAKER.get(), MayhemMakerEntity.createAttributes().build());
		event.put(ICE_PIKES.get(), IcePikesEntity.createAttributes().build());
		event.put(ICEPOOF_MAKER.get(), IcepoofMakerEntity.createAttributes().build());
	}
}

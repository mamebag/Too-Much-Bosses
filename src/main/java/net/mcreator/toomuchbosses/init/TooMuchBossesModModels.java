
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.toomuchbosses.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.toomuchbosses.client.model.Modelwithered_scout;
import net.mcreator.toomuchbosses.client.model.Modelwarden_no_pakuri;
import net.mcreator.toomuchbosses.client.model.Modelsample_block;
import net.mcreator.toomuchbosses.client.model.Modelherobrine;
import net.mcreator.toomuchbosses.client.model.Modelgrowl_effect;
import net.mcreator.toomuchbosses.client.model.Modelfrozen_warlock;
import net.mcreator.toomuchbosses.client.model.Modelbedrock_trap;
import net.mcreator.toomuchbosses.client.model.Modelbedrock_rain;
import net.mcreator.toomuchbosses.client.model.Modelbasalt_pillar;
import net.mcreator.toomuchbosses.client.model.Modelbasalt_guardian;
import net.mcreator.toomuchbosses.client.model.ModelTheBoss;
import net.mcreator.toomuchbosses.client.model.ModelPumpkin_Scarecrow;
import net.mcreator.toomuchbosses.client.model.ModelIceSpikes;
import net.mcreator.toomuchbosses.client.model.ModelBipedSample;
import net.mcreator.toomuchbosses.client.model.ModelBasalt_Turret;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class TooMuchBossesModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ModelIceSpikes.LAYER_LOCATION, ModelIceSpikes::createBodyLayer);
		event.registerLayerDefinition(Modelwarden_no_pakuri.LAYER_LOCATION, Modelwarden_no_pakuri::createBodyLayer);
		event.registerLayerDefinition(ModelTheBoss.LAYER_LOCATION, ModelTheBoss::createBodyLayer);
		event.registerLayerDefinition(Modelfrozen_warlock.LAYER_LOCATION, Modelfrozen_warlock::createBodyLayer);
		event.registerLayerDefinition(Modelsample_block.LAYER_LOCATION, Modelsample_block::createBodyLayer);
		event.registerLayerDefinition(ModelPumpkin_Scarecrow.LAYER_LOCATION, ModelPumpkin_Scarecrow::createBodyLayer);
		event.registerLayerDefinition(Modelwithered_scout.LAYER_LOCATION, Modelwithered_scout::createBodyLayer);
		event.registerLayerDefinition(ModelBasalt_Turret.LAYER_LOCATION, ModelBasalt_Turret::createBodyLayer);
		event.registerLayerDefinition(Modelbasalt_guardian.LAYER_LOCATION, Modelbasalt_guardian::createBodyLayer);
		event.registerLayerDefinition(Modelbedrock_trap.LAYER_LOCATION, Modelbedrock_trap::createBodyLayer);
		event.registerLayerDefinition(Modelherobrine.LAYER_LOCATION, Modelherobrine::createBodyLayer);
		event.registerLayerDefinition(Modelbasalt_pillar.LAYER_LOCATION, Modelbasalt_pillar::createBodyLayer);
		event.registerLayerDefinition(Modelbedrock_rain.LAYER_LOCATION, Modelbedrock_rain::createBodyLayer);
		event.registerLayerDefinition(ModelBipedSample.LAYER_LOCATION, ModelBipedSample::createBodyLayer);
		event.registerLayerDefinition(Modelgrowl_effect.LAYER_LOCATION, Modelgrowl_effect::createBodyLayer);
	}
}

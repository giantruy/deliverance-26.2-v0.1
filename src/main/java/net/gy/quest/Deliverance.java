package net.gy.quest;

import net.fabricmc.api.ModInitializer;

import net.gy.quest.block.ModBlocks;
import net.gy.quest.creativemodetab.ModCreativeModeTabs;
import net.gy.quest.effect.ModEffects;
import net.gy.quest.item.ModItems;
import net.gy.quest.world.ModWorldPlacedFeatures;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Deliverance implements ModInitializer {
	public static final String MOD_ID = "quest";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);



	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
		ModItems.registerModItems();
		ModCreativeModeTabs.registerModCreativeModeTabs();
		ModBlocks.registerModBlocks();
		ModWorldPlacedFeatures.registerModWorldPlacedFeatures();
		ModEffects.registerModEffects();
	}
}
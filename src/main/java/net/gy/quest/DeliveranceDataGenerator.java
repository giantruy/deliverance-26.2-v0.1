package net.gy.quest;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.gy.quest.datagen.*;
import net.gy.quest.world.ModWorldConfiguredFeatures;
import net.gy.quest.world.ModWorldPlacedFeatures;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

public class DeliveranceDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		var pack = fabricDataGenerator.createPack();

		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModBlockTagsProvider::new);
		pack.addProvider(ModBlockLootTableProvider::new);
		pack.addProvider(ModWorldgenProvider::new);
		pack.addProvider(ModRecipeProvider::new);
		pack.addProvider(ModChestLootTableProvider::new);
	}

	@Override
	public void buildRegistry(RegistrySetBuilder registryBuilder) {
		registryBuilder.add(Registries.CONFIGURED_FEATURE, ModWorldConfiguredFeatures::configure);
		registryBuilder.add(Registries.PLACED_FEATURE, ModWorldPlacedFeatures::configure);
	}

}

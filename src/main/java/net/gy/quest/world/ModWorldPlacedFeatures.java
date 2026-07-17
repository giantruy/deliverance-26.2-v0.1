package net.gy.quest.world;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.gy.quest.Deliverance;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.heightproviders.BiasedToBottomHeight;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModWorldPlacedFeatures {
    public static final ResourceKey<PlacedFeature> RUNESTONE_ORE_PLACED_KEY =
            ResourceKey.create(
                    Registries.PLACED_FEATURE,
                    Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, "runestone_ore_placed")
            );

    public static void configure(BootstrapContext<PlacedFeature> context) {

        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        List<PlacementModifier> runestoneOreVeinModifiers = List.of(
                CountPlacement.of(3), //counts per chunk
                BiomeFilter.biome(),
                InSquarePlacement.spread(),
                HeightRangePlacement.of(BiasedToBottomHeight.of(VerticalAnchor.absolute(0), VerticalAnchor.absolute(80), 3))
        );

        context.register(
                RUNESTONE_ORE_PLACED_KEY,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(ModWorldConfiguredFeatures.RUNESTONE_ORE_VEIN_KEY),
                        runestoneOreVeinModifiers
                )
        );
    }

    public static void registerModWorldPlacedFeatures() {

        Deliverance.LOGGER.info("Registering Mod World Placed Features for " + Deliverance.MOD_ID);

        BiomeModifications.addFeature(
                BiomeSelectors.foundInTheEnd(),
                GenerationStep.Decoration.UNDERGROUND_ORES,
                ModWorldPlacedFeatures.RUNESTONE_ORE_PLACED_KEY
        );
    }
}

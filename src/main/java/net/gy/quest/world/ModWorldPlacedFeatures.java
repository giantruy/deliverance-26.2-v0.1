package net.gy.quest.world;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.gy.quest.Deliverance;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
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

    public static final ResourceKey<PlacedFeature> CLASSIC_OAK_PLACED_KEY =
            ResourceKey.create(
                    Registries.PLACED_FEATURE,
                    Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, "classic_oak_placed")
            );

    public static final ResourceKey<PlacedFeature> CLASSIC_OAK_LEAFLESS_PLACED_KEY =
            ResourceKey.create(
                    Registries.PLACED_FEATURE,
                    Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, "classic_oak_leafless_placed")
            );

    public static final ResourceKey<PlacedFeature> CLASSIC_OAK_MIXED_PLACED_KEY =
            ResourceKey.create(
                    Registries.PLACED_FEATURE,
                    Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, "classic_oak_mixed_placed")
            );

    public static final ResourceKey<PlacedFeature> BRICK_PYRAMID_PLACED_KEY =
            ResourceKey.create(
                    Registries.PLACED_FEATURE,
                    Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, "brick_pyramid_placed")
            );

    public static final ResourceKey<PlacedFeature> CRAFTING_TABLE_PLACED_KEY =
            ResourceKey.create(
                    Registries.PLACED_FEATURE,
                    Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, "crafting_table_placed")
            );

    public static void configure(BootstrapContext<PlacedFeature> context) {

        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        List<PlacementModifier> runestoneOreVeinModifiers = List.of(
                CountPlacement.of(3),
                BiomeFilter.biome(),
                InSquarePlacement.spread(),
                HeightRangePlacement.of(BiasedToBottomHeight.of(VerticalAnchor.absolute(0), VerticalAnchor.absolute(80), 3))
        );

        List<PlacementModifier> classicOakModifiers = List.of(PlacementUtils.HEIGHTMAP);
        List<PlacementModifier> classicOakLeaflessModifiers = List.of(PlacementUtils.HEIGHTMAP);

        List<PlacementModifier> classicOakMixedModifiers = List.of(
                RarityFilter.onAverageOnceEvery(3),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP,
                BiomeFilter.biome()
        );

        context.register(
                CLASSIC_OAK_MIXED_PLACED_KEY,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(ModWorldConfiguredFeatures.CLASSIC_OAK_MIXED_KEY),
                        classicOakMixedModifiers
                )
        );

        context.register(
                RUNESTONE_ORE_PLACED_KEY,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(ModWorldConfiguredFeatures.RUNESTONE_ORE_VEIN_KEY),
                        runestoneOreVeinModifiers
                )
        );

        context.register(
                CLASSIC_OAK_PLACED_KEY,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(ModWorldConfiguredFeatures.CLASSIC_OAK_KEY),
                        classicOakModifiers
                )
        );

        context.register(
                CLASSIC_OAK_LEAFLESS_PLACED_KEY,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(ModWorldConfiguredFeatures.CLASSIC_OAK_LEAFLESS_KEY),
                        classicOakLeaflessModifiers
                        )
        );

        context.register(
                BRICK_PYRAMID_PLACED_KEY,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(ModWorldConfiguredFeatures.BRICK_PYRAMID_KEY),
                        List.of(
                                RarityFilter.onAverageOnceEvery(80),
                                InSquarePlacement.spread(),
                                PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                                BiomeFilter.biome()
                        )
                )
        );

        context.register(
                CRAFTING_TABLE_PLACED_KEY,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(ModWorldConfiguredFeatures.CRAFTING_TABLE_KEY),
                        List.of(
                                RarityFilter.onAverageOnceEvery(80),
                                InSquarePlacement.spread(),
                                PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                                BiomeFilter.biome()
                        )
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

//        BiomeModifications.addFeature(
//                BiomeSelectors.includeByKey(ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, "classic_plains"))),
//                GenerationStep.Decoration.VEGETAL_DECORATION,
//                ModWorldPlacedFeatures.CLASSIC_OAK_PLACED_KEY
//        );
//
//        BiomeModifications.addFeature(
//                BiomeSelectors.includeByKey(ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, "classic_plains"))),
//                GenerationStep.Decoration.VEGETAL_DECORATION,
//                ModWorldPlacedFeatures.CLASSIC_OAK_LEAFLESS_PLACED_KEY
//        );

        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(ResourceKey.create(Registries.BIOME,
                        Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, "classic_plains"))),
                GenerationStep.Decoration.VEGETAL_DECORATION,
                ModWorldPlacedFeatures.CLASSIC_OAK_MIXED_PLACED_KEY
        );

        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(ResourceKey.create(Registries.BIOME,
                        Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, "classic_plains"))),
                GenerationStep.Decoration.SURFACE_STRUCTURES,
                ModWorldPlacedFeatures.BRICK_PYRAMID_PLACED_KEY
        );

        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(ResourceKey.create(Registries.BIOME,
                        Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, "classic_plains"))),
                GenerationStep.Decoration.SURFACE_STRUCTURES,
                ModWorldPlacedFeatures.CRAFTING_TABLE_PLACED_KEY
        );
    }
}

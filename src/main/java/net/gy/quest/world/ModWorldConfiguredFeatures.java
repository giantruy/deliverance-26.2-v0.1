package net.gy.quest.world;

import net.gy.quest.Deliverance;
import net.gy.quest.block.ModBlocks;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import java.util.List;
import java.util.Optional;


public class ModWorldConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> RUNESTONE_ORE_VEIN_KEY =
            ResourceKey.create(
                    Registries.CONFIGURED_FEATURE,
                    Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, "runestone_ore_vein")
            );

    public static final ResourceKey<ConfiguredFeature<?, ?>> CLASSIC_OAK_KEY =
            ResourceKey.create(
                    Registries.CONFIGURED_FEATURE,
                    Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, "classic_tree")
            );

    public static final ResourceKey<ConfiguredFeature<?, ?>> CLASSIC_OAK_LEAFLESS_KEY =
            ResourceKey.create(
                    Registries.CONFIGURED_FEATURE,
                    Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, "classic_tree_leafless")
            );

    public static final ResourceKey<ConfiguredFeature<?, ?>> CLASSIC_OAK_MIXED_KEY =
            ResourceKey.create(
                    Registries.CONFIGURED_FEATURE,
                    Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, "classic_oak_mixed")
            );

    public static final ResourceKey<ConfiguredFeature<?, ?>> BRICK_PYRAMID_KEY =
            ResourceKey.create(
                    Registries.CONFIGURED_FEATURE,
                    Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, "brick_pyramid")
            );

    public static final ResourceKey<ConfiguredFeature<?, ?>> CRAFTING_TABLE_KEY =
            ResourceKey.create(
                    Registries.CONFIGURED_FEATURE,
                    Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, "crafting_table")
            );

    public static void configure(BootstrapContext<ConfiguredFeature<?, ?>> context) {

        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);

        context.register(
                CLASSIC_OAK_MIXED_KEY,
                new ConfiguredFeature<>(
                        Feature.RANDOM_SELECTOR,
                        new RandomFeatureConfiguration(
                                List.of(
                                        // 70% chance leafless, picked first
                                        new WeightedPlacedFeature(
                                                placedFeatures.getOrThrow(ModWorldPlacedFeatures.CLASSIC_OAK_LEAFLESS_PLACED_KEY),
                                                0.9f
                                        )
                                ),
                                // fallback (remaining 30%) = leaved
                                placedFeatures.getOrThrow(ModWorldPlacedFeatures.CLASSIC_OAK_PLACED_KEY)
                        )
                )
        );

        RuleTest endReplaceableRule = new BlockMatchTest(Blocks.END_STONE);
        List<OreConfiguration.TargetBlockState> runestoneOreConfig =
                List.of(
                        OreConfiguration.target(endReplaceableRule, ModBlocks.RUNESTONE_ORE.defaultBlockState())
                );

        context.register(
                RUNESTONE_ORE_VEIN_KEY,
                new ConfiguredFeature<>(
                        Feature.ORE,
                        new OreConfiguration(runestoneOreConfig, 3))
        );

        context.register(
                CLASSIC_OAK_KEY,
                new ConfiguredFeature<>(
                        Feature.TREE,
                        new TreeConfiguration.TreeConfigurationBuilder(
                                BlockStateProvider.simple(ModBlocks.CLASSIC_OAK_LOG.defaultBlockState()),
                                new StraightTrunkPlacer(4, 2, 0),
                                BlockStateProvider.simple(ModBlocks.CLASSIC_OAK_LEAVES.defaultBlockState()),
                                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                                new TwoLayersFeatureSize(1, 0, 1),
                                BlockStateProvider.simple(ModBlocks.CLASSIC_DIRT)
                        ).ignoreVines().build()
                )
        );

        context.register(
                CLASSIC_OAK_LEAFLESS_KEY,
                new ConfiguredFeature<>(
                        Feature.TREE,
                        new TreeConfiguration.TreeConfigurationBuilder(
                                BlockStateProvider.simple(ModBlocks.CLASSIC_OAK_LOG.defaultBlockState()),
                                new StraightTrunkPlacer(4, 2, 0),
                                BlockStateProvider.simple(Blocks.AIR.defaultBlockState()),
                                new BlobFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), 0),
                                new TwoLayersFeatureSize(1, 0, 0),
                                BlockStateProvider.simple(ModBlocks.CLASSIC_DIRT)
                        ).ignoreVines().build()
                )
        );

        context.register(
                BRICK_PYRAMID_KEY,
                new ConfiguredFeature<>(ModFeatures.BRICK_PYRAMID, NoneFeatureConfiguration.INSTANCE)
        );

        context.register(
                CRAFTING_TABLE_KEY,
                new ConfiguredFeature<>(ModFeatures.CRAFTING_TABLE, NoneFeatureConfiguration.INSTANCE)
        );
    }
}

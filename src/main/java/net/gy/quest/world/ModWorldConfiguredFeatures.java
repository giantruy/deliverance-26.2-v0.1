package net.gy.quest.world;

import net.gy.quest.Deliverance;
import net.gy.quest.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;

import java.util.List;

public class ModWorldConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> RUNESTONE_ORE_VEIN_KEY =
            ResourceKey.create(
                    Registries.CONFIGURED_FEATURE,
                    Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, "runestone_ore_vein")
            );

    public static void configure(BootstrapContext<ConfiguredFeature<?, ?>> context) {
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
    }
}

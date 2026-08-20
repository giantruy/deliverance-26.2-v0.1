package net.gy.quest.world;

import net.gy.quest.Deliverance;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class ModFeatures {
    public static final Feature<NoneFeatureConfiguration> BRICK_PYRAMID =
            Registry.register(
                    BuiltInRegistries.FEATURE,
                    Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, "brick_pyramid"),
                    new BrickPyramidFeature(NoneFeatureConfiguration.CODEC)
            );

    public static final Feature<NoneFeatureConfiguration> CRAFTING_TABLE =
            Registry.register(
                    BuiltInRegistries.FEATURE,
                    Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, "crafting_table"),
                    new CraftingTableFeature(NoneFeatureConfiguration.CODEC)
            );

    public static void registerModFeatures() {
        Deliverance.LOGGER.info("Registering Mod Features for " + Deliverance.MOD_ID);
    }
}

package net.gy.quest.world;

import com.mojang.serialization.Codec;
import net.gy.quest.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class BrickPyramidFeature extends Feature<NoneFeatureConfiguration> {

    public BrickPyramidFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel level = context.level();
        BlockPos origin = context.origin();
        RandomSource random = context.random();


        int[][] layers = {
                {2}, // half-width of each layer, bottom to top
                {1},
                {0}
        };

        for (int layer = 0; layer < layers.length; layer++) {
            int halfWidth = layers.length - 1 - layer;
            BlockPos layerOrigin = origin.above(layer);

            for (int x = -halfWidth; x <= halfWidth; x++) {
                for (int z = -halfWidth; z <= halfWidth; z++) {
                    BlockPos target = layerOrigin.offset(x, 0, z);
                    if (level.getBlockState(target).isAir() || level.getBlockState(target).canBeReplaced()) {
                        level.setBlock(target, ModBlocks.CLASSIC_BRICKS.defaultBlockState(), 3);
                    }
                }
            }
        }
        return true;
    }
}
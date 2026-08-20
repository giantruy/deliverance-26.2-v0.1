package net.gy.quest.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.state.BlockState;

public class ClassicGrassBlock extends GrassBlock {

    public ClassicGrassBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        BlockState above = level.getBlockState(pos.above());
        if (!above.isAir()) {
            level.setBlock(pos, ModBlocks.CLASSIC_DIRT.defaultBlockState(), 3);
            return;
        }

        for (int i = 0; i < 4; i++) {
            BlockPos target = pos.offset(
                    random.nextInt(3) - 1,
                    random.nextInt(5) - 3,
                    random.nextInt(3) - 1
            );

            BlockState targetState = level.getBlockState(target);
            if ((targetState.is(ModBlocks.CLASSIC_DIRT) || targetState.is(Blocks.DIRT))
                    && level.getBlockState(target.above()).isAir()) {
                level.setBlock(target, ModBlocks.CLASSIC_GRASS.defaultBlockState(), 3);
            }
        }
    }
}
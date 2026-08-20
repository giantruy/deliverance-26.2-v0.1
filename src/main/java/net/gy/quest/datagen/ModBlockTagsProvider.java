package net.gy.quest.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.gy.quest.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends FabricTagsProvider.BlockTagsProvider {
    public ModBlockTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.getRK(ModBlocks.ANCIENT_STONE_BRICKS))
                .add(ModBlocks.getRK(ModBlocks.RUNESTONE_ORE))
                .add(ModBlocks.getRK(ModBlocks.RUNESTONE_BLOCK))
                .add(ModBlocks.getRK(ModBlocks.POLISHED_RUNESTONE_BLOCK))
                .add(ModBlocks.getRK(ModBlocks.CLASSIC_STONE))
                .add(ModBlocks.getRK(ModBlocks.CLASSIC_COBBLESTONE))
                .add(ModBlocks.getRK(ModBlocks.CLASSIC_BRICKS))
        ;

        tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ModBlocks.getRK(ModBlocks.CLASSIC_GRASS))
                .add(ModBlocks.getRK(ModBlocks.CLASSIC_DIRT));

        tag(BlockTags.MINEABLE_WITH_HOE)
                .add(ModBlocks.getRK(ModBlocks.CLASSIC_OAK_LEAVES));

        tag(BlockTags.SHEARS_EXTREME_BREAKING_SPEED)
                .add(ModBlocks.getRK(ModBlocks.CLASSIC_OAK_LEAVES));

        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.getRK(ModBlocks.STAFFANS_CRAFTER))
                .add(ModBlocks.getRK(ModBlocks.CLASSIC_OAK_LOG))
                .add(ModBlocks.getRK(ModBlocks.CLASSIC_OAK_PLANKS))
                .add(ModBlocks.getRK(ModBlocks.CLASSIC_CRAFTING_TABLE))
                .add(ModBlocks.getRK(ModBlocks.CURSED_LECTERN))
        ;

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.getRK(ModBlocks.STAFFANS_CRAFTER))
        ;

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.getRK(ModBlocks.RUNESTONE_BLOCK))
                .add(ModBlocks.getRK(ModBlocks.POLISHED_RUNESTONE_BLOCK))
                .add(ModBlocks.getRK(ModBlocks.RUNESTONE_ORE))
        ;

        tag(BlockTags.LOGS)
                .add(ModBlocks.getRK(ModBlocks.CLASSIC_OAK_LOG))
        ;

        tag(BlockTags.DIRT)
                .add(ModBlocks.getRK(ModBlocks.CLASSIC_DIRT))
        ;

        tag(BlockTags.GRASS_BLOCKS)
                .add(ModBlocks.getRK(ModBlocks.CLASSIC_GRASS))
        ;
    }
}

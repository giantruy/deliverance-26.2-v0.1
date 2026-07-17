package net.gy.quest.datagen;

import com.jcraft.jorbis.Comment;
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
    protected  void addTags(HolderLookup.Provider registries) {
        valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.ANCIENT_STONE_BRICKS)
                .add(ModBlocks.RUNESTONE_ORE)
                .add(ModBlocks.RUNESTONE_BLOCK)
                .add(ModBlocks.POLISHED_RUNESTONE_BLOCK);

        valueLookupBuilder(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.STAFFANS_CRAFTER);

        valueLookupBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.STAFFANS_CRAFTER);

        valueLookupBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.RUNESTONE_BLOCK)
                .add(ModBlocks.POLISHED_RUNESTONE_BLOCK)
                .add(ModBlocks.RUNESTONE_ORE);
    }
}

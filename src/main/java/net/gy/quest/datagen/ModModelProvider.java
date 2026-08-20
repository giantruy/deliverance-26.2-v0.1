package net.gy.quest.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.gy.quest.block.ModBlocks;
import net.gy.quest.item.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.data.models.model.TexturedModel;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {

        TextureMapping classicGrassSnowy = new TextureMapping()
                .put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(net.minecraft.world.level.block.Blocks.DIRT))
                .copyForced(TextureSlot.BOTTOM, TextureSlot.PARTICLE)
                .put(TextureSlot.TOP, TextureMapping.getBlockTexture(ModBlocks.CLASSIC_GRASS, "_top"))
                .put(TextureSlot.SIDE, TextureMapping.getBlockTexture(ModBlocks.CLASSIC_GRASS, "_snow"));
        MultiVariant snowyVariant = BlockModelGenerators.plainVariant(
                ModelTemplates.CUBE_BOTTOM_TOP.createWithSuffix(ModBlocks.CLASSIC_GRASS, "_snow", classicGrassSnowy, blockModelGenerators.modelOutput)
        );
        var normalModel = TexturedModel.CUBE_TOP_BOTTOM.create(ModBlocks.CLASSIC_GRASS, blockModelGenerators.modelOutput);


        blockModelGenerators.createTrivialCube(ModBlocks.ANCIENT_STONE_BRICKS);
        blockModelGenerators.createTrivialCube(ModBlocks.RUNESTONE_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.RUNESTONE_BLOCK);
        blockModelGenerators.createTrivialCube(ModBlocks.POLISHED_RUNESTONE_BLOCK);
        blockModelGenerators.createGrassLikeBlock(ModBlocks.CLASSIC_GRASS, BlockModelGenerators.createRotatedVariants(BlockModelGenerators.plainModel(normalModel)), snowyVariant);
        blockModelGenerators.createTrivialCube(ModBlocks.CLASSIC_DIRT);
        blockModelGenerators.createTrivialCube(ModBlocks.CLASSIC_STONE);
        blockModelGenerators.createTrivialCube(ModBlocks.CLASSIC_COBBLESTONE);
        blockModelGenerators.createAxisAlignedPillarBlock(ModBlocks.CLASSIC_OAK_LOG, TexturedModel.CUBE_TOP_BOTTOM);
        blockModelGenerators.createTrivialCube(ModBlocks.CLASSIC_OAK_PLANKS);
        blockModelGenerators.createCraftingTableLike(ModBlocks.CLASSIC_CRAFTING_TABLE, ModBlocks.CLASSIC_OAK_PLANKS, TextureMapping::craftingTable);
        blockModelGenerators.createTrivialCube(ModBlocks.CLASSIC_BRICKS);
        blockModelGenerators.createPlant(ModBlocks.CLASSIC_OAK_SAPLING, ModBlocks.POTTED_CLASSIC_OAK_SAPLING, BlockModelGenerators.PlantType.TINTED);
        blockModelGenerators.createTrivialCube(ModBlocks.CLASSIC_BEDROCK);
        blockModelGenerators.createTintedLeaves(ModBlocks.CLASSIC_OAK_LEAVES, TexturedModel.LEAVES, 0x92BC95);
//        blockModelGenerators.createHorizontallyRotatedBlock(ModBlocks.CURSED_LECTERN, TexturedModel.CUBE_TOP_BOTTOM);

    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
//        itemModelGenerators.generateFlatItem(ModItems.COPPER_CORE, ModelTemplates.FLAT_ITEM);
//        itemModelGenerators.generateFlatItem(ModItems.IRON_CORE, ModelTemplates.FLAT_ITEM);
//        itemModelGenerators.generateFlatItem(ModItems.GOLD_CORE, ModelTemplates.FLAT_ITEM);
//        itemModelGenerators.generateFlatItem(ModItems.DIAMOND_CORE, ModelTemplates.FLAT_ITEM);
//        itemModelGenerators.generateFlatItem(ModItems.NETHERITE_CORE, ModelTemplates.FLAT_ITEM);
//        itemModelGenerators.generateFlatItem(ModItems.SPIDER_CORE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.CURSED_BOOK, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.RUNESTONE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.POLISHED_RUNESTONE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.RUNESTONE_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.RUNESTONE_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.RUNESTONE_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.RUNESTONE_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.RUNESTONE_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateSpear(ModItems.RUNESTONE_SPEAR);
        itemModelGenerators.generateFlatItem(ModItems.RUNESTONE_UPGRADE_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.STORY_BOOK, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.UNBREAKABLE_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.NOTCH_CORE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.NOTCH_APPLE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.HOLY_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.SAVAGE_SPAWN_EGG, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.ANCIENT_WOLF_FANG, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.MUSIC_DISC_DOWNED, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateTrident(ModItems.WOLF_FANG_TRIDENT);
        itemModelGenerators.generateFlatItem(ModItems.WHISTLE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.SHATTERGUARD_SPAWN_EGG, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.CLASSIC_OAK_SAPLING, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.RIFT_KEY, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.BLOOD_DROPPER, ModelTemplates.FLAT_ITEM);
//        itemModelGenerators.generateFlatItem(ModBlocks.CURSED_LECTERN.asItem(), ModelTemplates.FLAT_ITEM);

    }
}

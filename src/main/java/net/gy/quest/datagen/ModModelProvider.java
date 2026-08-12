package net.gy.quest.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.gy.quest.block.ModBlocks;
import net.gy.quest.item.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;

public class ModModelProvider extends FabricModelProvider {


    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        blockModelGenerators.createTrivialCube(ModBlocks.ANCIENT_STONE_BRICKS);
        blockModelGenerators.createTrivialCube(ModBlocks.RUNESTONE_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.RUNESTONE_BLOCK);
        blockModelGenerators.createTrivialCube(ModBlocks.POLISHED_RUNESTONE_BLOCK);

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


    }
}

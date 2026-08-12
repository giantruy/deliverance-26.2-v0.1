package net.gy.quest.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricEntityLootSubProvider;
import net.gy.quest.block.ModBlocks;
import net.gy.quest.entity.ModEntityTypes;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.concurrent.CompletableFuture;

public class ModEntityLootTableProvider extends FabricEntityLootSubProvider {
    public ModEntityLootTableProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    public void generate() {
        this.add(ModEntityTypes.SHATTERGUARD,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                .add(LootItem.lootTableItem(ModBlocks.ANCIENT_STONE_BRICKS)
                                        .setWeight(1)
                                )
                        )
                        .withPool(LootPool.lootPool()
                                .setRolls(UniformGenerator.between(1, 2))
                                .add(LootItem.lootTableItem(Items.LAPIS_LAZULI)
                                        .setWeight(5)
                                )
                                .add(LootItem.lootTableItem(Blocks.SAND)
                                        .setWeight(3)
                                )
                                .add(LootItem.lootTableItem(Blocks.SANDSTONE)
                                        .setWeight(1)
                                )
                                .add(LootItem.lootTableItem(Blocks.RED_SAND)
                                        .setWeight(2)
                                )
                                .add(LootItem.lootTableItem(Blocks.RED_SANDSTONE)
                                        .setWeight(1)
                                )
                                .add(LootItem.lootTableItem(ModBlocks.ANCIENT_STONE_BRICKS)
                                        .setWeight(3)
                                )
                                .add(LootItem.lootTableItem(Blocks.STONE_BRICKS)
                                        .setWeight(2)
                                )
                                .add(LootItem.lootTableItem(Blocks.CRACKED_STONE_BRICKS)
                                        .setWeight(2)
                                )
                                .add(LootItem.lootTableItem(Blocks.MOSSY_STONE_BRICKS)
                                        .setWeight(2)
                                )
                                .add(LootItem.lootTableItem(Blocks.COBBLESTONE)
                                        .setWeight(2)
                                )
                                .add(LootItem.lootTableItem(Blocks.MOSSY_COBBLESTONE)
                                        .setWeight(2)
                                )
                                .add(LootItem.lootTableItem(Blocks.STONE)
                                        .setWeight(2)
                                )
                                .add(LootItem.lootTableItem(Blocks.CHISELED_STONE_BRICKS)
                                        .setWeight(2)
                                )
                                .add(LootItem.lootTableItem(Blocks.INFESTED_STONE_BRICKS)
                                        .setWeight(1)
                                )
                                .add(LootItem.lootTableItem(Blocks.INFESTED_CRACKED_STONE_BRICKS)
                                        .setWeight(1)
                                )
                                .add(LootItem.lootTableItem(Blocks.INFESTED_MOSSY_STONE_BRICKS)
                                        .setWeight(1)
                                )
                                .add(LootItem.lootTableItem(Blocks.INFESTED_COBBLESTONE)
                                        .setWeight(1)
                                )
                                .add(LootItem.lootTableItem(Blocks.INFESTED_STONE)
                                        .setWeight(1)
                                )
                                .add(LootItem.lootTableItem(Blocks.INFESTED_CHISELED_STONE_BRICKS)
                                        .setWeight(1)
                                )
                        )
        );

        this.add(ModEntityTypes.SAVAGE,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(UniformGenerator.between(1, 2))
                                .add(LootItem.lootTableItem(Items.ROTTEN_FLESH)
                                        .setWeight(1)
                                )
                        )
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                .add(LootItem.lootTableItem(Items.ROTTEN_FLESH)
                                        .setWeight(3)
                                )
                                .add(LootItem.lootTableItem(Items.BONE)
                                        .setWeight(1)
                                )
                        )
        );
    }
}
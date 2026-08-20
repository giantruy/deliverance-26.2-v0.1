package net.gy.quest.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.gy.quest.block.ModBlocks;
import net.gy.quest.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.concurrent.CompletableFuture;

public class ModBlockLootTableProvider extends FabricBlockLootSubProvider {

    public ModBlockLootTableProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }

    @Override
    public void generate() {

        dropSelf(ModBlocks.ANCIENT_STONE_BRICKS);
        dropSelf(ModBlocks.STAFFANS_CRAFTER);
        dropSelf(ModBlocks.RUNESTONE_BLOCK);
        dropSelf(ModBlocks.POLISHED_RUNESTONE_BLOCK);
        dropSelf(ModBlocks.CLASSIC_DIRT);
        dropSelf(ModBlocks.CLASSIC_COBBLESTONE);
        dropSelf(ModBlocks.CLASSIC_OAK_LOG);
        dropSelf(ModBlocks.CLASSIC_OAK_PLANKS);
        dropSelf(ModBlocks.CLASSIC_CRAFTING_TABLE);
        dropSelf(ModBlocks.CLASSIC_BRICKS);
        dropSelf(ModBlocks.CLASSIC_OAK_SAPLING);
        dropSelf(ModBlocks.CURSED_LECTERN);
//        dropSelf(ModBlocks.CLASSIC_BEDROCK);
        dropPottedContents(ModBlocks.POTTED_CLASSIC_OAK_SAPLING);
        dropWhenSilkTouch(ModBlocks.CLASSIC_STONE);
//        dropWhenSilkTouch(ModBlocks.CLASSIC_GRASS);

        add(ModBlocks.RUNESTONE_ORE, createMultipleOreDrops(ModBlocks.RUNESTONE_ORE, ModItems.RUNESTONE, 0, 2));
        add(ModBlocks.CLASSIC_OAK_LEAVES, createBlockDropsItem(ModBlocks.CLASSIC_OAK_LEAVES, ModItems.CLASSIC_OAK_SAPLING, 1, 1));
        add(ModBlocks.CLASSIC_GRASS, createOtherBlockDrops(ModBlocks.CLASSIC_GRASS, ModBlocks.CLASSIC_DIRT, 1, 1));
    }

    public LootTable.Builder createMultipleOreDrops(final Block block, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> enchantments = this.registries.lookupOrThrow(Registries.ENCHANTMENT);

        return this.createSilkTouchDispatchTable(block, this.applyExplosionDecay(
                block, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(enchantments.getOrThrow(Enchantments.FORTUNE)))));
    }

    public LootTable.Builder createOtherBlockDrops(final Block block, Block blockDrop, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> enchantments = this.registries.lookupOrThrow(Registries.ENCHANTMENT);

        return this.createSilkTouchDispatchTable(block, this.applyExplosionDecay(
                block, LootItem.lootTableItem(blockDrop)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(enchantments.getOrThrow(Enchantments.FORTUNE)))));
    }

    public LootTable.Builder createBlockDropsItem(final Block block, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> enchantments = this.registries.lookupOrThrow(Registries.ENCHANTMENT);

        return this.createSilkTouchDispatchTable(block, this.applyExplosionDecay(
                block, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(enchantments.getOrThrow(Enchantments.FORTUNE)))));
    }

}

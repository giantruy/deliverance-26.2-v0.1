package net.gy.quest.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableSubProvider;
import net.gy.quest.ModLootTables;
import net.gy.quest.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.EnchantRandomlyFunction;
import net.minecraft.world.level.storage.loot.functions.EnchantWithLevelsFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class ModChestLootTableProvider extends SimpleFabricLootTableSubProvider {

    public ModChestLootTableProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture, LootContextParamSets.CHEST);
        this.registryLookupFuture = registryLookupFuture;
    }

    private final CompletableFuture<HolderLookup.Provider> registryLookupFuture;

    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> lootTableBiConsumer) {
        HolderLookup.Provider registries = registryLookupFuture.join();
        HolderLookup<Enchantment> enchantmentLookup = registries.lookupOrThrow(Registries.ENCHANTMENT);
        HolderSet<Enchantment> nonCurseEnchantments = HolderSet.direct(
                enchantmentLookup.listElements()
                        .filter(holder -> !holder.is(Enchantments.BINDING_CURSE)
                                && !holder.is(Enchantments.VANISHING_CURSE))
                        .toList()
        );
        lootTableBiConsumer.accept(ModLootTables.CURSED_CHEST_LOOT, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0f))
                        .add(LootItem.lootTableItem(ModItems.CURSED_BOOK)
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0f)))))
                .withPool(LootPool.lootPool()
                        .setRolls(UniformGenerator.between(5.0f, 11.0f))
                        .add(LootItem.lootTableItem(Items.DIAMOND)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 3.0f)))
                                .when(LootItemRandomChanceCondition.randomChance(0.2f)))
                        .add(LootItem.lootTableItem(Items.BOOK)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 3.0f)))
                                .when(LootItemRandomChanceCondition.randomChance(0.5f)))
                        .add(LootItem.lootTableItem(Items.IRON_INGOT)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 4.0f)))
                                .when(LootItemRandomChanceCondition.randomChance(0.3f)))
                        .add(LootItem.lootTableItem(Items.BONE)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 5.0f)))
                                .when(LootItemRandomChanceCondition.randomChance(0.5f)))
                        .add(LootItem.lootTableItem(Items.COBWEB)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 2.0f)))
                                .when(LootItemRandomChanceCondition.randomChance(0.75f)))
                        .add(LootItem.lootTableItem(Items.ROTTEN_FLESH)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 5.0f)))
                                .when(LootItemRandomChanceCondition.randomChance(0.4f)))
                        .add(LootItem.lootTableItem(Items.PAPER)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 5.0f)))
                                .when(LootItemRandomChanceCondition.randomChance(0.75f)))
                        .add(LootItem.lootTableItem(Items.ENCHANTED_GOLDEN_APPLE)
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0f)))
                                .when(LootItemRandomChanceCondition.randomChance(0.1f)))
                        .add(LootItem.lootTableItem(Items.BOOK)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 3.0f)))
                                .apply(EnchantWithLevelsFunction.enchantWithLevels(registries, UniformGenerator.between(25.0f, 33.0f))
                                        .withOptions(Optional.of(nonCurseEnchantments)))
                                .when(LootItemRandomChanceCondition.randomChance(0.3f)))
                        .add(LootItem.lootTableItem(Items.DIAMOND_AXE)
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0f)))
                                .apply(EnchantRandomlyFunction.randomApplicableEnchantment(registries)
                                        .withOptions(nonCurseEnchantments))
                                .apply(EnchantRandomlyFunction.randomApplicableEnchantment(registries)
                                        .withOptions(nonCurseEnchantments))
                                .apply(EnchantRandomlyFunction.randomApplicableEnchantment(registries)
                                        .withOptions(nonCurseEnchantments))
                                .apply(EnchantRandomlyFunction.randomApplicableEnchantment(registries)
                                        .withOptions(nonCurseEnchantments))
                                .when(LootItemRandomChanceCondition.randomChance(0.15f)))
                        .add(LootItem.lootTableItem(Items.DIAMOND_PICKAXE)
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0f)))
                                .apply(EnchantRandomlyFunction.randomApplicableEnchantment(registries)
                                        .withOptions(nonCurseEnchantments))
                                .apply(EnchantRandomlyFunction.randomApplicableEnchantment(registries)
                                        .withOptions(nonCurseEnchantments))
                                .apply(EnchantRandomlyFunction.randomApplicableEnchantment(registries)
                                        .withOptions(nonCurseEnchantments))
                                .apply(EnchantRandomlyFunction.randomApplicableEnchantment(registries)
                                        .withOptions(nonCurseEnchantments))
                                .when(LootItemRandomChanceCondition.randomChance(0.15f)))
                        .add(LootItem.lootTableItem(Items.DIAMOND_SHOVEL)
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0f)))
                                .apply(EnchantRandomlyFunction.randomApplicableEnchantment(registries)
                                        .withOptions(nonCurseEnchantments))
                                .apply(EnchantRandomlyFunction.randomApplicableEnchantment(registries)
                                        .withOptions(nonCurseEnchantments))
                                .apply(EnchantRandomlyFunction.randomApplicableEnchantment(registries)
                                        .withOptions(nonCurseEnchantments))
                                .apply(EnchantRandomlyFunction.randomApplicableEnchantment(registries)
                                        .withOptions(nonCurseEnchantments))
                                .when(LootItemRandomChanceCondition.randomChance(0.15f)))
                        .add(LootItem.lootTableItem(Items.DIAMOND_HOE)
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0f)))
                                .apply(EnchantRandomlyFunction.randomApplicableEnchantment(registries)
                                        .withOptions(nonCurseEnchantments))
                                .apply(EnchantRandomlyFunction.randomApplicableEnchantment(registries)
                                        .withOptions(nonCurseEnchantments))
                                .apply(EnchantRandomlyFunction.randomApplicableEnchantment(registries)
                                        .withOptions(nonCurseEnchantments))
                                .apply(EnchantRandomlyFunction.randomApplicableEnchantment(registries)
                                        .withOptions(nonCurseEnchantments))
                                .when(LootItemRandomChanceCondition.randomChance(0.15f)))
                        .add(LootItem.lootTableItem(Items.DIAMOND_SWORD)
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0f)))
                                .apply(EnchantRandomlyFunction.randomApplicableEnchantment(registries)
                                        .withOptions(nonCurseEnchantments))
                                .apply(EnchantRandomlyFunction.randomApplicableEnchantment(registries)
                                        .withOptions(nonCurseEnchantments))
                                .apply(EnchantRandomlyFunction.randomApplicableEnchantment(registries)
                                        .withOptions(nonCurseEnchantments))
                                .apply(EnchantRandomlyFunction.randomApplicableEnchantment(registries)
                                        .withOptions(nonCurseEnchantments))
                                .when(LootItemRandomChanceCondition.randomChance(0.15f)))
                        .add(LootItem.lootTableItem(ModItems.MUSIC_DISC_DOWNED)
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0f))))


                )
        );

        lootTableBiConsumer.accept(ModLootTables.FANG_CHEST_LOOT, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0f))
                        .add(LootItem.lootTableItem(ModItems.ANCIENT_WOLF_FANG)
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0f)))))
                .withPool(LootPool.lootPool()
                        .setRolls(UniformGenerator.between(4.0f, 9.0f))
                        .add(LootItem.lootTableItem(Items.BONE)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 3.0f)))
                                .when(LootItemRandomChanceCondition.randomChance(0.4f)))
                        .add(LootItem.lootTableItem(Items.ROTTEN_FLESH)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 3.0f)))
                                .when(LootItemRandomChanceCondition.randomChance(0.5f)))
                        .add(LootItem.lootTableItem(Items.STRING)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 2.0f)))
                                .when(LootItemRandomChanceCondition.randomChance(0.25f)))
                        .add(LootItem.lootTableItem(Items.COBWEB)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 2.0f)))
                                .when(LootItemRandomChanceCondition.randomChance(0.85f)))
                        .add(LootItem.lootTableItem(Items.BONE)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 2.0f)))
                                .when(LootItemRandomChanceCondition.randomChance(0.45f)))
                        .add(LootItem.lootTableItem(Items.IRON_SWORD)
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0f)))
                                .when(LootItemRandomChanceCondition.randomChance(0.15f)))
                        .add(LootItem.lootTableItem(ModItems.MUSIC_DISC_DOWNED)
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0f))))
                )
        );

        lootTableBiConsumer.accept(ModLootTables.RUINS_CHEST_LOOT, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0f))
                        .add(LootItem.lootTableItem(ModItems.POLISHED_RUNESTONE)
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0f)))))
                .withPool(LootPool.lootPool()
                        .setRolls(UniformGenerator.between(4.0f, 9.0f))
                        .add(LootItem.lootTableItem(ModItems.RUNESTONE)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 2.0f)))
                                .when(LootItemRandomChanceCondition.randomChance(0.05f)))
                        .add(LootItem.lootTableItem(Items.NETHERITE_INGOT)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 1.0f)))
                                .when(LootItemRandomChanceCondition.randomChance(0.05f)))
                        .add(LootItem.lootTableItem(Items.DIAMOND)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 2.0f)))
                                .when(LootItemRandomChanceCondition.randomChance(0.25f)))
                        .add(LootItem.lootTableItem(Items.IRON_INGOT)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 2.0f)))
                                .when(LootItemRandomChanceCondition.randomChance(0.85f)))
                        .add(LootItem.lootTableItem(Items.GOLD_BLOCK)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 2.0f)))
                                .when(LootItemRandomChanceCondition.randomChance(0.45f)))
                        .add(LootItem.lootTableItem(Items.EMERALD)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4)))
                                .when(LootItemRandomChanceCondition.randomChance(0.15f)))
                        .add(LootItem.lootTableItem(Items.QUARTZ)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 8)))
                                .when(LootItemRandomChanceCondition.randomChance(0.15f)))
                        .add(LootItem.lootTableItem(ModItems.MUSIC_DISC_DOWNED)
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0f))))
                )
        );
    }
}
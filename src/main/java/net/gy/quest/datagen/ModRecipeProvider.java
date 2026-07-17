package net.gy.quest.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.gy.quest.block.ModBlocks;
import net.gy.quest.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SmithingTransformRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        return new RecipeProvider(registries, output) {
            @Override
            public void buildRecipes() {
                List<ItemLike> RUNESTONE_SMELTABLES = List.of(ModBlocks.RUNESTONE_ORE);
                List<ItemLike> RUNESTONE_BLOCK_SMELTABLES = List.of(ModBlocks.RUNESTONE_BLOCK);

                oreSmelting(RUNESTONE_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModItems.RUNESTONE, 0.25f, 200, "runestone");
                oreBlasting(RUNESTONE_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModItems.RUNESTONE, 0.25f, 100, "runestone");

                nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.RUNESTONE, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RUNESTONE_BLOCK);
                nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.POLISHED_RUNESTONE, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_RUNESTONE_BLOCK);

                shaped(RecipeCategory.MISC, ModItems.COPPER_CORE)
                        .pattern("CCC")
                        .pattern("CRC")
                        .pattern("CCC")
                        .define('C', Items.COPPER_INGOT)
                        .define('R', ModItems.POLISHED_RUNESTONE)
                        .unlockedBy(getHasName(ModItems.POLISHED_RUNESTONE), has(ModItems.POLISHED_RUNESTONE))
                        .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                        .group("runestone")
                        .save(output);
                shaped(RecipeCategory.MISC, ModItems.IRON_CORE)
                        .pattern("CCC")
                        .pattern("CRC")
                        .pattern("CCC")
                        .define('C', Items.IRON_INGOT)
                        .define('R', ModItems.POLISHED_RUNESTONE)
                        .unlockedBy(getHasName(ModItems.POLISHED_RUNESTONE), has(ModItems.POLISHED_RUNESTONE))
                        .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                        .group("runestone")
                        .save(output);
                shaped(RecipeCategory.MISC, ModItems.GOLD_CORE)
                        .pattern("CCC")
                        .pattern("CRC")
                        .pattern("CCC")
                        .define('C', Items.GOLD_INGOT)
                        .define('R', ModItems.POLISHED_RUNESTONE)
                        .unlockedBy(getHasName(ModItems.POLISHED_RUNESTONE), has(ModItems.POLISHED_RUNESTONE))
                        .unlockedBy(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT))
                        .group("runestone")
                        .save(output);
                shaped(RecipeCategory.MISC, ModItems.DIAMOND_CORE)
                        .pattern("CCC")
                        .pattern("CRC")
                        .pattern("CCC")
                        .define('C', Items.DIAMOND)
                        .define('R', ModItems.POLISHED_RUNESTONE)
                        .unlockedBy(getHasName(ModItems.POLISHED_RUNESTONE), has(ModItems.POLISHED_RUNESTONE))
                        .unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND))
                        .group("runestone")
                        .save(output);
                shaped(RecipeCategory.MISC, ModItems.NETHERITE_CORE)
                        .pattern("CCC")
                        .pattern("CRC")
                        .pattern("CCC")
                        .define('C', Items.NETHERITE_INGOT)
                        .define('R', ModItems.POLISHED_RUNESTONE)
                        .unlockedBy(getHasName(ModItems.POLISHED_RUNESTONE), has(ModItems.POLISHED_RUNESTONE))
                        .unlockedBy(getHasName(Items.NETHERITE_INGOT), has(Items.NETHERITE_INGOT))
                        .group("runestone")
                        .save(output);
                shaped(RecipeCategory.MISC, ModItems.SPIDER_CORE)
                        .pattern("CCC")
                        .pattern("CRC")
                        .pattern("CCC")
                        .define('C', Items.STRING)
                        .define('R', ModItems.POLISHED_RUNESTONE)
                        .unlockedBy(getHasName(ModItems.POLISHED_RUNESTONE), has(ModItems.POLISHED_RUNESTONE))
                        .unlockedBy(getHasName(Items.STRING), has(Items.STRING))
                        .group("runestone")
                        .save(output);

                shaped(RecipeCategory.MISC, ModItems.RUNESTONE_UPGRADE_SMITHING_TEMPLATE)
                        .pattern("CCC")
                        .pattern("CRC")
                        .pattern("CCC")
                        .define('R', Items.NETHERITE_INGOT)
                        .define('C', ModItems.POLISHED_RUNESTONE)
                        .unlockedBy(getHasName(ModItems.POLISHED_RUNESTONE), has(ModItems.POLISHED_RUNESTONE))
                        .unlockedBy(getHasName(Items.NETHERITE_INGOT), has(Items.NETHERITE_INGOT))
                        .group("runestone")
                        .save(output);

                shaped(RecipeCategory.MISC, ModBlocks.STAFFANS_CRAFTER)
                        .pattern(" C ")
                        .pattern("ROR")
                        .pattern("OOO")
                        .define('C', ModItems.CURSED_BOOK)
                        .define('R', ModItems.POLISHED_RUNESTONE)
                        .define('O', Items.OBSIDIAN)
                        .unlockedBy(getHasName(ModItems.POLISHED_RUNESTONE), has(ModItems.POLISHED_RUNESTONE))
                        .unlockedBy(getHasName(ModItems.CURSED_BOOK), has(ModItems.CURSED_BOOK))
                        .unlockedBy(getHasName(Items.OBSIDIAN), has(Items.OBSIDIAN))
                        .group("runestone")
                        .save(output);

                stonecutterResultFromBase(RecipeCategory.MISC, ModItems.POLISHED_RUNESTONE, ModItems.RUNESTONE);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_RUNESTONE_BLOCK, ModBlocks.RUNESTONE_BLOCK);

                smithUpgrade(Items.DIAMOND_SWORD, ModItems.RUNESTONE_SWORD, "runestone_sword_smithing");
                smithUpgrade(Items.DIAMOND_PICKAXE, ModItems.RUNESTONE_PICKAXE, "runestone_pickaxe_smithing");
                smithUpgrade(Items.DIAMOND_AXE, ModItems.RUNESTONE_AXE, "runestone_axe_smithing");
                smithUpgrade(Items.DIAMOND_SHOVEL, ModItems.RUNESTONE_SHOVEL, "runestone_shovel_smithing");
                smithUpgrade(Items.DIAMOND_HOE, ModItems.RUNESTONE_HOE, "runestone_hoe_smithing");
                smithUpgrade(Items.DIAMOND_SPEAR, ModItems.RUNESTONE_SPEAR, "runestone_spear_smithing");


            }

            private void smithUpgrade(Item base, Item result, String name) {
                SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.RUNESTONE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(base),
                        Ingredient.of(Items.ECHO_SHARD),
                        RecipeCategory.TOOLS,
                        result
                )
                        .unlocks(getHasName(ModItems.RUNESTONE_UPGRADE_SMITHING_TEMPLATE), has(ModItems.RUNESTONE_UPGRADE_SMITHING_TEMPLATE))
                        .unlocks(getHasName(Items.ECHO_SHARD), has(Items.ECHO_SHARD))
                        .save(output, name);
            }
        };
    }

    @Override
    public String getName() {
        return "Deliverance Recipes";
    }
}

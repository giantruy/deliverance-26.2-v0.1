package net.gy.quest.datagen;

import net.gy.quest.Deliverance;
import net.gy.quest.recipe.StaffansCraftingRecipe;
import net.minecraft.advancements.*;
import net.minecraft.advancements.triggers.Criterion;
import net.minecraft.advancements.triggers.RecipeUnlockedTrigger;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.ItemLike;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StaffansCraftingRecipeBuilder implements RecipeBuilder {
    private final ItemLike result;
    private final int count;
    private final Map<Character, Ingredient> keys= new LinkedHashMap<>();
    private final List<String> rows = new ArrayList<>();
    private final Advancement.Builder advancement = Advancement.Builder.recipeAdvancement();
    private String group = "";

    private StaffansCraftingRecipeBuilder(ItemLike result, int count) {
        this.result = result;
        this.count = count;
    }

    public static StaffansCraftingRecipeBuilder staffansCrafting(ItemLike result) {
        return new StaffansCraftingRecipeBuilder(result, 1);
    }

    public static StaffansCraftingRecipeBuilder staffansCrafting(ItemLike result, int count) {
        return new StaffansCraftingRecipeBuilder(result, count);
    }

    public StaffansCraftingRecipeBuilder pattern(String row) {
        if (row.length() != 3) {
            throw new IllegalArgumentException("Must be 3 char long: " + row);
        }
        this.rows.add(row);
        return this;
    }

    public StaffansCraftingRecipeBuilder define(char key, ItemLike item) {
        this.keys.put(key, Ingredient.of(item));
        return this;
    }

    public StaffansCraftingRecipeBuilder define(char key, Ingredient ingredient) {
        this.keys.put(key, ingredient);
        return this;
    }

    @Override
    public StaffansCraftingRecipeBuilder unlockedBy(String name, Criterion<?> criterion) {
        this.advancement.addCriterion(name, criterion);
        return this;
    }

    @Override
    public StaffansCraftingRecipeBuilder group(String group) {
        this.group = group;
        return this;
    }

    @Override
    public ResourceKey<Recipe<?>> defaultId() {
        Identifier id = BuiltInRegistries.ITEM.getKey(this.result.asItem());
        return ResourceKey.create(Registries.RECIPE, id);
    }

    @Override
    public void save(RecipeOutput output, ResourceKey<Recipe<?>> id) {
        if (this.rows.size() != 3) {
            throw new IllegalStateException("recipe " + defaultId() + " must have 3 pattern rows");
        }

        List<Ingredient> inputs = new ArrayList<>(9);
        int index = 0;
        for (String row : rows) {
            for (char c : row.toCharArray()) {
                if (c == ' ') {
                    throw new IllegalStateException("blank slots not supported in recipe: " + defaultId());
                } else {
                    Ingredient ingredient = keys.get(c);
                    if (ingredient == null) {
                        throw new IllegalStateException("undefined symbol '" + c + "' in recipe " + defaultId());
                    }
                    inputs.add(ingredient);
                }
            }
        }

//        StaffansCraftingRecipe recipe = new StaffansCraftingRecipe(inputs, new ItemStackTemplate(this.result.asItem(), this.count));

        Identifier advancementId = defaultId().identifier().withPrefix("recipes/staffans_crafting/");
        AdvancementHolder advancementHolder = this.advancement
                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(defaultId()))
                .rewards(AdvancementRewards.Builder.recipe(defaultId()))
                .requirements(AdvancementRequirements.Strategy.OR)
                .build(advancementId);

        output.accept(defaultId(), new StaffansCraftingRecipe(inputs, new ItemStackTemplate(this.result.asItem(), this.count)), advancementHolder);
    }

    public void save(RecipeOutput output, String name) {
        save(output, ResourceKey.create(Registries.RECIPE, Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, name)));
    }
}

package net.gy.quest.recipe;

import net.gy.quest.Deliverance;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

public class ModRecipes {

    public static final RecipeType<StaffansCraftingRecipe> STAFFANS_CRAFTING_TYPE =
            Registry.register(BuiltInRegistries.RECIPE_TYPE,
                    Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, "staffans_crafting"),
                    new RecipeType<StaffansCraftingRecipe>() {
                        @Override
                        public String toString() {
                            return "quest:staffans_crafting";
                        }
                    });

    public static final RecipeSerializer<StaffansCraftingRecipe> STAFFANS_CRAFTING_SERIALIZER =
            Registry.register(BuiltInRegistries.RECIPE_SERIALIZER,
                    Identifier.fromNamespaceAndPath("quest", "staffans_crafting"),
                    new RecipeSerializer<>(StaffansCraftingRecipe.CODEC, StaffansCraftingRecipe.STREAM_CODEC));

    public static void registerModRecipes() {
        Deliverance.LOGGER.info("Registering Mod Recipes for " + Deliverance.MOD_ID);
    }

}
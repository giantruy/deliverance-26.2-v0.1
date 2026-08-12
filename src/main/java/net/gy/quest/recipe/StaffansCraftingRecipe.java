package net.gy.quest.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

import java.util.List;

public class StaffansCraftingRecipe implements Recipe<CraftingInput> {
    private final List<Ingredient> inputs;
    private final ItemStackTemplate output;

    public StaffansCraftingRecipe(List<Ingredient> inputs, ItemStackTemplate output) {
        this.inputs = inputs;
        this.output = output;
    }

    @Override
    public boolean matches(CraftingInput input, Level level) {
        if (input.size() != inputs.size()) return false;
        for (int i = 0; i < inputs.size(); i++) {
            if (!inputs.get(i).test(input.getItem(i))) return false;
        }
        return true;
    }

    @Override
    public ItemStack assemble(CraftingInput input) {
        return output.create();
    }

    @Override
    public boolean showNotification() {
        return true;
    }

    @Override
    public String group() {
        return "";
    }

    @Override
    public RecipeSerializer<? extends Recipe<CraftingInput>> getSerializer() {
        return ModRecipes.STAFFANS_CRAFTING_SERIALIZER;
    }

    @Override
    public RecipeType<? extends Recipe<CraftingInput>> getType() {
        return ModRecipes.STAFFANS_CRAFTING_TYPE;
    }

    @Override
    public PlacementInfo placementInfo() {
        return PlacementInfo.create(inputs);
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
        return RecipeBookCategories.CRAFTING_MISC;
    }

    public List<Ingredient> getInputs() {
        return inputs;
    }

    public ItemStackTemplate getOutput() {
        return output;
    }


    public static final MapCodec<StaffansCraftingRecipe> CODEC = RecordCodecBuilder.mapCodec(instance ->
            instance.group(
                    Ingredient.CODEC.listOf().fieldOf("ingredients").forGetter(StaffansCraftingRecipe::getInputs),
                    ItemStackTemplate.CODEC.fieldOf("result").forGetter(StaffansCraftingRecipe::getOutput)
            ).apply(instance, StaffansCraftingRecipe::new)
    );


    private static final StreamCodec<RegistryFriendlyByteBuf, List<Ingredient>> INGREDIENT_LIST_STREAM_CODEC =
            Ingredient.CONTENTS_STREAM_CODEC.apply(ByteBufCodecs.list());

    public static final StreamCodec<RegistryFriendlyByteBuf, StaffansCraftingRecipe> STREAM_CODEC = StreamCodec.composite(
            INGREDIENT_LIST_STREAM_CODEC,
            StaffansCraftingRecipe::getInputs,
            ItemStackTemplate.STREAM_CODEC,
            StaffansCraftingRecipe::getOutput,
            StaffansCraftingRecipe::new
    );
}

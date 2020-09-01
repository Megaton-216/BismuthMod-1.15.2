package com.github.BismuthMod.recipes;

import com.google.gson.JsonObject;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class CrucibleRecipeSerializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<CrucibleRecipe> {

    @Override
    public CrucibleRecipe read(ResourceLocation recipeId, JsonObject json) {
        ItemStack output = CraftingHelper.getItemStack(JSONUtils.getJsonObject(json, "output"), true);
        Ingredient input_d = Ingredient.deserialize(JSONUtils.getJsonObject(json, "input_d"));
        Ingredient input_e = Ingredient.deserialize(JSONUtils.getJsonObject(json, "input_e"));
        Ingredient input_f = Ingredient.deserialize(JSONUtils.getJsonObject(json, "input_f"));

        return new CrucibleRecipe(recipeId, input_d, input_e, input_f, output);
    }

    @Override
    public CrucibleRecipe read(ResourceLocation recipeId, PacketBuffer buffer) {
        ItemStack output = buffer.readItemStack();
        Ingredient input_d = Ingredient.read(buffer);
        Ingredient input_e = Ingredient.read(buffer);
        Ingredient input_f = Ingredient.read(buffer);


        return new CrucibleRecipe(recipeId, input_d, input_e, input_f, output);
    }

    @Override
    public void write(PacketBuffer buffer, CrucibleRecipe recipe) {
        Ingredient input_d = recipe.getIngredients().get(0);
        input_d.write(buffer);
        Ingredient input_e = recipe.getIngredients().get(0);
        input_e.write(buffer);
        Ingredient input_f = recipe.getIngredients().get(0);
        input_f.write(buffer);

        buffer.writeItemStack(recipe.getRecipeOutput(), false);
    }
}

package com.github.BismuthMod.recipes;

import com.github.BismuthMod.init.ModRecipeSerializer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.items.wrapper.RecipeWrapper;

public class CrucibleRecipe implements ICrucibleRecipe {

    private final ResourceLocation id;
    private Ingredient input_d;
    private Ingredient input_e;
    private Ingredient input_f;
    private final ItemStack output;

    public CrucibleRecipe(ResourceLocation id, Ingredient input_d, Ingredient input_e, Ingredient input_f, ItemStack output) {
        this.id = id;
        this.output = output;
        this.input_d = input_d;
        this.input_e = input_e;
        this.input_f = input_f;
    }

    @Override
    public boolean matches(RecipeWrapper inv, World worldIn) {
        if (this.input_d.test(inv.getStackInSlot(0))) {
            return true;
        }
        if (this.input_e.test(inv.getStackInSlot(0))) {
            return true;
        }
        if (this.input_f.test(inv.getStackInSlot(0))) {
            return true;
        }
        return false;
    }

    @Override
    public ItemStack getCraftingResult(RecipeWrapper inv) {
        return this.output;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return this.output;
    }

    @Override
    public ResourceLocation getId() {
        return this.id;
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return ModRecipeSerializer.CRUCIBLE_SERIALIZER.get();
    }

    @Override
    public Ingredient getInputD() {
        return this.input_d;
    }

    @Override
    public Ingredient getInputE() {
        return this.input_e;
    }

    @Override
    public Ingredient getInputF() {
        return this.input_f;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return NonNullList.from(null, this.input_d, this.input_e, this.input_f);
    }
}

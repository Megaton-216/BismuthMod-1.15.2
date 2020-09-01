package com.github.BismuthMod.init;

import com.github.BismuthMod.Bismuth;
import com.github.BismuthMod.recipes.CrucibleRecipe;
import com.github.BismuthMod.recipes.CrucibleRecipeSerializer;
import com.github.BismuthMod.recipes.ICrucibleRecipe;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModRecipeSerializer {

    public static final IRecipeSerializer<CrucibleRecipe> CRUCIBLE_RECIPE_SERIALIZER = new CrucibleRecipeSerializer();
    public static final IRecipeType<ICrucibleRecipe> CRUCIBLE_TYPE = registerType(ICrucibleRecipe.RECIPE_TYPE_ID);

    public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZERS = new DeferredRegister<>(
            ForgeRegistries.RECIPE_SERIALIZERS, Bismuth.MOD_ID);

    public static final RegistryObject<IRecipeSerializer<?>> CRUCIBLE_SERIALIZER = RECIPE_SERIALIZERS.register("crucible",
            () -> CRUCIBLE_RECIPE_SERIALIZER);

    private static class RecipeType<T extends IRecipe<?>> implements IRecipeType<T> {
        @Override
        public String toString() {
            return Registry.RECIPE_TYPE.getKey(this).toString();
        }
    }

    private static <T extends IRecipeType> T registerType(ResourceLocation recipeTypeId) {
        return (T) Registry.register(Registry.RECIPE_TYPE, recipeTypeId, new RecipeType<>());
    }
}

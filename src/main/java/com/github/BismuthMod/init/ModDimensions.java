package com.github.BismuthMod.init;

import com.github.BismuthMod.Bismuth;
import com.github.BismuthMod.world.dimensions.TempMoonDim;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModDimensions {

    public static final DeferredRegister<ModDimension> MOD_DIMENSIONS = new DeferredRegister<>(ForgeRegistries.MOD_DIMENSIONS, Bismuth.MOD_ID);

    public static final RegistryObject<ModDimension> TEMP_MOONDIM = MOD_DIMENSIONS.register("temp_moondim", () -> new TempMoonDim());
}

package com.github.BismuthMod.init;

import com.github.BismuthMod.Bismuth;
import com.github.BismuthMod.world.biomes.TempMoon;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBiomes {

    public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES, Bismuth.MOD_ID);

    public static final RegistryObject<Biome> TEMP_MOON = BIOMES.register("temp_moon", () -> new TempMoon(
            new Biome.Builder().precipitation(Biome.RainType.NONE).scale(1.1f).temperature(0.9f).waterColor(16724639).waterFogColor(16762304).surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(ModBlocks.LIMESTONEL.get().getDefaultState(), ModBlocks.LIMESTONEB.get().getDefaultState(), ModBlocks.FLOOR_BASALT.get().getDefaultState()))
            .category(Biome.Category.DESERT).downfall(0.4f).depth(0.1f).parent(null)));


    public static void registerBiomes() {
        registerBiome(TEMP_MOON.get(), Type.DRY, Type.OVERWORLD);
    }

    public static void registerBiome(Biome biome, Type... types) {
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(biome, 1024));
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addSpawnBiome(biome);
    }
}
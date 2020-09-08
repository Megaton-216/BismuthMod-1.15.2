package com.github.BismuthMod.world.dimensions;

import com.github.BismuthMod.init.ModBiomes;
import com.google.common.collect.ImmutableSet;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;

import java.util.Random;
import java.util.Set;

public class TempBiomeProvider extends BiomeProvider {

    private Random rand;

    public TempBiomeProvider(TempBiomeProviderSettings tempBiomeProviderSettings) {
        super(biomeList);
        rand = new Random();
    }

    private static final Set<Biome> biomeList = ImmutableSet.of(ModBiomes.TEMP_MOON.get());

    public Biome getNoiseBiome(int x, int y, int z) {
        return ModBiomes.TEMP_MOON.get();
    }
}

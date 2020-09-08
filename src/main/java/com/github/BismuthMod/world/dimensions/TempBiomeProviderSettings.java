package com.github.BismuthMod.world.dimensions;

import net.minecraft.world.WorldType;
import net.minecraft.world.biome.provider.IBiomeProviderSettings;
import net.minecraft.world.storage.WorldInfo;

public class TempBiomeProviderSettings implements IBiomeProviderSettings {

    private final long seed;
    private final WorldType worldType;
    private TempGenSettings generatorSettings = new TempGenSettings();

    public TempBiomeProviderSettings(WorldInfo info) {
        this.seed = info.getSeed();
        this.worldType = info.getGenerator();
    }

    public TempBiomeProviderSettings setGeneratorSettings(TempGenSettings settings) {
        this.generatorSettings = settings;
        return this;
    }

    public long getSeed() {
        return this.seed;
    }

    public WorldType getWorldType() {
        return this.worldType;
    }

    public TempGenSettings getGeneratorSettings() {
        return this.generatorSettings;
    }
}

package com.github.BismuthMod.world;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.DecoratedFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.ReplaceBlockConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Iterator;

public class DisableVanilOres
{
    public static void removeVanillaOre()
    {

        replaceGenerator(Blocks.COAL_ORE);
        replaceGenerator(Blocks.IRON_ORE);
        replaceGenerator(Blocks.GOLD_ORE);
        replaceGenerator(Blocks.REDSTONE_ORE);
        replaceGenerator(Blocks.LAPIS_ORE);
        replaceGenerator(Blocks.EMERALD_ORE);
        //for (Biome biome : ForgeRegistries.BIOMES)
        {
        //    biome.getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).clear();
        }
    }


    private static void replaceGenerator(Block vanillaOre) {
        Iterator<Biome> list = ForgeRegistries.BIOMES.iterator();
        while (list.hasNext()) {
            OreFeatureConfig oreConfig = null;
            ConfiguredPlacement<?> placementConfig = null;
            Biome biome = list.next();
            Iterator<ConfiguredFeature<?, ?>> it = biome.getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).iterator();
            while (it.hasNext()) {
                ConfiguredFeature<?, ?> feature = it.next();
                if (feature.config instanceof DecoratedFeatureConfig) {
                    DecoratedFeatureConfig dfconfig = (DecoratedFeatureConfig) feature.config;
                    if (dfconfig.feature.config instanceof OreFeatureConfig) {
                        OreFeatureConfig oreConfigl = (OreFeatureConfig) dfconfig.feature.config;
                        if (oreConfigl.state.getBlock() == vanillaOre) {
                            oreConfig = oreConfigl;
                            placementConfig = (ConfiguredPlacement<?>) dfconfig.decorator;
                            it.remove();
                            break;
                        }
                    }
                    if (dfconfig.feature.config instanceof ReplaceBlockConfig) {
                        ReplaceBlockConfig reBlockConfig = (ReplaceBlockConfig) dfconfig.feature.config;
                        if (reBlockConfig.state.getBlock() == vanillaOre) {
                            //oreConfig = reBlockConfig;
                            placementConfig = (ConfiguredPlacement<?>) dfconfig.decorator;
                            it.remove();
                            break;
                        }
                    }
                }
            }
        }
    }
}
package com.github.BismuthMod.world.gen;

import com.github.BismuthMod.Bismuth;
import com.github.BismuthMod.init.ModBlocks;
import com.google.common.collect.Lists;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.SphereReplaceConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

@Mod.EventBusSubscriber(modid = Bismuth.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModOreGen {

    private static final BlockState DIRT = Blocks.DIRT.getDefaultState();
    private static final BlockState GRASS_BLOCK = Blocks.GRASS_BLOCK.getDefaultState();

    @SubscribeEvent
    public static void generateOres(FMLLoadCompleteEvent event) {
        for (Biome biome : ForgeRegistries.BIOMES) {
            //Overworld Generation
            genStoneVariants(biome, 20, 4, 0, 30, OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.GABBRO.get().getDefaultState(), 18);
            genStoneVariants(biome, 12, 4, 0, 40, OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.DUNITE.get().getDefaultState(), 24);
            genStoneVariants(biome, 16, 32, 0, 38, OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.FLOOR_BASALT.get().getDefaultState(), 38);
            genStoneVariants(biome, 20, 4, 0, 35, OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.NORITE.get().getDefaultState(), 33);

            genOre(biome, 15, 24, 5, 69, OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.COPPER_ORE.get().getDefaultState(), 10);
            genOre(biome, 10, 20, 0, 256, OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.BROWN_GRANITE.get().getDefaultState(), 25);
            genOre(biome, 8, 20, 0, 256, OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.BLACK_GRANITE.get().getDefaultState(), 14);
            genOre(biome, 9, 20, 0, 256, OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.RED_GRANITE.get().getDefaultState(), 16);
            genOre(biome, 10, 20, 0, 256, OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.WHITE_GRANITE.get().getDefaultState(), 25);
            genOre(biome, 10, 20, 0, 256, OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.YELLOW_GRANITE.get().getDefaultState(), 25);
            genOre(biome, 15, 20, 0, 35, OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.PLATINUM_ORE.get().getDefaultState(), 10);
            genOre(biome, 12, 60, 0, 63, OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.CLAYR.get().getDefaultState(), 12);
            genOre(biome, 15, 0, 0, 256, OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.LIMESTONEB.get().getDefaultState(), 50);
            genOre(biome, 15, 0, 0, 256, OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.LIMESTONED.get().getDefaultState(), 50);
            genOre(biome, 15, 0, 0, 256, OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.LIMESTONEK.get().getDefaultState(), 50);
            genOre(biome, 15, 0, 0, 256, OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.LIMESTONEL.get().getDefaultState(), 50);
            //genOre(biome, 15, 0, 0, 256, OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.LIMESTONEM.get().getDefaultState(), 50);
            //genOre(biome, 15, 0, 0, 80, OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.LIMESTONER.get().getDefaultState(), 33);
            genOre(biome, 15, 0, 0, 256, OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.LIMESTONET.get().getDefaultState(), 50);

            genSediment(biome, 9, 4, Lists.newArrayList(DIRT, GRASS_BLOCK), ModBlocks.CLAYR.get().getDefaultState(), 16);

        }
    }

    private static void genStoneVariants(Biome biome, int count, int bottomOffset, int topOffset, int max, OreFeatureConfig.FillerBlockType filler, BlockState defaultBlockstate, int size) {
        CountRangeConfig range = new CountRangeConfig(count, bottomOffset, topOffset, max);
        OreFeatureConfig feature = new OreFeatureConfig(filler, defaultBlockstate, size);
        ConfiguredPlacement config = Placement.COUNT_RANGE.configure(range);
        biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.withConfiguration(feature).withPlacement(config));
    }

    private static void genOre(Biome biome, int count, int bottomOffset, int topOffset, int max, OreFeatureConfig.FillerBlockType filler, BlockState defaultBlockstate, int size) {
        CountRangeConfig range = new CountRangeConfig(count, bottomOffset, topOffset, max);
        OreFeatureConfig feature = new OreFeatureConfig(filler, defaultBlockstate, size);
        ConfiguredPlacement config = Placement.COUNT_RANGE.configure(range);
        biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(feature).withPlacement(config));
    }

    private static void genSediment(Biome biome, int radiusIn, int ySizeIn, List<BlockState> targetsIn, BlockState defaultBlockstate, int count) {
        FrequencyConfig frequency = new FrequencyConfig(count);
        SphereReplaceConfig replace = new SphereReplaceConfig(defaultBlockstate, radiusIn, ySizeIn, targetsIn);
        ConfiguredPlacement config = Placement.COUNT_TOP_SOLID.configure(frequency);
        biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.DISK.withConfiguration(replace).withPlacement(config));
    }

}
package com.github.BismuthMod.init;

import com.github.BismuthMod.Bismuth;
import com.github.BismuthMod.blocks.*;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, Bismuth.MOD_ID);

    // Blocks

    public static final RegistryObject<Block> COPPER_ORE = BLOCKS.register("copper_ore", CopperOre::new);
    public static final RegistryObject<Block> PLATINUM_ORE = BLOCKS.register("platinum_ore", PlatinumOre::new);
    public static final RegistryObject<Block> COPPER_BLOCK = BLOCKS.register("copper_block", CopperBlock::new);
    public static final RegistryObject<Block> PLATINUM_BLOCK = BLOCKS.register("platinum_block", PlatinumBlock::new);
    //public static final RegistryObject<Block> CRUCIBLE = BLOCKS.register("crucible", CrucibleBlock::new);
    public static final RegistryObject<Block> DUNITE = BLOCKS.register("dunite", Dunite::new);
    public static final RegistryObject<Block> FLOOR_BASALT = BLOCKS.register("floor_basalt", FloorBasalt::new);
    public static final RegistryObject<Block> GABBRO = BLOCKS.register("gabbro", Gabbro::new);
    public static final RegistryObject<Block> NORITE = BLOCKS.register("norite", Norite::new);
    public static final RegistryObject<Block> BEIGE_GRANITE = BLOCKS.register("beige_granite", BeigeGranite::new);
    public static final RegistryObject<Block> BLACK_GRANITE = BLOCKS.register("black_granite", BlackGranite::new);
    public static final RegistryObject<Block> RED_GRANITE = BLOCKS.register("red_granite", RedGranite::new);
    public static final RegistryObject<Block> WHITE_GRANITE = BLOCKS.register("white_granite", WhiteGranite::new);
    public static final RegistryObject<Block> YELLOW_GRANITE = BLOCKS.register("yellow_granite", YellowGranite::new);
    public static final RegistryObject<Block> LIMESTONED = BLOCKS.register("limestoned", LimestoneD::new);
    public static final RegistryObject<Block> LIMESTONEL = BLOCKS.register("limestonel", LimestoneL::new);
    public static final RegistryObject<Block> LIMESTONEB = BLOCKS.register("limestoneb", LimestoneB::new);
    public static final RegistryObject<Block> LIMESTONEK = BLOCKS.register("limestonek", LimestoneK::new);
    public static final RegistryObject<Block> LIMESTONEM = BLOCKS.register("limestonem", LimestoneM::new);
    public static final RegistryObject<Block> LIMESTONER = BLOCKS.register("limestoner", LimestoneR::new);
    public static final RegistryObject<Block> LIMESTONET = BLOCKS.register("limestonet", LimestoneT::new);
    public static final RegistryObject<Block> POLISHED_FLOOR_BASALT = BLOCKS.register("polished_floor_basalt", PolishedFloorBasalt::new);
    public static final RegistryObject<Block> POLISHED_BLACK_GRANITE = BLOCKS.register("polished_black_granite", PolishedBlackGranite::new);
    public static final RegistryObject<Block> POLISHED_BLUE_GRANITE = BLOCKS.register("polished_blue_granite", PolishedBlueGranite::new);
    public static final RegistryObject<Block> POLISHED_BROWN_GRANITE = BLOCKS.register("polished_brown_granite", PolishedBrownGranite::new);
    public static final RegistryObject<Block> POLISHED_CYAN_GRANITE = BLOCKS.register("polished_cyan_granite", PolishedCyanGranite::new);
    public static final RegistryObject<Block> POLISHED_GRAY_GRANITE = BLOCKS.register("polished_gray_granite", PolishedGrayGranite::new);
    public static final RegistryObject<Block> POLISHED_GREEN_GRANITE = BLOCKS.register("polished_green_granite", PolishedGreenGranite::new);
    public static final RegistryObject<Block> POLISHED_MAGENTA_GRANITE = BLOCKS.register("polished_magenta_granite", PolishedMagentaGranite::new);
    public static final RegistryObject<Block> POLISHED_ORANGE_GRANITE = BLOCKS.register("polished_orange_granite", PolishedOrangeGranite::new);
    public static final RegistryObject<Block> POLISHED_PINK_GRANITE = BLOCKS.register("polished_pink_granite", PolishedPinkGranite::new);
    public static final RegistryObject<Block> POLISHED_PURPLE_GRANITE = BLOCKS.register("polished_purple_granite", PolishedPurpleGranite::new);
    public static final RegistryObject<Block> POLISHED_RED_GRANITE = BLOCKS.register("polished_red_granite", PolishedRedGranite::new);
    public static final RegistryObject<Block> POLISHED_WHITE_GRANITE = BLOCKS.register("polished_white_granite", PolishedWhiteGranite::new);
    public static final RegistryObject<Block> POLISHED_YELLOW_GRANITE = BLOCKS.register("polished_yellow_granite", PolishedYellowGranite::new);
    public static final RegistryObject<Block> CLAYR = BLOCKS.register("clayr", ClayR::new);
    public static final RegistryObject<Block> DIRTA = BLOCKS.register("dirta", DirtA::new);
    public static final RegistryObject<Block> DIRTU = BLOCKS.register("dirtu", DirtU::new);
    public static final RegistryObject<Block> LARGE_QUARTZ_CRYSTAL = BLOCKS.register("large_quartz_crystal", LargeQuartzCrystal::new);
    public static final RegistryObject<Block> SANDY_DIRT = BLOCKS.register("sandy_dirt", SandyDirt::new);
    public static final RegistryObject<Block> SCHIST = BLOCKS.register("schist", Schist::new);
    public static final RegistryObject<Block> SHALEH = BLOCKS.register("shaleh", ShaleH::new);
    public static final RegistryObject<Block> SHALEA = BLOCKS.register("shalea", ShaleA::new);
    public static final RegistryObject<Block> LUNAR_REGOLITH = BLOCKS.register("lunar_regolith", LunarRegolith::new);
}
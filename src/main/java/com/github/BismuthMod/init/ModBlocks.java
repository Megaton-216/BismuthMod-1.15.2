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
    public static final RegistryObject<Block> COPPER_BLOCK = BLOCKS.register("copper_block", CopperBlock::new);
    public static final RegistryObject<Block> COPPER_ORE = BLOCKS.register("copper_ore", CopperOre::new);
    public static final RegistryObject<Block> CRUCIBLE = BLOCKS.register("crucible", CrucibleBlock::new);
    public static final RegistryObject<Block> GABBRO = BLOCKS.register("gabbro", Gabbro::new);
    public static final RegistryObject<Block> DUNITE = BLOCKS.register("dunite", Dunite::new);
    public static final RegistryObject<Block> FLOOR_BASALT = BLOCKS.register("floor_basalt", FloorBasalt::new);
    public static final RegistryObject<Block> YELLOW_GRANITE = BLOCKS.register("yellow_granite", YellowGranite::new);
    public static final RegistryObject<Block> POLISHED_FLOOR_BASALT = BLOCKS.register("polished_floor_basalt", PolishedFloorBasalt::new);
    public static final RegistryObject<Block> POLISHED_ORANGE_GRANITE = BLOCKS.register("polished_orange_granite", PolishedOrangeGranite::new);
    //public static final RegistryObject<Block> POLISHED_BEIGE_GRANITE = BLOCKS.register("polished_beige_granite", PolishedBeigeGranite::new);
    public static final RegistryObject<Block> POLISHED_YELLOW_GRANITE = BLOCKS.register("polished_yellow_granite", PolishedYellowGranite::new);
    public static final RegistryObject<Block> POLISHED_BROWN_GRANITE = BLOCKS.register("polished_brown_granite", PolishedBrownGranite::new);
    public static final RegistryObject<Block> POLISHED_GREEN_GRANITE = BLOCKS.register("polished_green_granite", PolishedGreenGranite::new);
    public static final RegistryObject<Block> POLISHED_BLUE_GRANITE = BLOCKS.register("polished_blue_granite", PolishedBlueGranite::new);
    public static final RegistryObject<Block> POLISHED_GRAY_GRANITE = BLOCKS.register("polished_gray_granite", PolishedGrayGranite::new);
    public static final RegistryObject<Block> POLISHED_WHITE_GRANITE = BLOCKS.register("polished_white_granite", PolishedWhiteGranite::new);
    public static final RegistryObject<Block> POLISHED_PINK_GRANITE = BLOCKS.register("polished_pink_granite", PolishedPinkGranite::new);
    public static final RegistryObject<Block> POLISHED_PURPLE_GRANITE = BLOCKS.register("polished_purple_granite", PolishedPurpleGranite::new);
    public static final RegistryObject<Block> POLISHED_RED_GRANITE = BLOCKS.register("polished_red_granite", PolishedRedGranite::new);
    public static final RegistryObject<Block> POLISHED_BLACK_GRANITE = BLOCKS.register("polished_black_granite", PolishedBlackGranite::new);
    public static final RegistryObject<Block> POLISHED_CYAN_GRANITE = BLOCKS.register("polished_cyan_granite", PolishedCyanGranite::new);
    public static final RegistryObject<Block> POLISHED_MAGENTA_GRANITE = BLOCKS.register("polished_magenta_granite", PolishedMagentaGranite::new);
}

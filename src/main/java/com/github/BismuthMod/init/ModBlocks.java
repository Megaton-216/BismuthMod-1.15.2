package com.github.BismuthMod.init;

import com.github.BismuthMod.Bismuth;
import com.github.BismuthMod.blocks.*;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
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
    public static final RegistryObject<Block> BLACK_GRANITE = BLOCKS.register("black_granite", BlackGranite::new);
    public static final RegistryObject<Block> BROWN_GRANITE = BLOCKS.register("brown_granite", BrownGranite::new);
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
    public static final RegistryObject<Block> LIMESTONED_BRICKS = BLOCKS.register("limestoned_bricks", LimestoneDBricks::new);
    public static final RegistryObject<Block> LIMESTONEL_BRICKS = BLOCKS.register("limestonel_bricks", LimestoneLBricks::new);
    public static final RegistryObject<Block> LIMESTONEB_BRICKS = BLOCKS.register("limestoneb_bricks", LimestoneBBricks::new);
    public static final RegistryObject<Block> LIMESTONEK_BRICKS = BLOCKS.register("limestonek_bricks", LimestoneKBricks::new);
    public static final RegistryObject<Block> LIMESTONEM_BRICKS = BLOCKS.register("limestonem_bricks", LimestoneMBricks::new);
    public static final RegistryObject<Block> LIMESTONER_BRICKS = BLOCKS.register("limestoner_bricks", LimestoneRBricks::new);
    public static final RegistryObject<Block> LIMESTONET_BRICKS = BLOCKS.register("limestonet_bricks", LimestoneTBricks::new);
    public static final RegistryObject<Block> LIMESTONED_BRICK_STAIRS = BLOCKS.register("limestoned_brick_stairs",
            () -> new StairsBlock(() -> ModBlocks.LIMESTONED_BRICKS.get().getDefaultState(), Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5f, 6.0f)
                    .sound(SoundType.STONE)
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> LIMESTONEL_BRICK_STAIRS = BLOCKS.register("limestonel_brick_stairs",
            () -> new StairsBlock(() -> ModBlocks.LIMESTONEL_BRICKS.get().getDefaultState(), Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5f, 6.0f)
                    .sound(SoundType.STONE)
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> LIMESTONEB_BRICK_STAIRS = BLOCKS.register("limestoneb_brick_stairs",
            () -> new StairsBlock(() -> ModBlocks.LIMESTONEB_BRICKS.get().getDefaultState(), Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5f, 6.0f)
                    .sound(SoundType.STONE)
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> LIMESTONEK_BRICK_STAIRS = BLOCKS.register("limestonek_brick_stairs",
            () -> new StairsBlock(() -> ModBlocks.LIMESTONEK_BRICKS.get().getDefaultState(), Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5f, 6.0f)
                    .sound(SoundType.STONE)
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> LIMESTONEM_BRICK_STAIRS = BLOCKS.register("limestonem_brick_stairs",
            () -> new StairsBlock(() -> ModBlocks.LIMESTONEM_BRICKS.get().getDefaultState(), Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5f, 6.0f)
                    .sound(SoundType.STONE)
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> LIMESTONER_BRICK_STAIRS = BLOCKS.register("limestoner_brick_stairs",
            () -> new StairsBlock(() -> ModBlocks.LIMESTONER_BRICKS.get().getDefaultState(), Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5f, 6.0f)
                    .sound(SoundType.STONE)
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> LIMESTONET_BRICK_STAIRS = BLOCKS.register("limestonet_brick_stairs",
            () -> new StairsBlock(() -> ModBlocks.LIMESTONET_BRICKS.get().getDefaultState(), Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5f, 6.0f)
                    .sound(SoundType.STONE)
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> LIMESTONED_BRICK_SLAB = BLOCKS.register("limestoned_brick_slab",
            () -> new SlabBlock(Block.Properties.from(ModBlocks.LIMESTONED_BRICKS.get())));
    public static final RegistryObject<Block> LIMESTONEL_BRICK_SLAB = BLOCKS.register("limestonel_brick_slab",
            () -> new SlabBlock(Block.Properties.from(ModBlocks.LIMESTONEL_BRICKS.get())));
    public static final RegistryObject<Block> LIMESTONEB_BRICK_SLAB = BLOCKS.register("limestoneb_brick_slab",
            () -> new SlabBlock(Block.Properties.from(ModBlocks.LIMESTONEB_BRICKS.get())));
    public static final RegistryObject<Block> LIMESTONEK_BRICK_SLAB = BLOCKS.register("limestonek_brick_slab",
            () -> new SlabBlock(Block.Properties.from(ModBlocks.LIMESTONEK_BRICKS.get())));
    public static final RegistryObject<Block> LIMESTONEM_BRICK_SLAB = BLOCKS.register("limestonem_brick_slab",
            () -> new SlabBlock(Block.Properties.from(ModBlocks.LIMESTONEM_BRICKS.get())));
    public static final RegistryObject<Block> LIMESTONER_BRICK_SLAB = BLOCKS.register("limestoner_brick_slab",
            () -> new SlabBlock(Block.Properties.from(ModBlocks.LIMESTONER_BRICKS.get())));
    public static final RegistryObject<Block> LIMESTONET_BRICK_SLAB = BLOCKS.register("limestonet_brick_slab",
            () -> new SlabBlock(Block.Properties.from(ModBlocks.LIMESTONET_BRICKS.get())));
    public static final RegistryObject<WallBlock> LIMESTONED_BRICK_WALL = BLOCKS.register("limestoned_brick_wall",
            () -> new WallBlock(Block.Properties.from(Blocks.BRICK_WALL)));
    public static final RegistryObject<WallBlock> LIMESTONEL_BRICK_WALL = BLOCKS.register("limestonel_brick_wall",
            () -> new WallBlock(Block.Properties.from(Blocks.BRICK_WALL)));
    public static final RegistryObject<WallBlock> LIMESTONEB_BRICK_WALL = BLOCKS.register("limestoneb_brick_wall",
            () -> new WallBlock(Block.Properties.from(Blocks.BRICK_WALL)));
    public static final RegistryObject<WallBlock> LIMESTONEK_BRICK_WALL = BLOCKS.register("limestonek_brick_wall",
            () -> new WallBlock(Block.Properties.from(Blocks.BRICK_WALL)));
    public static final RegistryObject<WallBlock> LIMESTONEM_BRICK_WALL = BLOCKS.register("limestonem_brick_wall",
            () -> new WallBlock(Block.Properties.from(Blocks.BRICK_WALL)));
    public static final RegistryObject<WallBlock> LIMESTONER_BRICK_WALL = BLOCKS.register("limestoner_brick_wall",
            () -> new WallBlock(Block.Properties.from(Blocks.BRICK_WALL)));
    public static final RegistryObject<WallBlock> LIMESTONET_BRICK_WALL = BLOCKS.register("limestonet_brick_wall",
            () -> new WallBlock(Block.Properties.from(Blocks.BRICK_WALL)));
    public static final RegistryObject<Block> POLISHED_FLOOR_BASALT = BLOCKS.register("polished_floor_basalt", PolishedFloorBasalt::new);
    public static final RegistryObject<Block> POLISHED_BLACK_GRANITE = BLOCKS.register("polished_black_granite", PolishedBlackGranite::new);
    public static final RegistryObject<Block> POLISHED_BLUE_GRANITE = BLOCKS.register("polished_blue_granite", PolishedBlueGranite::new);
    public static final RegistryObject<Block> POLISHED_BROWN_GRANITE = BLOCKS.register("polished_brown_granite", PolishedBrownGranite::new);
    public static final RegistryObject<Block> POLISHED_CYAN_GRANITE = BLOCKS.register("polished_cyan_granite", PolishedCyanGranite::new);
    public static final RegistryObject<Block> POLISHED_GRAY_GRANITE = BLOCKS.register("polished_gray_granite", PolishedGrayGranite::new);
    public static final RegistryObject<Block> POLISHED_GREEN_GRANITE = BLOCKS.register("polished_green_granite", PolishedGreenGranite::new);
    public static final RegistryObject<Block> POLISHED_MAGENTA_GRANITE = BLOCKS.register("polished_magenta_granite", PolishedMagentaGranite::new);
    public static final RegistryObject<Block> POLISHED_ORANGE_GRANITE = BLOCKS.register("polished_orange_granite", PolishedOrangeGranite::new);
    public static final RegistryObject<Block> POLISHED_PURPLE_GRANITE = BLOCKS.register("polished_purple_granite", PolishedPurpleGranite::new);
    public static final RegistryObject<Block> POLISHED_RED_GRANITE = BLOCKS.register("polished_red_granite", PolishedRedGranite::new);
    public static final RegistryObject<Block> POLISHED_WHITE_GRANITE = BLOCKS.register("polished_white_granite", PolishedWhiteGranite::new);
    public static final RegistryObject<Block> POLISHED_YELLOW_GRANITE = BLOCKS.register("polished_yellow_granite", PolishedYellowGranite::new);
    public static final RegistryObject<Block> POLISHED_FLOOR_BASALT_STAIRS = BLOCKS.register("polished_floor_basalt_stairs",
            () -> new StairsBlock(() -> ModBlocks.POLISHED_FLOOR_BASALT.get().getDefaultState(), Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5f, 6.0f)
                    .sound(SoundType.STONE)
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> POLISHED_BLACK_GRANITE_STAIRS = BLOCKS.register("polished_black_granite_stairs",
            () -> new StairsBlock(() -> ModBlocks.POLISHED_BLACK_GRANITE.get().getDefaultState(), Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5f, 6.0f)
                    .sound(SoundType.STONE)
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> POLISHED_BLUE_GRANITE_STAIRS = BLOCKS.register("polished_blue_granite_stairs",
            () -> new StairsBlock(() -> ModBlocks.POLISHED_BLUE_GRANITE.get().getDefaultState(), Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5f, 6.0f)
                    .sound(SoundType.STONE)
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> POLISHED_BROWN_GRANITE_STAIRS = BLOCKS.register("polished_brown_granite_stairs",
            () -> new StairsBlock(() -> ModBlocks.POLISHED_BROWN_GRANITE.get().getDefaultState(), Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5f, 6.0f)
                    .sound(SoundType.STONE)
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> POLISHED_CYAN_GRANITE_STAIRS = BLOCKS.register("polished_cyan_granite_stairs",
            () -> new StairsBlock(() -> ModBlocks.POLISHED_CYAN_GRANITE.get().getDefaultState(), Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5f, 6.0f)
                    .sound(SoundType.STONE)
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> POLISHED_GRAY_GRANITE_STAIRS = BLOCKS.register("polished_gray_granite_stairs",
            () -> new StairsBlock(() -> ModBlocks.POLISHED_GRAY_GRANITE.get().getDefaultState(), Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5f, 6.0f)
                    .sound(SoundType.STONE)
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> POLISHED_GREEN_GRANITE_STAIRS = BLOCKS.register("polished_green_granite_stairs",
            () -> new StairsBlock(() -> ModBlocks.POLISHED_GREEN_GRANITE.get().getDefaultState(), Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5f, 6.0f)
                    .sound(SoundType.STONE)
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> POLISHED_MAGENTA_GRANITE_STAIRS = BLOCKS.register("polished_magenta_granite_stairs",
            () -> new StairsBlock(() -> ModBlocks.POLISHED_MAGENTA_GRANITE.get().getDefaultState(), Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5f, 6.0f)
                    .sound(SoundType.STONE)
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> POLISHED_ORANGE_GRANITE_STAIRS = BLOCKS.register("polished_orange_granite_stairs",
            () -> new StairsBlock(() -> ModBlocks.POLISHED_ORANGE_GRANITE.get().getDefaultState(), Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5f, 6.0f)
                    .sound(SoundType.STONE)
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> POLISHED_PURPLE_GRANITE_STAIRS = BLOCKS.register("polished_purple_granite_stairs",
            () -> new StairsBlock(() -> ModBlocks.POLISHED_PURPLE_GRANITE.get().getDefaultState(), Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5f, 6.0f)
                    .sound(SoundType.STONE)
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> POLISHED_RED_GRANITE_STAIRS = BLOCKS.register("polished_red_granite_stairs",
            () -> new StairsBlock(() -> ModBlocks.POLISHED_RED_GRANITE.get().getDefaultState(), Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5f, 6.0f)
                    .sound(SoundType.STONE)
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> POLISHED_WHITE_GRANITE_STAIRS = BLOCKS.register("polished_white_granite_stairs",
            () -> new StairsBlock(() -> ModBlocks.POLISHED_WHITE_GRANITE.get().getDefaultState(), Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5f, 6.0f)
                    .sound(SoundType.STONE)
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> POLISHED_YELLOW_GRANITE_STAIRS = BLOCKS.register("polished_yellow_granite_stairs",
            () -> new StairsBlock(() -> ModBlocks.POLISHED_YELLOW_GRANITE.get().getDefaultState(), Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5f, 6.0f)
                    .sound(SoundType.STONE)
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)));
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
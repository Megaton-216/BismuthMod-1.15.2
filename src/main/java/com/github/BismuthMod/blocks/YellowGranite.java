package com.github.BismuthMod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class YellowGranite extends Block {

    public YellowGranite() {
        super(Properties.create(Material.ROCK)
                .hardnessAndResistance(1.5f, 6.0f)
                .sound(SoundType.STONE)
                .harvestLevel(1)
                .harvestTool(ToolType.PICKAXE));
                //.setRequiresTool());
    }
}
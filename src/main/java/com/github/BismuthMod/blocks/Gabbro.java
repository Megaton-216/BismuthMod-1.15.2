package com.github.BismuthMod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class Gabbro extends Block {

    public Gabbro() {
        super(Properties.create(Material.ROCK)
                .hardnessAndResistance(2.0f, 6.0f)
                .sound(SoundType.STONE)
                .harvestLevel(2)
                .harvestTool(ToolType.PICKAXE));
                //.setRequiresTool());
    }
}

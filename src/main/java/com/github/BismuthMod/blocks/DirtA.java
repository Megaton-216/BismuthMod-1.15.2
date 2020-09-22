package com.github.BismuthMod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class DirtA extends Block {

    public DirtA() {
        super(Properties.create(Material.EARTH)
                .hardnessAndResistance(0.5f, 0.5f)
                .sound(SoundType.GROUND)
                .harvestLevel(0)
                .harvestTool(ToolType.SHOVEL));
                //.setRequiresTool());
    }
}

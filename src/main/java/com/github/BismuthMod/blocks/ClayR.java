package com.github.BismuthMod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class ClayR extends Block {

    public ClayR() {
        super(Properties.create(Material.CLAY)
                .hardnessAndResistance(0.6f, 0.6f)
                .sound(SoundType.GROUND)
                .harvestLevel(0)
                .harvestTool(ToolType.SHOVEL));
                //.setRequiresTool());
    }
}

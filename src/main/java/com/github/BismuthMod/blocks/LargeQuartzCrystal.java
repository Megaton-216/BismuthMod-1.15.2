package com.github.BismuthMod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.GlassBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;

public class LargeQuartzCrystal extends GlassBlock {

    public LargeQuartzCrystal() {
        super(Properties.create(Material.ROCK)
                .hardnessAndResistance(3.0f, 3.0f)
                .sound(SoundType.STONE)
                .harvestLevel(2)
                .harvestTool(ToolType.PICKAXE));
        //.setRequiresTool()););
    }

    @OnlyIn(Dist.CLIENT)
    public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return -1.0F;
    }

    public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
        return true;
    }

    public boolean causesSuffocation(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return false;
    }

    public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return true;
    }

    public boolean canEntitySpawn(BlockState state, IBlockReader worldIn, BlockPos pos, EntityType<?> type) {
        return false;
    }

    public boolean isSideInvisible(BlockState state, BlockState adjacentBlockState, Direction side) {
        return adjacentBlockState.getBlock() == this || super.isSideInvisible(state, adjacentBlockState, side);
    }

    @Deprecated
    public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
        if (state.isOpaqueCube(worldIn, pos)) {
            return worldIn.getMaxLightLevel();
        } else {
            return state.propagatesSkylightDown(worldIn, pos) ? 0 : 1;
        }
    }

    @Deprecated
    public boolean isTransparent(BlockState state) {
        return true;
    }

    public boolean isVariableOpacity() {
        return true;
    }
}

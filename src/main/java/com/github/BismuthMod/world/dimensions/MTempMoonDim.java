package com.github.BismuthMod.world.dimensions;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.ChunkGenerator;

public class MTempMoonDim extends Dimension {

    public MTempMoonDim(World world, DimensionType type) {
        super(world, type , 0.0f);
    }

    @Override
    public ChunkGenerator<?> createChunkGenerator() {
        return new TempChunkGenerator(world,
                new TempBiomeProvider(new TempBiomeProviderSettings(this.world.getWorldInfo())),
                new TempGenSettings());
    }

    private static final ResourceLocation MOON_SKY_TEXTURES = new ResourceLocation("textures/environment/moon_sky.png");
    private TextureManager textureManager;
    private Minecraft mc;

    private void setSkyRenderer(MatrixStack matrixStackIn) {

    }

    @Override
    public BlockPos findSpawn(ChunkPos chunkPosIn, boolean checkValid) {
        return null;
    }

    @Override
    public BlockPos findSpawn(int posX, int posZ, boolean checkValid) {
        return null;
    }

    @Override
    public float calculateCelestialAngle(long worldTime, float partialTicks) {
         ;int j = 6000;
        float f1 = (j + partialTicks) / 24000.0f - 0.25f;
        if (f1 < 0.0f) {
            f1 += 1.0f;
        }

        if (f1 > 1.0f) {
            f1 -= 1.0f;
        }

        float f2 = f1;
        f1 = 1.0f - (float) ((Math.cos(f1 * Math.PI) + 1.0d) / 2.0d);
        f1 = f2 + (f1 - f2) / 3.0f;
        return f1;
    }

    public Vector3f getFogColor() {
        return new Vector3f(0, 0, 0);
    }

    @Override
    public boolean isSkyColored() {
        return false;
    }

    @Override
    public boolean isSurfaceWorld() {
        return false;
    }

    @Override
    public Vec3d getFogColor(float celestialAngle, float partialTicks) {
        return Vec3d.ZERO;
    }

    @Override
    public boolean canRespawnHere() {
        return true;
    }

    @Override
    public boolean doesXZShowFog(int x, int z) {
        return false;
    }

    @Override
    public int getActualHeight() {
        return 256;
    }
}

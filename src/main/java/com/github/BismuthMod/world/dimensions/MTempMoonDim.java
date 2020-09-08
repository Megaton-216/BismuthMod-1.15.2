package com.github.BismuthMod.world.dimensions;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
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

    public void WorldRenderer(Minecraft mcIn) {
        this.mc = mcIn;
        this.textureManager = mcIn.getTextureManager();
    }

    private void renderSkyMoon(MatrixStack matrixStackIn) {
        RenderSystem.disableAlphaTest();
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.depthMask(false);
        this.textureManager.bindTexture(MOON_SKY_TEXTURES);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferbuilder = tessellator.getBuffer();

        for(int i = 0; i < 6; ++i) {
            matrixStackIn.push();
            if (i == 1) {
                matrixStackIn.rotate(Vector3f.XP.rotationDegrees(90.0F));
            }

            if (i == 2) {
                matrixStackIn.rotate(Vector3f.XP.rotationDegrees(-90.0F));
            }

            if (i == 3) {
                matrixStackIn.rotate(Vector3f.XP.rotationDegrees(180.0F));
            }

            if (i == 4) {
                matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90.0F));
            }

            if (i == 5) {
                matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(-90.0F));
            }

            Matrix4f matrix4f = matrixStackIn.getLast().getMatrix();
            bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
            bufferbuilder.pos(matrix4f, -100.0F, -100.0F, -100.0F).tex(0.0F, 0.0F).color(40, 40, 40, 255).endVertex();
            bufferbuilder.pos(matrix4f, -100.0F, -100.0F, 100.0F).tex(0.0F, 16.0F).color(40, 40, 40, 255).endVertex();
            bufferbuilder.pos(matrix4f, 100.0F, -100.0F, 100.0F).tex(16.0F, 16.0F).color(40, 40, 40, 255).endVertex();
            bufferbuilder.pos(matrix4f, 100.0F, -100.0F, -100.0F).tex(16.0F, 0.0F).color(40, 40, 40, 255).endVertex();
            tessellator.draw();
            matrixStackIn.pop();
        }

        RenderSystem.depthMask(true);
        RenderSystem.enableTexture();
        RenderSystem.disableBlend();
        RenderSystem.enableAlphaTest();
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

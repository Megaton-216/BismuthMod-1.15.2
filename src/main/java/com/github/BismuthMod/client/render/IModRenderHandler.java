package com.github.BismuthMod.client.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.world.ClientWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@FunctionalInterface
public interface IModRenderHandler {

    @OnlyIn(Dist.CLIENT)
    void render(int ticks, float partialTicks, ClientWorld world, Minecraft mc);
}

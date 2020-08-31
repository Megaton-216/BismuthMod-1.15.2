package com.github.BismuthMod.client.render;

import com.github.BismuthMod.Bismuth;
import com.github.BismuthMod.client.model.CapybaraModel;
import com.github.BismuthMod.entities.CapybaraEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;

public class CapybaraRenderer extends MobRenderer<CapybaraEntity, EntityModel<CapybaraEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(Bismuth.MOD_ID, "textures/entity/capybara.png");


    public CapybaraRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new CapybaraModel<>(), 0.7f);
    }

    @Override
    public ResourceLocation getEntityTexture(CapybaraEntity entity) {
        return TEXTURE;
    }
}

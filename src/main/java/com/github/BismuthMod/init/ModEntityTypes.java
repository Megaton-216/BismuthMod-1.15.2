package com.github.BismuthMod.init;

import com.github.BismuthMod.Bismuth;
import com.github.BismuthMod.entities.CapybaraEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {

    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES, Bismuth.MOD_ID);

    //Entity Types
    public static final RegistryObject<EntityType<CapybaraEntity>> CAPYBARA = ENTITY_TYPES.register("capybara", () -> EntityType.Builder.create(CapybaraEntity::new, EntityClassification.CREATURE)
    .size(1.0f, 1.0f)
    .build(new ResourceLocation(Bismuth.MOD_ID, "capybara").toString()));
}

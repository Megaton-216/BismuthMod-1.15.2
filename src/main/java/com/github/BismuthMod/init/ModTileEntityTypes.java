package com.github.BismuthMod.init;

import com.github.BismuthMod.Bismuth;
import com.github.BismuthMod.tileentity.CrucibleTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntityTypes {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = new DeferredRegister<>(
            ForgeRegistries.TILE_ENTITIES, Bismuth.MOD_ID);

    public static final RegistryObject<TileEntityType<CrucibleTileEntity>> CRUCIBLE = TILE_ENTITY_TYPES.register("crucible",
            () -> TileEntityType.Builder.create(CrucibleTileEntity::new, ModBlocks.CRUCIBLE.get()).build(null));
}

package com.github.BismuthMod.init;

import com.github.BismuthMod.Bismuth;
import com.github.BismuthMod.container.CrucibleContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModContainerTypes {

    public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = new DeferredRegister<>(
            ForgeRegistries.CONTAINERS, Bismuth.MOD_ID);

    public static final RegistryObject<ContainerType<CrucibleContainer>> CRUCIBLE = CONTAINER_TYPES
            .register("crucible", () -> IForgeContainerType.create(CrucibleContainer::new));
}

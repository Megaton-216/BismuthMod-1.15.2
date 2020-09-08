package com.github.BismuthMod.util;

import com.github.BismuthMod.Bismuth;
import com.github.BismuthMod.init.ModDimensions;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.world.RegisterDimensionsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Bismuth.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEventBusSubscriber {

    @SubscribeEvent
    public static void registerDimensions(final RegisterDimensionsEvent event) {
        if (DimensionType.byName(Bismuth.TEMP_DIM_TYPE) == null) {
            DimensionManager.registerDimension(Bismuth.TEMP_DIM_TYPE, ModDimensions.TEMP_MOONDIM.get(), null,
                    true);
        }
        Bismuth.LOGGER.info("Dimensions Registered!");
    }
}

package com.github.BismuthMod;

import com.github.BismuthMod.init.*;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.github.BismuthMod.world.DisableVanilOres.removeVanillaOre;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("bismuth")
@Mod.EventBusSubscriber(modid = Bismuth.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Bismuth
{
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "bismuth";

    public static final ResourceLocation TEMP_DIM_TYPE = new ResourceLocation(MOD_ID, "bismuth");

    public Bismuth() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        ModBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModBiomes.BIOMES.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModDimensions.MOD_DIMENSIONS.register(FMLJavaModLoadingContext.get().getModEventBus());
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public static void onRegisterBiomes(final RegistryEvent.Register<Biome> event) {
        ModBiomes.registerBiomes();
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        //LOGGER.info("HELLO FROM PREINIT");
        //LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
        //removeVanillaOre();
    }

    private void doClientStuff(final FMLClientSetupEvent event) { }

    public static final ItemGroup TAB_0 = new ItemGroup("bismuthTab_0") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.COPPER_INGOT.get());
        }
    };
    public static final ItemGroup TAB_1 = new ItemGroup("bismuthTab_1") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.COPPER_ORE_ITEM.get());
        }
    };
    public static final ItemGroup TAB_2 = new ItemGroup("bismuthTab_2") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.COPPER_AXE.get());
        }
    };
    public static final ItemGroup TAB_3 = new ItemGroup("bismuthTab_3") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.COPPER_SWORD.get());
        }
    };
}

package com.github.BismuthMod.util;

import com.github.BismuthMod.Bismuth;
import com.github.BismuthMod.init.ModBlocks;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;


@Mod.EventBusSubscriber(modid = Bismuth.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        //ScreenManager.registerFactory(ModContainerTypes.EXAMPLE_CHEST.get(), ExampleChestScreen::new);
        //ScreenManager.registerFactory(ModContainerTypes.ITEM_PEDESTAL.get(), ItemPedestalScreen::new);
        //ScreenManager.registerFactory(ModContainerTypes.CRUCIBLE.get(), CrucibleScreen::new);
        RenderTypeLookup.setRenderLayer(ModBlocks.LARGE_QUARTZ_CRYSTAL.get(), RenderType.getTranslucent());

        //RenderTypeLookup.setRenderLayer(BlockInit.JAZZ_SAPLING.get(), RenderType.getCutout());
        //RenderTypeLookup.setRenderLayer(BlockInit.EXAMPLE_CROP.get(), RenderType.getCutout());
        //RenderTypeLookup.setRenderLayer(BlockInit.JAZZ_DOOR.get(), RenderType.getCutout());

        //RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.EXAMPLE_ENTITY.get(), ExampleEntityRender::new);

        //ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.ITEM_PEDESTAL.get(), ItemPedestalRenderer::new);

        /*ItemInit.CRYSTAL.get().addPropertyOverride(new ResourceLocation(TutorialMod.MOD_ID, "count"),
                new IItemPropertyGetter() {

                    @Override
                    public float call(ItemStack stack, World worldIn, LivingEntity entityIn) {
                        switch (stack.getCount()) {
                            case 1:
                                return 0.25f;
                            case 2:
                                return 0.5f;
                            case 3:
                                return 0.75f;
                            case 4:
                                return 1.0f;
                            default:
                                return 0.0f;
                        }
                    }
                });*/
    }
}
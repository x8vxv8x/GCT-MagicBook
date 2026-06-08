package com.smd.gctmagicbook.client;

import com.smd.gctmagicbook.GCTMagicBook;
import com.smd.gctmagicbook.Tags;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(modid = Tags.MOD_ID, value = Side.CLIENT)
public class ModelRegistrationHandler {

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        GCTMagicBook.modulemanager.onModelRegistry(event);
    }
}

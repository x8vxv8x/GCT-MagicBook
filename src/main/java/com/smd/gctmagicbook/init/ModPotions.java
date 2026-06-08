package com.smd.gctmagicbook.init;

import com.smd.gctmagicbook.Tags;
import com.smd.gctmagicbook.tools.magicbook.effect.ThermalHeatPotion;
import net.minecraft.potion.Potion;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Tags.MOD_ID)
public final class ModPotions {

    public static final Potion GAUSS_HEAT = new ThermalHeatPotion();

    private ModPotions() {
    }

    @SubscribeEvent
    public static void registerPotions(RegistryEvent.Register<Potion> event) {
        event.getRegistry().register(GAUSS_HEAT);
    }
}

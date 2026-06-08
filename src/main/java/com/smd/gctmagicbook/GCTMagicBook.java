package com.smd.gctmagicbook;

import com.smd.gctmagicbook.tools.magicbook.gui.MagicBookGuiHandler;
import com.smd.gctmagicbook.plugin.ModuleManager;
import com.smd.gctmagicbook.plugin.Modules;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.smd.gctmagicbook.proxy.CommonProxy;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod.EventBusSubscriber
@Mod(name = Tags.MOD_NAME,
     modid = Tags.MOD_ID,
     version = Tags.VERSION,
     dependencies = "after:tconstruct;after:plustic;after:tconevo",
     guiFactory = "com.smd.gctmagicbook.gui.TConGuiFactory")
public class GCTMagicBook {

    public static final Logger LOGGER = LogManager.getLogger(Tags.MOD_NAME);
    public static Configuration config;

    public static ModuleManager modulemanager;

    @Mod.Instance(Tags.MOD_ID)
    public static GCTMagicBook instance;

    @SidedProxy(serverSide = "com.smd.gctmagicbook.proxy.CommonProxy",
                clientSide = "com.smd.gctmagicbook.proxy.ClientProxy")

    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        config = new Configuration(event.getSuggestedConfigurationFile());
        modulemanager = new ModuleManager(config);
        Modules.registerAll(modulemanager);
        modulemanager.setupConfig();
        modulemanager.preInitActiveModules(event);

        proxy.preInit();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        modulemanager.initActiveModules(event);
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new MagicBookGuiHandler());
        proxy.initToolGuis();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        modulemanager.postInitActiveModules(event);
        proxy.initToolGuis();
    }
}

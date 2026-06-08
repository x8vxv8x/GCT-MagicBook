package com.smd.gctmagicbook.plugin;

import com.smd.gctmagicbook.plugin.magicbook.magicbook;

public final class Modules {

    private Modules() {
    }

    public static void registerAll(ModuleManager manager) {
        manager.registerModule(new magicbook());
    }
}

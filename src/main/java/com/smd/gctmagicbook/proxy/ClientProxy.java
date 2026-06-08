package com.smd.gctmagicbook.proxy;

import com.smd.gctmagicbook.plugin.magicbook.magicbook;
import net.minecraft.item.Item;
import slimeknights.tconstruct.common.ModelRegisterUtil;
import slimeknights.tconstruct.library.TinkerRegistryClient;
import slimeknights.tconstruct.library.client.ToolBuildGuiInfo;
import slimeknights.tconstruct.library.tools.IToolPart;
import slimeknights.tconstruct.library.tools.ToolCore;

public class ClientProxy extends CommonProxy {

    @Override
    public void initToolGuis() {
        if (magicbook.magicbook != null) {
            ToolBuildGuiInfo magicbookInfo = new ToolBuildGuiInfo(magicbook.magicbook);
            magicbookInfo.addSlotPosition(33 - 10 - 2, 42 + 10); // handle
            magicbookInfo.addSlotPosition(33 + 10 + 16 - 2, 42 - 10 + 16); // head 1
            magicbookInfo.addSlotPosition(33 + 10 - 16 - 2, 42 - 10 - 16); // head 2
            magicbookInfo.addSlotPosition(33 + 13 - 2, 42 - 13); // binding
            TinkerRegistryClient.addToolBuilding(magicbookInfo);
        }
    }

    @Override
    public void registerToolModel(ToolCore tc) {
        ModelRegisterUtil.registerToolModel(tc);
    }

    @Override
    public <T extends Item & IToolPart> void registerToolPartModel(T part) {
        ModelRegisterUtil.registerPartModel(part);
    }
}

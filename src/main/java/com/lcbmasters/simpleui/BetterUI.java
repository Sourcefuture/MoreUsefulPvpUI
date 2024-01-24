package com.lcbmasters.simpleui;

import com.lcbmasters.simpleui.Mod.ModManager;
import com.lcbmasters.simpleui.eventHandle.PlayerClickEvent;
import com.lcbmasters.simpleui.eventHandle.TextRenderEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = BetterUI.MODID, version = BetterUI.VERSION)
public class BetterUI {
    public static final String MODID = "betterUI";
    public static final String VERSION = "1.0.2";

    public static ModManager modManager;

    @EventHandler
    public void init(FMLInitializationEvent event) {
        modManager = new ModManager();
        modManager.load();

        FMLCommonHandler.instance().bus().register(new PlayerClickEvent());
        FMLCommonHandler.instance().bus().register(new TextRenderEvent());
    }
}

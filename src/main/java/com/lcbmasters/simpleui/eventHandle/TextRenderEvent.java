package com.lcbmasters.simpleui.eventHandle;

import com.lcbmasters.simpleui.BetterUI;
import com.lcbmasters.simpleui.Mod.Mod;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class TextRenderEvent {


    @SubscribeEvent
    public void onRenderGameOverlay(RenderGameOverlayEvent.Post event) {
        if (event.type != RenderGameOverlayEvent.ElementType.HELMET || Minecraft.getMinecraft().gameSettings.showDebugInfo) {
            return;
        }

        BetterUI.modManager.getEnableMods().forEach(Mod::draw);
    }
}

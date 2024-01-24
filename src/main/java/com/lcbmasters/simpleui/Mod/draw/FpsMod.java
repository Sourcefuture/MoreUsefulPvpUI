package com.lcbmasters.simpleui.Mod.draw;

import com.lcbmasters.simpleui.BetterUI;
import com.lcbmasters.simpleui.Mod.Mod;
import com.lcbmasters.simpleui.utils.DrawUtil;
import net.minecraft.client.Minecraft;

import java.awt.*;

public class FpsMod extends Mod {
    public FpsMod() {
        super("Fps", true);
    }

    public void draw() {
        DrawUtil drawUtil = new DrawUtil();
        int fps = Minecraft.getDebugFPS();
        if (!BetterUI.modManager.getByClass(PingMod.class).isEnable()) {
            drawUtil.drawTextLowerRight("FPS", DrawUtil.getStringWidth(fps + "FPS "), 0, new Color(62, 255, 255).getRGB(), 3);
            drawUtil.drawTextLowerRight(String.valueOf(fps), DrawUtil.getStringWidth(fps), 0, new Color(255, 255, 255).getRGB(), 3);
        } else {
            drawUtil.drawTextLowerRight("FPS", DrawUtil.getStringWidth(fps + "FPS ") + 31, 0, new Color(62, 255, 255).getRGB(), 3);
            drawUtil.drawTextLowerRight(String.valueOf(fps), DrawUtil.getStringWidth(fps) + 31, 0, new Color(255, 255, 255).getRGB(), 3);

        }

    }
}

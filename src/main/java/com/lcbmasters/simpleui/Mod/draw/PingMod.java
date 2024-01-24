package com.lcbmasters.simpleui.Mod.draw;

import com.lcbmasters.simpleui.Mod.Mod;
import com.lcbmasters.simpleui.utils.DrawUtil;
import net.minecraft.client.Minecraft;

import java.awt.*;

public class PingMod extends Mod {
    public PingMod() {
        super("Ping", true);
    }

    public void draw() {
        int responseTime = 0;
        try {
            responseTime = Minecraft.getMinecraft().thePlayer.sendQueue.getPlayerInfo(Minecraft.getMinecraft().thePlayer.getUniqueID()).getResponseTime();
            DrawUtil drawUtil = new DrawUtil();
            drawUtil.drawTextLowerRight("Ping", DrawUtil.getStringWidth(responseTime + "Ping "), 0, new Color(62, 255, 255).getRGB(), 3);
            drawUtil.drawTextLowerRight(String.valueOf(responseTime), DrawUtil.getStringWidth(String.valueOf(responseTime)), 0, new Color(255, 255, 255).getRGB(), 3);
        } catch (NullPointerException ignored) {
        }
    }
}

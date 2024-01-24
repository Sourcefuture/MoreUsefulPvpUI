package com.lcbmasters.simpleui.Mod.draw;

import com.lcbmasters.simpleui.Mod.Mod;
import com.lcbmasters.simpleui.utils.DrawUtil;
import net.minecraft.client.Minecraft;

import java.awt.*;

public class ComboDisplayMod extends Mod {
    public ComboDisplayMod() {
        super("Combo", true);
    }

    private static int comboCount;
    private static long lastHitTime;

    public static void setLastHitTime(long lastHitTime) {
        ComboDisplayMod.lastHitTime = lastHitTime;
    }

    public static void addComboCount() {
        comboCount++;
    }


    public void draw() {
        if (System.currentTimeMillis() - lastHitTime > 2000L || Minecraft.getMinecraft().thePlayer.hurtTime > 0) {
            comboCount = 0;
        }

        DrawUtil drawUtil = new DrawUtil();
        drawUtil.drawTextTopLeft("Combo: ", 50, 2, new Color(62, 255, 255).getRGB(), 4);
        drawUtil.drawTextTopLeft(String.valueOf(comboCount / 2), 50 + DrawUtil.getStringWidth("Combo: "), 2, new Color(255, 255, 255).getRGB(), 4);

    }
}




package com.lcbmasters.simpleui.Mod.draw;

import com.lcbmasters.simpleui.Mod.Mod;
import com.lcbmasters.simpleui.utils.DrawUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;

import java.awt.*;

public class SelfAppearanceMod extends Mod {
    public SelfAppearanceMod() {
        super("SelfAppearance", true);
    }

    @Override
    public void draw() {
        if (Minecraft.getMinecraft().gameSettings.showDebugInfo) {
            return;
        }

        EntityLivingBase player = Minecraft.getMinecraft().thePlayer;
        if (player != null) {
            DrawUtil drawUtil = new DrawUtil();
            DrawUtil.drawEntityOnScreen(25, 90, 30, 0, 0, player);
            drawUtil.drawTextTopLeft("Hi! ", 50, 0, new Color(62, 255, 255).getRGB(), 7);
            drawUtil.drawTextTopLeft(Minecraft.getMinecraft().thePlayer.getName(), 64, 0, new Color(255, 255, 255).getRGB(), 7);
        }
    }
}

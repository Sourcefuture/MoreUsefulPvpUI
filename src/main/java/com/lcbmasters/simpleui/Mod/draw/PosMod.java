package com.lcbmasters.simpleui.Mod.draw;

import com.lcbmasters.simpleui.Mod.Mod;
import com.lcbmasters.simpleui.utils.DataProcessing;
import com.lcbmasters.simpleui.utils.DrawUtil;
import net.minecraft.client.Minecraft;

import java.awt.*;
import java.math.BigDecimal;


public class PosMod extends Mod {
    public PosMod() {
        super("Pos", true);
    }

    public void draw() {
        DrawUtil drawUtil = new DrawUtil();

        String posX = DataProcessing.posManage(new BigDecimal(Minecraft.getMinecraft().thePlayer.posX).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
        String posY = DataProcessing.posManage(new BigDecimal(Minecraft.getMinecraft().thePlayer.posY).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
        String posZ = DataProcessing.posManage(new BigDecimal(Minecraft.getMinecraft().thePlayer.posZ).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());

        drawUtil.drawTextTopLeft("X:", 0, 0, new Color(62, 255, 255).getRGB(), 0);
        drawUtil.drawTextTopLeft(posX, 7, 0, new Color(255, 255, 255).getRGB(), 0);
        drawUtil.drawTextTopLeft("Y:", 0, 0, new Color(62, 255, 255).getRGB(), 1);
        drawUtil.drawTextTopLeft(posY, 7, 0, new Color(255, 255, 255).getRGB(), 1);
        drawUtil.drawTextTopLeft("Z:", 0, 0, new Color(62, 255, 255).getRGB(), 2);
        drawUtil.drawTextTopLeft(posZ, 7, 0, new Color(255, 255, 255).getRGB(), 2);


    }

}


package com.lcbmasters.simpleui.Mod.draw;

import com.lcbmasters.simpleui.Mod.Mod;
import com.lcbmasters.simpleui.utils.DrawUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;

import java.awt.*;
import java.math.BigDecimal;

public class DirectionMod extends Mod {
    public DirectionMod() {
        super("Direction", true);
    }

    public void draw() {
        DrawUtil drawUtil = new DrawUtil();
        EnumFacing horizontalFacing = Minecraft.getMinecraft().thePlayer.getHorizontalFacing();

        double rotationYaw = new BigDecimal(MathHelper.wrapAngleTo180_float(Minecraft.getMinecraft().thePlayer.rotationYaw)).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
        double rotationPitch = new BigDecimal(Minecraft.getMinecraft().thePlayer.rotationPitch).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();

        drawUtil.drawTextTopLeft("Facing:", 50, 0, new Color(62, 255, 255).getRGB(), 0);
        drawUtil.drawTextTopLeft(String.valueOf(horizontalFacing), 50 + DrawUtil.getStringWidth("Facing: "), 0, new Color(255, 255, 255).getRGB(), 0);

        drawUtil.drawTextTopLeft("( ", 50 + DrawUtil.getStringWidth("Facing:  " + horizontalFacing), 0, new Color(62, 255, 255).getRGB(), 0);
        drawUtil.drawTextTopLeft(String.valueOf(rotationYaw), 50 + DrawUtil.getStringWidth("Facing:   " + horizontalFacing), 0, new Color(255, 255, 255).getRGB(), 0);
        drawUtil.drawTextTopLeft(" / ", 50 + DrawUtil.getStringWidth("Facing:   " + horizontalFacing + rotationYaw), 0, new Color(255, 246, 0).getRGB(), 0);
        drawUtil.drawTextTopLeft(String.valueOf(rotationPitch), 50 + DrawUtil.getStringWidth("Facing:    / " + horizontalFacing + rotationYaw), 0, new Color(255, 255, 255).getRGB(), 0);
        drawUtil.drawTextTopLeft(" )", 50 + DrawUtil.getStringWidth("Facing:   / " + horizontalFacing + rotationYaw + rotationPitch), 0, new Color(62, 255, 255).getRGB(), 0);


    }
}

package com.lcbmasters.simpleui.Mod.draw;

import com.lcbmasters.simpleui.Mod.Mod;
import com.lcbmasters.simpleui.utils.DrawUtil;
import net.minecraft.client.Minecraft;

import java.awt.*;
import java.lang.reflect.Field;

public class SpeedMod extends Mod {
    public SpeedMod() {
        super("Speed", true);
    }

    private static float getTimerSpeed() {
        try {
            // 获取 Minecraft 实例
            Object minecraft = Minecraft.getMinecraft();
            // 获取 Timer 字段
            Field timerField = minecraft.getClass().getDeclaredField("timer");
            // 设置访问权限，使得私有字段可以被读取
            timerField.setAccessible(true);
            // 获取 timer 对象
            Object timer = timerField.get(minecraft);
            // 获取 timerSpeed 字段
            Field timerSpeedField = timer.getClass().getDeclaredField("timerSpeed");
            // 设置访问权限
            timerSpeedField.setAccessible(true);
            // 获取 timerSpeed 属性的值
            return timerSpeedField.getFloat(timer);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            return 0.0f; // 返回默认值或者适当的错误处理
        }
    }


    private double calculateBPS() {
        double bps = (Math.hypot(Minecraft.getMinecraft().thePlayer.posX - Minecraft.getMinecraft().thePlayer.prevPosX, Minecraft.getMinecraft().thePlayer.posZ - Minecraft.getMinecraft().thePlayer.prevPosZ) * getTimerSpeed()) * 20;
        return Math.round(bps * 100.0) / 100.0;
    }

    public void draw() {
        DrawUtil drawUtil = new DrawUtil();
        drawUtil.drawTextTopLeft("Speed:", 50, 0, new Color(62, 255, 255).getRGB(), 2);
        drawUtil.drawTextTopLeft(String.valueOf(this.calculateBPS()), 50 + DrawUtil.getStringWidth("Speed: "), 0, new Color(255, 255, 255).getRGB(), 2);

    }
}

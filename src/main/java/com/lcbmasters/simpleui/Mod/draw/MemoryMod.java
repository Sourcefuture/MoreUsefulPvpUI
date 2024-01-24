package com.lcbmasters.simpleui.Mod.draw;

import com.lcbmasters.simpleui.Mod.Mod;
import com.lcbmasters.simpleui.utils.DrawUtil;

import java.awt.*;

public class MemoryMod extends Mod {

    public MemoryMod() {
        super("Memory", true);
    }

    public void draw() {
        DrawUtil drawUtil = new DrawUtil();

        long i = Runtime.getRuntime().maxMemory();
        long j = Runtime.getRuntime().totalMemory();
        long k = Runtime.getRuntime().freeMemory();
        long l = j - k;

        drawUtil.drawTextLowerRight("Memory", DrawUtil.getStringWidth("Memory " + drawUtil.bytesToMb(l) + "/" + drawUtil.bytesToMb(i) + "MB"), 0, new Color(62, 255, 255).getRGB(), 2);
        drawUtil.drawTextLowerRight(drawUtil.bytesToMb(l) + "/" + drawUtil.bytesToMb(i) + "MB", DrawUtil.getStringWidth(drawUtil.bytesToMb(l) + "/" + drawUtil.bytesToMb(i) + "MB"), 0, new Color(255, 255, 255).getRGB(), 2);

    }


}


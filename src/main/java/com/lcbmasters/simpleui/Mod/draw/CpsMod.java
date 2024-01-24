package com.lcbmasters.simpleui.Mod.draw;

import com.lcbmasters.simpleui.Mod.Mod;
import com.lcbmasters.simpleui.utils.DrawUtil;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CpsMod extends Mod {
    public CpsMod() {
        super("Direction", true);
    }

    private static List<Long> leftClicks = new ArrayList<Long>();
    private static List<Long> leftToRemove = new ArrayList<Long>();
    private static List<Long> rightClicks = new ArrayList<Long>();
    private static List<Long> rightToRemove = new ArrayList<Long>();

    public static void addLeftClick() {
        leftClicks.add(Long.valueOf(System.currentTimeMillis() + 1000L));
    }

    public static void addRightClick() {
        rightClicks.add(Long.valueOf(System.currentTimeMillis() + 1000L));
    }

    public void draw() {
        DrawUtil drawUtil = new DrawUtil();

        for (Iterator<Long> iterator = leftClicks.iterator(); iterator.hasNext(); ) {
            long l = ((Long) iterator.next()).longValue();
            if (System.currentTimeMillis() > l)
                leftToRemove.add(Long.valueOf(l));
        }
        leftClicks.removeAll(leftToRemove);

        for (Iterator<Long> iterator = rightClicks.iterator(); iterator.hasNext(); ) {
            long l = ((Long) iterator.next()).longValue();
            if (System.currentTimeMillis() > l)
                rightToRemove.add(Long.valueOf(l));
        }
        rightClicks.removeAll(rightToRemove);

        drawUtil.drawTextTopLeft("CPS:", 50, 2, new Color(62, 255, 255).getRGB(), 5);
        drawUtil.drawTextTopLeft(String.valueOf(leftClicks.size()), 50 + DrawUtil.getStringWidth("CPS: "), 2, new Color(255, 255, 255).getRGB(), 5);
        drawUtil.drawTextTopLeft(" | ", 50 + DrawUtil.getStringWidth("CPS:" + leftClicks.size()), 2, new Color(62, 255, 255).getRGB(), 5);
        drawUtil.drawTextTopLeft(String.valueOf(rightClicks.size()), 50 + DrawUtil.getStringWidth("CPS: | " + leftClicks.size()), 2, new Color(255, 255, 255).getRGB(), 5);

    }
}

package com.lcbmasters.simpleui.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;

import java.math.BigDecimal;

public class DataProcessing {

    private ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());

// ---------------------------------------------------------------------------------------------------------------------

    public static String posManage(double pos) {
        if (pos == 1.0E+7) {
            return "10000000.0";
        }
        if (pos == 2.0E+7) {
            return "20000000.0";
        }
        if (pos == 3.0E+7) {
            return "30000000.0";
        }
        return new BigDecimal(String.valueOf(pos)).toString();
    }


    public int getHeight() {
        return sr.getScaledHeight();
    }

    public int getWidth() {
        return sr.getScaledWidth();
    }

}



package com.lcbmasters.simpleui.Mod.draw;

import com.lcbmasters.simpleui.Mod.Mod;
import com.lcbmasters.simpleui.utils.DrawUtil;

import java.awt.*;
import java.util.Calendar;

public class TimeMod extends Mod {

    public TimeMod() {
        super("Time", true);
    }

    public void draw() {
        DrawUtil drawUtil = new DrawUtil();

        //Get Time
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int date = calendar.get(Calendar.DATE);

        String minute = "";
        if (calendar.get(Calendar.MINUTE) < 10) {
            minute = "0" + calendar.get(Calendar.MINUTE);
        } else {
            minute = String.valueOf(calendar.get(Calendar.MINUTE));
        }

        String hour = "";
        if (calendar.get(Calendar.HOUR_OF_DAY) < 10) {
            hour = "0" + calendar.get(Calendar.HOUR_OF_DAY);
        } else {
            hour = String.valueOf(calendar.get(Calendar.HOUR_OF_DAY));
        }

        String time1 = month + "/" + date + "/" + year;
        String time2 = hour + ":" + minute;
        //Get Time End

        drawUtil.drawTextLowerRight("Time ", DrawUtil.getStringWidth("Time " + time1 + "  " + time2), 0, new Color(62, 255, 255).getRGB(), 1);
        drawUtil.drawTextLowerRight(time2 + " " + time1, DrawUtil.getStringWidth(time1 + "  " + time2), 0, new Color(255, 255, 255).getRGB(), 1);

    }
}


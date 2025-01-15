package com.lcbmasters.simpleui.Mod.draw;

import com.lcbmasters.simpleui.Mod.Mod;
import com.lcbmasters.simpleui.utils.DataProcessing;
import com.lcbmasters.simpleui.utils.DrawUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.item.ItemStack;

import java.awt.*;

public class ArmourMod extends Mod {
    public ArmourMod() {
        super("Armour", true);
    }

    private static void renderPercentWithColorForArmour(int percent, int x, int y) {
        FontRenderer font = Minecraft.getMinecraft().fontRendererObj;
        if (percent > 90) {
            font.drawStringWithShadow(String.valueOf(percent), x + 20, y + 3, new Color(0, 255, 0).getRGB());
        } else if (percent > 80) {
            font.drawStringWithShadow(String.valueOf(percent), x + 20, y + 3, new Color(91, 255, 0).getRGB());
        } else if (percent > 70) {
            font.drawStringWithShadow(String.valueOf(percent), x + 20, y + 3, new Color(137, 255, 0).getRGB());
        } else if (percent > 60) {
            font.drawStringWithShadow(String.valueOf(percent), x + 20, y + 3, new Color(215, 255, 0).getRGB());
        } else if (percent > 50) {
            font.drawStringWithShadow(String.valueOf(percent), x + 20, y + 3, new Color(255, 245, 0).getRGB());
        } else if (percent > 40) {
            font.drawStringWithShadow(String.valueOf(percent), x + 20, y + 3, new Color(255, 186, 0).getRGB());
        } else if (percent > 30) {
            font.drawStringWithShadow(String.valueOf(percent), x + 20, y + 3, new Color(255, 125, 0).getRGB());
        } else if (percent > 20) {
            font.drawStringWithShadow(String.valueOf(percent), x + 20, y + 3, new Color(255, 76, 0).getRGB());
        } else if (percent > 10) {
            font.drawStringWithShadow(String.valueOf(percent), x + 20, y + 3, new Color(255, 44, 0).getRGB());
        } else if (percent > 0) {
            font.drawStringWithShadow(String.valueOf(percent), x + 20, y + 3, new Color(255, 0, 0).getRGB());
        }
        font.drawStringWithShadow("%", x + 21 + font.getStringWidth(String.valueOf(percent)), y + 3, new Color(62, 255, 255).getRGB());
    }

    public void draw() {
        DataProcessing dataProcessing = new DataProcessing();
        int x = dataProcessing.getWidth() / 2 - 133;
        int y = dataProcessing.getHeight() - 15;
        int nullNumber = 0;

        for (ItemStack inventory : Minecraft.getMinecraft().thePlayer.getInventory()) {
            try {
                if (!(inventory.getMaxDamage() == 0)) {
                    int percentDurability = (int) ((double) (inventory.getMaxDamage() - inventory.getItemDamage()) / (double) inventory.getMaxDamage() * 100);
                    this.renderPercentWithColorForArmour(percentDurability, x, y);
                }
                DrawUtil.renderItem(inventory, x, y, 0, 0);

                y -= 20;
            } catch (NullPointerException e) {
                nullNumber++;
                y -= 20;
            }
        }

        ItemStack heldItem = Minecraft.getMinecraft().thePlayer.getHeldItem();
        if (!(heldItem == null)) {
            if (nullNumber == 4) {
                x = dataProcessing.getWidth() / 2 - 133;
                y = dataProcessing.getHeight() - 18;
            }
            double maxDurability = heldItem.getMaxDamage();
            int percentDurability = (int) ((double) (heldItem.getMaxDamage() - heldItem.getItemDamage()) / maxDurability * 100);
            if (!(maxDurability == 0)) {
                this.renderPercentWithColorForArmour(percentDurability, x, y);
                DrawUtil.renderItem(heldItem, x, y, 0, 0);
            } else {
                DrawUtil.renderItem(heldItem, x, y, 15, -6);
            }
        }
    }
}

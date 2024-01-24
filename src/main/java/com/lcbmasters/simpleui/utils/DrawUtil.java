package com.lcbmasters.simpleui.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;

import java.awt.*;
import java.math.BigDecimal;

public class DrawUtil {
    public static void drawRect(int x, int y, int width, int height, int color) {
        Gui.drawRect(x, y, x + width, y + height, color);
    }

    public long bytesToMb(long bytes) {
        return bytes / 1024L / 1024L;
    }

    public void drawTextTopLeft(String text, float x, float y, int color, int lineNumber) {
        FontRenderer font = Minecraft.getMinecraft().fontRendererObj;
        font.drawStringWithShadow(text, 3 + x, 1 + y + font.FONT_HEIGHT * lineNumber, color);
    }

    public void drawTextLowerRight(String text, float x, float y, int color, int lineNumber) {
        FontRenderer font = Minecraft.getMinecraft().fontRendererObj;
        DataProcessing dataProcessing = new DataProcessing();
        font.drawStringWithShadow(text, dataProcessing.getWidth() - x - 1, dataProcessing.getHeight() - y - font.FONT_HEIGHT * lineNumber - 2, color);
    }

    public static float getStringWidth(String text) {
        FontRenderer font = Minecraft.getMinecraft().fontRendererObj;
        return font.getStringWidth(text);
    }

    public static float getStringWidth(int text) {
        FontRenderer font = Minecraft.getMinecraft().fontRendererObj;
        return font.getStringWidth(String.valueOf(text));
    }

    public static void drawEntityOnScreen(int posX, int posY, int scale, float mouseX, float mouseY, EntityLivingBase ent) {
        GlStateManager.enableColorMaterial();
        GlStateManager.pushMatrix();
        GlStateManager.translate((float) posX, (float) posY, 50.0F);
        GlStateManager.scale((float) (-scale), (float) scale, (float) scale);
        GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
        float f = ent.renderYawOffset;
        float f1 = ent.rotationYaw;
        float f2 = ent.rotationPitch;
        float f3 = ent.prevRotationYawHead;
        float f4 = ent.rotationYawHead;
        GlStateManager.rotate(135.0F, 0.0F, 1.0F, 0.0F);
        RenderHelper.enableStandardItemLighting();
        GlStateManager.rotate(-135.0F, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(-((float) Math.atan((double) (mouseY / 40.0F))) * 20.0F, 1.0F, 0.0F, 0.0F);
        ent.renderYawOffset = (float) Math.atan((double) (mouseX / 40.0F)) * 20.0F;
        ent.rotationYaw = (float) Math.atan((double) (mouseX / 40.0F)) * 40.0F;
        ent.rotationPitch = -((float) Math.atan((double) (mouseY / 40.0F))) * 20.0F;
        ent.rotationYawHead = ent.rotationYaw;
        ent.prevRotationYawHead = ent.rotationYaw;
        GlStateManager.translate(0.0F, 0.0F, 0.0F);
        RenderManager rendermanager = Minecraft.getMinecraft().getRenderManager();
        rendermanager.setPlayerViewY(180.0F);
        rendermanager.setRenderShadow(false);

        //Update the draw method in order not to draw the hit box;
        rendermanager.doRenderEntity(ent, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F, true);
        // rendermanager.renderEntityWithPosYaw(ent, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);

        rendermanager.setRenderShadow(true);
        ent.renderYawOffset = f;
        ent.rotationYaw = f1;
        ent.rotationPitch = f2;
        ent.prevRotationYawHead = f3;
        ent.rotationYawHead = f4;
        GlStateManager.popMatrix();
        RenderHelper.disableStandardItemLighting();
        GlStateManager.disableRescaleNormal();
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.disableTexture2D();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
    }

    public static void drawHealth(EntityLivingBase entity, int x, int y) {
        double health = new BigDecimal(entity.getHealth() + entity.getAbsorptionAmount()).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
        if (health > 20) {
            Minecraft.getMinecraft().fontRendererObj.drawString(String.valueOf(health), x, y, new Color(248, 0, 255).getRGB());
        } else if (health > 15) {
            Minecraft.getMinecraft().fontRendererObj.drawString(String.valueOf(health), x, y, new Color(23, 255, 0).getRGB());
        } else if (health > 10) {
            Minecraft.getMinecraft().fontRendererObj.drawString(String.valueOf(health), x, y, new Color(254, 255, 0).getRGB());
        } else if (health > 5) {
            Minecraft.getMinecraft().fontRendererObj.drawString(String.valueOf(health), x, y, new Color(255, 143, 0).getRGB());
        } else {
            Minecraft.getMinecraft().fontRendererObj.drawString(String.valueOf(health), x, y, new Color(255, 0, 19).getRGB());
        }
    }

    public static void drawHealthWithShadow(EntityLivingBase entity, int x, int y) {
        double health = new BigDecimal(entity.getHealth() + entity.getAbsorptionAmount()).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
        if (health > 20) {
            Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(String.valueOf(health), x, y, new Color(248, 0, 255).getRGB());
        } else if (health > 15) {
            Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(String.valueOf(health), x, y, new Color(23, 255, 0).getRGB());
        } else if (health > 10) {
            Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(String.valueOf(health), x, y, new Color(254, 255, 0).getRGB());
        } else if (health > 5) {
            Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(String.valueOf(health), x, y, new Color(255, 143, 0).getRGB());
        } else {
            Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(String.valueOf(health), x, y, new Color(255, 0, 19).getRGB());
        }
    }
}

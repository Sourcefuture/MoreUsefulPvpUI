package com.lcbmasters.simpleui.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.math.BigDecimal;

public class DrawUtil {
    public static void renderBox(int x, int y, int width, int height, int color) {
        drawRect(x + 1, y, x + width - 1, y + height, color);
        drawRect(x, y + 1, x + 1, y + height - 1, color);
        drawRect(x + width - 1, y + 1, x + width, y + height - 1, color);
        drawRect(x + 1, y + 1, x + width - 1, y + 2, color);
        drawRect(x + 1, y + height - 2, x + width - 1, y + height - 1, color);
        drawRect(x + 1, y + 2, x + 2, y + height - 2, color);
        drawRect(x + width - 2, y + 2, x + width - 1, y + height - 2, color);
    }

    public static int colorRGB(int r, int g, int b) {
        return colorARGB(255, r, g, b);
    }

    public static int colorARGB(int a, int r, int g, int b) {
        return (a & 0xFF) << 24 | (r & 0xFF) << 16 | (g & 0xFF) << 8 | b & 0xFF;
    }

    public static void renderItem(ItemStack item, int x, int y, int xSkewing, int ySkewing) {
        GlStateManager.enableRescaleNormal();
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        RenderHelper.enableGUIStandardItemLighting();

        GlStateManager.enableBlend();
        GlStateManager.enableRescaleNormal();
        GlStateManager.pushMatrix();

        // 渲染物品
        Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(item, x, y);
        Minecraft.getMinecraft().getRenderItem().renderItemOverlayIntoGUI(Minecraft.getMinecraft().fontRendererObj, item, x + xSkewing, y + ySkewing, null);
        // 恢复渲染状态
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.disableBlend();
        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();

        RenderHelper.disableStandardItemLighting();
        GlStateManager.disableRescaleNormal();
        GlStateManager.disableBlend();
    }

//    public static void drawRect(int x, int y, int width, int height, int color) {
//        Gui.drawRect(x, y, x + width, y + height, color);
//    }
    public static void drawRect(int left, int top, int right, int bottom, int color) {
        if (left < right) {
            int j1 = left;
            left = right;
            right = j1;
        }
        if (top < bottom) {
            int j1 = top;
            top = bottom;
            bottom = j1;
        }
        float f3 = (color >> 24 & 0xFF) / 255.0F;
        float f = (color >> 16 & 0xFF) / 255.0F;
        float f1 = (color >> 8 & 0xFF) / 255.0F;
        float f2 = (color & 0xFF) / 255.0F;
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glColor4f(f, f1, f2, f3);
        worldrenderer.begin(7, DefaultVertexFormats.POSITION);
        worldrenderer.pos(left, bottom, 0.0D).endVertex();
        worldrenderer.pos(right, bottom, 0.0D).endVertex();
        worldrenderer.pos(right, top, 0.0D).endVertex();
        worldrenderer.pos(left, top, 0.0D).endVertex();
        tessellator.draw();
        GL11.glEnable(3553);
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
        font.drawStringWithShadow(text, dataProcessing.getWidth() - x - 1, dataProcessing.getHeight() - y - font.FONT_HEIGHT * lineNumber - 1, color);
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

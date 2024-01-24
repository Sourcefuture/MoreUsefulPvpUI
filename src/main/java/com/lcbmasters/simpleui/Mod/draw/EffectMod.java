package com.lcbmasters.simpleui.Mod.draw;


import com.lcbmasters.simpleui.Mod.Mod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;

import java.util.Collection;


public class EffectMod extends Mod {
    public EffectMod() {
        super("Effect", true);
    }

    public void draw() {
        Collection<PotionEffect> collection = Minecraft.getMinecraft().thePlayer.getActivePotionEffects();
        int i = 120;
        int j = 75;
        if (!collection.isEmpty()) {
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            GlStateManager.disableLighting();
            int l = 33;

            if (collection.size() > 5) {
                l = 132 / (collection.size() - 1);
            }

            for (PotionEffect potioneffect : Minecraft.getMinecraft().thePlayer.getActivePotionEffects()) {
                Potion potion = Potion.potionTypes[potioneffect.getPotionID()];
                GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
                final ResourceLocation inventoryBackground = new ResourceLocation("textures/gui/container/inventory.png");
                Minecraft.getMinecraft().getTextureManager().bindTexture(inventoryBackground);
                Gui gui = new Gui();

                if (potion.hasStatusIcon()) {
                    int i1 = potion.getStatusIconIndex();
                    gui.drawTexturedModalRect(i + 6, j + 7, 0 + i1 % 8 * 18, 198 + i1 / 8 * 18, 18, 18);
                }

                String s1 = I18n.format(potion.getName(), new Object[0]);

                if (potioneffect.getAmplifier() == 1) {
                    s1 = s1 + " " + I18n.format("enchantment.level.2", new Object[0]);
                } else if (potioneffect.getAmplifier() == 2) {
                    s1 = s1 + " " + I18n.format("enchantment.level.3", new Object[0]);
                } else if (potioneffect.getAmplifier() == 3) {
                    s1 = s1 + " " + I18n.format("enchantment.level.4", new Object[0]);
                }

                Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(s1, (float) (i + 10 + 18), (float) (j + 6), 16777215);
                String s = Potion.getDurationString(potioneffect);
                Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(s, (float) (i + 10 + 18), (float) (j + 6 + 10), 8355711);
                j += l;
            }
        }
    }
}



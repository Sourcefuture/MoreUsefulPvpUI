package com.lcbmasters.simpleui.Mod.draw;

import com.lcbmasters.simpleui.Mod.Mod;
import com.lcbmasters.simpleui.utils.DrawUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.util.BlockPos;
import java.awt.*;

public class BiomeMod extends Mod {
    public BiomeMod() {
        super("Biome", true);
    }

    public void draw() {
        String chunkName = Minecraft.getMinecraft().theWorld.getChunkFromBlockCoords(new BlockPos(Minecraft.getMinecraft().getRenderViewEntity().posX, Minecraft.getMinecraft().getRenderViewEntity().getEntityBoundingBox().minY, Minecraft.getMinecraft().getRenderViewEntity().posZ)).getBiome(new BlockPos(Minecraft.getMinecraft().getRenderViewEntity().posX, Minecraft.getMinecraft().getRenderViewEntity().getEntityBoundingBox().minY, Minecraft.getMinecraft().getRenderViewEntity().posZ), Minecraft.getMinecraft().theWorld.getWorldChunkManager()).biomeName;
        DrawUtil drawUtil = new DrawUtil();
        drawUtil.drawTextTopLeft("Biome:", 50, 0, new Color(62, 255, 255).getRGB(), 1);
        drawUtil.drawTextTopLeft(chunkName, 50 + DrawUtil.getStringWidth("Biome: "), 0, new Color(255, 255, 255).getRGB(), 1);

    }
}

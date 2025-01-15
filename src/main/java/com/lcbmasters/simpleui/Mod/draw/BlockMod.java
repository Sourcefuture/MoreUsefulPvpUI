package com.lcbmasters.simpleui.Mod.draw;

import com.lcbmasters.simpleui.Mod.Mod;
import com.lcbmasters.simpleui.utils.DataProcessing;
import com.lcbmasters.simpleui.utils.DrawUtil;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import java.awt.*;

public class BlockMod extends Mod {
    public BlockMod() {
        super("Block", true);
    }
    private final int maxDistance = 512;

    private static final Minecraft mc = Minecraft.getMinecraft();
    private static double calculateDistance(EntityPlayer player, BlockPos blockPos) {
        double dx = blockPos.getX() + 0.5 - player.posX; // 方块中心X
        double dy = blockPos.getY() + 0.5 - player.posY; // 方块中心Y
        double dz = blockPos.getZ() + 0.5 - player.posZ; // 方块中心Z
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    public void draw() {
        World world = mc.theWorld;
        EntityPlayer player = mc.thePlayer;

        if (world == null || mc.thePlayer == null) {
            return;
        }
        // 获取玩家视线的起点和方向
        Vec3 playerPos = mc.thePlayer.getPositionEyes(1.0F); // 玩家眼睛位置
        Vec3 lookVec = mc.thePlayer.getLookVec(); // 玩家视线方向
        // 计算射线的终点
        Vec3 rayEnd = playerPos.addVector(lookVec.xCoord * maxDistance, lookVec.yCoord * maxDistance, lookVec.zCoord * maxDistance);
        // 执行射线追踪
        MovingObjectPosition rayTraceResult = world.rayTraceBlocks(playerPos, rayEnd, false, true, false);

        if (rayTraceResult != null && rayTraceResult.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
            BlockPos blockPos = rayTraceResult.getBlockPos();
            Block block = world.getBlockState(blockPos).getBlock();
            IBlockState te = mc.theWorld.getBlockState(rayTraceResult.getBlockPos());
            ItemStack stack = te.getBlock().getPickBlock(rayTraceResult, (World)mc.theWorld, rayTraceResult.getBlockPos());

            // 打印方块信息
            DataProcessing dataProcessing = new DataProcessing();
            String localizedName = block.getLocalizedName();

            FontRenderer font = Minecraft.getMinecraft().fontRendererObj;
            //font.drawString(localizedName, dataProcessing.getWidth() - 50, 5, new Color(255, 255, 255).getRGB());
            int x = dataProcessing.getWidth() - (50 + (int) DrawUtil.getStringWidth(localizedName + String.valueOf(((int)calculateDistance(mc.thePlayer, blockPos)))));
            int y = 10;
            DrawUtil.renderBox(x, y, 40 + (int) DrawUtil.getStringWidth(localizedName + String.valueOf(((int)calculateDistance(mc.thePlayer, blockPos)))), 11 + mc.fontRendererObj.FONT_HEIGHT, DrawUtil.colorARGB(58, 0, 0, 0));
            mc.ingameGUI.drawString(mc.fontRendererObj, localizedName, x + 26, y + 6, DrawUtil.colorRGB(255, 255, 255));
            mc.ingameGUI.drawString(mc.fontRendererObj, " [" + String.valueOf(((int)calculateDistance(mc.thePlayer, blockPos))) + "]", x + 26 + (int) DrawUtil.getStringWidth(localizedName), y + 6, new Color(62, 255, 255).getRGB());
            RenderHelper.enableGUIStandardItemLighting();
            mc.getRenderItem().renderItemAndEffectIntoGUI(stack, x + 5, y + 2);
            RenderHelper.disableStandardItemLighting();
        }
        }
}

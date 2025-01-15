package com.lcbmasters.simpleui.Mod.draw;

import com.lcbmasters.simpleui.Mod.Mod;
import com.lcbmasters.simpleui.utils.DataProcessing;
import com.lcbmasters.simpleui.utils.DrawUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class InventoryMod extends Mod {
    public InventoryMod() {
        super("Inventory", true);
    }

    public void draw() {
        DataProcessing dataProcessing = new DataProcessing();
        int x = dataProcessing.getWidth() / 2 + 100;
        int y = dataProcessing.getHeight() - 59;

        ItemStack[] inventory = Minecraft.getMinecraft().thePlayer.inventory.mainInventory;
        for (int i = 9; i < 36; i++) {
            if (i == 18 || i == 27) {
                x = dataProcessing.getWidth() / 2 + 100;
                y = y + 20;
            }
            try {
                DrawUtil.renderItem(inventory[i], x, y, 0, 0);
                x += 19;
            } catch (NullPointerException e) {
                x += 19;
            }
        }
        if (!(isInventoryEmpty(Minecraft.getMinecraft().thePlayer))) {
            DrawUtil.renderBox(dataProcessing.getWidth() / 2 + 96, dataProcessing.getHeight() - 61, 176, 61, DrawUtil.colorARGB(58, 0, 0, 0));
        }
    }

    private static boolean isInventoryEmpty(EntityPlayer player) {
        IInventory inventory = player.inventory;  // 获取玩家背包

        // 遍历玩家背包中的所有槽位，检查是否有物品
        for (int i = 9; i < 36; i++) {
            ItemStack itemStack = inventory.getStackInSlot(i);  // 获取当前槽位的物品
            if (itemStack != null) {
                // 如果某个槽位中有物品，说明背包不为空
                return false;
            }
        }
        // 如果遍历完所有槽位都没有物品，背包为空
        return true;
    }
}




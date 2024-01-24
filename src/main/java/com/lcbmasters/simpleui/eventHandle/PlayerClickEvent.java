package com.lcbmasters.simpleui.eventHandle;

import com.lcbmasters.simpleui.Mod.draw.ComboDisplayMod;
import com.lcbmasters.simpleui.Mod.draw.CpsMod;
import com.lcbmasters.simpleui.Mod.draw.ReachDisplayMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PlayerClickEvent {
    @SubscribeEvent
    public void onAttackEntity(AttackEntityEvent event) {
        // 处理左键点击（攻击生物）
        // 获取攻击者
        EntityPlayer player = event.entityPlayer;

        // 获取被攻击的实体
        Entity targetEntity = event.target;
        ReachDisplayMod.setTargetEntity(targetEntity);

        // 判断是否为玩家成功攻击实体
        if (targetEntity instanceof EntityLivingBase && !targetEntity.isEntityInvulnerable(DamageSource.causePlayerDamage(player)) && !event.isCanceled()) {
            // 玩家成功攻击实体，增加 Combo 计数
            ComboDisplayMod.setLastHitTime(System.currentTimeMillis());
            ComboDisplayMod.addComboCount();
        }
    }

    @SubscribeEvent
    public void onMouseClick(MouseEvent event) {
        // 检测鼠标左键是否点击
        if (event.button == 0 && event.buttonstate) {
            // 在这里执行左键点击的逻辑
            CpsMod.addLeftClick();
        }

        // 检测鼠标右键是否点击
        if (event.button == 1 && event.buttonstate) {
            // 在这里执行右键点击的逻辑
            CpsMod.addRightClick();
        }
    }
}

package com.lcbmasters.simpleui.Mod.draw;

import com.lcbmasters.simpleui.Mod.Mod;
import com.lcbmasters.simpleui.utils.DrawUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;


import java.awt.*;
import java.math.BigDecimal;

public class ReachDisplayMod extends Mod {
    public ReachDisplayMod() {
        super("ReachDisplay", true);
    }

    private static Entity targetEntity;

    public static void setTargetEntity(Entity entity) {
        targetEntity = entity;
    }

    private double getReachDistanceFromEntity(Entity entity) {
        double maxSize = 20.0;
        AxisAlignedBB otherBB = entity.getEntityBoundingBox();
        float collisionBorderSize = entity.getCollisionBorderSize();
        AxisAlignedBB otherHitBox = otherBB.expand(collisionBorderSize, collisionBorderSize, collisionBorderSize);
        Vec3 eyePos = Minecraft.getMinecraft().thePlayer.getPositionEyes(1.0F);
        Vec3 lookPos = Minecraft.getMinecraft().thePlayer.getLook(1.0F);
        Vec3 adjustedPos = eyePos.addVector(lookPos.xCoord * maxSize, lookPos.yCoord * maxSize, lookPos.zCoord * maxSize);
        MovingObjectPosition movingObjectPosition = otherHitBox.calculateIntercept(eyePos, adjustedPos);
        if (movingObjectPosition == null) {
            return 0;
        }
        Vec3 otherEntityVec = movingObjectPosition.hitVec;
        return eyePos.distanceTo(otherEntityVec);
    }

    public void draw() {
        DrawUtil drawUtil = new DrawUtil();
        drawUtil.drawTextTopLeft("Reach:", 50, 2, new Color(62, 255, 255).getRGB(), 3);

        double reachDistanceFromEntity = 0;
        try {
            reachDistanceFromEntity = new BigDecimal(this.getReachDistanceFromEntity(targetEntity)).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
        } catch (NullPointerException ignored) {
        }

        drawUtil.drawTextTopLeft(String.valueOf(reachDistanceFromEntity), 50 + DrawUtil.getStringWidth("Reach: "), 2, new Color(255, 255, 255).getRGB(), 3);

    }

}

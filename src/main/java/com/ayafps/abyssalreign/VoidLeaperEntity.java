package com.ayafps.abyssalreign;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.*;
import net.minecraft.entity.effect.*;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.player.*;
import net.minecraft.particle.*;
import net.minecraft.server.world.*;
import net.minecraft.world.*;

public class VoidLeaperEntity extends AbyssMobEntity {

    public VoidLeaperEntity(EntityType<? extends PathAwareEntity> type, World world) {
        super(type, world);
        stats(28, 0.30, 8, 32, 3);
    }

    @Override
    protected void initGoals() {
        commonGoals();
    }

    @Override
    public void tick() {
        super.tick();
        if (getWorld().isClient) return;

        if (age % 70 == 0 && getTarget() != null) {
            double dx = getTarget().getX() - getX();
            double dz = getTarget().getZ() - getZ();
            double distance = Math.max(0.1, Math.sqrt(dx * dx + dz * dz));
            setVelocity(dx / distance * 0.9, 0.55, dz / distance * 0.9);
            velocityDirty = true;
        }
    }
}

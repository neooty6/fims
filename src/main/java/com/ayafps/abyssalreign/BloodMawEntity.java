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

public class BloodMawEntity extends AbyssMobEntity {

    public BloodMawEntity(EntityType<? extends PathAwareEntity> type, World world) {
        super(type, world);
        stats(45, 0.22, 9, 20, 5);
    }

    @Override
    protected void initGoals() {
        commonGoals();
    }

    @Override
    public void tick() {
        super.tick();
        if (getWorld().isClient) return;

        if (age % 90 == 0 && getTarget() != null) {
            tryAttack(getTarget());
        }
    }
}

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

public class GraveStalkerEntity extends AbyssMobEntity {

    public GraveStalkerEntity(EntityType<? extends PathAwareEntity> type, World world) {
        super(type, world);
        stats(18, 0.34, 5, 24, 2);
    }

    @Override
    protected void initGoals() {
        commonGoals();
    }

    @Override
    public void tick() {
        super.tick();
        if (getWorld().isClient) return;

        if (age % 80 == 0 && getTarget() != null) {
            setInvisible(true);
        }
        if (isInvisible() && age % 80 == 30) {
            setInvisible(false);
        }
    }
}

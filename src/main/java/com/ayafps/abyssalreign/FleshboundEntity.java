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

public class FleshboundEntity extends AbyssMobEntity {

    public FleshboundEntity(EntityType<? extends PathAwareEntity> type, World world) {
        super(type, world);
        stats(38, 0.26, 6, 26, 6);
    }

    @Override
    protected void initGoals() {
        commonGoals();
    }

    @Override
    public void tick() {
        super.tick();
        if (getWorld().isClient) return;

        if (getHealth() < getMaxHealth() * 0.35f && age % 100 == 0) {
            heal(5.0f);
        }
    }
}

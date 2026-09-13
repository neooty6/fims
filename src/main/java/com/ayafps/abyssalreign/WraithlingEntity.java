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

public class WraithlingEntity extends AbyssMobEntity {

    public WraithlingEntity(EntityType<? extends PathAwareEntity> type, World world) {
        super(type, world);
        stats(16, 0.30, 5, 30, 0);
    }

    @Override
    protected void initGoals() {
        commonGoals();
    }

    @Override
    public void tick() {
        super.tick();
        if (getWorld().isClient) return;

        setNoGravity(true);
    }
}

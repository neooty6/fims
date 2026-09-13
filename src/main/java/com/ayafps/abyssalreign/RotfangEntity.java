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

public class RotfangEntity extends AbyssMobEntity {

    public RotfangEntity(EntityType<? extends PathAwareEntity> type, World world) {
        super(type, world);
        stats(18, 0.31, 4, 20, 1);
    }

    @Override
    protected void initGoals() {
        commonGoals();
    }

    @Override
    public void tick() {
        super.tick();
        if (getWorld().isClient) return;

        if (age % 100 == 0 && getTarget() != null) {
            getTarget().addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 70, 0));
        }
    }
}

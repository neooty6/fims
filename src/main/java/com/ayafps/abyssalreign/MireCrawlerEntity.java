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

public class MireCrawlerEntity extends AbyssMobEntity {

    public MireCrawlerEntity(EntityType<? extends PathAwareEntity> type, World world) {
        super(type, world);
        stats(22, 0.34, 4.5, 22, 2);
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
            getTarget().addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 60, 1));
        }
    }
}

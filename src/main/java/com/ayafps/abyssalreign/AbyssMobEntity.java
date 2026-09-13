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

public abstract class AbyssMobEntity extends PathAwareEntity {

    protected AbyssMobEntity(EntityType<? extends PathAwareEntity> type, World world) {
        super(type, world);
    }

    protected void stats(double hp, double speed, double damage, double range, double armor) {
        getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue(hp);
        getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED).setBaseValue(speed);
        getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE).setBaseValue(damage);
        getAttributeInstance(EntityAttributes.GENERIC_FOLLOW_RANGE).setBaseValue(range);
        getAttributeInstance(EntityAttributes.GENERIC_ARMOR).setBaseValue(armor);
        setHealth((float) hp);
    }

    protected void commonGoals() {
        goalSelector.add(2, new MeleeAttackGoal(this, 1.15, true));
        goalSelector.add(7, new WanderAroundFarGoal(this, 0.8));
        goalSelector.add(8, new LookAtEntityGoal(this, PlayerEntity.class, 8));
        goalSelector.add(9, new LookAroundGoal(this));
        targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }
}

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

public class AbyssWardenEntity extends AbyssMobEntity {
    public AbyssWardenEntity(EntityType<? extends PathAwareEntity> type, World world) {
        super(type, world);
        stats(750, 0.21, 18, 48, 16);
        getAttributeInstance(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE).setBaseValue(1.0);
    }

    @Override
    protected void initGoals() {
        commonGoals();
    }

    @Override
    public void tick() {
        super.tick();
        if (getWorld().isClient) return;

        if (getWorld() instanceof ServerWorld serverWorld && age % 20 == 0) {
            serverWorld.spawnParticles(
                    ParticleTypes.PORTAL,
                    getX(), getY() + 2.2, getZ(),
                    12, 1.0, 1.5, 1.0, 0.08
            );
        }

        LivingEntity target = getTarget();
        if (target != null && age % 80 == 0) {
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 80, 1));
            target.damage(getDamageSources().mobAttack(this), 8.0f);
        }

        if (getHealth() < getMaxHealth() * 0.5f) {
            getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE).setBaseValue(22.0);
            if (age % 120 == 0) {
                heal(12.0f);
            }
        }
    }
}

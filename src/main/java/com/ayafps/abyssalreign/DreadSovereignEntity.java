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

public class DreadSovereignEntity extends AbyssMobEntity {
    public DreadSovereignEntity(EntityType<? extends PathAwareEntity> type, World world) {
        super(type, world);
        stats(500, 0.25, 14, 40, 12);
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

        if (getWorld() instanceof ServerWorld serverWorld && age % 30 == 0) {
            serverWorld.spawnParticles(
                    ParticleTypes.SOUL_FIRE_FLAME,
                    getX(), getY() + 2.0, getZ(),
                    8, 0.8, 1.2, 0.8, 0.02
            );
        }

        LivingEntity target = getTarget();
        if (target != null && age % 100 == 0) {
            target.damage(getDamageSources().mobAttack(this), 14.0f);
            double dx = target.getX() - getX();
            double dz = target.getZ() - getZ();
            double distance = Math.max(0.1, Math.sqrt(dx * dx + dz * dz));
            setVelocity(dx / distance * 0.7, 0.45, dz / distance * 0.7);
            velocityDirty = true;
        }

        if (getHealth() < getMaxHealth() * 0.3f) {
            getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE).setBaseValue(19.0);
        }
    }
}

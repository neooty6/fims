package com.ayafps.abyssalreign;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public final class ModEntities {
    private ModEntities() {}

    private static <T extends Entity> EntityType<T> register(
            String id, EntityType.Builder<T> builder) {
        return Registry.register(
                Registries.ENTITY_TYPE,
                new Identifier(AbyssalReign.MOD_ID, id),
                builder.build(id)
        );
    }

    private static <T extends MobEntity> EntityType<T> mob(
            String id, float width, float height, EntityType.EntityFactory<T> factory) {
        return register(id, EntityType.Builder.create(factory, SpawnGroup.MONSTER)
                .setDimensions(width, height)
                .maxTrackingRange(64)
                .trackingTickInterval(2));
    }

    public static final EntityType<GraveStalkerEntity> GRAVE_STALKER =
            mob("grave_stalker", 0.75f, 1.8f, GraveStalkerEntity::new);
    public static final EntityType<RotfangEntity> ROTFANG =
            mob("rotfang", 1.0f, 0.9f, RotfangEntity::new);
    public static final EntityType<HollowKnightEntity> HOLLOW_KNIGHT =
            mob("hollow_knight", 0.8f, 2.2f, HollowKnightEntity::new);
    public static final EntityType<BloodMawEntity> BLOOD_MAW =
            mob("blood_maw", 1.45f, 1.45f, BloodMawEntity::new);
    public static final EntityType<WraithlingEntity> WRAITHLING =
            mob("wraithling", 0.7f, 1.4f, WraithlingEntity::new);
    public static final EntityType<MireCrawlerEntity> MIRE_CRAWLER =
            mob("mire_crawler", 1.2f, 0.8f, MireCrawlerEntity::new);
    public static final EntityType<VoidLeaperEntity> VOID_LEAPER =
            mob("void_leaper", 0.85f, 1.5f, VoidLeaperEntity::new);
    public static final EntityType<FleshboundEntity> FLESHBOUND =
            mob("fleshbound", 1.0f, 2.0f, FleshboundEntity::new);
    public static final EntityType<DreadSovereignEntity> DREAD_SOVEREIGN =
            mob("dread_sovereign", 1.7f, 3.4f, DreadSovereignEntity::new);
    public static final EntityType<AbyssWardenEntity> ABYSS_WARDEN =
            mob("abyss_warden", 2.1f, 4.2f, AbyssWardenEntity::new);

    public static void register() {
        // Static initialization performs the registry calls.
    }

    private static DefaultAttributeContainer.Builder attributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_ARMOR, 0.0)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 0.0);
    }

    public static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(GRAVE_STALKER, attributes());
        FabricDefaultAttributeRegistry.register(ROTFANG, attributes());
        FabricDefaultAttributeRegistry.register(HOLLOW_KNIGHT, attributes());
        FabricDefaultAttributeRegistry.register(BLOOD_MAW, attributes());
        FabricDefaultAttributeRegistry.register(WRAITHLING, attributes());
        FabricDefaultAttributeRegistry.register(MIRE_CRAWLER, attributes());
        FabricDefaultAttributeRegistry.register(VOID_LEAPER, attributes());
        FabricDefaultAttributeRegistry.register(FLESHBOUND, attributes());
        FabricDefaultAttributeRegistry.register(DREAD_SOVEREIGN, attributes());
        FabricDefaultAttributeRegistry.register(ABYSS_WARDEN, attributes());
    }
}

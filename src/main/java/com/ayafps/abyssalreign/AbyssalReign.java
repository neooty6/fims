package com.ayafps.abyssalreign;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class AbyssalReign implements ModInitializer {
    public static final String MOD_ID = "abyssalreign";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModEntities.register();
        ModEntities.registerAttributes();
        ModItems.register();
        addSpawns();
    }

    private static void addSpawns() {
        add(ModEntities.GRAVE_STALKER, 28, 1, 2);
        add(ModEntities.ROTFANG, 24, 1, 3);
        add(ModEntities.HOLLOW_KNIGHT, 16, 1, 2);
        add(ModEntities.BLOOD_MAW, 10, 1, 1);
        add(ModEntities.WRAITHLING, 14, 1, 2);
        add(ModEntities.MIRE_CRAWLER, 20, 1, 3);
        add(ModEntities.VOID_LEAPER, 10, 1, 1);
        add(ModEntities.FLESHBOUND, 6, 1, 1);
    }

    private static void add(EntityType<?> type, int weight, int min, int max) {
        BiomeModifications.addSpawn(
                BiomeSelectors.foundInOverworld(),
                SpawnGroup.MONSTER,
                type,
                weight,
                min,
                max
        );
    }
}

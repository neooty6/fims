package com.ayafps.abyssalreign;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public final class ModItems {
    private ModItems() {}

    private static Item egg(String id, int primaryColor, int secondaryColor,
                           EntityType<? extends MobEntity> type) {
        return Registry.register(
                Registries.ITEM,
                new Identifier(AbyssalReign.MOD_ID, id + "_spawn_egg"),
                new SpawnEggItem(type, primaryColor, secondaryColor, new Item.Settings())
        );
    }

    public static final Item GRAVE_STALKER_SPAWN_EGG = egg("grave_stalker", 0x241B2E, 0xA94DFF, ModEntities.GRAVE_STALKER);
    public static final Item ROTFANG_SPAWN_EGG = egg("rotfang", 0x3B1717, 0xC43A2F, ModEntities.ROTFANG);
    public static final Item HOLLOW_KNIGHT_SPAWN_EGG = egg("hollow_knight", 0x15171D, 0x6D78FF, ModEntities.HOLLOW_KNIGHT);
    public static final Item BLOOD_MAW_SPAWN_EGG = egg("blood_maw", 0x3A0E12, 0xFF3131, ModEntities.BLOOD_MAW);
    public static final Item WRAITHLING_SPAWN_EGG = egg("wraithling", 0x142A38, 0x65E8FF, ModEntities.WRAITHLING);
    public static final Item MIRE_CRAWLER_SPAWN_EGG = egg("mire_crawler", 0x102D1C, 0x6BE36B, ModEntities.MIRE_CRAWLER);
    public static final Item VOID_LEAPER_SPAWN_EGG = egg("void_leaper", 0x170B2C, 0xC45BFF, ModEntities.VOID_LEAPER);
    public static final Item FLESHBOUND_SPAWN_EGG = egg("fleshbound", 0x351517, 0xF08A72, ModEntities.FLESHBOUND);
    public static final Item DREAD_SOVEREIGN_SPAWN_EGG = egg("dread_sovereign", 0x120C17, 0xFFB000, ModEntities.DREAD_SOVEREIGN);
    public static final Item ABYSS_WARDEN_SPAWN_EGG = egg("abyss_warden", 0x080A18, 0x4B63FF, ModEntities.ABYSS_WARDEN);

    public static void register() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(entries -> {
            entries.add(GRAVE_STALKER_SPAWN_EGG);
            entries.add(ROTFANG_SPAWN_EGG);
            entries.add(HOLLOW_KNIGHT_SPAWN_EGG);
            entries.add(BLOOD_MAW_SPAWN_EGG);
            entries.add(WRAITHLING_SPAWN_EGG);
            entries.add(MIRE_CRAWLER_SPAWN_EGG);
            entries.add(VOID_LEAPER_SPAWN_EGG);
            entries.add(FLESHBOUND_SPAWN_EGG);
            entries.add(DREAD_SOVEREIGN_SPAWN_EGG);
            entries.add(ABYSS_WARDEN_SPAWN_EGG);
        });
    }
}

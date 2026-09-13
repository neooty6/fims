package com.ayafps.abyssalreign;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.Identifier;

public final class AbyssalReignClient implements ClientModInitializer {
    private static final Identifier ZOMBIE_TEXTURE =
            new Identifier("minecraft", "textures/entity/zombie/zombie.png");

    @Override
    public void onInitializeClient() {
        register(ModEntities.GRAVE_STALKER, 0.5f);
        register(ModEntities.ROTFANG, 0.55f);
        register(ModEntities.HOLLOW_KNIGHT, 0.55f);
        register(ModEntities.BLOOD_MAW, 0.7f);
        register(ModEntities.WRAITHLING, 0.45f);
        register(ModEntities.MIRE_CRAWLER, 0.5f);
        register(ModEntities.VOID_LEAPER, 0.55f);
        register(ModEntities.FLESHBOUND, 0.55f);
        register(ModEntities.DREAD_SOVEREIGN, 0.85f);
        register(ModEntities.ABYSS_WARDEN, 0.9f);
    }

    private static <T extends MobEntity> void register(EntityType<T> type, float shadowRadius) {
        EntityRendererRegistry.register(type, ctx -> new SafeBipedRenderer<>(ctx, shadowRadius));
    }

    private static final class SafeBipedRenderer<T extends MobEntity>
            extends MobEntityRenderer<T, BipedEntityModel<T>> {
        private SafeBipedRenderer(EntityRendererFactory.Context ctx, float shadowRadius) {
            super(ctx, new BipedEntityModel<>(ctx.getPart(EntityModelLayers.ZOMBIE)), shadowRadius);
        }

        @Override
        public Identifier getTexture(T entity) {
            return ZOMBIE_TEXTURE;
        }
    }
}

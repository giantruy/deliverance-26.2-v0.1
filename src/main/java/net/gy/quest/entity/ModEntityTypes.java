package net.gy.quest.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.gy.quest.Deliverance;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class ModEntityTypes {

    public static final EntityType<SavageEntity> SAVAGE = register(
            "savage",
            EntityType.Builder.<SavageEntity>of(SavageEntity::new, MobCategory.MONSTER)
                    .sized(0.8f, 0.8f)
    );

    public static final EntityType<ShatterguardEntity> SHATTERGUARD = register(
            "shatterguard",
            EntityType.Builder.<ShatterguardEntity>of(ShatterguardEntity::new, MobCategory.MONSTER)
                    .sized(0.7f, 1.95f)
    );

    public static final EntityType<WolfTridentEntity> WOLF_TRIDENT = register("wolf_fang_trident", EntityType.Builder.<WolfTridentEntity>of(WolfTridentEntity::new, MobCategory.MISC)
            .sized(0.5f, 0.5f)
            .clientTrackingRange(4)
            .updateInterval(10)
    );

    private static <T extends Entity> EntityType<T> register(String name, EntityType.Builder<T> builder) {
        ResourceKey<EntityType<?>> key = ResourceKey.create(Registries.ENTITY_TYPE,
                Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, name));
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, key, builder.build(key));
    }


    public static void registerModEntities() {
        Deliverance.LOGGER.info("Registering Mod Entity Types for " + Deliverance.MOD_ID);
    }

    public static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(SAVAGE, SavageEntity.createCubeAttributes());
        FabricDefaultAttributeRegistry.register(SHATTERGUARD, ShatterguardEntity.createCubeAttributes());
    }
}

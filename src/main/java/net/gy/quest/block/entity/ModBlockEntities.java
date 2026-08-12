package net.gy.quest.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.gy.quest.Deliverance;
import net.gy.quest.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class ModBlockEntities {

    public static final BlockEntityType<StaffansCrafterBlockEntity> STAFFANS_CRAFTER_BE =
            Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE,
                    Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, "staffans_crafter_be"),
                    FabricBlockEntityTypeBuilder.create(StaffansCrafterBlockEntity::new, ModBlocks.STAFFANS_CRAFTER).build());

    public static void registerModBlockEntities() {
        Deliverance.LOGGER.info("Registering Mod Block Entities for " + Deliverance.MOD_ID);
    }
}

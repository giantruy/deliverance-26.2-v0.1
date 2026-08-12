package net.gy.quest.client.model;

import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.gy.quest.Deliverance;
import net.gy.quest.entity.model.SavageEntityModel;
import net.gy.quest.entity.model.ShatterguardModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.Identifier;

public class ModEntityModelLayers {
    public static final ModelLayerLocation SAVAGE = createMain("savage");
    public static final ModelLayerLocation SHATTERGUARD = createMain("shatterguard");

    private static ModelLayerLocation createMain(String name) {
        return new ModelLayerLocation(Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, name), "main");
    }

    public static void registerModelLayers() {
        ModelLayerRegistry.registerModelLayer(ModEntityModelLayers.SAVAGE, SavageEntityModel::getTexturedModelData);
        ModelLayerRegistry.registerModelLayer(ModEntityModelLayers.SHATTERGUARD, ShatterguardModel::getTexturedModelData);
    }
}

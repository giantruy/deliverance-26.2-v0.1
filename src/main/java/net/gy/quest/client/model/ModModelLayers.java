package net.gy.quest.client.model;

import net.gy.quest.Deliverance;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.Identifier;

public class ModModelLayers {
    public static final ModelLayerLocation STAFFANS_CIRCLE = new ModelLayerLocation(
            Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, "magic_circle"),
            "main"
    );
}

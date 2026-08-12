package net.gy.quest.client.model;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class StaffansPlaneModel {
    public static LayerDefinition createLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();

        root.addOrReplaceChild("plane",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-8.0F, -0.005F, -8.0F, 16.0F, 0.01F, 16.0F),
                PartPose.ZERO
        );
        return LayerDefinition.create(mesh, 16, 16);
    }
}

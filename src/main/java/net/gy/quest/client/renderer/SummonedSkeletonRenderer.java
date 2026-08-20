package net.gy.quest.client.renderer;

import net.gy.quest.Deliverance;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.SkeletonRenderer;
import net.minecraft.client.renderer.entity.ZombieRenderer;
import net.minecraft.client.renderer.entity.state.SkeletonRenderState;
import net.minecraft.client.renderer.entity.state.ZombieRenderState;
import net.minecraft.resources.Identifier;

public class SummonedSkeletonRenderer extends SkeletonRenderer {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, "textures/entity/summoned_skeleton.png");

    public SummonedSkeletonRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public Identifier getTextureLocation(SkeletonRenderState state) {
        return TEXTURE;
    }
}

package net.gy.quest.client.renderer;

import net.gy.quest.Deliverance;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ZombieRenderer;
import net.minecraft.client.renderer.entity.state.ZombieRenderState;
import net.minecraft.resources.Identifier;

public class SummonedZombieRenderer extends ZombieRenderer {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, "textures/entity/summoned_zombie.png");

    public SummonedZombieRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public Identifier getTextureLocation(ZombieRenderState state) {
        return TEXTURE;
    }
}

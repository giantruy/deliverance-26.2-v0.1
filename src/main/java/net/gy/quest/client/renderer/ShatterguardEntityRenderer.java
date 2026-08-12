package net.gy.quest.client.renderer;

import net.gy.quest.Deliverance;
import net.gy.quest.client.model.ModEntityModelLayers;
import net.gy.quest.entity.ShatterguardEntity;
import net.gy.quest.entity.model.ShatterguardModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

public class ShatterguardEntityRenderer extends MobRenderer<ShatterguardEntity, ShatterguardEntityRenderState, ShatterguardModel> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, "textures/entity/shatterguard.png");

    public  ShatterguardEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new ShatterguardModel(context.bakeLayer(ModEntityModelLayers.SHATTERGUARD)), 0.4f);
    }

    @Override
    public ShatterguardEntityRenderState createRenderState() {
        return new ShatterguardEntityRenderState();
    }

    @Override
    public Identifier getTextureLocation(ShatterguardEntityRenderState state) {
        return TEXTURE;
    }
}

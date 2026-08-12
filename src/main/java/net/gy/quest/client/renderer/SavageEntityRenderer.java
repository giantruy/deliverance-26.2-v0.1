package net.gy.quest.client.renderer;

import net.gy.quest.Deliverance;
import net.gy.quest.client.model.ModEntityModelLayers;
import net.gy.quest.entity.SavageEntity;
import net.gy.quest.entity.model.SavageEntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

public class SavageEntityRenderer extends MobRenderer<SavageEntity, SavageEntityRenderState, SavageEntityModel> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, "textures/entity/savage.png");

    public  SavageEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new SavageEntityModel(context.bakeLayer(ModEntityModelLayers.SAVAGE)), 0.4f);
    }

    @Override
    public SavageEntityRenderState createRenderState() {
        return new SavageEntityRenderState();
    }

    @Override
    public Identifier getTextureLocation(SavageEntityRenderState state) {
        return TEXTURE;
    }
}

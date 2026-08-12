package net.gy.quest;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.gy.quest.block.entity.ModBlockEntities;
import net.gy.quest.client.model.ModEntityModelLayers;
import net.gy.quest.client.model.ModModelLayers;
import net.gy.quest.client.model.StaffansPlaneModel;
import net.gy.quest.client.renderer.SavageEntityRenderer;
import net.gy.quest.client.renderer.ShatterguardEntityRenderer;
import net.gy.quest.client.renderer.StaffansCrafterRenderer;
import net.gy.quest.entity.ModEntityTypes;
import net.gy.quest.menu.ModMenuTypes;
import net.gy.quest.menu.StaffansCrafterScreen;
import net.gy.quest.particle.MagicCircleParticle;
import net.gy.quest.particle.ModParticles;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownTridentRenderer;

public class DeliveranceClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        MenuScreens.register(ModMenuTypes.STAFFANS_CRAFTER_MENU, StaffansCrafterScreen::new);
        ParticleProviderRegistry.getInstance().register(ModParticles.MAGIC_CIRCLE, MagicCircleParticle.Provider::new);
        BlockEntityRenderers.register(ModBlockEntities.STAFFANS_CRAFTER_BE, StaffansCrafterRenderer::new);
        ModelLayerRegistry.registerModelLayer(ModModelLayers.STAFFANS_CIRCLE, StaffansPlaneModel::createLayer);
        EntityRenderers.register(ModEntityTypes.SAVAGE, SavageEntityRenderer::new);
        EntityRenderers.register(ModEntityTypes.SHATTERGUARD, ShatterguardEntityRenderer::new);
        EntityRenderers.register(ModEntityTypes.WOLF_TRIDENT, ThrownTridentRenderer::new);
        ModEntityModelLayers.registerModelLayers();
    }
}

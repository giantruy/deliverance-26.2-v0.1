package net.gy.quest.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.gy.quest.Deliverance;
import net.gy.quest.block.entity.StaffansCrafterBlockEntity;
import net.gy.quest.client.model.ModModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.world.phys.Vec3;
import org.jspecify.annotations.Nullable;

public class StaffansCrafterRenderer implements BlockEntityRenderer<StaffansCrafterBlockEntity, StaffansCrafterRenderState> {

    private final ModelPart plane;
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, "textures/block/magic_circle.png");

    public StaffansCrafterRenderer(BlockEntityRendererProvider.Context context) {
        this.plane = context.bakeLayer(ModModelLayers.STAFFANS_CIRCLE);
    }

    @Override
    public StaffansCrafterRenderState createRenderState() {
        return new StaffansCrafterRenderState();
    }

    @Override
    public void extractRenderState(StaffansCrafterBlockEntity blockEntity, StaffansCrafterRenderState state, float partialTick, Vec3 cameraPosition, ModelFeatureRenderer.@Nullable CrumblingOverlay breakProgress) {
        BlockEntityRenderState.extractBase(blockEntity, state, breakProgress);
        state.rotation = blockEntity.rotation;
    }

    @Override
    public void submit(StaffansCrafterRenderState state, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState cameraRenderState) {
        poseStack.pushPose();
        poseStack.translate(0.5, 0.85, 0.5);
        poseStack.mulPose(Axis.YP.rotation(state.rotation));

        submitNodeCollector.submitModelPart(
                plane,
                poseStack,
                RenderTypes.entityTranslucentEmissive(TEXTURE),
                state.lightCoords = 0xF000F0,
                0,
                null
        );
        poseStack.popPose();
    }
}

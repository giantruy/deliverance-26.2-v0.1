package net.gy.quest.entity.model;

import net.gy.quest.client.renderer.SavageEntityRenderState;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;

public class SavageEntityModel extends EntityModel<SavageEntityRenderState> {
    private final ModelPart rightArm;
    private final ModelPart leftArm;
    private final ModelPart rightLeg;
    private final ModelPart leftLeg;
    private final ModelPart upperBody;
    private final ModelPart body;
    private final ModelPart head;
    private final ModelPart jaw;

    public SavageEntityModel(ModelPart root) {
        super(root);
        this.rightArm = root.getChild("right_arm");
        this.leftArm = root.getChild("left_arm");
        this.rightLeg = root.getChild("right_leg");
        this.leftLeg = root.getChild("left_leg");
        this.upperBody = root.getChild("upper_body");
        this.body = root.getChild("body");
        this.head = root.getChild("head");
        this.jaw = root.getChild("jaw");
    }

    public static LayerDefinition getTexturedModelData() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        partDefinition.addOrReplaceChild("right_arm",
                CubeListBuilder.create().texOffs(26, 0).addBox(-2.0f, -1.5f, -1.5f, 3.0f, 9.0f, 3.0f),
                PartPose.offset(-4.0f, 16.5f, -5.5f));

        partDefinition.addOrReplaceChild("left_arm",
                CubeListBuilder.create().texOffs(22, 28).addBox(-1.0f, -1.5f, -2.5f, 3.0f, 9.0f, 3.0f),
                PartPose.offset(4.0f, 16.5f, -4.5f));

        PartDefinition body = partDefinition.addOrReplaceChild("body",
                CubeListBuilder.create(), PartPose.offset(0.0f, 17.0f, -1.0f));

        body.addOrReplaceChild("cube_r1",
                CubeListBuilder.create().texOffs(0, 21).addBox(-3.0f, -2.0f, -2.5f, 6.0f, 4.0f, 5.0f),
                PartPose.offsetAndRotation(0.0f, 1.869f, 2.9179f, -0.3491f, 0.0f, 0.0f));

        partDefinition.addOrReplaceChild("jaw",
                CubeListBuilder.create().texOffs(22, 21).addBox(-3.0f, -1.0f, -4.0f, 6.0f, 1.0f, 6.0f),
                PartPose.offset(0.0f, 17.0f, -5.0f));

        partDefinition.addOrReplaceChild("head",
                CubeListBuilder.create().texOffs(0, 10).addBox(-3.0f, -5.5f, -4.0f, 6.0f, 5.0f, 6.0f),
                PartPose.offset(0.0f, 16.5f, -5.0f));

        PartDefinition upperBody = partDefinition.addOrReplaceChild("upper_body",
                CubeListBuilder.create(), PartPose.offset(0.0f, 15.0f, -3.0f));

        upperBody.addOrReplaceChild("cube_r2",
                CubeListBuilder.create().texOffs(0, 0).addBox(-4.0f, -2.5f, -2.5f, 8.0f, 5.0f, 5.0f),
                PartPose.offsetAndRotation(0.0f, 1.9226f, 0.8965f, -0.3491f, 0.0f, 0.0f));

        PartDefinition leftLeg = partDefinition.addOrReplaceChild("left_leg",
                CubeListBuilder.create(), PartPose.offset(2.5f, 20.0f, 4.0f));

        leftLeg.addOrReplaceChild("cube_r3",
                CubeListBuilder.create().texOffs(0, 30).addBox(-1.0f, -2.0f, -1.0f, 2.0f, 4.0f, 2.0f),
                PartPose.offsetAndRotation(0.5f, 1.8524f, 1.2525f, 0.1309f, 0.0f, 0.0f));

        PartDefinition rightLeg = partDefinition.addOrReplaceChild("right_leg",
                CubeListBuilder.create(), PartPose.offset(-2.5f, 20.0f, 4.0f));

        rightLeg.addOrReplaceChild("cube_r4",
                CubeListBuilder.create().texOffs(24, 12).addBox(-1.0f, -2.0f, -1.0f, 2.0f, 4.0f, 2.0f),
                PartPose.offsetAndRotation(-0.5f, 1.8524f, 1.2525f, 0.1309f, 0.0f, 0.0f));

        return LayerDefinition.create(meshDefinition, 64, 64);
    }

    @Override
    public void setupAnim(SavageEntityRenderState state) {
        super.setupAnim(state);

        float limbSwingAmplitude = state.walkAnimationSpeed;
        float limbSwingProgress = state.walkAnimationPos;
        float frequency = 0.39f;
        float armAmplitude = 0.5f;
        float legAmplitude = 0.6f;

        this.rightArm.xRot = Mth.cos(limbSwingProgress * frequency) * armAmplitude * limbSwingAmplitude;
        this.leftLeg.xRot = this.body.xRot + Mth.cos(limbSwingProgress * frequency) * legAmplitude * limbSwingAmplitude;

        this.leftArm.xRot = Mth.cos(limbSwingProgress * frequency + (float) Math.PI) * 1.4f * limbSwingAmplitude;
        this.rightLeg.xRot = this.body.xRot + Mth.cos(limbSwingProgress * frequency + (float) Math.PI) * legAmplitude * limbSwingAmplitude;

        this.upperBody.xRot = -0.3491f + Mth.cos(limbSwingProgress * frequency) * 0.1f * limbSwingAmplitude;
        this.body.xRot = -0.3491f + Mth.cos(limbSwingProgress * frequency) * 0.1f * limbSwingAmplitude;
        this.body.zRot = Mth.sin(limbSwingProgress * frequency) * 0.03f * limbSwingAmplitude;
        this.body.yRot = -Mth.abs(Mth.cos(limbSwingProgress * frequency)) * 0.3f * limbSwingAmplitude;

        this.head.xRot = (state.xRot * Mth.DEG_TO_RAD) * 1.2f;
        this.head.yRot = state.yRot * Mth.DEG_TO_RAD;

        this.jaw.xRot = this.head.xRot + Mth.abs(Mth.cos(limbSwingProgress * frequency)) * 0.3f * limbSwingAmplitude;
        this.jaw.yRot = this.head.yRot;
    }
}

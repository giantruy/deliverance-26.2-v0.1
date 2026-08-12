    package net.gy.quest.entity.model;

    import net.gy.quest.client.renderer.ShatterguardEntityRenderState;
    import net.minecraft.client.model.EntityModel;
    import net.minecraft.client.model.geom.ModelPart;
    import net.minecraft.client.model.geom.PartPose;
    import net.minecraft.client.model.geom.builders.CubeListBuilder;
    import net.minecraft.client.model.geom.builders.LayerDefinition;
    import net.minecraft.client.model.geom.builders.MeshDefinition;
    import net.minecraft.client.model.geom.builders.PartDefinition;
    import net.minecraft.util.Mth;

    public class ShatterguardModel extends EntityModel<ShatterguardEntityRenderState> {
        private final ModelPart rightLeg;
        private final ModelPart leftLeg;
        private final ModelPart head;
        private final ModelPart body;
        private final ModelPart leftArm;
        private final ModelPart rightArm;

        public ShatterguardModel(ModelPart root) {
            super(root);
            this.rightLeg = root.getChild("right_leg");
            this.leftLeg = root.getChild("left_leg");
            this.head = root.getChild("head");
            this.body = root.getChild("body");
            this.leftArm = root.getChild("left_arm");
            this.rightArm = root.getChild("right_arm");
        }

        public static LayerDefinition getTexturedModelData() {
            MeshDefinition meshdefinition = new MeshDefinition();
            PartDefinition partdefinition = meshdefinition.getRoot();

            PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg",
                    CubeListBuilder.create().texOffs(24, 16).addBox(-2.0F, 6.0F, -2.0F, 4.0F, 12.0F, 4.0F),
                    PartPose.offset(-1.0F, 6.0F, 1.0F));

            PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg",
                    CubeListBuilder.create().texOffs(0, 32).addBox(-2.0F, 6.0F, -2.0F, 4.0F, 12.0F, 4.0F),
                    PartPose.offset(-5.0F, 6.0F, 1.0F));

            PartDefinition head = partdefinition.addOrReplaceChild("head",
                    CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -12.0F, -4.0F, 8.0F, 8.0F, 8.0F),
                    PartPose.offset(-3.0F, 4.0F, 1.0F));

            PartDefinition body = partdefinition.addOrReplaceChild("body",
                    CubeListBuilder.create()
                            .texOffs(0, 16).addBox(-7.0F, -24.0F, -1.0F, 8.0F, 12.0F, 4.0F)
                            .texOffs(32, 43).addBox(-1.5F, -22.0F, 3.0F, 1.0F, 3.0F, 1.0F)
                            .texOffs(40, 26).addBox(-5.5F, -22.0F, 2.0F, 1.0F, 3.0F, 2.0F),
                    PartPose.offset(0.0F, 24.0F, 0.0F));

            PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm",
                    CubeListBuilder.create()
                            .texOffs(32, 0).addBox(-2.5F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F)
                            .texOffs(32, 32).addBox(-1.5F, 4.0F, -3.0F, 4.0F, 5.0F, 6.0F),
                    PartPose.offset(3.5F, 2.0F, 1.0F));

            PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm",
                    CubeListBuilder.create()
                            .texOffs(16, 32).addBox(-1.75F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F)
                            .texOffs(40, 16).addBox(-2.75F, -3.0F, -2.5F, 5.0F, 5.0F, 5.0F),
                    PartPose.offset(-9.25F, 2.0F, 1.0F));

            return LayerDefinition.create(meshdefinition, 64, 64);
        }

        @Override
        public void setupAnim(ShatterguardEntityRenderState state) {
            super.setupAnim(state);

            float limbSwingAmplitude = state.walkAnimationSpeed;
            float limbSwingProgress = state.walkAnimationPos;
            float frequency = 0.39f;
            float armAmplitude = 0.5f;
            float legAmplitude = 0.6f;

            this.rightArm.xRot = Mth.cos(limbSwingProgress * frequency) * armAmplitude * limbSwingAmplitude;
            this.leftArm.xRot = Mth.cos(limbSwingProgress * frequency + (float) Math.PI) * 1.4f * limbSwingAmplitude;

            this.leftLeg.xRot = this.body.xRot + Mth.cos(limbSwingProgress * frequency) * legAmplitude * limbSwingAmplitude;
            this.rightLeg.xRot = this.body.xRot + Mth.cos(limbSwingProgress * frequency + (float) Math.PI) * legAmplitude * limbSwingAmplitude;

            this.body.xRot = Mth.cos(limbSwingProgress * frequency) * 0.1f * limbSwingAmplitude;
            this.body.zRot = Mth.sin(limbSwingProgress * frequency) * 0.03f * limbSwingAmplitude;
            this.body.yRot = -Mth.abs(Mth.cos(limbSwingProgress * frequency)) * 0.3f * limbSwingAmplitude;


            this.head.xRot = (state.xRot * Mth.DEG_TO_RAD) * 1.2f;
            this.head.yRot = state.yRot * Mth.DEG_TO_RAD;
        }
    }
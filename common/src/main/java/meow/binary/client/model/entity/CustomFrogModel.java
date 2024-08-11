package meow.binary.client.model.entity;

import com.ibm.icu.text.Normalizer2;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import meow.binary.client.model.animation.CustomFrogAnimations;
import meow.binary.entity.ExampleEntity;
import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraft.client.animation.definitions.FrogAnimation;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import org.jetbrains.annotations.NotNull;

public class CustomFrogModel<T extends ExampleEntity> extends HierarchicalModel<T> {
	private static final float MAX_WALK_ANIMATION_SPEED = 1.5F;
	private static final float MAX_SWIM_ANIMATION_SPEED = 1.0F;
	private static final float WALK_ANIMATION_SCALE_FACTOR = 2.5F;
	private final ModelPart root;
	private final ModelPart croakingBody;

	public CustomFrogModel() {
		this.root = createBodyLayer().bakeRoot().getChild("root");
		this.croakingBody = root.getChild("croaking_body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshDefinition = new MeshDefinition();
		PartDefinition partdefinition = meshDefinition.getRoot();
		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.5F, 24.0F, 0.0F));

		PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(23, 13).addBox(-3.5F, -1.0F, -7.0F, 7.0F, 0.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(0, 13).addBox(-3.5F, -2.0F, -7.0F, 7.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, -4.0F, 3.0F));

		PartDefinition eyes = root.addOrReplaceChild("eyes", CubeListBuilder.create(), PartPose.offset(-1.0F, -4.0F, 5.0F));

		PartDefinition eyes_r1 = eyes.addOrReplaceChild("eyes_r1", CubeListBuilder.create().texOffs(0, 5).addBox(0.5F, -8.0F, -3.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, -5.0F, 0.0F, 0.0F, 0.1745F));

		PartDefinition eyes_r2 = eyes.addOrReplaceChild("eyes_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, -8.0F, -3.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 4.0F, -5.0F, 0.0F, 0.0F, -0.2182F));

		PartDefinition tongue = root.addOrReplaceChild("tongue", CubeListBuilder.create().texOffs(17, 13).addBox(-2.0F, 0.0F, -7.1F, 4.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, -3.1F, 5.0F));

		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(3, 1).addBox(-3.5F, -2.0F, -8.0F, 7.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(23, 22).addBox(-3.5F, -1.0F, -8.0F, 7.0F, 0.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, -2.0F, 4.0F));

		PartDefinition croaking_body = root.addOrReplaceChild("croaking_body", CubeListBuilder.create().texOffs(26, 5).addBox(-3.5F, -0.1F, -2.9F, 7.0F, 2.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.offset(-0.5F, -3.0F, -1.0F));

		PartDefinition left_arm = root.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(0, 32).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(18, 40).addBox(-4.0F, 3.01F, -5.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(3.5F, -3.0F, -2.5F));

		PartDefinition right_arm = root.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(0, 38).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(2, 40).addBox(-4.0F, 3.01F, -5.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.5F, -3.0F, -2.5F));

		PartDefinition left_leg = root.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(14, 25).addBox(-1.0F, 0.0F, -2.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(2, 32).addBox(-2.0F, 3.01F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -3.0F, 4.0F));

		PartDefinition right_leg = root.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 25).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(18, 32).addBox(-6.0F, 3.01F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -3.0F, 4.0F));

		return LayerDefinition.create(meshDefinition, 48, 48);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int color) {
		this.root.render(poseStack, buffer, packedLight, packedOverlay, color);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		AnimationDefinition animation = AnimationDefinition.Builder.withLength(2.0F)
				.addAnimation("tongue", new AnimationChannel(AnimationChannel.Targets.POSITION,
						new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, -7.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.build();

		this.animate(entity.jumpAnimationState, FrogAnimation.FROG_JUMP, ageInTicks);
		this.animate(entity.croakAnimationState, animation, ageInTicks);
		this.animate(entity.tongueAnimationState, FrogAnimation.FROG_TONGUE, ageInTicks);
		if (entity.isInWaterOrBubble()) {
			this.animateWalk(FrogAnimation.FROG_SWIM, limbSwing, limbSwingAmount, 1.0F, 2.5F);
		} else {
			this.animateWalk(FrogAnimation.FROG_WALK, limbSwing, limbSwingAmount, 1.5F, 2.5F);
		}

		this.animate(entity.swimIdleAnimationState, FrogAnimation.FROG_IDLE_WATER, ageInTicks);
		this.animate(entity.idleState, CustomFrogAnimations.IDLE, ageInTicks);
		this.croakingBody.visible = entity.croakAnimationState.isStarted();
	}


	@Override
	public @NotNull ModelPart root() {
		return this.root;
	}
}
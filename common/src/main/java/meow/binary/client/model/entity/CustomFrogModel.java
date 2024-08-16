package meow.binary.client.model.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import meow.binary.entity.CustomFrog;
import net.minecraft.client.animation.definitions.FrogAnimation;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import org.jetbrains.annotations.NotNull;

public class CustomFrogModel<T extends CustomFrog> extends HierarchicalModel<T> {
	private static final float MAX_WALK_ANIMATION_SPEED = 1.5F;
	private static final float MAX_SWIM_ANIMATION_SPEED = 1.0F;
	private static final float WALK_ANIMATION_SCALE_FACTOR = 2.5F;
	private final ModelPart root;
	private final ModelPart croakingBody;

	public CustomFrogModel() {
		this.root = createBodyLayer().bakeRoot().getChild("root");
		this.croakingBody = root.getChild("body").getChild("croaking_body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(3, 1).addBox(-3.5F, -2.0F, -8.0F, 7.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(23, 22).addBox(-3.5F, -1.0F, -8.0F, 7.0F, 0.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 4.0F));
		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(23, 13).addBox(-3.5F, -1.0F, -7.0F, 7.0F, 0.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(0, 13).addBox(-3.5F, -2.0F, -7.0F, 7.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(0, 51).addBox(-4.0F, -2.5F, -7.5F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, -1.0F));
		PartDefinition eyes = head.addOrReplaceChild("eyes", CubeListBuilder.create(), PartPose.offset(-0.5F, 0.0F, 2.0F));
		PartDefinition right_eye = eyes.addOrReplaceChild("right_eye", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, -3.0F, -6.5F));
		PartDefinition left_eye = eyes.addOrReplaceChild("left_eye", CubeListBuilder.create().texOffs(0, 5).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, -3.0F, -6.5F));
		PartDefinition croaking_body = body.addOrReplaceChild("croaking_body", CubeListBuilder.create().texOffs(26, 5).addBox(-3.5F, -0.1F, -2.9F, 7.0F, 2.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.offset(0.0F, -1.0F, -5.0F));
		PartDefinition tongue = body.addOrReplaceChild("tongue", CubeListBuilder.create().texOffs(17, 13).addBox(-2.0F, 0.0F, -7.1F, 4.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.1F, 1.0F));
		PartDefinition left_arm = body.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(0, 32).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(18, 40).addBox(-4.0F, 3.01F, -5.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, -1.0F, -6.5F));
		PartDefinition right_arm = body.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(0, 38).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(2, 40).addBox(-4.0F, 3.01F, -5.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -1.0F, -6.5F));
		PartDefinition left_leg = root.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(14, 25).addBox(-1.0F, 0.0F, -2.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(2, 32).addBox(-2.0F, 3.01F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(3.5F, -3.0F, 4.0F));
		PartDefinition right_leg = root.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 25).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(18, 32).addBox(-6.0F, 3.01F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.5F, -3.0F, 4.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int color) {
		this.root.render(poseStack, buffer, packedLight, packedOverlay, color);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
//		AnimationDefinition animation = AnimationDefinition.Builder.withLength(2.0F)
//				.addAnimation("tongue", new AnimationChannel(AnimationChannel.Targets.POSITION,
//						new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
//						new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, -7.0F), AnimationChannel.Interpolations.CATMULLROM),
//						new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
//				))
//				.build();
		this.animate(entity.jumpAnimationState, FrogAnimation.FROG_JUMP, ageInTicks);
		this.animate(entity.croakAnimationState, FrogAnimation.FROG_CROAK, ageInTicks);
		this.animate(entity.tongueAnimationState, FrogAnimation.FROG_TONGUE, ageInTicks);
		if (entity.isInWaterOrBubble()) {
			this.animateWalk(FrogAnimation.FROG_SWIM, limbSwing, limbSwingAmount, 1.0F, 2.5F);
		} else {
			this.animateWalk(FrogAnimation.FROG_WALK, limbSwing, limbSwingAmount, 1.5F, 2.5F);
		}

		this.animate(entity.swimIdleAnimationState, FrogAnimation.FROG_IDLE_WATER, ageInTicks);
		this.croakingBody.visible = entity.croakAnimationState.isStarted();
	}


	@Override
	public @NotNull ModelPart root() {
		return this.root;
	}
}
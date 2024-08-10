package meow.binary.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import meow.binary.FrogOverhaul;
import meow.binary.client.model.entity.CustomFrogModel;
import meow.binary.entity.ExampleEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class ExampleEntityRenderer extends EntityRenderer<ExampleEntity> {
    public final CustomFrogModel model;

    public ExampleEntityRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new CustomFrogModel<>();
    }

    @Override
    public void render(ExampleEntity entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
        poseStack.pushPose();
        poseStack.scale(1,1,1);
        poseStack.translate(0,1.51,0);
        poseStack.mulPose(Axis.ZP.rotationDegrees(180));
        poseStack.mulPose(Axis.YP.rotationDegrees((entity.tickCount+partialTick)*2));
        model.renderToBuffer(poseStack,bufferSource.getBuffer(RenderType.entityCutout(getTextureLocation(entity))),packedLight, OverlayTexture.NO_OVERLAY);
        poseStack.popPose();
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(ExampleEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("minecraft", "textures/entity/frog/temperate_frog.png");
    }
}

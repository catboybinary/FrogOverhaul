package meow.binary.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import meow.binary.FrogOverhaul;
import meow.binary.entity.ExampleEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class ExampleEntityRenderer extends EntityRenderer<ExampleEntity> {
    public ExampleEntityRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public void render(ExampleEntity entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);

    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(ExampleEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(FrogOverhaul.MOD_ID, "textures/test.png");
    }
}

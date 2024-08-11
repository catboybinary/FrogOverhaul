package meow.binary.client.renderer;

import meow.binary.client.model.entity.CustomFrogModel;
import meow.binary.entity.ExampleEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class ExampleEntityRenderer extends MobRenderer<ExampleEntity, CustomFrogModel<ExampleEntity>> {
    public ExampleEntityRenderer(EntityRendererProvider.Context context, CustomFrogModel<ExampleEntity> model, float shadowRadius) {
        super(context, model, shadowRadius);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(ExampleEntity entity) {
        return entity.getVariant().value().texture();
    }
}

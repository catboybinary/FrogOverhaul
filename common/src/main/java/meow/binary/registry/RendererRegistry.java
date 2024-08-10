package meow.binary.registry;

import dev.architectury.registry.client.level.entity.EntityRendererRegistry;
import meow.binary.client.renderer.ExampleEntityRenderer;
import meow.binary.entity.ExampleEntity;

public class RendererRegistry {
    public static void init() {
        EntityRendererRegistry.register(EntityRegistry.EXAMPLE_ENTITY, ExampleEntityRenderer::new);
    }
}

package meow.binary.registry;

import dev.architectury.registry.client.level.entity.EntityRendererRegistry;
import meow.binary.client.data.ClientFrogData;
import meow.binary.client.registry.ClientFrogRegistry;
import meow.binary.client.renderer.CustomFrogRenderer;

public class RendererRegistry {
    public static void init() {
        EntityRegistry.FROG_MAP.forEach((key, value) -> {
            ClientFrogData data = ClientFrogRegistry.CLIENT_FROG_MAP.get(key.getId());
            EntityRendererRegistry.register(value, ctx -> data.getRenderer().create(ctx, key, data));
        });
    }
}

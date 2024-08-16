package meow.binary;

import meow.binary.client.registry.ClientFrogRegistry;
import meow.binary.registry.RendererRegistry;

public final class FrogOverhaulClient {
    public static void init() {
        ClientFrogRegistry.init();
        RendererRegistry.init();
    }
}

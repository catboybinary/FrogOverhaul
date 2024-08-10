package meow.binary.fabric.client;

import meow.binary.FrogOverhaulClient;
import net.fabricmc.api.ClientModInitializer;

public final class FrogOverhaulFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // This entrypoint is suitable for setting up client-specific logic, such as rendering.
        FrogOverhaulClient.init();
    }
}

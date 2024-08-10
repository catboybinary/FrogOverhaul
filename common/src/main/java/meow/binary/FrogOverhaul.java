package meow.binary;

import dev.architectury.event.events.common.EntityEvent;
import dev.architectury.registry.level.entity.EntityAttributeRegistry;
import meow.binary.registry.EntityRegistry;
import meow.binary.registry.ItemRegistry;

public final class FrogOverhaul {
    public static final String MOD_ID = "frogoverhaul";

    public static void init() {
        // Write common init code here.
        ItemRegistry.init();
        EntityRegistry.init();


    }
}

package meow.binary;

import dev.architectury.event.events.common.LifecycleEvent;
import dev.architectury.registry.level.biome.BiomeModifications;
import meow.binary.registry.EntityRegistry;
import meow.binary.registry.FrogRegistry;
import meow.binary.registry.ItemRegistry;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.MobSpawnSettings;

public final class FrogOverhaul {
    public static final String MOD_ID = "frogoverhaul";

    public static void init() {
        // Write common init code here.
        EntityRegistry.init();
        ItemRegistry.init();

        LifecycleEvent.SETUP.register(() -> FrogRegistry.FROGS.values().forEach(frog -> BiomeModifications.addProperties(
                frog.getBiomePredicate(),
                (ctx, b) -> b.getSpawnProperties().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityRegistry.FROG_MAP.get(frog).get(), 100, 1, 4))
        )));
    }
}

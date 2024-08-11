package meow.binary;

import dev.architectury.registry.level.biome.BiomeModifications;
import meow.binary.registry.EntityRegistry;
import meow.binary.registry.ItemRegistry;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.MobSpawnSettings;

public final class FrogOverhaul {
    public static final String MOD_ID = "frogoverhaul";

    public static void init() {
        // Write common init code here.
        ItemRegistry.init();
        EntityRegistry.init();

        BiomeModifications.addProperties((ctx, b) -> b.getSpawnProperties().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityRegistry.EXAMPLE_ENTITY.get(), 100, 1, 4)));
    }
}

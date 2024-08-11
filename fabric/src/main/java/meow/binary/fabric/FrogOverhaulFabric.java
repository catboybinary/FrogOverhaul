package meow.binary.fabric;

import meow.binary.FrogOverhaul;
import meow.binary.registry.EntityRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.level.biome.Biomes;

public final class FrogOverhaulFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        FrogOverhaul.init();

//        BiomeModifications.addSpawn(
//                BiomeSelectors.includeByKey(Biomes.CHERRY_GROVE),
//                EntityRegistry.EXAMPLE_ENTITY.get().getCategory(),
//                EntityRegistry.EXAMPLE_ENTITY.get(),
//                100, 1, 4
//        );
    }
}

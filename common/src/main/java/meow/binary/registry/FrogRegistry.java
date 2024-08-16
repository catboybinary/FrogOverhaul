package meow.binary.registry;

import meow.binary.client.data.ClientFrogData;
import meow.binary.client.registry.ClientFrogRegistry;
import meow.binary.client.renderer.CustomFrogRenderer;
import meow.binary.data.FrogData;
import meow.binary.entity.CustomFrog;
import net.minecraft.world.level.biome.Biomes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrogRegistry {
    public static Map<String, FrogData<? extends CustomFrog>> FROGS = new HashMap<>();

    public static final FrogData<CustomFrog> LUSH_FROG = register(new FrogData<>("lush_frog", CustomFrog::new).toBuilder()
            .biomePredicate(biomeContext -> biomeContext.getKey().get().equals(Biomes.CHERRY_GROVE.location()))
            .build());

    public static <T extends CustomFrog> FrogData<T> register(FrogData<T> data) {
        FROGS.put(data.getId(), data);
        return data;
    }
}

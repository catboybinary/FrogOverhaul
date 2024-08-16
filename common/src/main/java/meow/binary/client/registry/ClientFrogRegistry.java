package meow.binary.client.registry;

import meow.binary.client.data.ClientFrogData;
import meow.binary.entity.CustomFrog;
import meow.binary.registry.FrogRegistry;
import net.minecraft.core.particles.ParticleTypes;

import java.util.HashMap;
import java.util.Map;

public class ClientFrogRegistry {
    public static final Map<String, ClientFrogData<? extends CustomFrog>> CLIENT_FROG_MAP = new HashMap<>();

    public static final ClientFrogData<CustomFrog> LUSH_FROG = register(new ClientFrogData<>("lush_frog").toBuilder()
            .particle(ParticleTypes.CHERRY_LEAVES)
            .build());

    public static <T extends CustomFrog> ClientFrogData<T> register(ClientFrogData<T> data) {
        CLIENT_FROG_MAP.put(data.getId(), data);
        return data;
    }

    public static <T extends CustomFrog> void init() {
        FrogRegistry.FROGS.keySet().forEach(s -> {
            if (!CLIENT_FROG_MAP.containsKey(s)) CLIENT_FROG_MAP.put(s, new ClientFrogData<T>(s));
        });
    }
}

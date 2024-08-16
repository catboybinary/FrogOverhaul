package meow.binary.registry;

import dev.architectury.registry.level.entity.EntityAttributeRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import meow.binary.FrogOverhaul;
import meow.binary.data.FrogData;
import meow.binary.entity.CustomFrog;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.animal.frog.Frog;
import net.minecraft.world.phys.Vec3;

import java.util.HashMap;
import java.util.Map;

public class EntityRegistry {
    public final static DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(FrogOverhaul.MOD_ID, Registries.ENTITY_TYPE);

    public static final Map<FrogData<? extends CustomFrog>, RegistrySupplier<EntityType<? extends CustomFrog>>> FROG_MAP = new HashMap<>();

    public static void init() {
        for (FrogData<? extends CustomFrog> data : FrogRegistry.FROGS.values()) {
            RegistrySupplier<EntityType<? extends CustomFrog>> frog = ENTITIES.register(data.getId(), () -> EntityType.Builder.of(data.getFactory(), MobCategory.CREATURE)
                    .sized(data.getWidth(), data.getHeight())
                    .passengerAttachments(data.getPassengerAttachments())
                    .clientTrackingRange(10)
                    .build(data.getId()));

            FROG_MAP.put(data, frog);
        }

        ENTITIES.register();
        registerAttributes();
    }

    public static void registerAttributes() {
        FROG_MAP.forEach((key, value) -> EntityAttributeRegistry.register(value, key.getAttributes()));
    }
}

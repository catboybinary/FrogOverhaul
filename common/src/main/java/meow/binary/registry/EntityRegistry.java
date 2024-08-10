package meow.binary.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import meow.binary.FrogOverhaul;
import meow.binary.entity.ExampleEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class EntityRegistry {
    public final static DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(FrogOverhaul.MOD_ID, Registries.ENTITY_TYPE);

    public static final RegistrySupplier<EntityType<ExampleEntity>> EXAMPLE_ENTITY = ENTITIES.register("example_entity", () -> EntityType.Builder.of(ExampleEntity::new, MobCategory.CREATURE)
            .sized(0.3f,0.3f)
            .build("example_entity"));

    public static void init() {
        ENTITIES.register();
    }
}

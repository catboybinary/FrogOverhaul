package meow.binary.registry;

import dev.architectury.registry.level.entity.EntityAttributeRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import meow.binary.FrogOverhaul;
import meow.binary.entity.ExampleEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.frog.Frog;
import net.minecraft.world.phys.Vec3;

public class EntityRegistry {
    public final static DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(FrogOverhaul.MOD_ID, Registries.ENTITY_TYPE);

    public static final RegistrySupplier<EntityType<ExampleEntity>> EXAMPLE_ENTITY = ENTITIES.register("example_entity", () -> EntityType.Builder.of(ExampleEntity::new, MobCategory.CREATURE)
            .sized(0.5F, 0.5F).passengerAttachments(new Vec3(0.0, 0.375, -0.25)).clientTrackingRange(10)
            .build("example_entity"));

    public static void init() {
        ENTITIES.register();
        registerAttributes();
    }

    public static void registerAttributes() {
        EntityAttributeRegistry.register(EXAMPLE_ENTITY, () -> Frog.createAttributes());
    }
}

package meow.binary.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import meow.binary.FrogOverhaul;
import meow.binary.item.EmptyJarItem;
import meow.binary.item.FrogJarItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.MobBucketItem;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.material.Fluids;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(FrogOverhaul.MOD_ID, Registries.ITEM);

//    public static final RegistrySupplier<Item> EXAMPLE_ITEM = ITEMS.register("example_item", () -> new Item(new Item.Properties()));
    public static final RegistrySupplier<Item> EMPTY_JAR = ITEMS.register("empty_jar", () -> new EmptyJarItem(new Item.Properties().stacksTo(16)));
    public static final RegistrySupplier<Item> FROG_JAR = ITEMS.register("frog_jar", () -> new MobBucketItem(EntityRegistry.FROG_MAP.get(FrogRegistry.LUSH_FROG).get(), Fluids.EMPTY, SoundEvents.ALLAY_DEATH, new Item.Properties().stacksTo(1)));

    public static void init() {
        ITEMS.register();
    }
}

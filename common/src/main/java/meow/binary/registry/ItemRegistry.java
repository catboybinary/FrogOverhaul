package meow.binary.registry;

import dev.architectury.registry.registries.DeferredRegister;
import meow.binary.FrogOverhaul;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(FrogOverhaul.MOD_ID, Registries.ITEM);

    //public static final RegistrySupplier<Item> EXAMPLE_ITEM = ITEMS.register("example_item", () -> new Item(new Item.Properties()));

    public static void init() {
        ITEMS.register();
    }
}

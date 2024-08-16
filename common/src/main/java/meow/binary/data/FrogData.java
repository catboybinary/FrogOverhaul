package meow.binary.data;

import com.google.common.base.Predicates;
import dev.architectury.registry.level.biome.BiomeModifications;
import lombok.*;
import meow.binary.FrogOverhaul;
import meow.binary.client.model.entity.CustomFrogModel;
import meow.binary.client.renderer.CustomFrogRenderer;
import meow.binary.client.renderer.FrogRendererProvider;
import meow.binary.entity.CustomFrog;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.animal.frog.Frog;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.phys.Vec3;

import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

@Builder(toBuilder = true)
@Getter
@AllArgsConstructor
public class FrogData<T extends CustomFrog> {
    private final String id;
    private final EntityType.EntityFactory<T> factory;
    private ResourceLocation texture;

    private float width = 0.5f;
    private float height = 0.5f;
    private Vec3 passengerAttachments = new Vec3(0.0, 0.375, -0.25);
    private Supplier<AttributeSupplier.Builder> attributes = Frog::createAttributes;

    private Predicate<BiomeModifications.BiomeContext> biomePredicate = Predicates.alwaysFalse();

    public FrogData(String id, EntityType.EntityFactory<T> factory) {
        this.id = id;
        this.factory = factory;
        this.texture = ResourceLocation.fromNamespaceAndPath(FrogOverhaul.MOD_ID, "textures/entity/frog/"+id+".png");
    }
}

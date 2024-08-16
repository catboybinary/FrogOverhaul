package meow.binary.client.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import meow.binary.client.model.entity.CustomFrogModel;
import meow.binary.client.renderer.CustomFrogRenderer;
import meow.binary.client.renderer.FrogRendererProvider;
import meow.binary.entity.CustomFrog;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;

@Builder(toBuilder = true)
@Getter
@AllArgsConstructor
public class ClientFrogData<T extends CustomFrog> {
    private final String id;

    private HierarchicalModel<T> model = new CustomFrogModel<>();
    private FrogRendererProvider renderer = CustomFrogRenderer::new;
    private float shadowRadius = 0.3f;
    private ParticleOptions particle;

    public ClientFrogData(String id) {
        this.id = id;
    }
}

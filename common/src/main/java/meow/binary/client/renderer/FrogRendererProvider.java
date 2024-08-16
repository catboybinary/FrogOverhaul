package meow.binary.client.renderer;

import meow.binary.client.data.ClientFrogData;
import meow.binary.data.FrogData;
import meow.binary.entity.CustomFrog;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

@FunctionalInterface
public interface FrogRendererProvider<T extends CustomFrog> {
    CustomFrogRenderer<T> create(EntityRendererProvider.Context context, FrogData data, ClientFrogData clientData);
}
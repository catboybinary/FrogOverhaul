package meow.binary.client.renderer;

import meow.binary.client.data.ClientFrogData;
import meow.binary.client.registry.ClientFrogRegistry;
import meow.binary.data.FrogData;
import meow.binary.entity.CustomFrog;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class CustomFrogRenderer<T extends CustomFrog> extends MobRenderer<T, HierarchicalModel<T>> {
    public final FrogData<T> data;
    public final ClientFrogData<T> clientData;

    public CustomFrogRenderer(EntityRendererProvider.Context context, FrogData<T> data, ClientFrogData<T> clientData) {
        super(context, clientData.getModel(), clientData.getShadowRadius());
        this.data = data;
        this.clientData = clientData;
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(T entity) {
        return data.getTexture();
    }
}

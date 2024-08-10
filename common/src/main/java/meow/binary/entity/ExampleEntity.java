package meow.binary.entity;

import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.DefaultAttributes;
import net.minecraft.world.entity.animal.frog.Frog;
import net.minecraft.world.level.Level;

public class ExampleEntity extends Frog {
    public ExampleEntity(EntityType<? extends Frog> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
    }
}

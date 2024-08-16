package meow.binary.entity;

import com.ibm.icu.text.AlphabeticIndex;
import meow.binary.client.data.ClientFrogData;
import meow.binary.client.registry.ClientFrogRegistry;
import meow.binary.data.FrogData;
import meow.binary.registry.FrogRegistry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.Bucketable;
import net.minecraft.world.entity.animal.frog.Frog;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.Objects;

public class CustomFrog extends Frog implements Bucketable {
    public final AnimationState idleState = new AnimationState();
    public final FrogData<? extends CustomFrog> data;
    private static final EntityDataAccessor<Boolean> FROM_JAR = null;

    public CustomFrog(EntityType<? extends Frog> entityType, Level level) {
        super(entityType, level);
        this.data = FrogRegistry.FROGS.get(Objects.requireNonNull(entityType.arch$registryName()).getPath());
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(FROM_JAR, false);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("FromJar", this.fromBucket());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.setFromBucket(compound.getBoolean("FromJar"));
    }

    @Override
    public void tick() {
        if (this.level().isClientSide()) {
            ClientFrogData clientFrogData = ClientFrogRegistry.CLIENT_FROG_MAP.get(data.getId());
            this.idleState.animateWhen(!this.isInWaterOrBubble() && !this.walkAnimation.isMoving(), this.tickCount);

            if (clientFrogData.getParticle() != null && tickCount % 20 == 0) {
                this.level().addParticle(
                        clientFrogData.getParticle(),
                        position().x+(random.nextFloat()-0.5f)*getBbWidth(),
                        position().y+getBbHeight(),
                        position().z+(random.nextFloat()-0.5f)*getBbWidth(),
                        0.1,
                        0.1,
                        0.1
                );
            }
        }
        super.tick();
    }

    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> dataAccessor) {
        super.onSyncedDataUpdated(dataAccessor);
    }

    public boolean fromBucket() {
        return (Boolean) this.entityData.get(FROM_BUCKET);
    }

    public void setFromBucket(boolean fromBucket) {
        this.entityData.set(FROM_BUCKET, fromBucket);
    }

    @Override
    public void saveToBucketTag(ItemStack stack) {

    }

    @Override
    public void loadFromBucketTag(CompoundTag tag) {

    }

    @Override
    public ItemStack getBucketItemStack() {
        return null;
    }

    @Override
    public SoundEvent getPickupSound() {
        return null;
    }
}

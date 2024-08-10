package meow.binary.neoforge;

import meow.binary.FrogOverhaul;
import meow.binary.FrogOverhaulClient;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLEnvironment;

@Mod(FrogOverhaul.MOD_ID)
public final class FrogOverhaulNeoForge {
    public FrogOverhaulNeoForge() {
        // Run our common setup.
        FrogOverhaul.init();
        if (FMLEnvironment.dist == Dist.CLIENT) {
            FrogOverhaulClient.init();
        }
    }
}

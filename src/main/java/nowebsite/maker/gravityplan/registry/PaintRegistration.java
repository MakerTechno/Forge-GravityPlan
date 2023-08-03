package nowebsite.maker.gravityplan.registry;

import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import nowebsite.maker.gravityplan.GravityPlan;

public class PaintRegistration {
    public static void init() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        PAINTINGS.register(bus);
    }

    public static final DeferredRegister<PaintingVariant> PAINTINGS = DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, GravityPlan.MOD_ID);

}

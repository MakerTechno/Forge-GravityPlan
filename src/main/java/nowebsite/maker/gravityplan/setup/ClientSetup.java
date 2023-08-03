package nowebsite.maker.gravityplan.setup;

import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import nowebsite.maker.gravityplan.GravityPlan;

@EventBusSubscriber(modid = GravityPlan.MOD_ID, bus = Bus.MOD)
public class ClientSetup {
    public static void init(FMLCommonSetupEvent event) {
    }
}

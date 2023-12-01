package nowebsite.maker.gravityplan.setup;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import nowebsite.maker.gravityplan.GravityPlan;

@EventBusSubscriber(modid = GravityPlan.MOD_ID, bus = Bus.MOD)
public class ModSetup {

    public static final String SHOULD_EXPLODE_TAG = "Should explode";
    public static final String HAS_EXPLODED_TAG = "Has exploded";
    public static void setup() {
        IEventBus bus = MinecraftForge.EVENT_BUS;
    }
}

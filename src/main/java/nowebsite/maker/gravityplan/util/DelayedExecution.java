package nowebsite.maker.gravityplan.util;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import nowebsite.maker.gravityplan.GravityPlan;
import org.jetbrains.annotations.NotNull;

/**Thanks for tt432 from <a href="https://tt432.github.io/ModdingTutorial118/#/inf%E9%99%84%E5%8A%A0%E5%86%85%E5%AE%B9/%E5%B0%8F%E5%B7%A5%E5%85%B7/%E5%BB%B6%E6%97%B6%E6%89%A7%E8%A1%8C">github.io</a>*/
@Mod.EventBusSubscriber(modid = GravityPlan.MOD_ID)
public class DelayedExecution {
    Runnable runnable;
    int delayTick;
    IEventBus bus;

    /***
     * @param bus event bus
     * @param runnable it'll be run later
     * @param delayTick delays(tick)
     */
    public DelayedExecution(@NotNull IEventBus bus, Runnable runnable, int delayTick) {
        this.runnable = runnable;
        this.delayTick = delayTick;

        this.bus = bus;

        bus.register(this);
    }

    public DelayedExecution(Runnable runnable, int delayTick) {
        this(MinecraftForge.EVENT_BUS, runnable, delayTick);
    }

    @SubscribeEvent
    public void tick(TickEvent event) {
        if (delayTick-- <= 0) {
            runnable.run();
            bus.unregister(this);
        }
    }
}

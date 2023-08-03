package nowebsite.maker.gravityplan.setup;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import nowebsite.maker.gravityplan.GravityPlan;
import nowebsite.maker.gravityplan.registry.ItemRegistration;
import org.jetbrains.annotations.NotNull;

@EventBusSubscriber(modid = GravityPlan.MOD_ID, bus = Bus.MOD)
public class SetupWithEvents {
    @SubscribeEvent
    public static void registerCreativeModeTab(CreativeModeTabEvent.@NotNull Register event) {
        event.registerCreativeModeTab(
                new ResourceLocation(GravityPlan.MOD_ID, "main_tab"),
                (builder) -> builder.displayItems((parameters, output) -> {
                    output.accept(ItemRegistration.FORCE_FORWARD.get());
                    output.accept(ItemRegistration.FORCE_BACK.get());
                    output.accept(ItemRegistration.FORCE_UP.get());
                    output.accept(ItemRegistration.FORCE_DOWN.get());
                    output.accept(ItemRegistration.FORCE_LEFT.get());
                    output.accept(ItemRegistration.FORCE_RIGHT.get());
                })
                //.title(Component.translatable("itemGroup.furniture"))
                //.icon(() -> new ItemStack(ItemRegistration.TEST_ITEM.get()))
        );
    }
}

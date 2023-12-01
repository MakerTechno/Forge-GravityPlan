package nowebsite.maker.gravityplan.setup;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
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
                    output.accept(ItemRegistration.FORCE.get());
                })
                .title(Component.translatable("itemGroup.gravityplan"))
                .icon(() -> new ItemStack(ItemRegistration.ICON.get()))
        );
    }
}

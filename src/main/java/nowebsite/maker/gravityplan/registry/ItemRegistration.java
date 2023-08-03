package nowebsite.maker.gravityplan.registry;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import nowebsite.maker.gravityplan.GravityPlan;
import nowebsite.maker.gravityplan.items.force.horizontalx.ForceBack;
import nowebsite.maker.gravityplan.items.force.horizontalx.ForceForward;
import nowebsite.maker.gravityplan.items.force.horizontalz.ForceLeft;
import nowebsite.maker.gravityplan.items.force.horizontalz.ForceRight;
import nowebsite.maker.gravityplan.items.force.verticle.ForceDown;
import nowebsite.maker.gravityplan.items.force.verticle.ForceUp;

public class ItemRegistration {
    public static void init() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(bus);
    }

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GravityPlan.MOD_ID);
    public static final RegistryObject<Item> ICON = ITEMS.register("icon", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> FORCE_FORWARD = ITEMS.register("force_forward", ForceForward::new);
    public static final RegistryObject<Item> FORCE_BACK = ITEMS.register("force_back", ForceBack::new);
    public static final RegistryObject<Item> FORCE_UP = ITEMS.register("force_up", ForceUp::new);
    public static final RegistryObject<Item> FORCE_DOWN = ITEMS.register("force_down", ForceDown::new);
    public static final RegistryObject<Item> FORCE_LEFT = ITEMS.register("force_left", ForceLeft::new);
    public static final RegistryObject<Item> FORCE_RIGHT = ITEMS.register("force_right", ForceRight::new);

}


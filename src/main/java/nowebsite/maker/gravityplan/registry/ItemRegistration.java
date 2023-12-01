package nowebsite.maker.gravityplan.registry;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import nowebsite.maker.gravityplan.GravityPlan;
import nowebsite.maker.gravityplan.items.SimpleIconIntro;
import nowebsite.maker.gravityplan.items.ForceItem;

public class ItemRegistration {
    public static void init() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(bus);
    }

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GravityPlan.MOD_ID);
    public static final RegistryObject<Item> ICON = ITEMS.register("icon", () -> new SimpleIconIntro(new Item.Properties()));
    public static final RegistryObject<Item> FORCE = ITEMS.register("force", () -> new ForceItem(new Item.Properties()));
    public static final RegistryObject<Item> SUPER_TNT = ITEMS.register("super_tnt", ()->new Item(new Item.Properties().stacksTo(114514)));

}


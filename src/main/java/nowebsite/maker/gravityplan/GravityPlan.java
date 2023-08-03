package nowebsite.maker.gravityplan;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import nowebsite.maker.gravityplan.datagen.ModDataGenerators;
import nowebsite.maker.gravityplan.registry.BlockRegistration;
import nowebsite.maker.gravityplan.registry.ItemRegistration;
import nowebsite.maker.gravityplan.registry.PaintRegistration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(GravityPlan.MOD_ID)
public class GravityPlan {
    public static final String MOD_ID = "gravityplan";
    public static final Logger LOGGER = LogManager.getLogger();

    public GravityPlan(){
        LOGGER.info("Gravity Plan mod is on loading.");
        BlockRegistration.init();
        ItemRegistration.init();
        PaintRegistration.init();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ModDataGenerators::gatherData);
    }
}

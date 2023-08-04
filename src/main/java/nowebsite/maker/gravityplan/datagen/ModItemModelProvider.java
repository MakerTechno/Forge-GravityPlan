package nowebsite.maker.gravityplan.datagen;

import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import nowebsite.maker.gravityplan.registry.ItemRegistration;
import nowebsite.maker.gravityplan.GravityPlan;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper helper) {
        super(output, GravityPlan.MOD_ID, helper);
    }

    protected void registerModels() {
        singleTexture(
                ItemRegistration.ICON.get().toString(),
                mcLoc("item/generated"),
                "layer0",
                modLoc("item/icon")
        );
        singleTexture(
                ItemRegistration.FORCE_FORWARD.get().toString(),
                mcLoc("item/generated"),
                "layer0",
                modLoc("item/forward")
        );
        singleTexture(
                ItemRegistration.FORCE_BACK.get().toString(),
                mcLoc("item/generated"),
                "layer0",
                modLoc("item/back")
        );
        singleTexture(
                ItemRegistration.FORCE_UP.get().toString(),
                mcLoc("item/generated"),
                "layer0",
                modLoc("item/up")
        );
        singleTexture(
                ItemRegistration.FORCE_DOWN.get().toString(),
                mcLoc("item/generated"),
                "layer0",
                modLoc("item/down")
        );
        singleTexture(
                ItemRegistration.FORCE_LEFT.get().toString(),
                mcLoc("item/generated"),
                "layer0",
                modLoc("item/left")
        );
        singleTexture(
                ItemRegistration.FORCE_RIGHT.get().toString(),
                mcLoc("item/generated"),
                "layer0",
                modLoc("item/right")
        );
        //withExistingParent(ro.get().get().toString(), modLoc("block/" + ro.get()));
    }

}

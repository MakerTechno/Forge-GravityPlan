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
                ItemRegistration.FORCE.get().toString(),
                mcLoc("item/generated"),
                "layer0",
                modLoc("item/force")
        );
        singleTexture(
                ItemRegistration.SUPER_TNT.get().toString(),
                mcLoc("item/generated"),
                "layer0",
                mcLoc("item/stick")
        );
        //withExistingParent(ro.get().get().toString(), modLoc("block/" + ro.get()));
    }

}

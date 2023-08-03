package nowebsite.maker.gravityplan.datagen;

import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import nowebsite.maker.gravityplan.GravityPlan;

public class ModBlockStateProvider extends BlockStateProvider {
    public final ExistingFileHelper HELPER;

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper helper) {
        super(output, GravityPlan.MOD_ID, helper);
        this.HELPER = helper;
    }

    protected void registerStatesAndModels() {
        /*horizontalBlock(ro.get(), models().singleTexture(
                    BuiltInRegistries.BLOCK.getKey(ro.get()).toString(),
                    modLoc("block/" + modelCap), "particle",
                    mcLoc("block/" + FoldingRegistration.PROPERTY_KINDS[count])
                    ));*/
    }
}

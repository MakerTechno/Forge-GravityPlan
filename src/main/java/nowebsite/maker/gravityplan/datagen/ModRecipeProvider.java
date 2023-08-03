package nowebsite.maker.gravityplan.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput output) {
        super(output);
    }

    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        /*ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChairBlockRegistration.OAK_CHAIRS.get(), 2)
                .define('O', Items.OAK_SLAB)
                .define('S', Items.STICK)
                .pattern("  O")
                .pattern("SOS")
                .pattern("S S")
                .unlockedBy("has_slab", has(Items.OAK_SLAB))
                .save(consumer);*/
    }
}

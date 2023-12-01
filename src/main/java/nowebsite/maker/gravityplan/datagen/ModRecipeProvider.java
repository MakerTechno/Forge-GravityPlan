package nowebsite.maker.gravityplan.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import nowebsite.maker.gravityplan.registry.ItemRegistration;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput output) {
        super(output);
    }

    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        /*ShapelessRecipeBuilder.shapeless(RecipeCategory.COMBAT, ItemRegistration.FORCE_FORWARD.get(),1)
                .requires(ItemRegistration.FORCE_FORWARD.get())
                .requires(ItemRegistration.FORCE_FORWARD.get())
                .unlockedBy("has_power", has())
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ItemRegistration.FORCE_UP.get())
                .define('U')*/
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.TNT), RecipeCategory.MISC, ItemRegistration.SUPER_TNT.get(), 0.1f, 50).unlockedBy("has_tnt", has(Items.TNT)).save(consumer);
        //SimpleCookingRecipeBuilder.blasting(Ingredient.of(Items.TNT), RecipeCategory.MISC, Items.TNT, 0.1f, 1).save(consumer);
        //SimpleCookingRecipeBuilder.smoking(Ingredient.of(Items.TNT), RecipeCategory.MISC, Items.TNT, 0.1f, 1).save(consumer);
    }
}

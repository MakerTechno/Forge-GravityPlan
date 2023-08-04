/*
package nowebsite.maker.gravityplan.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import nowebsite.maker.gravityplan.GravityPlan;
import nowebsite.maker.gravityplan.registry.ItemRegistration;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture, CompletableFuture<TagLookup<Block>> lookupCompletableFuture) {
        super(output, completableFuture, lookupCompletableFuture);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
         ItemTags.create(new ResourceLocation(GravityPlan.MOD_ID, "force");
        tag())
                .add(ItemRegistration.FORCE_FORWARD.get())
                .add(ItemRegistration.FORCE_BACK.get())
                .add(ItemRegistration.FORCE_UP.get())
                .add(ItemRegistration.FORCE_DOWN.get())
                .add(ItemRegistration.FORCE_LEFT.get())
                .add(ItemRegistration.FORCE_RIGHT.get());
    }
}
*/

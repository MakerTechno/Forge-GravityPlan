package nowebsite.maker.gravityplan.datagen;

import java.util.concurrent.CompletableFuture;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import org.jetbrains.annotations.NotNull;

public class ModDataGenerators {
    public static void gatherData(@NotNull GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper helper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        CompletableFuture<TagsProvider.TagLookup<Block>> lookupCompletableFuture = event.getLookupProvider().newIncompleteFuture();
        generator.addProvider(true, new ModEnglishLanguageProvider(packOutput, "en_us"));
        generator.addProvider(true, new ModChineseLanguageProvider(packOutput, "zh_cn"));
        generator.addProvider(event.includeClient(), new ModBlockStateProvider(packOutput, helper));
        generator.addProvider(event.includeClient(), new ModItemModelProvider(packOutput, helper));
        generator.addProvider(event.includeServer(), new ModLootTableProvider(packOutput));
        generator.addProvider(event.includeServer(), new ModRecipeProvider(packOutput));
        generator.addProvider(event.includeServer(), new ModBlockTagsProvider(packOutput, lookupProvider, helper));
        //generator.addProvider(event.includeServer(), new ModItemTagsProvider(packOutput, lookupProvider, lookupCompletableFuture));
    }
}

package nowebsite.maker.gravityplan.datagen;

import com.google.common.collect.Iterables;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.registries.RegistryObject;
import nowebsite.maker.gravityplan.registry.BlockRegistration;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ModLootTableProvider extends LootTableProvider {
    static Set<ResourceLocation> resourceLocations = new HashSet<>();
    static {
            //resourceLocations.add(ro.getId());
    }

    public ModLootTableProvider(PackOutput output) {
        super(output, resourceLocations, List.of(new SubProviderEntry(ModCustomBlockLootProvider::new, LootContextParamSets.BLOCK)));
    }

    protected void validate(@NotNull Map<ResourceLocation, LootTable> map, @NotNull ValidationContext validationcontext) {
        map.forEach((key, value) -> LootTables.validate(validationcontext, key, value));
    }
}

class ModCustomBlockLootProvider extends BlockLootSubProvider {
    public ModCustomBlockLootProvider() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    protected void generate() {
        //dropSelf(ro.get());
    }

    protected @NotNull Iterable<Block> getKnownBlocks() {
        return Iterables.transform(BlockRegistration.BLOCKS.getEntries(), RegistryObject::get);
    }

}

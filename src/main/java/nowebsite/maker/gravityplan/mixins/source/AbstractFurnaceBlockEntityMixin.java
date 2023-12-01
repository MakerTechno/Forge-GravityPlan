package nowebsite.maker.gravityplan.mixins.source;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FurnaceBlock;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.MinecraftForge;
import nowebsite.maker.gravityplan.util.DelayedExecution;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static nowebsite.maker.gravityplan.setup.ModSetup.HAS_EXPLODED_TAG;
import static nowebsite.maker.gravityplan.setup.ModSetup.SHOULD_EXPLODE_TAG;

@Mixin(AbstractFurnaceBlockEntity.class)
public abstract class AbstractFurnaceBlockEntityMixin {
    @Inject(method = {"serverTick"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/entity/AbstractFurnaceBlockEntity;setRecipeUsed(Lnet/minecraft/world/item/crafting/Recipe;)V", shift = At.Shift.BEFORE)} )
    private static void serverTick(@NotNull Level level, BlockPos pos, BlockState state, @NotNull AbstractFurnaceBlockEntity entity, CallbackInfo ci){
        if (!level.isClientSide) {
            if (entity.getItem(0).is(Items.TNT)) {
                new DelayedExecution(
                        MinecraftForge.EVENT_BUS,
                        () -> level.explode(null, pos.getX(), pos.getY(), pos.getZ(), 2f, true, Level.ExplosionInteraction.TNT),
                        2
                );
            }
        }
    }
}

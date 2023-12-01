package nowebsite.maker.gravityplan.items;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class ForceItem extends Item {
    public ForceItem(Properties properties) {
        super(properties.stacksTo(16));
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);
        if (itemStack.is(this)) {
            Vec3 a = player.getViewVector(1.0F);
            if (!level.isClientSide) {
                player.addDeltaMovement(a.normalize().scale(2));
                player.hurtMarked = true;
                itemStack.shrink(1);
            }
            return InteractionResultHolder.success(this.getDefaultInstance());
        }
        return InteractionResultHolder.fail(this.getDefaultInstance());
    }

    @Override
    public void inventoryTick(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull Entity entity, int i, boolean b) {
        super.inventoryTick(itemStack, level, entity, i, b);
    }

}

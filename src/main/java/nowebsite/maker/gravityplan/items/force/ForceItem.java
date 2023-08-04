package nowebsite.maker.gravityplan.items.force;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import nowebsite.maker.gravityplan.GravityPlan;
import org.jetbrains.annotations.NotNull;

public abstract class ForceItem extends Item {
    public static final String NBT_SOURCE = "ForceScale";
    public ForceItem() {
        super(new Properties().stacksTo(16));
    }

    public void extraEvent(Level level, Player player, InteractionHand interactionHand){}

    public abstract IResultDirection getResult();

    @Override
    public @NotNull Component getDescription() {
        return Component.translatable("description.gravityplan.first").append(getResult().getDescription()).append("\n")
                .append(Component.translatable("description.gravityplan.force").append(":").append(((Integer)getCompByFlush()).toString()));
    }

    public abstract int getCompByFlush();

    public abstract void flushComp(int i);

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);
        if (itemStack.is(this)) {
            int sub = getCompoundTagRel(itemStack);
            flushComp(sub);
            if (!level.isClientSide) {
                player.addDeltaMovement(player.getEyePosition().normalize().multiply(getResult().getDirect()).scale(sub));
                extraEvent(level, player, interactionHand);
            }
            itemStack.shrink(1);
            return InteractionResultHolder.success(this.getDefaultInstance());
        }
        return InteractionResultHolder.fail(this.getDefaultInstance());
    }

    @Override
    public void inventoryTick(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull Entity entity, int i, boolean b) {
        super.inventoryTick(itemStack, level, entity, i, b);
        flushComp(getCompoundTagRel(itemStack));
    }

    public int getCompoundTagRel(ItemStack itemStack){
        CompoundTag compoundTag = itemStack.getTag();
        assert compoundTag != null;
        int sub;
        try {sub = compoundTag.getInt(NBT_SOURCE);}
        catch (ClassCastException classcastexception) {
            sub = 0;
            GravityPlan.LOGGER.error(classcastexception.getMessage());
        }
        return sub;
    }

}

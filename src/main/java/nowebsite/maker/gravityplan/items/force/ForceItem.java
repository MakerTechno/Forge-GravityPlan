package nowebsite.maker.gravityplan.items.force;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
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
    protected @NotNull String getOrCreateDescriptionId() {
        return "An Force that takes you "+ getResult().toString();
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);
        if (itemStack.is(this)) {
            CompoundTag compoundTag = itemStack.getTag();
            assert compoundTag != null;
            int sub;
            try {sub = compoundTag.getInt(NBT_SOURCE);}
            catch (ClassCastException classcastexception) {
                sub = 0;
                GravityPlan.LOGGER.error(classcastexception.getMessage());
            }
            if (!level.isClientSide) {
                player.addDeltaMovement(player.getEyePosition().normalize().multiply(getResult().getDirect()).scale(sub));
                extraEvent(level, player, interactionHand);
            }
            itemStack.shrink(1);
            return InteractionResultHolder.success(this.getDefaultInstance());
        }
        return InteractionResultHolder.fail(this.getDefaultInstance());
    }

}

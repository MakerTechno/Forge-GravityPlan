package nowebsite.maker.gravityplan.items;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class SimpleIconIntro extends Item {
    public boolean isUseOnce = false;
    public SimpleIconIntro(Properties properties) {
        super(properties.stacksTo(1));
    }

    @Override
    public boolean isFoil(@NotNull ItemStack itemStack) {
        return true;
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand interactionHand) {
        if (!level.isClientSide) {
            if (!isUseOnce) {
                player.sendSystemMessage(Component.translatable("msg.gravityplan.introduce"));
                isUseOnce = true;
            } else {
                ItemStack stack = player.getItemInHand(interactionHand);
                stack.shrink(1);
                player.displayClientMessage(Component.translatable("gravityplan.msg.bye").withStyle(ChatFormatting.RED), true);
                level.explode(player, player.getX(), player.getY(), player.getZ(), 4.5f, Level.ExplosionInteraction.MOB);
            }
        }
        return super.use(level, player, interactionHand);
    }

}

package nowebsite.maker.gravityplan.items;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class SimpleIconIntro extends Item {
    public SimpleIconIntro() {
        super(new Properties().stacksTo(1));
    }

    @Override
    public boolean isFoil(ItemStack itemStack) {
        return true;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        player.sendSystemMessage(Component.translatable("msg.gravityplan.introduce"));
        return super.use(level, player, interactionHand);
    }

}

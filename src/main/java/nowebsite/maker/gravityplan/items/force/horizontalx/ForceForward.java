package nowebsite.maker.gravityplan.items.force.horizontalx;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import nowebsite.maker.gravityplan.items.force.ForceItem;
import nowebsite.maker.gravityplan.items.force.IResultDirection;

public class ForceForward extends ForceItem {
    @Override
    public IResultDirection getResult() {
        return IResultDirection.FORWARD;
    }

    @Override
    public void extraEvent(Level level, Player player, InteractionHand interactionHand) {
        super.extraEvent(level, player, interactionHand);

    }
}
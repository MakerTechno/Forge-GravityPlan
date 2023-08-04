package nowebsite.maker.gravityplan.items.force.verticle;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import nowebsite.maker.gravityplan.items.force.ForceItem;
import nowebsite.maker.gravityplan.items.force.IResultDirection;

public class ForceDown extends ForceItem {
    @Override
    public IResultDirection getResult() {
        return IResultDirection.DOWN;
    }



    private int subSource;

    @Override
    public int getCompByFlush() {
        return subSource;
    }

    @Override
    public void flushComp(int i) {
        subSource = i;
    }

    @Override
    public void extraEvent(Level level, Player player, InteractionHand interactionHand) {
        player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2, 100, false, false, false), player);
        Vec3 vec3 = player.position();
        float sub = (float) getCompoundTagRel(player.getItemInHand(interactionHand)) /10;
        Explosion explosion = level.explode(player, vec3.x, vec3.y, vec3.z, sub, Level.ExplosionInteraction.MOB);
        explosion.interactsWithBlocks();
    }
}

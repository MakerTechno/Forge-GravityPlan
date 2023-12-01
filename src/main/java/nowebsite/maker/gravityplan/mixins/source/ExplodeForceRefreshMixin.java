package nowebsite.maker.gravityplan.mixins.source;

import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import nowebsite.maker.gravityplan.eventhandler.RefreshAct;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(Explosion.class)
public abstract class ExplodeForceRefreshMixin {

    @Shadow @Final private float radius;

    @Shadow @Final private double x;

    @Shadow @Final private double y;

    @Shadow @Final private double z;

    @Shadow @Final private Level level;

    @Inject(method = {"finalizeExplosion"}, at = @At(value = "TAIL", shift = At.Shift.BEFORE))
    private void finalizeExplosion(boolean b, CallbackInfo ci){
        if(radius > 1.5f) {
            RefreshAct.requestBlockUpdates(level, new Vec3(x, y, z));
        }
    }
}

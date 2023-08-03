package nowebsite.maker.gravityplan.eventhandler;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import nowebsite.maker.gravityplan.GravityPlan;

@Mod.EventBusSubscriber(modid = GravityPlan.MOD_ID)
public class PlayerEventRegistration {
    public static void playerHurtEvent(LivingHurtEvent event){
        Entity entity = event.getEntity();
        if (entity instanceof Player){
            if (event.getSource().getEntity() instanceof Player){
                Vec3 target =  entity.position();
                Vec3 source = event.getSource().getEntity().position();
                double xL = Math.abs(target.x() - source.x);
                double yL = Math.abs(target.y() - source.y);
                double zL = Math.abs(target.z() - source.z);
                ItemStack stack;

                if (target.x()>source.x() && yL<xL && zL<xL){

                }
            }
        }
    }
}

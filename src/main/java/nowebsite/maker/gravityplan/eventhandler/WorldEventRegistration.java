package nowebsite.maker.gravityplan.eventhandler;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import nowebsite.maker.gravityplan.GravityPlan;
import nowebsite.maker.gravityplan.registry.ItemRegistration;
import org.jetbrains.annotations.NotNull;

@Mod.EventBusSubscriber(modid = GravityPlan.MOD_ID)
public class WorldEventRegistration {
    @SubscribeEvent
    public static void playerHurtEvent(@NotNull LivingHurtEvent event){
        if (event.getSource().getDirectEntity() instanceof FallingBlockEntity entity){
            if (event.getSource().getEntity() instanceof FallingBlockEntity){
                if(entity.fallDistance > 4){
                    entity.getLevel().explode(
                            entity, null,
                            new ExplosionDamageCalculator(),
                            entity.getX(), entity.getY(), entity.getZ(),
                            (float)((entity.getStartPos().getY() - entity.getY())/20 + 1.0f),
                            false,
                            Level.ExplosionInteraction.BLOCK
                    );
                }
            }
        }
    }

    @SubscribeEvent
    public static void playerFallDamageEvent(@NotNull LivingFallEvent event){
        float distance = event.getDistance();
        if (distance > 8.0f){
            Entity entity = event.getEntity();
            entity.getLevel().explode(
                    null,
                    entity.getX(), entity.getY(), entity.getZ(),
                    distance /5 + 2.0f,
                    Level.ExplosionInteraction.MOB
            );
        }
    }

    @SubscribeEvent
    public static void playerPunchEmptyEvent(PlayerInteractEvent.@NotNull LeftClickEmpty event){
        Vec3 target = event.getEntity().position();
        ItemStack stack = ItemRegistration.FORCE.get().getDefaultInstance();
        ItemEntity itemEntity = new ItemEntity(event.getEntity().getLevel(), target.x(), target.y(), target.z(), stack);
        Vec3 a = event.getEntity().getViewVector(1.0F);
        itemEntity.addDeltaMovement(a.normalize().scale(0.6));
        event.getLevel().addFreshEntity(itemEntity);
    }

    @SubscribeEvent
    public static void onSmelting(PlayerEvent.@NotNull ItemSmeltedEvent event){
        ItemStack from = event.getSmelting();
        if (from.is(ItemRegistration.SUPER_TNT.get())){
            Vec3 vec3 = event.getEntity().position();
            if (!event.getEntity().getLevel().isClientSide) {
                event.getEntity().getLevel().explode(null, vec3.x, vec3.y, vec3.z, 3.0f, Level.ExplosionInteraction.BLOCK);
            }
        }
    }
}

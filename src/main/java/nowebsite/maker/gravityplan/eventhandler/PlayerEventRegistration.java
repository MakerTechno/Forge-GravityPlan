package nowebsite.maker.gravityplan.eventhandler;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import nowebsite.maker.gravityplan.GravityPlan;
import nowebsite.maker.gravityplan.items.force.ForceItem;
import nowebsite.maker.gravityplan.registry.ItemRegistration;

@Mod.EventBusSubscriber(modid = GravityPlan.MOD_ID)
public class PlayerEventRegistration {
    @SubscribeEvent
    public static void playerHurtEvent(LivingHurtEvent event){
        Entity entity = event.getEntity();
        if (entity instanceof Player){
            if (event.getSource().getEntity() instanceof Player){
                Vec3 target =  entity.position();
                /*Vec3 source = event.getSource().getEntity().position();
                double xL = Math.abs(target.x() - source.x);
                double yL = Math.abs(target.y() - source.y);
                double zL = Math.abs(target.z() - source.z);*/
                ItemStack stack = switch (event.getEntity().getRandom().nextInt(6)+1){
                    case 2 -> ItemRegistration.FORCE_BACK.get().getDefaultInstance();
                    case 3 -> ItemRegistration.FORCE_UP.get().getDefaultInstance();
                    case 4 -> ItemRegistration.FORCE_DOWN.get().getDefaultInstance();
                    case 5 -> ItemRegistration.FORCE_LEFT.get().getDefaultInstance();
                    case 6 -> ItemRegistration.FORCE_RIGHT.get().getDefaultInstance();
                    default -> ItemRegistration.FORCE_FORWARD.get().getDefaultInstance();
                };
                ItemEntity itemEntity = new ItemEntity(event.getEntity().getLevel(), target.x(), target.y(), target.z(), stack);
                /*if (yL<xL && zL<xL) {
                    if (target.x() > source.x()) {
                        itemEntity = new ItemEntity(event.getEntity().getLevel(), target.x(), target.y(), target.z(), ItemRegistration.FORCE_FORWARD.get().getDefaultInstance());
                    } else if (target.x < source.x){
                        itemEntity = new ItemEntity(event.getEntity().getLevel(), target.x(), target.y(), target.z(), ItemRegistration.FORCE_BACK.get().getDefaultInstance());
                    }
                }*/
                event.getEntity().getLevel().addFreshEntity(itemEntity);
            }
        }
    }

    @SubscribeEvent
    public static void playerPunchEmptyEvent(PlayerInteractEvent.RightClickEmpty event){
        Vec3 target =  event.getEntity().position();
        ItemStack stack = switch (event.getEntity().getRandom().nextInt(6)+1){
            case 2 -> ItemRegistration.FORCE_BACK.get().getDefaultInstance();
            case 3 -> ItemRegistration.FORCE_UP.get().getDefaultInstance();
            case 4 -> ItemRegistration.FORCE_DOWN.get().getDefaultInstance();
            case 5 -> ItemRegistration.FORCE_LEFT.get().getDefaultInstance();
            case 6 -> ItemRegistration.FORCE_RIGHT.get().getDefaultInstance();
            default -> ItemRegistration.FORCE_FORWARD.get().getDefaultInstance();
        };
        ItemEntity itemEntity = new ItemEntity(event.getEntity().getLevel(), target.x(), target.y(), target.z(), stack);
        event.getEntity().getLevel().addFreshEntity(itemEntity);
    }
    @SubscribeEvent
    public static void onCrafting(PlayerEvent.ItemCraftedEvent event){
        ItemStack result = event.getCrafting();
        if (result.is(ItemRegistration.FORCE_FORWARD.get())){
            int nbtSub = 0;
            for (int i = 0; i<event.getInventory().getContainerSize(); i++){
                ItemStack stack = event.getInventory().getItem(i);
                if (!stack.isEmpty()&&stack.is(ItemRegistration.FORCE_FORWARD.get())) {
                    CompoundTag compoundTag = stack.getTag();
                    assert compoundTag != null;
                    try {
                        nbtSub += compoundTag.getInt(ForceItem.NBT_SOURCE);
                    } catch (ClassCastException classcastexception) {
                        GravityPlan.LOGGER.error(classcastexception.getMessage());
                    }
                }
            }
            result.serializeNBT().putInt(ForceItem.NBT_SOURCE,nbtSub);
        }
    }

    @SubscribeEvent
    public static void onSmelting(PlayerEvent.ItemSmeltedEvent event){
        ItemStack from = event.getSmelting();
        if (from.is(Items.TNT)){
            Vec3 vec3 = event.getEntity().position();
            if (!event.getEntity().getLevel().isClientSide) {
                event.getEntity().getLevel().explode(event.getEntity(), vec3.x, vec3.y, vec3.z, 2.0f, Level.ExplosionInteraction.MOB);
            }
        }
    }

}

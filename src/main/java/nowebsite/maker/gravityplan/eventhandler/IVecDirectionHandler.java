package nowebsite.maker.gravityplan.eventhandler;

import net.minecraft.world.item.Item;
import nowebsite.maker.gravityplan.registry.ItemRegistration;

public enum IVecDirectionHandler {
    FORWARD,BACK,UP,DOWN,LEFT,RIGHT;

    public Item getDirectItem(){
        return switch (this){
            case FORWARD -> ItemRegistration.FORCE_FORWARD.get();
            case BACK -> ItemRegistration.FORCE_BACK.get();
            case UP -> ItemRegistration.FORCE_UP.get();
            case DOWN -> ItemRegistration.FORCE_DOWN.get();
            case LEFT -> ItemRegistration.FORCE_LEFT.get();
            case RIGHT -> ItemRegistration.FORCE_RIGHT.get();
        };
    }
}

package nowebsite.maker.gravityplan.items.force;

import net.minecraft.network.chat.Component;
import net.minecraft.world.phys.Vec3;

public enum IResultDirection {
    FORWARD,BACK,UP,DOWN,LEFT,RIGHT;

    public Vec3 getDirect(){
        return switch (this){
            case FORWARD -> new Vec3(1,0,0);
            case BACK -> new Vec3(-1,0,0);
            case UP -> new Vec3(0,1,0);
            case DOWN -> new Vec3(0,-1,0);
            case LEFT -> new Vec3(0,0,-1);
            case RIGHT -> new Vec3(0,0,1);
        };
    }

    public Component getDescription(){
        return switch (this){
            case FORWARD -> Component.translatable("description.gravityplan.forward");
            case BACK -> Component.translatable("description.gravityplan.back");
            case UP -> Component.translatable("description.gravityplan.up");
            case DOWN -> Component.translatable("description.gravityplan.down");
            case LEFT -> Component.translatable("description.gravityplan.left");
            case RIGHT -> Component.translatable("description.gravityplan.right");
        };
    }
}

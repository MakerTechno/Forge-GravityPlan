package nowebsite.maker.gravityplan.items.force.verticle;

import nowebsite.maker.gravityplan.items.force.ForceItem;
import nowebsite.maker.gravityplan.items.force.IResultDirection;

public class ForceDown extends ForceItem {
    @Override
    public IResultDirection getResult() {
        return IResultDirection.DOWN;
    }

}

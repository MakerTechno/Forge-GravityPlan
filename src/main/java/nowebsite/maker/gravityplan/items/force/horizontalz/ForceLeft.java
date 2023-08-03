package nowebsite.maker.gravityplan.items.force.horizontalz;

import nowebsite.maker.gravityplan.items.force.ForceItem;
import nowebsite.maker.gravityplan.items.force.IResultDirection;

public class ForceLeft extends ForceItem {
    @Override
    public IResultDirection getResult() {
        return IResultDirection.LEFT;
    }
}

package nowebsite.maker.gravityplan.items.force.horizontalx;

import nowebsite.maker.gravityplan.items.force.ForceItem;
import nowebsite.maker.gravityplan.items.force.IResultDirection;

public class ForceBack extends ForceItem {
    @Override
    public IResultDirection getResult() {
        return IResultDirection.BACK;
    }
}

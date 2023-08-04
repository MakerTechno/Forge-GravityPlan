package nowebsite.maker.gravityplan.items.force.horizontalx;

import nowebsite.maker.gravityplan.items.force.ForceItem;
import nowebsite.maker.gravityplan.items.force.IResultDirection;

public class ForceBack extends ForceItem {
    @Override
    public IResultDirection getResult() {
        return IResultDirection.BACK;
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
}

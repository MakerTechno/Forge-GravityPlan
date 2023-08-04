package nowebsite.maker.gravityplan.items.force.verticle;

import nowebsite.maker.gravityplan.items.force.ForceItem;
import nowebsite.maker.gravityplan.items.force.IResultDirection;

public class ForceUp extends ForceItem {
    @Override
    public IResultDirection getResult() {
        return IResultDirection.UP;
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

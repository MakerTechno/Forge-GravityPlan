package nowebsite.maker.gravityplan.items.force.horizontalz;

import nowebsite.maker.gravityplan.items.force.ForceItem;
import nowebsite.maker.gravityplan.items.force.IResultDirection;

public class ForceRight extends ForceItem {
    @Override
    public IResultDirection getResult() {
        return IResultDirection.RIGHT;
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

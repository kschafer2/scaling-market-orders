package lists;

import buildable.Buildable;

import java.util.ArrayList;
import java.util.Collection;

public class MarketOrderArrayList extends ArrayList implements Buildable, MutableMarketOrders, UniqueFirstMarketOrder {

    public MarketOrderArrayList(int initialCapacity) {
        super(initialCapacity);
    }

    public MarketOrderArrayList() {
    }

    public MarketOrderArrayList(Collection c) {
        super(c);
    }

    @Override
    public void build() {

    }

    @Override
    public void addMarketOrder(int index) {

    }

    @Override
    public void addFirstMarketOrder() {

    }
}

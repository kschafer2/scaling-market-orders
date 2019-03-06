package trades;

import orders.MarketOrder;

import java.util.List;

public abstract class AbstractTrade<T> {

    List<MarketOrder> marketOrderList;
    T calculations;

    public List<MarketOrder> getMarketOrderList() {
        return marketOrderList;
    }
}

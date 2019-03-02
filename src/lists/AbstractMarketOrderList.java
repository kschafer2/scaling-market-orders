package lists;

import calculations.AbstractTradeCalculations;
import data.AbstractTradeData;
import orders.MarketOrder;

import java.util.List;

public abstract class AbstractMarketOrderList implements MarketOrderList {

    List<MarketOrder> marketOrderList;
    AbstractTradeData data;
    AbstractTradeCalculations calculations;

    public AbstractMarketOrderList(AbstractTradeData data) {
        this.data = data;
    }
}
